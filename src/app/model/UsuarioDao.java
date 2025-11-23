package app.model;

import java.util.ArrayList;
import java.util.List;

import app.exception.UsuarioExeception;

/**
 * Classe de manipulação de DAO da Usuário
 * 
 * @author GuilhermeHolanda
 * @version 2.0
 */
public class UsuarioDao {

    private List<Usuario> usuarios = new ArrayList<>();
    private int proximoId = 1;

    /**
     * Adiciona um novo usuário após validar nome e email.
     *
     * @param nome  nome do usuário
     * @param email email do usuário
     * @throws UsuarioExeception caso os dados sejam inválidos
     */
    public void adicionarUsuario(String nome, String email) throws UsuarioExeception {

        if (nome == null || nome.length() < 2)
            throw new UsuarioExeception("Nome inválido");

        if (email == null || email.length() < 5 || !email.contains("@") || !email.contains("."))
            throw new UsuarioExeception("Email inválido");

        usuarios.add(new Usuario(proximoId++, nome, email));
    }

    /**
     * @return lista completa de usuários cadastrados
     */
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    /**
     * Atualiza dados de um usuário existente.
     *
     * @param id        identificador
     * @param novoNome  novo nome
     * @param novoEmail novo email
     * @return true se atualizado, false se não encontrado
     * @throws UsuarioExeception caso os novos dados sejam inválidos
     */
    public boolean atualizarUsuario(int id, String novoNome, String novoEmail) throws UsuarioExeception {
        if (id <= 0)
            throw new UsuarioExeception("ID inválido");

        if (novoNome == null || novoNome.length() < 2)
            throw new UsuarioExeception("Nome inválido");

        if (novoEmail == null || novoEmail.length() < 5 || !novoEmail.contains("@") || !novoEmail.contains("."))
            throw new UsuarioExeception("Email inválido");

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
     * Remove um usuário pelo ID.
     *
     * @param id identificador
     * @return true se removido, false caso não exista
     */
    public boolean removerUsuario(int id) {
        return usuarios.removeIf(u -> u.getId() == id);
    }

    /**
     * Busca um usuário pelo ID.
     *
     * @param id identificador
     * @return usuário encontrado ou null
     */
    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id)
                return u;
        }
        return null;
    }
}
