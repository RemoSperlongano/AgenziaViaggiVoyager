/**
 * 
 */
package gestione_Catalogo.thread;

import gestione_Catalogo.control.ControlloreAggiungiPrenotazione;
import gestione_Catalogo.entity.Data;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.PostiNonSufficientiException;
import gestione_Catalogo.exception.PrenotazioneException;
import gestione_Catalogo.exception.QuantitaException;
import gestione_Catalogo.exception.TrattaInesistenteException;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class VenditoreThread5 implements Runnable {


	//Attributi d'istanza
		private ControlloreAggiungiPrenotazione controllore;
		private ArrayList<String> listaNomi = new ArrayList<String>();
		private ArrayList<String> listaCognomi = new ArrayList<String>();
		private ArrayList<String> listaMail = new ArrayList<String>();
			
			
		//Costruttore
		public VenditoreThread5(ControlloreAggiungiPrenotazione controllore){
			this.controllore = controllore;
		}
		
		
	public void run() {
		


		
		
		
		try {
		Integer[] data = new Integer[5];
		data[0] = 15;
		data[1] = 5;
		data[2] = 2014;
		data[3] = 10;
		data[4] = 30;
		
		Data dataPartenza = new Data(data[0], data[1], data[2], data[3], data[4]);
		
		
		
		System.out.println("Venditore5 In azione");
		riempiListe();
		controllore.aggiungiPrenotazioneThread("Terra", "Bus", "Roma", "Bologna", "(Diretto)", dataPartenza.stampaData(), listaNomi, listaCognomi, listaMail);
		Thread.sleep(100);
		riempiListe();
		controllore.aggiungiPrenotazioneThread("Mare", "Traghetto", "Cagliari", "Ajaccio", "(Diretto)", dataPartenza.stampaData(), listaNomi, listaCognomi, listaMail);
		Thread.sleep(100);
		riempiListe();
		controllore.aggiungiPrenotazioneThread("Aria", "Charter", "Chicago", "Buenos Aires", "(Diretto)", dataPartenza.stampaData(), listaNomi, listaCognomi, listaMail);
		
		System.out.println("Venditore5 saluta e muore...");
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TrattaInesistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IDEsternoElementoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QuantitaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (DirittiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (OffertaInesistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PrenotazioneException e) {
			System.out.println("La prenotazione già esiste, il Venditore5 ucciso!");
		} catch (PostiNonSufficientiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void riempiListe(){
		String nome = "Mario";
		String cognome = "Rossi";
		String mail = "mario.rossi@libero.it";
		
		listaNomi.add(nome);
		listaCognomi.add(cognome);
		listaMail.add(mail);
		
		nome = "Sonia";
		cognome = "Strada";
		mail = "sonia11985@libero.it";
		
		listaNomi.add(nome);
		listaCognomi.add(cognome);
		listaMail.add(mail);
		
		nome = "Cristian";
		cognome = "LaGrotteria";
		mail = "CriLaGrotte@alice.it";
		
		listaNomi.add(nome);
		listaCognomi.add(cognome);
		listaMail.add(mail);
	}

}
