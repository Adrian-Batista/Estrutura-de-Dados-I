#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Produto{
	char nome[30];
	float preco;
}Produto;

typedef struct Item{
	int quantidade;
	Produto *Produto = NULL;
}Item;

typedef struct Venda{
	char data[10];
	Item *vItens[5];
	int quantVenda=0;
}Venda;

int main(){
	int i,j, aux, opt, parte1=0, auxiliar=0, parte2=0, contador=0, contador1;
	char nomeProduto[30];
	Produto *vProdutos[10];
	Venda *vVenda[10];

	vProdutos[0] = (Produto*) malloc(sizeof(Produto));
	strcpy(vProdutos[0]->nome, "CAMISETA\0");
	vProdutos[0]->preco = 55.5;
	vProdutos[1] = (Produto*) malloc(sizeof(Produto));
	strcpy(vProdutos[1]->nome, "SAPATO\0");
	vProdutos[1]->preco = 160;
	vProdutos[2] = (Produto*) malloc(sizeof(Produto));
	strcpy(vProdutos[2]->nome, "BERMUDA\0");
	vProdutos[2]->preco = 80;
	vProdutos[3] = (Produto*) malloc(sizeof(Produto));
	strcpy(vProdutos[3]->nome, "JAQUETA\0");
	vProdutos[3]->preco = 35;
	vProdutos[4] = (Produto*) malloc(sizeof(Produto));
	strcpy(vProdutos[4]->nome, "MEIA\0");
	vProdutos[4]->preco = 15;

	do{
		system("cls");
		printf("----------------------- SISTEMA DE VENDAS -----------------------\n\n(1) - LISTAR PRODUTOS\n(2) - INCLUIR VENDA\n(3) - LISTAR VENDAS\n(4) - SAIR\n");
		scanf("%d",&opt);
		system("cls");
		switch(opt){
			case 1:
				printf("-----------------------------\n");
				for(i=0;i<5;i++){
					printf("- %s\n", vProdutos[i]->nome);
				}
				printf("-----------------------------\n");
				system("pause");
				break;
				
					
			case 2:
				contador1=0;
				system("cls");
				vVenda[parte1] = (Venda*) malloc(sizeof(Venda));
				printf("Digite a data da venda : ");
				scanf("%s", &vVenda[parte1]->data);
				parte2=0;
				
				while(auxiliar<5){
					
					printf("ATENCAO - DIGITE EM MAIUSCULO ALGUM PRODUTO ABAIXO!\n");
					printf("-----------------------------\n");
						for(i=0;i<5;i++){
							printf("- %s\n", vProdutos[i]->nome);
						}
					printf("-----------------------------\n");
				
					printf("Digite o nome do produto desejado : ");
					scanf("%s", &nomeProduto);
					for(j=0;j<6; j++){
						if(strcmp(nomeProduto, vProdutos[j]->nome)==0){
							vVenda[parte1]->vItens[parte2] = (Item*) malloc(sizeof(Item));
							vVenda[parte1]->vItens[parte2]->Produto = vProdutos[j];
							printf("Digite a quantidade: ");
							scanf("%d", &vVenda[parte1]->vItens[parte2]->quantidade);
							parte2++;
							contador=1;
							contador1++;
							break;
						}
						
					}
					if(contador!=1){
							printf("\nDados nao encotrados, refaca a operacao!!\n");
							system("pause");
							system("cls");
							
						}
					if(contador==1){
						contador=0;
						auxiliar++;
						system("cls");
						printf("Dados armazenados com sucesso!!\n");
						printf("Deseja relizar a venda de mais um item? [ (1)Sim / (2)Nao ]");
						scanf("%d", &aux);
						vVenda[parte1]->quantVenda = contador1;
						if(aux!=1){
							parte1++;
							break;
						}
					}
				}
				break;
			case 3:
				for(i=0;i<parte1;i++){
					printf("\n\nDATA DA COMPRA : %s\n\n", vVenda[i]->data);
						for(j=0;j<vVenda[i]->quantVenda;j++){
							printf("PRODUTO: %s\nQUANTIDADE : %d\nPRECO : R$ %.2f\n---------------------------------\n", vVenda[i]->vItens[j]->Produto, vVenda[i]->vItens[j]->quantidade, vVenda[i]->vItens[j]->Produto->preco);
						}
				}
				system("pause");
				break;
			case 4:
				opt = 0;
				break;
			default:
				opt = 0;
				break;
		}
	}while(opt!=0);	
	return 0;
}
