package gestione_Catalogo.entity;

import gestione_Catalogo.dao.CatalogoDAO;
import gestione_Catalogo.dao.OffertaDAO;
import gestione_Catalogo.dao.PrenotazioneDAO;
import gestione_Catalogo.dao.TrattaDAO;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.MappaException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.OfferteNonPresentiException;
import gestione_Catalogo.exception.PrenotazioneInesistenteException;
import gestione_Catalogo.exception.TrattaInesistenteException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class Catalogo {
	
	//attributi di classe
	private static Catalogo istanza;
	
	//attributi di istanza
	private List<Tratta> listaTratte;
	private List<Offerta> listaOfferte;
	private List<Prenotazione> listaPrenotazioni;
	
	private MappaCatalogo mappaCatalogo;
	
	//costruttore
	private Catalogo() {
//		listaTratte = new ArrayList<Tratta>();
//		listaOfferte = new ArrayList<Offerta>();
//		listaPrenotazioni = new ArrayList<Prenotazione>();
		mappaCatalogo = new MappaCatalogo(); //istanziato il catalogo, creo subito una mappa per gli ambienti
		
		CatalogoDAO dao = CatalogoDAO.getIstanza();
		listaTratte = Collections.synchronizedList(dao.getCatalogo());
		
		OffertaDAO offertaDao = OffertaDAO.getIstanza();
		listaOfferte = Collections.synchronizedList(offertaDao.getListaOfferte());
		
		PrenotazioneDAO prenotazioneDao = PrenotazioneDAO.getIstanza();
		listaPrenotazioni = Collections.synchronizedList(prenotazioneDao.getListaPrenotazioni());
		
		try {
			caricaCatalogo();
		} catch (IDEsternoElementoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OffertaInesistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DirittiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	// metodi
	public static Catalogo getIstanza(){
		if (istanza == null){
			istanza = new Catalogo();
		}
		return istanza;
	}
	
	
	public boolean verificaEsistenzaViaggio(String ambiente, String mezzo, String cittaPartenza, String cittaArrivo, String via) throws IDEsternoElementoException, DirittiException{	
		/*
		 * Non va in exception: prima di prendere un elemento, verifica la sua esistenza...se c'è, lo prende, se non c'è, ritorna con false
		 */

		if (!mappaCatalogo.esistenzaElemento(ambiente)) return false;	//Se non c'è l'elemento ambiente nella prima mappa torna subito con false, altrimenti continua
		ElementoCatalogo amb = mappaCatalogo.getElemento(ambiente);
		if (!amb.esistenzaElemento(mezzo)) return false;  //se nn c'è il mezzo ritorna con false, altrimenti continua
		ElementoCatalogo mez = amb.getElemento(mezzo);
		if (!mez.esistenzaElemento(cittaPartenza)) return false;
		ElementoCatalogo part = mez.getElemento(cittaPartenza);
		if (!part.esistenzaElemento(cittaArrivo)) return false;
		ElementoCatalogo arr = part.getElemento(cittaArrivo);
		if (!arr.esistenzaElemento(via)) return false;
		
		// Se tutti i controlli hanno dato esisto negativo, allora il viaggio è già presente
		return true;
	}
	
	
	// Verifica se esista o meno una determinata offerta.
	public boolean verificaEsistenzaOfferta(String ambiente, String mezzo, String partenza, String arrivo, String via, Data dataPartenza) throws IDEsternoElementoException, DirittiException {
		return mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(partenza).getElemento(arrivo).getElemento(via).esistenzaOfferta(dataPartenza);
	}


	// Verifica se esistono offerte per un determinato viaggio. Un viaggio non puo' essere rimosso se esistono offerte ad esso associate.
	public boolean verificaEsistenzaOfferte(String ambiente, String mezzo, String cittaPartenza, String cittaArrivo, String via) throws IDEsternoElementoException, DirittiException {
		return !mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(cittaPartenza).getElemento(cittaArrivo).getElemento(via).mapIsEmpty();
	}
	

	// Verifica se esista o meno una determinata prenotazione.
	public boolean verificaEsistenzaPrenotazione(String ambiente, String mezzo, String cittaPartenza, String cittaArrivo, String via, Data dataPartenza, String nomeAcquirente) throws OffertaInesistenteException, IDEsternoElementoException, DirittiException{
		return mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(cittaPartenza).getElemento(cittaArrivo).getElemento(via).getOfferta(dataPartenza).esistenzaPrenotazione(nomeAcquirente);
	}
	
	// Verifica se esistono prenotazioni per una determinata offerta. Un'offerta non puo' essere rimossa se esistono prenotazioni ad essa associate.
	public boolean verificaEsistenzaPrenotazioni(String ambiente, String mezzo, String cittaPartenza, String cittaArrivo, String via, Data dataPartenza) throws OffertaInesistenteException, IDEsternoElementoException, DirittiException{
		return !mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(cittaPartenza).getElemento(cittaArrivo).getElemento(via).getOfferta(dataPartenza).mapIsEmpty();
	}
	
	
	//Verifica se esiste un mezzo che è stato specificato con un tipo
	public boolean verificaEsistenzaTipo(String mezzo){
		for (int i=0; i<listaTratte.size(); i++){
			
			Tratta t = listaTratte.get(i);
			
			if (t.getCategoria().equals(mezzo) && !t.getMezzo().getIDEsternoElemento().equals(mezzo)){
			return true;	
		} 
			
		}
			
		//se non è ritornato con true e arriva qui, ritorna con false
		return false;
			
	}
	
	
	
	
	public void aggiungiViaggioAlCatalogo(Tratta tratta) throws IDEsternoElementoException, DirittiException{
		
		listaTratte.add(tratta);
		
		aggiungiInMappaCatalogo(tratta);
		
	}
	

	public void rimuoviViaggioDalCatalogo(Tratta tratta) throws IDEsternoElementoException, DirittiException{
		
		listaTratte.remove(tratta);
		
		rimuoviDaMappaCatalogo(tratta);
		
		TrattaDAO dao = TrattaDAO.getIstanza();
		dao.delete(tratta);
		
	}
	
	
	public void aggiungiOffertaAlCatalogo(Offerta offerta, Tratta tratta) throws IDEsternoElementoException, DirittiException{
		listaOfferte.add(offerta);
		
		aggiungiInMappaOfferte(tratta, offerta);
	}
	
	
	public void rimuoviOffertaDalCatalogo(Offerta offerta, Tratta tratta) throws IDEsternoElementoException, OffertaInesistenteException, DirittiException {
		listaOfferte.remove(offerta);
		
		rimuoviDaMappaOfferte(tratta, offerta);
		
		OffertaDAO dao = OffertaDAO.getIstanza();
		dao.delete(offerta);
		
	}
	
	public void aggiungiPrenotazioneAlCatalogo(Prenotazione prenotazione, Offerta offerta, Tratta tratta ) throws OffertaInesistenteException, IDEsternoElementoException, DirittiException{
		listaPrenotazioni.add(prenotazione);
		
		aggiungiInMappaPrenotazioni(tratta, offerta, prenotazione);
	}
	
	public void rimuoviPrenotazioneDalCatalogo(Prenotazione prenotazione, Offerta offerta, Tratta tratta) throws OffertaInesistenteException, PrenotazioneInesistenteException, IDEsternoElementoException, DirittiException{
		listaPrenotazioni.remove(prenotazione);
		
		rimuoviDaMappaPrenotazioni(tratta, offerta, prenotazione);
		
		PrenotazioneDAO dao = PrenotazioneDAO.getIstanza();
		dao.delete(prenotazione);
	}


	public void caricaCatalogo() throws IDEsternoElementoException, OffertaInesistenteException, DirittiException{
		for (Tratta tratta : listaTratte){
			aggiungiInMappaCatalogo(tratta);
			caricaOfferte(tratta);
		}
	}
	
	public void caricaOfferte(Tratta tratta) throws IDEsternoElementoException, OffertaInesistenteException, DirittiException{
		for (Offerta offerta : listaOfferte){
			if (tratta.getID().equals(offerta.getIdTratta())){
				aggiungiInMappaOfferte(tratta, offerta);
			    caricaPrenotazioni(tratta, offerta);
			}
		}		
	}
	
	public void caricaPrenotazioni(Tratta tratta, Offerta offerta) throws OffertaInesistenteException, IDEsternoElementoException, DirittiException{
		for (Prenotazione prenotazione : listaPrenotazioni){
			if (offerta.getIdOfferta().equals(prenotazione.getIdOfferta())){
				aggiungiInMappaPrenotazioni(tratta, offerta, prenotazione);
			}
		}
	}
	

	public Set<String> getChiaviAmbienti() throws MappaException {
		Set<String> ambienti = mappaCatalogo.keySet();
		if (ambienti.isEmpty())
			throw new MappaException("Non sono presenti Viaggi nel Catalogo.");
		else
			return ambienti;
	}
	
	public Set<String> getChiaviMezzi(String ambiente) throws IDEsternoElementoException, DirittiException {
		return mappaCatalogo.getElemento(ambiente).listaChiaviElementi();	
	}
	
	public Set<String> getChiaviCittaDiPartenza(String ambiente, String mezzo) throws IDEsternoElementoException, DirittiException {
		return mappaCatalogo.getElemento(ambiente).getElemento(mezzo).listaChiaviElementi(); 
	}
	
	public Set<String> getChiaviCittaDiArrivo(String ambiente, String mezzo, String partenza) throws IDEsternoElementoException, DirittiException {
		return mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(partenza).listaChiaviElementi();
	}
	
	public Set<String> getChiaviVia(String ambiente, String mezzo, String partenza, String arrivo) throws IDEsternoElementoException, DirittiException{
		return  mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(partenza).getElemento(arrivo).listaChiaviElementi();
	}
	
	
	public Set<Data> getChiaviOfferte(String ambiente, String mezzo, String partenza, String arrivo, String via) throws IDEsternoElementoException, OfferteNonPresentiException, DirittiException {
		Set<Data> offerte = mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(partenza).getElemento(arrivo).getElemento(via).listaChiaviOfferte();
		if (offerte.isEmpty()){
			throw new OfferteNonPresentiException("Non ci sono offerte per questo Viaggio.");
		} else
			return offerte;
	
	}
	
	public Set<String> getChiaviPrenotazione(String ambiente, String mezzo, String partenza, String arrivo, String via, Data dataPartenza) throws OffertaInesistenteException, IDEsternoElementoException, PrenotazioneInesistenteException, DirittiException {
		Set<String> prenotazioni = mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(partenza).getElemento(arrivo).getElemento(via).getOfferta(dataPartenza).listaChiaviPrenotazioni();
		if (prenotazioni.isEmpty()){
			throw new PrenotazioneInesistenteException("Non ci sono prenotazioni per questo viaggio");
		} else
		return prenotazioni;
	}
	
	
	public Tratta getTrattaByValue(String ambiente, String mezzo, String cittaPartenza, String cittaArrivo, String via) throws TrattaInesistenteException{
		for (Tratta tratta : listaTratte) {
			if (tratta.verifyExistence(ambiente, mezzo, cittaPartenza, cittaArrivo, via))
				return tratta;
		}
		throw new TrattaInesistenteException("Tratta non esistente.");
	}
	
	
	public Offerta getOffertaFromMappa(String ambiente, String mezzo, String partenza, String arrivo, String via, Data data) throws IDEsternoElementoException, OffertaInesistenteException, DirittiException {
		
		return mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(partenza).getElemento(arrivo).getElemento(via).getOfferta(data);
	}
	
	public Prenotazione getPrenotazioneFromMappa(String ambiente,String mezzo, String partenza, String arrivo, String via, Data dataPartenza, String prenotazione) throws OffertaInesistenteException, PrenotazioneInesistenteException, IDEsternoElementoException, DirittiException {
		
		return mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(partenza).getElemento(arrivo).getElemento(via).getOfferta(dataPartenza).getPrenotazione(prenotazione);
	}
	
	
	private void aggiungiInMappaCatalogo(Tratta tratta) throws IDEsternoElementoException, DirittiException {
		/*
		 * Il controllo con esistenzaElemento() qui non e' piu' necessario, dal 
		 * momento che il metodo aggiungiElemento() in MappaCatalogo (a sua 
		 * volta richiamato dal metodo aggiungiElemento() in ElementoIntermedio) 
		 * aggiunge un elemento solo se la chiave non esiste gia'. 
		 */
		
		Ambiente ambiente = tratta.getAmbiente();
		Mezzo mezzo = tratta.getMezzo();
		Citta partenza = tratta.getPartenza();
		Citta arrivo = tratta.getArrivo();
		Via via = tratta.getVia();
		
		/*
		 * Bisogna sempre verificare, prima di aggiungere un elemento alla tabella, se questo elemento e' gia' presente!
		 */
		
		// Aggiungo l'ambiente in mappaCatalogo
		mappaCatalogo.aggiungiElemento(ambiente.getIDEsternoElemento(), ambiente);
		
		// Aggiungo il mezzo nella mappa dell'ambiente prima aggiunto
		mappaCatalogo.getElemento(ambiente.getIDEsternoElemento()).aggiungiElemento(mezzo.getIDEsternoElemento(), mezzo);
				
		// Aggiungo cittaPartenza nella mappa del mezzo prima aggiunto
		mappaCatalogo.getElemento(ambiente.getIDEsternoElemento()).getElemento(mezzo.getIDEsternoElemento()).aggiungiElemento(partenza.getIDEsternoElemento(), partenza);
		
		// Aggiungo stazioneArrivo nella mappa della cittaPartenza prima aggiunta
		mappaCatalogo.getElemento(ambiente.getIDEsternoElemento()).getElemento(mezzo.getIDEsternoElemento()).getElemento(partenza.getIDEsternoElemento()).aggiungiElemento(arrivo.getIDEsternoElemento(), arrivo);
				
		// Aggiungo via nella mappa delle citta' di Arrivo
		mappaCatalogo.getElemento(ambiente.getIDEsternoElemento()).getElemento(mezzo.getIDEsternoElemento()).getElemento(partenza.getIDEsternoElemento()).getElemento(arrivo.getIDEsternoElemento()).aggiungiElemento(via.getIDEsternoElemento(), via);

		//System.out.println("Viaggio Aggiunto");
		
	}
	
	
	private void rimuoviDaMappaCatalogo(Tratta tratta) throws IDEsternoElementoException, DirittiException {

		ElementoCatalogo elementoAmbiente = mappaCatalogo.getElemento(tratta.getAmbiente().getIDEsternoElemento());
		ElementoCatalogo elementoMezzo = elementoAmbiente.getElemento(tratta.getMezzo().getIDEsternoElemento());
		ElementoCatalogo elementoPartenza = elementoMezzo.getElemento(tratta.getPartenza().getIDEsternoElemento());
		ElementoCatalogo elementoArrivo = elementoPartenza.getElemento(tratta.getArrivo().getIDEsternoElemento());

		// Rimuovo via dalla mappa
		elementoArrivo.rimuoviElemento(tratta.getVia().getIDEsternoElemento());

		// Se la mappa della citta' di arrivo non ha elementi, rimuovo la citta' di arrivo;
		if (elementoArrivo.listaChiaviElementi().isEmpty())
			elementoPartenza.rimuoviElemento(tratta.getArrivo().getIDEsternoElemento());
		
		// Se la mappa della citta' di partenza non ha elementi, rimuovo la citta' di partenza
		if (elementoPartenza.listaChiaviElementi().isEmpty())
			elementoMezzo.rimuoviElemento(tratta.getPartenza().getIDEsternoElemento());
		
		// Se la mappa del mezzo non ha elementi, rimuovo il mezzo
		if (elementoMezzo.listaChiaviElementi().isEmpty())
			elementoAmbiente.rimuoviElemento(tratta.getMezzo().getIDEsternoElemento());
		
		// Se la mappa dell'ambiente non ha elementi, rimuovo l'ambiente
		if (elementoAmbiente.listaChiaviElementi().isEmpty())
			mappaCatalogo.rimuoviElemento(tratta.getAmbiente().getIDEsternoElemento());

		//System.out.println("Viaggio Rimosso");
		
	}


	private void aggiungiInMappaOfferte(Tratta tratta, Offerta offerta) throws IDEsternoElementoException, DirittiException {
		String ambiente = tratta.getAmbiente().getIDEsternoElemento();
		String mezzo = tratta.getMezzo().getIDEsternoElemento();
		String partenza = tratta.getPartenza().getIDEsternoElemento();
		String arrivo = tratta.getArrivo().getIDEsternoElemento();
		String via = tratta.getVia().getIDEsternoElemento();
		mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(partenza).getElemento(arrivo).getElemento(via).aggiungiOfferta(offerta.getData(), offerta);
		
	}

	private void rimuoviDaMappaOfferte(Tratta tratta, Offerta offerta) throws IDEsternoElementoException, OffertaInesistenteException, DirittiException {
		String ambiente = tratta.getAmbiente().getIDEsternoElemento();
		String mezzo = tratta.getMezzo().getIDEsternoElemento();
		String partenza = tratta.getPartenza().getIDEsternoElemento();
		String arrivo = tratta.getArrivo().getIDEsternoElemento();
		String via = tratta.getVia().getIDEsternoElemento();
		mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(partenza).getElemento(arrivo).getElemento(via).rimuoviOfferta(offerta.getData());
	}
	
	
	
	private void aggiungiInMappaPrenotazioni(Tratta tratta, Offerta offerta, Prenotazione prenotazione) throws OffertaInesistenteException, IDEsternoElementoException, DirittiException{
		String ambiente = tratta.getAmbiente().getIDEsternoElemento();
		String mezzo = tratta.getMezzo().getIDEsternoElemento();
		String partenza = tratta.getPartenza().getIDEsternoElemento();
		String arrivo = tratta.getArrivo().getIDEsternoElemento();
		String via = tratta.getVia().getIDEsternoElemento();
		Data dataPartenza = offerta.getData();
		mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(partenza).getElemento(arrivo).getElemento(via).getOfferta(dataPartenza).aggiungiPrenotazione(prenotazione.getnomeAcquirente(), prenotazione);
	}
	
	private void rimuoviDaMappaPrenotazioni(Tratta tratta, Offerta offerta, Prenotazione prenotazione) throws OffertaInesistenteException, PrenotazioneInesistenteException, IDEsternoElementoException, DirittiException{
		String ambiente = tratta.getAmbiente().getIDEsternoElemento();
		String mezzo = tratta.getMezzo().getIDEsternoElemento();
		String partenza = tratta.getPartenza().getIDEsternoElemento();
		String arrivo = tratta.getArrivo().getIDEsternoElemento();
		String via = tratta.getVia().getIDEsternoElemento();
		Data dataPartenza = offerta.getData();
		mappaCatalogo.getElemento(ambiente).getElemento(mezzo).getElemento(partenza).getElemento(arrivo).getElemento(via).getOfferta(dataPartenza).rimuoviPrenotazione(prenotazione.getnomeAcquirente());
	}
	
	
	public boolean esistenzaAmbiente(String ambiente){
		return mappaCatalogo.esistenzaElemento(ambiente);
	}

	public boolean esistenzaMezzo(String ambiente, String mezzo) throws IDEsternoElementoException, DirittiException{
		if (!esistenzaAmbiente(ambiente)){
			return false;
		}
		return mappaCatalogo.getElemento(ambiente).esistenzaElemento(mezzo);
	}
	
	
	/*
	 * 
	 * Metodi per i Thread
	 * 
	 */
	
	// Verifica se esista o meno una determinata offerta.
		public boolean verificaEsistenzaOffertaThread(String ambiente, String mezzo, String partenza, String arrivo, String via, Data dataPartenza) throws IDEsternoElementoException, DirittiException, InterruptedException {
			return mappaCatalogo.getElementoThread(ambiente).getElementoThread(mezzo).getElementoThread(partenza).getElementoThread(arrivo).getElementoThread(via).esistenzaOfferta(dataPartenza);
		}
	


}

