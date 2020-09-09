package Sistema.Principal;

import java.io.IOException;
import java.util.Scanner;

import Sistema.Entidades.Produto;

public class Main {

	public static void main(String[] args) throws IOException {
		int opcao = 0;
		do {
		if(opcao!=0)
			Main.LimparTela();
		Scanner entrada = new Scanner(System.in);
		System.out.println("\n\n BEM VINDO AO YOUTUBE ");	
		System.out.println("\n================================= \n|\t\t\t\t|");
		System.out.println("| ( 1 ) - ADICIONAR VENDA       | \n|\t\t\t\t|");
		System.out.println("| ( 2 ) - CONSULTAR VENDA       | \n|\t\t\t\t|");
		System.out.println("| ( 3 ) - ATUALIZAR VENDA       | \n|\t\t\t\t| ");
		System.out.println("| ( 4 ) - REMOVER VENDA         | \n|\t\t\t\t| ");
		System.out.println("| ( 0 ) - SAIR                  | \n|\t\t\t\t|");
		System.out.println("=================================\n");

		System.out.println(" Escolha uma das opções: ");
		opcao = entrada.nextInt();
		entrada.nextLine();
		System.out.print("\n");
		
		switch(opcao) {
		
		case 1:
			System.out.println("Digite a data da venda:");
			
			System.out.println("Escolha um dos produtos a baixo:\n\n");
			System.out.println("1 - Bermuda\n");
			System.out.println("2 - Sapato\n");
			System.out.println("3 - Camiseta\n");
			System.out.println("4 - Calção\n");
			System.out.println("5 - Tênis\n");
			System.out.println("6 - Óculos\n");
			int escolha = entrada.nextInt();
			entrada.nextLine();
			Produto.EscolheProduto(escolha);
			
			break;
		case 2:
			System.out.println("opcao2");
			break;
			
		case 3:
			System.out.println("opcao3");
			break;
			
		case 4:
			System.out.println("opcao4");
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

