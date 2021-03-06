/**
 * 
 */
package gestione_Catalogo.control;

import gestione_Catalogo.entity.Biglietto;
import gestione_Catalogo.entity.Data;
import gestione_Catalogo.entity.Offerta;
import gestione_Catalogo.entity.Prenotazione;
import gestione_Catalogo.entity.Viaggiatore;
import gestione_Catalogo.exception.BigliettoNonPresenteException;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.ListaBigliettiNonModificataException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.PostiNonSufficientiException;
import gestione_Catalogo.exception.PrenotazioneInesistenteException;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreModificaPrenotazione extends Controllore {
	
	public ControlloreModificaPrenotazione(){
		super();
	}
	
	
	public void modificaPrenotazione(String ambiente, String mezzo, String partenza, String arrivo, String via, String offertaScelta, String prenotazioneScelta, ArrayList<String> listaNomi, ArrayList<String> listaCognomi, ArrayList<String> listaEmail) throws ParseException, OffertaInesistenteException, PrenotazioneInesistenteException, IDEsternoElementoException, PostiNonSufficientiException, ListaBigliettiNonModificataException, BigliettoNonPresenteException, DirittiException{
		

		Data dataPartenza = Data.parseTimestamp(offertaScelta);
		
		//prendo l'offerta dalla mappa
		Offerta offerta = catalogo.getOffertaFromMappa(ambiente, mezzo, partenza, arrivo, via, dataPartenza);
		
		//prendo la prenotazione dalla mappa
		Prenotazione prenotazione = catalogo.getPrenotazioneFromMappa(ambiente, mezzo, partenza, arrivo, via, dataPartenza, prenotazioneScelta);
		
		//prendo la lista dei biglietti e i dati dei viaggiatori
		ArrayList<Biglietto> listaBiglietti = prenotazione.getListaBiglietti();
		ArrayList<ArrayList<String>> datiViaggiatori = getDatiViaggiatori(listaBiglietti);
		
		// controllo che la lista dei biglietti contenga il biglietto dell'acquirente
		if (listaNomi.size() == 0 
				|| !(listaNomi.get(0).equalsIgnoreCase(datiViaggiatori.get(0).get(0)) 
						&& listaCognomi.get(0).equalsIgnoreCase(datiViaggiatori.get(1).get(0)) 
						&& listaEmail.get(0).equalsIgnoreCase(datiViaggiatori.get(2).get(0)))){
			throw new BigliettoNonPresenteException("Errore. Il biglietto dell'acquirente non puo' essere rimosso.");
		}
		
		//verifico che la lista dei biglietti sia stata effettivamente modificata
		if (listaNomi.equals(datiViaggiatori.get(0)))
			if (listaCognomi.equals(datiViaggiatori.get(1)))
				throw new ListaBigliettiNonModificataException("Nessun cambiamento rilevato. La prenotazione non sara' modificata.");
		
		//libero i posti precedentemente prenotati
		offerta.liberaPosti(listaBiglietti.size());
		
		//controllo disponibilitÓ biglietti
		if (offerta.getPosti() < listaNomi.size()){
			//riassegno i posti precedentemente liberati, la prenotazione non viene modificata.
			offerta.assegnaPosti(listaBiglietti.size()); 
			throw new PostiNonSufficientiException("Non ci sono abbastanza Posti disponibili per soddisfare tale prenotazione.");
		}
		//svuoto la lista dei biglietti
		prenotazione.clearListaBiglietti();
		
		ArrayList<Biglietto> nuovaListaBiglietti = new ArrayList<Biglietto>();
		
		while (!listaNomi.isEmpty()){
			//creo un nuovo biglietto
			Biglietto b = new Biglietto(prenotazione.getIdPrenotazione(), listaNomi.get(0), listaCognomi.get(0), listaEmail.get(0));
			nuovaListaBiglietti.add(b);
			
			//assegno un posto per ogni biglietto creato
			offerta.assegnaPosti(1); 
			
			//elimino gli elementi in listaNomi, listaCognomi, listaMail
			listaNomi.remove(0);
			listaCognomi.remove(0);
			listaEmail.remove(0);
		}
		
		//aggiungo la nuova lista dei biglietti alla prenotazione
		prenotazione.setListaBiglietti(nuovaListaBiglietti);
		
		log.aggiornaLogModificaPrenotazione(sessione.getUsername(), ambiente, mezzo, partenza, arrivo, via, offertaScelta, prenotazioneScelta);
		
	}
	
	
	public ArrayList<ArrayList<String>> getDatiViaggiatoriPerPrenotazione(String ambiente, String mezzo, String partenza, String arrivo, String via, String offerta, String prenotazione) throws OffertaInesistenteException, PrenotazioneInesistenteException, IDEsternoElementoException, ParseException, DirittiException{
		Data dataPartenza = Data.parseTimestamp(offerta);
		Prenotazione p = catalogo.getPrenotazioneFromMappa(ambiente, mezzo, partenza, arrivo, via, dataPartenza, prenotazione);
		ArrayList<Biglietto> listaBiglietti = p.getListaBiglietti();

		return getDatiViaggiatori(listaBiglietti);	
	}
	

	private ArrayList<ArrayList<String>> getDatiViaggiatori(ArrayList<Biglietto> listaBiglietti) {
		
		ArrayList<String> listaNomi = new ArrayList<String>();
		ArrayList<String> listaCognomi = new ArrayList<String>();
		ArrayList<String> listaEmail = new ArrayList<String>();
		
		for (int i=0; i<listaBiglietti.size(); i++){
			Viaggiatore v = listaBiglietti.get(i).getViaggiatore();
			listaNomi.add(v.getNome());
			listaCognomi.add(v.getCognome());
			listaEmail.add(v.getEmail());
		}
		
		ArrayList<ArrayList<String>> listaDati = new ArrayList<ArrayList<String>>();
		listaDati.add(listaNomi);
		listaDati.add(listaCognomi);
		listaDati.add(listaEmail);
		return listaDati;
	}

}
