package app.model;

import java.util.ArrayList;
import java.util.List;

import app.exception.Execeptions;

/**
 * Classe de manipulação de DAO da Usuário
 * 
 * @author Luiz Martins
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
	 * @throws Execeptions verificar de nome do usuário está correto
	 */
	// Inserir
	public void adicionarUsuario(String nome, String email) throws Execeptions {
		if (nome == null || nome.equals("") || nome.length() < 2) {
			throw new Execeptions("Nome inválido");
		}
		//Pattern pattern = Pattern.compile("\"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,6}$\"");
		//Matcher matcher = pattern.matcher(email);
		if (email == null || email.equals("") || email.length() <= 5) {
			throw new Execeptions("Email inválido");
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

	// Alterar
	public boolean atualizarUsuario(int id, String novoNome, String novoEmail) throws Execeptions {
		if(id <= 0) {
			throw new Execeptions("Id de usuário inválido");
		}
		if (novoNome == null || novoNome.equals("") || novoNome.length() < 2) {
			throw new Execeptions("Nome inválido");
		}
		if (novoEmail == null || novoEmail.equals("") || novoEmail.length() <= 5) {
			throw new Execeptions("Email inválido");
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
