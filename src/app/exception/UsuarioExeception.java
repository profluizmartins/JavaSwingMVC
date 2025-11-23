package app.exception;

/**
 * Exceção personalizada utilizada para sinalizar erros relacionados
 * às operações envolvendo a entidade {@code Usuario}.
 *
 * @author GuilhermeHolanda
 * @version 2.0
 */
public class UsuarioExeception extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Construtor que recebe uma mensagem descritiva do erro ocorrido.
     *
     * @param msg mensagem explicando a causa da exceção
     */
    public UsuarioExeception(String msg) {
        super(msg);
    }
}
