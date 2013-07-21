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
public class PromotoreThread5 implements Runnable{

	//Attributi d'istanza
	private ControlloreGestioneCatalogo controllore;
		
		
	//Costruttore
	public PromotoreThread5(ControlloreGestioneCatalogo controllore){
		this.controllore = controllore;
	}
		
		
		
	@Override
	public void run() {


		try {
			
			System.out.println("Promotore5 In azione");
			controllore.aggiungiViaggio("Terra", "Bus", "", "Roma", "Bologna", "", "");
			controllore.aggiungiViaggio("Mare", "Traghetto", "", "Cagliari", "Ajaccio", "","");
			controllore.aggiungiViaggio("Aria", "Charter", "", "Chicago", "Buenos Aires", "", "");
			System.out.println("Promotore5 saluta e muore...");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
