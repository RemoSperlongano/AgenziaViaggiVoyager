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
public class MappaPrenotazioni extends TreeMap<Integer, Prenotazione>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MappaPrenotazioni(){
		super();
	}
	
	public void aggiungiPrenotazione(Integer idPrenotazione, Prenotazione p){
		if(!containsKey(idPrenotazione)){
			super.put(idPrenotazione, p);
		}
		
	}
	
	public void rimuoviPrenotazione(Integer idPrenotazione) throws PrenotazioneInesistenteException{
		if(!containsKey(idPrenotazione)){
			throw new PrenotazioneInesistenteException("Errore in rimozione. Prenotazione numero  \""+idPrenotazione+"\" non presente.");
		}
	}
	
	public Prenotazione getPrenotazione(Integer idPrenotazione) throws OffertaInesistenteException, PrenotazioneInesistenteException {
		if (!containsKey(idPrenotazione)){
			throw new PrenotazioneInesistenteException("Errore in rimozione. Prenotazione numero  \""+idPrenotazione+"\" non presente.");
		}
		return super.get(idPrenotazione);
	}

}
