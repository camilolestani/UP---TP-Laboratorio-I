package jdbc.util;

import jdbc.exceptions.sql.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryRunner {

    public static void runUpdate(String sql, Object... params) throws SQLException {
        Connection c = null;
        try {
            c = DBManager.connect();
            PreparedStatement ps = c.prepareStatement(sql);

            // Set parameters
            setParameters(ps, params);

            ps.executeUpdate();
            c.commit();
        } catch (SQLException e) {
            handleRollback(c, e);
            throw mapSQLException(e);
        } finally {
            closeConnection(c);
        }
     }


    public static <T> List<T> runSelection(String sql, RowMapper<T> mapper, Object... params) throws SQLException {
        Connection c = null;
        List<T> results = new ArrayList<>();
        try {
            c = DBManager.connect();
            PreparedStatement ps = c.prepareStatement(sql);

            // Set parameters
            setParameters(ps, params);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                results.add(mapper.map(rs));
            }
            return results;

        } catch (SQLException e) {
            throw mapSQLException(e);
        } finally {
            if (c!= null && !c.isClosed()) {
                closeConnection(c);
            }
        }
    }

    private static void setParameters(PreparedStatement ps, Object... params) throws SQLException {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
        }
    }

    private static void handleRollback(Connection c, SQLException originalException)
            throws TransactionException {
        if (c != null) {
            try {
                c.rollback();
            } catch (SQLException rollbackException) {
                // Log both exceptions
                System.err.println("Original error:");
                originalException.printStackTrace();
                System.err.println("Rollback error:");
                rollbackException.printStackTrace();

                throw new TransactionException(
                        "Failed to rollback transaction after error",
                        rollbackException
                );
            }
        }
    }

    private static void closeConnection(Connection c) throws ConnectionCloseException {
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                throw new ConnectionCloseException(e);
            }
        }
    }

    private static SQLException mapSQLException(SQLException e) {
        int errorCode = e.getErrorCode();
        String sqlState = e.getSQLState();

        if (errorCode == 23505 || sqlState.startsWith("23")) {
            if (sqlState.equals("23505")) {
                return new DuplicateKeyException(
                        "Duplicate key violation: " + e.getMessage()
                );
            }
            if (sqlState.equals("23503")) {
                return new ForeignKeyViolationException(
                        "Foreign key constraint violation: " + e.getMessage()
                );
            }
            return new ConstraintViolationException(
                    "Constraint violation: " + e.getMessage(),
                    e
            );
        }

        // Default to generic query execution exception
        return new QueryExecutionException(e.getMessage(), e);
    }
}

