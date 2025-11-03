package jdbc.exceptions.sql;

import java.sql.SQLException;

// Transaction-related
public class TransactionException extends SQLException {
    public TransactionException(String reason) {
        super(reason);
    }

    public TransactionException() {
        super();
    }

    public TransactionException(Throwable cause) {
        super(cause);
    }

    public TransactionException(String reason, Throwable cause) {
        super(reason, cause);
    }
}
