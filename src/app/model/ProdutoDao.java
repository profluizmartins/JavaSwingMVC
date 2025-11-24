package Aula08;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO de produtos
 */
public class ProdutoDao {
    private List<Produto> produtos = new ArrayList<Produto>();
    private int proxID = 1;

    /**
     * Método para validar a entrada de dados na criação ou atualização de produtos
     * @param nome nome do produto
     * @param preco preço do produto
     * @throws ProdutoException caso os dados sejam inválidos
     */
    private void validarDadosProduto(String nome, double preco) throws ProdutoException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ProdutoException("O nome do produto não pode ser vazio.");
        }
        if (preco < 0) {
            throw new ProdutoException("O preço do produto não pode ser negativo.");
        }
    }

    /**
     * Método para adicionar um produto ao banco de dados
     * @param nome nome do produto
     * @param preco preço do produto
     * @throws ProdutoException caso os dados sejam inválidos
     */
    public void addProduto(String nome, double preco) throws ProdutoException {
        validarDadosProduto(nome, preco);
        Produto p = new Produto(proxID++, nome, preco);
        produtos.add(p);
    }

    /**
     * Método para retornar o banco de dados de produtos
     * @return retorna o banco de dados
     */
    public List<Produto> listarProdutos() {
        return produtos;
    }

    /**
     * Método para atualizar um produto no banco de dados
     * @param id ID do produto a ser atualizado
     * @param newNome novo nome
     * @param newPreco novo preço
     * @throws ProdutoException caso os dados sejam inválidos
     */
    public void updateProduto(int id, String newNome, double newPreco) throws ProdutoException {
        validarDadosProduto(newNome, newPreco);
        Produto p = buscaProdutoId(id);

        p.setNome(newNome);
        p.setPreco(newPreco);
    }

    /**
     * Método para excluir um produto no banco de dados
     * @param id ID do produto a ser excluido
     * @throws ProdutoException caso o produto não seja encontrado
     */
    public void removeProduto(int id) throws ProdutoException {
        Produto p = buscaProdutoId(id);
        produtos.remove(p);
    }

    /**
     * Método para buscar um produto pelo ID no banco de dados
     * @param id ID do produto a ser buscado
     * @return produto encontrado
     * @throws ProdutoException caso o produto não seja encontrado
     */
    public Produto buscaProdutoId(int id) throws ProdutoException {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new ProdutoException("Produto com ID " + id + " não encontrado no sistema.");
    }

    /**
     * Método para buscar um produto pelo nome no banco de dados
     * @param nome nome do produto a ser buscado
     * @return produto encontrado
     * @throws ProdutoException caso o produto não seja encontrado
     */
    public Produto buscaProdutoNome(String nome) throws ProdutoException {
        for (Produto p : produtos){
            if(p.getNome().equalsIgnoreCase(nome)){
                return p;
            }
        }
        throw new ProdutoException("Produto com o nome '" + nome + "' não encontrado.");
    }
}
