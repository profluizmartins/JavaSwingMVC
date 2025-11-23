package app.model;

import app.exception.UsuarioExeception;

/**
 * Classe de domínio que representa um usuário.
 * Contém validações e dados essenciais.
 *
 * @author GuilhermeHolanda
 * @version 2.0
 */
public class Usuario {

    private int id;
    private String nome;
    private String email;

    /**
     * Construtor do usuário com validação.
     *
     * @param id    identificador
     * @param nome  nome do usuário
     * @param email email do usuário
     * @throws UsuarioExeception caso algum valor seja inválido
     */
    public Usuario(int id, String nome, String email) throws UsuarioExeception {

        if (id <= 0)
            throw new UsuarioExeception("ID inválido.");

        if (nome == null || nome.trim().length() < 2)
            throw new UsuarioExeception("Nome inválido.");

        if (email == null || email.trim().length() < 5)
            throw new UsuarioExeception("Email inválido.");

        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    /** @return id do usuário */
    public int getId() {
        return id;
    }

    /** Define novo ID */
    public void setId(int id) {
        this.id = id;
    }

    /** @return nome do usuário */
    public String getNome() {
        return nome;
    }

    /** Define novo nome */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** @return email do usuário */
    public String getEmail() {
        return email;
    }

    /** Define novo email */
    public void setEmail(String email) {
        this.email = email;
    }
}