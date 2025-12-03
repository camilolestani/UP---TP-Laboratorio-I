package jdbc.ui;


import jdbc.entidades.Usuario;
import jdbc.ui.views.creacion_usuarios.PantallaCreacionUsuario;
import jdbc.ui.views.edicion_usuarios.PantallaEdicionUsuario;
import jdbc.ui.views.login.Login;
import jdbc.ui.views.usuarios.VistaUsuarioAdmin;

import javax.swing.*;

public class PanelManager {

	private JFrame frame;
	private VistaUsuarioAdmin vistaUsuarioAdmin;
    private Login vistaLogin;
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

        vistaLogin = new Login(this);
        vistaUsuarioAdmin = new VistaUsuarioAdmin(this);
        pantallaCreacionUsuario = new PantallaCreacionUsuario(this);
        pantallaEdicionUsuario = new PantallaEdicionUsuario(this);
	}

	public void showFrame() {
		frame.setVisible(true);
	}

    public void mostrarLogin() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(vistaLogin);
        frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
        frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

	public void mostrarVistaUsuarios() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(vistaUsuarioAdmin);
        vistaUsuarioAdmin.recargarContenido();
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
