package app.controller;

import java.util.List;
import app.exception.UsuarioExeception;
import app.model.Usuario;
import app.model.UsuarioDao;
import app.view.UsuarioView;

/**
 * Controlador responsável por gerenciar operações de usuários.
 * Aplica regras de negócio e manipula DAO e View.
 *
 * @author GuilhermeHolanda
 * @version 2.0
 * 
 */
public class UsuarioController {

    private UsuarioDao dao;
    private UsuarioView view;

    /**
     * Construtor do controlador.
     *
     * @param dao objeto de acesso aos dados dos usuários
     * @param view interface para exibição das informações
     */
    public UsuarioController(UsuarioDao dao, UsuarioView view) {
        this.dao = dao;
        this.view = view;
    }

    /**
     * Cria um novo usuário no sistema.
     *
     * @param nome  nome do usuário
     * @param email email do usuário
     */
    public void criarUsuario(String nome, String email) {
        try {
            dao.adicionarUsuario(nome, email);
            view.mostrarMensagem("Usuário adicionado com sucesso.");
        } catch (UsuarioExeception e) {
            view.mostrarMensagemErro("Não foi possível criar usuário: " + e.getMessage());
        }
    }

    /**
     * Lista todos os usuários cadastrados.
     */
    public void listarUsuarios() {
        List<Usuario> usuarios = dao.listarUsuarios();
        view.listarUsuarios(usuarios);
    }

    /**
     * Atualiza um usuário existente.
     *
     * @param id        identificador do usuário
     * @param novoNome  novo nome
     * @param novoEmail novo email
     */
    public void atualizarUsuario(int id, String novoNome, String novoEmail) {
        try {
            boolean sucesso = dao.atualizarUsuario(id, novoNome, novoEmail);
            if (sucesso) {
                view.mostrarMensagem("Usuário atualizado com sucesso.");
            } else {
                view.mostrarMensagemErro("Usuário não encontrado.");
            }
        } catch (UsuarioExeception e) {
            view.mostrarMensagemErro("Erro ao atualizar usuário: " + e.getMessage());
        }
    }

    /**
     * Remove um usuário pelo ID.
     *
     * @param id identificador do usuário
     */
    public void removerUsuario(int id) {
        boolean sucesso = dao.removerUsuario(id);
        if (sucesso) {
            view.mostrarMensagem("Usuário removido com sucesso.");
        } else {
            view.mostrarMensagemErro("Usuário não encontrado.");
        }
    }

    /**
     * Busca e exibe um usuário pelo ID.
     *
     * @param id identificador do usuário
     */
    public void buscarUsuario(int id) {
        Usuario u = dao.buscarPorId(id);
        view.mostrarUsuario(u);
    }
}