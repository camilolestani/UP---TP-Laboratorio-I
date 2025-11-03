package jdbc.ui.views.usuarios;

import jdbc.ui.PanelManager;
import jdbc.ui.views.usuarios.componentes.TablaUsuariosPanel;

import javax.swing.*;

public class VistaUsuarios extends JPanel {
    private TablaUsuariosPanel tabla;
    public VistaUsuarios(PanelManager panelManager) {
        this.tabla = new TablaUsuariosPanel(panelManager);
        renderizar();
    }

    public void renderizar() {
        this.add(tabla);
    }

    public void recargarTabla() {
        tabla.recargarContenido();
    }
}
