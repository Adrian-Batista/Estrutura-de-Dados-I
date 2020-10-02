package Sistema.Principal;

import java.io.IOException;
import java.util.Scanner;

import Sistema.Entidades.EncadeadaProduto;
import Sistema.Entidades.EncadeadaVenda;
import Sistema.Entidades.Produto;
import Sistema.Entidades.Venda;

public class Main {

	public static void main(String[] args) throws IOException {
		int opcao = 0;
		int indice = 0;
		do {

			EncadeadaProduto obj = new EncadeadaProduto();

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

			case 1: // ~~~~~~~~~~~~~~~~~~~~~~~~~~~ MENU DE PRODUTOS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




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
						if(obj.listarElementos() == true) {
							System.out.println("\nDados listados com Sucesso!");
							System.in.read();
						}else {
							Main.LimparTela();
							System.out.println("Lista Vazia!");
							System.in.read();
						}

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
						Produto update = new Produto(null, 0);

						System.out.println("Digite o número / id do produto a ser atualizado:");
						int id = entrada.nextInt();
						entrada.nextLine();

						System.out.println("Digite o Nome do Produto atual: ");
						update.setNome(entrada.nextLine());
						System.out.println("Digite o valor do Produto atual: ");
						update.setPreco(entrada.nextDouble());
						entrada.nextLine();

						if(obj.AtualizarElementoIndice(id, update) == true) {
							System.out.println("\nDados Aualizados com Sucesso!");
							System.in.read();
						}else {
							Main.LimparTela();
							System.out.println("Dados não localizados tente novamente!");
							System.in.read();
						}

						break;

					case 4:

						System.out.println("Digite o Nome do Produto: ");
						String remover = entrada.nextLine();

						if(obj.removerElementoProduto(remover) == true) {
							System.out.println("\nDados Removidos com Sucesso!");
							System.in.read();
							indice--;
						}else {
							System.out.println("\nDados não localizados tente Novamente!");
							System.in.read();
						}

						break;
					}

				}while (opcao2 != 0);

				break;

			case 2: // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ADICIONAR VENDAS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

				System.out.println("Digite a data da venda:");

				Main.LimparTela();
				System.out.println("\n\n-------------- MENU DE VENDAS --------------- ");	
				System.out.println("\nData da Venda:  DATA");
				System.out.println("\n=========================================== \n|\t\t\t\t\t  |");
				System.out.println("| ( 1 ) - ADICIONAR PRODUTO               | \n|\t\t\t\t\t  |");
				System.out.println("| ( 0 ) - SAIR                            | \n|\t\t\t\t\t  |");
				System.out.println("===========================================\n");

				System.out.println(" Escolha uma das opções: ");
				opcao3 = entrada.nextInt();
				entrada.nextLine();
				System.out.print("\n");





				System.out.println("Digite o nome do Produto: ");
				String verifica = entrada.nextLine();

				objeto = obj.VerificaProduto(verifica);
				if(objeto==null) {
					System.out.println("Nome não localizado tente novamente!");
				}else {
					venda.getListaItens().inserirElementoFim(objeto);
				}

				break;




				break;

			case 3: // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LISTAR VENDAS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

				venda.getDate();
				venda.getListaItens().listarElementos();
				System.in.read();

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

