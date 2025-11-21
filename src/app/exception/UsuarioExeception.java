package app.exception;

/**
 * Classe utilizada para fazer a exibição das mensagens dos tratamentos de erros
 */

public class UsuarioExeception extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Método para exibir as mensagens dos tratamentos de erros
	 * @param msg
	 */

	public UsuarioExeception(String msg) {
		super(msg);
	}

}
