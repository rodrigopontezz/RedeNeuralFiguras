public class Cor {
	private static int totalCores = 0;
	private String nome;
	private String targetCor;
	
	public Cor() {
		Cor.totalCores++;
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
	
	public String getTargetCor() {
		return targetCor;
	}
	
	public void setTargetCor(String targetCor) {
		this.targetCor = targetCor;
	}
}