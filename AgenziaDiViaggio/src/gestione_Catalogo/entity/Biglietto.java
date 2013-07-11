package gestione_Catalogo.entity;

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
		
		//QUI ANDREBBE IL DAO BIGLIETTO, PER SALVARE IL BIGLIETTO SU DB E GENERARE L'ID DEL BIGLIETTO
		
		
		
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
