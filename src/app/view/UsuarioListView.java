package app.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import app.controller.UsuarioController;
import app.exception.UsuarioExeception;
import app.model.Usuario;
import app.model.UsuarioDao;


/**
 * Tela responsável pela visualização, listagem e edição de usuários da aplicação.
 * 
 * <p>
 * A classe se comunica diretamente com {@link UsuarioDao} para carregar e 
 * atualizar os dados, enquanto controlar estados da interface por meio dos
 * métodos <code>modeList()</code> e <code>modeForm()</code>
 * </p>
 * 
 * @author Luiz Martins
 */
public class UsuarioListView extends JFrame {

	private UsuarioDao dao = new UsuarioDao();
	private JLabel lTitulo;

	private JPanel jpFormulario;
	private JTextField txfNome;
	private JTextField txfEmail;

	JPanel painelBotoes;
	JButton btnNovo;
	JButton btnEditar;
	JButton btnExcluir;
	JButton btnSalvar;
	JButton btnCancelar;
	JPanel painelCentral;
	JScrollPane scrollTabela;
	private DefaultTableModel modelo;
	private JTable tabela;

	private Usuario usuario;

	/**
	 * Contrói a janela gráfica de gerenciamente de usuários
	 * 
	 * <p>
	 * O construtor inicializa os componetes da interface, cria a tabela e 
	 * carrega os usuários de exemplo no DAO e registra os botões de ação.
	 * </p>
	 */
	public UsuarioListView() {
		
		super("Teste do BorderLayout");
		
		// dados inciais para teste
		try {
			dao.adicionarUsuario("Juarez Silva", "juarezsilva@gmail.com");
			dao.adicionarUsuario("Edson Arantes", "pelerei@gmail.com");
			dao.adicionarUsuario("João Souza", "joaosouza@gmail.com");
			dao.adicionarUsuario("Luiza M", "luiza@gmail.com");
		} catch (UsuarioExeception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		getContentPane().setLayout(new BorderLayout());

		painelCentral = new JPanel();
		this.lTitulo = new JLabel("");
		getContentPane().add(this.lTitulo, BorderLayout.NORTH);
		getContentPane().add(painelCentral, BorderLayout.CENTER);
		String[] colunas = { "ID", "Nome", "E-mail" };

		modelo = new DefaultTableModel(colunas, 0);
		tabela = new JTable(modelo);

		scrollTabela = new JScrollPane(tabela);
		painelCentral.add(scrollTabela);
		this.refreshTable();

		painelBotoes = new JPanel();
		getContentPane().add(painelBotoes, BorderLayout.SOUTH);

		// ---- Botões e Listeners ----

		btnNovo = new JButton(new AbstractAction("Novo") {
			@Override
			public void actionPerformed(ActionEvent e) {
				modeForm();
				usuario = null;
				txfNome.setText("");
				txfEmail.setText("");

			}
		});

		btnEditar = new JButton(new AbstractAction("Editar") {
			@Override
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tabela.getSelectedRow();
				if (linhaSelecionada != -1) {
					int id = (int) modelo.getValueAt(linhaSelecionada, 0);
					String nome = (String) modelo.getValueAt(linhaSelecionada, 1);
					String email = (String) modelo.getValueAt(linhaSelecionada, 2);
					usuario = new Usuario(id, nome, email);
					txfNome.setText(nome);
					txfEmail.setText(email);
					modeForm();
				} else { 
					JOptionPane.showMessageDialog(null, "Selecione uma linha para editar!");
				}

				
			}
		});

		// Botão para remover linha selecionada
		btnExcluir = new JButton(new AbstractAction("Excluir") {
			@Override
			public void actionPerformed(ActionEvent e) {
				 int linhaSelecionada = tabela.getSelectedRow();
				 if (linhaSelecionada != -1) {
					 int id = (int) modelo.getValueAt(linhaSelecionada, 0);
					dao.removerUsuario(id);
					refreshTable();
				 } else {
				 JOptionPane.showMessageDialog(null, "Selecione uma linha para remover!");
				}
			}
		});
		// Layout

		btnSalvar = new JButton(new AbstractAction("Gravar") {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nome = txfNome.getText();
				String email = txfEmail.getText();
				if(usuario == null) {
					try {
						dao.adicionarUsuario(nome, email);
						refreshTable();
						modeList();
						JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");
						
					} catch (UsuarioExeception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao criar usuário: "+e1.getMessage());
					}
				}else {
					try {
						dao.atualizarUsuario(usuario.getId(), nome, email);
						refreshTable();
						modeList();
						JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
						
					} catch (UsuarioExeception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao alterar usuário: "+e1.getMessage());
					}
					
				}

			}
		});

		btnCancelar = new JButton(new AbstractAction("Cancelar") {
			@Override
			public void actionPerformed(ActionEvent e) {
				modeList();
			}
		});

		painelBotoes.add(btnNovo);
		painelBotoes.add(btnEditar);
		painelBotoes.add(btnExcluir);
		painelBotoes.add(btnSalvar);
		painelBotoes.add(btnCancelar);

		// getContentPane().add(painelBotoesForm, BorderLayout.SOUTH);

		// ---- Formulário ----

		jpFormulario = new JPanel(new GridLayout(3, 2));
		jpFormulario.add(new JLabel("Nome:"));
		txfNome = new JTextField();
		txfNome.setColumns(20); // número de colunas (~20 caracteres)
		jpFormulario.add(txfNome);

		jpFormulario.add(new JLabel("Email"));
		txfEmail = new JTextField();
		txfEmail.setColumns(20);
		jpFormulario.add(txfEmail);
		jpFormulario.setVisible(false);
		painelCentral.add(jpFormulario);

		this.modeList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Alterna a interface para o modo de listagem, exibindo a tabela de usuário 
	 * e ocultando o formulário de edição/criação
	 */
	private void modeList() {
		btnCancelar.setVisible(false);
		btnSalvar.setVisible(false);
		btnNovo.setVisible(true);
		btnEditar.setVisible(true);
		btnExcluir.setVisible(true);
		jpFormulario.setVisible(false);
		scrollTabela.setVisible(true);
		lTitulo.setText("Lista de Usuários Cadastrados");
	}

	/**
	 * Alterna a interface para o modo de formulário, ocultando a tabela 
	 * e permitindo a criação ou edição de um usuário
	 */
	private void modeForm() {
		btnCancelar.setVisible(true);
		btnSalvar.setVisible(true);
		btnNovo.setVisible(false);
		btnEditar.setVisible(false);
		btnExcluir.setVisible(false);
		jpFormulario.setVisible(true);
		scrollTabela.setVisible(false);
		lTitulo.setText("Formulário de Cadastrado de Usuários");
	}


	/**
	 * Atualiza os dados exibidos na tabela, recarregando a lista de usuários 
	 * Remove todas as linhas da tabela e insere os dados atualizados
	 */
	private void refreshTable() {
		List<Usuario> usuarios = dao.listarUsuarios();
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}

		for (Usuario usuario : usuarios) {
			modelo.addRow(new Object[] { usuario.getId(), usuario.getNome(), usuario.getEmail() });
		}
	}
}
