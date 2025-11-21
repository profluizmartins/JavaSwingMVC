package app.controller;

import java.util.List;

import app.exception.UsuarioExeception;
import app.model.Usuario;
import app.model.UsuarioDao;
import app.view.UsuarioView;
/**
 * Classe responsável pelo controle dos usuários.
 * @author João Pedro
 * @version 1.0
 */
public class UsuarioController {
	private UsuarioDao dao;
	private UsuarioView view;
/**
 * Metodo construtor.
 * @param dao Guarda e busca os dados
 * @param view Mostra coisas na tela e recebe ações do usuário
 */
	public UsuarioController(UsuarioDao dao, UsuarioView view) {
		this.dao = dao;
		this.view = view;
	}
/**
 * Metodo responsável por criar novos usuarios.
 * @param nome Nome do usuario
 * @param email Email do usuario
 */
	public void criarUsuario(String nome, String email) {
		/**
		 * Tratamento.
		 */
		try {
			dao.adicionarUsuario(nome, email);
			view.mostrarMensagem("Usuário adicionado com sucesso.");
		} catch (UsuarioExeception e) {
			view.mostrarMensagem("Não foi possivel criar usuário: "+e.getMessage());
		}
		
	}
/**
 * Metodo responsável por listar os usuarios.
 */
	public void listarUsuarios() {
		List<Usuario> usuarios = dao.listarUsuarios();
		view.listarUsuarios(usuarios);
	}
/**
 * Metodo responsável por atualizar os dados dos usuario.
 * @param id ID do usuario
 * @param novoNome Novo nome do usuario
 * @param novoEmail Novo email do usuario
 * @throws UsuarioExeception tratamento responsável por checar se o usuario foi atualizado
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
 * Metodo responsável por remover usuarios.
 * @param id Id do usuario
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
 * metodo responsável por buscar os usuarios.
 * @param id Id do usuario
 * @throws UsuarioExeception Tratamento de exceções responsavel por verificar se o id
 * e o usuario são veridicos
 */
	public void buscarUsuario(int id) throws UsuarioExeception {
		if (id < 0) {
			throw new UsuarioExeception("Usuario não encontrado");
		} 
		Usuario u = dao.buscarPorId(id);

	    if (u == null) {
	        throw new UsuarioExeception("Usuário não encontrado no banco de dados");
	    }

	    view.mostrarUsuario(u);
	}
	}
}
