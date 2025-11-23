package app.controller;

import java.util.List;

import app.exception.*;
import app.model.*;
import app.model.*;
import app.view.*;


/**
 * @author Luiz Martins
 * Classe domínio de UsuarioController
 * @version 1.0
 */
public class UsuarioController {
	private UsuarioDao dao;
	private UsuarioView view;


	/**
	 * Classe construtora
	 * @param dao
	 * @param view
	 */
	public UsuarioController(UsuarioDao dao, UsuarioView view) {
		this.dao = dao;
		this.view = view;
	}


	/**
	 * Classe controle de criação de Usuario
	 * @param nome
	 * @param email
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
	 * Classe controle de criação de Usuario
	 */
	public void listarUsuarios() {
		List<Usuario> usuarios = dao.listarUsuarios();
		view.listarUsuarios(usuarios);
	}


/**
 * Classe controle de atualizar dados de Usuario
 * @param id
 * @param novoNome
 * @param novoEmail
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
	 * Classe controle de remover Usuario
	 * @param id
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
	 * Classe controle de buscar Usuario
	 * @param id
	 */
	public void buscarUsuario(int id) {
		Usuario u = dao.buscarPorId(id);
		view.mostrarUsuario(u);
	}
}
