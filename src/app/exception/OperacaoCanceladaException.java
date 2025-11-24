package Aula08;

/**
 * Classe de exceção personalizada para operações canceladas
 */
public class OperacaoCanceladaException extends Exception {
    /**
     * Método de exceção personalizada para operações canceladas
     */
    public OperacaoCanceladaException() {
        super("A operação foi cancelada pelo usuário.");
    }
}