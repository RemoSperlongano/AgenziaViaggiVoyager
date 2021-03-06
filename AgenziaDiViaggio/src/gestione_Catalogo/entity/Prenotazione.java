package gestione_Catalogo.entity;

import gestione_Catalogo.dao.BigliettoDAO;
import gestione_Catalogo.dao.PrenotazioneDAO;

import java.util.ArrayList;

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
		this.nomeAcquirente = listaNomi.get(0) + " " + listaCognomi.get(0);	//l'acquirente � il titolare del primo biglietto.
	    this.dataInserimento = new Data();
	    listaBiglietti = new ArrayList<Biglietto>();
	    
		PrenotazioneDAO dao = PrenotazioneDAO.getIstanza();
		this.idPrenotazione = dao.insertAndReturnId(idOfferta, nomeAcquirente, dataInserimento);
		
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
	
	public Prenotazione(Integer idPrenotazione, Integer idOfferta, String nomeAcquirente, Data dataInserimento, ArrayList<Biglietto> listaBiglietti){
		this.idPrenotazione = idPrenotazione;
		this.idOfferta = idOfferta;
		this.nomeAcquirente = nomeAcquirente;
		this.dataInserimento = dataInserimento;
		this.listaBiglietti = listaBiglietti;
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
	
	public void clearListaBiglietti(){
		listaBiglietti.clear();
		BigliettoDAO dao = BigliettoDAO.getIstanza();
		dao.delete(this);
	}
	
	public void setListaBiglietti(ArrayList<Biglietto> listaBiglietti){
		this.listaBiglietti = listaBiglietti;
	}
	
}
