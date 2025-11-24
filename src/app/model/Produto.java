package app.model;

import app.exception.ProdutoException;

/**
 * Classe de domínio que representa um Produto.
 * 
 * Contém validações nos setters para garantir a integridade dos dados.
 * 
 * @author Maria Julia
 * @version 1.0
 */
public class Produto {

    private Integer id;
    private String nome;
    private double preco;
    private int estoque;

    /**
     * Construtor do Produto.
     * 
     * @param id      identificador do produto (pode ser null para novo cadastro)
     * @param nome    nome do produto
     * @param preco   preço do produto
     * @param estoque quantidade em estoque
     * 
     * @throws ProdutoException caso algum campo seja inválido
     */
    public Produto(Integer id, String nome, double preco, int estoque) throws ProdutoException {
        setId(id);
        setNome(nome);
        setPreco(preco);
        setEstoque(estoque);
    }

    /** @return id do produto */
    public Integer getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     * 
     * @param id identificador
     * @throws ProdutoException se id for negativo
     */
    public void setId(Integer id) throws ProdutoException {
        if (id != null && id < 0)
            throw new ProdutoException("ID inválido");
        this.id = id;
    }

    /** @return nome do produto */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     * 
     * @param nome nome
     * @throws ProdutoException se nome for vazio ou nulo
     */
    public void setNome(String nome) throws ProdutoException {
        if (nome == null || nome.trim().isEmpty())
            throw new ProdutoException("Nome inválido");
        this.nome = nome.trim();
    }

    /** @return preço do produto */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     * 
     * @param preco valor
     * @throws ProdutoException se preço for menor que zero
     */
    public void setPreco(double preco) throws ProdutoException {
        if (preco < 0)
            throw new ProdutoException("Preço inválido");
        this.preco = preco;
    }

    /** @return estoque do produto */
    public int getEstoque() {
        return estoque;
    }

    /**
     * Define o estoque.
     * 
     * @param estoque quantidade
     * @throws ProdutoException se estoque for negativo
     */
    public void setEstoque(int estoque) throws ProdutoException {
        if (estoque < 0)
            throw new ProdutoException("Estoque inválido");
        this.estoque = estoque;
    }
}
