package Sistema.Entidades;

public class EncadeadaProduto {
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

	public EncadeadaProduto(){
		inicio = null;
		fim = null;
		tamanho = 0;
	}

	public int getTamanho(){
		return tamanho;
	}

	public void listarElementos(){
		Elemento aux = inicio;
		int cont = 0;
		while(aux!=null){
			System.out.println(cont + " ) Item: " + aux.produto.getNome() + " | Valor : " + aux.produto.getPreco());
			aux = aux.prox;
			cont++;
		}
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

	public Boolean removerInicio(){
		if(tamanho<0)
			return false;
		else if (tamanho == 1){
			inicio = null;
			fim = null;
			tamanho--;
			return true;
		}else {
			inicio = inicio.prox;
			tamanho--;
			return true;
		}
	}

	public Boolean removerFim(){
		if (tamanho<0)
			return false;
		else if (tamanho == 1){
			inicio = null;
			fim = null;
			tamanho--;
			return true;
		}else {		
			Elemento aux = inicio;
			for(int i=0; i<tamanho-2; i++)
				aux = aux.prox;
			aux.prox = null;
			fim = aux;
			tamanho--;
			return true;
		}
	}

	public Boolean removerElementoIndice(int indice){
		if (indice < 0 || indice > tamanho-1)
			return false;
		else if (indice == 0)
			return removerInicio();
		else if (indice == tamanho-1)
			return removerFim();

		Elemento aux = inicio;
		for(int i=0; i<indice-1; i++)
			aux=aux.prox;
		aux.prox = aux.prox.prox;
		tamanho--;
		return true;
	}

	public Boolean removerElementoValor(Produto produto){
		if (tamanho == 0)
			return false;

		if (inicio.produto.getNome().contentEquals(produto.getNome()))
			return removerInicio();

		Elemento aux = inicio;
		while(aux.prox != null){
			if (aux.prox.produto.getNome().contentEquals(produto.getNome()))
				break;
			else
				aux = aux.prox;
		}
		if (aux.prox == null)
			return false;

		if (aux.prox == fim)
			return removerFim();

		aux.prox = aux.prox.prox;
		tamanho--;
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