package gestione_Catalogo.dao;

import gestione_Catalogo.entity.Ambiente;
import gestione_Catalogo.entity.Citta;
import gestione_Catalogo.entity.Data;
import gestione_Catalogo.entity.IDEsternoElemento;
import gestione_Catalogo.entity.Info;
import gestione_Catalogo.entity.Mezzo;
import gestione_Catalogo.entity.Offerta;
import gestione_Catalogo.entity.Tratta;
import gestione_Catalogo.entity.Via;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class OffertaDAO extends DAO {
	private static OffertaDAO istanza = null;

	private static final String getListaOfferteQuery = "SELECT * FROM offerta WHERE 1";

	private static final String createQuery = 
			"CREATE TABLE IF NOT EXISTS offerta(" +
					"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
					"idtratta INTEGER, " +
					"datapartenza DATETIME, " +
					"dataarrivo DATETIME, " +
					"posti INTEGER, " +
					"datainserimento DATETIME, " +
					"FOREIGN KEY (idtratta) REFERENCES catalogo (ID) "   +
					")";

	private static final String insertQuery = 
			"INSERT INTO offerta " +
			"VALUES(?, ?, ?, ?, ?, ?)";
	
	private static final String insertByValueQuery = 
		"INSERT INTO offerta(idtratta,datapartenza,dataarrivo,posti, datainserimento) " +
		"VALUES(?, ?, ?, ?, ?)";
	
	private static final String updateQuery = 
			"UPDATE offerta SET " +
			"idtratta=?, datapartenza=?, dataarrivo=?, posti=?, datainserimento=? " +
			"WHERE ID=? LIMIT 1";
	private static final String deleteQuery = 
			"DELETE FROM offerta " +
			"WHERE ID=? LIMIT 1";
	private static final String findQuery = 
			"SELECT * FROM offerta " +
			"WHERE ID=? LIMIT 1";

	private static final String findByValueQuery =
			"SELECT * FROM offerta " + 
			"WHERE IDTRATTA=? AND DATAPARTENZA=? LIMIT 1";

	private static final String dropQuery = "DROP TABLE OFFERTA IF EXISTS";
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	private OffertaDAO() {
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
	
	public static OffertaDAO getIstanza() {
		if (istanza == null)
			istanza = new OffertaDAO();
		return istanza;
	}


	/*
	 * CRUD - Create
	 * La Insert viene invocata dal costruttore di Offerta, collegata alla creazione dell'oggetto
	 * Questa particolare insert mi deve ritornare l'id da associare all'oggetto appena creato
	 */
	public synchronized Integer insertAndReturnId(Integer idTratta, Data dataPartenza, Data dataArrivo, Integer posti, Data dataInserimento) {
		ResultSet rs;
		try {
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(findByValueQuery);
			ps.setInt(1, idTratta);
			ps.setTimestamp(2, dataPartenza.getDataForDB());
			System.out.println(ps.toString());
			
			rs = ps.executeQuery();
			if(rs.next()) { // elemento gia'� presente, ritorno direttamente l'ID. 
				Integer a = rs.getInt(1);
				closeResource();
				return a;
			} else { // elemento non presente: inserisco, inizialmente, solo il valore associato
				ps = conn.prepareStatement(insertByValueQuery);
				ps.setInt(1,idTratta);
				ps.setTimestamp(2, dataPartenza.getDataForDB());
				ps.setTimestamp(3, dataArrivo.getDataForDB());
				//System.out.println(ps.toString());
				ps.setInt(4, posti);
				ps.setTimestamp(5, dataInserimento.getDataForDB());
				ps.executeUpdate();
				
				// ora che l'elemento e' inserito, richiedo l'ID associato e lo ritorno.
				ps = conn.prepareStatement(findByValueQuery);
				ps.setInt(1, idTratta);
				ps.setTimestamp(2, dataPartenza.getDataForDB());
				rs = ps.executeQuery();
				
				if(rs.next()) { // elemento gia'� presente, ritorno direttamente l'ID. 
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
	 * La Read invocata nel Catalogo - siamo in fase di fetch del Catalogo dal DB 
	 * 
	 */

//	public IDEsternoElemento readOnlyValue(Integer id) {
//		String s;
//		try {
//			conn = Persistenza.getConnection();
//			ps = conn.prepareStatement(findQuery);
//			ps.setInt(1, id);
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				s = rs.getString(2);
//			} else { 
//				s = null;
//			}
//			closeResource();
//			return new IDEsternoElemento(s);
//		} catch (ClassCastException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public List<Offerta> getListaOfferte(){
		List<Offerta> listaOfferte = new ArrayList<Offerta>();
		try {
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(getListaOfferteQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				Integer idOfferta = rs.getInt(1);
				Integer idTratta = rs.getInt(2);
				Data dataPartenza = new Data(rs.getTimestamp(3));
				Data dataArrivo = new Data(rs.getTimestamp(4));
				Integer posti = rs.getInt(5);
				Data dataInserimento = new Data(rs.getTimestamp(6));
				Offerta offerta = new Offerta(idOfferta, idTratta, dataPartenza, dataArrivo, posti, dataInserimento);
				listaOfferte.add(offerta);
			}

			closeResource();
			return listaOfferte;
			
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
	 * CRUD - Update
	 * Da invocare nei metodo set di Mezzo
	 */

	public void update(Offerta offerta){
		// TODO Auto-generated method stub
		try {
			conn = Persistenza.getConnection();

			ps = conn.prepareStatement(updateQuery);
			
			
			ps.setInt(1, offerta.getIdTratta());
			ps.setTimestamp(2, offerta.getData().getDataForDB());
			ps.setTimestamp(3, offerta.getDataArrivo().getDataForDB());
			ps.setInt(4, offerta.getPosti());
			ps.setTimestamp(5, offerta.getDataInserimento().getDataForDB());
			ps.setInt(6, offerta.getIdOfferta());

			

			ps.executeUpdate();

		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource();
		}

	}

	/*
	 * CRUD -  Delete
	 * Da invocare nell'eliminazione di un offerta dal Catalogo
	 */
	public void delete(Offerta offerta){
		// TODO Auto-generated method stub
		try {

			conn = Persistenza.getConnection();

			ps = conn.prepareStatement(deleteQuery);

			ps.setInt(1, offerta.getIdOfferta());

			ps.executeUpdate();

		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource();
		}
	}
	
	
	
	public void dropTable() {
		try {
			conn = Persistenza.getConnection();

			ps = conn.prepareStatement(dropQuery);

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
