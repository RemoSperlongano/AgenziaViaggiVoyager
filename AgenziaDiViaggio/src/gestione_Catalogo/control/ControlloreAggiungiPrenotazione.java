package gestione_Catalogo.control;

import gestione_Catalogo.entity.Data;
import gestione_Catalogo.entity.Offerta;
import gestione_Catalogo.entity.Prenotazione;
import gestione_Catalogo.entity.Tratta;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.OffertaException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.OfferteNonPresentiException;
import gestione_Catalogo.exception.PostiNonSufficientiException;
import gestione_Catalogo.exception.PrenotazioneException;
import gestione_Catalogo.exception.TrattaInesistenteException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreAggiungiPrenotazione extends Controllore{
	
	//costruttore
	public ControlloreAggiungiPrenotazione(){
		super();
	}

	
	public void aggiungiPrenotazione(String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza, ArrayList<String> listaNomi,ArrayList<String> listaCognomi, ArrayList<String> listaEmail) throws ParseException, IDEsternoElementoException, OffertaInesistenteException, PrenotazioneException, TrattaInesistenteException, PostiNonSufficientiException, CloneNotSupportedException {
		
		
		
		//Controllo se esiste già una prenotazione
		String nomeAcquirente = listaNomi.get(0) + " " + listaCognomi.get(0);
		Data dataOfferta = Data.parseTimestamp(dataPartenza);
		
		if (catalogo.verificaEsistenzaPrenotazione(ambiente,mezzo,partenza,arrivo,via,dataOfferta,nomeAcquirente)){
			throw new PrenotazioneException("Prenotazione già esistente per questo viaggio");
		}
		
		//prendo la  Tratta
		Tratta tratta = catalogo.getTrattaByValue(ambiente, mezzo, partenza, arrivo, via);
		
		//prendo l'offerta dalla Mappa
		Offerta offerta = catalogo.getOffertaFromMappa(ambiente, mezzo, partenza, arrivo, via, dataOfferta);
		Integer idOfferta = offerta.getIdOfferta();
		
		//controllo disponibilità biglietti
		if (offerta.getPosti() < listaNomi.size()){
			throw new PostiNonSufficientiException("Non ci sono abbastanza Posti disponibili per soddisfare tale prenotazione");
		}
		

		offerta.assegnaPosti(listaNomi.size());
		
		
		//creo una nuova Prenotazione
		Prenotazione prenotazione = new Prenotazione(idOfferta, listaNomi, listaCognomi, listaEmail);
		
		//Aggiungo la prenotazione al catalogo
		catalogo.aggiungiPrenotazioneAlCatalogo(prenotazione, offerta, tratta);
		log.aggiornaLogAggiungiPrenotazione(ambiente, mezzo, partenza, arrivo, via, dataOfferta, nomeAcquirente);
		
		
	}


	
}
