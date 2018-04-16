package modelo;

/*	 Implementação de como a rede neural reconhece cores a partir do dataset.
 * 
 * 	 @author Rodrigo Pontes
 *	 @version 2.0
 */

public class Cor implements Treinavel {
	private static int totalCores = 0;
	private final int id;
	private String nome;
	private String targetCor;
	
	public Cor() {
		this.id = Cor.getTotalCores();
		Cor.totalCores++;
	}
	
	public int getId() {
		return id;
	}
	
	public static int getTotalCores() {
		return totalCores;
	}

        public static void setTotalCores(int totalCores) {
            Cor.totalCores = totalCores;
        }
        
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String getTarget() {
		return targetCor;
	}
	
	/* Método que gera um target único para cada cor existente.
	 */
	public void setTargetCor(int count) {
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i < Cor.getTotalCores(); i++) {
			if (i == count) {
				str.append("1");
			} else {
				str.append("0");
			}
		}
		
		this.targetCor = str.toString();
	}
}