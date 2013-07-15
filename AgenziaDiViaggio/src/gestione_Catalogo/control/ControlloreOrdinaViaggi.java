/**
 * 
 */
package gestione_Catalogo.control;

import gestione_Catalogo.entity.Data;
import gestione_Catalogo.entity.Offerta;
import gestione_Catalogo.entity.Prenotazione;
import gestione_Catalogo.entity.Tratta;
import gestione_Catalogo.exception.BigliettoNonPresenteException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.PostiNonSufficientiException;
import gestione_Catalogo.exception.PrenotazioneException;
import gestione_Catalogo.exception.TrattaInesistenteException;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreOrdinaViaggi extends Controllore {
	
	public ControlloreOrdinaViaggi(){
		super();
	}

	
	public ArrayList<String> getDatiClientePerBiglietto(String ambiente, String mezzo, String cittaPartenza, String cittaArrivo, String via, String dataPartenza) throws OffertaInesistenteException, IDEsternoElementoException, PrenotazioneException, ParseException{
		
		String nomeAcquirente = sessione.getNome() + " " + sessione.getCognome();
		Data dataOfferta = Data.parseTimestamp(dataPartenza);
		
		//Controllo se esiste gia' la prenotazione
		if (catalogo.verificaEsistenzaPrenotazione(ambiente, mezzo, cittaPartenza, cittaArrivo, via, dataOfferta, nomeAcquirente)){
			throw new PrenotazioneException("Hai gia'prenotato questo viaggio!");
		}

		return getDatiUtenteDaSessione();
	}

	public void prenotaViaggio(String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza, ArrayList<String> listaNomi,ArrayList<String> listaCognomi, ArrayList<String> listaEmail) throws ParseException, OffertaInesistenteException, IDEsternoElementoException, PrenotazioneException, TrattaInesistenteException, PostiNonSufficientiException, BigliettoNonPresenteException {
		
		// controllo che la lista dei biglietti contenga il biglietto del cliente prenotante
		if (listaNomi.size() == 0 
				|| !(listaNomi.get(0).equalsIgnoreCase(sessione.getNome())
						&& listaCognomi.get(0).equalsIgnoreCase(sessione.getCognome()) 
						&& listaEmail.get(0).equalsIgnoreCase(sessione.getEmail()))){
			throw new BigliettoNonPresenteException("Errore: la prenotazione deve contenere il biglietto del cliente prenotante.");
		}
		
		//Controllo se esiste gia' una prenotazione
		String nomeAcquirente = listaNomi.get(0) + " " + listaCognomi.get(0);
		Data dataOfferta = Data.parseTimestamp(dataPartenza);
		
		if (catalogo.verificaEsistenzaPrenotazione(ambiente,mezzo,partenza,arrivo,via,dataOfferta,nomeAcquirente)){
			throw new PrenotazioneException("Hai gia'prenotato questo viaggio!");
		}
		
		//prendo la  Tratta
		Tratta tratta = catalogo.getTrattaByValue(ambiente, mezzo, partenza, arrivo, via);
		
		//prendo l'offerta dalla Mappa
		Offerta offerta = catalogo.getOffertaFromMappa(ambiente, mezzo, partenza, arrivo, via, dataOfferta);
		Integer idOfferta = offerta.getIdOfferta();
		
		//controllo disponibilita' biglietti
		if (offerta.getPosti() < listaNomi.size()){
			throw new PostiNonSufficientiException("Non ci sono abbastanza Posti disponibili per soddisfare tale prenotazione.");
		}
		

		offerta.assegnaPosti(listaNomi.size());
		
		
		//creo una nuova Prenotazione
		Prenotazione prenotazione = new Prenotazione(idOfferta, listaNomi, listaCognomi, listaEmail);
		
		//Aggiungo la prenotazione al catalogo
		catalogo.aggiungiPrenotazioneAlCatalogo(prenotazione, offerta, tratta);
		log.aggiornaLogAggiungiPrenotazione(ambiente, mezzo, partenza, arrivo, via, dataPartenza, nomeAcquirente);
		
		
	}

}
