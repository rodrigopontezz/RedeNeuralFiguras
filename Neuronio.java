import java.util.List;

public class Neuronio {
	private int quantidadeEstimulos;
	private int [] palpite;
	private int [] target;
	private double [] peso;
	private double taxaAprendizado;
	
	public Neuronio (int quantidadeEstimulos, int tamanhoDataset, List<Treinavel> listaTreinavel, int indice) {
		this.taxaAprendizado = 0.3;
		this.quantidadeEstimulos = quantidadeEstimulos;
		this.peso = new double[quantidadeEstimulos];
		this.target = new int[tamanhoDataset];
		this.palpite = new int[tamanhoDataset];
		
		inicializaPesos(quantidadeEstimulos);
		gerarVetorTarget(listaTreinavel,indice);
	}
	
	public void inicializaPesos(int quantidadeEstimulos) {
		for(int i = 0; i < quantidadeEstimulos; i++) {
			this.peso[i] = 0;
		}
	}
	
	public void gerarVetorTarget(List<Treinavel> listaTreinavel, int indice) {
		int i = 0;
		for (Treinavel treinavel : listaTreinavel) {
			
			char ch = treinavel.getTarget().charAt(indice);
			if (ch == '0') {
				this.target[i] = 0;
			} else {
				this.target[i] = 1;
			}				
			i++;	
		}
	}
	
	public boolean aplicarEstimulos(double [] estimulos, int indiceFigura) {
		double somatorio = 0.0;
		
		/* CÁLCULO DO SOMATÓRIO */
		for (int i = 0; i < quantidadeEstimulos; i++) {
			somatorio += estimulos[i] * peso[i];
		}
		
		/* DEGRAU */
		if (somatorio > 0) {
			this.palpite[indiceFigura] = 1;
		} else {
			this.palpite[indiceFigura] = 0;
		}
		
		if (this.palpite[indiceFigura] != this.target[indiceFigura]) {
			ajustarPesos(estimulos, indiceFigura);
			return true;
		}
		
		return false;
	}
	
	public void ajustarPesos(double [] estimulos, int indiceFigura) {
		for (int i = 0; i < quantidadeEstimulos; i++) {
			peso[i] = peso[i] + (target[indiceFigura] - palpite[indiceFigura]) * estimulos[i] * this.taxaAprendizado;
		}
	}
	
	public double getPesoAt(int x) {
	 	return this.peso[x];
	}
	
	public int getTargetAt(int x) {
		return this.target[x];
	}
	
	public int getPalpiteAt(int x) {
		return palpite[x];
	}
}
