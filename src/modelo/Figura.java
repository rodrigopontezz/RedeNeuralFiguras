package modelo;

/*	 Implementação de figuras, que representam a união de uma forma e uma cor.
 * 
 * 	 @author Rodrigo Pontes
 *	 @version 2.0
 */

public class Figura {
	private static int totalFiguras = 0;
	private final int id;
	private Forma forma;
	private Cor cor;
	private String target;
	
	public Figura() {
		this.id = Figura.getTotalFiguras();
		Figura.totalFiguras++;
	}
	
	public int getId() {
		return id;
	}
	
	/* Método que calcula o target absoluto da figura concatenando os
	 * targets parciais da forma e da cor.
	 */
	public void calcularTarget() {
		this.target = this.forma.getTarget() + this.cor.getTarget();
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
