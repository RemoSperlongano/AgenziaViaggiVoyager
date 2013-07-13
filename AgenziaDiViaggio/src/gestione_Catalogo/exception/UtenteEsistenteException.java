/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class UtenteEsistenteException extends Exception {
	
	private static final long	serialVersionUID	= 1L;

	public UtenteEsistenteException(){
		
	}
	
	public UtenteEsistenteException(String m){
		super(m);
	}
	
	public String toString(){
		return "Esiste già un utente con questo username";
	}
	
}