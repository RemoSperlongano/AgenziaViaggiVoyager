/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class CalcoloIndiceException extends Exception {
	
	private static final long	serialVersionUID	= 1L;

	public CalcoloIndiceException(){
		
	}
	
	public CalcoloIndiceException(String m){
		super(m);
	}
	
	public String toString(){
		return "Errore nel calcolo degli indici.";
	}
	

}

