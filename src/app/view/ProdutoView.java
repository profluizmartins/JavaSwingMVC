package app.view;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import app.model.Produto;

/**
 * View (Visualização) da aplicação, responsável por interagir com o usuário
 * através de caixas de diálogo (JOptionPane).
 * @author Enzo Fonseca
 * @version 1.0
 */
public class ProdutoView {
    /**
     * Exibe os detalhes de um único produto ou uma mensagem de "não encontrado".
     * @param produto O objeto Produto a ser exibido (pode ser null).
     */
    public void mostrarProduto(Produto produto) {
        if (produto != null) {
            String detalhes = String.format("ID: %d\nNome: %s\nPreço: R$ %.2f", produto.getId(), produto.getNome(), produto.getPreco());
            JOptionPane.showMessageDialog(null, detalhes, "Detalhes do Produto", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.", "Erro", 0);
        }
    }

    /**
     * Exibe uma lista de produtos em uma caixa de diálogo com scroll.
     * @param produtos A lista de produtos a ser exibida.
     */
    public void listarProdutos(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            this.mostrarMensagem("Nenhum produto cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder("--- Lista de Produtos ---\n\n");
            for (Produto p : produtos) {
                sb.append(String.format("ID: %d\nNome: %s\nPreço: R$ %.2f\n--------------------\n", p.getId(), p.getNome(), p.getPreco()));
            }
            JTextArea textArea = new JTextArea(sb.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(350, 250));
            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Produtos", 1);
        }
    }

    /**
     * Exibe uma mensagem genérica para o usuário.
     * @param mensagem O texto da mensagem.
     */
    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Mensagem", 1);
    }
}
