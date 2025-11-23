package app;

import java.util.Scanner;

import app.controller.*;
import app.model.*;
import app.view.*;
import app.view.*;

/**
 * Classe principal da API
 * 
 * Esta classe representa o ponto de entrada do sistema, seguindo o padrão MVC.
 * Sua responsabilidade é inicializar o controlador principal e dar início ao fluxo inicial da aplicação (menu principal)
 * 
 * Estrutura MVC:
 * - Model: entidades e regras de negócio
 * - View: interação com o usuário (console/GUI)
 * - Controller: coordena a comunicação entre Model e View
 * 
 * @author Luiz Martins
 * @version 1.0
 * 
 */

public class Main {

	/**
	 * Método de entrada da aplicação
	 * Responsável por instanciar o UsuarioController, UsuarioDao e UsuarioView e inciar o sistema.
	 * 
	 * @param args (não utilizado)
	 */
	public static void main(String[] args) {
		
		// o armazenamento ocorre em usuário DAO
		UsuarioDao dao = new UsuarioDao();
		
		UsuarioView view = new UsuarioView();
		UsuarioController controller = new UsuarioController(dao, view);

		Scanner scanner = new Scanner(System.in);
		int opcao = -1;

		while (opcao != 0) {
			System.out.println("\n==== MENU USUÁRIOS ====");
			System.out.println("1. Adicionar usuário");
			System.out.println("2. Listar usuários");
			System.out.println("3. Atualizar usuário");
			System.out.println("4. Remover usuário");
			System.out.println("5. Buscar usuário por ID");
			System.out.println("0. Sair");
			System.out.print("Escolha: ");
			opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar buffer

			switch (opcao) {
			case 1:
				System.out.print("Nome: ");
				String nome = scanner.nextLine();
				System.out.print("Email: ");
				String email = scanner.nextLine();
				controller.criarUsuario(nome, email);
				break;
			case 2:
				controller.listarUsuarios();
				break;
			case 3:
				System.out.print("ID do usuário: ");
				controller.listarUsuarios();
				int idAtualizar = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Novo nome: ");
				String novoNome = scanner.nextLine();
				System.out.print("Novo email: ");
				String novoEmail = scanner.nextLine();
				controller.atualizarUsuario(idAtualizar, novoNome, novoEmail);
				break;
			case 4:
				System.out.print("ID do usuário: ");
				int idRemover = scanner.nextInt();
				controller.removerUsuario(idRemover);
				break;
			case 5:
				System.out.print("ID do usuário: ");
				int idBuscar = scanner.nextInt();
				controller.buscarUsuario(idBuscar);
				break;
			case 0:
				System.out.println("Encerrando...");
				break;
			default:
				System.out.println("Opção inválida.");
			}
		}

		scanner.close();
		
		MainView mv = new MainView();
		/* mais um comentário
		 * 
		 */
		
	}

}
