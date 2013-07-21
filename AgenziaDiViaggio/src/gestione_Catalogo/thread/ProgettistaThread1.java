/**
 * 
 */
package gestione_Catalogo.thread;

import gestione_Catalogo.control.ControlloreGestioneOfferta;
import gestione_Catalogo.exception.DataNonValidaException;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.OffertaException;
import gestione_Catalogo.exception.QuantitaException;
import gestione_Catalogo.exception.TrattaInesistenteException;



/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ProgettistaThread1 implements Runnable{


	//Attributi d'istanza
		private ControlloreGestioneOfferta controllore;
			
			
		//Costruttore
		public ProgettistaThread1(ControlloreGestioneOfferta controllore){
			this.controllore = controllore;
		}
		
		
	public void run() {
		
		
		try {
		Integer[] data = new Integer[5];
		data[0] = 15;
		data[1] = 5;
		data[2] = 2014;
		data[3] = 10;
		data[4] = 30;
		
		
		
		System.out.println("Progettista1 In azione");
		controllore.aggiungiOffertaThread("Aria", "Charter", "Roma", "Milano", "(Diretto)", data, new Integer(100), new Integer(100));
		controllore.aggiungiOffertaThread("Aria", "Charter", "Roma", "Parigi", "(Diretto)", data, new Integer(100), new Integer(100));
		controllore.aggiungiOffertaThread("Aria", "Boing", "Roma", "Ginevra", "(Diretto)", data, new Integer(100), new Integer(100));
		
		
		data[1] = 6;
		
		controllore.aggiungiOffertaThread("Aria", "Charter", "Roma", "Milano", "(Diretto)", data, new Integer(100), new Integer(100));
		controllore.aggiungiOffertaThread("Aria", "Charter", "Roma", "Parigi", "(Diretto)", data, new Integer(100), new Integer(100));
		controllore.aggiungiOffertaThread("Aria", "Boing", "Roma", "Ginevra", "(Diretto)", data, new Integer(100), new Integer(100));
		System.out.println("L'offerta saluta e muore...");
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TrattaInesistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IDEsternoElementoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OffertaException e) {
			System.out.println("Il viaggio gi� esiste, il Progettista1 ucciso!");
		} catch (QuantitaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataNonValidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DirittiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
