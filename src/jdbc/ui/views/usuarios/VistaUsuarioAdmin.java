package jdbc.ui.views.usuarios;

import jdbc.entidades.Usuario;
import jdbc.services.UsuarioService;
import jdbc.ui.PanelManager;
import jdbc.ui.componentes.AbstractVistaTabla;
import jdbc.ui.views.usuarios.componentes.UsuarioTableModel;
import jdbc.ui.views.usuarios.componentes.user_actions_menu.UserActionsEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class VistaUsuarioAdmin extends AbstractVistaTabla {

    private JButton botonRecargar;
    private JButton botonNuevo;
    public VistaUsuarioAdmin(PanelManager panelManager) {
        super(panelManager);
    }

    protected void renderizarTabla() {
        modelo = new UsuarioTableModel();
        UserActionsEditor userActionCell = new UserActionsEditor(panelManager, tabla);
        tabla = new JTable(modelo);
        tabla.getColumnModel().getColumn(5).setCellRenderer(userActionCell);
        tabla.getColumnModel().getColumn(5).setCellEditor(userActionCell);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(180); // Wider actions column
        tabla.getColumnModel().getColumn(5).setMinWidth(180);
        tabla.setRowHeight(35);
    }

    @Override
    protected void renderizarFooter() {
        JPanel auxBotonesPanel = new JPanel();
        botonRecargar = new JButton("Recargar Tabla");
        auxBotonesPanel.add(botonRecargar);

        botonNuevo = new JButton("Nuevo Usuario");
        auxBotonesPanel.add(botonNuevo);

        botonRecargar.addActionListener(this);
        botonNuevo.addActionListener(this);

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

        ((UsuarioTableModel) modelo).setContenido(lista);
        modelo.fireTableDataChanged();
        if (tabla.getCellEditor() != null) {
            tabla.getCellEditor().stopCellEditing();
        }
    }
}
