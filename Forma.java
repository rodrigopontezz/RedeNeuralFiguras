public class Forma implements Treinavel {
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
	
	@Override
	public String getTarget() {
		return targetForma;
	}
	
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