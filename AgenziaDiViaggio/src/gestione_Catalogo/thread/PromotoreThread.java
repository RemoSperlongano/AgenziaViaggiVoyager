/*
 * Autori:
 * Remo Sperlongano
 * Ivan Torre
 */


package gestione_Catalogo.thread;

import java.lang.reflect.InvocationTargetException;

import gestione_Catalogo.control.ControlloreGestioneCatalogo;
import gestione_Catalogo.exception.CittaCoincidentiException;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.TipoMezzoException;
import gestione_Catalogo.exception.TrattaException;


public class PromotoreThread implements Runnable {
	
	//Attributi d'istanza
	private ControlloreGestioneCatalogo controllore;
	
	
	//Costruttore
	public PromotoreThread(ControlloreGestioneCatalogo controllore){
		this.controllore = controllore;
	}

	@Override
	public void run() {

		
		try {
	
			controllore.aggiungiViaggioThread("Aria", "Charter", "", "Roma", "Milano", "", "");
			controllore.aggiungiViaggioThread("Aria", "Charter", "", "Roma", "Parigi", "","");
			controllore.aggiungiViaggioThread("Aria", "Charter", "", "Roma", "Ginevra", "", "");
			controllore.aggiungiViaggioThread("Aria", "Charter", "", "Napoli", "Cagliari", "", "");
			controllore.aggiungiViaggioThread("Aria", "Charter", "", "Napoli", "Isernia", "", "");
			controllore.aggiungiViaggioThread("Aria", "Charter", "", "Napoli", "Torino", "", "");
			controllore.aggiungiViaggioThread("Aria", "Boing", "", "Roma", "Milano", "", "");
			controllore.aggiungiViaggioThread("Aria", "Boing", "", "Roma", "Parigi", "", "");
			controllore.aggiungiViaggioThread("Aria", "Boing", "", "Roma", "Ginevra", "", "");
			controllore.aggiungiViaggioThread("Aria", "Boing", "", "Napoli", "Cagliari","", "");
			controllore.aggiungiViaggioThread("Aria", "Boing", "", "Napoli", "Isernia", "", "");
			controllore.aggiungiViaggioThread("Aria", "Boing", "", "Napoli", "Torino", "", "");
			controllore.aggiungiViaggioThread("Terra", "Treno", "Tav", "Roma", "Milano", "", "");
			controllore.aggiungiViaggioThread("Terra", "Treno", "Tav", "Roma", "Parigi", "", "");
			controllore.aggiungiViaggioThread("Terra", "Treno", "Tav", "Roma", "Ginevra","", "");
			controllore.aggiungiViaggioThread("Terra", "Treno", "Base", "Napoli", "Cagliari","", "");
			controllore.aggiungiViaggioThread("Terra", "Treno", "Base", "Napoli", "Isernia","", "");
			controllore.aggiungiViaggioThread("Terra", "Treno", "Base", "Napoli", "Torino", "", "");
			controllore.aggiungiViaggioThread("Terra", "Bus", "", "Roma", "Milano", "", "");
			controllore.aggiungiViaggioThread("Terra", "Bus", "", "Roma", "Parigi", "", "");
			controllore.aggiungiViaggioThread("Terra", "Bus", "", "Roma", "Ginevra", "", "");
			controllore.aggiungiViaggioThread("Terra", "Bus", "", "Napoli", "Cagliari", "", "");
			controllore.aggiungiViaggioThread("Terra", "Bus", "", "Napoli", "Isernia", "", "");
			controllore.aggiungiViaggioThread("Terra", "Bus", "", "Napoli", "Torino", "", "");
			controllore.aggiungiViaggioThread("Mare", "Panfilo", "", "Roma", "Milano", "", "");
			controllore.aggiungiViaggioThread("Mare", "Panfilo", "", "Roma", "Parigi", "", "");
			controllore.aggiungiViaggioThread("Mare", "Panfilo", "", "Roma", "Ginevra", "", "");
			controllore.aggiungiViaggioThread("Mare", "Panfilo", "", "Napoli", "Cagliari", "", "");
			controllore.aggiungiViaggioThread("Mare", "Panfilo", "", "Napoli", "Isernia", "", "");
			controllore.aggiungiViaggioThread("Mare", "Panfilo", "", "Napoli", "Torino", "", "");
			controllore.aggiungiViaggioThread("Mare", "Traghetto", "", "Roma", "Milano", "", "");
			controllore.aggiungiViaggioThread("Mare", "Traghetto", "", "Roma", "Parigi", "", "");
			controllore.aggiungiViaggioThread("Mare", "Traghetto", "", "Roma", "Ginevra", "", "");
			controllore.aggiungiViaggioThread("Mare", "Traghetto", "", "Napoli", "Cagliari","", "");
			controllore.aggiungiViaggioThread("Mare", "Traghetto", "", "Napoli", "Isernia", "", "");
			controllore.aggiungiViaggioThread("Mare", "Traghetto", "", "Napoli", "Torino", "", "");
		
		} catch (IDEsternoElementoException e) {
			System.out.println(e.getMessage()+"\n");
		} catch (TipoMezzoException e) {
			System.out.println(e.getMessage()+"\n");
		} catch (CittaCoincidentiException e) {
			System.out.println(e.getMessage()+"\n");
		} catch (TrattaException e) {
			System.out.println(e.getMessage()+"\n");
		} catch (DirittiException e) {
			System.out.println(e.getMessage()+"\n");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
