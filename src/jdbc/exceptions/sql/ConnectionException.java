package jdbc.exceptions.sql;

import java.sql.SQLException;

public class ConnectionException extends SQLException {
    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionException(String reason) {
        super(reason);
    }

    public ConnectionException() {
        super();
    }

    public ConnectionException(Throwable cause) {
        super(cause);
    }
}
