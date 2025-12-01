import jdbc.ui.PanelManager;
import jdbc.util.TableManager;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Principal {
    private PanelManager manager;
    public static void main(String[] args) throws SQLException {
        TableManager tm = new TableManager();
        tm.createUsuarioTable();

        Principal principal = new Principal();
        principal.iniciarManager();
        principal.showFrame();

    }


    public void iniciarManager() {
        manager = new PanelManager();
        manager.armarManager();

        manager.mostrarLogin();
//        manager.mostrarVistaUsuarios();
    }

    public void showFrame() {
        manager.showFrame();
    }
}