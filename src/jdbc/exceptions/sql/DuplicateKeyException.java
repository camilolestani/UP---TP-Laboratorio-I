package jdbc.exceptions.sql;

import java.sql.SQLException;

// Constraint violations (important for CRUD!)
public class DuplicateKeyException extends SQLException {
    public DuplicateKeyException(String message) {
        super(message);
    }

    public DuplicateKeyException() {
        super();
    }

    public DuplicateKeyException(Throwable cause) {
        super(cause);
    }

    public DuplicateKeyException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
