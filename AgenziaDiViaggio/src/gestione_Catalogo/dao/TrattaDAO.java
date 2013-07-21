package gestione_Catalogo.dao;

import gestione_Catalogo.entity.Ambiente;
import gestione_Catalogo.entity.Citta;
import gestione_Catalogo.entity.Data;
import gestione_Catalogo.entity.IDEsternoElemento;
import gestione_Catalogo.entity.Info;
import gestione_Catalogo.entity.Mezzo;
import gestione_Catalogo.entity.Tratta;
import gestione_Catalogo.entity.Via;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class TrattaDAO extends DAO {
	private static TrattaDAO istanza = null;
	
	private static final String createQuery = 
		"CREATE TABLE IF NOT EXISTS catalogo(" +
				"ID INTEGER PRIMARY KEY, " +
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
	
	private static final String insertByValueQuery = 
			"INSERT INTO catalogo(ambiente,mezzo,categoria,cittapartenza,cittaarrivo,via,info,data) " +
			"VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String findByValueQuery =
			"SELECT * FROM catalogo " + 
			"WHERE AMBIENTE=? AND MEZZO=? AND CATEGORIA=? AND CITTAPARTENZA=? AND CITTAARRIVO=? AND VIA=? LIMIT 1";

	private static final String insertQuery = 
			"INSERT INTO catalogo " +
			"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String updateQuery = 
			"UPDATE catalogo SET " +
			"ID=?, ambiente=?, mezzo=?, categoria=?, cittapartenza=?, cittarrivo=?, via=?, info=?, data=? " +
			"WHERE ID=?";
	private static final String deleteQuery = 
			"DELETE FROM " +
			"catalogo WHERE ID=?";
	private static final String findQuery = 
			"SELECT * FROM catalogo " +
			"WHERE ID=?";  
	
	private static final String getCatalogoQuery = "SELECT * FROM catalogo";

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;


	/**
	 * La tratta non si occupa della gestione della tabella del Catalogo. Queste
	 * operazioni sono effettuate dal catalogo all'inizializzazione. La tratta
	 * si occupa di creare e inserire la tupla nel catalogo, chiamando gli altri
	 * DAO per l'inserimento nelle rispettive tabelle.
	 */
	private TrattaDAO() {
		try {
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(createQuery);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeResource();
		}
	}

	public static TrattaDAO getIstanza() {
		if (istanza == null)
			istanza = new TrattaDAO();
		return istanza;
	}

	
	/*
	 * CRUD - Create
	 * La Insert viene invocata dal costruttore di Tratta, collegata alla creazione dell'oggetto
	 */
	
//	public synchronized void insert(Tratta tratta) {
//		// TODO Auto-generated method stub
//		try {
//
//			conn = Persistenza.getConnection();
//
//			ps = conn.prepareStatement(insertQuery);
//
//			System.out.println("Inserimento della tratta nel db.");
//
//			ps.setInt(1, tratta.getID());
//			ps.setInt(2, tratta.getAmbiente().getID());
//			ps.setInt(3, tratta.getMezzo().getID());
//			ps.setString(4, tratta.getCategoria());
//			ps.setInt(5, tratta.getPartenza().getID());
//			ps.setInt(6, tratta.getArrivo().getID());
//			ps.setInt(7, tratta.getVia().getID());
//			ps.setString(8, tratta.getInfo());
//			ps.setTimestamp(9, tratta.getDataInserimento().getDataForDB());
//			System.out.println(ps.toString());
//			ps.executeUpdate();
//
//		} catch (ClassCastException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			closeResource();
//		}
//
//	}
	
	
	public synchronized Integer insertAndReturnId(Ambiente ambiente, Mezzo mezzo, String categoria, Citta partenza, Citta arrivo, Via via, Info info, Data data) {
		ResultSet rs;
		try {
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(findByValueQuery);
			ps.setInt(1, ambiente.getID());
			ps.setInt(2, mezzo.getID());
			ps.setString(3, categoria);
			ps.setInt(4, partenza.getID());
			ps.setInt(5, arrivo.getID());
			ps.setInt(6, via.getID());
			
			System.out.println(ps.toString());
			
			rs = ps.executeQuery();
			if(rs.next()) { // elemento gia'  presente, ritorno direttamente l'ID. 
				Integer a = rs.getInt(1);
				closeResource();
				return a;
			} else { // elemento non presente: inserisco, inizialmente, solo il valore associato
				ps = conn.prepareStatement(insertByValueQuery);
				ps.setInt(1, ambiente.getID());
				ps.setInt(2, mezzo.getID());
				ps.setString(3, categoria);
				ps.setInt(4, partenza.getID());
				ps.setInt(5, arrivo.getID());
				ps.setInt(6, via.getID());
				ps.setString(7, info.toString());
				ps.setTimestamp(8, data.getDataForDB());
				ps.executeUpdate();
				
				// ora che l'elemento e' inserito, richiedo l'ID associato e lo ritorno.
				ps = conn.prepareStatement(findByValueQuery);
				ps.setInt(1, ambiente.getID());
				ps.setInt(2, mezzo.getID());
				ps.setString(3, categoria);
				ps.setInt(4, partenza.getID());
				ps.setInt(5, arrivo.getID());
				ps.setInt(6, via.getID());
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
	 * La Read invocata nel TrattaDAO , legge una riga dal DB
	 */
	public Tratta read(Integer id){
		;
		String valore;
		try {
			conn = Persistenza.getConnection();

			ps = conn.prepareStatement(findQuery);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			rs.next();
			
			valore = readValue("AMBIENTE", rs.getInt(2));
			Class<?> c = Class.forName("gestione_Catalogo.entity."+valore);   // per classi in un package, va messo il nome del package!!!"
			
			//preparo i parametri
			Class<?> primoParametro  = Integer.class;
			Class<?> secondoParametro	 = Class.forName("gestione_Catalogo.entity.IDEsternoElemento");
			
			Class<?>[] parametri = {primoParametro, secondoParametro};
			
			//prendo il costruttore della classe con i parametri indicati
			Constructor<?> costruttore = c.getConstructor(parametri);
			
			//creo l'oggetto
			Ambiente ambiente = (Ambiente) costruttore.newInstance(id, valore);
			
			

			valore = readValue("MEZZO", rs.getInt(3));
			Mezzo mezzo = new Mezzo(rs.getInt(3), new IDEsternoElemento(valore));
			
			String categoria = rs.getString(4);

			valore = readValue("CITTA", rs.getInt(5));
			Citta cittaPartenza = new Citta(rs.getInt(5), new IDEsternoElemento(valore));

			valore = readValue("CITTA", rs.getInt(6));
			Citta cittaArrivo = new Citta(rs.getInt(6), new IDEsternoElemento(valore));

			valore = readValue("VIA", rs.getInt(7));
			Via via = new Via(rs.getInt(7), new IDEsternoElemento(valore));
			
			Info info = new Info(rs.getString(8));
			
			Data data = new Data(rs.getTimestamp(9));
		
			closeResource();
			return new Tratta(id, ambiente, mezzo, categoria, cittaPartenza, cittaArrivo, via, info, data );

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			closeResource();
		}

		
	}
	
	/*
	 * CRUD - Update
	 * DA IMPLEMENTARE
	 */
	
	public void update(Object obj){
		System.out.println("Ancora da implementare!!!");

	}

	/*
	 * CRUD - Delete
	 * DA RIVEDERE
	 */
	
	public void delete(Tratta tratta){
		
		try {
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(deleteQuery);
			System.out.println("Cancellazione della tratta nel db.");
			
			ps.setInt(1, tratta.getID());
			ps.executeUpdate();
			
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource();
		}

	}

	
	//chiamato prima dell'insert di questo DAO: per trovare gli ID degli oggetti nelle altre tabelle
	public String readValue(String table, Integer id){

		String query = "SELECT * FROM " + table + " " + "WHERE id=?";
		ResultSet rs = null;
		try {
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(query);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			rs.next();
			String a = rs.getString(2);
			closeResource();
			return a;

		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			closeResource();
		}

	}
	
	public synchronized Integer getNextId(){
		try {
			// Situazione 1. Tabella Vuota. Id da ritornare 1.
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(getCatalogoQuery);
			rs = ps.executeQuery();
			if (!rs.next()){
				System.out.println("ID RITORNATO : 1");
				return 1;
			}
			// Situazione 2. Almeno un Elemento presente.
			rs.last();
			
			Integer a = (rs.getInt(1)) + 1;
			closeResource();
			System.out.println("ID RITORNATO : 1");
			return a;
		} catch (ClassCastException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			closeResource();
		}
	}
	
}
