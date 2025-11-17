package app.view;

import java.util.List;

import app.model.Usuario;

/**
 * Classe da janela de formulario para cadastro do usuário
 *
 * @author Romulo Henrique
 * @version 1.0
 */
public class UsuarioView {

     /**
     * Método contrutor de UsuárioView
     * @param usuario Usuário
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
         * Método de mostrar a listagem de usuários
         * @param usuarios Lista de Usuários
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
         * Método de mostrar mensagens
         * @param mensagem mostra uma mensagem no programa
         */
	    public void mostrarMensagem(String mensagem) {
	        System.out.println(mensagem);
	    }
	    
        /**
         * Método de mostrar mensagens de erro
         * @param mensagem mostra uma mensagem de erro no programa
         */
	    public void mostrarMensagemErro(String mensagem) {
	        System.out.println(mensagem);
	    }
}
