package Sistema.Principal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int opcao = 0;
		
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
			break;
		case 2:
			break;
			
		case 3:
			break;
			
		case 4:
			break;
			
		case 0:
			break;
		
		}
		
		
		
		
		
		
		entrada.close();
	}

}
