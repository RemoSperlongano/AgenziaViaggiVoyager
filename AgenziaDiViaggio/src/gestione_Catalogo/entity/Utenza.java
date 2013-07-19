/**
 * 
 */
package gestione_Catalogo.entity;

import gestione_Catalogo.dao.UtenteDAO;

import java.util.ArrayList;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class Utenza {

	private ArrayList<Utente> listaUtenti;
	
	private Utenza(){
		
		listaUtenti = new ArrayList<Utente>();
		
		UtenteDAO dao = UtenteDAO.getIstanza();
		/*
		 * da continuare.
		 */
	}
}
