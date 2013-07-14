/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class CittaCoincidentiException extends Exception {
	
	private static final long	serialVersionUID	= 1L;

	public CittaCoincidentiException(){
		
	}
	
	public CittaCoincidentiException(String m){
		super(m);
	}
	
	public String toString(){
		return "Citta' di partenza, citta' di arrivo o via coincidenti.";
	}
	
}
