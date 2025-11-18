package app.model;
/**
* Classe para criação de produtos
* @author Arthur Souza
* @version 1.0
 **/
public class Produto {
    private int id;
    private String nome;
    private Double preco;
/**
* Classe Contrutora
* @param id Identificador do produto
* @param nome Nome do produto
* @param preco Preço do produto
 **/
    public Produto(int id, String nome, Double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
/**
* Getters e Setters para cada atributo da classe Produto
 **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
