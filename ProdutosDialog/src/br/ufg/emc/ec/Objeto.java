package br.ufg.emc.ec;

/**
 * Classe que representa um produto no sistema.
 * Armazena informações como ID, nome e preço.
 * 
 * @author Diego
 * @version 1.0
 */

public class Objeto {

    private String id;
    private String nome;
    private String preco;

    /**
     * Construtor para criar um novo produto.
     * 
     * @param id Código identificador do produto
     * @param nome Nome do produto
     * @param preco Preço do produto
     * @throws IllegalArgumentException se algum parâmetro for nulo ou vazio
     */
    
    public Objeto(String id, String nome, String preco) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID não pode ser nulo ou vazio");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (preco == null || preco.trim().isEmpty()) {
            throw new IllegalArgumentException("Preço não pode ser nulo ou vazio");
        }
        
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    
    public String getId() {
        return id;
    }

   
    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID não pode ser nulo ou vazio");
        }
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    
    public String getPreco() {
        return preco;
    }

    
    public void setPreco(String preco) {
        if (preco == null || preco.trim().isEmpty()) {
            throw new IllegalArgumentException("Preço não pode ser nulo ou vazio");
        }
        this.preco = preco;
    }

    
    public String toString() {
        return "Produto [ID=" + id + ", Nome=" + nome + ", Preço=R$ " + preco + "]";
    }
}
