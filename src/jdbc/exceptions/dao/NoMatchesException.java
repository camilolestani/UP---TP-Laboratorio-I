package jdbc.exceptions.dao;

public class NoMatchesException extends DAOException{
    public NoMatchesException() {
        super();
    }

    public NoMatchesException(String message) {
        super(message);
    }

    public NoMatchesException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMatchesException(Throwable cause) {
        super(cause);
    }
}
