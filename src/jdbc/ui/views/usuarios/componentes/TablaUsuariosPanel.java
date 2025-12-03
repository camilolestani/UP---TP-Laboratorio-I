package jdbc.ui.views.usuarios.componentes;


import jdbc.entidades.Usuario;
import jdbc.services.UsuarioService;
import jdbc.ui.PanelManager;
import jdbc.ui.views.usuarios.componentes.user_actions_menu.UserActionsEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.List;

public class TablaUsuariosPanel extends JPanel implements ActionListener {

    private PanelManager panelManager;

    private JTable tablaUsuarios;
    private UsuarioTableModel modelo;

    private JScrollPane scrollPaneParaTabla;
    private JButton botonRecargar;
    private JButton botonNuevo;

    public TablaUsuariosPanel(PanelManager panelManager) {
        super();
        this.panelManager = panelManager;
        armarPanel();
        recargarContenido();
    }

    private void armarPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel auxTabla = new JPanel();
        modelo = new UsuarioTableModel();
        UserActionsEditor userActionCell = new UserActionsEditor(panelManager, tablaUsuarios);
        tablaUsuarios = new JTable(modelo);
        tablaUsuarios.getColumnModel().getColumn(5).setCellRenderer(userActionCell);
        tablaUsuarios.getColumnModel().getColumn(5).setCellEditor(userActionCell);
        tablaUsuarios.getColumnModel().getColumn(5).setPreferredWidth(180); // Wider actions column
        tablaUsuarios.getColumnModel().getColumn(5).setMinWidth(180);
        tablaUsuarios.setRowHeight(35);
        scrollPaneParaTabla = new JScrollPane(tablaUsuarios);
        auxTabla.add(scrollPaneParaTabla);


        JPanel auxBotonesPanel = new JPanel();
        botonRecargar = new JButton("Recargar Tabla");
        auxBotonesPanel.add(botonRecargar);

        botonNuevo = new JButton("Nuevo Usuario");
        auxBotonesPanel.add(botonNuevo);

        botonRecargar.addActionListener(this);
        botonNuevo.addActionListener(this);

        this.add(auxTabla);
        this.add(auxBotonesPanel);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonNuevo) {
            this.panelManager.mostrarPantallaAltaUsuario();
        } else if (e.getSource() == botonRecargar) {
            this.recargarContenido();
        }
    }

    public void recargarContenido() {
        UsuarioService usuarioService = new UsuarioService();
        List<Usuario> lista = usuarioService.obtenerTodosLosUsuarios();
        modelo.setContenido(lista);
        modelo.fireTableDataChanged();
        if (tablaUsuarios.getCellEditor() != null) {
            tablaUsuarios.getCellEditor().stopCellEditing();
        }
    }
}
