package produto;

import javax.swing.JOptionPane;

import produto.controller.ProdutoController;
import produto.dao.ProdutoDao;
import produto.model.Produto;
import produto.view.ProdutoView;

/**
 * Classe principal responsável por inicializar a aplicação de gestão de produtos.
 * Ela exibe um menu utilizando JOptionPane e direciona as operações para
 * o {@link ProdutoController}.
 *
 * <p>Permite adicionar, listar, atualizar, remover e buscar produtos
 * cadastrados em memória.</p>
 *
 * @author Luiz Lima
 * @version 1.0
 */
public class MainProduto {

    /**
     * Método principal da aplicação. Ele cria as instâncias de DAO, View
     * e Controller, exibe o menu e controla o fluxo de execução do programa.
     *
     * @param args argumentos não utilizados na aplicação
     */
    public static void main(String[] args) {

        ProdutoDao dao = new ProdutoDao();
        ProdutoView view = new ProdutoView();
        ProdutoController controller = new ProdutoController(dao, view);

        Object[] escolhas = { "Sair", "Adicionar", "Listar", "Atualizar", "Remover", "Buscar" };
        int opcao = -1;

        while (opcao != 0) {

            opcao = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção",
                    "Menu Produto",
                    0,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    escolhas,
                    escolhas[0]);

            Produto produto = null;

            switch (opcao) {

                case 1:
                    produto = view.formCadastro();
                    controller.criarProduto(produto);
                    break;

                case 2:
                    controller.listarProdutos();
                    break;

                case 3:
                    produto = view.formAlterar();
                    controller.atualizarProduto(produto);
                    break;

                case 4:
                    int idRemover = view.formBusca();
                    controller.removerProduto(idRemover);
                    break;

                case 5:
                    int idBuscar = view.formBusca();
                    controller.buscarProduto(idBuscar);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}
