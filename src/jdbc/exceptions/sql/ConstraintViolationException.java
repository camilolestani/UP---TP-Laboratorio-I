package jdbc.exceptions.sql;

import java.sql.SQLException;

public class ConstraintViolationException extends SQLException {
    public ConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConstraintViolationException(String reason) {
        super(reason);
    }

    public ConstraintViolationException() {
        super();
    }

    public ConstraintViolationException(Throwable cause) {
        super(cause);
    }
}
