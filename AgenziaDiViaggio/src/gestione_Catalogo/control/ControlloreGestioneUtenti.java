/**
 * 
 */
package gestione_Catalogo.control;

import gestione_Catalogo.entity.Utente;
import gestione_Catalogo.exception.UtenteEsistenteException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreGestioneUtenti extends Controllore {

	public ControlloreGestioneUtenti(){
		super();
	}
	
	
	public void cambiaPassword(String vecchiaPsw, String nuovaPsw){
		/*
		 * IN SOSPESO
		 */
		String username = sessione.getUsername();
			 
	}
	
	public void aggiungiUtente(String nome, String cognome, String email, String username, String password, String ruolo) throws UtenteEsistenteException{
		Utente nuovoUtente = new Utente(nome, cognome, email, username, password, ruolo);
		nuovoUtente.registraUtente();
		log.aggiornaLogAggiungiUtente(sessione.getUsername(), nome, cognome, username, ruolo);
	}
}
