package jdbc.exceptions.sql;

import java.sql.SQLException;

public class ConnectionCloseException extends SQLException {
    public ConnectionCloseException(String reason) {
        super(reason);
    }

    public ConnectionCloseException() {
        super();
    }

    public ConnectionCloseException(Throwable cause) {
        super(cause);
    }

    public ConnectionCloseException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
