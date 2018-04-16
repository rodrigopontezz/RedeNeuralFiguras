package exception;

/*	 Exceção lançada caso não seja possível executar o treinamento.
 * 
 *       @author Rodrigo Pontes
 *	 @version 2.0
 */

public class TreinamentoException extends RuntimeException {

    public TreinamentoException(String msg) {
        super(msg);
    }
    
}
