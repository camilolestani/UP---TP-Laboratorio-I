package jdbc.exceptions.sql;

import java.sql.SQLException;

public class QueryExecutionException extends SQLException {
    public QueryExecutionException(String reason) {
        super(reason);
    }

    public QueryExecutionException() {
        super();
    }

    public QueryExecutionException(Throwable cause) {
        super(cause);
    }

    public QueryExecutionException(String reason, Throwable cause) {
        super(reason, cause);
    }
}

