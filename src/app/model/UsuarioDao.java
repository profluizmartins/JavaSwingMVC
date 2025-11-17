package app.model;

import java.util.ArrayList;
import java.util.List;

import app.exception.UsuarioExeception;

/**
 * Classe de manipulação de DAO da Usuário
 * 
 * @author Romulo Henrique
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
	 * @throws UsuarioExeception verificar de nome do usuário está correto
	 */
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
	 * Método de retornar a lista de usuários
	 * @return List<Usuários> a lista dos usuário cadastrados
	 */
	// Ler
	public List<Usuario> listarUsuarios() {
		return usuarios;
	}

    /**
     * Método de atualizar o cadastro do usuário
     * @param novoNome Novo nome do Usuário
     * @param id Identificador do Usuário
     * @param novoEmail Novo email do usuário
     *
     * @throws UsuarioExeception verificar se o id, nome e email são válidos
     *
     * @return true se o id do usuário for existente, e false se o id do usuário for inexistente
     */
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

    /**
     * Método de remover um usuário
     * @param id Identificador do Usuário
     *
     *
     * @return ação de remover o usuário, se o id for válido
     */
	// Excluir
	public boolean removerUsuario(int id) {
		return usuarios.removeIf(u -> u.getId() == id);
	}

    /**
     * Método de buscar um usuário pelo id
     * @param id Identificador do Usuário

     * @return o usuário do id buscado, se não existir, retorna valor nulo
     */
	public Usuario buscarPorId(int id) {
		for (Usuario u : usuarios) {
			if (u.getId() == id)
				return u;
		}
		return null;
	}
}
