package app.controller;
import java.util.List;
import app.exception.ValidacaoException;
import app.model.Produto;
import app.model.ProdutoDao;
import app.view.ProdutoView;

/**
 * Controlador (Controller) da aplicação, responsável por intermediar
 * a comunicação entre a View (ProdutoView) e o Model (ProdutoDao).
 * @author Enzo Fonseca
 * @version 1.0
 */
public class ProdutoController {
    /** Objeto de acesso a dados para Produtos. */
    private ProdutoDao dao;
    /** Objeto de visualização para interagir com o usuário. */
    private ProdutoView view;

    /**
     * Construtor do controlador.
     * @param dao O DAO de Produto.
     * @param view A View de Produto.
     */
    public ProdutoController(ProdutoDao dao, ProdutoView view) {
        this.dao = dao;
        this.view = view;
    }

    /**
     * Tenta criar um novo produto.
     * @param nome O nome do produto.
     * @param preco O preço do produto.
     */
    public void criarProduto(String nome, double preco) {
        try {
            this.dao.adicionarProduto(nome, preco);
            this.view.mostrarMensagem("Produto adicionado com sucesso.");
        } catch (ValidacaoException e) {
            this.view.mostrarMensagem("Erro ao adicionar produto: " + e.getMessage());
        }
    }

    /**
     * Lista todos os produtos cadastrados.
     */
    public void listarProdutos() {
        List<Produto> produtos = this.dao.listarProdutos();
        this.view.listarProdutos(produtos);
    }

    /**
     * Tenta atualizar um produto existente.
     * @param id O ID do produto a ser atualizado.
     * @param novoNome O novo nome.
     * @param novoPreco O novo preço.
     */
    public void atualizarProduto(int id, String novoNome, double novoPreco) {
        try {
            boolean sucesso = this.dao.atualizarProduto(id, novoNome, novoPreco);
            if (sucesso) {
                this.view.mostrarMensagem("Produto atualizado com sucesso.");
            } else {
                this.view.mostrarMensagem("Produto não encontrado.");
            }
        } catch (ValidacaoException e) {
            this.view.mostrarMensagem("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    /**
     * Remove um produto pelo ID.
     * @param id O ID do produto a ser removido.
     */
    public void removerProduto(int id) {
        boolean sucesso = this.dao.removerProduto(id);
        if (sucesso) {
            this.view.mostrarMensagem("Produto removido com sucesso.");
        } else {
            this.view.mostrarMensagem("Produto não encontrado.");
        }
    }

    /**
     * Busca um produto pelo ID e exibe na view.
     * @param id O ID do produto a ser buscado.
     */
    public void buscarProduto(int id) {
        Produto p = this.dao.buscarPorId(id);
        this.view.mostrarProduto(p);
    }

    /**
     * Busca produtos por parte do nome e exibe na view.
     * @param nome A string de busca.
     */
    public void buscarProdutosPorNome(String nome) {
        List<Produto> produtosEncontrados = this.dao.buscarPorNome(nome);
        if (produtosEncontrados.size() == 1) {
            Produto unicoProduto = produtosEncontrados.get(0);
            this.view.mostrarProduto(unicoProduto);
        } else {
            this.view.listarProdutos(produtosEncontrados);
        }
    }
}
