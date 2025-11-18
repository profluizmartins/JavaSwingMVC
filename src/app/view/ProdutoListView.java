package app.view;

import java.awt.BorderLayout;
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

import app.exception.Execeptions;
import app.model.Produto;
import app.model.ProdutoDao;
import app.model.Usuario;

public class ProdutoListView extends JFrame {

    private ProdutoDao dao = new ProdutoDao();
    private JLabel lTitulo;

    private JPanel jpFormulario;
    private JTextField txfNome;
    private JTextField txfPreco;

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

    private Produto produto;
    public ProdutoListView() {

        super("Teste do BorderLayout");

        try {
            dao.adicionarProdutos("Teclado mecânico", 120.0);
            dao.adicionarProdutos("Mouse sem fio", 90.0);
            dao.adicionarProdutos("Monitor 4K", 1200.95);
            dao.adicionarProdutos("RTX 5090", 542.98);
        } catch (Execeptions e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        getContentPane().setLayout(new BorderLayout());

        painelCentral = new JPanel();
        this.lTitulo = new JLabel("");
        getContentPane().add(this.lTitulo, BorderLayout.NORTH);
        getContentPane().add(painelCentral, BorderLayout.CENTER);
        String[] colunas = { "ID", "Nome", "Preço" };

        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);

        scrollTabela = new JScrollPane(tabela);
        painelCentral.add(scrollTabela);
        this.refreshTable();

        painelBotoes = new JPanel();
        getContentPane().add(painelBotoes, BorderLayout.SOUTH);

        btnNovo = new JButton(new AbstractAction("Novo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeForm();
                produto = null;
                txfNome.setText("");
                txfPreco.setText("");

            }
        });

        btnEditar = new JButton(new AbstractAction("Editar") {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tabela.getSelectedRow();
                if (linhaSelecionada != -1) {
                    int id = (int) modelo.getValueAt(linhaSelecionada, 0);
                    String nome = (String) modelo.getValueAt(linhaSelecionada, 1);
                    Double preco = (Double) modelo.getValueAt(linhaSelecionada, 2);
                    produto = new Produto(id, nome, preco);
                    txfNome.setText(nome);
                    txfPreco.setText(String.valueOf(preco));
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
                    try {
                        dao.removerProdutos(id);
                    } catch (Execeptions erro) {
                        throw new RuntimeException(erro);
                    }
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
                Double preco = Double.parseDouble(txfPreco.getText());;
                if(produto == null) {
                    try {
                        dao.adicionarProdutos(nome, preco);
                        refreshTable();
                        modeList();
                        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

                    } catch (Execeptions e1) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: "+e1.getMessage());
                    }
                }else {
                    try {
                        dao.atualizarProdutos(produto.getId(), nome, preco);
                        refreshTable();
                        modeList();
                        JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");

                    } catch (Execeptions e1) {
                        JOptionPane.showMessageDialog(null, "Erro ao alterar produto: "+e1.getMessage());
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

        jpFormulario = new JPanel(new GridLayout(3, 2));
        jpFormulario.add(new JLabel("Nome:"));
        txfNome = new JTextField();
        txfNome.setColumns(20); // número de colunas (~20 caracteres)
        jpFormulario.add(txfNome);

        jpFormulario.add(new JLabel("Preço:"));
        txfPreco = new JTextField();
        txfPreco.setColumns(20);
        jpFormulario.add(txfPreco);
        jpFormulario.setVisible(false);
        painelCentral.add(jpFormulario);

        this.modeList();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void modeList() {
        btnCancelar.setVisible(false);
        btnSalvar.setVisible(false);
        btnNovo.setVisible(true);
        btnEditar.setVisible(true);
        btnExcluir.setVisible(true);
        jpFormulario.setVisible(false);
        scrollTabela.setVisible(true);
        lTitulo.setText("Lista de Produtos Cadastrados");
    }

    private void modeForm() {
        btnCancelar.setVisible(true);
        btnSalvar.setVisible(true);
        btnNovo.setVisible(false);
        btnEditar.setVisible(false);
        btnExcluir.setVisible(false);
        jpFormulario.setVisible(true);
        scrollTabela.setVisible(false);
        lTitulo.setText("Formulário de Cadastrado de Produtos");
    }

    private void refreshTable() {
        List<Produto> produtos = dao.listarProdutos();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (Produto p : produtos) {
            modelo.addRow(new Object[] { p.getId(), p.getNome(), p.getPreco() });
        }
    }
}
