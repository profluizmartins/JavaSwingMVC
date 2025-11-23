package app;
import javax.swing.JOptionPane;
import app.controller.ProdutoController;
import app.model.ProdutoDao;
import app.view.ProdutoView;
/**
 * Classe principal da aplicação.
 * @author Enzo Fonseca
 * @version 1.0
 * Inicializa os componentes MVC e exibe o menu de opções.
 */
public class Main {
    /**
     * Ponto de entrada da aplicação.
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        int opcao;
        ProdutoDao dao = new ProdutoDao();
        ProdutoView view = new ProdutoView();
        ProdutoController controller = new ProdutoController(dao, view);
        Object[] escolhas = new Object[]{"Sair", "Adicionar", "Listar", "Atualizar", "Remover", "Buscar por ID", "Buscar por Nome"};

        while ((opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu Produto", -1, 1, null, escolhas, escolhas[0])) != 0 && opcao != -1) {
            try {
                switch (opcao) {
                    case 1: {
                        String nome = JOptionPane.showInputDialog(null, "Nome do Produto:", "Adicionar Produto", 3);
                        double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Preço do Produto:", "Adicionar Produto", 3));
                        controller.criarProduto(nome, preco);
                        break;
                    }
                    case 2: {
                        controller.listarProdutos();
                        break;
                    }
                    case 3: {
                        int idAtualizar = Integer.parseInt(JOptionPane.showInputDialog(null, "ID do produto para atualizar:", "Atualizar Produto", 3));
                        String novoNome = JOptionPane.showInputDialog(null, "Novo nome:", "Atualizar Produto", 3);
                        double novoPreco = Double.parseDouble(JOptionPane.showInputDialog(null, "Novo preço:", "Atualizar Produto", 3));
                        controller.atualizarProduto(idAtualizar, novoNome, novoPreco);
                        break;
                    }
                    case 4: {
                        int idRemover = Integer.parseInt(JOptionPane.showInputDialog(null, "ID do produto para remover:", "Remover Produto", 3));
                        controller.removerProduto(idRemover);
                        break;
                    }
                    case 5: {
                        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog(null, "ID do produto para buscar:", "Buscar Produto", 3));
                        controller.buscarProduto(idBuscar);
                        break;
                    }
                    case 6: {
                        String nomeBusca = JOptionPane.showInputDialog(null, "Digite o nome (ou parte do nome) para buscar:", "Buscar Produto por Nome", 3);
                        if (nomeBusca == null || nomeBusca.trim().isEmpty()) break;
                        controller.buscarProdutosPorNome(nomeBusca);
                        break;
                    }
                }
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número válido para ID ou Preço.", "Erro de Formato", 0);
            }
            catch (NullPointerException e) {
                // Captura quando o usuário clica em "Cancelar" ou fecha a janela
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Aviso", 2);
            }
        }
        System.out.println("Sistema encerrado.");
    }
}
