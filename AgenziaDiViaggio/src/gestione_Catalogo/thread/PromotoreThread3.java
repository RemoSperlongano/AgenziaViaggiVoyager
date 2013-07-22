/**
 * 
 */
package gestione_Catalogo.thread;

import java.lang.reflect.InvocationTargetException;

import gestione_Catalogo.control.ControlloreGestioneCatalogo;
import gestione_Catalogo.exception.CittaCoincidentiException;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.TipoMezzoException;
import gestione_Catalogo.exception.TrattaException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class PromotoreThread3 implements Runnable {

	//Attributi d'istanza
	private ControlloreGestioneCatalogo controllore;
		
		
	//Costruttore
	public PromotoreThread3(ControlloreGestioneCatalogo controllore){
		this.controllore = controllore;
	}
	@Override
	public void run() {


		try {
			
			System.out.println("Promotore3 In azione");
			controllore.aggiungiViaggioThread("Mare", "Traghetto", "", "Cagliari", "Roma", "", "");
			controllore.aggiungiViaggioThread("Mare", "Panfilo", "", "Formia", "Napoli", "","");
			controllore.aggiungiViaggioThread("Mare", "Traghetto", "", "Cagliari", "Napoli", "", "");
			System.out.println("Promotore3 saluta e muore...");
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
		} catch (TrattaException e) {
			System.out.println("Il viaggio già esiste, il Promotore3 ucciso!");
		} catch (IDEsternoElementoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CittaCoincidentiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TipoMezzoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DirittiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
