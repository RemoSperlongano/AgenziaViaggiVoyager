/**
 * 
 */
package gestione_Catalogo.control;

import gestione_Catalogo.entity.Indice;
import gestione_Catalogo.entity.Tratta;
import gestione_Catalogo.exception.CalcoloIndiceException;
import gestione_Catalogo.exception.TrattaInesistenteException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreGestioneIndici extends Controllore{
	
	public ControlloreGestioneIndici(){
		super();
	}

	
	public Double CalcolaIndiceGradimento(String ambiente, String mezzo, String partenza, String arrivo, String via, String metodoScelto, String numeratore, String denominatore) throws TrattaInesistenteException, CalcoloIndiceException {
		
		Tratta tratta;
		Tratta trattaInversa = null;
		Double risultato = null;
		
		Indice indice = Indice.getIstanza();
		
		tratta = catalogo.getTrattaByValue(ambiente, mezzo, partenza, arrivo, via);
		
		
		
		if (numeratore.equals("Ambiente") && denominatore.equals("Totale")){
			
		}
		
		if (numeratore.equals("Tipo Mezzo") && denominatore.equals("Ambiente")){
			
			if (tratta.getMezzo().getIDEsternoElemento().equals(tratta.getCategoria())){
				throw new CalcoloIndiceException("Il mezzo selezionato non ha un tipo. Calcolare indice Mezzo/Ambiente");
			}
			
		}
		
		if (numeratore.equals("Mezzo") && denominatore.equals("Ambiente")){
			
		}
		
		if (numeratore.equals("Mezzo") && denominatore.equals("Tipo Mezzo")){
			
			if (tratta.getMezzo().getIDEsternoElemento().equals(tratta.getCategoria())){
				throw new CalcoloIndiceException("Il mezzo selezionato non ha un tipo. Impossibile calcolare questo tipo di indice");
			}
			
		}
		
		if (numeratore.equals("Tratta") && denominatore.equals("Mezzo")){
			
			try {
				//se non c'è una tratta inversa, allora torna null, gestisce qui l'eccezione
				trattaInversa = catalogo.getTrattaByValue(ambiente, mezzo, arrivo, partenza, via);
			} catch (TrattaInesistenteException e) {
				trattaInversa = null;
			} finally {
				risultato = indice.calcolaIndiceGradimentoTrattaSuMezzo(tratta, trattaInversa, metodoScelto);
				
			}
			
		}
		
		
		return risultato;
		
		
		
		
	}
	
	
	

}
