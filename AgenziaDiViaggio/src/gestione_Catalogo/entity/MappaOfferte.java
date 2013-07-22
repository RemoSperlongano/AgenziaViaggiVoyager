package gestione_Catalogo.entity;

import gestione_Catalogo.exception.OffertaInesistenteException;

import java.util.TreeMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class MappaOfferte extends TreeMap<Data,Offerta>{
	
	
	private ReentrantLock lucchetto = new ReentrantLock();
	private Condition codaCondizione = lucchetto.newCondition();

	private static final long serialVersionUID = 1L;

	public MappaOfferte(MappaOfferteComparator moc){
		super(moc);
	}

	public void aggiungiOfferta(Data k, Offerta o){
		try{
			lucchetto.lock();
			if(!containsKey(k)){
				super.put(k, o);
				System.out.println("Ho aggiunto l'offerta " + k.stampaData() + "ora libero tutti gli altri Thread! ");
				codaCondizione.signalAll();
			}
		} finally {
			lucchetto.unlock();
		}
		
	}
	
	public void rimuoviOfferta(Data k) throws OffertaInesistenteException{
		if(!containsKey(k)){
			throw new OffertaInesistenteException("Errore in rimozione. Offerta \""+k+"\" non presente.");
		}
		super.remove(k);
	}

	public Offerta getOfferta(Data k) throws OffertaInesistenteException {
		try {
			lucchetto.lock();
			if (!containsKey(k)){
				throw new OffertaInesistenteException("Offerta \""+k+"\" non presente.");
			}
		} finally{
			lucchetto.unlock();
		}
		
		return super.get(k);
	}
	
	
	/*
	 * 
	 * Metodi per i Thread
	 * 
	 */
	
	public Offerta getOffertaThread(Data k) throws OffertaInesistenteException, InterruptedException {
		try {
			lucchetto.lock();
			while (!containsKey(k)){
				System.out.println("Ho provato a prendere l'offerta " + k.stampaData() + " ma non è in mappa per cui mi sono bloccato.");
				codaCondizione.await();
			}
		} finally{
			lucchetto.unlock();
		}
		
		return super.get(k);
	}
	
	
}
