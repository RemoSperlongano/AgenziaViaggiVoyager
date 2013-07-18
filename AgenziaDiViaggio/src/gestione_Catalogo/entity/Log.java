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
	
	private static final String directory = "log";
	private static final String nomeFile ="/log.txt";
	private static final String path = directory+nomeFile;
	
	//attributi d'istanza
	private String log;
	
	
	//costruttore
	public Log() {
		log = "";
	}
	
	
	//Metodi
	public void aggiornaLogAggiungiViaggio(String user, String ambiente, String mezzo, String cittaPartenza, String cittaArrivo, String via){
		log = " * [" + Data.stampaDataAttuale() + "] "+ user +"  ---  AGGIUNTO VIAGGIO: \n     ";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + cittaPartenza + " : " + cittaArrivo + "  ->  " + via + "\n";
		System.out.println(log);
		salvaLog(log); 
	}
	

	public void aggiornaLogRimuoviViaggio(String user, String ambiente, String mezzo, String cittaPartenza, String cittaArrivo, String via){
		log = " * [" + Data.stampaDataAttuale() + "] "+ user +"  ---  RIMOSSO VIAGGIO: \n     ";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + cittaPartenza + " : " + cittaArrivo + "  ->  " + via + "\n";
		System.out.println(log);
		salvaLog(log); 
	}
	
	
	public void aggiornaLogAggiungiOfferta(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, Data dataPartenza, int durata, int posti) {
		log = " * [" + Data.stampaDataAttuale() + "] "+ user +"  ---  AGGIUNTA NUOVA OFFERTA: \n     ";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n     ";
		log+= "Data di Partenza: " + dataPartenza.stampaData()+"\n     ";
		log+= "Data di Arrivo: " + dataPartenza.getNuovaData(durata).stampaData()+"\n     ";
		log+= "Posti disponibili: " + posti+"\n";
		System.out.println(log);
		salvaLog(log); 
	}
	
	public void aggiornaLogRimuoviOfferta(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza) {
		log = " * [" + Data.stampaDataAttuale() + "] "+ user +"  ---  RIMOSSA OFFERTA: \n     ";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n     ";
		log+= "Data di Partenza: " + dataPartenza+"\n";
		System.out.println(log);
		salvaLog(log); 
		
	}
	
	public void aggiornaLogAggiungiPrenotazione(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza, String nomeAcquirente) {
		log = " * [" + Data.stampaDataAttuale() + "] "+ user +"  ---  AGGIUNTA NUOVA PRENOTAZIONE: \n     ";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n     ";
		log+= "Data di Partenza: " + dataPartenza +"\n     ";
		log+= "Nome Acquirente: " + nomeAcquirente+"\n";
		System.out.println(log);
		salvaLog(log); 

		
	}
	

	public void aggiornaLogRimuoviPrenotazione(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza, String nomeAcquirente) {
		log = " * [" + Data.stampaDataAttuale() + "] "+ user +"  ---  RIMOSSA PRENOTAZIONE: \n     ";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n     ";
		log+= "Data di Partenza: " + dataPartenza +"\n     ";
		log+= "Nome Acquirente: " + nomeAcquirente+"\n";
		System.out.println(log);
		salvaLog(log); 

	}
	
	
	public void aggiornaLogModificaPrenotazione(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza, String nomeAcquirente) {
		log = " * [" + Data.stampaDataAttuale() + "] "+ user +"  ---  MODIFICATA PRENOTAZIONE: \n     ";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n     ";
		log+= "Data di Partenza: " + dataPartenza +"\n     ";
		log+= "Nome Acquirente: " + nomeAcquirente+"\n";
		System.out.println(log);
		salvaLog(log); 
	}

	public void aggiornaLogEmissioneBiglietti(String user, String ambiente, String mezzo, String partenza, String arrivo, String via, String dataPartenza, String nomeAcquirente) {
		log = " * [" + Data.stampaDataAttuale() + "] "+ user +"  ---  EROGATI BIGLIETTI PER LA PRENOTAZIONE: \n     ";
		log+= "Viaggio Via " + ambiente + ": " + mezzo + "  ->  " + partenza + " : " + arrivo + "  ->  " + via + "\n     ";
		log+= "Data di Partenza: " + dataPartenza +"\n     ";
		log+= "Nome Acquirente: " + nomeAcquirente+"\n";
		System.out.println(log);
		salvaLog(log); 
		
	}

	

	public String caricaLog() throws FileInesistenteException {
		StringBuilder contenutoFile = new StringBuilder();
		File file = new File(path);
		try {			
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String s;
			while((s = br.readLine()) != null) {
				contenutoFile.append(s+"\n");
			} 
			br.close();
		} catch (FileNotFoundException e) {
			throw new FileInesistenteException("Log non presente.");
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return contenutoFile.toString();
	}
	
	
	public static void cancellaLog() throws FileInesistenteException{
		File file = new File(path);
		if(!file.exists())
			throw new FileInesistenteException("Il file di log non e' stato trovato.");
		file.delete();
	}
	

	private void salvaLog(String input) { //salva su file la stringa di input
		new File(directory).mkdir();
		BufferedWriter bw;
		try {
			File file = new File(path);
			bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(input+"\r\n");
			bw.flush();
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}



}
