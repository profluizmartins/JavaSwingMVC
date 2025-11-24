// Arquivo: Main.java
package Aula08;

/**
 * @author Marllus Coutinho
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        UsuarioDao usuarioDao = new UsuarioDao();
        UsuarioView usuarioView = new UsuarioView();
        UsuarioController usuarioController = new UsuarioController(usuarioDao, usuarioView);

        ProdutoDao produtoDao = new ProdutoDao();
        ProdutoView produtoView = new ProdutoView();
        ProdutoController produtoController = new ProdutoController(produtoDao, produtoView);
        // -----------------------------------------------------------------

        String[] opcoesPrincipais = {"Gerenciar Usuários", "Gerenciar Produtos", "Sair"};

        while (true) {
            String opcaoPrincipal = ProdutoView.obterOpcao("Menu Principal", "Bem-vindo! O que deseja fazer?", opcoesPrincipais);

            if (opcaoPrincipal == null || opcaoPrincipal.equals("Sair")) {
                ProdutoView.info("Encerrando o sistema...");
                break;
            }

            switch (opcaoPrincipal) {
                case "Gerenciar Usuários":
                    gerenciarUsuarios(usuarioController);
                    break;
                case "Gerenciar Produtos":
                    gerenciarProdutos(produtoController);
                    break;
            }
        }
    }

    /**Método para criar menu do módulo Usuários
     *
     * @param usuarioController Classe instanciada Controller do módulo usuários.
     */
    public static void gerenciarUsuarios(UsuarioController usuarioController) {
        String[] opcoes = {"Adicionar", "Listar", "Atualizar", "Remover", "Buscar por ID", "Retornar"};

        while (true) {
            String opcao = UsuarioView.obterOpcao("Menu Usuário", "Escolha uma operação para usuários:", opcoes);

            if (opcao == null || opcao.equals("Retornar")) {
                break;
            }

            try {
                switch (opcao) {
                    case "Adicionar":
                        String nome = UsuarioView.lerTexto("Nome do usuário:");
                        String email = UsuarioView.lerTexto("Email do usuário:");
                        usuarioController.criarUsuario(nome, email);
                        break;
                    case "Listar":
                        usuarioController.listarUsuarios();
                        break;
                    case "Atualizar":
                        int idAtualizar = UsuarioView.lerInt("ID do usuário para atualizar:");
                        String novoNome = UsuarioView.lerTexto("Novo nome:");
                        String novoEmail = UsuarioView.lerTexto("Novo email:");
                        usuarioController.atualizarUsuario(idAtualizar, novoNome, novoEmail);
                        break;
                    case "Remover":
                        int idRemover = UsuarioView.lerInt("ID do usuário para remover:");
                        String[] botoesConfirmacao = {"Sim, remover", "Cancelar"};
                        String confirmacao = UsuarioView.obterOpcao("Confirmação", "Tem certeza?", botoesConfirmacao);

                        if ("Sim, remover".equals(confirmacao)) {
                            usuarioController.removerUsuario(idRemover);
                        }
                        break;
                    case "Buscar por ID":
                        int idBuscar = UsuarioView.lerInt("ID do usuário para buscar:");
                        usuarioController.buscarUsuario(idBuscar);
                        break;
                }
            } catch (OperacaoCanceladaException e) {
                UsuarioView.info("Operação cancelada.");
            }
        }
    }

    /**
     * Método para criar menu do módulo Produtos
     * @param produtoController classe Controller instanciada do módulo Produtos.
     */
    public static void gerenciarProdutos(ProdutoController produtoController) {
        String[] opcoes = {"Adicionar", "Listar", "Atualizar", "Remover", "Buscar por ID", "Buscar por Nome", "Retornar"};

        while (true) {
            String opcao = ProdutoView.obterOpcao("Menu Produto", "Escolha uma operação para produtos:", opcoes);

            if (opcao == null || opcao.equals("Retornar")) {
                break;
            }

            try {
                switch (opcao) {
                    case "Adicionar":
                        String nomeProd = ProdutoView.lerTexto("Nome do produto:");
                        double precoProd = ProdutoView.lerDouble("Preço do produto:");
                        produtoController.criarProduto(nomeProd, precoProd);
                        break;
                    case "Listar":
                        produtoController.listarProdutos();
                        break;
                    case "Atualizar":
                        int idUpdate = ProdutoView.lerInt("ID do produto para atualizar:");
                        String newNome = ProdutoView.lerTexto("Novo nome:");
                        double newPreco = ProdutoView.lerDouble("Novo preço:");
                        produtoController.atualizarProduto(idUpdate, newNome, newPreco);
                        break;
                    case "Remover":
                        int idRemove = ProdutoView.lerInt("ID do produto para remover:");
                        String[] botoesConfirmacao = {"Sim, remover", "Cancelar"};
                        String confirmacao = ProdutoView.obterOpcao("Confirmação", "Tem certeza?", botoesConfirmacao);
                        if ("Sim, remover".equals(confirmacao)) {
                            produtoController.removerProduto(idRemove);
                        }
                        break;
                    case "Buscar por ID":
                        int idBusca = ProdutoView.lerInt("ID do produto para buscar:");
                        produtoController.buscarProdutoId(idBusca);
                        break;
                    case "Buscar por Nome":
                        String nomeBusca = ProdutoView.lerTexto("Nome do produto para buscar:");
                        produtoController.buscarProdutoNome(nomeBusca);
                        break;
                }
            } catch (OperacaoCanceladaException e) {
                ProdutoView.info("Operação cancelada.");
            }
        }
    }
}