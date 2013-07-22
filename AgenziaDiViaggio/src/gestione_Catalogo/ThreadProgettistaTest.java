/**
 * 
 */
package gestione_Catalogo;


import gestione_Catalogo.control.ControlloreGestioneOfferta;
import gestione_Catalogo.thread.ProgettistaThread1;
import gestione_Catalogo.thread.ProgettistaThread2;
import gestione_Catalogo.thread.ProgettistaThread3;
import gestione_Catalogo.thread.ProgettistaThread4;
import gestione_Catalogo.thread.ProgettistaThread5;


/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ThreadProgettistaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ControlloreGestioneOfferta controllore = new ControlloreGestioneOfferta();
		
		ProgettistaThread1 dt1 = new ProgettistaThread1(controllore);
		ProgettistaThread2 dt2 = new ProgettistaThread2(controllore);
		ProgettistaThread3 dt3 = new ProgettistaThread3(controllore);
		ProgettistaThread4 dt4 = new ProgettistaThread4(controllore);
		ProgettistaThread5 dt5 = new ProgettistaThread5(controllore);
		
		
		
		
		Thread t1 = new Thread(dt1);
		Thread t2 = new Thread(dt2);
		Thread t3 = new Thread(dt3);
		Thread t4 = new Thread(dt4);
		Thread t5 = new Thread(dt5);
		
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		


	}

}
