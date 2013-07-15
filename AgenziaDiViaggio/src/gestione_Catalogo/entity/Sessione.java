/**
 * 
 */
package gestione_Catalogo.entity;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */


public class Sessione {
	private String username;
	private String ruolo;
	private String nome;
	private String cognome;
	private String eMail;
	
	public static final int USERNAME = 0;
	public static final int RUOLO = 1;
	public static final int NOME = 2;
	public static final int COGNOME = 3;
	public static final int EMAIL = 4;
	
	
	public Sessione(String username, String ruolo, String nome, String cognome, String mail){
		
		this.username = username;
		this.ruolo = ruolo;
		this.nome = nome;
		this.cognome = cognome;
		this.eMail = mail;
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getRuolo() {
		return ruolo;
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

