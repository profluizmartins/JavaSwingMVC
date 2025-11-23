package app.model;

import java.util.ArrayList;
import java.util.List;

import app.exception.UsuarioExeception;

/**
 * Classe de manipulação de DAO da Usuário
 * 
 * @author Luiz Martins
 * @version 1.0
 */

public class UsuarioDao {
	// Armazenamento de usuários
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
		if (nome == null || nome.equals("") || nome.length() < 2) {
			throw new UsuarioExeception("Nome inválido");
		}
		//Pattern pattern = Pattern.compile("\"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,6}$\"");
		//Matcher matcher = pattern.matcher(email);
		if (email == null || email.equals("") || email.length() <= 5) {
			throw new UsuarioExeception("Email inválido");
		}

		// adicionou-se mais um usuário banco de dados
		usuarios.add(new Usuario(proximoId++, nome, email));
	}

	/**
	 * Médoto de retornar a lista de usuários
	 * @return List<Usuários> a lista dos usuário cadastrados
	 */
	// Ler
	public List<Usuario> listarUsuarios() {
		return usuarios;
	}

	/**
	 * Método para atualizar as informações de um usuário a partir de seu ID
	 * 
	 * @param id
	 * @param novoNome
	 * @param novoEmail
	 * @return boolean (true se usuário for adicionado, false senão)
	 * @throws UsuarioExeception
	 */
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

	/**
	 * Método para remover um usuário a partir de seu ID
	 * 
	 * @param id
	 * @return boolean (true se usuário for removido, false senão)
	 */
	public boolean removerUsuario(int id) {
		return usuarios.removeIf(u -> u.getId() == id);
	}

	/**
	 * Método para buscar, pelo ID, um usuário no banco de dados
	 * @param id
	 * @return Usuario
	 */
	public Usuario buscarPorId(int id) {
		for (Usuario u : usuarios) {
			if (u.getId() == id)
				return u;
		}
		return null;
	}
}
