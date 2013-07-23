package gestione_Catalogo.bean;

import gestione_Catalogo.control.ControlloreGestioneCatalogo;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.OffertaException;
import gestione_Catalogo.exception.TrattaInesistenteException;

/**
 * @authors
 * Francesco Tomei
 * Remo Sperlongano
 * Ivan Torre
 */
public class RimuoviTrattaBean {
	private String ambiente;
	private String mezzo;
	private String tipoMezzo;
	private String partenza;
	private String arrivo;
	private String via;
	private String info;
	
	public RimuoviTrattaBean(){
	}

	public boolean validate() {
		System.out.println("sono nel validate");
		if (this.getAmbiente() != null &&
			this.getMezzo() != null &&
			this.getPartenza() != null &&
			this.getArrivo() != null)
		{
			System.out.println("sono nell'if");
			if (this.getTipoMezzo() == null) { setTipoMezzo(""); System.out.println("ho resettato il tipomezzo");};
			if (this.getVia() == null) { setVia(""); System.out.println("ho resettato la Via"); };
			ControlloreGestioneCatalogo controllore = new ControlloreGestioneCatalogo();
			try {
				System.out.println("Il controllore sta per rimuovere il viaggio...");
				controllore.rimuoviViaggio(ambiente, mezzo+ " " + tipoMezzo, partenza, arrivo, via);
			} catch (SecurityException | IllegalArgumentException
					| IDEsternoElementoException | DirittiException | OffertaException e) {
				e.printStackTrace();
				
			}
			catch (TrattaInesistenteException e) {
				System.err.println("Tratta inesistente");
				return false;
			}
			
		} else { return false; }
		return true;
	} 
	
	/**
	 * @return the ambiente
	 */
	public String getAmbiente() {
		return ambiente;
	}


	/**
	 * @param ambiente the ambiente to set
	 */
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}


	/**
	 * @return the mezzo
	 */
	public String getMezzo() {
		return mezzo;
	}


	/**
	 * @param mezzo the mezzo to set
	 */
	public void setMezzo(String mezzo) {
		this.mezzo = mezzo;
	}


	/**
	 * @return the tipoMezzo
	 */
	public String getTipoMezzo() {
		return tipoMezzo;
	}


	/**
	 * @param tipoMezzo the tipoMezzo to set
	 */
	public void setTipoMezzo(String tipoMezzo) {
		this.tipoMezzo = tipoMezzo;
	}


	/**
	 * @return the partenza
	 */
	public String getPartenza() {
		return partenza;
	}


	/**
	 * @param partenza the partenza to set
	 */
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}


	/**
	 * @return the arrivo
	 */
	public String getArrivo() {
		return arrivo;
	}


	/**
	 * @param arrivo the arrivo to set
	 */
	public void setArrivo(String arrivo) {
		this.arrivo = arrivo;
	}


	/**
	 * @return the via
	 */
	public String getVia() {
		return via;
	}


	/**
	 * @param via the via to set
	 */
	public void setVia(String via) {
		this.via = via;
	}


	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}


	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}


}
