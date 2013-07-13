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
