package app.view;

import java.util.List;

import javax.swing.JOptionPane;

import app.model.Produto;

/**
 * View simples para interação com Produto usando diálogos Swing.
 * 
 * @author Maria Julia
 * @version 1.0
 */
public class ProdutoView {

    /**
     * Exibe um produto.
     * 
     * @param p produto
     */
    public void exibir(Produto p) {
        if (p == null) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado");
        } else {
            JOptionPane.showMessageDialog(null,
                    "ID: " + p.getId() + "\nNome: " + p.getNome() + "\nPreço: " + p.getPreco() + "\nEstoque: "
                            + p.getEstoque());
        }
    }

    /**
     * Lista produtos.
     * 
     * @param lista lista de produtos
     */
    public void listar(List<Produto> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Produto p : lista) {
            sb.append(p.getId()).append(" - ").append(p.getNome()).append(" - R$")
                    .append(p.getPreco()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }

    /** Exibe mensagem de erro */
    public void erro(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /** Exibe mensagem de sucesso */
    public void sucesso(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}
