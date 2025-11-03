package jdbc.ui.views.creacion_usuarios;

import jdbc.entidades.Usuario;
import jdbc.exceptions.service.ServiceException;
import jdbc.services.UsuarioService;
import jdbc.ui.PanelManager;
import jdbc.ui.componentes.AbstractPantallaUpsert;

import javax.swing.*;

public class PantallaCreacionUsuario extends AbstractPantallaUpsert {

    public PantallaCreacionUsuario(PanelManager manager) {
        super(manager);
    }

    protected void setCamposPanel() {this.camposPanel = new CreacionUsuarioCamposPanel(panelManager);}

    protected void handleConfirmAction(){
        UsuarioService usuarioService = new UsuarioService();
        Usuario u = ((CreacionUsuarioCamposPanel)this.camposPanel).obtenerValor();
        try {
            usuarioService.agregarUsuario(u);
        } catch (ServiceException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        finally {
            panelManager.mostrarVistaUsuarios();
            this.camposPanel.limpiarValores();
        }
    }

    protected void handleCancelAction(){
        panelManager.mostrarVistaUsuarios();
        this.camposPanel.limpiarValores();
    }
}
