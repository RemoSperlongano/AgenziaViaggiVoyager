package gestione_Catalogo.control;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import gestione_Catalogo.entity.Biglietto;
import gestione_Catalogo.entity.Catalogo;
import gestione_Catalogo.entity.Data;
import gestione_Catalogo.entity.Log;
import gestione_Catalogo.entity.Offerta;
import gestione_Catalogo.entity.Prenotazione;
import gestione_Catalogo.entity.Sessione;
import gestione_Catalogo.entity.Viaggiatore;

import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.MappaException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.OfferteNonPresentiException;
import gestione_Catalogo.exception.PrenotazioneInesistenteException;


public abstract class Controllore {

	//attributi di classe
	protected static Catalogo catalogo;
	protected Log log;
	protected static Sessione sessione;
	
	//costruttore
	public Controllore() {
		
		catalogo = Catalogo.getIstanza();
		log = new Log();
		
	}
	
	
	
	//metodi in comune
	public ArrayList<String> getDatiUtenteDaSessione(){
		ArrayList<String> datiUtente = new ArrayList<String>();
		datiUtente.add(Sessione.USERNAME, sessione.getUsername());
		datiUtente.add(Sessione.RUOLO, sessione.getRuolo());
		datiUtente.add(Sessione.NOME, sessione.getNome());
		datiUtente.add(Sessione.COGNOME, sessione.getCognome());
		datiUtente.add(Sessione.EMAIL, sessione.getEmail());
		return datiUtente;
	}
	
	
	public Set<String> mostraAmbientiInCatalogo() throws MappaException {
		return catalogo.getChiaviAmbienti();
	}
	
	public Set<String> mostraMezziInCatalogo(String ambiente) throws IDEsternoElementoException {
		return catalogo.getChiaviMezzi(ambiente);
	}

	public Set<String> mostraCittaDiPartenzaInCatalogo(String ambiente, String mezzo) throws IDEsternoElementoException {
		return catalogo.getChiaviCittaDiPartenza(ambiente, mezzo);		
	}

	public Set<String> mostraCittaDiArrivoInCatalogo(String ambiente, String mezzo, String partenza) throws IDEsternoElementoException {
		return catalogo.getChiaviCittaDiArrivo(ambiente, mezzo, partenza);
	}
	
	public Set<String> mostraViaInCatalogo(String ambiente, String mezzo, String partenza, String arrivo) throws IDEsternoElementoException{
		return catalogo.getChiaviVia(ambiente, mezzo, partenza, arrivo);
	}
		
	public ArrayList<String> mostraOffertePerLaTratta(String ambiente, String mezzo, String partenza, String arrivo, String via) throws IDEsternoElementoException, OfferteNonPresentiException {
		ArrayList<String> date = new ArrayList<String>();
		
		Set<Data> chiaviOfferte = catalogo.getChiaviOfferte(ambiente, mezzo, partenza, arrivo, via);
		Iterator<Data> it = chiaviOfferte.iterator();
		while (it.hasNext()){
			date.add(it.next().stampaData());
		}
		return date;
	}
	
	public ArrayList<String> mostraOfferteValidePerLaTratta(String ambiente, String mezzo, String partenza, String arrivo, String via) throws IDEsternoElementoException, OfferteNonPresentiException{
		
		ArrayList<String> dateValide = new ArrayList<String>();
		
		Set<Data> chiaviOfferte = catalogo.getChiaviOfferte(ambiente, mezzo, partenza, arrivo, via);
		Iterator<Data> it = chiaviOfferte.iterator();
		
		//filtro le offerte scadute
		Data dataAttuale = new Data();
		while(it.hasNext()){
			Data dataOfferta = it.next();
			if (dataOfferta.after(dataAttuale)){
				dateValide.add(dataOfferta.stampaData());
			}
		}
		return dateValide;
	}
	
	public Set<String> mostraPrenotazioniPerOfferta(String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza) throws ParseException, OffertaInesistenteException, IDEsternoElementoException, PrenotazioneInesistenteException{
		Data dp = Data.parseTimestamp(dataPartenza);
		return catalogo.getChiaviPrenotazione(ambiente, mezzo, partenza, arrivo, via, dp);
	}
	
	
	public String mostraListaOffertaInCatalogo(String ambiente, String mezzo, String partenza, String arrivo, String via) throws IDEsternoElementoException, OfferteNonPresentiException, OffertaInesistenteException{
		  
		  String stringaOfferte = "";
		  
		  //prendo tutte le chiavi dalla mappa
		  Set<Data> s = catalogo.getChiaviOfferte(ambiente, mezzo, partenza, arrivo, via);
		  Iterator<Data> it = s.iterator();
		  
		  while (it.hasNext()){
		   
		   Offerta o = catalogo.getOffertaFromMappa(ambiente, mezzo, partenza, arrivo, via, it.next());
		   
		   //Inserisce gli elementi nella stringa da ritornare
		   stringaOfferte += o.getData().stampaData() + "\t" + o.getDataArrivo().stampaData() + "\t" + o.getPosti() + "\n";

		  }
		  
		  
		  return stringaOfferte;
		  
		 }
	
	
	public String mostraListaOfferteValideInCatalogo(String ambiente, String mezzo, String partenza, String arrivo, String via) throws IDEsternoElementoException, OfferteNonPresentiException, OffertaInesistenteException{
		 
		  String stringaOfferte = "";
		  
		  //prendo tutte le chiavi dalla mappa
		  Set<Data> s = catalogo.getChiaviOfferte(ambiente, mezzo, partenza, arrivo, via);
		  Iterator<Data> it = s.iterator();
		  
			Data dataAttuale = new Data();
			
			while (it.hasNext()){
				
				Data dataOfferta = it.next();
				
				// filtro le offerte scadute
				if (dataOfferta.after(dataAttuale)){
					Offerta o = catalogo.getOffertaFromMappa(ambiente, mezzo, partenza, arrivo, via, dataOfferta);
					
					//Inserisce gli elementi nella stringa da ritornare
					stringaOfferte += o.getData().stampaData() + "\t" + o.getDataArrivo().stampaData() + "\t" + o.getPosti() + "\n";
				}
			}
			
			return stringaOfferte;	
	}
	
	
	public String mostraListaBigliettiPerPrenotazione(String ambiente, String mezzo, String partenza, String arrivo, String via, String offerta, String prenotazione) throws OffertaInesistenteException, PrenotazioneInesistenteException, IDEsternoElementoException, ParseException {
			
		String stringaBiglietti = "ELENCO BIGLIETTI:\n\n";
		
		Data dataPartenza = Data.parseTimestamp(offerta);
		
		Prenotazione p = catalogo.getPrenotazioneFromMappa(ambiente, mezzo, partenza, arrivo, via, dataPartenza, prenotazione);

		ArrayList<Biglietto> listaBiglietti = p.getListaBiglietti();
		
		
		
		for (int i=0; i<listaBiglietti.size(); i++){
			Viaggiatore v = listaBiglietti.get(i).getViaggiatore();
			stringaBiglietti += i+1 + ".   " + v.getNome() + "\t" + v.getCognome() + "\t" + v.getEmail() + "\n";
		}
		
		
		return stringaBiglietti;
	}
	

	
}
