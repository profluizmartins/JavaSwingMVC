package app.model;
import app.exception.UsuarioExeception;
/**
 * Classe de domínio de Usuario
 * @author Samuel Barbosa
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
     * @throws UsuarioExeception para tratamento de exceções
     */
	public Usuario(int id, String nome, String email) throws UsuarioExeception{
		super();
		this.setId(id);
		this.nome = nome;
		this.setEmail(email);
	}

    /**
     * Pega o Id do usuário
     * @return
     */
	public int getId() {
		return id;
	}
	
	/**
	 * Define o Id do usuário
	 * @version 2.0
     * @param id id a ser modificado
     * @throws UsuarioExeception exceção caso o id seja negativo
	 */
	public void setId(int id) throws UsuarioExeception {
		if(id < 0){
            throw new UsuarioExeception("Id menor que 0");
        }
        this.id = id;
	}

    /**
     * Pega o nome do usuário
     * @return
     */

	public String getNome() {
		return nome;
	}

    /**
     * Define o nome do usuário
     * @param nome
     */
	public void setNome(String nome) {
		this.nome = nome;
	}

    /**
     * Pega o email do usuário
     * @return
     */
    public String getEmail() {
		return email;
	}

    /**
     * Define o email do usuário
     * @param email
     * @throws UsuarioExeception exceção caso o email digitado seja inválido
     */
	public void setEmail(String email) throws UsuarioExeception{
		if (email == null || email.trim().equals("")) {
            throw new UsuarioExeception("Email não pode ser vazio");
        }if (!email.contains("@")) {
                throw new UsuarioExeception("Email precisa incluir o @.");
            }
        this.email = email;
        }

	}
    

