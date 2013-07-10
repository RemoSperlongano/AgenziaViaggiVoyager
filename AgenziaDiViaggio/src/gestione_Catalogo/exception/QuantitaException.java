/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class QuantitaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public QuantitaException(){
		
	}
	
	public QuantitaException(String m){
		super(m);
	}

	public String toString(){
		return "La quantita' non deve essere nulla.";
	}


}
