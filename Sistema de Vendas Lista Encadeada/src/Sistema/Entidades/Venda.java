package Sistema.Entidades;

public class Venda {
	private int date;
	private EncadeadaItem listaItens;
	
	public Venda(int date, EncadeadaItem listaItens) {
		super();
		this.date = date;
		this.listaItens = listaItens;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public EncadeadaItem getListaItens() {
		return listaItens;
	}

	public void setIListaItens(EncadeadaItem listaItens) {
		this.listaItens = listaItens;
	}
	
}
