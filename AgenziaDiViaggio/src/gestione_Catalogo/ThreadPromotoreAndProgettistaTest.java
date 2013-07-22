/**
 * 
 */
package gestione_Catalogo;

import gestione_Catalogo.control.ControlloreGestioneCatalogo;
import gestione_Catalogo.control.ControlloreGestioneOfferta;
import gestione_Catalogo.thread.ProgettistaThread1;
import gestione_Catalogo.thread.ProgettistaThread2;
import gestione_Catalogo.thread.ProgettistaThread3;
import gestione_Catalogo.thread.ProgettistaThread4;
import gestione_Catalogo.thread.ProgettistaThread5;
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
public class ThreadPromotoreAndProgettistaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ControlloreGestioneOfferta controlloreProgettista = new ControlloreGestioneOfferta();
		ControlloreGestioneCatalogo controllorePromotore = new ControlloreGestioneCatalogo();


		ProgettistaThread1 dt1 = new ProgettistaThread1(controlloreProgettista);
		ProgettistaThread2 dt2 = new ProgettistaThread2(controlloreProgettista);
		ProgettistaThread3 dt3 = new ProgettistaThread3(controlloreProgettista);
		ProgettistaThread4 dt4 = new ProgettistaThread4(controlloreProgettista);
		ProgettistaThread5 dt5 = new ProgettistaThread5(controlloreProgettista);
		
		PromotoreThread1 pt1 = new PromotoreThread1(controllorePromotore);
		PromotoreThread2 pt2 = new PromotoreThread2(controllorePromotore);
		PromotoreThread3 pt3 = new PromotoreThread3(controllorePromotore);
		PromotoreThread4 pt4 = new PromotoreThread4(controllorePromotore);
		PromotoreThread5 pt5 = new PromotoreThread5(controllorePromotore);
		
		
		
		
		
		Thread t1 = new Thread(dt1);
		Thread t2 = new Thread(dt2);
		Thread t3 = new Thread(dt3);
		Thread t4 = new Thread(dt4);
		Thread t5 = new Thread(dt5);
		Thread t6 = new Thread(pt1);
		Thread t7 = new Thread(pt2);
		Thread t8 = new Thread(pt3);
		Thread t9 = new Thread(pt4);
		Thread t10 = new Thread(pt5);
		
		
		
		t5.start();
		t1.start();
		t3.start();
		t7.start();
		t9.start();
		t6.start();
		t10.start();
		t4.start();
		t8.start();
		t2.start();
		
		
		
		
		
		
		
		
		

	}



}
