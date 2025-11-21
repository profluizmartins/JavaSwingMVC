package app.controller;

import java.util.List;



import app.exception.UsuarioExeception;
import app.model.Usuario;
import app.model.UsuarioDao;
import app.view.UsuarioView;

/**
 * A classe controller faz a comunicação entre a classe dao e view.
 */

public class UsuarioController {
	private UsuarioDao dao;
	private UsuarioView view;
	
	/**
	 * Classe Construtora de Usuario View
	 * @author Samuel Barbosa
	 * @version 1.0
	 * @param dao chama a classe dao para receber os dados
	 * @param view chama a classe view para exibir os dados
	 */

	public UsuarioController(UsuarioDao dao, UsuarioView view) {
		this.dao = dao;
		this.view = view;
	}
	/**
	 * Método de criação de usuário
	 * @param  nome nome do usuario
	 * @param email email do usuario
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
	 * Solicita ao dao a lista de todos os usuarios para o view exibir
	 * 
	 */

	public void listarUsuarios() {
		List<Usuario> usuarios = dao.listarUsuarios();
		view.listarUsuarios(usuarios);
	}
	
	/**
	 * Método para atualizar as informações dos usuários pelo Dao
	 * Usa o view para mostrar as mensagens de erro
	 * @param id id do usuário para ser atualizado
	 * @param novoNome o nome atualizado do usuário
	 * @param novoEmail o email atualizado do usuário
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
	 * Método deletar usuário
	 * @param id o id do usuário a ser deletado
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
	 * Método para exibir as informações de um usuario especifico
	 * @param id utiliza o id do usuario para mostrar suas informações
	 */

	public void buscarUsuario(int id) {
		Usuario u = dao.buscarPorId(id);
		view.mostrarUsuario(u);
	}
}
