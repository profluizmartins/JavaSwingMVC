package app.model;

import java.util.ArrayList;
import java.util.List;

import app.exception.ProdutoException;

/**
 * DAO responsável por armazenar e gerenciar Produtos em memória.
 * Implementação simplificada usando uma lista.
 * 
 * @author Maria Julia
 * @version 1.0
 */
public class ProdutoDao {

    private List<Produto> tabela = new ArrayList<>();
    private int sequencia = 1;

    /**
     * Salva um produto (insere ou atualiza).
     * 
     * @param produto objeto produto preenchido
     * @return o produto salvo (com ID atribuído se for novo)
     * 
     * @throws ProdutoException caso ocorra falha na validação
     */
    public Produto salvar(Produto produto) throws ProdutoException {
        if (produto.getId() == null) {
            Produto novo = new Produto(sequencia++, produto.getNome(), produto.getPreco(), produto.getEstoque());
            tabela.add(novo);
            return novo;
        } else {
            for (int i = 0; i < tabela.size(); i++) {
                if (tabela.get(i).getId().equals(produto.getId())) {
                    tabela.set(i, produto);
                    return produto;
                }
            }
            throw new ProdutoException("Produto não encontrado para atualizar");
        }
    }

    /**
     * Remove um produto pelo ID.
     * 
     * @param id identificador do produto
     * @return true se foi removido
     */
    public boolean remover(Integer id) {
        return tabela.removeIf(p -> p.getId().equals(id));
    }

    /**
     * Busca produto pelo ID.
     * 
     * @param id identificador
     * @return produto encontrado ou null
     */
    public Produto buscarPorId(Integer id) {
        return tabela.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Lista todos os produtos cadastrados.
     * 
     * @return lista de produtos
     */
    public List<Produto> listarTodos() {
        return new ArrayList<>(tabela);
    }
}
