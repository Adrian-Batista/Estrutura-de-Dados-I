package Sistema.Principal;

import java.io.IOException;
import java.util.Scanner;

import Sistema.Entidades.EncadeadaProduto;
import Sistema.Entidades.Produto;

public class Main {

	public static void main(String[] args) throws IOException {
		int opcao = 0;
		int indice = 0;
		int aux = 10;
		do {
			if(opcao!=0)
				Main.LimparTela();
			Scanner entrada = new Scanner(System.in);
			System.out.println("\n\n BEM VINDO AO YOUTUBE ");	
			System.out.println("\n================================= \n|\t\t\t\t|");
			System.out.println("| ( 1 ) - MENU DE PRODUTOS      | \n|\t\t\t\t|");
			System.out.println("| ( 2 ) - ADICIONAR VENDA       | \n|\t\t\t\t|");
			System.out.println("| ( 3 ) - LISTAR VENDAS         | \n|\t\t\t\t| ");
			System.out.println("| ( 0 ) - SAIR                  | \n|\t\t\t\t|");
			System.out.println("=================================\n");

			System.out.println(" Escolha uma das opções: ");
			opcao = entrada.nextInt();
			entrada.nextLine();
			System.out.print("\n");

			switch(opcao) {

			case 1:
				EncadeadaProduto obj = new EncadeadaProduto();
				

				int opcao2 = 0;
				do {
					Main.LimparTela();
					System.out.println("\n\n-------------- MENU DE PRODUTOS --------------- ");	
					System.out.println("\n================================= \n|\t\t\t\t|");
					System.out.println("| ( 1 ) - LISTAR PRODUTOS       | \n|\t\t\t\t|");
					System.out.println("| ( 2 ) - ADICIONAR PRODUTO     | \n|\t\t\t\t|");
					System.out.println("| ( 3 ) - ATUALIZAR PRODUTO     | \n|\t\t\t\t| ");
					System.out.println("| ( 4 ) - REMOVER PRODUTO       | \n|\t\t\t\t| ");
					System.out.println("| ( 0 ) - SAIR                  | \n|\t\t\t\t|");
					System.out.println("=================================\n");

					System.out.println(" Escolha uma das opções: ");
					opcao2 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");

					switch(opcao2) {

					case 1:
						obj.listarElementos();

						System.out.println("Dados listados com Sucesso!");
						System.in.read();
						break;

					case 2:
						Produto produto = new Produto(null, 0);
						
						System.out.println("Digite o Nome do Produto: ");
						produto.setNome(entrada.nextLine());
						System.out.println("Digite o valor do Produto: ");
						produto.setPreco(entrada.nextDouble());
						entrada.nextLine();
						
						obj.inserirElementoIndice(produto, indice);
						indice++;
						
						
						System.out.println("\nDados Cadastrados com Sucesso!");
						System.in.read();

						break;

					case 3:
						break;

					}

				}while (opcao2 != 0);


				break;
			case 2:
				System.out.println("opcao2");
				break;

			case 3:
				System.out.println("opcao3");
				break;

			case 0:
				break;

			default:
				System.out.println("Opção Inválida!");
				System.out.println("Pressione Enter.!");
				System.in.read();

			}

		}while (opcao != 0);

	}


	public static void LimparTela() {
		for(int i = 0; i < 100; i++)
			System.out.println("");
	}
}

