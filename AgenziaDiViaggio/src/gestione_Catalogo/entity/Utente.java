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
	
	
	public final static String RUOLO_AMMINISTRATORE = "Amministratore";
	public final static String RUOLO_PROMOTORE = "Promotore";
	public final static String RUOLO_PROGETTISTA = "Progettista";
	public final static String RUOLO_GESTORE_ECCEZIONI = "GestoreEccezioni";
	public final static String RUOLO_VENDITORE = "Venditore";
	public final static String RUOLO_CLIENTE = "Cliente";
	
	public final static String[] RUOLI = {
		RUOLO_AMMINISTRATORE, RUOLO_PROMOTORE, RUOLO_PROGETTISTA, RUOLO_GESTORE_ECCEZIONI, RUOLO_VENDITORE, RUOLO_CLIENTE
	};
	

	
	public Utente(String nome, String cognome, String eMail, String username, String password, String ruolo){
		this.nome = nome;
		this.cognome = cognome;
		this.eMail = eMail;
		this.username = username;
		this.password = password;
		this.ruolo = ruolo;
	}
	
	//costruttore usato da Controllore login per controllo credenziali da db
	public Utente(String username, String password){
		this.nome = null;
		this.cognome = null;
		this.eMail = null;
		this.username = username;
		this.password = password;
		this.ruolo = null;
	}
	
	
	public void registraUtente() throws UtenteEsistenteException{
		UtenteDAO dao = UtenteDAO.getIstanza();
		dao.insert(nome, cognome, eMail, username, password, ruolo);
	}
	
	public Sessione login(){
		UtenteDAO dao = UtenteDAO.getIstanza();
		return dao.login(username, password);
	}
	
	public void cambiaPasswordAmministratore(String username, String password){
		UtenteDAO dao = UtenteDAO.getIstanza();
		dao.cambiaPasswordAmministratore(username, password);
	}
	
	
	public void cambiaPassword(String password){
		UtenteDAO dao = UtenteDAO.getIstanza();
		dao.cambiaPassword(username, password);
	}
	
	public void cambiaEmail(String email){
		UtenteDAO dao = UtenteDAO.getIstanza();
		dao.cambiaMail(username, email);
	}
	
	public void eliminaUtente(){
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
