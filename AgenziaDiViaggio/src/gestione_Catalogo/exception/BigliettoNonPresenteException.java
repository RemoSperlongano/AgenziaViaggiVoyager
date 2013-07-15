/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BigliettoNonPresenteException extends Exception {
	
	private static final long	serialVersionUID	= 1L;

	public BigliettoNonPresenteException(){
		
	}
	
	public BigliettoNonPresenteException(String m){
		super(m);
	}
	
	public String toString(){
		return "Biglietto non presente.";
	}
	

}
