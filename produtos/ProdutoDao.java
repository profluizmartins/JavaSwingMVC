
import java.util.ArrayList;

import java.util.List;
/**
 * Classe DAO.  
 * @since 1.0
 */
public class ProdutoDao {
    /**
     * ArrayList para cadastrar produtos
     */
	private List<Produto> produtos = new ArrayList<Produto>();
    /**
     * Indicador do próximo id
     */
    private int proximoId = 1;
    
    /** 
     * Adicona um produto ao ArrayList de produtos
     * @param nome Nome do produto
     * @param preco Preço do produto
     * @throws DadosInvalidosException se o nome não for preenchido, ou se ou preço for menor ou igual a zero ou "null".
    */
    public void adicionarProduto (String nome, Double preco) throws DadosInvalidosException{
        if(nome.length()==0){
            throw new DadosInvalidosException("O nome deve ser preenchido. Digite novamente o nome.");
        }
        if(preco<=0){
            throw new DadosInvalidosException("O preço deve ser maior que zero. Digite novamente o preço.");
        }
        produtos.add(new Produto(proximoId++, nome, preco));
    }
    /**
     * Retorna uma lista de produtos
     * @return Lista de produtos
     */
    
    public List<Produto> listarProdutos() {
        return produtos;}

    /**
     * Atualiza um produto cadastrado, usando os métodos getter e setter da classe produto.
     * @param id ID do produto
     * @param novoNome Novo nome
     * @param novoPreco Novo preço
     * @return true em caso de sucesso, false para indicar que o produto não foi atualizado.
     * @throws DadosInvalidosException se o nome não for preenchido, ou se ou preço for menor ou igual a zero, ou ID não for um inteiro positivo.
     */
    public boolean atualizarProduto(Integer id, String novoNome, Double novoPreco) throws DadosInvalidosException{
        if(novoNome.length()==0){
         throw new DadosInvalidosException("O nome deve ser preenchido. Digite novamente o nome.");   
        }
        if(novoPreco<=0){
            throw new DadosInvalidosException("O preço deve ser maior que zero. Digite novamente o preço.");
        }
        if(id<=0){
            throw new DadosInvalidosException("O ID deve ser um inteiro positivo. Digite novamente o ID.");
        }
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setNome(novoNome);
                p.setPreco(novoPreco);
                return true;
            }
        }
        return false;
    }
    /**
     * Remove um produto cadastrado.
     * @param id ID do produto
     * @return true em caso de sucesso, false para indicar que o produto não foi atualizado.
     * @throws DadosInvalidosException caso o ID não seja um inteiro positivo.
     */
    public boolean removerProduto(int id) throws DadosInvalidosException{
        if(id<=0){
            throw new DadosInvalidosException("O ID deve ser um inteiro positivo. Digite novamente o ID.");
        }
        return produtos.removeIf(p -> p.getId() == id);
    }
 /**
  * Busca um produto por ID.
  * @param id ID do produto
  * @return o produto em caso de sucesso, nada em caso de erro
  * @throws DadosInvalidosException caso o ID não seja um inteiro positivo.
  */
    public Produto buscarPorId(int id) throws DadosInvalidosException {
        if(id<=0){
            throw new DadosInvalidosException("O ID deve ser um inteiro positivo. Digite novamente o ID.");
        }
        for (Produto p : produtos){
            if (p.getId() == id) {return p;}
        }
        return null;
    }
    /**
     * Busca um produto por nome
     * @param nome Nome do produto
     * @return o produto em caso de sucesso, nada em caso de erro
     * @throws DadosInvalidosException se o nome não for preenchido, ou se ou preço for menor ou igual a zero ou "null".
     */
    public Produto buscarPorNome(String nome) throws DadosInvalidosException{
        if(nome.length()==0){
            throw new DadosInvalidosException("O nome deve ser preenchido. Digite novamente o nome.");
        }
        for(Produto p: produtos){
            if(p.getNome().equals(nome)){return p;} 
        }
        return null;
    }
}
