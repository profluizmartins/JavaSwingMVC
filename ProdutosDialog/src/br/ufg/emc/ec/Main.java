package br.ufg.emc.ec;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 * Classe principal do sistema de gestão de produtos.
 * 
 * 
 * @author Diego	
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(System.in);
            String id;
            String nome;
            String preco;
            int opcao = 0;
            String[] escolhas = {"Sair", "Criar", "Atualizar", "Listar", "Deletar", "Buscar"};
            
            
            ProdutoDAO produtoDAO = new ProdutoDAO();
            ProdutoView produtoView = new ProdutoView();
            ProdutoController controller = new ProdutoController(produtoDAO, produtoView);
            
            
            do {
                try {
                    opcao = JOptionPane.showOptionDialog(null, 
                            "Escolha uma opção",
                            "Menu do usuário", 
                            0,
                            JOptionPane.INFORMATION_MESSAGE, 
                            null,
                            escolhas, 
                            escolhas[0]);
                    
                    if (opcao == -1) {
                        opcao = 0; 
                    }
                    
                    switch (opcao) {
                        case 1: 
                            try {
                                id = JOptionPane.showInputDialog(null, 
                                        "Digite o ID do produto: ",
                                        "Criação do produto", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                
                                if (id == null) break; 
                                
                                nome = JOptionPane.showInputDialog(null, 
                                        "Digite o nome do produto: ",
                                        "Criação do produto", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                
                                if (nome == null) break; 
                                
                                preco = JOptionPane.showInputDialog(null, 
                                        "Digite o preço do produto: ", 
                                        "Criação do produto", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                
                                if (preco == null) break; 
                                
                                controller.criarProduto(id, nome, preco);
                                
                            } catch (Exception e) {
                                produtoView.mostrarErro("Erro ao criar produto: " + e.getMessage());
                            }
                            break;
                        
                        case 2: 
                            try {
                                id = JOptionPane.showInputDialog(null, 
                                        "Digite o ID do produto", 
                                        "Atualização do produto", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                
                                if (id == null) break; 
                                
                                nome = JOptionPane.showInputDialog(null, 
                                        "Digite o nome do produto: ",
                                        "Atualização do produto", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                
                                if (nome == null) break; 
                                
                                preco = JOptionPane.showInputDialog(null, 
                                        "Digite o preço do produto: ", 
                                        "Atualização do produto", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                
                                if (preco == null) break; 
                                
                                controller.atualizarProduto(id, nome, preco);
                                
                            } catch (Exception e) {
                                produtoView.mostrarErro("Erro ao atualizar produto: " + e.getMessage());
                            }
                            break;
                        
                        case 3: 
                            try {
                                controller.listarProdutos();
                            } catch (Exception e) {
                                produtoView.mostrarErro("Erro ao listar produtos: " + e.getMessage());
                            }
                            break;
                        
                        case 4: 
                            try {
                                id = JOptionPane.showInputDialog(null, 
                                        "Digite o ID do produto", 
                                        "Deletar um produto", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                
                                if (id == null) break; 
                                
                                controller.deletarProduto(id);
                                
                            } catch (Exception e) {
                                produtoView.mostrarErro("Erro ao deletar produto: " + e.getMessage());
                            }
                            break;
                        
                        case 5: 
                            try {
                                id = JOptionPane.showInputDialog(null, 
                                        "Digite o ID do produto: ", 
                                        "Busca do produto", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                
                                if (id == null) break; 
                                
                                controller.buscarId(id);
                                
                            } catch (Exception e) {
                                produtoView.mostrarErro("Erro ao buscar produto: " + e.getMessage());
                            }
                            break;
                        
                        case 0: 
                            JOptionPane.showMessageDialog(null, 
                                    "Encerrando o sistema... Até logo!", 
                                    "Encerramento", 
                                    JOptionPane.INFORMATION_MESSAGE);
                            break;
                        
                        default:
                            JOptionPane.showMessageDialog(null, 
                                    "Opção inválida! Escolha uma das opções do menu.", 
                                    "Aviso", 
                                    JOptionPane.WARNING_MESSAGE);
                    }
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, 
                            "Erro no menu: " + e.getMessage(), 
                            "Erro", 
                            JOptionPane.ERROR_MESSAGE);
                    System.err.println("Erro no menu: " + e.getMessage());
                    e.printStackTrace();
                }
                
            } while (opcao != 0);
            
        } catch (Exception e) {
            System.err.println("Erro crítico na aplicação: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, 
                    "Erro crítico: " + e.getMessage(), 
                    "Erro Fatal", 
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            
            if (scanner != null) {
                try {
                    scanner.close();
                } catch (Exception e) {
                    System.err.println("Erro ao fechar scanner: " + e.getMessage());
                }
            }
            System.out.println("Aplicação encerrada.");
        }
    }
}