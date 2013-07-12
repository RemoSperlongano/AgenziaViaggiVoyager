package gestione_Catalogo.entity;

import gestione_Catalogo.dao.ViaggiatoreDAO;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class Viaggiatore {
	
	private Integer idViaggiatore;
	private String nome;
	private String cognome;
	private String eMail;
	
	public Viaggiatore(String nome, String cognome, String eMail){
		this.nome = nome;
		this.cognome = cognome;
		this.eMail = eMail;
		
		ViaggiatoreDAO dao = ViaggiatoreDAO.getIstanza();
		this.idViaggiatore = dao.insertAndReturnId(nome, cognome, eMail);
	}
	
	public Viaggiatore(Integer idViaggiatore, String nome, String cognome, String eMail){
		this.idViaggiatore = idViaggiatore;
		this.nome = nome;
		this.cognome = cognome;
		this.eMail = eMail;
	}
	
	public Integer getIdViaggiatore(){
		return idViaggiatore;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	public String getEmail(){
		return eMail;
	}

}
