package app.view;

import java.util.List;

import app.model.Usuario;
/**
 * Classe responsável por mostrar os usuários.
 * @author João Pedro
 * @version 1.0
 */
public class UsuarioView {
	/**
	 * Método responsável para apresentar os usuários com seus respectivos dados.
	 * @param usuario Objeto usuario da classe Usuario
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
 * Metodo responsável por listar os usuários cadastrados.
 * @param usuarios
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
 * metodo responsável por apresentar uma mensagem.
 * @param mensagem Mensagem a ser exibida
 */
	    public void mostrarMensagem(String mensagem) {
	        System.out.println(mensagem);
	    }
	    /**
	     * metodo responsável por apresentar uma mensagem de erro.
	     * @param mensagem Mensagem a ser exibida
	     */
	    public void mostrarMensagemErro(String mensagem) {
	        System.out.println(mensagem);
	    }
}
