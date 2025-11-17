package app.exception;
/**
 * Classe de exceções do programa
 *
 * @author Romulo Henrique
 * @version 1.0
 */
public class UsuarioExeception extends Exception{

	private static final long serialVersionUID = 1L;

    /**
     * Método de exceção
     *
     * @param msg  Mensagem que aparecerá na tela do usuário quando a exceção for ativada
     */
	public UsuarioExeception(String msg) {
		super(msg);
	}

}
