public class Estimulo {
	private int quantidadeEstimulos;
	private double [][] estimulos;
	
	public Estimulo(int tamanhoDataset){
		calcularQuantidadeEstimulos(tamanhoDataset);
		gerarEstimulos(tamanhoDataset);
	}
	
	public void calcularQuantidadeEstimulos(int tamanhoDataset) {
		this.quantidadeEstimulos = (int) (Math.ceil(Math.sqrt(tamanhoDataset)) + 1);
	}
	
	public void gerarEstimulos(int tamanhoDataset) {
		estimulos = new double[tamanhoDataset][quantidadeEstimulos];
		
		//TO-DO
		//this.estimulos[][] = ;
	}
	
	public double getEstimulo(int x, int y) {
		return this.estimulos[x][y];
	}

	public int getQuantidadeEstimulos() {
		return quantidadeEstimulos;
	}
}
