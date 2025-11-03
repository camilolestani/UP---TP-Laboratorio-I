package jdbc.ui.componentes;

import jdbc.entidades.Usuario;
import jdbc.exceptions.service.ServiceException;
import jdbc.services.UsuarioService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ListaUsuarios extends JPanel {
    private UsuarioService usuarioService = new UsuarioService();
    private List<Usuario> usuarios = new ArrayList<>();

    public ListaUsuarios() {
        renderizar();
    }

    private void renderizar(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JButton refrescarBtn = new JButton("Buscar usuarios");
        refrescarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pedirListaUsuarios();
            }
        });
        this.add(refrescarBtn);

        try{
            renderizarLista();
        } catch(ServiceException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void renderizarLista() throws ServiceException {
        this.usuarios = this.usuarioService.obtenerTodosLosUsuarios();
        for (Usuario usuario : usuarios) {
            System.out.printf(usuario.toString());
            this.add(new UsuarioRow(usuario));
        }
    }

    private void pedirListaUsuarios(){
        this.removeAll();
        renderizar();
    }
}
