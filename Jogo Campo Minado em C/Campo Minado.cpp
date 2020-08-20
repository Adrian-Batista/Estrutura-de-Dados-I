// ------------------------- CAMPO MINADO -------------------------------------
#include<stdio.h>
#include <conio.h>
#include<stdlib.h>

int main (){
	
	
	int reiniciar=1;
	while(reiniciar==1){
	char usuario[10];
	int i, j, k, linha, coluna, bomba=0, b1, b2, c1, c2, contador=1, cont=0;
	
	printf(" ----------------- CAMPO MINADO -----------------\n");
	printf("- OBS: o programa aceita matrizes de 3 a 10 \n");
	printf("- OBS: O CAMPO TEM DE SER MATRIZ QUADRADA!\n");
	printf("- Digite o tamanho da matriz quadrada: ");
	scanf("%d", &linha);
	
	while(linha<3 or linha>10){
		if(linha<3){
			system("cls");
			printf("Valores muito baixos, repita a operacao! \n");			// condicao limitadora de matriz 3 a 10 
			printf("- Digite o tamanho da matriz quadrada: ");
			scanf("%d", &linha);
		}
		if(linha>10){
			system("cls");
			printf("Valores muito altos, repita a operacao! \n");	 
			printf("- Digite o tamanho da matriz quadrada: ");
			scanf("%d", &linha);
		}
	}
	coluna=linha;	
	printf("- Digite a quantidade de bombas que voce deseja: ");
	scanf("%d", &bomba);
	
	while(bomba>(linha*linha)){
		system("cls");
		printf("Valores muito altos repita a operacao! \n");			// condicao limitadora de bomba 
		printf("- Digite a quantidade de bombas que voce deseja: ");
		scanf("%d", &bomba);
	}
		while(bomba<1){
		system("cls");
		printf("Valor muito baixo repita a operacao! \n");			// condicao limitadora de bomba 
		printf("- Digite a quantidade de bombas que voce deseja: ");
		scanf("%d", &bomba);
	}
	
	int campo[linha+1][coluna+1];
	int campoTela[linha+1][coluna+1];
	
//----------------------------------------------------------------------------
	for(i=0;i<linha;i++){
			for(j=0;j<coluna;j++){
					campo[i][j]=0;
					campoTela[i][j]=-1;
			}
		}
		
	for(j=0;j<bomba;j++){
		b1=rand() % linha;
		b2=rand() % coluna;
		while(campo[b1][b2]==-1){
			b1=rand() % linha;
			b2=rand() % coluna;
		}
		campo[b1][b2]=-1;
	}
	printf("\n");
	
	
	for(i=0;i<linha;i++){
		for(j=0;j<coluna;j++){
			if(campo[i][j]==-1){
				if(campo[i-1][j-1]!=-1)
					campo[i-1][j-1]++;
				if(campo[i-1][j]!=-1)
					campo[i-1][j]++;
				if(campo[i-1][j+1]!=-1)
					campo[i-1][j+1]++;
				if(campo[i][j-1]!=-1)
					campo[i][j-1]++;
				if(campo[i][j+1]!=-1)
					campo[i][j+1]++;
				if(campo[i+1][j-1]!=-1)
					campo[i+1][j-1]++;
				if(campo[i+1][j]!=-1)
					campo[i+1][j]++;
				if(campo[i+1][j+1]!=-1)
					campo[i+1][j+1]++;
			}
		}
	}
		printf("\n");
		for(i=0;i<linha;i++){
			for(j=0;j<coluna;j++){
				if(campoTela[i][j]==-1)
					printf("| # ");
				else
					printf("| %c ", campoTela[i][j]);
			}
			printf("\n");
		}
		
// ----------------------------------------------------------------
		
	while(contador==1){
		if(cont+bomba==linha*coluna){
			printf("\n ---------------- !!!!! PARABENS VOCE VENCEU !!!!! -------------------------");
			break;
		}
		printf("Digite a linha a ser localizada: ");
		scanf("%d", &c1);
		while(c1<0 or c1>linha-1){
			if(c1<0){
				system("cls");
				printf("\n");				
				for(i=0;i<linha;i++){
					for(j=0;j<coluna;j++){
						if(campoTela[i][j]==-1)
							printf("| # ");
						else
							printf("| %c ", campoTela[i][j]);
					}
					printf("\n");
				}
				printf("\n");
				printf("Valores muito baixos, repita a operacao! \n");													
				printf("Digite a linha a ser localizada: ");
				scanf("%d", &c1);
			}
			if(c1>linha-1){
				system("cls");
				printf("\n");
				for(i=0;i<linha;i++){
					for(j=0;j<coluna;j++){
						if(campoTela[i][j]==-1)
							printf("| # ");
						else
							printf("| %c ", campoTela[i][j]);
					}
					printf("\n");
				}
				printf("\n");
				printf("Valores muito altos, repita a operacao! \n");													
				printf("Digite a linha a ser localizada: ");
				scanf("%d", &c1);
			}	
		}
		
		printf("Digite a coluna a ser localizada: ");
		scanf("%d", &c2);
		while(c2<0 or c2>linha){
			if(c2<0){
				system("cls");
				printf("Valores muito baixos, repita a operacao! \n");													
				printf("Digite a coluna a ser localizada: ");
				scanf("%d", &c2);
			}
			if(c2>linha){
				system("cls");
				printf("Valores muito altos, repita a operacao! \n");													
				printf("Digite a coluna a ser localizada: ");
				scanf("%d", &c2);
			}	
		}
		system("cls");
		
			
		if(campo[c1][c2]==-1){
			printf("Que pena, voce perdeu!!");
			contador=2;
		}else{
			if(campoTela[c1][c2]==campo[c1][c2]){
				printf("Valor ja digitado!\n");
				break;
			}
			if(campoTela[c1][c2] != campo[c1][c2]){
				campoTela[c1][c2] = campo[c1][c2];
				cont++;
			}
					printf("\n");
		for(i=0;i<linha;i++){
			for(j=0;j<coluna;j++){
				if(campoTela[i][j]==-1)
					printf("| # ");
				else
					printf("| %d ", campoTela[i][j]);
			}
			printf("\n");
		}
			
		}
	}

	
	  	printf("\nDeseja refazer a operacao? [SIM=1/NAO=2]");
	  	scanf("%d", &reiniciar);
	  	bomba=0;
	}
	return 0;
}
