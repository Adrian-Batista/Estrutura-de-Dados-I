package Sistema.Entidades;

public class EncadeadaVenda {
	public class Elemento{

		Venda venda;
		Elemento prox;

		public Elemento(Venda venda){
			this.venda = venda;
			this.prox = null;
		}		
		public Elemento (Venda venda, Elemento prox){
			this.venda = venda;
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
			System.out.println("\n ---------------------------------------------------------------\n");
			System.out.println(" Data da Venda: "  + aux.venda.getDate());
			aux.venda.getListaItens().listarElementos();
			aux = aux.prox;
			cont++;
		}
		System.out.println("\n ---------------------------------------------------------------\n");
		return true;
	}

	public Boolean inserirElementoFim(Venda venda){
		Elemento novo = new Elemento(venda);
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


