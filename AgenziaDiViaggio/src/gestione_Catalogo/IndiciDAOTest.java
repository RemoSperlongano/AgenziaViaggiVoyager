/**
 * 
 */
package gestione_Catalogo;

import java.util.ArrayList;

import gestione_Catalogo.dao.CatalogoDAO;
import gestione_Catalogo.dao.IndiceDAO;
import gestione_Catalogo.entity.Tratta;
import gestione_Catalogo.exception.CalcoloIndiceException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class IndiciDAOTest {
	
	public static void main(String[] args) {
		
		IndiceDAO dao = IndiceDAO.getIstanza();
		CatalogoDAO daocatalogo = CatalogoDAO.getIstanza();
		
		ArrayList<Tratta> listatratte = daocatalogo.getCatalogo();
		
		Tratta t = listatratte.get(15);
		
		
		try {
			System.out.println(dao.calcolaIndiceMezzoSuTipoMezzo(t));
		} catch (CalcoloIndiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
