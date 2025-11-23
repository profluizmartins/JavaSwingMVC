package app.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Janela principal do sistema.
 *
 * <p>Responsável por exibir o menu inicial da aplicação e permitir o acesso
 * às telas de cadastro, como a lista de usuários.</p>
 *
 * @author GuilhermeHolanda
 * @version 2.0
 */
public class MainView extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuCadastros;
    private JMenuItem menuUsuario;

    /**
     * Construtor da janela principal.
     *
     * <p>Configura o layout, cria o menu e define o comportamento
     * ao abrir a tela de listagem de usuários.</p>
     */
    public MainView() {
        super("Sistema de Cadastros");
        getContentPane().setLayout(new FlowLayout());

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuCadastros = new JMenu("Cadastros");
        menuBar.add(menuCadastros);

        menuUsuario = new JMenuItem(new AbstractAction("Usuários") {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UsuarioListView();
            }
        });
        menuCadastros.add(menuUsuario);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
