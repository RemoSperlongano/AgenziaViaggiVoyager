package gestione_Catalogo.entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import gestione_Catalogo.exception.FileInesistenteException;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class Log {
	
	
	//attributi d'istanza
	private String log;
	
	
	//costruttore
	public Log() {
		log = "";
	}
	
	
	//Metodi
	public void aggiornaLogAggiungiViaggio(String user, String ambiente, String mezzo, String cittaPartenza, String cittaArrivo, String via){
		log = "[" + Data.stampaDataAttuale() + "]  UTENTE: "+ user +"  -  AGGIUNTO VIAGGIO Via " + ambiente + ":\n" ;									
		log+= mezzo + "  ->  " + cittaPartenza + " : " + cittaArrivo + "  ->  " + via + "\n";
		System.out.println(log);
		salvaLog(log); 
	}
	

	public void aggiornaLogRimuoviViaggio(String user, String ambiente, String mezzo, String cittaPartenza, String cittaArrivo, String via){
		log = "[" + Data.stampaDataAttuale() + "]  UTENTE: "+ user +"  -  RIMOSSO VIAGGIO Via " + ambiente + ":\n";
		log+= mezzo + "  ->  " + cittaPartenza + " : " + cittaArrivo + "  ->  " + via + "\n";
		System.out.println(log);
		salvaLog(log); 
	}
	
	
	public void aggiornaLogAggiungiOfferta(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, Data dataPartenza, int durata, int posti) {
		log = "[" + Data.stampaDataAttuale() + "]  UTENTE: "+ user +"  -  AGGIUNTA NUOVA OFFERTA: \n";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n";
		log+= "Data di Partenza: " + dataPartenza.stampaData()+"\n";
		log+= "Data di Arrivo: " + dataPartenza.getNuovaData(durata).stampaData()+"\n";
		log+= "Posti disponibili: " + posti+"\n";
		System.out.println(log);
		salvaLog(log); 
	}
	
	public void aggiornaLogRimuoviOfferta(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza) {
		log = "[" + Data.stampaDataAttuale() + "]  UTENTE: "+ user +"  -  RIMOSSA OFFERTA: \n";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n";
		log+= "Data di Partenza: " + dataPartenza+"\n";
		System.out.println(log);
		salvaLog(log); 
		
	}
	
	public void aggiornaLogAggiungiPrenotazione(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza, String nomeAcquirente) {
		log = "[" + Data.stampaDataAttuale() + "]  UTENTE: "+ user +"  -  AGGIUNTA NUOVA PRENOTAZIONE: \n";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n";
		log+= "Data di Partenza: " + dataPartenza +"\n";
		log+= "Nome Acquirente: " + nomeAcquirente+"\n";
		System.out.println(log);
		salvaLog(log); 

		
	}
	

	public void aggiornaLogRimuoviPrenotazione(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza, String nomeAcquirente) {
		log = "[" + Data.stampaDataAttuale() + "]  UTENTE: "+ user +"  -  RIMOSSA PRENOTAZIONE: \n";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n";
		log+= "Data di Partenza: " + dataPartenza +"\n";
		log+= "Nome Acquirente: " + nomeAcquirente+"\n";
		System.out.println(log);
		salvaLog(log); 

	}
	
	
	public void aggiornaLogModificaPrenotazione(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza, String nomeAcquirente) {
		log = "[" + Data.stampaDataAttuale() + "]  UTENTE: "+ user +"  -  MODIFICATA PRENOTAZIONE: \n";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n";
		log+= "Data di Partenza: " + dataPartenza +"\n";
		log+= "Nome Acquirente: " + nomeAcquirente+"\n";
		System.out.println(log);
		salvaLog(log); 
	}

	public void aggiornaLogEmissioneBiglietti(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza, String nomeAcquirente) {
		log = "[" + Data.stampaDataAttuale() + "]  UTENTE: "+ user +"  -  EROGATI BIGLIETTI PER LA PRENOTAZIONE: \n";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n";
		log+= "Data di Partenza: " + dataPartenza +"\n";
		log+= "Nome Acquirente: " + nomeAcquirente+"\n";
		System.out.println(log);
		salvaLog(log); 
		
	}

	

	public String caricaLog() throws FileInesistenteException {
		String contenutoFile = "";
		String Dir = "Save";
		new File(Dir).mkdir();
		String path = Dir+"/log.txt";
		FileReader fr;
		
		File file = new File(path);
		try {			
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr); 
			String s;
			while((s = br.readLine()) != null) {
				contenutoFile = contenutoFile + s+"\n";
			} 
			fr.close();
		} catch (FileNotFoundException e) {
			throw new FileInesistenteException("Attenzione! File Inesistente!");
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return contenutoFile;
	}
	

	private void salvaLog(String input) { //salva su file la stringa di input
		String Dir = "Save";
		new File(Dir).mkdir();
		String path = Dir+"/log.txt";
		BufferedWriter fw;
		try {
			File file = new File(path);
			fw = new BufferedWriter(new FileWriter(file,true));
			fw.write(input+"\r\n");
			fw.flush();
			fw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}



}
