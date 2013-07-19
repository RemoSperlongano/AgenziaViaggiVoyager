/**
 * 
 */
package gestione_Catalogo.entity;

import gestione_Catalogo.dao.UtenteDAO;
import gestione_Catalogo.exception.UtenteEsistenteException;
import gestione_Catalogo.exception.UtenteInesistenteException;

import java.util.ArrayList;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class Utenza {
	
	private static Utenza istanza;

	private ArrayList<Utente> listaUtenti;
	
	private Utenza(){
		
		listaUtenti = new ArrayList<Utente>();
		
		UtenteDAO dao = UtenteDAO.getIstanza();
		listaUtenti = dao.getUtenza();
	}
	

	public static Utenza getIstanza(){
		if (istanza == null){
			istanza = new Utenza();
		}
		return istanza;
	}
	
	
	public ArrayList<Utente> getListaUtenti(){
		return listaUtenti;
	}
	
	public void aggiungiUtente(Utente nuovoUtente) throws UtenteEsistenteException{
		listaUtenti.add(nuovoUtente);
		nuovoUtente.registraUtente();
	}
	
	public void rimuoviUtente(Utente utente){
		listaUtenti.remove(utente);
		utente.eliminaUtente();
	}
	
	public Utente getUtenteByUsername(String username) throws UtenteInesistenteException{
		for (Utente utente : listaUtenti){
			if (utente.getUsername().equals(username)){
				return utente;
			}
		}
		throw new UtenteInesistenteException("Utente non esistente.");
	}
	
	
}
