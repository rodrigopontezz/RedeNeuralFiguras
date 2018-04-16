package exception;

/*	 Exceção lançada caso uma janela não possa ser aberta.
 * 
 *       @author Rodrigo Pontes
 *	 @version 2.0
 */

public class WindowException extends RuntimeException {

    public WindowException() {
        super("Não foi possível criar esta janela!");
    }
}
