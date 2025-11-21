package pckg.model;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO
 * @author Rafael S.Lemes
 * @version 1.0
 */
public class UsuarioDao {
    
    /** Lista em memória que armazena os usuários */
    private List<Usuario>usuarios=new ArrayList<Usuario>();
    /** Contador para gerar IDs automaticamente */
    private int proximoId=1;
    
    /** Construtor*/
    public UsuarioDao() {
        super();
        usuarios.add(new Usuario(proximoId++,"Paulino Loko d+ Martins","luizmartins@ufg.br"));
        usuarios.add(new Usuario(proximoId++,"Fulano Irineu","fulano@ufg.br"));
        usuarios.add(new Usuario(proximoId++,"Ciclano Rochoso pleno","ciclano@ufg.br"));
        usuarios.add(new Usuario(proximoId++,"Papa chumbo","papador@gmail.com"));
        usuarios.add(new Usuario(proximoId++,"Oi professor :)","professorMinoxidil@ufg.br"));
        usuarios.add(new Usuario(proximoId++,"Cara com Alzheimer","senha1234@ufg.br"));
        usuarios.add(new Usuario(proximoId++,"Cara com Alzheimer","senha1234@ufg.br"));
        usuarios.add(new Usuario(proximoId++,"Cara com Alzheimer","senha1234@ufg.br"));
        usuarios.add(new Usuario(proximoId++,"vinhado","maluyco@ufg.br"));
    }
    /**
     * Adiciona um novo usuário pra lista
     * Gera um novo ID com base no contador interno
     * @param usuario Objeto contendo os dados
     * @throws IllegalArgumentException Se o usuário fornecido for nulo
     */
    public void addUsuario(Usuario usuario){
        if(usuario==null)throw new IllegalArgumentException("Usuário não pode ser nulo");
        usuarios.add(new Usuario(proximoId++,usuario.getNome(),usuario.getEmail()));}
    /**
     * Retorna a lista completa de usuários
     * @return Uma lista contendo todos os usuários
     */
    public List<Usuario> listarUsuarios() {return usuarios;}
    /**
     * Atualiza os dados de um usuário
     * @param usuario Objeto contendo o ID do usuário a ser atualizado e os novos dados
     * @return true se o usuário foi encontrado e atualizado, false caso contrário
     * @throws IllegalArgumentException Se o objeto usuário for nulo
     */
    public boolean attUsuario(Usuario usuario){
        if(usuario==null)throw new IllegalArgumentException("Dados inválidos para atualização");
        for (Usuario u:usuarios){
            if(u.getId()==usuario.getId()){
                u.setNome(usuario.getNome());u.setEmail(usuario.getEmail());return true;}
        }
        return false;
    }
    /**
     * Remove um usuário da lista
     * @param id
     * @return true se algum elemento foi removido, false caso contrário
     */
    public boolean rmUsuario(int id){return usuarios.removeIf(u->u.getId()==id);}
    /**
     * Busca um usuário
     * @param id
     * @return O objeto Usuario se encontrado, ou null se não existir
     */
    public Usuario buscarPorId(int id){
        for(Usuario u:usuarios){if(u.getId()==id)return u;}
        return null;
    }
}