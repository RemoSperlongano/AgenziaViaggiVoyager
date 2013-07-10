/**
 * 
 */
package gestione_Catalogo.entity;

import java.util.TreeMap;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class MappaPrenotazioni extends TreeMap<Integer, Prenotazione>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MappaPrenotazioni(){
		super();
	}
	
	public void aggiungiPrenotazione(Integer idPrenotazione, Prenotazione p){
		super.put(idPrenotazione, p);
	}

}
