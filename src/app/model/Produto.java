package Aula08;

/**
 * Classe model de produtos.
 */
public class Produto {
    private int id;
    private String nome;
    private double preco;

    /**
     * Método construtor de produto
     * @param id id do produto
     * @param nome nome do produto
     * @param preco preço do produto
     */
    public Produto(int id, String nome, double preco){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

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

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return  "\nID: " + id +
                "\nNome: " + nome +
                "\nPreço: R$" + preco +
                "\n-====================-";
    }
}
