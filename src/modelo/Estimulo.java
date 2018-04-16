package modelo;

/*	 Implementa uma matriz de estímulos e seus métodos.
 * 
 * 	 @author Rodrigo Pontes
 *	 @version 1.1
 */

public class Estimulo {
	private int quantidadeEstimulos;
	private double [][] estimulos;
	
	public Estimulo(int tamanhoDataset){
		calcularQuantidadeEstimulos(tamanhoDataset);
		gerarEstimulos(tamanhoDataset);
	}
	
	/* M�todo que calcula a quantidade de est�mulos necess�rios para
	 * representar o dataset recebido, incluindo o est�mulo fixo (bias).
	 */
	public void calcularQuantidadeEstimulos(int tamanhoDataset) {
		this.quantidadeEstimulos = (int) (Math.ceil(Math.sqrt(tamanhoDataset)) + 1);
	}
	
	/* M�todo para gera��o da matriz de est�mulos.
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
	
	/* M�todo que recebe um n�mero em decimal, e o tamanho em caracteres
	 * que a String de retorno deve conter. Retorna o n�mero transformado
	 * em bin�rio.
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
