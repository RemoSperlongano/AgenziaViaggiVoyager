/**
 * 
 */
package gestione_Catalogo;

import gestione_Catalogo.control.ControlloreGestioneCatalogo;
import gestione_Catalogo.thread.PromotoreThread1;
import gestione_Catalogo.thread.PromotoreThread2;
import gestione_Catalogo.thread.PromotoreThread3;
import gestione_Catalogo.thread.PromotoreThread4;
import gestione_Catalogo.thread.PromotoreThread5;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ControlloreGestioneCatalogo controllore = new ControlloreGestioneCatalogo();
		PromotoreThread1 pt1 = new PromotoreThread1(controllore);
		PromotoreThread2 pt2 = new PromotoreThread2(controllore);
		PromotoreThread3 pt3 = new PromotoreThread3(controllore);
		PromotoreThread4 pt4 = new PromotoreThread4(controllore);
		PromotoreThread5 pt5 = new PromotoreThread5(controllore);
		
		
		
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
