/**
 * 
 */
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
public class ViaggiatoreDAO extends DAO{
	
	private static ViaggiatoreDAO istanza = null;
	
	private static final String getListaViaggiatoreQuery = "SELECT * FROM viaggiatore WHERE 1";

	private static final String createQuery = 
			"CREATE TABLE IF NOT EXISTS viaggiatore(" +
					"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
					"nome VARCHAR(30), " +
					"cognome VARCHAR(30), " +
					"mail VARCHAR(50) " +
					")";

	private static final String insertQuery = 
			"INSERT INTO viaggiatore " +
			"VALUES(?, ?, ?, ?)";
	
	private static final String insertByValueQuery = 
		"INSERT INTO viaggiatore(nome,cognome,mail) " +
		"VALUES(?, ?, ?)";
	
	private static final String updateQuery = 
			"UPDATE viaggiatore SET " +
			"nome=?, cognome=?, mail=? " +
			"WHERE ID=? LIMIT 1";
	private static final String deleteQuery = 
			"DELETE FROM viaggiatore " +
			"WHERE ID=? LIMIT 1";
	private static final String findQuery = 
			"SELECT * FROM viaggiatore " +
			"WHERE ID=? LIMIT 1";

	private static final String findByValueQuery =
			"SELECT * FROM viaggiatore " + 
			"WHERE nome=? AND cognome=? LIMIT 1";

	private static final String dropQuery = "DROP TABLE viaggiatore IF EXISTS";
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	
	
	
	private ViaggiatoreDAO() {
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
	
	public static ViaggiatoreDAO getIstanza() {
		if (istanza == null)
			istanza = new ViaggiatoreDAO();
		return istanza;
	}
	
	
	
	/*
	 * CRUD - Create
	 * La Insert viene invocata dal costruttore di Viaggiatore, collegata alla creazione dell'oggetto
	 * Questa particolare insert mi deve ritornare l'id da associare all'oggetto appena creato
	 */
	public Integer insertAndReturnId(String nome, String cognome, String mail) {
		ResultSet rs;
		try {
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(findByValueQuery);
			ps.setString(1, nome);
			ps.setString(2, cognome);
			System.out.println(ps.toString());
			
			rs = ps.executeQuery();
			if(rs.next()) { // elemento gia'  presente, ritorno direttamente l'ID. 
				Integer a = rs.getInt(1);
				closeResource();
				return a;
			} else { // elemento non presente: inserisco, inizialmente, solo il valore associato
				ps = conn.prepareStatement(insertByValueQuery);
				ps.setString(1, nome);
				ps.setString(2, cognome);
				ps.setString(3, mail);
				ps.executeUpdate();
				
				// ora che l'elemento e' inserito, richiedo l'ID associato e lo ritorno.
				ps = conn.prepareStatement(findByValueQuery);
				ps.setString(1, nome);
				ps.setString(2, cognome);
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
