package app.exception;
    /**
     * Classe responsável por cuidar das exceções.
     * @author João Pedro
     * @version 1.0
     *
     */
public class UsuarioExeception extends Exception{

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * Método do construtor responsável por apresentar a mensagem de erro.
     * @param msg mensagem a ser exibida para alertar sobre o erro
     */
	public UsuarioExeception(String msg) {
		super(msg);
	}

}
