/**
 * 
 */
package gestione_Catalogo.exception;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class PrenotazioneInesistenteException extends Exception {
	

	private static final long serialVersionUID = 1L;

	public PrenotazioneInesistenteException(){
		
	}
	
	public PrenotazioneInesistenteException(String m){
		super(m);
	}

	public String toString(){
		return "Prenotazione inesistente";
	}

}
