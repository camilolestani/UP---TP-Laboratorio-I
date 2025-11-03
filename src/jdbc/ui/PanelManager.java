package jdbc.ui;


import jdbc.entidades.Usuario;
import jdbc.ui.views.creacion_usuarios.PantallaCreacionUsuario;
import jdbc.ui.views.edicion_usuarios.PantallaEdicionUsuario;
import jdbc.ui.views.usuarios.VistaUsuarios;

import javax.swing.*;

public class PanelManager {

	private JFrame frame;
	private VistaUsuarios vistaUsuarios;
    private PantallaCreacionUsuario pantallaCreacionUsuario;
    private PantallaEdicionUsuario pantallaEdicionUsuario;
//	private PantallaInicioPanel pantallaInicioPanel;

	public PanelManager() {
		// TODO Auto-generated constructor stub
	}

	public void armarManager() {
		frame = new JFrame("mi app");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        vistaUsuarios = new VistaUsuarios(this);
        pantallaCreacionUsuario = new PantallaCreacionUsuario(this);
        pantallaEdicionUsuario = new PantallaEdicionUsuario(this);
	}

	public void showFrame() {
		frame.setVisible(true);
	}

	public void mostrarVistaUsuarios() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(vistaUsuarios);
        vistaUsuarios.recargarTabla();
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior

	}

    public void mostrarPantallaAltaUsuario() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(pantallaCreacionUsuario);
        frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
        frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior

    }

	public void mostrarPantallaEdicionUsuario(Usuario usuarioAEditar) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(pantallaEdicionUsuario);
        pantallaEdicionUsuario.precargarUsuario(usuarioAEditar);
		frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
		frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior

	}

}
