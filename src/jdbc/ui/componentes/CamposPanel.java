package jdbc.ui.componentes;

import jdbc.ui.PanelManager;

import javax.swing.*;

public abstract class CamposPanel<T> extends JPanel {
    protected PanelManager m;

    public CamposPanel(PanelManager m) {
        this.m = m;
        renderizar();
    }

    public abstract void renderizar();
    public abstract T obtenerValor();
    public abstract void limpiarValores();
}
