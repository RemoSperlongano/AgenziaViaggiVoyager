/**
 * 
 */
package gestione_Catalogo.control;

import gestione_Catalogo.entity.Data;
import gestione_Catalogo.entity.Offerta;
import gestione_Catalogo.entity.Tratta;
import gestione_Catalogo.exception.DataNonValidaException;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.OffertaException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.PrenotazioneException;
import gestione_Catalogo.exception.QuantitaException;
import gestione_Catalogo.exception.TrattaInesistenteException;

import java.text.ParseException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreGestioneOfferta extends Controllore {
	
	
	
	
	public ControlloreGestioneOfferta(){
		super();
	}
	
	
	
	public void aggiungiOfferta(String ambiente, String mezzo, String partenza, String arrivo, String via, Integer[] data, Integer durata, Integer posti) throws TrattaInesistenteException, IDEsternoElementoException, OffertaException, QuantitaException, DataNonValidaException, DirittiException{
		
		Data dataPartenza = new Data(data[0], data[1], data[2], data[3], data[4]);
		
		//controllo che la data di partenza non sia inferiore alla data odierna + 1 settimana. Il sistema non accetta offerte con date antecedenti a tale data.
		Data dataAttuale = new Data();
		Data dataMinima = new Data(dataAttuale.getGiorno()+ 7, dataAttuale.getMese(), dataAttuale.getAnno());
		if (dataPartenza.before(dataMinima)){
			throw new DataNonValidaException("La data di partenza del viaggio non puo' essere antecedente alla settimana successiva della data odierna.");
		}
		
		if (durata <= 0){
			throw new QuantitaException("La durata del viaggio non puo' essere nulla. Inserire una durata maggiore di 0 minuti.");
		}
		if (posti <= 0){
			throw new QuantitaException("I posti disponibili non possono essere nulli. Inserire una quantita' di posti maggiore di 0.");
		}
		
		Tratta tratta = catalogo.getTrattaByValue(ambiente, mezzo, partenza, arrivo, via);
		Integer idTratta = tratta.getID();
		
		if (catalogo.verificaEsistenzaOfferta(ambiente,mezzo,partenza,arrivo,via,dataPartenza)){
			throw new OffertaException("Offerta gia' esistente per il viaggio!");
		}
		
		Offerta nuovaOfferta = new Offerta(idTratta, dataPartenza, durata, posti);
		catalogo.aggiungiOffertaAlCatalogo(nuovaOfferta, tratta);
		log.aggiornaLogAggiungiOfferta(sessione.getUsername(), ambiente, mezzo, partenza, arrivo , via, dataPartenza, durata, posti);
	}
	
	
	public void rimuoviOfferta(String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza) throws TrattaInesistenteException, PrenotazioneException, OffertaInesistenteException, IDEsternoElementoException, ParseException, DirittiException{
		
		Data dataOfferta = Data.parseTimestamp(dataPartenza);
		
		if (catalogo.verificaEsistenzaPrenotazioni(ambiente, mezzo, partenza, arrivo, via, dataOfferta)){
			throw new PrenotazioneException("Ci sono prenotazioni attive! L'offerta non puo' essere rimossa.");
		}
		
		Tratta tratta = catalogo.getTrattaByValue(ambiente, mezzo, partenza, arrivo, via);
		Offerta offerta = catalogo.getOffertaFromMappa(ambiente, mezzo, partenza, arrivo, via, dataOfferta);
		
		catalogo.rimuoviOffertaDalCatalogo(offerta, tratta);
		log.aggiornaLogRimuoviOfferta(sessione.getUsername(), ambiente, mezzo, partenza, arrivo, via, dataPartenza);
	}
	
	
	
	
	
	/*
	 * 
	 * Metodi per i Thread
	 * 
	 */
	
	public void aggiungiOffertaThread(String ambiente, String mezzo, String partenza, String arrivo, String via, Integer[] data, Integer durata, Integer posti) throws TrattaInesistenteException, IDEsternoElementoException, OffertaException, QuantitaException, DataNonValidaException, DirittiException, InterruptedException{
		
		Data dataPartenza = new Data(data[0], data[1], data[2], data[3], data[4]);
		
		//controllo che la data di partenza non sia inferiore alla data odierna + 1 settimana. Il sistema non accetta offerte con date antecedenti a tale data.
		Data dataAttuale = new Data();
		
		
		if (durata <= 0){
			throw new QuantitaException("La durata del viaggio non puo' essere nulla. Inserire una durata maggiore di 0 minuti.");
		}
		if (posti <= 0){
			throw new QuantitaException("I posti disponibili non possono essere nulli. Inserire una quantita' di posti maggiore di 0.");
		}
		
		if (catalogo.verificaEsistenzaOffertaThread(ambiente,mezzo,partenza,arrivo,via,dataPartenza)){
			throw new OffertaException("Offerta gia' esistente per il viaggio!");
		}
		
		Tratta tratta = catalogo.getTrattaByValue(ambiente, mezzo, partenza, arrivo, via);
		Integer idTratta = tratta.getID();
		
		
		Offerta nuovaOfferta = new Offerta(idTratta, dataPartenza, durata, posti);
		catalogo.aggiungiOffertaAlCatalogo(nuovaOfferta, tratta); // questo lo lascio con i metodi normale, tanto la verifica degli elementi in mappa l'ha fatta da verificaEsistenzaOfferta
		log.aggiornaLogAggiungiOfferta("Thread", ambiente, mezzo, partenza, arrivo , via, dataPartenza, durata, posti);
	}
	
	


}

