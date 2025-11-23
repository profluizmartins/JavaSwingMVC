package app.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * Classe domímio de MainView
 * Exibe os dados na tela
 * 
 * @author Luiz Martins
 */
public class MainView  extends JFrame{
	private JMenuBar menuBar;
	private JMenu menuCadastros;
	private JMenuItem menuUsuario;

	public MainView(){
		super("Sistema de Cadastros");
		getContentPane().setLayout(new FlowLayout());
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuCadastros = new JMenu("Cadastros");
		menuBar.add(menuCadastros);
		menuUsuario = new JMenuItem(new AbstractAction("Usuários") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioListView ulv = new UsuarioListView();
				
			}
		});
		menuCadastros.add(menuUsuario);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
		
	}

}
