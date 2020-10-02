package Sistema.Entidades;

public class EncadeadaItem {
	public class Elemento{

		Item item;
		Elemento prox;

		public Elemento(Item item){
			this.item = item;
			this.prox = null;
		}		
		public Elemento (Item item, Elemento prox){
			this.item = item;
			this.prox = prox;
		}
	}

	Elemento inicio;
	Elemento fim;
	int tamanho;

	public EncadeadaItem(){
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
			System.out.println(cont + " ) Item: " + aux.item.getProduto().getNome() + " | Valor : " + aux.item.getProduto().getPreco());
			aux = aux.prox;
			cont++;
		}
		return true;
	}

	public Boolean inserirElementoInicio(Item item){
		Elemento novo = new Elemento(item, inicio);
		inicio = novo;
		if (tamanho==0){
			fim = novo;
		}
		tamanho++;
		return true;
	}

	public Boolean inserirElementoFim(Item item){
		Elemento novo = new Elemento(item);
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

	public Boolean inserirElementoIndice(Item item, int indice){
		if (indice < 0 || indice > tamanho)
			return false;
		else if(indice == 0)
			return inserirElementoInicio(item);
		else if(indice == tamanho)
			return inserirElementoFim(item);

		Elemento aux = inicio;
		for (int i=0; i<indice-1; i++)
			aux = aux.prox;
		Elemento novo = new Elemento(item, aux.prox);
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

	public Boolean AtualizarElementoIndice(int indice, Item item){
		if (indice < 0 || indice > tamanho)
			return false;
		
		Elemento aux = inicio;
		int cont = 0;
		while(aux!=null){
			if(indice == cont) {
				aux.item = item;
			}
			aux = aux.prox;
			cont++;
		}
		
		return true;
	}

	public Boolean removerElementoProduto(String remover){
		if (tamanho == 0)
			return false;

		if (inicio.item.getProduto().getNome().contentEquals(remover))
			return removerInicio();

		Elemento aux = inicio;
		while(aux.prox != null){
			if (aux.prox.item.getProduto().getNome().contentEquals(remover))
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
	
	public Produto VerificaProduto(String verifica){
		if (tamanho == 0)
			return null;

		Elemento aux = inicio;
		while(aux.prox != null){
			if (aux.item.getProduto().getNome().contentEquals(verifica))
				return aux.item.getProduto();
		}
		return null;
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