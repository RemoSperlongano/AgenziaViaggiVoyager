/**
 * 
 */
package gestione_Catalogo.boundary;



import gestione_Catalogo.control.ControlloreRimuoviOffertaConPrenotazioni;
import gestione_Catalogo.entity.Data;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.MappaException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.OfferteNonPresentiException;
import gestione_Catalogo.exception.PrenotazioneInesistenteException;
import gestione_Catalogo.exception.TrattaInesistenteException;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryGestoreEccezioni_GestioneEccezioni_RimuoviOffertaConPrenotazioni {
	
	
	/*
	 * Attributi di istanza
	 */
	
	//Entita'
	private ControlloreRimuoviOffertaConPrenotazioni controllore;
	private String ambienteScelto;
	private String mezzoScelto;
	private String partenzaScelta;
	private String arrivoScelto;
	private String viaScelta;
	private String offertaScelta;
	private String areaTestoOfferta;
	private String areaTestoCatalogo;
	private String areaTestoImp;

	//Pannelli
	private JPanel panel;
	
	
	
	//Elementi Pannello3
    private JLabel	labelTitoloPannello3;

	private JLabel labelAmbientePannello3;
	private JComboBox<String> tendinaAmbientePannello3;

	private JTextArea areaTestoPannello3;
	private JScrollPane scrollAreaTestoPannello3;
	
	private JLabel labelMezziPannello3;
	private JComboBox<String> tendinaMezziPannello3;

	private JLabel labelCittaPartenzaPannello3;
	private JComboBox<String> tendinaCittaPartenzaPannello3;

	private JLabel labelCittaArrivoPannello3;
	private JComboBox<String> tendinaCittaArrivoPannello3;
	
	private JLabel labelViaPannello3;
	private JComboBox<String> tendinaViaPannello3;
	
	private JLabel labelOffertaPannello3;
	private JComboBox<String> tendinaOffertaPannello3;

	private JButton bottoneRimuovi;
	private JButton bottoneSvuotaPannello3;
	
	private JButton bottoneChiudiPannello3;
	
	private TendinaAmbientePannello3AA ascoltatoreTendinaAmbientePannello3;
	private TendinaMezziPannello3AA ascoltatoreTendinaMezziPannello3;
	private TendinaPartenzePannello3AA ascoltatoreTendinaPartenzePannello3;
	private TendinaArriviPannello3AA ascoltatoreTendinaArriviPannello3;
	private TendinaViaPannello3AA ascoltatoreTendinaViaPannello3;
	private ChiudiPannello3AA ascoltatoreBottoneChiudiPannello3;
	private RimuoviAA ascoltatoreBottoneRimuovi;
	private SvuotaPannello3AA ascoltatoreBottoneSvuotaPannello3;
	
	
	
	


    
    
    public BoundaryGestoreEccezioni_GestioneEccezioni_RimuoviOffertaConPrenotazioni(JPanel panelNext){
    	
    	ambienteScelto = null;
		mezzoScelto = null;
		partenzaScelta = null;
		arrivoScelto = null;
		viaScelta = null;
		offertaScelta = null;
		areaTestoOfferta = null;
		controllore = new ControlloreRimuoviOffertaConPrenotazioni();
		
		areaTestoImp = "Offerte per il viaggio:   ";
		
		/*
		 * 
		 * Il superPanel di questa Boundary prende le dimensioni del pannello Passato
		 * 
		 */
		panel = panelNext;
		panel.setVisible(true);   //Si vede ora!
		
		
		
		
		
		/*
		 * 
		 * elementi pannello
		 * 
		 */
    
   
		
		labelTitoloPannello3 = new JLabel();	
		labelTitoloPannello3.setFont(new Font("Arial", 0, 20));
		labelTitoloPannello3.setBounds(panel.getWidth()/3, panel.getHeight()/200, panel.getWidth()/3, panel.getHeight()/7);
		labelTitoloPannello3.setVerticalAlignment(JLabel.CENTER);
		labelTitoloPannello3.setHorizontalAlignment(JLabel.CENTER);
		labelTitoloPannello3.setText("RIMUOVI OFFERTA");
		panel.add(labelTitoloPannello3);
		    
		    
	    labelAmbientePannello3 = new JLabel();        //Etichetta per i mezzi
		labelAmbientePannello3.setFont(new Font("Arial", 0, 15));
		labelAmbientePannello3.setBounds(panel.getWidth()/11-35, panel.getHeight()/6, panel.getWidth()/6, 20);
		labelAmbientePannello3.setText("Ambiente");
		panel.add(labelAmbientePannello3);
		
		
		tendinaAmbientePannello3 = new JComboBox<String>();	  //Tendina per i mezzi
		tendinaAmbientePannello3.setBackground(Color.WHITE);
		tendinaAmbientePannello3.setEnabled(false);
		tendinaAmbientePannello3.setBounds(panel.getWidth()/11-35, panel.getHeight()/6+20, panel.getWidth()/6, 20);
		panel.add(tendinaAmbientePannello3);

			
			
			
		labelMezziPannello3 = new JLabel();        //Etichetta per i mezzi
		labelMezziPannello3.setFont(new Font("Arial", 0, 15));
		labelMezziPannello3.setBounds(panel.getWidth()/11*3-35, panel.getHeight()/6, panel.getWidth()/6, 20);
		labelMezziPannello3.setText("Mezzo di Trasporto");
		panel.add(labelMezziPannello3);
			
			
		tendinaMezziPannello3 = new JComboBox<String>();	  //Tendina per i mezzi
		tendinaMezziPannello3.setBackground(Color.WHITE);
		tendinaMezziPannello3.setEnabled(false);
		tendinaMezziPannello3.setBounds(panel.getWidth()/11*3-35, panel.getHeight()/6+20, panel.getWidth()/6, 20);
		panel.add(tendinaMezziPannello3);
			
			
		labelCittaPartenzaPannello3 = new JLabel();        //Etichetta per Stazioni di partenza
		labelCittaPartenzaPannello3.setFont(new Font("Arial", 0, 15));
		labelCittaPartenzaPannello3.setBounds(panel.getWidth()/11*5-35, panel.getHeight()/6, panel.getWidth()/6, 20);
		labelCittaPartenzaPannello3.setText("Citta' di Partenza");
		panel.add(labelCittaPartenzaPannello3);
			
			
		tendinaCittaPartenzaPannello3 = new JComboBox<String>();	 //Tendina per stazioni di partenza
		tendinaCittaPartenzaPannello3.setBackground(Color.WHITE);
		tendinaCittaPartenzaPannello3.setBounds(panel.getWidth()/11*5-35, panel.getHeight()/6+20, panel.getWidth()/6, 20);
		tendinaCittaPartenzaPannello3.setEnabled(false);
		panel.add(tendinaCittaPartenzaPannello3);
			
			
		labelCittaArrivoPannello3 = new JLabel();        //Etichetta per Stazione di arrivo
		labelCittaArrivoPannello3.setFont(new Font("Arial", 0, 15));
		labelCittaArrivoPannello3.setBounds(panel.getWidth()/11*7-35, panel.getHeight()/6, panel.getWidth()/6, 20);
		labelCittaArrivoPannello3.setText("Citta' di Arrivo");
		panel.add(labelCittaArrivoPannello3);
			
			
		tendinaCittaArrivoPannello3 = new JComboBox<String>();	 //Tendina per stazioni di arrivo
		tendinaCittaArrivoPannello3.setBackground(Color.WHITE);
		tendinaCittaArrivoPannello3.setBounds(panel.getWidth()/11*7-35, panel.getHeight()/6+20, panel.getWidth()/6, 20);
		tendinaCittaArrivoPannello3.setEnabled(false);
		panel.add(tendinaCittaArrivoPannello3);
			
			
		labelViaPannello3 = new JLabel();	//Etichetta per Stazione intermedia
		labelViaPannello3.setFont(new Font("Arial", 0, 15));
		labelViaPannello3.setBounds(panel.getWidth()/11*9-35, panel.getHeight()/6, panel.getWidth()/6, 20);
		labelViaPannello3.setText("Via");
		panel.add(labelViaPannello3);
		
		
			
		tendinaViaPannello3 = new JComboBox<String>(); //Tendina per stazioni intermedie
		tendinaViaPannello3.setBackground(Color.WHITE);
		tendinaViaPannello3.setBounds(panel.getWidth()/11*9-35, panel.getHeight()/6+20, panel.getWidth()/6, 20);
		tendinaViaPannello3.setEnabled(false);
		panel.add(tendinaViaPannello3);
		
		
		
		areaTestoPannello3 = new JTextArea();
		areaTestoPannello3 = new JTextArea(panel.getWidth()/40*38, panel.getHeight()/6*3);
		areaTestoPannello3.setFont(new Font("Arial", 0, 15));
		areaTestoPannello3.setEditable(false);
		areaTestoPannello3.setLineWrap(false);
		scrollAreaTestoPannello3 = new JScrollPane(areaTestoPannello3);   //creo un piccolo scroll e lo aggiungo alla text area
		scrollAreaTestoPannello3.setBounds(panel.getWidth()/11-35, panel.getHeight()/6*2-20, panel.getWidth()/2-50, panel.getHeight()/6*3);
		panel.add(scrollAreaTestoPannello3);
		
		
		
		labelOffertaPannello3 = new JLabel();	//Etichetta elementi data
		labelOffertaPannello3.setFont(new Font("Arial",0,15));
		labelOffertaPannello3.setBounds(panel.getWidth()/4*2+100, panel.getHeight()/6*2, panel.getWidth()/4, 20);
		labelOffertaPannello3.setText("Offerta");
		panel.add(labelOffertaPannello3); 
		
		
		
		tendinaOffertaPannello3 = new JComboBox<String>(); //Tendina per stazioni intermedie
		tendinaOffertaPannello3.setBackground(Color.WHITE);
		tendinaOffertaPannello3.setBounds(panel.getWidth()/4*2+100, panel.getHeight()/6*2+20, panel.getWidth()/4, 20);
		tendinaOffertaPannello3.setEnabled(false);
		panel.add(tendinaOffertaPannello3);
		
		
		
		bottoneSvuotaPannello3 = new JButton("AZZERA CAMPI");
		bottoneSvuotaPannello3.setBackground(Color.YELLOW);
		bottoneSvuotaPannello3.setBounds(panel.getWidth()/5*3-60, panel.getHeight()/6*4+20, panel.getWidth()/5, panel.getHeight()/14);
		panel.add(bottoneSvuotaPannello3);
		
		bottoneRimuovi = new JButton("RIMUOVI OFFERTA");
		bottoneRimuovi.setBackground(Color.ORANGE);
		bottoneRimuovi.setBounds(panel.getWidth()/5*4-25, panel.getHeight()/6*4+20, panel.getWidth()/5, panel.getHeight()/14);
		panel.add(bottoneRimuovi);
		
		bottoneChiudiPannello3 = new JButton("X");
		bottoneChiudiPannello3.setBackground(Color.RED);
		bottoneChiudiPannello3.setBounds(panel.getWidth()/20*19, 0, panel.getWidth()/20, panel.getHeight()/18);
		panel.add(bottoneChiudiPannello3);
    
		
		//ascoltatori per il pannello 3
		
		
		ascoltatoreTendinaAmbientePannello3 = new TendinaAmbientePannello3AA();
		tendinaAmbientePannello3.addActionListener(ascoltatoreTendinaAmbientePannello3);
		
		ascoltatoreTendinaMezziPannello3 = new TendinaMezziPannello3AA();
		tendinaMezziPannello3.addActionListener(ascoltatoreTendinaMezziPannello3);

		ascoltatoreTendinaPartenzePannello3 = new TendinaPartenzePannello3AA();
		tendinaCittaPartenzaPannello3.addActionListener(ascoltatoreTendinaPartenzePannello3);
		
		ascoltatoreTendinaArriviPannello3 = new TendinaArriviPannello3AA();
		tendinaCittaArrivoPannello3.addActionListener(ascoltatoreTendinaArriviPannello3);
		
		ascoltatoreTendinaViaPannello3 = new TendinaViaPannello3AA();
		tendinaViaPannello3.addActionListener(ascoltatoreTendinaViaPannello3);
		
		ascoltatoreBottoneChiudiPannello3 = new ChiudiPannello3AA();
		bottoneChiudiPannello3.addActionListener(ascoltatoreBottoneChiudiPannello3);
		
		ascoltatoreBottoneRimuovi = new RimuoviAA();
		bottoneRimuovi.addActionListener(ascoltatoreBottoneRimuovi);
		
		ascoltatoreBottoneSvuotaPannello3 = new SvuotaPannello3AA();
		bottoneSvuotaPannello3.addActionListener(ascoltatoreBottoneSvuotaPannello3);
		
		
		//dulcis in fundo attivo la tendina degli ambienti
		aggiornaTendinePannello3();
		
	
    }
    
    
    	
    	
    	
    	private void aggiornaTendinePannello3() { 
    		
    		tendinaAmbientePannello3.removeAllItems();
    		tendinaAmbientePannello3.setEnabled(false);
    		
    		areaTestoPannello3.setText("");
    		areaTestoPannello3.setCaretPosition(0);
    		
    		//imposto ambiente scelto
    		ambienteScelto = "-----";
    		
    		try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
    			Set<String> s = controllore.mostraAmbientiInCatalogo();
    			Iterator<String> it = s.iterator();
    			if (s.size() > 1){ //se c'e' piu' di un elemento visualizzo l'elemento neutro
    				//devo aggiungere l'elemento vuoto
    				tendinaAmbientePannello3.addItem("-----");
    			}
    				
    			while(it.hasNext()){ 					//itero l'insieme di chiavi
    				tendinaAmbientePannello3.addItem(it.next());  //ne aggiungo uno alla volta
    			}
    				
    			tendinaAmbientePannello3.setEnabled(true);
    			
    					
    		} catch (MappaException e) {
    			areaTestoPannello3.setText(e.getMessage()+"\n");
    		} 

    	}
    	
		private void aggiornaOffertePannello3() {
			//Svuoto tutte le tendine e l'area testo
			tendinaOffertaPannello3.removeAllItems();
			tendinaOffertaPannello3.setEnabled(false);
			
			offertaScelta = "-----";
			
			areaTestoPannello3.setText("");
    		areaTestoPannello3.setCaretPosition(0);
			areaTestoOfferta="";
			
			if (tendinaViaPannello3.getItemCount() != 0) {
				
					
					if (!viaScelta.equals("-----")){
						
						try {
							areaTestoCatalogo = ambienteScelto + " " + mezzoScelto + " " + partenzaScelta + " : " + arrivoScelto + " -> " + viaScelta + "\n\n";
						
							Set<Data> set = controllore.mostraOffertePerLaTratta(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
			
							Iterator<Data> it = set.iterator();
							if(set.size() > 1){
								//inserisco l'elemento neutro
								tendinaOffertaPannello3.addItem("-----");
							}
						    
							while(it.hasNext()){
								Data d = it.next();
								//inserisco l'elemento in tendina
								tendinaOffertaPannello3.addItem(d.stampaData());
							}
						    
							tendinaOffertaPannello3.setEnabled(true);
							tendinaOffertaPannello3.setSelectedIndex(0);
						
							//ImpostoareaTestoOfferta
							areaTestoOfferta = controllore.mostraListaOffertaInCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
						
							//Imposto areatestoCatalogo
							areaTestoCatalogo = ambienteScelto + " " + mezzoScelto + " " + partenzaScelta + " : " + arrivoScelto + " -> " + viaScelta + "\n\n"  +
											"ORA PARTENZA\tORA ARRIVO\t\tPOSTI\n" +
											"-----------\t\t----------\t\t----------\n";
						
						
						} catch (IDEsternoElementoException e1) {
							areaTestoPannello3.setText(e1.getMessage()+"\n");
						} catch (OfferteNonPresentiException e) {
							areaTestoOfferta = e.getMessage();
						} catch (OffertaInesistenteException e) {
							areaTestoOfferta = e.getMessage();
						} 
						areaTestoPannello3.setText(areaTestoImp + areaTestoCatalogo + areaTestoOfferta);
			    		areaTestoPannello3.setCaretPosition(0);
						
					}
					
	
			} 
					
			
			
		}
		
			
    
	
	/*
	 * Ascoltatori per Pannello
	 */
	
	
	private class TendinaAmbientePannello3AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuoto l'area testo
			areaTestoPannello3.setText("");
    		areaTestoPannello3.setCaretPosition(0);
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaMezziPannello3.removeAllItems();
			tendinaMezziPannello3.setEnabled(false);
			
			//prendo il valore di questa tendina
			ambienteScelto	= (String)tendinaAmbientePannello3.getSelectedItem();
			
			if (tendinaAmbientePannello3.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
			
					
					if(!ambienteScelto.equals("-----")){ //Solo se non e' l'elemento neutro
							
						try {  //cerca nella mappa tutte le chiavi da aggiungere in tendina
							Set<String> s = controllore.mostraMezziInCatalogo(ambienteScelto);
							Iterator<String> it = s.iterator();
							
							if (s.size() > 1){
								//inserisco l'elemento neutro
								tendinaMezziPannello3.addItem("-----");
							}
							
							while(it.hasNext()){ 					//itero l'insieme di chiavi
								tendinaMezziPannello3.addItem(it.next());  //ne aggiungo uno alla volta
							}
							tendinaMezziPannello3.setEnabled(true);
							
						} catch (IDEsternoElementoException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						}
					}
					
	
			}
		
		}
		
	}
	
	
	private class TendinaMezziPannello3AA implements ActionListener{
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuoto l'area testo
			areaTestoPannello3.setText("");
    		areaTestoPannello3.setCaretPosition(0);
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaCittaPartenzaPannello3.removeAllItems();
			tendinaCittaPartenzaPannello3.setEnabled(false);
			
			//prendo il valore delle altre tendina
			ambienteScelto = (String) tendinaAmbientePannello3.getSelectedItem();   //Neanche servirebbe, in teoria...
			mezzoScelto = (String)tendinaMezziPannello3.getSelectedItem();
			
			if (tendinaMezziPannello3.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
	
				if(!mezzoScelto.equals("-----")){ //Solo se non e' l'elemento neutro
					
					try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
						Set<String> s = controllore.mostraCittaDiPartenzaInCatalogo(ambienteScelto, mezzoScelto);
						Iterator<String> it = s.iterator();
						
						if (s.size() > 1){
							//inserisco l'elemento neutro
							tendinaCittaPartenzaPannello3.addItem("-----");
						}
						
						while(it.hasNext()){ 					//itero l'insieme di chiavi
							tendinaCittaPartenzaPannello3.addItem(it.next());  //ne aggiungo uno alla volta
						}
						
						tendinaCittaPartenzaPannello3.setEnabled(true);
						
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}   
				}
						
	
			}
		
		}
		
	}
	
	private class TendinaPartenzePannello3AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuoto l'area testo
			areaTestoPannello3.setText("");
    		areaTestoPannello3.setCaretPosition(0);
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaCittaArrivoPannello3.removeAllItems();
			tendinaCittaArrivoPannello3.setEnabled(false);
			
			//prendo il valore delle altre tendina
			ambienteScelto = (String) tendinaAmbientePannello3.getSelectedItem();
			mezzoScelto = (String) tendinaMezziPannello3.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenzaPannello3.getSelectedItem();
			
			if (tendinaCittaPartenzaPannello3.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
				
				if(!partenzaScelta.equals("-----")){ //Solo se non e' l'elemento neutro
					
					try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
						Set<String> s = controllore.mostraCittaDiArrivoInCatalogo(ambienteScelto, mezzoScelto, partenzaScelta);
						Iterator<String> it = s.iterator();
						
						if(s.size() > 1){
							//inserisco l'elemento neutro
							tendinaCittaArrivoPannello3.addItem("-----");
						}
						
						while(it.hasNext()){ 					//itero l'insieme di chiavi
							tendinaCittaArrivoPannello3.addItem(it.next());  //ne aggiungo uno alla volta
						}
						
						tendinaCittaArrivoPannello3.setEnabled(true);
						tendinaCittaArrivoPannello3.setSelectedIndex(0);
						
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
			
			}
			
		}
		
	}
	
	private class TendinaArriviPannello3AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuoto l'area testo
			areaTestoPannello3.setText("");
    		areaTestoPannello3.setCaretPosition(0);
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaViaPannello3.removeAllItems();
			tendinaViaPannello3.setEnabled(false);
			
			//prendo il valore delle altre tendina
			ambienteScelto = (String) tendinaAmbientePannello3.getSelectedItem();
			mezzoScelto = (String) tendinaMezziPannello3.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenzaPannello3.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivoPannello3.getSelectedItem();
			
			if (tendinaCittaArrivoPannello3.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
				
				if(!arrivoScelto.equals("-----")){ //Solo se non e' l'elemento neutro
					
					try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
						Set<String> s = controllore.mostraViaInCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto);
						Iterator<String> it = s.iterator();
						
						if(s.size() > 1){
							//inserisco l'elemento neutro
							tendinaViaPannello3.addItem("-----");
						}
						
						while(it.hasNext()){ 					//itero l'insieme di chiavi
							tendinaViaPannello3.addItem(it.next());  //ne aggiungo uno alla volta
						}
						
						tendinaViaPannello3.setEnabled(true);
						tendinaViaPannello3.setSelectedIndex(0);
						
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
	
			
			ambienteScelto = (String) tendinaAmbientePannello3.getSelectedItem();
			mezzoScelto = (String) tendinaMezziPannello3.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenzaPannello3.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivoPannello3.getSelectedItem();
			
				
			}
			
			
		}
		
	}
	
	
	private class TendinaViaPannello3AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ambienteScelto = (String) tendinaAmbientePannello3.getSelectedItem();
			mezzoScelto = (String) tendinaMezziPannello3.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenzaPannello3.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivoPannello3.getSelectedItem();
			viaScelta = (String) tendinaViaPannello3.getSelectedItem();
			
			aggiornaOffertePannello3();

		}
		
	}
	
	
	private class RimuoviAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			ambienteScelto = (String) tendinaAmbientePannello3.getSelectedItem();
			mezzoScelto = (String) tendinaMezziPannello3.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenzaPannello3.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivoPannello3.getSelectedItem();
			viaScelta = (String) tendinaViaPannello3.getSelectedItem();
			offertaScelta = (String) tendinaOffertaPannello3.getSelectedItem();
			
			if (tendinaOffertaPannello3.getItemCount() != 0 && !offertaScelta.equals("-----")){
	
				int conferma = JOptionPane.showConfirmDialog(null, "Rimuovere l'offerta selezionata?", "Conferma Rimozione Offerta", JOptionPane.YES_NO_OPTION);
				if (conferma == JOptionPane.YES_OPTION){
						
					// rimuovo il viaggio
					try {
						controllore.rimuoviOffertaConPrenotazioni(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta, offertaScelta);
						JOptionPane.showMessageDialog(null, "L'offerta e' stata rimossa correttamente.", "Offerta Rimossa", JOptionPane.INFORMATION_MESSAGE);
						aggiornaOffertePannello3();
							
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (TrattaInesistenteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (OffertaInesistenteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (PrenotazioneInesistenteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Attenzione!", JOptionPane.WARNING_MESSAGE);
					}			
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Nessuna offerta selezionata!");
			}
			
		}
	
	}
	
	private class SvuotaPannello3AA implements ActionListener{
		/*
		 * Svuota tutti i campi
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (tendinaAmbientePannello3.isEnabled()){
								
				tendinaAmbientePannello3.setSelectedIndex(0); //la tendina torna al primo valore.
				
				if (tendinaAmbientePannello3.getItemCount()>1){
					tendinaMezziPannello3.removeAllItems();  //svuota le tendine
					tendinaMezziPannello3.setEnabled(false);//disattiva tutte le tendine

					ambienteScelto = null;
					mezzoScelto = null;
					partenzaScelta = null;
					arrivoScelto = null;
					viaScelta = null;
					offertaScelta = null;

				}
			
			areaTestoPannello3.setText("");
    		areaTestoPannello3.setCaretPosition(0);
			
				
		//	} else {
		//		JOptionPane.showMessageDialog(null, "Nessun viaggio in catalogo!", "Catalogo Vuoto", JOptionPane.INFORMATION_MESSAGE);
			}

		}
		
	}
	
	private class ChiudiPannello3AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			panel.setVisible(false); 					//chiude questo pannello
			BoundaryGestoreEccezioni_GestioneEccezioni.riattivaBottoni();
			
			//svuoto comunque il pannello
			if (tendinaAmbientePannello3.getItemCount() != 0){
				
				tendinaAmbientePannello3.setSelectedIndex(0); //la tendina torna al primo valore.
				tendinaMezziPannello3.removeAllItems();  //svuota le tendine
				tendinaMezziPannello3.setEnabled(false);//disattiva tutte le tendine

			}
			
			ambienteScelto = null;
			mezzoScelto = null;
			partenzaScelta = null;
			arrivoScelto = null;
			viaScelta = null;
			offertaScelta = null;
			
			areaTestoPannello3.setText("");
    		areaTestoPannello3.setCaretPosition(0);

		}
	}

}
