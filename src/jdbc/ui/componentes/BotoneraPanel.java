package jdbc.ui.componentes;

import jdbc.ui.PanelManager;

import javax.swing.*;

public class BotoneraPanel extends JPanel {

    private JButton okBtn;
    private JButton cancelBtn;
    private PanelManager manager;

    public BotoneraPanel(PanelManager manager) {
        this.manager = manager;
        armar();
    }

    public BotoneraPanel() {
        armar();
    }

    private void armar() {
        this.okBtn = new JButton("ACEPTAR");
        this.cancelBtn = new JButton("CANCELAR");
        this.add(okBtn);
        this.add(cancelBtn);
    }

    public JButton getOkBtn() {
        return okBtn;
    }

    public void setOkBtn(JButton okBtn) {
        this.okBtn = okBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public void setCancelBtn(JButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }
}