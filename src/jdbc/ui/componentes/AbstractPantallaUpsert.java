package jdbc.ui.componentes;

import jdbc.ui.PanelManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractPantallaUpsert extends JPanel {
    protected PanelManager panelManager;
    protected CamposPanel camposPanel;
    protected BotoneraPanel botoneraPanel;

    public AbstractPantallaUpsert(PanelManager manager) {
        panelManager = manager;
        this.setCamposPanel();
        this.setBotoneraPanel();
        renderizar();
    }

    public void renderizar(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(camposPanel);
        this.add(botoneraPanel);

        this.botoneraPanel.getOkBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleConfirmAction();
            }
        });
        this.botoneraPanel.getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCancelAction();
            }
        });
    }

    private void setBotoneraPanel() { this.botoneraPanel= new BotoneraPanel(this.panelManager);}

    protected abstract void setCamposPanel();

    protected abstract void handleConfirmAction();
    protected abstract void handleCancelAction();

}
