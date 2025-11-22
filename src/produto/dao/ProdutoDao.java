package produto.dao;

import java.util.ArrayList;
import java.util.List;

import produto.model.Produto;

/**
 * Classe responsável por armazenar, gerenciar e manipular os dados
 * referentes aos produtos cadastrados na aplicação.
 *
 * <p>
 * Os dados são mantidos em memória através de uma lista, simulando um
 * repositório simples. Esta classe oferece operações de CRUD:
 * adicionar, listar, atualizar, remover e buscar produtos.
 * </p>
 *
 * @author Luiz Lima
 * @version 1.0
 * @see produto.model.Produto
 */
public class ProdutoDao {

    private List<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    /**
     * Construtor padrão da classe ProdutoDao.
     * Inicializa a lista interna de produtos.
     */
    public ProdutoDao() {
    }

    /**
     * Adiciona um novo produto ao repositório.
     * O ID é gerado automaticamente.
     *
     * @param produto objeto Produto contendo nome e preço
     */
    public void adicionarProduto(Produto produto) {
        produtos.add(new Produto(proximoId++, produto.getNome(), produto.getPreco()));
    }

    /**
     * Retorna a lista completa de produtos cadastrados.
     *
     * @return lista de objetos Produto
     */
    public List<Produto> listarProdutos() {
        return produtos;
    }

    /**
     * Atualiza os dados de um produto existente.
     *
     * @param produto objeto contendo ID, nome e preço atualizados
     * @return true se o produto foi encontrado e atualizado; false caso contrário
     */
    public boolean atualizarProduto(Produto produto) {
        for (Produto p : produtos) {
            if (p.getId() == produto.getId()) {
                p.setNome(produto.getNome());
                p.setPreco(produto.getPreco());
                return true;
            }
        }
        return false;
    }

    /**
     * Remove um produto da lista com base no ID informado.
     *
     * @param id identificador do produto a ser removido
     * @return true se o produto foi removido; false se não foi encontrado
     */
    public boolean removerProduto(int id) {
        return produtos.removeIf(p -> p.getId() == id);
    }

    /**
     * Busca um produto pelo seu ID.
     *
     * @param id identificador do produto
     * @return objeto Produto encontrado ou null se não existir
     */
    public Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
