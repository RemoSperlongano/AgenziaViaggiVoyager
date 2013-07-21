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
		
		ProgettistaThread1 pt1 = new ProgettistaThread1(controllore);
		ProgettistaThread2 pt2 = new ProgettistaThread2(controllore);
		ProgettistaThread3 pt3 = new ProgettistaThread3(controllore);
		ProgettistaThread4 pt4 = new ProgettistaThread4(controllore);
		ProgettistaThread5 pt5 = new ProgettistaThread5(controllore);
		
		
		
		
		Thread t1 = new Thread(pt1);
		Thread t2 = new Thread(pt2);
		Thread t3 = new Thread(pt3);
		Thread t4 = new Thread(pt4);
		Thread t5 = new Thread(pt5);
		
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		


	}

}
