package produto.controller;

import java.util.List;

import produto.dao.ProdutoDao;
import produto.model.Produto;
import produto.view.ProdutoView;

/**
 * Controlador responsável por realizar a comunicação entre a camada de
 * visualização ({@link ProdutoView}) e a camada de dados ({@link ProdutoDao}).
 *
 * <p>Ele recebe comandos da interface gráfica, repassa ao DAO e exibe
 * mensagens adequadas ao usuário.</p>
 *
 * <p>Também realiza retornos e mensagens de sucesso ou falha conforme
 * a operação solicitada.</p>
 *
 * @author Luiz Lima
 * @version 1.0
 */
public class ProdutoController {

    private ProdutoDao dao;
    private ProdutoView view;

    /**
     * Construtor da classe ProdutoController.
     *
     * @param dao  objeto responsável por manipular os dados
     * @param view objeto responsável por interagir com o usuário
     */
    public ProdutoController(ProdutoDao dao, ProdutoView view) {
        this.dao = dao;
        this.view = view;
    }

    /**
     * Cria um novo produto e envia mensagem de confirmação ao usuário.
     *
     * @param produto objeto do tipo Produto contendo nome e preço
     */
    public void criarProduto(Produto produto) {
        dao.adicionarProduto(produto);
        view.mostrarMensagem("Produto adicionado com sucesso.");
    }

    /**
     * Solicita ao DAO a lista de produtos e a exibe ao usuário.
     */
    public void listarProdutos() {
        List<Produto> produtos = dao.listarProdutos();
        view.listarProdutos(produtos);
    }

    /**
     * Atualiza um produto existente.
     *
     * @param produto objeto contendo id, nome e preço atualizados
     */
    public void atualizarProduto(Produto produto) {
        boolean sucesso = dao.atualizarProduto(produto);

        if (sucesso) {
            view.mostrarMensagem("Produto atualizado com sucesso.");
        } else {
            view.mostrarMensagem("Produto não encontrado.");
        }
    }

    /**
     * Remove um produto pelo ID.
     *
     * @param id identificador do produto a ser removido
     */
    public void removerProduto(int id) {
        boolean sucesso = dao.removerProduto(id);

        if (sucesso) {
            view.mostrarMensagem("Produto removido com sucesso.");
        } else {
            view.mostrarMensagem("Produto não encontrado.");
        }
    }

    /**
     * Realiza a busca de um produto pelo ID e exibe as informações.
     *
     * @param id identificador do produto a ser buscado
     */
    public void buscarProduto(int id) {
        Produto p = dao.buscarPorId(id);
        String msg = view.mostrarProduto(p);
        view.mostrarMensagem(msg);
    }
}
