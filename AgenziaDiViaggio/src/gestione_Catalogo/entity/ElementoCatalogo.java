package gestione_Catalogo.entity;

import java.util.Set;

import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.OffertaInesistenteException;


/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public abstract class ElementoCatalogo {
	
	//attributi di istanza
	private Integer ID;
	private IDEsternoElemento idEsternoElemento;

	
	//costruttori
	public ElementoCatalogo (IDEsternoElemento idEsternoElemento){
		this.idEsternoElemento = idEsternoElemento;		
		//this.setID(0);
	}
	
	public ElementoCatalogo(Integer ID, IDEsternoElemento idEsternoElemento){
		this.ID= ID;
		this.idEsternoElemento = idEsternoElemento;
	}
	
	
	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		this.ID = iD;
	}

	public String getIDEsternoElemento() {
		return idEsternoElemento.toString();
	}
	
	
	public void print() {
		System.out.println(this.getClass().getSimpleName() + " " + this.getID().toString() + " " +  this.getIDEsternoElemento().toString());
		
	}
	


	public void aggiungiElemento(String key, ElementoCatalogo value) throws DirittiException{
		throw new DirittiException("Errore: aggiungiElemento in ElementoCatalogo. Operazione non ammessa.");
	}
	
	public void rimuoviElemento(String key) throws IDEsternoElementoException, DirittiException {
		throw new DirittiException("Errore: rimuoviElemento in ElementoCatalogo. Operazione non ammessa.");
	}
	
	public ElementoCatalogo getElemento(String k) throws IDEsternoElementoException, DirittiException{
		throw new DirittiException("Errore: getElemento in ElementoCatalogo. Operazione non ammessa.");
	}
		
	public Set<String> listaChiaviElementi() throws DirittiException{
		throw new DirittiException("Errore: listaChiaviElementi in ElementoCatalogo. Operazione non ammessa.");
	}
	
	public boolean esistenzaElemento(String k) throws DirittiException{
		throw new DirittiException("Errore: esistenzaElemento in ElementoCatalogo. Operazione non ammessa.");
	}
	
	
	public void aggiungiOfferta(Data key, Offerta value) throws DirittiException{
		throw new DirittiException("Errore: aggiungiOfferta in ElementoCatalogo. Operazione non ammessa.");
	}
		
	public void rimuoviOfferta(Data key) throws OffertaInesistenteException, DirittiException{
		throw new DirittiException("Errore: rimuoviOfferta in ElementoCatalogo. Operazione non ammessa.");
	}
	
	public Offerta getOfferta(Data k) throws OffertaInesistenteException, DirittiException{
		throw new DirittiException("Errore: getOfferta in ElementoCatalogo. Operazione non ammessa.");
	}

	public Set<Data> listaChiaviOfferte() throws DirittiException{
		throw new DirittiException("Errore: listaChiaviOfferte in ElementoCatalogo. Operazione non ammessa.");
	}
	
	public boolean esistenzaOfferta(Data k) throws DirittiException{
		throw new DirittiException("Errore: esistenzaOfferta in ElementoCatalogo. Operazione non ammessa.");
	}
	
	public boolean mapIsEmpty() throws DirittiException{
		throw new DirittiException("Errore: mapIsEmpty in ElementoCatalogo. Operazione non ammessa.");
	}
	
}	