
/**
 * Classe de produtos
 * @since 1.0
 */
public class Produto {
	/**
	 * Número de identificação do produto
	 */
	private int id;
	/**
	 * Nome do produto
	 */
    private String nome;
	/**
	 * Preço do produto
	 */
    private double preco;

	/**
	 * Método construtor de um produto
	 * @param id Número de identificação do produto
	 * @param nome Nome do produto
	 * @param preco Preço do produto
	 * @since 1.0
	 */
	public Produto(int id, String nome, double preco) {
		this.id = id;
		this.nome = nome;
		this.preco=preco;
	}
	/**
	 *  Getter para obter o ID 
	 * @return id Retorna número de identificação
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter para atualizar o ID
	 * @param id Novo ID
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter para obter nome
	 * @return Retorna nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Setter para atualizar nome
	 * @param nome Novo nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Getter para obter preço
	 * @return Retorna o preço
	 */
	public double getPreco(){
	 return this.preco;   
	} 
	/**
	 * Setter para atualizar preço
	 * @param preco2 Novo preço
	 */
    public void setPreco(double preco2){
    this.preco=preco2;	    
    }

}
