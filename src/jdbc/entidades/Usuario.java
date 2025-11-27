package jdbc.entidades;

import jdbc.enums.TipoUsuario;

public class Usuario {
    private Integer dni;
    private String nombreCompleto;
    private String email;
    private String password;
    private TipoUsuario tipo;

    public Usuario(){}

    public Usuario(Integer dni, String nombreCompleto, String email, String password, TipoUsuario tipo){
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni=" + dni +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
}
