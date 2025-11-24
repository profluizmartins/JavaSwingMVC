package app.exception;

/**
 * Exceção usada para indicar erros de validação relacionados ao Produto.
 * 
 * @author Maria Julia
 * @version 1.0
 */
public class ProdutoException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Construtor da exceção de Produto.
     * 
     * @param mensagem descrição do erro ocorrido
     */
    public ProdutoException(String mensagem) {
        super(mensagem);
    }
}
