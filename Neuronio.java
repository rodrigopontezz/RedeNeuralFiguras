import java.util.List;

public class Neuronio {
	private int quantidadeEstimulos;
	private int palpite;
	private int [] target;
	private double [] peso;
	private double taxaAprendizado;
	
	public Neuronio(int quantidadeEstimulos, int tamanhoDataset, List<Figura> listaFiguras, int indice) {
		this.taxaAprendizado = 0.3;
		this.quantidadeEstimulos = quantidadeEstimulos;
		this.peso = new double[quantidadeEstimulos];
		this.target = new int[tamanhoDataset];
		
		inicializaPesos(quantidadeEstimulos);
		gerarVetorTarget(listaFiguras,indice);
	}
	
	public void inicializaPesos(int quantidadeEstimulos) {
		for(int i = 0; i < quantidadeEstimulos; i++) {
			this.peso[i] = 0;
		}
	}
	
	public void gerarVetorTarget(List<Figura> listaFiguras, int indice) {
		int i = 0;
		for (Figura figura : listaFiguras) {
			
			char ch = figura.getTarget().charAt(indice);
			if (ch == '0') {
				this.target[i] = 0;
			} else {
				this.target[i] = 1;
			}				
			i++;	
		}
	}
	
	public void calculaSomatorio(int linha, double [] estimulos) {
		double somatorio = 0.0;
		
		/* CÁLCULO DO SOMATÓRIO */
		for (int i = 0; i < quantidadeEstimulos; i++) {
			somatorio += estimulos[i] * peso[i];
		}
		
		/* DEGRAU */
		if (somatorio > 0) {
			this.palpite = 1;
		} else {
			this.palpite = 0;
		}
	}
	
	public int getPalpite() {
		return this.palpite;
	}
	
	public void ajustarPesos(int [] estimulos, int indiceFigura/*int [] target, int somatorio, double taxaAprendizado*/) {
		for (int i = 0; i < quantidadeEstimulos; i++) {
			peso[i] = peso[i] + (target[indiceFigura] - palpite) * estimulos[i] * this.taxaAprendizado;
		}
	}
	
	public double getPesoAt(int x) {
	 	return this.peso[x];
	}
	
	public double getTargetAt(int x) {
		return this.target[x];
	}
}
