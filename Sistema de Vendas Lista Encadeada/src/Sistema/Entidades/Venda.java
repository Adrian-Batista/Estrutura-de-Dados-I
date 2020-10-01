package Sistema.Entidades;

public class Venda {
	private int date;
	private EncadeadaProduto listaItens;
	
	public Venda(int date, EncadeadaProduto listaItens) {
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

	public EncadeadaProduto getListaItens() {
		return listaItens;
	}

	public void setIListaItens(EncadeadaProduto listaItens) {
		this.listaItens = listaItens;
	}
	
}
