package gestione_Catalogo.bean;

import java.lang.reflect.InvocationTargetException;

import gestione_Catalogo.control.ControlloreGestioneCatalogo;
import gestione_Catalogo.exception.CittaCoincidentiException;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.TipoMezzoException;
import gestione_Catalogo.exception.TrattaException;

/**
 * @authors
 * Francesco Tomei
 * Remo Sperlongano
 * Ivan Torre
 */
public class AggiungiTrattaBean {
	private String ambiente;
	private String mezzo;
	private String tipoMezzo;
	private String partenza;
	private String arrivo;
	private String via;
	private String info;

	public AggiungiTrattaBean(){
	}

	public boolean validate() {
		System.out.println("sono nel validate");
		if (this.getAmbiente() != null &&
			this.getMezzo() != null &&
			this.getPartenza() != null &&
			this.getArrivo() != null)
		{
			System.out.println("sono nell'if");
			if (this.getTipoMezzo() == null) { setTipoMezzo("");};
			if (this.getVia() == null) { setVia(""); };
			if (this.getInfo() == null) { setInfo("");};
			System.out.println(this.toString());
			ControlloreGestioneCatalogo controllore = new ControlloreGestioneCatalogo();
			try {
				System.out.println(this.toString());
				controllore.aggiungiViaggio(ambiente, mezzo, tipoMezzo, partenza, arrivo, via, info);
			} catch (ClassNotFoundException | NoSuchMethodException
					| SecurityException | InstantiationException
					| IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | TrattaException
					| IDEsternoElementoException | CittaCoincidentiException
					| TipoMezzoException | DirittiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
