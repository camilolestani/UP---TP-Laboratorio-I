package jdbc.ui.componentes;

import jdbc.entidades.Usuario;

import javax.swing.*;

public class UsuarioRow extends JPanel {
    public UsuarioRow(Usuario u) {
        renderizar(u);
    }
    private void renderizar(Usuario u){
        this.add(new JLabel(u.toString()));
        this.add(new JButton("Eliminar"));
    }
}
