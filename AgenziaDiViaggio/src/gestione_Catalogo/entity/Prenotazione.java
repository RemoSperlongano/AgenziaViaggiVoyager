package gestione_Catalogo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class Prenotazione {
	
	private Integer idPrenotazione;
	private Integer idOfferta;
	private String  nomeAcquirente;
	private Data dataInserimento;
	private ArrayList<Biglietto> listaBiglietti;
	
	public Prenotazione(Integer idOfferta, ArrayList<String> listaNomi, ArrayList<String> listaCognomi, ArrayList<String> listaEmail ){
		this.idOfferta = idOfferta;
		this.nomeAcquirente = listaNomi.get(0) + " " + listaCognomi.get(0);	//l'acquirente è il titolare del primo biglietto.
	    this.dataInserimento = new Data();
	    listaBiglietti = new ArrayList<Biglietto>();
	    
		//QUI ANDREBBE IL DAO PRENOTAZIONE, DEVO SALVARE LA PRENOTAZIONE IN DB E PRENDERE IL SUO ID...
		
		while (!listaNomi.isEmpty()){
			//creo un nuovo biglietto
			Biglietto b = new Biglietto(idPrenotazione, listaNomi.get(0), listaCognomi.get(0), listaEmail.get(0));
			listaBiglietti.add(b);
			
			//elimino gli elementi in listaNomi, listaCognomi, listaMail
			listaNomi.remove(0);
			listaCognomi.remove(0);
			listaEmail.remove(0);
		}
	}
	
	
	public Integer getIdPrenotazione(){
		return idPrenotazione;
	}
	
	public Integer getIdOfferta(){
		return idOfferta;
	}
	
	public String getnomeAcquirente(){
		return nomeAcquirente;
	}
	
	public Data getDataInserimento(){
		return dataInserimento;
	}
	
	public ArrayList<Biglietto> getListaBiglietti(){
		return listaBiglietti;
	}

}
