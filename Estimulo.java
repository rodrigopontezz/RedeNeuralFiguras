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
	
	/*public String transformaDecimalEmBinario(int numero, int tamanhoTarget) {
		int d = numero;
		StringBuffer str = new StringBuffer();
		while (d > 0) {
			int b = d % 2;
			str.append(b);
			d = d >> 1;
		}
		str = str.reverse();
		int completa = tamanhoTarget - str.length();
		StringBuffer aux = new StringBuffer();
		if(completa > 0) {
			for(int i = 0; i < completa; i++) {
				aux.append("0");
			}
		}
		
		aux.append(str.toString());
		return aux.toString();
	}*/
	
	/*public static int calculaDigitosBinarios(int num) {
	num++;
	int count = 0;
	
	while(num > 1) {
		num = (int) Math.ceil(num / 2.0);
		count++;
	}
	
	return count;
}*/
}
