package jdbc.services;

import jdbc.dao.UsuarioDAO;
import jdbc.dao.impl.UsuarioDAOH2Impl;
import jdbc.entidades.Usuario;
import jdbc.exceptions.dao.*;
import jdbc.exceptions.service.ServiceException;
import jdbc.exceptions.sql.ConnectionException;

import java.util.List;

public class UsuarioService {
    private UsuarioDAO dao = new UsuarioDAOH2Impl();

    public boolean agregarUsuario(Usuario u) throws ServiceException {
        try {
            dao.crearUsuario(u);
            return true;
        } catch (ObjetoDuplicadoException e) {
            throw new ServiceException("El usuario ya existe.");
        }
        catch (ReferenciaErroneaException e) {
            throw new ServiceException("No se puede crear el usuario: Alguna de las entidades referenciadas no existe.");
        }
        catch (ViolacionRestriccionException e) {
            throw new ServiceException("Un error inesperado sucedió al tratar de crear el usario: Alguno de los parametros no cumple con las restricciones del campo.");
        }
        catch (SinConexionException e) {
            throw new ServiceException("Hubo un error al conectarse con la base de datos.");
        }
        catch (DAOException e) {
            throw new ServiceException("Un error inesperado sucedió al tratar de crear el usario.");
        }
    }

    public boolean editarUsuario(Usuario u) throws ServiceException {
        try {
            dao.actualizarUsuario(u);
            return true;
        } catch (NoMatchesException e) {
            throw new ServiceException("No se encontró el usuario que se deseaba editar.");
        }
        catch (ReferenciaErroneaException e) {
            throw new ServiceException("No se puede editar el usuario: Alguna de las entidades referenciadas no existe.");
        }
        catch (ViolacionRestriccionException e) {
            throw new ServiceException("Un error inesperado sucedió al tratar de editar el usario: Alguno de los parametros no cumple con las restricciones del campo.");
        }
        catch (SinConexionException e) {
            throw new ServiceException("Hubo un error al conectarse con la base de datos.");
        }
        catch (DAOException e) {
            throw new ServiceException("Un error inesperado sucedió al tratar de editar el usario.");
        }
    }

    public boolean borrarUsuario(Usuario u) throws ServiceException {
        try {
            dao.borrarUsuario(u.getDni());
            return true;
        } catch (NoMatchesException e) {
            throw new ServiceException("No se encontró el usuario que se deseaba borrar.");
        }
        catch (ReferenciaErroneaException e) {
            throw new ServiceException("No se puede borrar el usuario ya que tiene entidades asociadas.");
        }
        catch (ViolacionRestriccionException e) {
            throw new ServiceException("Un error inesperado sucedió al tratar de borrar el usario: El parametro de busqueda no cumple con las restricciones del campo.");
        }
        catch (SinConexionException e) {
            throw new ServiceException("Hubo un error al conectarse con la base de datos.");
        }
        catch (DAOException e) {
            throw new ServiceException("Un error inesperado sucedió al tratar de borrar el usario.");
        }
    }

    public Usuario obtenerUsuario(Integer dni) throws ServiceException {
        try {
            return dao.muestraUsuario(dni);
        } catch (NoMatchesException e) {
            throw new ServiceException("No se encontró el usuario buscado.");
        }
        catch (ViolacionRestriccionException e) {
            throw new ServiceException("Hubo un error inesperado al tratar de obtener el usuario: el parametro de busqueda no cumple con las restricciones del campo.");
        }
        catch (SinConexionException e) {
            throw new ServiceException("Hubo un error al conectarse con la base de datos.");
        }
        catch (DAOException e) {
            throw new ServiceException("Hubo un error inesperado al tratar de obtener el usuario.");
        }
    }

    public List<Usuario> obtenerTodosLosUsuarios() throws ServiceException {
        try {
            return dao.listaTodosLosUsuarios();
        }
        catch (SinConexionException e) {
            throw new ServiceException("Hubo un error al conectarse con la base de datos.");
        }
        catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException("Hubo un error para consultar la lista de usuarios.");
        }
    }
}
