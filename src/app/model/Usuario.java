package app.model;
/**
 * Classe de domínio de Usuario
 * @author João Pedro
 * @version 1.0
 * 
 */
public class Usuario {
	private int id;
    private String nome;
    private String email;
    /**
     * Classe contrutora
     * @param id Identificador do Usuário
     * @param nome Nome do Usuário
     * @param email Email do Usuário
     */
	public Usuario(int id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
