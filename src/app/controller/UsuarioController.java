package app.controller;

import java.util.List;

import app.exception.UsuarioExeception;
import app.model.Usuario;
import app.model.UsuarioDao;
import app.view.UsuarioView;

/**
 * Classe de manipulação de Controller da Usuario
 * @author Rômulo Henrique
 * @version 1.0
 *
 */
public class UsuarioController {
	private UsuarioDao dao;
	private UsuarioView view;

    /**
     * Classe contrutora
     * @param dao Parte do Dao do programa
     * @param view Parte do View do programa
     */
	public UsuarioController(UsuarioDao dao, UsuarioView view) {
		this.dao = dao;
		this.view = view;
	}

    /**
     * Método de chamar o criar um usuário banco de dados
     *
     * @param nome  Nome do usuário
     * @param email Email do usuário
     * @throws UsuarioExeception verificar se nome e email do usuário estao corretos
     */
	public void criarUsuario(String nome, String email) {
		try {
			dao.adicionarUsuario(nome, email);
			view.mostrarMensagem("Usuário adicionado com sucesso.");
		} catch (UsuarioExeception e) {
			view.mostrarMensagem("Não foi possivel criar usuário: "+e.getMessage());
		}
	}

    /**
     * Método de chamar a listagem dos usuários do banco de dados
     *
     *
     *
     */
	public void listarUsuarios() {
		List<Usuario> usuarios = dao.listarUsuarios();
		view.listarUsuarios(usuarios);
	}

    /**
     * Método de chamar a atualização do usuário do banco de dados
     * @param id Identificador do usuário
     * @param novoEmail Novo email do usuário
     * @param novoNome Novo nome do usuário
     *
     * @throws UsuarioExeception verificar se o novo nome e novo email do usuário estão corretos
     */
	public void atualizarUsuario(int id, String novoNome, String novoEmail) {
		boolean sucesso = false;
		try {
			sucesso = dao.atualizarUsuario(id, novoNome, novoEmail);
		} catch (UsuarioExeception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sucesso) {
			view.mostrarMensagem("Usuário atualizado com sucesso.");
		} else {
			view.mostrarMensagem("Usuário não encontrado.");
		}
	}

    /**
     * Método de chamar a remoção do usuário do banco de dados
     * @param id Identificador do Usuário
     *
     * @throws UsuarioExeception verificar se o id do usuário estão corretos para a remoção
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
     * Método de chamar a busca do usuário do banco de dados
     * @param id Identificador do Usuário
     *
     * @throws UsuarioExeception verificar se o id do usuário estão corretos para a busca
     */
	public void buscarUsuario(int id) {
		Usuario u = dao.buscarPorId(id);
		view.mostrarUsuario(u);
	}
}
