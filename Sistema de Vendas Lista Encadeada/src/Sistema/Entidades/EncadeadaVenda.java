package Sistema.Entidades;

public class EncadeadaVenda {
	public class Elemento{

		Produto produto;
		Elemento prox;

		public Elemento(Produto produto){
			this.produto = produto;
			this.prox = null;
		}		
		public Elemento (Produto produto, Elemento prox){
			this.produto = produto;
			this.prox = prox;
		}
	}

	Elemento inicio;
	Elemento fim;
	int tamanho;

	public EncadeadaVenda(){
		inicio = null;
		fim = null;
		tamanho = 0;
	}

	public int getTamanho(){
		return tamanho;
	}

	public Boolean listarElementos(){
		Elemento aux = inicio;
		int cont = 0;
		
		if(tamanho == 0) {
			return false;
		}

		while(aux!=null){
			System.out.println(cont + " ) Item: " + aux.produto.getNome() + " | Valor : " + aux.produto.getPreco());
			aux = aux.prox;
			cont++;
		}
		return true;
	}

	public Boolean inserirElementoInicio(Produto produto){
		Elemento novo = new Elemento(produto, inicio);
		inicio = novo;
		if (tamanho==0){
			fim = novo;
		}
		tamanho++;
		return true;
	}

	public Boolean inserirElementoFim(Produto produto){
		Elemento novo = new Elemento(produto);
		if (tamanho == 0){
			inicio = novo;
			fim = novo;
		}else{
			fim.prox = novo;
			fim = novo;
		}
		tamanho++;
		return true;
	}

	public Boolean inserirElementoIndice(Produto produto, int indice){
		if (indice < 0 || indice > tamanho)
			return false;
		else if(indice == 0)
			return inserirElementoInicio(produto);
		else if(indice == tamanho)
			return inserirElementoFim(produto);

		Elemento aux = inicio;
		for (int i=0; i<indice-1; i++)
			aux = aux.prox;
		Elemento novo = new Elemento(produto, aux.prox);
		aux.prox = novo;
		tamanho++;
		return true;
	}

	public Elemento getElemento(int indice){
		if (indice < 0 || indice > tamanho-1)
			return null;
		else if (indice == 0)
			return inicio;
		else if (indice == tamanho-1)
			return fim;

		Elemento aux = inicio;
		for(int i=0; i<indice; i++)
			aux=aux.prox;
		return aux;
	}

}

