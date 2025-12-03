package jdbc.ui.views.usuarios.componentes.user_actions_menu;

import jdbc.entidades.Usuario;
import jdbc.exceptions.service.ServiceException;
import jdbc.services.UsuarioService;
import jdbc.ui.PanelManager;
import jdbc.ui.views.usuarios.componentes.UsuarioTableModel;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserActionsEditor extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
    PanelManager manager;
    private JPanel panel;
    private JButton editBtn;
    private JButton verProductosBtn;
    private JButton deleteBtn;
    private Usuario usuario;
    private JTable table;

    public UserActionsEditor(PanelManager m, JTable t) {
        manager = m;
        table = t;
        this.renderizar();
    }

    public void renderizar() {
        this.panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
        this.editBtn = new JButton("Editar");
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        });
        this.panel.add(editBtn);

        this.deleteBtn = new JButton("Borrar");
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrar();
            }
        });
        this.panel.add(deleteBtn);

    }

    private void editar() {
        this.manager.mostrarPantallaEdicionUsuario(usuario);
    }

    private void borrar() {
        int confirm = JOptionPane.showConfirmDialog(panel, "¿Está seguro de que desea borrar el usuario " + usuario.getNombreCompleto() + "?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            UsuarioService usuarioService = new UsuarioService();
            try {
                usuarioService.borrarUsuario(usuario);
                JOptionPane.showMessageDialog(panel, "Usuario borrado exitosamente");

                // Refresh table
                ((UsuarioTableModel) table.getModel()).getContenido().remove(usuario);
                ((UsuarioTableModel) table.getModel()).fireTableDataChanged();
                table.getCellEditor().stopCellEditing();

            } catch (ServiceException e) {
                JOptionPane.showMessageDialog(panel, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.usuario = (Usuario) value;
        return panel;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        if (isSelected) {
            panel.setBackground(table.getSelectionBackground());
        } else {
            panel.setBackground(table.getBackground());
        }
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return usuario;
    }

}
