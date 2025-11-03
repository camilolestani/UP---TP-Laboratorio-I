package jdbc.exceptions.sql;

import java.sql.SQLException;

public class ForeignKeyViolationException extends SQLException {
    public ForeignKeyViolationException(String message) {
        super(message);
    }

    public ForeignKeyViolationException() {
        super();
    }

    public ForeignKeyViolationException(Throwable cause) {
        super(cause);
    }

    public ForeignKeyViolationException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
