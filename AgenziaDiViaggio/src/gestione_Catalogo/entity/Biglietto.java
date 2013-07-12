package gestione_Catalogo.entity;

import gestione_Catalogo.dao.BigliettoDAO;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class Biglietto {
	
	private Integer idBiglietto;
	private Integer idPrenotazione;
	private Viaggiatore viaggiatore;

	
	
	public Biglietto(Integer idPrenotazione, String nome, String cognome, String eMail){
		this.idPrenotazione = idPrenotazione;	
		this.viaggiatore = new Viaggiatore(nome, cognome, eMail);
		
		BigliettoDAO dao = BigliettoDAO.getIstanza();
		this.idBiglietto = dao.insertAndReturnId(idPrenotazione, viaggiatore.getIdViaggiatore());
		
		
		
	}
	
	
	public Integer getIdBiglietto(){
		return idBiglietto;
	}
	
	public Integer getIdPrenotazione(){
		return idPrenotazione;
	}
	
	public Viaggiatore getViaggiatore(){
		return viaggiatore;
	}

}
