/*	 Implementa uma matriz de estímulos e seus métodos.
 * 
 *	 @version 2.0
 * 	 GitHub: https://github.com/rodrigopontezz/RedeNeuralFiguras
 */

package modelo;

public class Estimulo {
	private int quantidadeEstimulos;
	private double [][] estimulos;
	
	public Estimulo(int tamanhoDataset){
		calcularQuantidadeEstimulos(tamanhoDataset);
		gerarEstimulos(tamanhoDataset);
	}
	
	/* Método que calcula a quantidade de estímulos necessários para
	 * representar o dataset recebido, incluindo o estímulo fixo (bias).
	 */
	public void calcularQuantidadeEstimulos(int tamanhoDataset) {
		this.quantidadeEstimulos = (int) (Math.ceil(Math.sqrt(tamanhoDataset)) + 1);
	}
	
	/* Método para geração da matriz de estímulos.
	 */
	public void gerarEstimulos(int tamanhoDataset) {
		estimulos = new double[tamanhoDataset][quantidadeEstimulos];
		
		for(int i = 0; i < tamanhoDataset; i++) {
			String str = transformaDecimalEmBinario(i,quantidadeEstimulos-1);
			
			for(int j = 0; j < quantidadeEstimulos; j++) {
				if(j == 0) {
					this.estimulos[i][j] = 1.0;
				} else {
					if (str.charAt(j-1) == '1') {
						this.estimulos[i][j] = 1.0;
					} else {
						this.estimulos[i][j] = 0.0;
					}
				}
			}
		}
	}
	
	/* Método que recebe um número em decimal, e o tamanho em caracteres
	 * que a String de retorno deve conter. Retorna o número transformado
	 * em binário.
	 */
	public String transformaDecimalEmBinario(int numero, int tamanho) {
		int d = numero;
		StringBuffer str = new StringBuffer();
		while (d > 0) {
			int b = d % 2;
			str.append(b);
			d = d >> 1;
		}
		str = str.reverse();
		int completa = tamanho - str.length();
		StringBuffer aux = new StringBuffer();
		if(completa > 0) {
			for(int i = 0; i < completa; i++) {
				aux.append("0");
			}
		}
		
		aux.append(str.toString());
		return aux.toString();
	}

	public int getQuantidadeEstimulos() {
		return quantidadeEstimulos;
	}
		
	public double [] getVetorEstimulo(int linha) {
		return this.estimulos[linha];
	}
}
