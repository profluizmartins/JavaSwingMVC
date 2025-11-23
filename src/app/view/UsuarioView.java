package app.view;

import java.util.List;

import app.model.Usuario;


/**
 * Classe auxiliar para exibir informações do usuário no console.
 *
 * <p>Usada apenas para testes e depuração. A versão visual é a
 * {@link UsuarioListView}.</p>
 *
 * @author GuilhermeHolanda
 * @version 2.0
 */

public class UsuarioView {

    /**
     * Mostra os dados de um único usuário no console.
     *
     * @param usuario usuário que será exibido
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
     * Exibe todos os usuários de uma lista.
     *
     * @param usuarios lista de usuários
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
     * Exibe uma mensagem simples no console.
     *
     * @param mensagem texto da mensagem
     */
    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    /**
     * Exibe uma mensagem de erro no console.
     *
     * @param mensagem mensagem de erro
     */
    public void mostrarMensagemErro(String mensagem) {
        System.out.println(mensagem);
    }
}
