package jdbc.ui.views.edicion_usuarios;

import jdbc.entidades.Usuario;
import jdbc.ui.PanelManager;
import jdbc.ui.componentes.CamposPanel;

import javax.swing.*;
import java.awt.*;

public class EdicionUsuarioCamposPanel extends CamposPanel<Usuario> {
    private JTextField dniTxt;
    private JTextField nombreTxt;
    private JTextField emailTxt;
    private JTextField passwordTxt;

    public EdicionUsuarioCamposPanel(PanelManager m){
        super(m);
    }
    public void renderizar(){
        this.setLayout(new GridLayout(4, 2));

        JLabel dniLabel = new JLabel("DNI (sin puntos): ");
        JTextField dniInput = new JTextField(15);
        this.dniTxt = dniInput;
        dniInput.setEnabled(false);
        this.add(dniLabel);
        this.add(dniInput);

        JLabel nombreCompletoLabel = new JLabel("Nombre Completo: ");
        JTextField nombreCompletoInput = new JTextField(15);
        this.nombreTxt = nombreCompletoInput;
        this.add(nombreCompletoLabel);
        this.add(nombreCompletoInput);

        JLabel emailLabel = new JLabel("Email: ");
        JTextField emailInput = new JTextField(15);
        this.emailTxt = emailInput;
        this.add(emailLabel);
        this.add(emailInput);

        JLabel passwordLabel = new JLabel("Password: ");
        JTextField passwordInput = new JTextField(15);
        this.passwordTxt = passwordInput;
        this.add(passwordLabel);
        this.add(passwordInput);
    }

    public Usuario obtenerValor(){
        Integer dni = Integer.parseInt(this.dniTxt.getText());
        String nombre = this.nombreTxt.getText();
        String email = this.emailTxt.getText();
        String password = this.passwordTxt.getText();
        return new Usuario(dni, nombre, email, password);
    }

    public void precargarUsuario(Usuario u){
        this.dniTxt.setText(u.getDni().toString());
        this.nombreTxt.setText(u.getNombreCompleto());
        this.emailTxt.setText(u.getEmail());
        this.passwordTxt.setText(u.getPassword());
    }

    @Override
    public void limpiarValores() {
        this.dniTxt.setText("");
        this.nombreTxt.setText("");
        this.emailTxt.setText("");
        this.passwordTxt.setText("");
    }
}
