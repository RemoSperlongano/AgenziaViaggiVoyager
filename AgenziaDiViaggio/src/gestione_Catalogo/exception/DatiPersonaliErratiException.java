/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class DatiPersonaliErratiException extends Exception {
	
	private static final long	serialVersionUID	= 1L;

	public DatiPersonaliErratiException(){
		
	}
	
	public DatiPersonaliErratiException(String m){
		super(m);
	}
	
	public String toString(){
		return "Dati inseriti in maniera errata";
	}
	
}
