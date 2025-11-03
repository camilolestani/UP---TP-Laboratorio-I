package jdbc.exceptions.dao;

public class ObjetoDuplicadoException extends DAOException {
    public ObjetoDuplicadoException(String message) {
        super(message);
    }

    public ObjetoDuplicadoException() {
        super();
    }

    public ObjetoDuplicadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjetoDuplicadoException(Throwable cause) {
        super(cause);
    }
}
