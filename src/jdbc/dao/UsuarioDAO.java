package jdbc.dao;

import jdbc.entidades.Usuario;
import jdbc.exceptions.dao.DAOException;

import java.util.List;

public interface UsuarioDAO {
    void crearUsuario(Usuario usuario) throws DAOException;

    void borrarUsuario(Integer dni) throws DAOException;

    void actualizarUsuario(Usuario unUsuario) throws DAOException;

    Usuario muestraUsuario(Integer dni) throws DAOException;

    List<Usuario> listaTodosLosUsuarios() throws DAOException;
}
