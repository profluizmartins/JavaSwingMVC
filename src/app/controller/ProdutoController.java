package Aula08;

import java.util.List;

/**
 * Classe Controller de produtos
 */
public class ProdutoController {
    private ProdutoDao dao;
    private ProdutoView view;

    /**
     * Método Construtor
     * @param dao Dao a ser vinculado ao controller
     * @param view View a ser vinculado ao controller
     */
    public ProdutoController(ProdutoDao dao, ProdutoView view){
        this.dao = dao;
        this.view = view;
    }

    /**
     * Método para criar um produto
     * @param nome nome do produto
     * @param preco preço do produto
     */
    public void criarProduto(String nome, double preco) {
        try {
            dao.addProduto(nome, preco);
            view.mostrarMsg("Produto cadastrado com sucesso!");
        } catch (ProdutoException e) {
            view.mostrarMsg("Erro: " + e.getMessage());
        }
    }

    /**
     * Método para listar os produtos do DAO associado
     */
    public void listarProdutos(){
        List<Produto> produtos = dao.listarProdutos();
        view.listarProdutos(produtos);
    }

    /**
     * Método para atualizar um produto existente
     * @param id id do produto a ser atualizado
     * @param newNome novo nome
     * @param newPreco novo preço
     */
    public void atualizarProduto(int id, String newNome, double newPreco) {
        try {
            dao.updateProduto(id, newNome, newPreco);
            view.mostrarMsg("Produto atualizado com sucesso!");
        } catch (ProdutoException e) {
            view.mostrarMsg("Erro: " + e.getMessage());
        }
    }

    /**
     * Método para remover um produto
     * @param id id do produto a ser removido
     */
    public void removerProduto(int id) {
        try {
            dao.removeProduto(id);
            view.mostrarMsg("Produto removido com sucesso!");
        } catch (ProdutoException e) {
            view.mostrarMsg("Erro: " + e.getMessage());
        }
    }

    /**
     * Método para buscar produto por ID
     * @param id id do produto a ser buscado
     */
    public void buscarProdutoId(int id) {
        try {
            Produto p = dao.buscaProdutoId(id);
            view.mostrarProduto(p);
        } catch (ProdutoException e) {
            view.mostrarMsg("Erro: " + e.getMessage());
        }
    }

    /**
     * Método para buscar produto pelo nome
     * @param nome nome do produto a ser buscado
     */
    public void buscarProdutoNome(String nome){
        try {
            Produto p = dao.buscaProdutoNome(nome);
            view.mostrarProduto(p);
        } catch (ProdutoException e) {
            view.mostrarMsg("Erro: " + e.getMessage());
        }
    }
}
