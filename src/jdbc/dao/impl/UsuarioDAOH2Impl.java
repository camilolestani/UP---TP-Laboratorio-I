package jdbc.dao.impl;

import jdbc.dao.UsuarioDAO;
import jdbc.entidades.Usuario;
import jdbc.enums.TipoUsuario;
import jdbc.exceptions.dao.*;
import jdbc.exceptions.sql.ConnectionException;
import jdbc.exceptions.sql.ConstraintViolationException;
import jdbc.exceptions.sql.DuplicateKeyException;
import jdbc.exceptions.sql.ForeignKeyViolationException;
import jdbc.util.QueryRunner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOH2Impl implements UsuarioDAO {
    @Override
    public void crearUsuario(Usuario usuario) throws DAOException {
        Integer dni = usuario.getDni();
        String nombreCompleto = usuario.getNombreCompleto();
        String email = usuario.getEmail();
        String password = usuario.getPassword();
        String tipo = usuario.getTipo().toString();
        String sql = "INSERT INTO usuarios (dni, nombre_completo, email, password, tipo_usuario) VALUES (?,?,?,?,?)";
//        String sql = "INSERT INTO usuarios (dni, nombre_completo, email, password) VALUES ('" + dni + "', '" + nombreCompleto + "', '" + email + "', '" + password + "' )";
        try {
            QueryRunner.runUpdate(sql, dni, nombreCompleto, email, password, tipo);
        } catch (DuplicateKeyException e) {
            throw new ObjetoDuplicadoException(e);
        } catch (ForeignKeyViolationException e) {
            throw new ReferenciaErroneaException(e);
        } catch (ConstraintViolationException e) {
            throw new ViolacionRestriccionException(e);
        } catch (ConnectionException e) {
            throw new SinConexionException(e);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws DAOException {
        Integer dni = usuario.getDni();
        String nombreCompleto = usuario.getNombreCompleto();
        String email = usuario.getEmail();
        String password = usuario.getPassword();
        String tipo = usuario.getTipo().toString();
        String sql = "UPDATE usuarios SET nombre_completo = ?, email = ?, password = ?, tipo_usuario = ? WHERE dni=?";
//        String sql = "UPDATE usuarios SET nombre_completo = '" + nombreCompleto + "', email = '" + email + "', password = '" + password + "' WHERE dni='" + dni.toString()+ "'";
        try {
            QueryRunner.runUpdate(sql, nombreCompleto, email, password, tipo, dni);
        } catch (ForeignKeyViolationException e) {
            throw new ReferenciaErroneaException(e);
        } catch (ConstraintViolationException e) {
            throw new ViolacionRestriccionException(e);
        } catch (ConnectionException e) {
            throw new SinConexionException(e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        }
    }

    @Override
    public void borrarUsuario(Integer dni) throws DAOException {
        String sql = "DELETE FROM usuarios WHERE dni = ? ";
//        String sql = "DELETE FROM usuarios WHERE dni = '" + dni + "' ";
        try {
            QueryRunner.runUpdate(sql, dni);
        } catch (ForeignKeyViolationException e) {
            throw new ReferenciaErroneaException(e);
        } catch (ConstraintViolationException e) {
            throw new ViolacionRestriccionException(e);
        } catch (ConnectionException e) {
            throw new SinConexionException(e);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Usuario muestraUsuario(Integer d) throws DAOException {
        String sql = "SELECT * FROM usuarios WHERE dni = ?";
        try {
            List<Usuario> usuarios = QueryRunner.runSelection(sql, (rs) -> {
                int dni = rs.getInt("dni");
                String nombreCompleto = rs.getString("nombre_completo");
                String email = rs.getString("email");
                String password = rs.getString("password");
                TipoUsuario tipo = TipoUsuario.valueOf(rs.getString("tipo_usuario"));

                return new Usuario(dni, nombreCompleto, email, password, tipo);
            }, d);
            Usuario u = usuarios.getFirst();
            if(u != null) {
                return u;
            } else {
                throw new NoMatchesException("No se encontró el usuario buscado.");
            }
        } catch (ForeignKeyViolationException e) {
            throw new ReferenciaErroneaException(e);
        } catch (ConstraintViolationException e) {
            throw new ViolacionRestriccionException(e);
        } catch (ConnectionException e) {
            throw new SinConexionException(e);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public Usuario loginUsuario(Integer d, String p) throws DAOException {
        String sql = "SELECT * FROM usuarios WHERE dni = ? and password = ?";
        try {
            List<Usuario> usuarios = QueryRunner.runSelection(sql, (rs) -> {
                int dni = rs.getInt("dni");
                String nombreCompleto = rs.getString("nombre_completo");
                String email = rs.getString("email");
                String password = rs.getString("password");
                TipoUsuario tipo = TipoUsuario.valueOf(rs.getString("tipo_usuario"));

                return new Usuario(dni, nombreCompleto, email, password, tipo);
            }, d, p);
            if(usuarios.isEmpty()) {
                throw new NoMatchesException("No se encontró el usuario buscado.");
            }
            Usuario u = usuarios.getFirst();

            if(u != null) {
                return u;
            } else {
                throw new NoMatchesException("No se encontró el usuario buscado.");
            }
        } catch (ForeignKeyViolationException e) {
            throw new ReferenciaErroneaException(e);
        } catch (ConstraintViolationException e) {
            throw new ViolacionRestriccionException(e);
        } catch (ConnectionException e) {
            throw new SinConexionException(e);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Usuario> listaTodosLosUsuarios() throws DAOException {
        List<Usuario> ls = new ArrayList<>();
        String sql = "SELECT * FROM usuarios;";
        try {
            return QueryRunner.runSelection(sql, (rs) -> {
                int dni = rs.getInt("dni");
                String nombreCompleto = rs.getString("nombre_completo");
                String email = rs.getString("email");
                String password = rs.getString("password");
                TipoUsuario tipo = TipoUsuario.valueOf(rs.getString("tipo_usuario"));
                return new Usuario(dni, nombreCompleto, email, password, tipo);
            });
        } catch (ForeignKeyViolationException e) {
            throw new ReferenciaErroneaException(e);
        } catch (ConstraintViolationException e) {
            throw new ViolacionRestriccionException(e);
        } catch (ConnectionException e) {
            throw new SinConexionException(e);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
