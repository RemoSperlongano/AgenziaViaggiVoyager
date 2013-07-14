/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class DataNonValidaException extends Exception {
	
	private static final long	serialVersionUID	= 1L;

	public DataNonValidaException(){
		
	}
	
	public DataNonValidaException(String m){
		super(m);
	}
	
	public String toString(){
		return "Data non valida.";
	}
	

}
