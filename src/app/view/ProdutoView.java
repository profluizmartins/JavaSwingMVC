package Aula08;

import javax.swing.*;
import java.awt.Dimension;
import java.util.List;

/**
 * Classe View de produtos
 */
public class ProdutoView {

    /**
     * Método para criar janelas de menus.
     * @param titulo título da janela
     * @param mensagem mensagem exibida na janela
     * @param opcoes opções do menu
     * @return
     */
    public static String menu(String titulo, String mensagem, Object[] opcoes) {
        Object selecionado = JOptionPane.showInputDialog(null,
                mensagem,
                titulo,
                JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]);

        return (selecionado == null) ? null : selecionado.toString();
    }

    /**
     * Método para criar janelas para ler texto
     * @param mensagem mensagem exibida na janela
     * @return retorna o texto digitado
     */
    public static String lerTexto(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    /**
     * Método para criar janelas para ler números inteiros
     * @param mensagem mensagem exibida na janela
     * @return retorna o inteiro digitado
     * @throws OperacaoCanceladaException caso retorne vazio
     */
    public static int lerInt(String mensagem) throws OperacaoCanceladaException {
        while (true) {
            String input = JOptionPane.showInputDialog(mensagem);
            if (input == null) {
                throw new OperacaoCanceladaException();
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                erro("Entrada inválida. Por favor, digite um número inteiro.");
            }
        }
    }

    /**
     * Método para criar janelas para ler números flutuantes
     * @param mensagem mensagem exibida na janela
     * @return retorna o número flutuante digitado
     * @throws OperacaoCanceladaException caso retorne vazio
     */
    public static double lerDouble(String mensagem) throws OperacaoCanceladaException {
        while (true) {
            String input = JOptionPane.showInputDialog(mensagem);
            if (input == null) {
                throw new OperacaoCanceladaException();
            }
            try {
                return Double.parseDouble(input.replace(",", "."));
            } catch (NumberFormatException e) {
                erro("Entrada inválida. Por favor, digite um número válido (ex: 19.99).");
            }
        }
    }

    /**
     * Método para criar janelas com opções
     * @param titulo título da janela
     * @param mensagem mensagem exibida na janela
     * @param opcoes opções exibidas na janela
     * @return retorna a opção escolhida
     */
    public static String obterOpcao(String titulo, String mensagem, String[] opcoes) {
        int escolha = JOptionPane.showOptionDialog(
                null,
                mensagem,
                titulo,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, opcoes, null
        );

        if (escolha == JOptionPane.CLOSED_OPTION) {
            return null;
        }

        return opcoes[escolha];
    }

    /**
     * Método para criar janelas para exibir mensagens de informação.
     * @param mensagem mensagem de informação exibida na janela
     */
    public static void info(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para criar janelas para exibir mensagens de erro.
     * @param mensagem mensagem de erro exibido na janela
     */
    public static void erro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método para exibir descrição de um produto
     * @param p produto a ser exibido.
     */
    public void mostrarProduto(Produto p) {
        if (p != null) {
            ProdutoView.info(p.toString());
        } else {
            ProdutoView.erro("Produto não encontrado!");
        }
    }

    /**
     * Método para exibir uma lista de produtos
     * @param produtos lista de produtos a ser exibida
     */
    public void listarProdutos(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            ProdutoView.info("Nenhum produto cadastrado!");
        } else {
            StringBuilder listaFormatada = new StringBuilder();
            listaFormatada.append("--- Lista de Produtos ---\n\n");

            for (Produto p : produtos) {
                listaFormatada.append(p.toString()).append("\n");
            }

            JTextArea textArea = new JTextArea(listaFormatada.toString());
            textArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(450, 300)); // Ajuste o tamanho se necessário

            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Produtos", JOptionPane.PLAIN_MESSAGE);
        }
    }

    /**
     * Método para exibir mensagem
     * @param mensagem mensagem a ser exibida
     */
    public void mostrarMsg(String mensagem) {
        ProdutoView.info(mensagem);
    }
}