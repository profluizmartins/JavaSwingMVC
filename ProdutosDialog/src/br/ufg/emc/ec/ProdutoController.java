package br.ufg.emc.ec;

import java.util.List;

/**
 * Controlador do sistema gestão de produtos.
 * 
 * 
 * @author Diego
 * @version 1.0
 */

public class ProdutoController {

    private ProdutoDAO dao;
    private ProdutoView view;

    /**
     * Construtor do controlador.
     * 
     * @param dao Objeto de acesso a dados
     * @param view Objeto de visualização
     * @throws IllegalArgumentException se dao ou view forem nulos
     */
    
    public ProdutoController(ProdutoDAO dao, ProdutoView view) {
        if (dao == null) {
            throw new IllegalArgumentException("DAO não pode ser nulo");
        }
        if (view == null) {
            throw new IllegalArgumentException("View não pode ser nula");
        }
        
        this.dao = dao;
        this.view = view;
    }

    /**
     * Cria um novo produto no sistema.
     * 
     * @param id Identificador do novo produto
     * @param nome Nome do novo produto
     * @param preco Preço do novo produto
     */
    
    public void criarProduto(String id, String nome, String preco) {
        try {
            
            if (id == null || id.trim().isEmpty()) {
                view.mostrarErro("ID não pode ser vazio!");
                return;
            }
            if (nome == null || nome.trim().isEmpty()) {
                view.mostrarErro("Nome não pode ser vazio!");
                return;
            }
            if (preco == null || preco.trim().isEmpty()) {
                view.mostrarErro("Preço não pode ser vazio!");
                return;
            }
            
            
            try {
                Double.parseDouble(preco);
            } catch (NumberFormatException e) {
                view.mostrarErro("Preço inválido! Digite apenas números.");
                return;
            }
            
            dao.adicionarProduto(id, nome, preco);
            view.mostrarMensagem("Produto adicionado com sucesso!");
            
        } catch (RuntimeException e) {
            view.mostrarErro("Erro ao criar produto: " + e.getMessage());
        } catch (Exception e) {
            view.mostrarErro("Erro inesperado ao criar produto: " + e.getMessage());
        }
    }

    
    public void listarProdutos() {
        try {
            List<Objeto> produtos = dao.listarProdutos();
            view.listarProdutos(produtos);
        } catch (Exception e) {
            view.mostrarErro("Erro ao listar produtos: " + e.getMessage());
        }
    }

    /**
     * Atualiza os dados de um produto existente.
     * 
     * @param id Identificador do produto a ser atualizado
     * @param novoNome Novo nome do produto
     * @param novoPreco Novo preço do produto
     */
    
    public void atualizarProduto(String id, String novoNome, String novoPreco) {
        try {
            
            if (id == null || id.trim().isEmpty()) {
                view.mostrarErro("ID não pode ser vazio!");
                return;
            }
            if (novoNome == null || novoNome.trim().isEmpty()) {
                view.mostrarErro("Nome não pode ser vazio!");
                return;
            }
            if (novoPreco == null || novoPreco.trim().isEmpty()) {
                view.mostrarErro("Preço não pode ser vazio!");
                return;
            }
            
            
            try {
                Double.parseDouble(novoPreco);
            } catch (NumberFormatException e) {
                view.mostrarErro("Preço inválido! Digite apenas números.");
                return;
            }
            
            dao.atualizarProduto(id, novoNome, novoPreco);
            view.mostrarMensagem("Produto atualizado com sucesso!");
            
        } catch (RuntimeException e) {
            view.mostrarErro("Erro ao atualizar produto: " + e.getMessage());
        } catch (Exception e) {
            view.mostrarErro("Erro inesperado ao atualizar produto: " + e.getMessage());
        }
    }

    /**
     * Deleta um produto do sistema.
     * 
     * @param id Identificador do produto a ser deletado
     */
    
    public void deletarProduto(String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                view.mostrarErro("ID não pode ser vazio!");
                return;
            }
            
            dao.removerProduto(id);
            view.mostrarMensagem("Produto deletado com sucesso!");
            
        } catch (RuntimeException e) {
            view.mostrarErro("Erro ao deletar produto: " + e.getMessage());
        } catch (Exception e) {
            view.mostrarErro("Erro inesperado ao deletar produto: " + e.getMessage());
        }
    }

    /**
     * Busca um produto pelo identificador e exibe suas informações.
     * 
     * @param id Identificador do produto a ser buscado
     */
    
    public void buscarId(String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                view.mostrarErro("ID não pode ser vazio!");
                return;
            }
            
            Objeto produto = dao.buscarID(id);
            view.mostrarProduto(produto);
            
        } catch (Exception e) {
            view.mostrarErro("Erro ao buscar produto: " + e.getMessage());
        }
    }
}