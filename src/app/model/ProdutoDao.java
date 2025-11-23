package app.model;
import java.util.ArrayList;
import java.util.List;
import app.exception.ValidacaoException;

/**
 * Classe de manipulação de DAO da Produto
 * Simula a persistência de dados em memória (ArrayList).
 * @author Enzo Fonseca
 * @version 1.0
 */
public class ProdutoDao {
    /** Lista de produtos armazenados em memória. */
    private List<Produto> produtos = new ArrayList<Produto>();
    /** Contador para gerar o próximo ID de produto. */
    private int proximoId = 1;

    /**
     * Adiciona um novo produto à lista.
     * @param nome O nome do produto.
     * @param preco O preço do produto.
     * @throws ValidacaoException Se os dados do produto forem inválidos.
     */
    public void adicionarProduto(String nome, double preco) throws ValidacaoException {
        // A validação ocorre no construtor de Produto
        Produto novoProduto = new Produto(this.proximoId, nome, preco);
        this.produtos.add(novoProduto);
        this.proximoId++;
    }
    /**
     * Retorna uma lista com todos os produtos.
     * @return Uma cópia da lista de produtos.
     */
    public List<Produto> listarProdutos() {
        return new ArrayList<Produto>(this.produtos);
    }
    /**
     * Atualiza o nome e o preço de um produto existente.
     * @param id O ID do produto a ser atualizado.
     * @param novoNome O novo nome do produto.
     * @param novoPreco O novo preço do produto.
     * @return true se o produto foi encontrado e atualizado, false caso contrário.
     * @throws ValidacaoException Se os novos dados do produto forem inválidos.
     */
    public boolean atualizarProduto(int id, String novoNome, double novoPreco) throws ValidacaoException {
        for (Produto p : this.produtos) {
            if (p.getId() != id) continue;
            // A validação ocorre nos setters de Produto
            p.setNome(novoNome);
            p.setPreco(novoPreco);
            return true;
        }
        return false;
    }
    /**
     * Remove um produto da lista pelo ID.
     * @param id O ID do produto a ser removido.
     * @return true se o produto foi encontrado e removido, false caso contrário.
     */
    public boolean removerProduto(int id) {
        return this.produtos.removeIf(p -> p.getId() == id);
    }
    /**
     * Busca um produto pelo ID.
     * @param id O ID do produto a ser buscado.
     * @return O objeto Produto encontrado ou null se não existir.
     */
    public Produto buscarPorId(int id) {
        for (Produto p : this.produtos) {
            if (p.getId() != id) continue;
            return p;
        }
        return null;
    }

    /**
     * Busca produtos cujo nome contenha a string de busca (case-insensitive).
     * @param nomeBusca A string de busca.
     * @return Uma lista de produtos encontrados.
     */
    public List<Produto> buscarPorNome(String nomeBusca) {
        ArrayList<Produto> encontrados = new ArrayList<Produto>();
        for (Produto p : this.produtos) {
            if (!p.getNome().toLowerCase().contains(nomeBusca.toLowerCase())) continue;
            encontrados.add(p);
        }
        return encontrados;
    }
}