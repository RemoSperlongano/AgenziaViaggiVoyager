/**
 * 
 */
package gestione_Catalogo.control;

import gestione_Catalogo.entity.Log;
import gestione_Catalogo.exception.FileInesistenteException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreVisualizzaLog extends Controllore {
	
	public ControlloreVisualizzaLog(){
		super();
	}
	
	public String visualizzaLog() throws FileInesistenteException{
		return log.caricaLog();
	}
	
	public void cancellaLog() throws FileInesistenteException{
		Log.cancellaLog();
	}

}
