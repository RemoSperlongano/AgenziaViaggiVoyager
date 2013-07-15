/**
 * 
 */
package gestione_Catalogo.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gestione_Catalogo.control.ControlloreRimuoviPrenotazione;
import gestione_Catalogo.entity.Data;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.MappaException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.OfferteNonPresentiException;
import gestione_Catalogo.exception.PrenotazioneInesistenteException;
import gestione_Catalogo.exception.TrattaInesistenteException;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryVenditore_GestionePrenotazione_RimuoviPrenotazione {
	
	/*
	 * Attributi di istanza
	 */
	
	private ControlloreRimuoviPrenotazione controllore;
	private String ambienteScelto;
	private String mezzoScelto;
	private String partenzaScelta;
	private String arrivoScelto;
	private String viaScelta;
	private String offertaScelta;
	private String prenotazioneScelta;
	private String areaTestoOfferta;
	private String areaTestoCatalogo;
	private String areaTestoImp;
	private String areaTestoPrenotazione;
	private String areaTestoBiglietto;
	
	//Pannelli
	private JPanel 	panel;   //C'e' un solo pannello in questa boundary!!!
	
	
	//Elementi Pannello
    private JLabel	labelTitolo;

	private JLabel labelAmbiente;
	private JComboBox<String> tendinaAmbiente;

	private JTextArea areaTesto;
	private JScrollPane scrollAreaTesto;
	
	private JLabel labelMezzi;
	private JComboBox<String> tendinaMezzi;

	private JLabel labelCittaPartenza;
	private JComboBox<String> tendinaCittaPartenza;

	private JLabel labelCittaArrivo;
	private JComboBox<String> tendinaCittaArrivo;
	
	private JLabel labelVia;
	private JComboBox<String> tendinaVia;
	
	private JLabel labelOfferta;
	private JComboBox<String> tendinaOfferta;
	
	private JLabel labelPrenotazione;
	private JComboBox<String> tendinaPrenotazione;
	
	private JButton bottoneRimuovi;
	private JButton bottoneSvuota;
	
	private JButton bottoneChiudi;
	
	private TendinaAmbienteAA ascoltatoreTendinaAmbiente;
	private TendinaMezziAA ascoltatoreTendinaMezzi;
	private TendinaPartenzeAA ascoltatoreTendinaPartenze;
	private TendinaArriviAA ascoltatoreTendinaArrivi;
	private TendinaViaAA ascoltatoreTendinaVia;
	private TendinaOfferteAA ascoltatoreTendinaOfferte;
	private TendinaPrenotazioniAA ascoltatoreTendinaPrenotazioni;
	private ChiudiAA ascoltatoreBottoneChiudi;
	private RimuoviAA ascoltatoreBottoneRimuovi;
	private SvuotaAA ascoltatoreBottoneSvuota;
	
	
	/*
	 * Costruttore
	 */

	public BoundaryVenditore_GestionePrenotazione_RimuoviPrenotazione(JPanel panelNext){

		ambienteScelto = null;
		mezzoScelto = null;
		partenzaScelta = null;
		arrivoScelto = null;
		viaScelta = null;
		offertaScelta = null;
		areaTestoOfferta = "";
		areaTestoPrenotazione = "";
		areaTestoBiglietto = "";
		areaTestoImp = "Offerte per il viaggio:   ";
		
		
		controllore = new ControlloreRimuoviPrenotazione();
		
		
		
		/*
		 * 
		 * Il superPanel di questa Boundary prende le dimensioni del pannello Passato
		 * 
		 */
		panel = panelNext;
		panel.setVisible(true);   //Si vede ora!
		
		
		
		labelTitolo = new JLabel();	
		labelTitolo.setFont(new Font("Arial", 0, 20));
		labelTitolo.setBounds(panel.getWidth()/3, panel.getHeight()/200, panel.getWidth()/3, panel.getHeight()/7);
		labelTitolo.setVerticalAlignment(JLabel.CENTER);
		labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		labelTitolo.setText("RIMUOVI PRENOTAZIONE");
		panel.add(labelTitolo);
		    
		    
	    labelAmbiente = new JLabel();        //Etichetta per i mezzi
		labelAmbiente.setFont(new Font("Arial", 0, 15));
		labelAmbiente.setBounds(panel.getWidth()/11-35, panel.getHeight()/6, panel.getWidth()/6, 20);
		labelAmbiente.setText("Ambiente");
		panel.add(labelAmbiente);
		
		
		tendinaAmbiente = new JComboBox<String>();	  //Tendina per i mezzi
		tendinaAmbiente.setBackground(Color.WHITE);
		tendinaAmbiente.setEnabled(false);
		tendinaAmbiente.setBounds(panel.getWidth()/11-35, panel.getHeight()/6+20, panel.getWidth()/6, 20);
		panel.add(tendinaAmbiente);

			
			
			
		labelMezzi = new JLabel();        //Etichetta per i mezzi
		labelMezzi.setFont(new Font("Arial", 0, 15));
		labelMezzi.setBounds(panel.getWidth()/11*3-35, panel.getHeight()/6, panel.getWidth()/6, 20);
		labelMezzi.setText("Mezzo di Trasporto");
		panel.add(labelMezzi);
			
			
		tendinaMezzi = new JComboBox<String>();	  //Tendina per i mezzi
		tendinaMezzi.setBackground(Color.WHITE);
		tendinaMezzi.setEnabled(false);
		tendinaMezzi.setBounds(panel.getWidth()/11*3-35, panel.getHeight()/6+20, panel.getWidth()/6, 20);
		panel.add(tendinaMezzi);
			
			
		labelCittaPartenza = new JLabel();        //Etichetta per Stazioni di partenza
		labelCittaPartenza.setFont(new Font("Arial", 0, 15));
		labelCittaPartenza.setBounds(panel.getWidth()/11*5-35, panel.getHeight()/6, panel.getWidth()/6, 20);
		labelCittaPartenza.setText("Citta' di Partenza");
		panel.add(labelCittaPartenza);
			
			
		tendinaCittaPartenza = new JComboBox<String>();	 //Tendina per stazioni di partenza
		tendinaCittaPartenza.setBackground(Color.WHITE);
		tendinaCittaPartenza.setBounds(panel.getWidth()/11*5-35, panel.getHeight()/6+20, panel.getWidth()/6, 20);
		tendinaCittaPartenza.setEnabled(false);
		panel.add(tendinaCittaPartenza);
			
			
		labelCittaArrivo = new JLabel();        //Etichetta per Stazione di arrivo
		labelCittaArrivo.setFont(new Font("Arial", 0, 15));
		labelCittaArrivo.setBounds(panel.getWidth()/11*7-35, panel.getHeight()/6, panel.getWidth()/6, 20);
		labelCittaArrivo.setText("Citta' di Arrivo");
		panel.add(labelCittaArrivo);
			
			
		tendinaCittaArrivo = new JComboBox<String>();	 //Tendina per stazioni di arrivo
		tendinaCittaArrivo.setBackground(Color.WHITE);
		tendinaCittaArrivo.setBounds(panel.getWidth()/11*7-35, panel.getHeight()/6+20, panel.getWidth()/6, 20);
		tendinaCittaArrivo.setEnabled(false);
		panel.add(tendinaCittaArrivo);
			
			
		labelVia = new JLabel();	//Etichetta per Stazione intermedia
		labelVia.setFont(new Font("Arial", 0, 15));
		labelVia.setBounds(panel.getWidth()/11*9-35, panel.getHeight()/6, panel.getWidth()/6, 20);
		labelVia.setText("Via");
		panel.add(labelVia);
		
		
			
		tendinaVia = new JComboBox<String>(); //Tendina per stazioni intermedie
		tendinaVia.setBackground(Color.WHITE);
		tendinaVia.setBounds(panel.getWidth()/11*9-35, panel.getHeight()/6+20, panel.getWidth()/6, 20);
		tendinaVia.setEnabled(false);
		panel.add(tendinaVia);
		
		
		
		areaTesto = new JTextArea();
		areaTesto = new JTextArea(panel.getWidth()/40*38, panel.getHeight()/6*3);
		areaTesto.setFont(new Font("Arial", 0, 15));
		areaTesto.setEditable(false);
		areaTesto.setLineWrap(false);
		areaTesto.setCaretPosition(0);
		scrollAreaTesto = new JScrollPane(areaTesto);   //creo un piccolo scroll e lo aggiungo alla text area
		scrollAreaTesto.setBounds(panel.getWidth()/11-35, panel.getHeight()/6*2-20, panel.getWidth()/2-50, panel.getHeight()/6*3);
		panel.add(scrollAreaTesto);
		
		
		
		labelOfferta = new JLabel();	//Etichetta elementi data
		labelOfferta.setFont(new Font("Arial",0,15));
		labelOfferta.setBounds(panel.getWidth()/4*2+100, panel.getHeight()/6*2, panel.getWidth()/4, 20);
		labelOfferta.setText("Offerta");
		panel.add(labelOfferta); 
		
		
		
		tendinaOfferta = new JComboBox<String>(); //Tendina per stazioni intermedie
		tendinaOfferta.setBackground(Color.WHITE);
		tendinaOfferta.setBounds(panel.getWidth()/4*2+100, panel.getHeight()/6*2+20, panel.getWidth()/4, 20);
		tendinaOfferta.setEnabled(false);
		panel.add(tendinaOfferta);
		
		
		
		labelPrenotazione = new JLabel();
		labelPrenotazione.setFont(new Font("Arial",0,15));
		labelPrenotazione.setBounds(panel.getWidth()/4*2+100, panel.getHeight()/6*3,panel.getWidth()/6, 20);
		labelPrenotazione.setText("Prenotazione");
		panel.add(labelPrenotazione);
		
		
		tendinaPrenotazione = new JComboBox<String>();
		tendinaPrenotazione.setBackground(Color.WHITE);
		tendinaPrenotazione.setBounds(panel.getWidth()/4*2+100, panel.getHeight()/6*3+20, panel.getWidth()/4, 20);
		tendinaPrenotazione.setEnabled(false);
		panel.add(tendinaPrenotazione);
		
		
		
		
		
		bottoneSvuota = new JButton("AZZERA CAMPI");
		bottoneSvuota.setBackground(Color.YELLOW);
		bottoneSvuota.setBounds(panel.getWidth()/5*3-60, panel.getHeight()/6*4+20, panel.getWidth()/5, panel.getHeight()/14);
		panel.add(bottoneSvuota);
		
		bottoneRimuovi = new JButton("RIMUOVI PRENOTAZIONE");
		bottoneRimuovi.setBackground(Color.ORANGE);
		bottoneRimuovi.setBounds(panel.getWidth()/5*4-25, panel.getHeight()/6*4+20, panel.getWidth()/5, panel.getHeight()/14);
		panel.add(bottoneRimuovi);
		
		bottoneChiudi = new JButton("X");
		bottoneChiudi.setBackground(Color.RED);
		bottoneChiudi.setBounds(panel.getWidth()/20*19, 0, panel.getWidth()/20, panel.getHeight()/18);
		panel.add(bottoneChiudi);
    
		
		//ascoltatori per il pannello 
		
		
		ascoltatoreTendinaAmbiente = new TendinaAmbienteAA();
		tendinaAmbiente.addActionListener(ascoltatoreTendinaAmbiente);
		
		ascoltatoreTendinaMezzi = new TendinaMezziAA();
		tendinaMezzi.addActionListener(ascoltatoreTendinaMezzi);

		ascoltatoreTendinaPartenze = new TendinaPartenzeAA();
		tendinaCittaPartenza.addActionListener(ascoltatoreTendinaPartenze);
		
		ascoltatoreTendinaArrivi = new TendinaArriviAA();
		tendinaCittaArrivo.addActionListener(ascoltatoreTendinaArrivi);
		
		ascoltatoreTendinaVia = new TendinaViaAA();
		tendinaVia.addActionListener(ascoltatoreTendinaVia);
		
		ascoltatoreTendinaOfferte = new TendinaOfferteAA();
		tendinaOfferta.addActionListener(ascoltatoreTendinaOfferte);
		
		ascoltatoreTendinaPrenotazioni = new TendinaPrenotazioniAA();
		tendinaPrenotazione.addActionListener(ascoltatoreTendinaPrenotazioni);
		
		ascoltatoreBottoneChiudi = new ChiudiAA();
		bottoneChiudi.addActionListener(ascoltatoreBottoneChiudi);
		
		ascoltatoreBottoneRimuovi = new RimuoviAA();
		bottoneRimuovi.addActionListener(ascoltatoreBottoneRimuovi);
		
		ascoltatoreBottoneSvuota = new SvuotaAA();
		bottoneSvuota.addActionListener(ascoltatoreBottoneSvuota);
		
		
		
		//Alla fine aggiorno le tendine
		aggiornaTendine();
	}
	
	
	
	/*
	 * Metodi
	 */
	
	
	private void aggiornaTendine() { 
		
		tendinaAmbiente.removeAllItems();
		tendinaAmbiente.setEnabled(false);
		
		areaTesto.setText("");
		
		//imposto ambiente scelto
		ambienteScelto = "-----";
		
		try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
			Set<String> s = controllore.mostraAmbientiInCatalogo();
			Iterator<String> it = s.iterator();
			if (s.size() > 1){ //se c'e' piu' di un elemento visualizzo l'elemento neutro
				//devo aggiungere l'elemento vuoto
				tendinaAmbiente.addItem("-----");
			}
				
			while(it.hasNext()){ 					//itero l'insieme di chiavi
				tendinaAmbiente.addItem(it.next());  //ne aggiungo uno alla volta
			}
				
			tendinaAmbiente.setEnabled(true);
			
					
		} catch (MappaException e) {
			areaTesto.setText(e.getMessage()+"\n");
		} 

	}
	
	private void aggiornaOfferte() {
		//Svuoto tutte le tendine e l'area testo
		tendinaOfferta.removeAllItems();
		tendinaOfferta.setEnabled(false);
		
		offertaScelta = "-----";
		
		areaTesto.setText("");
		areaTestoOfferta="";
		
		if (tendinaVia.getItemCount() != 0) {
			
				
				if (!viaScelta.equals("-----")){
					
					try {
						areaTestoCatalogo = ambienteScelto + " " + mezzoScelto + " " + partenzaScelta + " : " + arrivoScelto + " -> " + viaScelta + "\n\n";
					
						ArrayList<Data> listaOfferte = controllore.mostraOfferteValidePerLaTratta(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
						
						
						//inserisco l'elemento neutro
						tendinaOfferta.addItem("-----");
				
					    
						for(Data d : listaOfferte){
							//inserisco l'elemento in tendina
							tendinaOfferta.addItem(d.stampaData());
						}
					    
						tendinaOfferta.setEnabled(true);
						tendinaOfferta.setSelectedIndex(0);
					
						//ImpostoareaTestoOfferta
						areaTestoOfferta = controllore.mostraListaOfferteValideInCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
					
						//Imposto areatestoCatalogo
						areaTestoCatalogo = ambienteScelto + " " + mezzoScelto + " " + partenzaScelta + " : " + arrivoScelto + " -> " + viaScelta + "\n\n"  +
										"ORA PARTENZA\tORA ARRIVO\t\tPOSTI\n" +
										"-----------\t\t----------\t\t----------\n";
					
					
					} catch (IDEsternoElementoException e1) {
						areaTesto.setText(e1.getMessage()+"\n");
					} catch (OfferteNonPresentiException e) {
						areaTestoOfferta = e.getMessage();
					} catch (OffertaInesistenteException e) {
						areaTestoOfferta = e.getMessage();
					} finally{
						areaTesto.setText(areaTestoImp + areaTestoCatalogo + areaTestoOfferta);	
					}
				
					
				}
				

		} 
				
		
		
	}
	
	
	private void aggiornaPrenotazioni(){
		
		tendinaPrenotazione.removeAllItems();
		tendinaPrenotazione.setEnabled(false);
		
		areaTesto.setText("");
		areaTestoOfferta = "";
		areaTestoPrenotazione="PRENOTAZIONI EFFETTUATE:\n\n";
		
		
		
		if (tendinaOfferta.getItemCount() != 0 && !offertaScelta.equals("-----")){
		
			if(!offertaScelta.equals("-----")){
				
				try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
					Set<String> s = controllore.mostraPrenotazioniPerOfferta(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta, offertaScelta);
					Iterator<String> it = s.iterator();
					
					
					//inserisco l'elemento neutro
					tendinaPrenotazione.addItem("-----");
					
					
					while(it.hasNext()){ 	//itero l'insieme di chiavi
						String str = it.next();
						tendinaPrenotazione.addItem(str);    //ne aggiungo uno alla volta
						areaTestoPrenotazione += str + "\n"; // aggiorno l'insieme di prenotazioni
					}
					
					tendinaPrenotazione.setEnabled(true);
					tendinaPrenotazione.setSelectedIndex(0);
					
					areaTestoCatalogo = ambienteScelto + " " + mezzoScelto + " " + partenzaScelta + " : " + arrivoScelto + " -> " + viaScelta + "\n\n";
					
					//ImpostoareaTestoOfferta
					areaTestoOfferta = "Prenotazione per il giorno: \t " + offertaScelta + "\n\n"; 
					
						
					
				} catch (IDEsternoElementoException e1) {
					areaTestoCatalogo = e1.getMessage();
				} catch (ParseException e1) {
					areaTestoOfferta = e1.getMessage();
				} catch (OffertaInesistenteException e1) {
					areaTestoOfferta = e1.getMessage();
				} catch (PrenotazioneInesistenteException e1) {
					areaTestoPrenotazione = e1.getMessage();
				}finally{
					areaTesto.setText(areaTestoImp + areaTestoCatalogo + areaTestoOfferta + areaTestoPrenotazione);	
				}
			}
		
		}
	}
	
	private void aggiornaBiglietti(){
		
		areaTesto.setText("");
		areaTestoOfferta = "";
		areaTestoBiglietto = "";
		
		if (tendinaPrenotazione.getItemCount()!=0){
			if (!prenotazioneScelta.equals("-----")){
				
				
				try {
					//Imposto le varie stringhe
					areaTestoCatalogo = ambienteScelto + " " + mezzoScelto + " " + partenzaScelta + " : " + arrivoScelto + " -> " + viaScelta + "\n\n";
					areaTestoOfferta = "Prenotazione per il giorno: \t " + offertaScelta + "\n\n"; 
					areaTestoPrenotazione = "A nome di " + prenotazioneScelta + "\n\n";
					
					areaTestoBiglietto += controllore.mostraListaBigliettiPerPrenotazione(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta, offertaScelta, prenotazioneScelta);
				} catch (OffertaInesistenteException e) {
					areaTestoOfferta = e.getMessage();
				} catch (PrenotazioneInesistenteException e) {
					areaTestoPrenotazione = e.getMessage();
				} catch (IDEsternoElementoException e) {
					areaTestoCatalogo = e.getMessage();
				} catch (ParseException e) {
					e.printStackTrace();
				} finally{
					areaTesto.setText(areaTestoImp + areaTestoCatalogo + areaTestoOfferta + areaTestoPrenotazione + areaTestoBiglietto); 
				}
				
				
			}
		}
	}
	
	
	
	/*
	 * Ascoltatori per Elementi
	 */
	
	
	private class TendinaAmbienteAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuoto l'area testo
			areaTesto.setText("");
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaMezzi.removeAllItems();
			tendinaMezzi.setEnabled(false);
			
			//prendo il valore di questa tendina
			ambienteScelto	= (String)tendinaAmbiente.getSelectedItem();
			
			if (tendinaAmbiente.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
			
					
					if(!ambienteScelto.equals("-----")){ //Solo se non e' l'elemento neutro
							
						try {  //cerca nella mappa tutte le chiavi da aggiungere in tendina
							Set<String> s = controllore.mostraMezziInCatalogo(ambienteScelto);
							Iterator<String> it = s.iterator();
							
							if (s.size() > 1){
								//inserisco l'elemento neutro
								tendinaMezzi.addItem("-----");
							}
							
							while(it.hasNext()){ 					//itero l'insieme di chiavi
								tendinaMezzi.addItem(it.next());  //ne aggiungo uno alla volta
							}
							tendinaMezzi.setEnabled(true);
							
						} catch (IDEsternoElementoException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						}
					}
					
	
			}
		
		}
		
	}
	
	
	private class TendinaMezziAA implements ActionListener{
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuoto l'area testo
			areaTesto.setText("");
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaCittaPartenza.removeAllItems();
			tendinaCittaPartenza.setEnabled(false);
			
			//prendo il valore delle altre tendina
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();   //Neanche servirebbe, in teoria...
			mezzoScelto = (String)tendinaMezzi.getSelectedItem();
			
			if (tendinaMezzi.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
	
				if(!mezzoScelto.equals("-----")){ //Solo se non e' l'elemento neutro
					
					try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
						Set<String> s = controllore.mostraCittaDiPartenzaInCatalogo(ambienteScelto, mezzoScelto);
						Iterator<String> it = s.iterator();
						
						if (s.size() > 1){
							//inserisco l'elemento neutro
							tendinaCittaPartenza.addItem("-----");
						}
						
						while(it.hasNext()){ 					//itero l'insieme di chiavi
							tendinaCittaPartenza.addItem(it.next());  //ne aggiungo uno alla volta
						}
						
						tendinaCittaPartenza.setEnabled(true);
						
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}   
				}
						
	
			}
		
		}
		
	}
	
	private class TendinaPartenzeAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuoto l'area testo
			areaTesto.setText("");
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaCittaArrivo.removeAllItems();
			tendinaCittaArrivo.setEnabled(false);
			
			//prendo il valore delle altre tendina
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			
			if (tendinaCittaPartenza.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
				
				if(!partenzaScelta.equals("-----")){ //Solo se non e' l'elemento neutro
					
					try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
						Set<String> s = controllore.mostraCittaDiArrivoInCatalogo(ambienteScelto, mezzoScelto, partenzaScelta);
						Iterator<String> it = s.iterator();
						
						if(s.size() > 1){
							//inserisco l'elemento neutro
							tendinaCittaArrivo.addItem("-----");
						}
						
						while(it.hasNext()){ 					//itero l'insieme di chiavi
							tendinaCittaArrivo.addItem(it.next());  //ne aggiungo uno alla volta
						}
						
						tendinaCittaArrivo.setEnabled(true);
						tendinaCittaArrivo.setSelectedIndex(0);
						
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
			
			}
			
		}
		
	}
	
	private class TendinaArriviAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuoto l'area testo
			areaTesto.setText("");
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaVia.removeAllItems();
			tendinaVia.setEnabled(false);
			
			//prendo il valore delle altre tendina
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			
			if (tendinaCittaArrivo.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
				
				if(!arrivoScelto.equals("-----")){ //Solo se non e' l'elemento neutro
					
					try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
						Set<String> s = controllore.mostraViaInCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto);
						Iterator<String> it = s.iterator();
						
						if(s.size() > 1){
							//inserisco l'elemento neutro
							tendinaVia.addItem("-----");
						}
						
						while(it.hasNext()){ 					//itero l'insieme di chiavi
							tendinaVia.addItem(it.next());  //ne aggiungo uno alla volta
						}
						
						tendinaVia.setEnabled(true);
						tendinaVia.setSelectedIndex(0);
						
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
	
			
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			
				
			}
			
			
		}
		
	}
	
	
	private class TendinaViaAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			viaScelta = (String) tendinaVia.getSelectedItem();
			
			aggiornaOfferte();

		}
		
	}
	
	
	private class TendinaOfferteAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaPrenotazione.removeAllItems();
			tendinaPrenotazione.setEnabled(false);
			
			
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			offertaScelta = (String) tendinaOfferta.getSelectedItem();
			
			if (tendinaOfferta.getItemCount()!=0){
				if (offertaScelta.equals("-----")){
					aggiornaOfferte();
				} else {
					aggiornaPrenotazioni();
				}
			}
		
			
			
			
		}
		
	}
	
	private class TendinaPrenotazioniAA implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
		
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			offertaScelta = (String) tendinaOfferta.getSelectedItem();
			prenotazioneScelta = (String) tendinaPrenotazione.getSelectedItem();
			
			if (tendinaPrenotazione.getItemCount()!=0){
				if (prenotazioneScelta.equals("-----")){
					aggiornaPrenotazioni();
				} else {
					aggiornaBiglietti();
				}
			}
			
		}
		
	}
	
	
	private class RimuoviAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {	
			
			
			if (tendinaPrenotazione.getItemCount() != 0 && !prenotazioneScelta.equals("-----")){
				
				prenotazioneScelta = (String) tendinaPrenotazione.getSelectedItem();
				
				int conferma = JOptionPane.showConfirmDialog(null, "Rimuovere la prenotazione selezionata?", "Conferma Rimozione Prenotazione", JOptionPane.YES_NO_OPTION);
				if (conferma == JOptionPane.YES_OPTION){
					
					//rimuovo la prenotazione
					try {
						controllore.rimuoviPrenotazione(ambienteScelto,mezzoScelto,partenzaScelta,arrivoScelto,viaScelta,offertaScelta,prenotazioneScelta);
						JOptionPane.showMessageDialog(null, "La prenotazione e' stata rimossa correttamente.", "Prenotazione Rimossa", JOptionPane.INFORMATION_MESSAGE);
						aggiornaPrenotazioni();
						
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), e1.toString(), JOptionPane.INFORMATION_MESSAGE);
					} catch (TrattaInesistenteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (OffertaInesistenteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (PrenotazioneInesistenteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Nessuna prenotazione selezionata!");
			}
			
		}
	
	}
	
	private class SvuotaAA implements ActionListener{
		/*
		 * Svuota tutti i campi
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (tendinaAmbiente.isEnabled()){
								
				tendinaAmbiente.setSelectedIndex(0); //la tendina torna al primo valore.
				
				if (tendinaAmbiente.getItemCount()>1){
					tendinaMezzi.removeAllItems();  //svuota le tendine
					tendinaMezzi.setEnabled(false);//disattiva tutte le tendine

					ambienteScelto = null;
					mezzoScelto = null;
					partenzaScelta = null;
					arrivoScelto = null;
					viaScelta = null;
					offertaScelta = null;

				}
			
			areaTesto.setText("");
			
			}

		}
		
	}
	
	private class ChiudiAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			panel.setVisible(false); 					//chiude questo pannello
			BoundaryVenditore_GestionePrenotazione.riattivaBottoni();
			
			//svuoto comunque il pannello
			if (tendinaAmbiente.getItemCount() != 0){
				
				tendinaAmbiente.setSelectedIndex(0); //la tendina torna al primo valore.
				tendinaMezzi.removeAllItems();  //svuota le tendine
				tendinaMezzi.setEnabled(false);//disattiva tutte le tendine

			}
			
			ambienteScelto = null;
			mezzoScelto = null;
			partenzaScelta = null;
			arrivoScelto = null;
			viaScelta = null;
			offertaScelta = null;
			
			areaTesto.setText("");

		}
	}
}
