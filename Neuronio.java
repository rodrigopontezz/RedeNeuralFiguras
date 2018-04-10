import java.util.List;

public class Neuronio {
	private double [] peso;
	private double [] target;
	private double somatorio;
	private double taxaAprendizado;
	
	public Neuronio(int quantidadeEstimulos, int tamanhoDataset, double taxaAprendizado, List<Figura> listaFiguras) {
		this.taxaAprendizado = taxaAprendizado;
		this.peso = new double[quantidadeEstimulos];
		this.target = new double[tamanhoDataset];
		
		inicializaPesos(tamanhoDataset);
		gerarVetorTarget(listaFiguras);
	}
	
	public void inicializaPesos(int tamanhoDataset) {
		for(int i = 0; i < tamanhoDataset; i++) {
			this.peso[i] = 1;
		}
	}
	
	public void gerarVetorTarget(List<Figura> listaFiguras) {
		//TO-DO
		
		//this.target[] = ;
	}
	
	public void calculaSomatorio(int linha, int [] estimulos) {
		//TO-DO
		
		//this.somatorio = ;
	}
	
	public int palpite() {
		//TO-DO
		
		return 1; //TO-DO
	}
	
	public void ajustarPesos(int [] estimulos/*int [] target, int somatorio, double taxaAprendizado*/) {
		//TO-DO
		
		//this.peso[] = ;
	}
	
	/*public double getPeso(int x) {
	 	return this.peso[x];
	 }*/
}
