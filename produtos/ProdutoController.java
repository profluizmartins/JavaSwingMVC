
import java.util.List;
/**
 * Classe de controller
 * @since 1.0
 */
public class ProdutoController {
	/**
	 * Dao
	 */
	private ProdutoDao dao;
	/**
	 * View
	 */
	private ProdutoView view;
    /**
	 * 	Método construtor de um controller
	 * @param dao Dao
	 * @param view View
	 * @since 1.0
	 */
	public ProdutoController(ProdutoDao dao, ProdutoView view) {
		this.dao = dao;
		this.view = view;
	}
    /**
	 * Cria um produto e adiciona ele no List do DAO. Chama o método mostrarMensagem do View a fim de mostrar mensagem de sucesso caso o produto seja adicionado. Trata exceção de dados inválidos.
	 * @param nome Nome do produto
	 * @param preco Preço do produto
	 * @see ProdutoView
	 * @see ProdutoDao
	 */
	public void criarProduto(String nome, double preco){
		try{
		dao.adicionarProduto(nome, preco);
		view.mostrarMensagem("Produto adicionado com sucesso!", 0);}catch(DadosInvalidosException e){
          view.mostrarMensagem(e.getMessage(), 1);
		}
		
		
		
	}
	/**
	 * Esse método cria um List que recebe o return do método listar produtos do Dao. Chama o método listarProdutos do view e assim lista os produtos. Trata exceção de dados inválidos
	 * @see ProdutoView
	 * @see ProdutoDao
	 */
	public void listarProdutos() {
		List<Produto> produtos = dao.listarProdutos();
		view.listarProdutos(produtos);
	}
/**
 * Atualiza um produto cadastrado. Chama o método mostrarMensagem do view para emitir mensagem de sucesso ou erro. Trata exceção de dados inválidos.
 * @param id Novo ID
 * @param novoNome Novo nome
 * @param novoPreco Novo preço
 * @see ProdutoView
 */
	public void atualizarProduto(int id, String novoNome, double novoPreco) {
		try{
		boolean sucesso = dao.atualizarProduto(id, novoNome, novoPreco);
		if (sucesso) {
			view.mostrarMensagem("Produto atualizado com sucesso.", 0);
		} else {
			view.mostrarMensagem("Produto não encontrado." , 1);
		}
	
	  }catch(DadosInvalidosException e){
		view.mostrarMensagem(e.getMessage(), 1);
		}
	
	}
	/**
	 * Remove um produto do sistema. Chama o método mostrarMensagem do view para emitir mensagem de sucesso ou erro. Trata exceção de dados inválidos.
	 * @param id ID do produto a ser removido.
	 * @see ProdutoView
	 */
	public void removerProduto(int id) {
		try{
		boolean sucesso = dao.removerProduto(id);
		if (sucesso) {
			view.mostrarMensagem("Produto removido com sucesso.", 0);
		} else {
			view.mostrarMensagem("Produto não encontrado.", 1);
		}}catch(DadosInvalidosException e){
		 view.mostrarMensagem(e.getMessage(), 1);
		}
	}
    /**
	 * Busca um produto cadastrado por ID. Chama o método mostrarProduto do view. Trata exceção de dados inválidos.
	 * @param id Número de identificação do produto a ser pesquisado. 
	 * @see ProdutoView
	 */
	public void buscarProduto(int id) {
		try{
		Produto p = dao.buscarPorId(id);
		view.mostrarProduto(p);}catch(DadosInvalidosException e){
			view.mostrarMensagem(e.getMessage(), 1);
		}
	}
   /**
	 * Busca um produto cadastrado por nome. Chama o método mostrarProduto do view. Trata exceção de dados inválidos.
	 * @param nome Nome do produto a ser pesquisado.
	 * @see ProdutoView
	 */
	public void buscarProdutoNome(String nome){
		try{
	    Produto p= dao.buscarPorNome(nome);
	    view.mostrarProduto(p);}catch(DadosInvalidosException e){
			view.mostrarMensagem(e.getMessage(), 1);
		}
	    
}

}
