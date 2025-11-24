package Aula08;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe DAO de usuários
 */
public class UsuarioDao {
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private int proximoId = 1;

    /**
     * Método para criar um usuáro na base de dados.
     * @param nome nome usuário.
     * @param email email usuário.
     */
    public void adicionarUsuario(String nome, String email) {
        usuarios.add(new Usuario(proximoId++, nome, email));
    }

    /**
     * Método para retornar o banco de dados de usuários
     * @return retorna o banco de dados de usuários
     */
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    /**
     * Método para atualizar um usuário no banco de dados
     * @param id ID do usuário a ser atualizado
     * @param novoNome novo nome
     * @param novoEmail novo email
     * @return retorna true se for atualizado e false se não for
     */
    public boolean atualizarUsuario(int id, String novoNome, String novoEmail) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                u.setNome(novoNome);
                u.setEmail(novoEmail);
                return true;
            }
        }
        return false;
    }

    /**
     * Método para remover um usuário do banco de dados
     * @param id ID do usuário a ser removido
     * @return retorna true se o usuário for removido e false se não for
     */
    public boolean removerUsuario(int id) {
        return usuarios.removeIf(u -> u.getId() == id);
    }

    /**
     * Método para buscar no banco de dados um usuário pelo ID
     * @param id ID do usuário a ser encontrado
     * @return usuário encontrado
     */
    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}

