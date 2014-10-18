package negocio;

import java.util.ArrayList;
import java.util.List;

public class CalculoDireitosAutoraisComposite implements
		CalculoDireitosAutorais {
	private List<CalculoDireitosAutorais> listaCalcDireitosAutorais;

	public CalculoDireitosAutoraisComposite(int codigoEditora, int mes) {
		this.listaCalcDireitosAutorais = new ArrayList<CalculoDireitosAutorais>();
	}

	public void add(CalculoDireitosAutorais calculoDireitosAutorais) {
		listaCalcDireitosAutorais.add(calculoDireitosAutorais);
	}

	@Override
	public double calcularDireitosAutoraisMes(int codigoEditora, int mes) {
		return listaCalcDireitosAutorais
				.stream()
				.mapToDouble(
						d -> calcularDireitosAutoraisMes(codigoEditora, mes))
				.sum();
	}

}
