package Aula08;

import java.util.List;

/**
 * Classe Controller de usuários
 */
public class UsuarioController {
    private UsuarioDao dao;
    private UsuarioView view;

    /**
     * Método Construtor
     * @param dao Dao a ser vinculado ao controller
     * @param view View a ser vinculado ao controller
     */
    public UsuarioController(UsuarioDao dao, UsuarioView view) {
        this.dao = dao;
        this.view = view;
    }

    /**
     * Método para criar um usuário
     * @param nome nome do usuário
     * @param email email do usuário
     */
    public void criarUsuario(String nome, String email) {
        dao.adicionarUsuario(nome, email);
        view.mostrarMensagem("Usuário adicionado com sucesso.");
    }

    /**
     * Método para listar usuários
     */
    public void listarUsuarios() {
        List<Usuario> usuarios = dao.listarUsuarios();
        view.listarUsuarios(usuarios);
    }

    /**
     * Método para atualizar um usuário
     * @param id ID do usuário a ser atualizado
     * @param novoNome novo nome
     * @param novoEmail novo email
     */
    public void atualizarUsuario(int id, String novoNome, String novoEmail) {
        boolean sucesso = dao.atualizarUsuario(id, novoNome, novoEmail);
        if (sucesso) {
            view.mostrarMensagem("Usuário atualizado com sucesso.");
        } else {
            view.mostrarMensagem("Usuário não encontrado.");
        }
    }

    /**
     * Método para remover um usuário
     * @param id ID do usuário a ser removido
     */
    public void removerUsuario(int id) {
        boolean sucesso = dao.removerUsuario(id);
        if (sucesso) {
            view.mostrarMensagem("Usuário removido com sucesso.");
        } else {
            view.mostrarMensagem("Usuário não encontrado.");
        }
    }

    /**
     * Método para buscar um usuário pelo ID
     * @param id ID do usuário a ser encontrado
     */
    public void buscarUsuario(int id) {
        Usuario u = dao.buscarPorId(id);
        view.mostrarUsuario(u);
    }
}
