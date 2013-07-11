/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class PostiNonSufficientiException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PostiNonSufficientiException(){
		
	}
	
	public PostiNonSufficientiException(String m){
		super(m);
	}

	public String toString(){
		return "Non ci sono posti disponibili sufficienti per soddisfare questa prenotazione";
	}

}