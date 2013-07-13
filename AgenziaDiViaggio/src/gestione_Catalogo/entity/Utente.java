/**
 * 
 */
package gestione_Catalogo.entity;

import gestione_Catalogo.dao.UtenteDAO;
import gestione_Catalogo.exception.UtenteEsistenteException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class Utente {
	
	private String nome;
	private String cognome;
	private String eMail;
	private String username;
	private String password;
	private String ruolo;

	
	public Utente(String nome, String cognome, String eMail, String username, String password, String ruolo){
		this.nome = nome;
		this.cognome = cognome;
		this.eMail = eMail;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}
	
	
	public void registraUtente(String nome, String cognome, String mail, String username, String password, String ruolo) throws UtenteEsistenteException{
		UtenteDAO dao = UtenteDAO.getIstanza();
		dao.insert(nome, cognome, mail, username, password, ruolo);
	}
	
	public Sessione login(String username, String password){
		UtenteDAO dao = UtenteDAO.getIstanza();
		return dao.login(username, password);
	}
	
	public void cambiaPassword(String username, String password){
		UtenteDAO dao = UtenteDAO.getIstanza();
		dao.cambiaPassword(username, password);
	}
	
	public void eliminaUtente(String username){
		UtenteDAO dao = UtenteDAO.getIstanza();
		dao.delete(username);
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
	
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getRuolo(){
		return ruolo;
	}
}
