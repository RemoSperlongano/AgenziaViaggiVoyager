/**
 * 
 */
package gestione_Catalogo.control;

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
		sessione = utente.login();
		
		if (sessione == null){
			throw new LoginFallitoException("La password e' errata o non esiste l'utente indicato");
		} else {
			return sessione.getRuolo();
		}
	}
	
	
}
