/**
 * 
 */
package gestione_Catalogo;

import gestione_Catalogo.control.ControlloreAggiungiPrenotazione;
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
public class ThreadConcorrentiTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ControlloreGestioneOfferta controlloreProgettista = new ControlloreGestioneOfferta();
		ControlloreGestioneCatalogo controllorePromotore = new ControlloreGestioneCatalogo();
		ControlloreAggiungiPrenotazione controlloreVenditore = new ControlloreAggiungiPrenotazione();


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
		
		
		VenditoreThread1 vt1 = new VenditoreThread1(controlloreVenditore);
		VenditoreThread2 vt2 = new VenditoreThread2(controlloreVenditore);
		VenditoreThread3 vt3 = new VenditoreThread3(controlloreVenditore);
		VenditoreThread4 vt4 = new VenditoreThread4(controlloreVenditore);
		VenditoreThread5 vt5 = new VenditoreThread5(controlloreVenditore);
		
		
		
		
		
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
		Thread t11 = new Thread(vt1);
		Thread t12 = new Thread(vt2);
		Thread t13 = new Thread(vt3);
		Thread t14 = new Thread(vt4);
		Thread t15 = new Thread(vt5);
		
		
		t1.setName("T1_ProgettistaThread");
		t2.setName("T2_ProgettistaThread");
		t3.setName("T3_ProgettistaThread");
		t4.setName("T4_ProgettistaThread");
		t5.setName("T5_ProgettistaThread");
		t6.setName("T6_PromotoreThread");
		t7.setName("T7_PromotoreThread");
		t8.setName("T8_PromotoreThread");
		t9.setName("T9_PromotoreThread");
		t10.setName("T10_PromotoreThread");
		t11.setName("T11_VenditoreThread");
		t12.setName("T12_VenditoreThread");
		t13.setName("T13_VenditoreThread");
		t14.setName("T14_VenditoreThread");
		t15.setName("T15_VenditoreThread");
		

		t13.start();
		t5.start();
		t14.start();
		t1.start();
		t3.start();
		t15.start();
		t7.start();
		t9.start();
		t6.start();
		t10.start();
		t4.start();
		t12.start();
		t11.start();
		t8.start();
		t2.start();
		
		
		
		
		
		
		
		
		

	}

}
