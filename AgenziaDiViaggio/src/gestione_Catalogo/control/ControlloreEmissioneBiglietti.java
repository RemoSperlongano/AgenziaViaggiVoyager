/**
 * 
 */
package gestione_Catalogo.control;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class ControlloreEmissioneBiglietti extends Controllore {
	
	public ControlloreEmissioneBiglietti(){
		super();
	}

	public void erogaBiglietti(String ambiente, String mezzo, String partenza, String arrivo, String via, String offerta, String prenotazione) {
		
		log.aggiornaLogEmissioneBiglietti(ambiente,mezzo,partenza,arrivo,via,offerta,prenotazione);
		
	}

}
