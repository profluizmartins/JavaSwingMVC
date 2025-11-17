package app.model;

import app.exception.UsuarioExeception;

/**
 * Classe de domínio de Usuario
 * @author Luiz Martins
 * @version 1.0
 * 
 */
public class Usuario {
	private int id;
    private String nome;
    private String email;
    /**
     * Método contrutor de Usuário
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
    /**
     * Método de pegar o id do Usuario
     *
     * @return id quando usado
     */
	public int getId() {
		return id;
	}

    /**
     * Método de setar o id do Usuario
     *
     * @param id Novo Identificador do Usuário
     */
	public void setId(int id) {
		this.id = id;
	}
    /**
     * Método de pegar o nome do Usuario
     *
     * @return nome quando usado
     */
	public String getNome() {
		return nome;
	}
    /**
     * Método de setar o nome do Usuario
     *
     * @param nome Novo Nome do Usuario
     */
	public void setNome(String nome) {
		this.nome = nome;
	}
    /**
     * Método de pegar o email do Usuario
     *
     * @return email quando usado
     */
	public String getEmail() {
		return email;
	}
    /**
     * Método de setar o email do Usuario
     *
     * @param email Novo Email do Usuario
     */
	public void setEmail(String email) {
		this.email = email;
	}
    
}
