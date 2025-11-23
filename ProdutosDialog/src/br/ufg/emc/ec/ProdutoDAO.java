package br.ufg.emc.ec;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de acesso a dados para gerenciar produtos.
 * 
 * 
 * @author Diego
 * @version 1.0
 */
public class ProdutoDAO {
    
    private ArrayList<Objeto> listaProdutos;
    
    /**
     * Construtor de DAO
     */
    public ProdutoDAO() {
        listaProdutos = new ArrayList<>();
        try {
            listaProdutos.add(new Objeto("1", "Cálculo - James Stewart", "150.0"));
            listaProdutos.add(new Objeto("2", "Cálculo - Guidorizzi", "120.0"));
            listaProdutos.add(new Objeto("3", "Álgebra Linear - Boldrini", "130.0"));
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao inicializar produtos padrão: " + e.getMessage());
        }
    }
    
    /**
     * Adiciona um novo produto à lista.
     * 
     * @param id Identificador do produto
     * @param nome Nome do produto
     * @param preco Preço do produto
     * @throws IllegalArgumentException Se algum parâmetro for inválido
     * @throws RuntimeException Se já existir um produto com o mesmo ID
     */
    
    public void adicionarProduto(String id, String nome, String preco) {
        try {
            
            if (buscarID(id) != null) {
                throw new RuntimeException("Já existe um produto com o ID: " + id);
            }
            
            Objeto p = new Objeto(id, nome, preco);
            listaProdutos.add(p);
            
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Dados inválidos para criar produto: " + e.getMessage());
        }
    }
    
    /**
     * Imprime a lista de produtos cadastrados.
     * 
     * @return Lista de produtos
     */
    
    public List<Objeto> listarProdutos() {
        return new ArrayList<>(listaProdutos); // Retorna uma cópia para evitar modificações externas
    }
    
    /**
     * Atualiza os dados de um produto que já existe.
     * 
     * @param id Identificador do produto a ser atualizado
     * @param novoNome Novo nome do produto
     * @param novoPreco Novo preço do produto
     * @throws IllegalArgumentException Se os novos dados forem inválidos
     * @throws RuntimeException Se o produto não for encontrado
     */
    
    public void atualizarProduto(String id, String novoNome, String novoPreco) {
        try {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("ID não pode ser nulo ou vazio");
            }
            
            for (int i = 0; i < listaProdutos.size(); i++) {
                if (listaProdutos.get(i).getId().equals(id)) {
                    listaProdutos.get(i).setNome(novoNome);
                    listaProdutos.get(i).setPreco(novoPreco);
                    return;
                }
            }
            
            
            throw new RuntimeException("Produto com ID '" + id + "' não encontrado para atualização");
            
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Erro ao atualizar produto: " + e.getMessage());
        }
    }
    
    /**
     * Remove um produto da lista pelo identificador.
     * 
     * @param id Identificador do produto a ser removido
     * @throws IllegalArgumentException Se o identificador for nulo ou vazio
     * @throws RuntimeException Se o produto não for encontrado
     */
    
    public void removerProduto(String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("ID não pode ser nulo ou vazio");
            }
            
            for (int i = 0; i < listaProdutos.size(); i++) {
                if (listaProdutos.get(i).getId().equals(id)) {
                    listaProdutos.remove(i);
                    return;
                }
            }
            
            
            throw new RuntimeException("Produto com ID '" + id + "' não encontrado para remoção");
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover produto: " + e.getMessage());
        }
    }
    
    /**
     * Busca um produto pelo identificador.
     * 
     * @param id Identificador do produto a ser buscado
     * @return O objeto produto encontrado, ou null se não encontrado
     * @throws IllegalArgumentException Se o identificador for nulo ou vazio
     */
    
    public Objeto buscarID(String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("ID não pode ser nulo ou vazio para busca");
            }
            
            for (int i = 0; i < listaProdutos.size(); i++) {
                if (listaProdutos.get(i).getId().equals(id)) {
                    return listaProdutos.get(i);
                }
            }
            
            return null; 
            
        } catch (Exception e) {
            System.err.println("Erro ao buscar produto: " + e.getMessage());
            return null;
        }
    }
}