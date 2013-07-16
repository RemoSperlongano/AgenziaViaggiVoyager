/**
 * 
 */
package gestione_Catalogo.control;

import gestione_Catalogo.entity.Sessione;
import gestione_Catalogo.entity.Utente;
import gestione_Catalogo.exception.LoginFallitoException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreLogin extends Controllore {

	
	
	public ControlloreLogin(){
		if (sessione != null){
			sessione = null;
		}
	}

	
	public String controlloLogin(String username, String password) throws LoginFallitoException {
		
		//creo un nuovo utente e controllo il login
		Utente utente = new Utente(username, password);
		sessione = utente.login(username, password);
		
		if (sessione == null){
			throw new LoginFallitoException("La password e' errata o non esiste l'utente indicato");
		} else {
			inizializzaSessione(sessione);
			return sessione.getRuolo();
		}
	}
	
	
	private static void inizializzaSessione(Sessione s){
		sessione = s;
	}
}
