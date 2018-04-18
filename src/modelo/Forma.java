/*	 Implementação de como a rede neural reconhece formas a partir do dataset.
 * 
 *	 @version 2.0
 * 	 GitHub: https://github.com/rodrigopontezz/RedeNeuralFiguras
 */

package modelo;

public class Forma implements Treinavel {
	private static int totalFormas = 0;
	private final int id;
	private String nome;
	private String targetForma;

	public Forma() {
		this.id = Forma.getTotalFormas();
		Forma.totalFormas++;
	}
	
	public int getId() {
		return id;
	}
	
	public static int getTotalFormas() {
		return totalFormas;
	}

        public static void setTotalFormas(int totalFormas) {
                Forma.totalFormas = totalFormas;
        }
        
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String getTarget() {
		return targetForma;
	}
	
	/* Método que gera um target único para cada forma existente.
	 */
	public void setTargetForma(int count) {
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i < Forma.getTotalFormas(); i++) {
			if (i == count) {
				str.append("1");
			} else {
				str.append("0");
			}
		}
		
		this.targetForma = str.toString();
	}
}