package jdbc.exceptions.dao;

public class ViolacionRestriccionException extends DAOException{
    public ViolacionRestriccionException() {
        super();
    }

    public ViolacionRestriccionException(String message) {
        super(message);
    }

    public ViolacionRestriccionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ViolacionRestriccionException(Throwable cause) {
        super(cause);
    }
}
