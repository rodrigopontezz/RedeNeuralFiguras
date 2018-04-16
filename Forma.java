/*	 Implementação de como a rede neural reconhece formas a partir do dataset.
 * 
 * 	 @author Rodrigo Pontes
 *	 @version 1.1
 */

public class Forma implements Treinavel {
	private static int totalFormas = 0;
	private int id;
	private String nome;
	private char [][] matriz;
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
	
	public char[][] getMatriz() {
		return matriz;
	}
	
	public void setMatriz(char[][] matriz) {
		this.matriz = matriz;
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