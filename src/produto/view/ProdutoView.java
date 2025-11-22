package produto.view;

import java.util.List;

import javax.swing.JOptionPane;

import produto.model.Produto;

/**
 * Classe responsável pela interação com o usuário via JOptionPane.
 * Exibe mensagens, formulários e listas de produtos.
 * 
 * author Luiz Lima
 * @version 1.0
 */
public class ProdutoView {

    /**
     * Exibe uma mensagem simples.
     * 
     * @param mensagem texto a ser mostrado
     */
    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Retorna uma representação textual de um produto.
     * 
     * @param produto produto a ser mostrado
     * @return texto formatado
     */
    public String mostrarProduto(Produto produto) {
        if (produto == null) {
            return "Produto não encontrado.";
        }

        return "ID: " + produto.getId() +
               "\nNome: " + produto.getNome() +
               "\nPreço: " + produto.getPreco() +
               "\n-------------------\n";
    }

    /**
     * Exibe a lista de produtos.
     * 
     * @param produtos lista de produtos
     */
    public void listarProdutos(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            mostrarMensagem("Nenhum produto cadastrado.");
            return;
        }

        String aux = "";
        for (Produto p : produtos) {
            aux += mostrarProduto(p);
        }

        mostrarMensagem(aux);
    }

    /**
     * Formulário para cadastro de produto.
     * 
     * @return novo produto ou null se cancelado
     */
    public Produto formCadastro() {

        String nome = JOptionPane.showInputDialog(null,
                "Informe o nome do produto:",
                "Cadastro de Produto",
                JOptionPane.INFORMATION_MESSAGE);

        if (nome == null || nome.trim().isEmpty()) {
            mostrarMensagem("Nome inválido.");
            return null;
        }

        double preco = 0;

        while (true) {
            String txtPreco = JOptionPane.showInputDialog(null,
                    "Informe o preço do produto:",
                    "Cadastro de Produto",
                    JOptionPane.INFORMATION_MESSAGE);

            if (txtPreco == null) return null;

            try {
                preco = Double.parseDouble(txtPreco);
                break;
            } catch (NumberFormatException e) {
                mostrarMensagem("Preço inválido.");
            }
        }

        return new Produto(0, nome, preco);
    }

    /**
     * Formulário para alterar um produto.
     * 
     * @return produto atualizado ou null
     */
    public Produto formAlterar() {

        int id = formBusca();
        if (id == -1) return null;

        String nome = JOptionPane.showInputDialog(null,
                "Informe o novo nome:",
                "Alterar Produto",
                JOptionPane.INFORMATION_MESSAGE);

        if (nome == null || nome.trim().isEmpty()) {
            mostrarMensagem("Nome inválido.");
            return null;
        }

        double preco = 0;

        while (true) {
            String txtPreco = JOptionPane.showInputDialog(null,
                    "Informe o novo preço:",
                    "Alterar Produto",
                    JOptionPane.INFORMATION_MESSAGE);

            if (txtPreco == null) return null;

            try {
                preco = Double.parseDouble(txtPreco);
                break;
            } catch (NumberFormatException e) {
                mostrarMensagem("Preço inválido.");
            }
        }

        return new Produto(id, nome, preco);
    }

    /**
     * Formulário para buscar um produto por ID.
     * 
     * @return ID válido ou -1 se cancelado
     */
    public int formBusca() {

        while (true) {
            String txt = JOptionPane.showInputDialog(null,
                    "Informe o ID:",
                    "Buscar Produto",
                    JOptionPane.INFORMATION_MESSAGE);

            if (txt == null) return -1;

            try {
                return Integer.parseInt(txt);
            } catch (NumberFormatException e) {
                mostrarMensagem("ID inválido.");
            }
        }
    }
}
