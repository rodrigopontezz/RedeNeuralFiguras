package exception;

/*	 Exceção lançada caso não seja possível iniciar o programa.
 * 
 *       @author Rodrigo Pontes
 *	 @version 2.0
 */

public class InitException extends Exception {

    public InitException(String msg) {
        super(msg);
    }
    
}
