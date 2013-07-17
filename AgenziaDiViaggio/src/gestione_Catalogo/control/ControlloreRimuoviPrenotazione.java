/**
 * 
 */
package gestione_Catalogo.control;

import java.text.ParseException;

import gestione_Catalogo.entity.Data;
import gestione_Catalogo.entity.Offerta;
import gestione_Catalogo.entity.Prenotazione;
import gestione_Catalogo.entity.Tratta;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.PrenotazioneInesistenteException;
import gestione_Catalogo.exception.TrattaInesistenteException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreRimuoviPrenotazione extends Controllore {
	
	public ControlloreRimuoviPrenotazione(){
		super();
	}

	
	public void rimuoviPrenotazione(String ambiente, String mezzo, String partenza, String arrivo, String via, String offertaScelta, String prenotazioneScelta) throws TrattaInesistenteException, ParseException, IDEsternoElementoException, OffertaInesistenteException, PrenotazioneInesistenteException {
		//prendo la tratta
		Tratta tratta = catalogo.getTrattaByValue(ambiente, mezzo, partenza, arrivo, via);
		//prendo l'offerta
		Data dataOfferta = Data.parseTimestamp(offertaScelta);
		Offerta offerta = catalogo.getOffertaFromMappa(ambiente, mezzo, partenza, arrivo, via, dataOfferta);
		//prendo la prenotazione
		Prenotazione prenotazione = catalogo.getPrenotazioneFromMappa(ambiente, mezzo, partenza, arrivo, via, dataOfferta, prenotazioneScelta);
		
		//rimuovo la prenotazione dal catalogo
		catalogo.rimuoviPrenotazioneDalCatalogo(prenotazione, offerta, tratta);
		//libero i posti nuovamente disponibili
		offerta.liberaPosti(prenotazione.getListaBiglietti().size());
		log.aggiornaLogRimuoviPrenotazione(sessione.getUsername(),ambiente,mezzo,partenza,arrivo,via,offertaScelta,prenotazioneScelta);	
		
	}

	

}
