package app.view;

import java.util.List;

import app.model.Usuario;

public class UsuarioView {
	 public void mostrarUsuario(Usuario usuario) {
	        if (usuario != null) {
	            System.out.println("ID: " + usuario.getId());
	            System.out.println("Nome: " + usuario.getNome());
	            System.out.println("Email: " + usuario.getEmail());
	            System.out.println("---------------");
	        } else {
	            System.out.println("Usuário não encontrado.");
	        }
	    }

	    public void listarUsuarios(List<Usuario> usuarios) {
	        if (usuarios.isEmpty()) {
	            System.out.println("Nenhum usuário cadastrado.");
	        } else {
	            for (Usuario u : usuarios) {
	                mostrarUsuario(u);
	            }
	        }
	    }

	    public void mostrarMensagem(String mensagem) {
	        System.out.println(mensagem);
	    }
}
