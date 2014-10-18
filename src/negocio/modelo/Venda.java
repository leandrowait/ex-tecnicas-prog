package negocio.modelo;

import java.util.ArrayList;
import java.util.List;

public class Venda {
	private int codigo;
	private int quantidade;
	private double valor;
	private List<ItemVenda> itensVenda;

	public Venda(int codigo, int quantidade, double valor) {
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.valor = valor;
		this.itensVenda = new ArrayList<ItemVenda>();
	}

	public void addItemVenda(ItemVenda itemVenda) {
		itensVenda.add(itemVenda);
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

	public int getCodigo() {
		return codigo;
	}
}
