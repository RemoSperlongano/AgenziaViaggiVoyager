/**
 * 
 */
package gestione_Catalogo.control;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import gestione_Catalogo.entity.Data;
import gestione_Catalogo.entity.Offerta;
import gestione_Catalogo.entity.Prenotazione;
import gestione_Catalogo.entity.Tratta;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.PrenotazioneInesistenteException;
import gestione_Catalogo.exception.TrattaInesistenteException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreRimuoviOffertaConPrenotazioni extends Controllore{
	
	
	public void rimuoviOffertaConPrenotazioni(String ambiente, String mezzo,String partenza, String arrivo, String via, String dataPartenza) throws ParseException, OffertaInesistenteException, IDEsternoElementoException, TrattaInesistenteException, PrenotazioneInesistenteException, DirittiException {
		
		Data dataOfferta = Data.parseTimestamp(dataPartenza);
		
		Tratta tratta = catalogo.getTrattaByValue(ambiente, mezzo, partenza, arrivo, via);
		Offerta offerta = catalogo.getOffertaFromMappa(ambiente, mezzo, partenza, arrivo, via, dataOfferta);
		
		if (catalogo.verificaEsistenzaPrenotazioni(ambiente, mezzo, partenza, arrivo, via, dataOfferta)){
			
			//Se vi sono delle prenotazioni per un offerta, elimino tutte quelle prenotazioni
			Set<String> listaPrenotazioni = catalogo.getChiaviPrenotazione(ambiente, mezzo, partenza, arrivo, via, dataOfferta);
			Iterator<String> it = listaPrenotazioni.iterator();
			
			//inseriesco l'iteratore in un arrayList
			//Sono costretto a farlo, perchè eliminando una prenotazione mentre itero le chiavi in mappa prenotazione mi va in Cuncurrent exception
			ArrayList<String> lp = new ArrayList<String>();
			
			while(it.hasNext()){
				String prenotazione = it.next();
				lp.add(prenotazione);
			}
			
			for(int i=0; i<lp.size(); i++){
				Prenotazione p = catalogo.getPrenotazioneFromMappa(ambiente, mezzo, partenza, arrivo, via, dataOfferta, lp.get(i));
				catalogo.rimuoviPrenotazioneDalCatalogo(p, offerta, tratta);
				offerta.liberaPosti(p.getListaBiglietti().size());
				log.aggiornaLogRimuoviPrenotazione(sessione.getUsername(),ambiente,mezzo,partenza,arrivo,via,dataPartenza,lp.get(i));
			}
			
		}
		
		
		catalogo.rimuoviOffertaDalCatalogo(offerta, tratta);
		log.aggiornaLogRimuoviOfferta(sessione.getUsername(), ambiente, mezzo, partenza, arrivo, via, dataPartenza);
		
	}

}


