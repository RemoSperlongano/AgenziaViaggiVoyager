/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class UtenteInesistenteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UtenteInesistenteException(){
		
	}
	
	public UtenteInesistenteException(String m){
		super(m);
	}
	
	public String toString(){
		return "Utente inesistente";
	}

}
