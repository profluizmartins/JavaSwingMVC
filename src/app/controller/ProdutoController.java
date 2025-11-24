package app.controller;

import java.util.List;

import app.exception.ProdutoException;
import app.model.Produto;
import app.model.ProdutoDao;
import app.view.ProdutoView;

/**
 * Controller responsável por intermediar a View do Produto e a camada DAO.
 * 
 * Realiza tratamento de exceções e conversão de dados.
 * 
 * @author Maria Julia
 * @version 1.0
 */
public class ProdutoController {

    private ProdutoDao dao;
    private ProdutoView view;

    /**
     * Construtor do controller.
     * 
     * @param dao  instância do DAO
     * @param view instância da view
     */
    public ProdutoController(ProdutoDao dao, ProdutoView view) {
        this.dao = dao;
        this.view = view;
    }

    /**
     * Salva ou atualiza um produto.
     * 
     * @param idStr     id em String (pode ser vazio)
     * @param nome      nome
     * @param precoStr  preço
     * @param estStr    estoque
     */
    public void salvar(String idStr, String nome, String precoStr, String estStr) {
        try {
            Integer id = (idStr == null || idStr.isEmpty()) ? null : Integer.valueOf(idStr);
            double preco = Double.parseDouble(precoStr.replace(",", "."));
            int estoque = Integer.parseInt(estStr);

            Produto p = new Produto(id, nome, preco, estoque);
            dao.salvar(p);
            view.sucesso("Produto salvo com sucesso!");

        } catch (ProdutoException e) {
            view.erro("Erro de validação: " + e.getMessage());
        } catch (NumberFormatException e) {
            view.erro("Erro: valores numéricos inválidos!");
        }
    }

    /**
     * Exclui um produto pelo ID.
     * 
     * @param id identificador em string
     */
    public void excluir(String id) {
        try {
            boolean removido = dao.remover(Integer.parseInt(id));
            if (removido)
                view.sucesso("Produto removido");
            else
                view.erro("Produto não encontrado");
        } catch (NumberFormatException e) {
            view.erro("ID inválido");
        }
    }

    /** Lista todos os produtos */
    public void listar() {
        List<Produto> lista = dao.listarTodos();
        view.listar(lista);
    }

    /** Busca um produto pelo ID */
    public void buscar(String idStr) {
        try {
            Produto p = dao.buscarPorId(Integer.parseInt(idStr));
            view.exibir(p);
        } catch (NumberFormatException e) {
            view.erro("ID inválido");
        }
    }
}
