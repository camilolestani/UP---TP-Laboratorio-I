package jdbc.ui.componentes;

import jdbc.ui.PanelManager;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractVistaTabla extends JPanel implements ActionListener {
    protected PanelManager panelManager;
    protected JTable tabla;
    protected AbstractTableModel modelo;

    public AbstractVistaTabla(PanelManager panelManager) {
        super();
        this.panelManager = panelManager;
        renderizar();
        recargarContenido();
    }

    private void renderizar(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Crea la tabla y la carga
        this.renderizarTabla();
        JPanel auxTabla = new JPanel();
        JScrollPane scrollPaneParaTabla = new JScrollPane(tabla);
        auxTabla.add(scrollPaneParaTabla);

        this.add(auxTabla);

        this.renderizarFooter();
    }

    // Crea la tabla customizada con el modelo
    protected abstract void renderizarTabla();

    // Crea la seccion de acciones
    protected abstract void renderizarFooter();

    public abstract void actionPerformed(ActionEvent e);

    public abstract void recargarContenido();
}
