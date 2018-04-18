/*	 Exceção lançada caso uma janela não possa ser aberta.
 * 
 *	 @version 2.0
 * 	 GitHub: https://github.com/rodrigopontezz/RedeNeuralFiguras
 */

package exception;

public class WindowException extends RuntimeException {

    public WindowException() {
        super("Não foi possível criar esta janela!");
    }
}
