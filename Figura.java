public class Figura {
	private static int totalFiguras = 0;
	private Forma forma;
	private Cor cor;
	private String target;
	
	public Figura() {
		Figura.totalFiguras++;
	}
	
	public void calcularTarget() {
		this.target = this.forma.getTargetForma() + this.cor.getTargetCor();
	}
	
	public String getTarget() {
		return target;
	}

	public static int getTotalFiguras() {
		return totalFiguras;
	}

	public static void setTotalFiguras(int totalFiguras) {
		Figura.totalFiguras = totalFiguras;
	}

	public Forma getForma() {
		return forma;
	}

	public void setForma(Forma forma) {
		this.forma = forma;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}
}
