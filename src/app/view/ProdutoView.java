package app.view;

import java.util.List;

import app.model.Produto;
import app.model.Usuario;

public class ProdutoView {
    public void mostrarProduto(Produto produto) {
        if (produto != null) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: R$ " + produto.getPreco());
            System.out.println("---------------");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void listarProdutos(List<Produto> produtos) {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p : produtos) {
                mostrarProduto(p);
            }
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarMensagemErro(String mensagem) {
        System.out.println(mensagem);
    }
}
