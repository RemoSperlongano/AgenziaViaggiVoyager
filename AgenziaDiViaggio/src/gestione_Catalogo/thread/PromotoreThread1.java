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
public class PromotoreThread1 implements Runnable {

	//Attributi d'istanza
	private ControlloreGestioneCatalogo controllore;
		
		
	//Costruttore
	public PromotoreThread1(ControlloreGestioneCatalogo controllore){
		this.controllore = controllore;
	}
		
		
	@Override
	public void run() {

		
		try {
			
			System.out.println("Promotore1 In azione");
			controllore.aggiungiViaggioThread("Aria", "Charter", "", "Roma", "Milano", "", "");
			Thread.sleep(100);
			controllore.aggiungiViaggioThread("Aria", "Charter", "", "Roma", "Parigi", "","");
			Thread.sleep(100);
			controllore.aggiungiViaggioThread("Aria", "Boing", "", "Roma", "Ginevra", "", "");
			System.out.println("Promotore1 saluta e muore...");
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
			System.out.println("Il viaggio gi� esiste, il Promotore1 ucciso!");
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
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
