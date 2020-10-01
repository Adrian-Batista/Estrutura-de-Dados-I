package Sistema.Entidades;

public class Encadeada {
	public class Elemento{

		int valor;
		Elemento prox;

		public Elemento(int valor){
			this.valor = valor;
			this.prox = null;
		}		
		public Elemento (int valor, Elemento prox){
			this.valor = valor;
			this.prox = prox;
		}
	}

	Elemento inicio;
	Elemento fim;
	int tamanho;

	public Encadeada(){
		inicio = null;
		fim = null;
		tamanho = 0;
	}

	public int getTamanho(){
		return tamanho;
	}

	public void listarElementos(){
		Elemento aux = inicio;
		while(aux!=null){
			System.out.println(aux.valor +" "+aux.prox);
			aux = aux.prox;
		}
	}

	public Boolean inserirElementoInicio(int valor){
		Elemento novo = new Elemento(valor, inicio);
		inicio = novo;
		if (tamanho==0){
			fim = novo;
		}
		tamanho++;
		return true;
	}

	public Boolean inserirElementoFim(int valor){
		Elemento novo = new Elemento(valor);
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

	public Boolean inserirElementoIndice(int valor, int indice){
		if (indice < 0 || indice > tamanho)
			return false;
		else if(indice == 0)
			return inserirElementoInicio(valor);
		else if(indice == tamanho)
			return inserirElementoFim(valor);

		Elemento aux = inicio;
		for (int i=0; i<indice-1; i++)
			aux = aux.prox;
		Elemento novo = new Elemento(valor, aux.prox);
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

	public Boolean removerElementoValor(int valor){
		if (tamanho == 0)
			return false;

		if (inicio.valor == valor)
			return removerInicio();

		Elemento aux = inicio;
		while(aux.prox != null){
			if (aux.prox.valor == valor)
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
