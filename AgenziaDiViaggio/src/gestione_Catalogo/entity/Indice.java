/**
 * 
 */
package gestione_Catalogo.entity;

import gestione_Catalogo.dao.IndiceDAO;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class Indice {
	
	private static Indice istanza;
	
	private Indice(){
		
	}
	
	public static Indice getIstanza(){
		if (istanza == null){
			istanza = new Indice();
		}
		return istanza;
	}
	
	public Double calcolaIndiceGradimentoTrattaSuMezzo(Tratta tratta, Tratta trattaInversa, String metodoScelto){
		
		IndiceDAO dao = IndiceDAO.getIstanza();
		return dao.calcolaGradimentoTrattaSuMezzo(tratta, trattaInversa, metodoScelto);
		
	}

}
