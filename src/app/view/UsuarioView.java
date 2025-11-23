package app.view;

import java.util.List;

import app.model.Usuario;

/**
 * Classe que exibe os dados do usuario
 * @author Samuel Barbosa
 */

public class UsuarioView {
    /**
     * Exibe dados do usuario no console
     * @param usuario para os dados do usuario
     */
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

    /**
     * Exibe a lista dos usuarios no console
     * @param usuarios a lista dos usuarios
     */

    public void listarUsuarios(List<Usuario> usuarios) {
	        if (usuarios.isEmpty()) {
	            System.out.println("Nenhum usuário cadastrado.");
	        } else {
	            for (Usuario u : usuarios) {
	                mostrarUsuario(u);
	            }
	        }
	    }

    /**
     * Função pra exibir uma mensagem
     * @param mensagem
     */

    public void mostrarMensagem(String mensagem) {
	        System.out.println(mensagem);
	    }
	    
	    public void mostrarMensagemErro(String mensagem) {
	        System.out.println(mensagem);
	    }
}
