package app.model;

import java.util.ArrayList;
import java.util.List;

import app.exception.UsuarioExeception;

/**
 * Classe de manipulação de DAO da Usuário
 * 
 * /**
 * Controlador responsável por gerenciar operações de CRUD de usuários.
 * Faz a ponte entre usuário (View) e regras de negócio (Dao), tratando exceções
 * e exibindo mensagens apropriadas.
 * 
 * @eliel
 * @version 1.0
 */
/**
 * Cria um novo usuário.
 * @param nome Nome do usuário
 * @param email Email do usuário
 */

/**
 * Lista todos os usuários cadastrados.
 */
/**
 * Atualiza um usuário existente.
 * Trata erros lançados pelo DAO e informa a View.
 * 
 * @param id Identificador do usuário
 * @param novoNome Novo nome
 * @param novoEmail Novo email
 */

/**
 * Remove um usuário pelo ID.
 * @param id identificador
 */
/**
 * Busca e exibe um usuário pelo ID.
 * @param id identificador
 */


public class UsuarioDao {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private int proximoId = 1;

	/**
	 * Método de adicionar um usuário banco de dados
	 * 
	 * @param nome  Nome do usuário
	 * @param email email do usuário
	 * @throws UsuarioExeception verificar de nome do usuário está correto
	 */
	// Inserir
	public void adicionarUsuario(String nome, String email) throws UsuarioExeception {
		if (nome == null || nome.isBlank() || nome.length() < 2) {
			throw new UsuarioExeception("Nome inválido");
		}
		//Pattern pattern = Pattern.compile("\"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,6}$\"");
		//Matcher matcher = pattern.matcher(email);
		if (email == null || email.isBlank() || email.length() <= 5) {
			throw new UsuarioExeception("Email inválido");
		}

		usuarios.add(new Usuario(proximoId++, nome, email));
	}

	/**
	 * Retorna a lista completa de usuários cadastrados.
	 * 
	 * @return lista de usuários armazenados em memória
	 */

	public List<Usuario> listarUsuarios() {
		return usuarios;
	}

	// Alterar
	public boolean atualizarUsuario(int id, String novoNome, String novoEmail) throws UsuarioExeception {
		if(id <= 0) {
			throw new UsuarioExeception("Id de usuário inválido");
		}
		if (novoNome == null || novoNome.equals("") || novoNome.length() < 2) {
			throw new UsuarioExeception("Nome inválido");
		}
		if (novoEmail == null || novoEmail.equals("") || novoEmail.length() <= 5) {
			throw new UsuarioExeception("Email inválido");
		}
		for (Usuario u : usuarios) {
			if (u.getId() == id) {
				u.setNome(novoNome);
				u.setEmail(novoEmail);
				return true;
			}
		}
		return false;
	}

	// Excluir
	public boolean removerUsuario(int id) {
		return usuarios.removeIf(u -> u.getId() == id);
	}

	public Usuario buscarPorId(int id) {
		for (Usuario u : usuarios) {
			if (u.getId() == id)
				return u;
		}
		return null;
	}
}
