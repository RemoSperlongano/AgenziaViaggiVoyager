/**
 * 
 */
package gestione_Catalogo.control;

import java.util.ArrayList;

import gestione_Catalogo.entity.Utente;
import gestione_Catalogo.entity.Utenza;
import gestione_Catalogo.exception.CredenzialiErrateException;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.UtenteEsistenteException;
import gestione_Catalogo.exception.UtenteInesistenteException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreGestioneUtenti extends Controllore {
	
	protected static Utenza utenza;

	public ControlloreGestioneUtenti(){
		super();
		utenza = Utenza.getIstanza();
	}
	
	
	public void aggiungiUtente(String nome, String cognome, String email, String username, String password, String ruolo) throws UtenteEsistenteException{
		Utente nuovoUtente = new Utente(nome, cognome, email, username, password, ruolo);
		utenza.aggiungiUtente(nuovoUtente);
		log.aggiornaLogAggiungiUtente(sessione.getUsername(), nome, cognome, username, ruolo);
	}
	

	public void rimuoviUtente(String username, String ruolo) throws UtenteInesistenteException, DirittiException {
		if (sessione.getUsername().equals(username)){
			throw new DirittiException("Non e' possibile rimuovere l'utente della sessione corrente.");
		}
		Utente utente = utenza.getUtenteByUsername(username);
		utenza.rimuoviUtente(utente);
		log.aggiornaLogRimuoviUtente(sessione.getUsername(), username, ruolo);	
	}
	
	
	public void cambiaPassword(String vecchiaPsw, String nuovaPsw) throws UtenteInesistenteException, CredenzialiErrateException{
		String username = sessione.getUsername();
		Utente utente = utenza.getUtenteByUsername(username);
		if (!utente.getPassword().equals(vecchiaPsw)){
			throw new CredenzialiErrateException("La password inserita non e' corretta.");
		}
		utente.cambiaPassword(nuovaPsw);	 
	}
	
	
	public void cambiaEmail(String nuovaEmail, String password) throws UtenteInesistenteException, CredenzialiErrateException {
		String username = sessione.getUsername();
		Utente utente = utenza.getUtenteByUsername(username);
		if (!utente.getPassword().equals(password)){
			throw new CredenzialiErrateException("La password inserita non e' corretta.");
		}
		utente.cambiaEmail(nuovaEmail);
	}
	
	public ArrayList<String> mostraRuoliUtenza(){
		ArrayList<String> listaRuoliUtenza = new ArrayList<String>();
		ArrayList<Utente> listaUtenti = utenza.getListaUtenti();
		for (Utente u : listaUtenti){
			if (!listaRuoliUtenza.contains(u.getRuolo())){
				listaRuoliUtenza.add(u.getRuolo());
			}
		}
		return listaRuoliUtenza;
	}
	
	public ArrayList<String> mostraUtentiPerRuolo(String ruolo){
		ArrayList<String> listaUsername = new ArrayList<String>();
		ArrayList<Utente> listaUtenti = utenza.getListaUtenti();
		for (Utente u : listaUtenti){
			if (u.getRuolo().equals(ruolo)){ 
				listaUsername.add(u.getUsername());
			}
		}
		return listaUsername;
	}





}
