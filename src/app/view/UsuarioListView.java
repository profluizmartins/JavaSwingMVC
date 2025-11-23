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
 * Tela responsável pela listagem, criação, edição e exclusão de usuários.
 *
 * <p>Possui dois modos: modo lista (exibe a tabela) e modo formulário
 * (para criação ou edição de usuários).</p>
 *
 * @author GuilhermeHolanda
 * @version 2.0
 */

public class UsuarioListView extends JFrame {

    private UsuarioDao dao = new UsuarioDao();

    private JLabel lTitulo;

    private JPanel jpFormulario;
    private JTextField txfNome;
    private JTextField txfEmail;

    private JPanel painelBotoes;
    private JButton btnNovo;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnSalvar;
    private JButton btnCancelar;

    private JPanel painelCentral;
    private JScrollPane scrollTabela;
    private DefaultTableModel modelo;
    private JTable tabela;

    private Usuario usuario;

    /**
     * Construtor da tela de usuários.
     *
     * <p>Inicializa layout, tabela, botões e eventos da tela.</p>
     */
    public UsuarioListView() {
        super("Lista de Usuários");

        // Dados iniciais de teste
        try {
            dao.adicionarUsuario("Juarez Silva", "juarezsilva@gmail.com");
            dao.adicionarUsuario("Edson Arantes", "pelerei@gmail.com");
            dao.adicionarUsuario("João Souza", "joaosouza@gmail.com");
            dao.adicionarUsuario("Luiza M", "luiza@gmail.com");
        } catch (UsuarioExeception e) {
            e.printStackTrace();
        }

        getContentPane().setLayout(new BorderLayout());

        painelCentral = new JPanel();
        lTitulo = new JLabel("");
        getContentPane().add(lTitulo, BorderLayout.NORTH);
        getContentPane().add(painelCentral, BorderLayout.CENTER);

        String[] colunas = {"ID", "Nome", "E-mail"};
        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);
        scrollTabela = new JScrollPane(tabela);
        painelCentral.add(scrollTabela);
        refreshTable();

        painelBotoes = new JPanel();
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);

        // ----------------------------
        // Botão: Novo Usuário
        // ----------------------------
        btnNovo = new JButton(new AbstractAction("Novo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeForm();
                usuario = null;
                txfNome.setText("");
                txfEmail.setText("");
            }
        });

        // ----------------------------
        // Botão: Editar Usuário
        // ----------------------------
        btnEditar = new JButton(new AbstractAction("Editar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabela.getSelectedRow();

                if (linhaSelecionada != -1) {
                    int id = (int) modelo.getValueAt(linhaSelecionada, 0);
                    String nome = (String) modelo.getValueAt(linhaSelecionada, 1);
                    String email = (String) modelo.getValueAt(linhaSelecionada, 2);

                    try {
                        usuario = new Usuario(id, nome, email);
                    } catch (UsuarioExeception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao carregar usuário: " + ex.getMessage());
                        return;
                    }

                    txfNome.setText(nome);
                    txfEmail.setText(email);
                    modeForm();

                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha para editar!");
                }
            }
        });

        // ----------------------------
        // Botão: Excluir Usuário
        // ----------------------------
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

        // ----------------------------
        // Botão: Salvar Usuário
        // ----------------------------
        btnSalvar = new JButton(new AbstractAction("Gravar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txfNome.getText();
                String email = txfEmail.getText();

                if (usuario == null) { // Novo cadastro
                    try {
                        dao.adicionarUsuario(nome, email);
                        refreshTable();
                        modeList();
                        JOptionPane.showMessageDialog(null, "Usuário criado com sucesso!");
                    } catch (UsuarioExeception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao criar usuário: " + ex.getMessage());
                    }

                } else { // Atualização
                    try {
                        dao.atualizarUsuario(usuario.getId(), nome, email);
                        refreshTable();
                        modeList();
                        JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
                    } catch (UsuarioExeception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao alterar usuário: " + ex.getMessage());
                    }
                }
            }
        });

        // ----------------------------
        // Botão: Cancelar operação
        // ----------------------------
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

        // ----------------------------
        // Formulário
        // ----------------------------
        jpFormulario = new JPanel(new GridLayout(3, 2));

        jpFormulario.add(new JLabel("Nome:"));
        txfNome = new JTextField();
        jpFormulario.add(txfNome);

        jpFormulario.add(new JLabel("Email:"));
        txfEmail = new JTextField();
        jpFormulario.add(txfEmail);

        jpFormulario.setVisible(false);
        painelCentral.add(jpFormulario);

        modeList();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Alterna a tela para o modo de listagem (modo tabela).
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
     * Alterna a tela para o modo de formulário (modo cadastro/edição).
     */
    private void modeForm() {
        btnCancelar.setVisible(true);
        btnSalvar.setVisible(true);
        btnNovo.setVisible(false);
        btnEditar.setVisible(false);
        btnExcluir.setVisible(false);

        jpFormulario.setVisible(true);
        scrollTabela.setVisible(false);
        lTitulo.setText("Formulário de Cadastro de Usuários");
    }

    /**
     * Atualiza a tabela com os dados existentes no {@link UsuarioDao}.
     */
    private void refreshTable() {
        List<Usuario> usuarios = dao.listarUsuarios();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (Usuario usuario : usuarios) {
            modelo.addRow(new Object[]{
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
            });
        }
    }
}
