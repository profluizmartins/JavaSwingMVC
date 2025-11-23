package br.ufg.emc.ec;

import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela interface do sistema
 * 
 * 
 * @author Diego
 * @version 1.0
 */
public class ProdutoView {

    /**
     * Exibe os dados de um produto específico.
     * 
     * @param produto Objeto produto a ser exibido
     */
	
    public void mostrarProduto(Objeto produto) {
        try {
            if (produto != null) {
                String mensagem = "----- Produto Encontrado -----\n" +
                                 "ID: " + produto.getId() + "\n" +
                                 "Nome: " + produto.getNome() + "\n" +
                                 "Preço: R$ " + produto.getPreco() + "\n" +
                                 "------------------------------";
                
                System.out.println(mensagem);
                JOptionPane.showMessageDialog(null, mensagem, 
                    "Produto Encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                String mensagem = "Produto não encontrado!";
                System.out.println(mensagem);
                JOptionPane.showMessageDialog(null, mensagem, 
                    "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            mostrarErro("Erro ao exibir produto: " + e.getMessage());
        }
    }

    /**
     * Lista todos os produtos cadastrados no sistema.
     * 
     * @param produtos Lista de produtos a ser exibida
     */
    
    public void listarProdutos(List<Objeto> produtos) {
        try {
            if (produtos == null || produtos.isEmpty()) {
                String mensagem = "Nenhum produto cadastrado!";
                System.out.println(mensagem);
                JOptionPane.showMessageDialog(null, mensagem, 
                    "Lista Vazia", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("----- Lista de Produtos -----\n\n");
            
            System.out.println("----- Lista de produtos -----");
            for (Objeto produto : produtos) {
                String info = "ID: " + produto.getId() + "\n" +
                             "Nome: " + produto.getNome() + "\n" +
                             "Preço: R$ " + produto.getPreco() + "\n" +
                             "--------------------------\n";
                
                System.out.print(info);
                sb.append(info).append("\n");
            }
            
            JOptionPane.showMessageDialog(null, sb.toString(), 
                "Lista de Produtos", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (Exception e) {
            mostrarErro("Erro ao listar produtos: " + e.getMessage());
        }
    }

    /**
     * Exibe uma mensagem ao usuário.
     * 
     * @param mensagem Mensagem a ser exibida
     */
    
    public void mostrarMensagem(String mensagem) {
        try {
            System.out.println(mensagem);
            JOptionPane.showMessageDialog(null, mensagem, 
                "Informação", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println("Erro ao exibir mensagem: " + e.getMessage());
        }
    }
    
    /**
     * Exibe uma mensagem de erro ao usuário.
     * 
     * @param mensagem Mensagem de erro a ser exibida
     */
    
    public void mostrarErro(String mensagem) {
        System.err.println("ERRO: " + mensagem);
        JOptionPane.showMessageDialog(null, mensagem, 
            "Erro", JOptionPane.ERROR_MESSAGE);
    }
}