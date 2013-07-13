/**
 * 
 */
package gestione_Catalogo.control;

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
}
