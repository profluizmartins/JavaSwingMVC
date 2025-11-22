package produto.exception;

/**
 * Exceção para erros relacionados a operações de produto.
 * 
 * @author Luiz Lima
 * @version 1.0
 */
public class ProdutoException extends RuntimeException {

    /**
     * Cria uma nova exceção de produto.
     * 
     * @param mensagem mensagem de erro
     */
    public ProdutoException(String mensagem) {
        super(mensagem);
    }
}
