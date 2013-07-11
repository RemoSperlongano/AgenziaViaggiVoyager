package gestione_Catalogo.entity;

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
		
		//QUI ANDREBBE IL DAO VIAGGIATORE, PER FARSI DARE L'ID DEL VIAGGIATORE
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
