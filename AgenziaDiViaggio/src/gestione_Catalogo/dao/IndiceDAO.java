/**
 * 
 */
package gestione_Catalogo.dao;

import gestione_Catalogo.entity.Mezzo;
import gestione_Catalogo.entity.Tratta;
import gestione_Catalogo.exception.CalcoloIndiceException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class IndiceDAO extends DAO{
	
	private static IndiceDAO istanza = null;
	
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	
	private IndiceDAO() {
		
	}
	
	
	public static IndiceDAO getIstanza() {
		if (istanza == null)
			istanza = new IndiceDAO();
		return istanza;
	}
	
	
	/*
	 * 
	 * Metodi per calcolare gli indici
	 */
	
	
	public Double calcolaGradimentoTrattaSuMezzo (Tratta tratta , Tratta trattaInversa, String metodoScelto){
		
	
		try {
			
			ResultSet rs;
			String selectQuery;
			Double numeratore = null ;
			Double denominatore = null;
			
			conn = Persistenza.getConnection();
			
			if (metodoScelto.equals("Totale")){
				
				// CALCOLO NUMERATORE
				
				// tutti i biglietti venduti per una tratta
				selectQuery = 
						"SELECT COUNT(*) FROM offerta AS o, prenotazione AS p, biglietto AS b " + 
						"WHERE o.idtratta=? " +
						"AND p.idofferta = o.ID "  +
						"AND b.idprenotazione = p.ID";
				
				
				ps = conn.prepareStatement(selectQuery);
				ps.setInt(1, tratta.getID());   //per calcolo di indici su tutta la tratta mi basta il semplice id della tratta
				
				rs = ps.executeQuery();
				
				if (rs.next()){
					numeratore = rs.getDouble(1);
				}
				
				
				//se esiste una tratta inversa, calcolo di tutti i biglietti venduti per la tratta inversa
				if (trattaInversa != null ){
					
					ps = conn.prepareStatement(selectQuery);
					ps.setInt(1, trattaInversa.getID());   //per calcolo di indici su tutta la tratta mi basta il semplice id della tratta
					
					rs = ps.executeQuery();
					
					if (rs.next()){
						numeratore += rs.getDouble(1);
					}
					
				}
				
				
				// CALCOLO DENOMINATORE
				
				Mezzo m = tratta.getMezzo();
				
				selectQuery = 
						"SELECT COUNT(*) FROM catalogo AS c, offerta AS o, prenotazione AS p, biglietto AS b " + 
						"WHERE c.mezzo=? " +
						"AND o.idtratta = c.ID " +
						"AND p.idofferta = o.ID "  +
						"AND b.idprenotazione = p.ID";
				
				
				ps = conn.prepareStatement(selectQuery);
				ps.setInt(1,  m.getID());    //per il calcolo di indici su mezzo mi serve l'id del mezzo
				
				rs = ps.executeQuery();
				
				if (rs.next()){
					denominatore = rs.getDouble(1);
				}
				
				
				
			}
			
			if (metodoScelto.equals("Annuale")){
				
				
			}
			
			if (metodoScelto.equals("UltimaOfferta")){
				
				
			}
			
			System.out.println(numeratore + " / " + denominatore + " = " + numeratore/denominatore);
			return (numeratore/denominatore) * 100;
			
			
		} catch (ClassCastException e) {
			e.printStackTrace();
			closeResource();
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			closeResource();
			return null;
		}finally{
			closeResource();
		}
			
		
	
		
	}
	
	public Double calcolaGradimentoMezzoSuTipoMezzo(Tratta tratta) throws CalcoloIndiceException{
		

		
		
		try {
			
			Mezzo m = tratta.getMezzo();
			String categoria = tratta.getCategoria();
			
				
			ResultSet rs;
			String selectQuery;
			Double numeratore = null ;
			Double denominatore = null;
				
			// CALCOLO NUMERATORE
				
			conn = Persistenza.getConnection();
			// tutti i biglietti venduti per una tratta
			selectQuery = 
					"SELECT COUNT(*) FROM catalogo AS c, offerta AS o, prenotazione AS p, biglietto AS b " + 
					"WHERE c.mezzo=? " +
					"AND o.idtratta = c.ID " +
					"AND p.idofferta = o.ID "  +
					"AND b.idprenotazione = p.ID";
				
				
			ps = conn.prepareStatement(selectQuery);
			ps.setInt(1, m.getID());   //per calcolo di indici su tutta la tratta mi basta il semplice id della tratta
				
			rs = ps.executeQuery();
				
			if (rs.next()){
				numeratore = rs.getDouble(1);
			}
				
				
			// CALCOLO DENOMINATORE
				
				
			selectQuery = 
					"SELECT COUNT(*) FROM catalogo AS c, offerta AS o, prenotazione AS p, biglietto AS b " + 
					"WHERE c.categoria=? " +
					"AND o.idtratta = c.ID " +
					"AND p.idofferta = o.ID "  +
					"AND b.idprenotazione = p.ID";
				
				
			ps = conn.prepareStatement(selectQuery);
			ps.setString(1,  tratta.getCategoria());    //per il calcolo di indici su mezzo mi serve l'id del mezzo
				
			rs = ps.executeQuery();
				
			if (rs.next()){
				denominatore = rs.getDouble(1);
			}
				
			System.out.println(numeratore + " / " + denominatore + " = " + numeratore/denominatore);
			return (numeratore/denominatore) * 100;
				
			
			
			
			
			
			
			
		} catch (ClassCastException e) {
			e.printStackTrace();
			closeResource();
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			closeResource();
			return null;
		}finally{
			closeResource();
		}
			
		
	
		
	
		
	}
	
	
	public Integer prova(){
		Integer risultato = null;
		
		
		
		 
//		//tutti i biglietti venduti per una prenotazione
//		String selectQuery = 
//				"SELECT COUNT(*) FROM biglietto " + 
//				"WHERE idprenotazione=?";
		 
		
		
		
		// tutti i biglietti venduti per una tratta
		String selectQuery = 
				"SELECT COUNT(*) FROM offerta AS o, prenotazione AS p, biglietto AS b " + 
				"WHERE o.idtratta=? " +
				"AND p.idofferta = o.ID "  +
				"AND b.idprenotazione = p.ID";
		
		
		ResultSet rs;
		try {
			
			conn = Persistenza.getConnection();
			ps = conn.prepareStatement(selectQuery);
			ps.setInt(1, 13);
			
			rs = ps.executeQuery();
			
			if (rs.next()){
				risultato = rs.getInt(1);
			}
			
			return risultato;
			
			
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
