package app.exception;

/**
 * Exceção personalizada para erros de validação de dados.
 * Esta exceção deve ser lançada quando um dado de entrada
 * não atende aos critérios de negócio.
 * @author Enzo Fonseca
 * @version 1.0
 */
public class ValidacaoException extends Exception {

    /**
     * Construtor que recebe a mensagem de erro.
     * @param message A mensagem detalhada sobre o erro de validação.
     */
    public ValidacaoException(String message) {
        super(message);
    }
}
