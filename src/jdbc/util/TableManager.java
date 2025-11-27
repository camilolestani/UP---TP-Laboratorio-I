package jdbc.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

    public void createUsuarioTable() {

        Connection c = null;
        try {
            c = DBManager.connect();
            String sql = "CREATE TABLE IF NOT EXISTS usuarios (dni INTEGER IDENTITY, nombre_completo VARCHAR(256), tipo_usuario VARCHAR(256), email VARCHAR(256), password VARCHAR(256))";

            Statement s = c.createStatement();
            s.execute(sql);
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if(c != null && !c.isClosed()) {

                c.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void dropUsuarioTable() {

        Connection c = DBManager.connect();

        String sql = "DROP TABLE usuarios";

        try {
            Statement s = c.createStatement();
            s.execute(sql);
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
