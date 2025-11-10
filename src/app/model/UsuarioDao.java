package app.model;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
	private List<Usuario> usuarios = new ArrayList<Usuario>();
    private int proximoId = 1;
    
    // Inserir
    public void adicionarUsuario(String nome, String email) {
        usuarios.add(new Usuario(proximoId++, nome, email));
    }

    // Ler
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    // Alterar
    public boolean atualizarUsuario(int id, String novoNome, String novoEmail) {
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
            if (u.getId() == id) return u;
        }
        return null;
    }
}
