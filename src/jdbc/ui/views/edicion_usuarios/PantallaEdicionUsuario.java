package jdbc.ui.views.edicion_usuarios;

import jdbc.entidades.Usuario;
import jdbc.exceptions.service.ServiceException;
import jdbc.services.UsuarioService;
import jdbc.ui.PanelManager;
import jdbc.ui.componentes.AbstractPantallaUpsert;
import jdbc.ui.views.creacion_usuarios.CreacionUsuarioCamposPanel;

import javax.swing.*;

public class PantallaEdicionUsuario extends AbstractPantallaUpsert {

    public PantallaEdicionUsuario(PanelManager manager) {
        super(manager);
    }

    protected void setCamposPanel() {this.camposPanel = new EdicionUsuarioCamposPanel(panelManager);}

    // TODO - Abstraer mas todavia ya que solo cambia el metodo del servicio
    protected void handleConfirmAction(){
        UsuarioService usuarioService = new UsuarioService();
        Usuario u = ((EdicionUsuarioCamposPanel)this.camposPanel).obtenerValor();
        try {
            usuarioService.editarUsuario(u);
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

    public void precargarUsuario(Usuario u) {
        ((EdicionUsuarioCamposPanel)camposPanel).precargarUsuario(u);
    }
}
