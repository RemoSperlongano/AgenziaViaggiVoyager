package gestione_Catalogo.entity;

import java.util.Set;

import gestione_Catalogo.dao.OffertaDAO;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.PrenotazioneInesistenteException;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class Offerta {
	
	private Integer idOfferta;
	private Integer idTratta;
	private Data dataPartenza;
	private Data dataArrivo;
	private Integer posti;
	private Data dataInserimento;
	private MappaPrenotazioni mappaPrenotazioni;
	
	
	

	public Offerta(Integer idTratta, Data dataPartenza, Integer durata, Integer posti) {
		this.idTratta = idTratta;
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataPartenza.getNuovaData(durata);
		this.posti = posti;
		this.dataInserimento = new Data();
		this.mappaPrenotazioni = new MappaPrenotazioni();

		
		//inserisco l'offerta appena creata nel db
		OffertaDAO dao = OffertaDAO.getIstanza();
		this.idOfferta = dao.insertAndReturnId(idTratta, dataPartenza, dataArrivo, posti, dataInserimento);
	}
	
	
	
	public Offerta(Integer idOfferta, Integer idTratta, Data dataPartenza, Data dataArrivo, Integer posti, Data dataInserimento){
		this.idOfferta = idOfferta;
		this.idTratta = idTratta;
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataArrivo;
		this.posti = posti;
		this.mappaPrenotazioni = new MappaPrenotazioni();
		this.dataInserimento = dataInserimento;
	}

	
	public Integer getIdOfferta(){
		return idOfferta;
	}
	
	public Data getData(){
		return dataPartenza;
	}
	
	public Data getDataArrivo(){
		return dataArrivo;
	}
	
	public Data getDataInserimento(){
		return dataInserimento;
	}
	
	public Integer getIdTratta(){
		return idTratta;
	}
	
	public Integer getPosti(){
		return posti;
	}
	
	public void assegnaPosti(int nPosti){
		this.posti -= nPosti;
		
		OffertaDAO dao = OffertaDAO.getIstanza();
		dao.update(this);
	}
	
	public boolean esistenzaPrenotazione(String nomeAcquirente){
		return mappaPrenotazioni.containsKey(nomeAcquirente);
	}
	
	public Set<String> listaChiaviPrenotazioni(){
		return mappaPrenotazioni.keySet();
	}
	
	public Prenotazione getPrenotazione(String nomeAcquirente) throws OffertaInesistenteException, PrenotazioneInesistenteException{
		return mappaPrenotazioni.getPrenotazione(nomeAcquirente);
	}
	
	public void aggiungiPrenotazione(String nomeAcquirente, Prenotazione p){
		mappaPrenotazioni.aggiungiPrenotazione(nomeAcquirente, p);
	}
	
	public void rimuoviPrenotazione(String nomeAcquirente) throws OffertaInesistenteException, PrenotazioneInesistenteException{
		mappaPrenotazioni.rimuoviPrenotazione(nomeAcquirente);
	}
	
	
}
