package gestione_Catalogo.dao;

import gestione_Catalogo.entity.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class PrenotazioneDAO extends DAO{
	
	private static PrenotazioneDAO istanza = null;

	private static final String getListaPrenotazioneQuery = "SELECT * FROM prenotazione WHERE 1";

	private static final String createQuery = 
			"CREATE TABLE IF NOT EXISTS prenotazione(" +
					"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
					"idofferta INTEGER, " +
					"acquirente VARCHAR(30), " +
					"datainserimento DATETIME, " +
					"FOREIGN KEY (idofferta) REFERENCES offerta (ID) "   +
					")";

	private static final String insertQuery = 
			"INSERT INTO prenotazione " +
			"VALUES(?, ?, ?, ?)";
	
	private static final String insertByValueQuery = 
		"INSERT INTO prenotazione(idofferta,acquirente,datainserimento) " +
		"VALUES(?, ?, ?)";
	
	private static final String updateQuery = 
			"UPDATE prenotazione SET " +
			"idofferta=?, acquirente=?, datainserimento=? " +
			"WHERE ID=? LIMIT 1";
	private static final String deleteQuery = 
			"DELETE FROM prenotazione " +
			"WHERE ID=? LIMIT 1";
	private static final String findQuery = 
			"SELECT * FROM prenotazione " +
			"WHERE ID=? LIMIT 1";

	private static final String findByValueQuery =
			"SELECT * FROM prenotazione " + 
			"WHERE idofferta=? AND acquirente=? LIMIT 1";

	private static final String dropQuery = "DROP TABLE prenotazione IF EXISTS";
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	
	private PrenotazioneDAO() {
		try {
			conn = Persistenza.getConnection();

			ps = conn.prepareStatement(createQuery);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
	}
	
	public static PrenotazioneDAO getIstanza() {
		if (istanza == null)
			istanza = new PrenotazioneDAO();
		return istanza;
	}
	
	/*
	 * CRUD - Create
	 * La Insert viene invocata dal costruttore di Prenotazione, collegata alla creazione dell'oggetto
	 * Questa particolare insert mi deve ritornare l'id da associare all'oggetto appena creato
	 */
	public Integer insertAndReturnId(Integer idOfferta, String acquirente, Data dataInserimento) {
		ResultSet rs;
		try {
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(findByValueQuery);
			ps.setInt(1, idOfferta);
			ps.setString(2, acquirente);
			System.out.println(ps.toString());
			
			rs = ps.executeQuery();
			if(rs.next()) { // elemento gia'  presente, ritorno direttamente l'ID. 
				Integer a = rs.getInt(1);
				closeResource();
				return a;
			} else { // elemento non presente: inserisco, inizialmente, solo il valore associato
				ps = conn.prepareStatement(insertByValueQuery);
				ps.setInt(1, idOfferta);
				ps.setString(2, acquirente);
				ps.setTimestamp(3, dataInserimento.getDataForDB());
				ps.executeUpdate();
				
				// ora che l'elemento e' inserito, richiedo l'ID associato e lo ritorno.
				ps = conn.prepareStatement(findByValueQuery);
				ps.setInt(1, idOfferta);
				ps.setString(2, acquirente);
				rs = ps.executeQuery();
				
				if(rs.next()) { // elemento gia'  presente, ritorno direttamente l'ID. 
					Integer a = rs.getInt(1);
					closeResource();
					return a;
				} else {
					closeResource();
					System.out.println("prova null");
					return null;
				}
			}
		} catch (ClassCastException e) {
			e.printStackTrace();
			closeResource();
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			closeResource();
			return null;
		}
	}
	

}
