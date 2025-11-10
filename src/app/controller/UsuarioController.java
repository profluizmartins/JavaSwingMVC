package app.controller;

import java.util.List;

import app.model.Usuario;
import app.model.UsuarioDao;
import app.view.UsuarioView;

public class UsuarioController {
	private UsuarioDao dao;
	private UsuarioView view;

	public UsuarioController(UsuarioDao dao, UsuarioView view) {
		this.dao = dao;
		this.view = view;
	}

	public void criarUsuario(String nome, String email) {
		dao.adicionarUsuario(nome, email);
		view.mostrarMensagem("Usuário adicionado com sucesso.");
	}

	public void listarUsuarios() {
		List<Usuario> usuarios = dao.listarUsuarios();
		view.listarUsuarios(usuarios);
	}

	public void atualizarUsuario(int id, String novoNome, String novoEmail) {
		boolean sucesso = dao.atualizarUsuario(id, novoNome, novoEmail);
		if (sucesso) {
			view.mostrarMensagem("Usuário atualizado com sucesso.");
		} else {
			view.mostrarMensagem("Usuário não encontrado.");
		}
	}

	public void removerUsuario(int id) {
		boolean sucesso = dao.removerUsuario(id);
		if (sucesso) {
			view.mostrarMensagem("Usuário removido com sucesso.");
		} else {
			view.mostrarMensagem("Usuário não encontrado.");
		}
	}

	public void buscarUsuario(int id) {
		Usuario u = dao.buscarPorId(id);
		view.mostrarUsuario(u);
	}
}
