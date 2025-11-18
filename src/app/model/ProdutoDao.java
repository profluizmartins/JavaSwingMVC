package app.model;

import app.exception.Execeptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de manipução de dados (DAO) da classe Produto
 * @author Arthur Souza
 * @version 1.0
 *
 **/
public class ProdutoDao {
    private List<Produto> produtos = new ArrayList<Produto>();
    private int proximoId = 1;

    /**
     *Método de adicionar produtos ao banco de dados
     * @param nome Nome a ser adicionado ao produto
     * @param preco preço a ser adicionado ao produto
     **/

    //Adicionar produtos
    public void adicionarProdutos(String nome, Double preco) throws Execeptions {
        if (nome == null || nome.equals("") || nome.length() < 2) {
            throw new Execeptions("Nome inválido");
        }
        if (preco < 0) {
            throw new Execeptions("Preço inválido");
        }

        produtos.add(new Produto(proximoId++, nome, preco));
    }

    /**
     * Método para listar todos os produtos cadastrados
     * Irá retornar a lista de produtos
     **/

    //Ler produtos
    public List<Produto> listarProdutos() {
        return produtos;
    }

    /**
     * Método de atualizar produtos do banco de dados
     * @param id Identificador do produto a ser atualizado
     * @param novoNome Nome do produto a ser atualizado
     * @param novoPreco Preco do produto a ser atualizado
     **/

    //Atualizar produtos
    public boolean atualizarProdutos(int id, String novoNome, Double novoPreco) throws Execeptions {
        if (id <= 0) {
            throw new Execeptions("Id de produto inválido");
        }
        if (novoNome == null || novoNome.equals("") || novoNome.length() < 2) {
            throw new Execeptions("Nome inválido");
        }
        if (novoPreco < 0) {
            throw new Execeptions("Preço inválido");
        }
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setNome(novoNome);
                p.setPreco(novoPreco);
                return true;
            }
        }
        return false;
    }

    /**
     * Método de mexclusão de produtos do banco de dados
     * @param id Identificador do produto a ser excluído
     **/

    //Excluir produtos
    public boolean removerProdutos(int id) throws Execeptions{
        if(id < 0){
            throw new Execeptions("Id inválido"); }
        return produtos.removeIf(p -> p.getId() == id);
    }

    /**
     * Método que buscar produtos do banco de dados
     * @param id Identificador do produto a ser buscado
     **/

    //Buscar produtos
    public Produto buscarProdutos(int id) throws Execeptions{
        if(id < 0){
            throw new Execeptions("Id inválido");
        }
        for(Produto p: produtos) {
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
}
