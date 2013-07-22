/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class TipoMezzoException extends Exception {
	
	private static final long	serialVersionUID	= 1L;

	public TipoMezzoException(){
		
	}
	
	public TipoMezzoException(String m){
		super(m);
	}
	
	public String toString(){
		return "Errore in inserimento del Tipo di mezzo.";
	}
	

}
