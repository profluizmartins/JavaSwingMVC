package app.model;

import java.util.ArrayList;
import java.util.List;

import app.exception.UsuarioExeception;

/**
 * Classe de manipulação de DAO da Usuário
 * 
 * @author Samuel Barbosa
 * @version 1.0
 */
public class UsuarioDao {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private int proximoId = 1;

	/**
	 * Método de adicionar um usuário banco de dados
	 * 
	 * @param nome  Nome do usuário
	 * @param email email do usuário
	 * @throws UsuarioExeception verificar se os dados do usuário estão corretos
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
     * Atualiza os dados do usuário
     * @param id O id do usuario a ser alterado
     * @param novoNome o novo nome do usuario
     * @param novoEmail o novo email do usuario
     * @return retorna true se os dados forem alterados, caso contrario false
     * @throws UsuarioExeception exceções lançadas caso os dados sejam preechidas de forma errada
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
     * remove o usuario pelo ID
     * @param id o ID do usuario a ser deletado
     * @return retorna true se o usuario for deletado, caso contrario false
     */
	public boolean removerUsuario(int id) {
		return usuarios.removeIf(u -> u.getId() == id);
	}

    /**
     * Busca o usuario pelo ID
     * @param id o Id do usuario a ser encontrado
     * @return true se encontrado false se não for encontrado
     */
	public Usuario buscarPorId(int id) {
		for (Usuario u : usuarios) {
			if (u.getId() == id)
				return u;
		}
		return null;
	}
}
