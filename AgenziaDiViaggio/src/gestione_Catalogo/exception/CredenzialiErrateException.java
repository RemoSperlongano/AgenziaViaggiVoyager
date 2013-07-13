/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class CredenzialiErrateException extends Exception {
	
	private static final long	serialVersionUID	= 1L;

	public CredenzialiErrateException(){
		
	}
	
	public CredenzialiErrateException(String m){
		super(m);
	}
	
	public String toString(){
		return "Errore nell'inserimento delle credenziali";
	}
	
}