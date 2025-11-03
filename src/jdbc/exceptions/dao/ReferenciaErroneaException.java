package jdbc.exceptions.dao;

public class ReferenciaErroneaException extends DAOException {
    public ReferenciaErroneaException() {
        super();
    }

    public ReferenciaErroneaException(String message) {
        super(message);
    }

    public ReferenciaErroneaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReferenciaErroneaException(Throwable cause) {
        super(cause);
    }
}
