package jdbc.ui.views.creacion_usuarios;

import jdbc.entidades.Usuario;
import jdbc.enums.TipoUsuario;
import jdbc.ui.PanelManager;
import jdbc.ui.componentes.CamposPanel;

import javax.swing.*;
import java.awt.*;

public class CreacionUsuarioCamposPanel extends CamposPanel<Usuario> {
    protected JTextField dniTxt;
    protected JTextField nombreTxt;
    protected JTextField emailTxt;
    protected JTextField passwordTxt;
    protected JCheckBox adminUserCheckbox;

    public CreacionUsuarioCamposPanel(PanelManager m){
        super(m);
    }
    public void renderizar(){
        this.setLayout(new GridLayout(5, 2));

        JLabel dniLabel = new JLabel("DNI (sin puntos): ");
        JTextField dniInput = new JTextField(15);
        this.dniTxt = dniInput;
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

        JLabel adminUsuarioLabel = new JLabel("Admin: ");
        JCheckBox adminUserCheckbox = new JCheckBox();
        this.adminUserCheckbox = adminUserCheckbox;
        this.add(adminUsuarioLabel);
        this.add(adminUserCheckbox);
    }

    public Usuario obtenerValor(){
        Integer dni = Integer.parseInt(this.dniTxt.getText());
        String nombre = this.nombreTxt.getText();
        String email = this.emailTxt.getText();
        String password = this.passwordTxt.getText();
        Boolean isAdmin = this.adminUserCheckbox.isSelected();
        return new Usuario(dni, nombre, email, password, isAdmin ? TipoUsuario.ADMINISTRADOR : TipoUsuario.CLIENTE);
    }

    @Override
    public void limpiarValores() {
        this.dniTxt.setText("");
        this.nombreTxt.setText("");
        this.emailTxt.setText("");
        this.passwordTxt.setText("");
        this.adminUserCheckbox.setSelected(false);
    }
}
