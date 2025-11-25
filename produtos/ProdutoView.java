
import java.util.List;

import javax.swing.JOptionPane;
/**
 * Classe de view
 * @since 1.0
 */
public class ProdutoView {
	/**
	 * Mostra um produto. 
	 * @param produto Produto a ser procurado.
	 */
	 public void mostrarProduto(Produto produto) {
	        if (produto != null) {
				String aux ="ID: "+produto.getId()+"\nNome: "+produto.getNome()+"\nPreço: "+produto.getPreco();

			JOptionPane.showMessageDialog(null, aux ,"Mostrar produto", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null,  "Produto não encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }
 /**
  * Lista produtos.
  * @param produtos Lista de produtos.
  */
	    public void listarProdutos(List<Produto> produtos) {
	        if (produtos.isEmpty()) {
	            JOptionPane.showMessageDialog(null,  "Nenhum produto cadastrado", "Erro", JOptionPane.ERROR_MESSAGE);
	        
	        } else {
	            for (Produto p : produtos) {
	                mostrarProduto(p);
	            }
	        }
	    }
 /**
  * Mostra uma mensagem ao usuário.
  * @param mensagem Texto da mensagem
  * @param tipo Tipo de ícone a ser mostrado.
  */
	    public void mostrarMensagem(String mensagem, int tipo) {
			if(tipo==0){
	        JOptionPane.showMessageDialog(null, mensagem, "Mensagem", JOptionPane.INFORMATION_MESSAGE);}
		if(tipo==1){JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);}
	        }
	    }
