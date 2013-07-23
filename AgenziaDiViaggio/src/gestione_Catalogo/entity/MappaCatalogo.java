package gestione_Catalogo.entity;

import gestione_Catalogo.exception.IDEsternoElementoException;

import java.util.TreeMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;



/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class MappaCatalogo extends TreeMap<String,ElementoCatalogo> {
	
	private ReentrantLock lucchetto = new ReentrantLock();
	private Condition codaCondizione = lucchetto.newCondition();
	

	private static final long serialVersionUID = 1L;

	public MappaCatalogo(){
		super();
	}
	
	
	public void aggiungiElemento(String k, ElementoCatalogo e){
		try {
			lucchetto.lock();
			if(!containsKey(k)){
				super.put(k, e);
				codaCondizione.signalAll();
			}
				
		} finally {
			lucchetto.unlock();
		}
		
	}
	
	
	public void rimuoviElemento(String k) throws IDEsternoElementoException{
		if(!containsKey(k)){
			throw new IDEsternoElementoException("Errore in rimozione. Elemento \""+k+"\" non presente.");
		}
		super.remove(k);
		
	}
	
	
	public ElementoCatalogo getElemento(String k) throws IDEsternoElementoException{
		try {
			lucchetto.lock();
			if (!containsKey(k)){
				throw new IDEsternoElementoException("Elemento \""+k+"\" non presente.");
			}
			
		} finally {
			lucchetto.unlock();
		}
		
		return super.get(k);
		
	}
	
	
	
	
	public boolean esistenzaElemento(String k){    //se in parametro gli passo una stringa
		return super.containsKey(k);
	}
	
	public boolean esistenzaElemento(ElementoCatalogo e){  // se in parametro gli passo un elemento
		return super.containsKey(e.getIDEsternoElemento());
	}
	
	/*
	 * 
	 * Metodi per Thread
	 * 
	 */
	public ElementoCatalogo getElementoThread(String k) throws IDEsternoElementoException, InterruptedException{
		try {
			lucchetto.lock();
			while(!containsKey(k)){
				System.out.println("Ho cercato di prendere l'elemento " + k + " ma non � in mappa per cui mi sono bloccato");
				codaCondizione.await();
			}
			
		} finally {
			lucchetto.unlock();
		}
		
		return super.get(k);
		
	}
	
}
