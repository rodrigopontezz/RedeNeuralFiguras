public class Forma {
	private static int totalFormas = 0;
	private String nome;
	private char [][] matriz;
	private String targetForma;
	
	public Forma() {
		Forma.totalFormas++;
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
	
	public String getTargetForma() {
		return targetForma;
	}
	
	public void setTargetForma(String targetForma) {
		this.targetForma = targetForma;
	}
}