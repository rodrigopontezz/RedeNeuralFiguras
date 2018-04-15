/*	 Implementação de neurônios que treinarão a rede neural.
 * 
 * 	 @author Rodrigo Pontes
 *	 @version 1.1
 */

import java.util.List;

public class Neuronio {
	private int quantidadeEstimulos;
	private int [] palpite;
	private int [] target;
	private double [] peso;
	private double taxaAprendizado;
	
	/*	Construtor que inicializa o neurônio de acordo com a interface
	 *  Treinavel, que pode receber uma lista de formas ou cores para
	 *  treinamento.
	 */
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
	
	/* Método que gera o vetor de targets para o neurônio. Cada item "i" deste
	 * vetor representa a resposta desejável para o conjunto de estímulos "i"
	 * que receber posteriormente. 
	 */
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
	
	/* Método que recebe um conjunto de estímulos "i", calcula o somatório de
	 * acordo com o vetor de pesos atual do neurônio e arrisca um palpite. Caso
	 * o palpite do neurônio não corresponda com a resposta desejável (vetor de 
	 * targets "i"), reajusta os pesos.
	 */
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
	
	/* Método que reajusta os pesos do neurônio de acordo com um conjunto
	 * de estímulos "i" recebido.
	 */
	public void ajustarPesos(double [] estimulos, int indiceFigura) {
		for (int i = 0; i < quantidadeEstimulos; i++) {
			peso[i] = peso[i] + (target[indiceFigura] - palpite[indiceFigura]) * estimulos[i] * this.taxaAprendizado;
		}
	}
	
	public char getPalpiteAt(int x) {
		if (this.palpite[x] == 1) {
			return '1';
		}
		return '0';
	}
	
	public double[] getPeso() {
		return peso;
	}
}
