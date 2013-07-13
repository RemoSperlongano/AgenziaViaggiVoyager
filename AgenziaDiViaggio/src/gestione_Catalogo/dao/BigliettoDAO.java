/**
 * 
 */
package gestione_Catalogo.dao;

import gestione_Catalogo.entity.Biglietto;
import gestione_Catalogo.entity.Data;
import gestione_Catalogo.entity.Offerta;
import gestione_Catalogo.entity.Prenotazione;
import gestione_Catalogo.entity.Viaggiatore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BigliettoDAO extends DAO{
	
	private static BigliettoDAO istanza = null;

	private static final String getListaBigliettiQuery = "SELECT * FROM biglietto WHERE 1";

	private static final String createQuery = 
			"CREATE TABLE IF NOT EXISTS biglietto(" +
					"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
					"idprenotazione INTEGER, " +
					"idviaggiatore INTEGER, " +
					"FOREIGN KEY (idprenotazione) REFERENCES prenotazione (ID), "   +
					"FOREIGN KEY (idviaggiatore) REFERENCES viaggiatore (ID) " +
					")";

	private static final String insertQuery = 
			"INSERT INTO biglietto " +
			"VALUES(?, ?, ?)";
	
	private static final String insertByValueQuery = 
		"INSERT INTO biglietto(idprenotazione, idviaggiatore) " +
		"VALUES(?, ?)";
	
	private static final String updateQuery = 
			"UPDATE biglietto SET " +
			"idprenotazione=?, idviaggiatore=? " +
			"WHERE ID=? LIMIT 1";
	private static final String deleteQuery = 
			"DELETE FROM biglietto " +
			"WHERE ID=? LIMIT 1";
	private static final String deletePrenotazioneQuery =
			"DELETE FROM biglietto " +
			"WHERE idPrenotazione=?";
	private static final String findQuery = 
			"SELECT * FROM biglietto " +
			"WHERE ID=? LIMIT 1";

	private static final String findByValueQuery =
			"SELECT * FROM biglietto " + 
			"WHERE idprenotazione=? AND idviaggiatore=? LIMIT 1";

	
	private static final String findByIdQuery =
			"SELECT * FROM biglietto " + 
			"WHERE idprenotazione=?";
	
	
	private static final String dropQuery = "DROP TABLE biglietto IF EXISTS";
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	
	private BigliettoDAO() {
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
	
	public static BigliettoDAO getIstanza() {
		if (istanza == null)
			istanza = new BigliettoDAO();
		return istanza;
	}
	
	
	/*
	 * CRUD - Create
	 * La Insert viene invocata dal costruttore di Biglietto, collegata alla creazione dell'oggetto
	 * Questa particolare insert mi deve ritornare l'id da associare all'oggetto appena creato
	 */
	public Integer insertAndReturnId(Integer idPrenotazione, Integer idViaggiatore){
		ResultSet rs;
		try {
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(findByValueQuery);
			ps.setInt(1, idPrenotazione);
			ps.setInt(2, idViaggiatore);
			System.out.println(ps.toString());
			
			rs = ps.executeQuery();
			if(rs.next()) { // elemento gia'  presente, ritorno direttamente l'ID. 
				Integer a = rs.getInt(1);
				closeResource();
				return a;
			} else { // elemento non presente: inserisco, inizialmente, solo il valore associato
				ps = conn.prepareStatement(insertByValueQuery);
				ps.setInt(1, idPrenotazione);
				ps.setInt(2, idViaggiatore);
				ps.executeUpdate();
				
				// ora che l'elemento e' inserito, richiedo l'ID associato e lo ritorno.
				ps = conn.prepareStatement(findByValueQuery);
				ps.setInt(1, idPrenotazione);
				ps.setInt(2, idViaggiatore);
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
	
	
	/*
	 * CRUD - Read
	 * La Read invocata nella PrenotazioneDAO - devo riprendere tutti i biglietti per ogni prenotazione
	 * 
	 */

	
	public ArrayList<Biglietto> getListaBiglietti(Integer idPrenotazione){
		ArrayList<Biglietto> listaBiglietti = new ArrayList<Biglietto>();
		try {
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(findByIdQuery);
			ps.setInt(1, idPrenotazione);
			rs = ps.executeQuery();
			while (rs.next()) {
				Integer idBiglietto = rs.getInt(1);
				
				//interrogo il viaggiatore Dao per riprendere il viaggiatore

				ViaggiatoreDAO dao = ViaggiatoreDAO.getIstanza();
				Viaggiatore viaggiatore = dao.read(rs.getInt(3));
				
				
				Biglietto biglietto = new Biglietto(idBiglietto, idPrenotazione, viaggiatore);
				listaBiglietti.add(biglietto);
			}

			closeResource();
			return listaBiglietti;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeResource();
		}

	}
	
	
	/*
	 * CRUD - Delete
	 * Da invocare nella delete del DaoPrenotazione, per eliminare tutta la prenotazione
	 * Invocato anche in Prenotazione, quando si vuole modificare editando la lista biglietti
	 */
	public void delete(Prenotazione prenotazione){
		try {

			conn = Persistenza.getConnection();
			
			//prima di togliere una prenotazione, devo eliminare tutti i suoi biglietti

			ps = conn.prepareStatement(deletePrenotazioneQuery);

			ps.setInt(1, prenotazione.getIdPrenotazione());

			ps.executeUpdate();

		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource();
		}
	}

}
