/**
 * 
 */
package gestione_Catalogo.entity;

import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.PrenotazioneInesistenteException;

import java.util.TreeMap;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class MappaPrenotazioni extends TreeMap<String, Prenotazione>  implements Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MappaPrenotazioni(){
		super();
	}
	
	public void aggiungiPrenotazione(String nomeAcquirente, Prenotazione p){
		if(!containsKey(nomeAcquirente)){
			super.put(nomeAcquirente, p);
		}
		
	}
	
	public void rimuoviPrenotazione(String nomeAcquirente) throws PrenotazioneInesistenteException{
		if(!containsKey(nomeAcquirente)){
			throw new PrenotazioneInesistenteException("Errore in rimozione. Prenotazione del signor  \""+nomeAcquirente+"\" non presente.");
		}
		super.remove(nomeAcquirente);
	}
	
	public Prenotazione getPrenotazione(String nomeAcquirente) throws OffertaInesistenteException, PrenotazioneInesistenteException {
		if (!containsKey(nomeAcquirente)){
			throw new PrenotazioneInesistenteException("Errore in rimozione. Prenotazione del signor  \""+nomeAcquirente+"\" non presente.");
		}
		return super.get(nomeAcquirente);
	}
	
	
	
	//clone
	public MappaPrenotazioni clone(){
		//creo un oggetto richiamando il metodo clone della superclasse
			MappaPrenotazioni clonato = (MappaPrenotazioni) super.clone();
			return clonato;
	}

}
