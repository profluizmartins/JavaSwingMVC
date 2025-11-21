package pckg.model;

/**
 * Classe de usuáriossstoptop
 * @author Rafael S.Lemes
 * @version 1.0
 */
public class Usuario {
    /** ID */
    private int id;
    /** nome né */
    private String nome;
    /** endereço de email */
    private String email;
    
    /**
     * Construtor com validação de dados
     * @param id
     * @param nome
     * @param email
     * @throws IllegalArgumentException Se nome ou email forem inválidos
     */
    public Usuario(int id,String nome,String email){
        super();
        if(nome==null||nome.trim().isEmpty())throw new IllegalArgumentException("Nome não pode ser vazio");
        if(email==null||email.trim().isEmpty())throw new IllegalArgumentException("Email não pode ser vazio");
        this.id=id;this.nome=nome;this.email=email;
    }
    /** Lê o ID * @return O número inteiro representando o ID */
    public int getId(){return id;}
    /** Define um ID * @param id O novo número de ID */
    public void setId(int id){this.id=id;}
    /** Lê o nome * @return A String contendo o nome */
    public String getNome(){return nome;}
    
    /** * Define um nome com validação
     * @param nome
     * @throws IllegalArgumentException Se o nome for vazio ou nulo
     */
    public void setNome(String nome){
        if(nome==null||nome.trim().isEmpty())throw new IllegalArgumentException("Nome inválido");
        this.nome=nome;
    }
    /** Lê um email* @return A String contendo o email */
    public String getEmail(){return email;}
    
    /** Define um email com validação
     * @param email 
     * @throws IllegalArgumentException Se o email for vazio ou nulo
     */
    public void setEmail(String email){
        if(email==null||email.trim().isEmpty())throw new IllegalArgumentException("Email inválido");
        this.email=email;
    }
}