package jdbc.ui.views.usuarios.componentes.user_actions_menu;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class UserActionsRenderer extends JPanel implements TableCellRenderer {
    private JButton editarBtn;
    private JButton borrarBtn;

    public UserActionsRenderer() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        editarBtn = new JButton("Editar");
        borrarBtn = new JButton("Borrar");

        add(editarBtn);
        add(borrarBtn);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        if (isSelected) {
            setBackground(table.getSelectionBackground());
        } else {
            setBackground(table.getBackground());
        }
        return this;
    }
}