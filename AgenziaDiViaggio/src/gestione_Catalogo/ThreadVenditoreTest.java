/**
 * 
 */
package gestione_Catalogo;

import gestione_Catalogo.control.ControlloreAggiungiPrenotazione;
import gestione_Catalogo.thread.VenditoreThread1;
import gestione_Catalogo.thread.VenditoreThread2;
import gestione_Catalogo.thread.VenditoreThread3;
import gestione_Catalogo.thread.VenditoreThread4;
import gestione_Catalogo.thread.VenditoreThread5;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ThreadVenditoreTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ControlloreAggiungiPrenotazione controllore = new ControlloreAggiungiPrenotazione();
		
		VenditoreThread1 vt1 = new VenditoreThread1(controllore);
		VenditoreThread2 vt2 = new VenditoreThread2(controllore);
		VenditoreThread3 vt3 = new VenditoreThread3(controllore);
		VenditoreThread4 vt4 = new VenditoreThread4(controllore);
		VenditoreThread5 vt5 = new VenditoreThread5(controllore);
		
		
		
		
		Thread t1 = new Thread(vt1);
		Thread t2 = new Thread(vt2);
		Thread t3 = new Thread(vt3);
		Thread t4 = new Thread(vt4);
		Thread t5 = new Thread(vt5);
		
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

}
