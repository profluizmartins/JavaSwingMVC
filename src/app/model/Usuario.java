package Aula08;

/**
 * Classe model de usuários.
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;

    /**
     * Método construtor de usuário
     * @param id id do usuário
     * @param nome nome do usuário
     * @param email email do usuário
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
