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

	public Boolean AtualizarElementoIndice(int indice, Produto produto){
		if (indice < 0 || indice > tamanho)
			return false;
		
		Elemento aux = inicio;
		int cont = 0;
		while(aux!=null){
			if(indice == cont) {
				aux.produto = produto;
			}
			aux = aux.prox;
			cont++;
		}
		
		return true;
	}

	public Boolean removerElementoProduto(String remover){
		if (tamanho == 0)
			return false;

		if (inicio.produto.getNome().contentEquals(remover))
			return removerInicio();

		Elemento aux = inicio;
		while(aux.prox != null){
			if (aux.prox.produto.getNome().contentEquals(remover))
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
		Produto vazio = new Produto(null, 0);
		if (tamanho == 0)
			return vazio;
		
		Elemento aux = inicio;
		while(aux != null){
			if (aux.produto.getNome().contentEquals(verifica)) {
				return aux.produto;
			}
			aux = aux.prox;	
		}
		return vazio;
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