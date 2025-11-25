
import javax.swing.JOptionPane;
/**    
 * Classe main
	 * @author Luiz Martins e Geovane Santos Ribeiro
	 * @version 2.0
	 * @since 1.0
	 */
public class Main {
 /**
  * Método main contém um loop em que executa o menu de opções, usando while e switch-case. Opções: 1. Adicionar produto", "2. Listar produtos", "3. Atualizar produto", "4. Remover produto", "5. Buscar produto por ID ou nome";
  * @param args
  */
	public static void main(String[] args){
			Object[] opcoes={"1. Adicionar produto", "2. Listar produtos", "3. Atualizar produto", "4. Remover produto", "5. Buscar produto por ID ou nome"};
			ProdutoDao dao = new ProdutoDao();
			ProdutoView view = new ProdutoView();
			ProdutoController controller = new ProdutoController(dao, view);
			Object opcao = null;
			int controle=0;
			String novoNome="";
			String idAt="";
			String idrev="";
			String opcoesbusca[]={"Nome", "ID"};
			String np="";
			Object opcaobusca=null;
		
JOptionPane.showMessageDialog(null, "Bem-vindo ao sistema de gereciamento de produtos!", "Inicializando a aplicação", JOptionPane.INFORMATION_MESSAGE);
			do{
	
				opcao=JOptionPane.showInputDialog(null, "Qual opção deseja executar?", "Opções do menu", JOptionPane.QUESTION_MESSAGE,  null,opcoes, opcoes[0]);
				if(opcao==opcoes[0]){
						controle=1;
				}
				if(opcao==opcoes[1]){
						controle=2;
				}
				if(opcao==opcoes[2]){
						controle=3;
				}
				if(opcao==opcoes[3]){
						controle=4;
				}
				if(opcao==opcoes[4]){
						controle=5;
				}
				if(opcao==null){
					controle=6;
				}
				switch (controle) {
				case 1:
					String nome="";
					String precoaux="";
					double preco=0;
						nome = JOptionPane.showInputDialog(null , "Digite o nome: ");
					    precoaux= JOptionPane.showInputDialog(null , "Digite o preço: ");
						if(nome==null){
							nome="";
						}
						if(precoaux==null){
							precoaux="0";
						}
						if(precoaux.length()==0){
							precoaux="0";
						}
						
						try{preco=Double.parseDouble(precoaux);}catch(NumberFormatException e){
							view.mostrarMensagem("O preço deve ser um número positivo!", 1);
						}
						
						controller.criarProduto(nome, preco);
				
				
				
				
					break;
	        
					
				case 2:
					controller.listarProdutos();
					break;
				case 3:
					int idat=0;
					double novopreco=0;
					idAt=JOptionPane.showInputDialog(null , "Digite o ID: ");
					if(idAt==null){
						idAt="-1";
					}
					if(idAt.length()==0){
						idAt="-1";
					}
					try{
					idat=Integer.parseInt(idAt);}catch(NumberFormatException e){view.mostrarMensagem("O ID deve ser um inteiro positivo!", 1);}
					novoNome = JOptionPane.showInputDialog(null, "Digite o nome: ");
					if(novoNome==null){
						novoNome="";
					}
					np = JOptionPane.showInputDialog(null, "Digite o novo preço");
					if(np==null){
						np="0";
					}
					if(np.length()==0){
						np="0";
					}
					try{novopreco=Double.parseDouble(np);}catch(NumberFormatException e){view.mostrarMensagem("O preço deve ser positivo!", 1);}
					controller.atualizarProduto(idat, novoNome, novopreco );
				
					break;
				case 4:
					int idremover=0;
					idrev=JOptionPane.showInputDialog(null, "Digite o ID do produto:");
                    if(idrev==null){
						idrev="-1";
					}
					if(idrev.length()==0){
						idrev="-1";
					}
					try{
					idremover=Integer.parseInt(idrev);}catch(NumberFormatException e){view.mostrarMensagem("O ID deve ser um inteiro positivo!", 1);}
					controller.removerProduto(idremover);
					break;
				case 5:
				
				    opcaobusca=JOptionPane.showInputDialog(null, "Deseja buscar o produto pelo nome ou pelo ID?", "Selecionar opção de busca", JOptionPane.QUESTION_MESSAGE,null, opcoesbusca, opcoesbusca[0]);
					if(opcaobusca==null){
						break;
					}
				    if(opcaobusca==opcoesbusca[0]){
				        String buscarnome=JOptionPane.showInputDialog(null, "Digite o nome: ");
					if(buscarnome==null){
							break;
						}
				        controller.buscarProdutoNome(buscarnome);

				    }else if(opcaobusca==opcoesbusca[1]){
					String buscarid=JOptionPane.showInputDialog(null, "DIgite o ID: ");
											if(buscarid==null){
					break;
				}
							if(buscarid.length()==0){
						buscarid="-1";							
						}
						int idbusca=0;
						try{
						idbusca= Integer.parseInt(buscarid);}catch(NumberFormatException e){view.mostrarMensagem("O ID deve ser um inteiro positivo!", 1);}
					controller.buscarProduto(idbusca);}
					break;
					case 6:
					JOptionPane.showMessageDialog(null, "Obrigado pela preferênci", "Encerrando o programa", JOptionPane.INFORMATION_MESSAGE);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Obrigado pela preferência", "Encerrando o programa", JOptionPane.INFORMATION_MESSAGE);
					break;
			}}while(controle!=6);
		}}
	


