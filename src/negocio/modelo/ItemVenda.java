package negocio.modelo;

public class ItemVenda {
	private int quantidade;
	private double valor;
	private Livro livro;

	public ItemVenda(int codigoVenda, int quantidade, double valor, Livro livro) {
		this.quantidade = quantidade;
		this.valor = valor;
		this.livro = livro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
