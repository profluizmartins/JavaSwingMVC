package app.model;
import app.exception.ValidacaoException;
/**
 * Classe de domínio de Produto
 * @author Enzo Fonseca
 * @version 1.0
 *
 */
public class Produto {
    /** O identificador único do produto. */
    private int id;
    /** O nome do produto. */
    private String nome;
    /** O preço unitário do produto. */
    private double preco;

    /**
     * Construtor para criar um novo Produto.
     * @param id O ID do produto.
     * @param nome O nome do produto.
     * @param preco O preço do produto.
     * @throws ValidacaoException Se algum campo for inválido.
     */
    public Produto(int id, String nome, double preco) throws ValidacaoException {
        this.id = id; // O ID não tem validação de negócio neste contexto
        this.setNome(nome);
        this.setPreco(preco);
    }

    /**
     * Retorna o ID do produto.
     * @return O ID do produto.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Define o ID do produto.
     * @param id O novo ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o nome do produto.
     * @return O nome do produto.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Define o nome do produto.
     * @param nome O novo nome.
     * @throws ValidacaoException Se o nome for nulo ou vazio.
     */
    public void setNome(String nome) throws ValidacaoException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidacaoException("O nome do produto não pode ser vazio.");
        }
        this.nome = nome; // LINHA CORRIGIDA
    }

    /**
     * Retorna o preço do produto.
     * @return O preço do produto.
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * Define o preço do produto.
     * @param preco O novo preço.
     * @throws ValidacaoException Se o preço for negativo.
     */
    public void setPreco(double preco) throws ValidacaoException {
        if (preco < 0) {
            throw new ValidacaoException("O preço do produto não pode ser negativo.");
        }
        this.preco = preco; // LINHA CORRIGIDA
    }
}
