package jdbc.exceptions.dao;

public class SinConexionException extends DAOException{
    public SinConexionException() {
        super();
    }

    public SinConexionException(String message) {
        super(message);
    }

    public SinConexionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SinConexionException(Throwable cause) {
        super(cause);
    }
}
