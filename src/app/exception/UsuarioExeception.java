package app.exception;

public class UsuarioExeception extends Exception{

	/**
	 * Lida com exceções da classe usuário
	 * @author Luiz Martins
	 * @version 1.0
	 * @see UsuarioDao.java
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioExeception(String msg) {
		super(msg);
	}

}
