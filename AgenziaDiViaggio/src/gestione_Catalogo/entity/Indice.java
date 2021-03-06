/**
 * 
 */
package gestione_Catalogo.entity;

import gestione_Catalogo.dao.IndiceDAO;
import gestione_Catalogo.exception.CalcoloIndiceException;

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
	
	public Double calcolaIndiceGradimentoMezzoSuCategoria(Tratta tratta, String metodoScelto){
		
		IndiceDAO dao = IndiceDAO.getIstanza();
		return dao.calcolaGradimentoMezzoSuCategoria(tratta, metodoScelto);
		
	}

	public Double calcolaIndiceGradimentoCategoriaSuAmbiente(Tratta tratta, String metodoScelto){
	
	IndiceDAO dao = IndiceDAO.getIstanza();
	return dao.calcolaGradimentoCategoriaSuAmbiente(tratta, metodoScelto);
	
	}

	public Double calcolaIndiceGradimentoMezzoSuAmbiente(Tratta tratta, String metodoScelto){
	
	IndiceDAO dao = IndiceDAO.getIstanza();
	return dao.calcolaGradimentoMezzoSuAmbiente(tratta, metodoScelto);
	
	}

	public Double calcolaIndiceGradimentoAmbienteSuTotale(Tratta tratta, String metodoScelto){
	
	IndiceDAO dao = IndiceDAO.getIstanza();
	return dao.calcolaGradimentoAmbienteSuTotale(tratta, metodoScelto);
	
	}

}
