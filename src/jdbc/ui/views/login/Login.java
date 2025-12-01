package jdbc.ui.views.login;

import jdbc.entidades.Usuario;
import jdbc.exceptions.dao.NoMatchesException;
import jdbc.exceptions.service.ServiceException;
import jdbc.services.UsuarioService;
import jdbc.ui.PanelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel {
    private JTextField dniTxt;
    private JTextField passwordTxt;
    private JButton loginButton;
    private JLabel errorLabel;
    private PanelManager panelManager;

    public Login(PanelManager m) {
        this.panelManager = m;
        renderizar();
    }

    public void renderizar(){
        this.setLayout(new BorderLayout());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 1));

        JPanel inputsPanel = new JPanel();
        inputsPanel.setLayout(new GridLayout(2, 2));
        inputsPanel.setBackground(Color.gray);
        inputsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        inputsPanel.add(new JLabel("DNI: "));
        dniTxt = new JTextField();
        inputsPanel.add(dniTxt);

        inputsPanel.add(new JLabel("PASSWORD: "));
        passwordTxt = new JTextField();
        inputsPanel.add(passwordTxt);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UsuarioService usuarioService = new UsuarioService();
                    Usuario user = usuarioService.loginUsuario(Integer.parseInt(dniTxt.getText()), passwordTxt.getText());
                    if (user.getDni() != null) {
                        panelManager.mostrarVistaUsuarios();
                        limpiarValores();
                    } else {
                        errorLabel.setVisible(true);
                    }
                } catch (ServiceException ex){
                    errorLabel.setVisible(true);
                }
            }
        });

        loginPanel.add(inputsPanel);

        loginPanel.add(loginButton);

        errorLabel = new JLabel("DNI o contraseña invalidos.");
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        loginPanel.add(errorLabel);

        this.add(loginPanel, BorderLayout.CENTER);
    }

    private void limpiarValores(){
        dniTxt.setText("");
        passwordTxt.setText("");
        errorLabel.setVisible(false);
    }
}
