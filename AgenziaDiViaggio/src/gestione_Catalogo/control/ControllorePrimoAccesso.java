/**
 * 
 */
package gestione_Catalogo.control;

import gestione_Catalogo.entity.Utente;
import gestione_Catalogo.exception.UtenteEsistenteException;
import gestione_Catalogo.exception.UtenteInesistenteException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControllorePrimoAccesso extends ControlloreGestioneUtenti{

	
	public void modificaUtente(String nome, String cognome, String email, String username, String password, String ruolo) throws UtenteInesistenteException, UtenteEsistenteException  {
		
		
		Utente vecchioUtente = utenza.getUtenteByUsername("admin");
		utenza.rimuoviUtente(vecchioUtente);
		
		Utente nuovoUtente = new Utente(nome, cognome, email, username, password, ruolo);
		utenza.aggiungiUtente(nuovoUtente);
		log.aggiornaLogAggiungiUtente(sessione.getUsername(), nome, cognome, username, ruolo);
		// TODO Auto-generated method stub
		
	}

}
