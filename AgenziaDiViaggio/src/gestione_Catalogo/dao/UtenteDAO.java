/**
 * 
 */
package gestione_Catalogo.dao;


import gestione_Catalogo.entity.Sessione;
import gestione_Catalogo.entity.Utente;
import gestione_Catalogo.exception.UtenteEsistenteException;

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
public class UtenteDAO extends DAO{
	
	private static UtenteDAO istanza = null;
	
	private static final String getListaUtentiQuery = "SELECT * FROM utente WHERE 1";

	private static final String createQuery = 
			"CREATE TABLE IF NOT EXISTS utente(" +
					"ID INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
					"nome VARCHAR(30), " +
					"cognome VARCHAR(30), " +
					"mail VARCHAR(30), " +
					"username VARCHAR(30), " +
					"password VARCHAR(30), " +
					"ruolo VARCHAR(30) " +
					")";

	
	private static final String insertByValueQuery = 
		"INSERT INTO utente(nome,cognome,mail,username,password,ruolo) " +
		"VALUES(?, ?, ?, ?, ?, ?)";
	
	
	private static final String cambiaPasswordQuery = 
			"UPDATE utente SET " +
			"password=? " +
			"WHERE username=? LIMIT 1";
	
	
	private static final String cambiaPasswordAmministratoreQuery = 
			"UPDATE utente SET " +
			"username=?, password=? " +
			"WHERE username=? LIMIT 1";
	
	private static final String cambiaMailQuery = 
			"UPDATE utente SET " +
			"mail=? " +
			"WHERE username=? LIMIT 1";
	
	private static final String deleteQuery = 
			"DELETE FROM utente " +
			"WHERE username=? LIMIT 1";
	
	private static final String findUtenteQuery = 
			"SELECT * FROM utente " +
			"WHERE username=? LIMIT 1";

	private static final String findLoginQuery =
			"SELECT * FROM utente " + 
			"WHERE username=? AND password=? LIMIT 1";

	
	

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	
	private UtenteDAO(){
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
	
	public static UtenteDAO getIstanza(){
		if (istanza == null){
			istanza = new UtenteDAO();
		}
		return istanza;
	}
	
	
	/*
	 * CRUD - Create
	 * La insert viene invocata dal metodo "registra utente in db" della classe Utente
	 */
	
	public void insert(String nome, String cognome, String mail, String username, String password, String ruolo) throws UtenteEsistenteException {
		ResultSet rs;
			
				try {
					conn = Persistenza.getConnection();
					//verifico se esiste gi� un utente con questo nome
					ps = conn.prepareStatement(findUtenteQuery);
					ps.setString(1, username);
					
					rs = ps.executeQuery();
					
					if(rs.next()){
						throw new UtenteEsistenteException("Esiste gi� un utente con questo username");
					} else{
						//se non esiste lo aggiungo
						ps = conn.prepareStatement(insertByValueQuery);
						ps.setString(1, nome);
						ps.setString(2, cognome);
						ps.setString(3, mail);
						ps.setString(4, username);
						ps.setString(5, password);
						ps.setString(6, ruolo);
						ps.executeUpdate();
					}
					
					
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
	}
	
	/*
	 * CRUD - Read
	 * Invocata nel metodo LOGIN di Utente
	 * 
	 */
	
	public Sessione login(String username, String password){
		Sessione sessione = null;
		try {
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(findLoginQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				String mail = rs.getString(4);
				String ruolo = rs.getString(7);
				
				sessione = new Sessione(username, ruolo, nome, cognome, mail);
				
			}

			closeResource();
			return sessione;
			
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
	 * Da invocare nei metodo cambia Password di Utente
	 */

	public void cambiaPasswordAmministratore(String username, String password){
		// TODO Auto-generated method stub
		try {
			conn = Persistenza.getConnection();

			ps = conn.prepareStatement(cambiaPasswordAmministratoreQuery);
			
			
			ps.setString(1, password);
			ps.setString(2, username);
			ps.setString(3, "admin");

			ps.executeUpdate();

		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource();
		}

	}
	
	
	public void cambiaPassword(String username, String password){
		// TODO Auto-generated method stub
		try {
			conn = Persistenza.getConnection();

			ps = conn.prepareStatement(cambiaPasswordQuery);
			
			
			ps.setString(1, password);
			ps.setString(2, username);

			ps.executeUpdate();

		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource();
		}

	}
	
	
	
	public void cambiaMail(String username, String mail){
		// TODO Auto-generated method stub
		try {
			conn = Persistenza.getConnection();

			ps = conn.prepareStatement(cambiaMailQuery);
			
			
			ps.setString(1, mail);
			ps.setString(2, username);

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
	 * Da invocare nell'eliminazione di un utente , dalla classe Utente
	 */
	public void delete(String username){
		// TODO Auto-generated method stub
		try {

			conn = Persistenza.getConnection();

			ps = conn.prepareStatement(deleteQuery);

			ps.setString(1, username);

			ps.executeUpdate();

		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeResource();
		}
	}
	
	
	public ArrayList<Utente> getUtenza(){
		ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
			try {
				conn = Persistenza.getConnection();
				ps = conn.prepareStatement(getListaUtentiQuery);
				rs = ps.executeQuery();
				
				while (rs.next()) {
					String nome = rs.getString(2);
					String cognome = rs.getString(3);
					String email = rs.getString(4);
					String username = rs.getString(5);
					String password = rs.getString(6);
					String ruolo = rs.getString(7);
					
					Utente utente = new Utente(nome, cognome, email, username, password, ruolo);
					listaUtenti.add(utente);
				}
				
				closeResource();
				return listaUtenti;
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeResource();
			}
	
		return listaUtenti;
	}

}
