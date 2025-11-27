package jdbc.ui.views.edicion_usuarios;

import jdbc.entidades.Usuario;
import jdbc.enums.TipoUsuario;
import jdbc.ui.PanelManager;
import jdbc.ui.views.creacion_usuarios.CreacionUsuarioCamposPanel;

import javax.swing.*;
import java.awt.*;

public class EdicionUsuarioCamposPanel extends CreacionUsuarioCamposPanel {

    public EdicionUsuarioCamposPanel(PanelManager m){
        super(m);
    }
    public void renderizar(){
        super.renderizar();
        this.dniTxt.setEnabled(false);
    }

    public void precargarUsuario(Usuario u){
        this.dniTxt.setText(u.getDni().toString());
        this.nombreTxt.setText(u.getNombreCompleto());
        this.emailTxt.setText(u.getEmail());
        this.passwordTxt.setText(u.getPassword());
        this.adminUserCheckbox.setSelected(u.getTipo() == TipoUsuario.ADMINISTRADOR);
    }

}
