/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ListaBigliettiNonModificataException extends Exception {
	
	private static final long	serialVersionUID	= 1L;

	public ListaBigliettiNonModificataException(){
		
	}
	
	public ListaBigliettiNonModificataException(String m){
		super(m);
	}
	
	public String toString(){
		return "Nessuna modifica per la prenotazione";
	}
	

}
