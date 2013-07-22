/*
 * Autori:
 * Remo Sperlongano
 * Ivan Torre
 */

package gestione_Catalogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String createQuery = null;
		String dropQuery = null;
		String insertQuery = null;
		PreparedStatement ps = null;
		
				
				
		System.out.println("Test di connessione a MySQL.");
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		String connectionURL = "jdbc:mysql:";
		String url = connectionURL + "//" + "localhost:3306" + "/";
		String dbName = url + "voyager";


		String userName = "voyager";
		String password = "voyager";
		try {
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(dbName,userName,password);
		System.out.println("Connesso.");
		
		
		System.out.println("Piallo il db!!!");
		dropQuery = "DROP TABLE `utente`, `biglietto`, `viaggiatore`, `prenotazione`, `offerta`, `catalogo`, `ambiente`, `citta`, `mezzo`, `via`";
		
		ps = conn.prepareStatement(dropQuery);
		ps.executeUpdate();
		
		System.out.println("Creo Tabella utente");
		createQuery = 
				"CREATE TABLE IF NOT EXISTS utente(" +
						"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
						"nome VARCHAR(30), " +
						"cognome VARCHAR(30), " +
						"mail VARCHAR(30), " +
						"username VARCHAR(30), " +
						"password VARCHAR(30), " +
						"ruolo VARCHAR(30) " +
						")";
		ps = conn.prepareStatement(createQuery);
		ps.executeUpdate();
		
		System.out.println("Inserisco utenti di base");
		insertQuery =
				"INSERT INTO `utente` (`nome`, `cognome`, `mail`, `username`, `password`, `ruolo`) VALUES " + 
				"('admin', 'voyager', 'admin@voyager.it', 'admin', 'pas', 'PrimoAccesso'), " +
				"('Moto', 'Vendo', 'motovendo@voyager.it', 'v', 'v', 'Venditore'), " +
				"('Vincenzo', 'Proferrari', 'proferrari@voyager.it', 'p', 'p', 'Promotore'), " +
				"('Archimede', 'Pitagorico', 'archipit@voyager.it', 'd', 'd', 'Progettista'), " +
				"('Mario', 'Rossi', 'mariorossi@libero.it', 'c', 'c', 'Cliente'), " +
				"('Felice', 'Correggetti', 'correggetti@voyager.it', 'g', 'g', 'GestoreEccezioni') ";
		
		ps = conn.prepareStatement(insertQuery);
		ps.executeUpdate();
		
		
		System.out.println("Creo Tabella ambiente");
		createQuery = 
				"CREATE TABLE IF NOT EXISTS ambiente(" +
						"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
						"idesternoelemento VARCHAR(30) " +
						")";
		
		ps = conn.prepareStatement(createQuery);
		ps.executeUpdate();
		
		
		
		
		System.out.println("Creo Tabella mezzo");
		createQuery = 
				"CREATE TABLE IF NOT EXISTS mezzo(" +
						"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
						"idesternoelemento VARCHAR(30) " +
						")";
		
		ps = conn.prepareStatement(createQuery);
		ps.executeUpdate();
		
		
		
		System.out.println("Creo Tabella citta");
		createQuery = 
				"CREATE TABLE IF NOT EXISTS citta(" +
						"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
						"idesternoelemento VARCHAR(30) " +
						")";
		
		ps = conn.prepareStatement(createQuery);
		ps.executeUpdate();
		
		
		
		System.out.println("Creo Tabella via");
		createQuery = 
				"CREATE TABLE IF NOT EXISTS via(" +
						"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
						"idesternoelemento VARCHAR(30) " +
						")";
		
		ps = conn.prepareStatement(createQuery);
		ps.executeUpdate();
		
		
		
		
		System.out.println("Creo Tabella catalogo");
		createQuery = 
				"CREATE TABLE IF NOT EXISTS catalogo(" +
						"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
						"ambiente INTEGER, " +
						"mezzo INTEGER, " +
						"categoria VARCHAR(30), " +
						"cittapartenza INTEGER, " +
						"cittaarrivo INTEGER, " +
						"via INTEGER, " +
						"info VARCHAR(100), " +
						"data DATETIME, " +
						"FOREIGN KEY (ambiente) REFERENCES ambiente (ID), "   +
						"FOREIGN KEY (mezzo) REFERENCES mezzo (ID), " +
						"FOREIGN KEY (cittapartenza) REFERENCES citta (ID), " +
						"FOREIGN KEY (cittaarrivo) REFERENCES citta (ID), " +
						"FOREIGN KEY (via) REFERENCES via (ID) " +
						")";
		
		ps = conn.prepareStatement(createQuery);
		ps.executeUpdate();
		
		System.out.println("Creo Tabella offerta");
		createQuery = 
				"CREATE TABLE IF NOT EXISTS offerta(" +
						"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
						"idtratta INTEGER, " +
						"datapartenza DATETIME, " +
						"dataarrivo DATETIME, " +
						"posti INTEGER, " +
						"datainserimento DATETIME, " +
						"FOREIGN KEY (idtratta) REFERENCES catalogo (ID) "   +
						")";
		
		ps = conn.prepareStatement(createQuery);
		ps.executeUpdate();
		
		System.out.println("Creo Tabella prenotazioni");
		createQuery = 
				"CREATE TABLE IF NOT EXISTS prenotazione(" +
						"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
						"idofferta INTEGER, " +
						"acquirente VARCHAR(30), " +
						"datainserimento DATETIME, " +
						"FOREIGN KEY (idofferta) REFERENCES offerta (ID) "   +
						")";

		ps = conn.prepareStatement(createQuery);
		ps.executeUpdate();
		
		System.out.println("Creo Tabella viaggiatori");
		createQuery = 
				"CREATE TABLE IF NOT EXISTS viaggiatore(" +
						"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
						"nome VARCHAR(30), " +
						"cognome VARCHAR(30), " +
						"mail VARCHAR(50) " +
						")";
		
		ps = conn.prepareStatement(createQuery);
		ps.executeUpdate();
		
		System.out.println("Creo Tabella biglietti");
		createQuery = 
				"CREATE TABLE IF NOT EXISTS biglietto(" +
		"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
		"idprenotazione INTEGER, " +
		"idviaggiatore INTEGER, " +
		"FOREIGN KEY (idprenotazione) REFERENCES prenotazione (ID), "   +
		"FOREIGN KEY (idviaggiatore) REFERENCES viaggiatore (ID) " +
		")";
		
		ps = conn.prepareStatement(createQuery);
		ps.executeUpdate();
		
		
		
		
		conn.close();
		System.out.println("Non connesso.");
		} catch (Exception e) {
		e.printStackTrace();
		}

	}

}
