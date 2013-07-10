package gestione_Catalogo.entity;

import gestione_Catalogo.dao.OffertaDAO;

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
	private MappaPrenotazioni mappaPrenotazioni;
	
	private Data dataInserimento;
	

	public Offerta(Integer idTratta, Data dataPartenza, Integer durata, Integer posti) {
		this.idTratta = idTratta;
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataPartenza.getNuovaData(durata);
		this.posti = posti;
		this.dataInserimento = new Data();
		this.mappaPrenotazioni = new MappaPrenotazioni();

		
		//inserisco l'offerta appena creata nel db
		OffertaDAO dao = OffertaDAO.getIstanza();
		this.idOfferta = dao.insertAndReturnId(idTratta, dataPartenza, dataPartenza, posti, dataInserimento);
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


	public boolean verifyExistence(Integer idTratta, Data dataPartenza){
		//serve per verificare se l'offerta da inserire e' gia presente
		if(this.idTratta.equals(idTratta) &&
		   this.dataPartenza.equals(dataPartenza)) return true;
		else return false;
		
	}
	
	
	public boolean verifyExistence(Integer idTratta) {
		//serve per verificare se nella lista delle offerte, c'e' almeno un offerta per una particolare tratta
		//evita di eliminare quella tratta
		if (this.idTratta.equals(idTratta))
			return true;
		return false;
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
	
	public Integer getIdTratta(){
		return idTratta;
	}
	
	public Integer getPosti(){
		return posti;
	}
	
}
