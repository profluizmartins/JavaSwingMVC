/**
 * Exceção para dados inválidos, como preços negativos ou nulos ou string de nome vazia.
 */
public class DadosInvalidosException extends Exception {
    public DadosInvalidosException(String msg){
        super(msg);
    }
}
