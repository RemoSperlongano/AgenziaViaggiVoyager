/**
 * 
 */
package gestione_Catalogo.boundary;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;


import gestione_Catalogo.control.ControlloreGestioneCatalogo;
import gestione_Catalogo.control.ControlloreMostraCatalogo;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.MappaException;
import gestione_Catalogo.exception.OffertaException;
import gestione_Catalogo.exception.TrattaInesistenteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryVisitatore_InfoViaggi_MostraCatalogo {
	
	/*
	 * Attributi di istanza
	 */
	
	//Entita'
	private ControlloreMostraCatalogo controllore;
	private String ambienteScelto;
	private String mezzoScelto;
	private String partenzaScelta;
	private String arrivoScelto;
	private String viaScelta;
	private String areaTestoCatalogo;
	private String areaTestoImp;

	//Pannelli
	private JPanel panel;
	
	//Elementi panel
	//Elementi 
	
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
		
		private JLabel labelData;
		
		private JComboBox<Integer> tendinaGiorno;
		
		private JLabel labelSlash1;
		
		private JComboBox<Integer> tendinaMese;
		
		private JLabel labelSlash2;
		
		private JComboBox<Integer> tendinaAnno;
		
		private JLabel labelPosti;
		private JComboBox<Integer> tendinaPosti;

		private JButton bottoneCercaOfferta;
		private JButton bottoneSvuota;
		
		private JButton bottoneChiudi;
		
		private TendinaAmbienteAA ascoltatoreTendinaAmbiente;
		private TendinaMezziAA ascoltatoreTendinaMezzi;
		private TendinaPartenzeAA ascoltatoreTendinaPartenze;
		private TendinaArriviAA ascoltatoreTendinaArrivi;
		private TendinaViaAA ascoltatoreTendinaVia;
		private TendinaAnnoAA ascoltatoreTendinaAnno;
		private TendinaMeseAA ascoltatoreTendinaMese;
		private ChiudiAA ascoltatoreBottoneChiudi;
		private CercaOffertaAA ascoltatoreBottoneCercaOfferta;
		private SvuotaAA ascoltatoreBottoneSvuota;
	
	
	public BoundaryVisitatore_InfoViaggi_MostraCatalogo(JPanel panelNext){
		
		ambienteScelto = null;
		mezzoScelto = null;
		partenzaScelta = null;
		arrivoScelto = null;
		viaScelta = null;
		areaTestoCatalogo = null;
		controllore = new ControlloreMostraCatalogo();
		
		areaTestoImp = "AMBIENTE" + "\t" + "MEZZO" + "\t\t" + "TRATTA" + "\t\t\t"  + "INFO\n" +
		   "--------------" + "\t" + "----------" + "\t\t" + "------------" + "\t\t\t" + "---------" + "\n";
		
		/*
		 * 
		 * Il panel di questa Boundary prende le dimensioni del pannello Passato
		 * 
		 */
		panel = panelNext;
		panel.setVisible(true);   //Si vede ora!
		
		
		
		
		/*
		 * 
		 * Elementi del pannello
		 * 
		 */
		
		
		labelTitolo = new JLabel();	
		labelTitolo.setFont(new Font("Arial", 0, 20));
		labelTitolo.setBounds(panel.getWidth()/3, panel.getHeight()/200, panel.getWidth()/3, panel.getHeight()/7);
		labelTitolo.setVerticalAlignment(JLabel.CENTER);
		labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		labelTitolo.setText("MOSTRA CATALOGO");
		panel.add(labelTitolo);
		
		areaTesto = new JTextArea();
		areaTesto = new JTextArea(panel.getWidth()/40*39+10, panel.getHeight()/6*3);
		areaTesto.setFont(new Font("Arial", 0, 15));
		areaTesto.setEditable(false);
		areaTesto.setLineWrap(false);
		scrollAreaTesto = new JScrollPane(areaTesto);   //creo un piccolo scroll e lo aggiungo alla text area
		scrollAreaTesto.setBounds(panel.getWidth()/40, panel.getHeight()/7, panel.getWidth()/40*39+10, panel.getHeight()/6*3);
		panel.add(scrollAreaTesto);
		
		
		
		labelAmbiente = new JLabel();        //Etichetta per i mezzi
		labelAmbiente.setFont(new Font("Arial", 0, 15));
		labelAmbiente.setBounds(panel.getWidth()/11-35, panel.getHeight()/6*4, panel.getWidth()/6, 20);
		labelAmbiente.setText("Ambiente");
		panel.add(labelAmbiente);
		
		
		tendinaAmbiente = new JComboBox<String>();	  //Tendina per i mezzi
		tendinaAmbiente.setBackground(Color.WHITE);
		tendinaAmbiente.setEnabled(false);
		tendinaAmbiente.setBounds(panel.getWidth()/11-35, panel.getHeight()/6*4+20, panel.getWidth()/6, 20);
		panel.add(tendinaAmbiente);

		
		
		
		labelMezzi = new JLabel();        //Etichetta per i mezzi
		labelMezzi.setFont(new Font("Arial", 0, 15));
		labelMezzi.setBounds(panel.getWidth()/11*3-35, panel.getHeight()/6*4, panel.getWidth()/6, 20);
		labelMezzi.setText("Mezzo di Trasporto");
		panel.add(labelMezzi);
		
		
		tendinaMezzi = new JComboBox<String>();	  //Tendina per i mezzi
		tendinaMezzi.setBackground(Color.WHITE);
		tendinaMezzi.setEnabled(false);
		tendinaMezzi.setBounds(panel.getWidth()/11*3-35, panel.getHeight()/6*4+20, panel.getWidth()/6, 20);
		panel.add(tendinaMezzi);
		
		
		labelCittaPartenza = new JLabel();        //Etichetta per Stazioni di partenza
		labelCittaPartenza.setFont(new Font("Arial", 0, 15));
		labelCittaPartenza.setBounds(panel.getWidth()/11*5-35, panel.getHeight()/6*4, panel.getWidth()/6, 20);
		labelCittaPartenza.setText("Citta' di Partenza");
		panel.add(labelCittaPartenza);
		
		
		tendinaCittaPartenza = new JComboBox<String>();	 //Tendina per stazioni di partenza
		tendinaCittaPartenza.setBackground(Color.WHITE);
		tendinaCittaPartenza.setBounds(panel.getWidth()/11*5-35, panel.getHeight()/6*4+20, panel.getWidth()/6, 20);
		tendinaCittaPartenza.setEnabled(false);
		panel.add(tendinaCittaPartenza);
		
		
		labelCittaArrivo = new JLabel();        //Etichetta per Stazione di arrivo
		labelCittaArrivo.setFont(new Font("Arial", 0, 15));
		labelCittaArrivo.setBounds(panel.getWidth()/11*7-35, panel.getHeight()/6*4, panel.getWidth()/6, 20);
		labelCittaArrivo.setText("Citta' di Arrivo");
		panel.add(labelCittaArrivo);
		
		
		tendinaCittaArrivo = new JComboBox<String>();	 //Tendina per stazioni di arrivo
		tendinaCittaArrivo.setBackground(Color.WHITE);
		tendinaCittaArrivo.setBounds(panel.getWidth()/11*7-35, panel.getHeight()/6*4+20, panel.getWidth()/6, 20);
		tendinaCittaArrivo.setEnabled(false);
		panel.add(tendinaCittaArrivo);
		
		
		labelVia = new JLabel();	//Etichetta per Stazione intermedia
		labelVia.setFont(new Font("Arial", 0, 15));
		labelVia.setBounds(panel.getWidth()/11*9-35, panel.getHeight()/6*4, panel.getWidth()/6, 20);
		labelVia.setText("Via");
		panel.add(labelVia);
		
		
		tendinaVia = new JComboBox<String>(); //Tendina per stazioni intermedie
		tendinaVia.setBackground(Color.WHITE);
		tendinaVia.setBounds(panel.getWidth()/11*9-35, panel.getHeight()/6*4+20, panel.getWidth()/6, 20);
		tendinaVia.setEnabled(false);
		panel.add(tendinaVia);
		
		
		
		
		
	
		
		labelData = new JLabel();	//Etichetta per Data
		labelData.setFont(new Font("Arial",0,15));
		labelData.setBounds(panel.getWidth()/11*3-35, panel.getHeight()/24*20, panel.getWidth()/12, 20);
		labelData.setText("Data");
		panel.add(labelData);
		
		
		
		
		tendinaGiorno = new JComboBox<Integer>(); //Tendina per giorno
		tendinaGiorno.setBackground(Color.WHITE);
		tendinaGiorno.setBounds(panel.getWidth()/11*3+15, panel.getHeight()/24*20, panel.getWidth()/24, 20);
		tendinaGiorno.setEnabled(false);
		panel.add(tendinaGiorno);
	    
	    
	    
	    labelSlash1 = new JLabel();	//Etichetta elementi data
	    labelSlash1.setFont(new Font("Arial",0,15));
	    labelSlash1.setBounds(panel.getWidth()/11*3+60, panel.getHeight()/24*20, panel.getWidth()/36, 20);
	    labelSlash1.setText("/");
		panel.add(labelSlash1); 
		
		
		
		
		tendinaMese = new JComboBox<Integer>(); //Tendina per mesi
		tendinaMese.setBackground(Color.WHITE);
		tendinaMese.setBounds(panel.getWidth()/11*3+70, panel.getHeight()/24*20, panel.getWidth()/24, 20);
		tendinaMese.setEnabled(false);
		panel.add(tendinaMese);
		
		
		labelSlash2 = new JLabel();	//Etichetta elementi data
		labelSlash2.setFont(new Font("Arial",0,15));
		labelSlash2.setBounds(panel.getWidth()/11*3+115, panel.getHeight()/24*20, panel.getWidth()/36, 20);
		labelSlash2.setText("/");
		panel.add(labelSlash2); 
		
		
		tendinaAnno = new JComboBox<Integer>(); //Tendina per anni
		tendinaAnno.setBackground(Color.WHITE);
		tendinaAnno.setBounds(panel.getWidth()/11*3+125, panel.getHeight()/24*20, panel.getWidth()/18, 20);
		tendinaAnno.setEnabled(false);
		panel.add(tendinaAnno);
		
		
		labelPosti = new JLabel();	//Etichetta elementi ora
	    labelPosti.setFont(new Font("Arial", 0, 15));
	    labelPosti.setBounds(panel.getWidth()/22*12, panel.getHeight()/24*20, panel.getWidth()/12, 20);
	    labelPosti.setText("Posti");
		panel.add(labelPosti);
		
		
	    tendinaPosti = new JComboBox<Integer> (); 
	    tendinaPosti.setBackground(Color.WHITE);
	    tendinaPosti.setBounds(panel.getWidth()/22*12+50, panel.getHeight()/24*20, panel.getWidth()/24, 20);
	    for (int i=1; i<31; i++){
	    	tendinaPosti.addItem(i);
	    }
	    tendinaPosti.setSelectedIndex(0);
	    tendinaPosti.setEnabled(false);
	    panel.add(tendinaPosti); 
		
		
		bottoneSvuota = new JButton("AZZERA CAMPI");
		bottoneSvuota.setBackground(Color.YELLOW);
		bottoneSvuota.setBounds(panel.getWidth()/5-30, panel.getHeight()/6*5+30, panel.getWidth()/5+10, panel.getHeight()/14);
		panel.add(bottoneSvuota);

		bottoneCercaOfferta = new JButton("CERCA OFFERTA");
		bottoneCercaOfferta.setBackground(Color.ORANGE);
		bottoneCercaOfferta.setBounds(panel.getWidth()/5*3+16, panel.getHeight()/6*5+30, panel.getWidth()/5+10, panel.getHeight()/14);
		panel.add(bottoneCercaOfferta);
		
		bottoneChiudi = new JButton("X");
		bottoneChiudi.setBackground(Color.RED);
		bottoneChiudi.setBounds(panel.getWidth()/20*19, 0, panel.getWidth()/20, panel.getHeight()/18);
		panel.add(bottoneChiudi);
		
		
		//Ascoltatori pannello 3
		
		ascoltatoreTendinaAmbiente   = new TendinaAmbienteAA();
		ascoltatoreTendinaMezzi	     = new TendinaMezziAA();
		ascoltatoreTendinaPartenze   = new TendinaPartenzeAA();
		ascoltatoreTendinaArrivi     = new TendinaArriviAA();
		ascoltatoreTendinaVia 		 = new TendinaViaAA();
		ascoltatoreTendinaAnno       = new TendinaAnnoAA();
		ascoltatoreTendinaMese 		 = new TendinaMeseAA();
		ascoltatoreBottoneCercaOfferta		  = new CercaOffertaAA();
		ascoltatoreBottoneChiudi     = new ChiudiAA();
		ascoltatoreBottoneSvuota 	 = new SvuotaAA();
		
		tendinaAmbiente.addActionListener(ascoltatoreTendinaAmbiente);
		tendinaMezzi.addActionListener(ascoltatoreTendinaMezzi);
		tendinaCittaPartenza.addActionListener(ascoltatoreTendinaPartenze);
		tendinaCittaArrivo.addActionListener(ascoltatoreTendinaArrivi);
		tendinaVia.addActionListener(ascoltatoreTendinaVia);
		tendinaAnno.addActionListener(ascoltatoreTendinaAnno);
		tendinaMese.addActionListener(ascoltatoreTendinaMese);
		bottoneCercaOfferta.addActionListener(ascoltatoreBottoneCercaOfferta);
		bottoneChiudi.addActionListener(ascoltatoreBottoneChiudi);
		bottoneSvuota.addActionListener(ascoltatoreBottoneSvuota);
		
		
		
		// dulcis in fundo .... attivo la prima tendina
		aggiornaTendine();
		
		
		
		
		
	}
	
	
	
	// Aggiorna la tendina degli ambienti del secondo pannello
		private void aggiornaTendine() { 
			
			tendinaAmbiente.removeAllItems();
			tendinaAmbiente.setEnabled(false);
								
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
				
				//visualizzo subito il catalogo	
				areaTestoCatalogo = controllore.mostraCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
				areaTesto.setText(areaTestoImp + areaTestoCatalogo);
				areaTesto.setCaretPosition(0);
				
				
    			//imposto l'anno attuale 
				GregorianCalendar data = new GregorianCalendar();
				
				int anno = data.get(Calendar.YEAR);
				
				tendinaAnno.removeAllItems();
				for(int i=0; i<5; i++){
					
					tendinaAnno.addItem(new Integer(anno+i));
					
				}
				
						
			} catch (MappaException e) {
				areaTesto.setText(e.getMessage()+"\n");
			} catch (IDEsternoElementoException e) {
				areaTesto.setText(e.getMessage()+"\n");
			} catch (TrattaInesistenteException e) {
				areaTesto.setText(e.getMessage()+"\n");
			} 

		}
		
		private void svuotaPartePannello(){
    		
    		
    		tendinaAnno.setEnabled(false);
    		//imposto l'anno attuale
			GregorianCalendar data = new GregorianCalendar();
			//aumento la data attuale di una settimana
			data.add(Calendar.MINUTE, 10080);
			
			int anno = data.get(Calendar.YEAR);
			
			tendinaAnno.removeAllItems();
			for(int i=0; i<5; i++){
				
				tendinaAnno.addItem(new Integer(anno+i));
				
			}
			tendinaGiorno.setSelectedItem(0);
			tendinaGiorno.setEnabled(false);
			
			tendinaMese.setSelectedIndex(0);
			tendinaMese.setEnabled(false);
			
			tendinaAnno.setSelectedIndex(0);
			tendinaAnno.setEnabled(false);
			
			tendinaPosti.setSelectedIndex(0);
			tendinaPosti.setEnabled(false);
			
			areaTesto.setText("");
			areaTesto.setCaretPosition(0);
    	}
	
	
	
	
	
	
	
	/*
	 * Ascoltatori per elementi pannello 
	 */
	
	
	private class TendinaAmbienteAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			svuotaPartePannello();
			
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
					
					//Aggiorno l'area testo che mostra il catalogo
					try {
						
						areaTestoCatalogo = controllore.mostraCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
						areaTesto.setText(areaTestoImp + areaTestoCatalogo);
						areaTesto.setCaretPosition(0);
						
					} catch (MappaException e1) {
						areaTesto.setText(e1.getMessage()+"\n");
					} catch (IDEsternoElementoException e1) {
						areaTesto.setText(e1.getMessage()+"\n");
					} catch (TrattaInesistenteException e1) {
						areaTesto.setText(e1.getMessage()+"\n");
					}
	
			}
		
		}
		
	}
	
	
	private class TendinaMezziAA implements ActionListener{
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			svuotaPartePannello();
			
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
				
				//Aggiorno l'area testo che mostra il catalogo
				try {
					
					areaTestoCatalogo = controllore.mostraCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
					areaTesto.setText(areaTestoImp + areaTestoCatalogo);		
					areaTesto.setCaretPosition(0);
				
				} catch (MappaException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				} catch (IDEsternoElementoException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				} catch (TrattaInesistenteException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				}
						
	
			}
		
		}
		
	}
	
	private class TendinaPartenzeAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			svuotaPartePannello();
			
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
	
				//Aggiorno l'area testo che mostra il catalogo
				try {
					
					areaTestoCatalogo = controllore.mostraCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
					areaTesto.setText(areaTestoImp + areaTestoCatalogo);
					areaTesto.setCaretPosition(0);
					
				} catch (MappaException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				} catch (IDEsternoElementoException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				} catch (TrattaInesistenteException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				}
			
			}
			
		}
		
	}
	
	private class TendinaArriviAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			svuotaPartePannello();
			
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
	
				//Aggiorno l'area testo che mostra il catalogo
				try {
					
					areaTestoCatalogo = controllore.mostraCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
					areaTesto.setText(areaTestoImp + areaTestoCatalogo);
					areaTesto.setCaretPosition(0);
					
				} catch (MappaException e1) {
					areaTesto.setText(e1.getMessage()+"\n");	
				} catch (IDEsternoElementoException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				} catch (TrattaInesistenteException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				}
			
			}
			
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			
			if (tendinaCittaArrivo.getItemCount() != 0) {
				//Aggiorno l'area testo che mostra il catalogo
				try {
					
					areaTestoCatalogo = controllore.mostraCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
					areaTesto.setText(areaTestoImp + areaTestoCatalogo);
					areaTesto.setCaretPosition(0);
				} catch (MappaException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				} catch (IDEsternoElementoException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				} catch (TrattaInesistenteException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				}
				
			}
			
			
		}
		
	}
	
	
	private class TendinaViaAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			svuotaPartePannello();
			
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			viaScelta = (String) tendinaVia.getSelectedItem();
			
			if (tendinaVia.getItemCount() != 0) {
				//Aggiorno l'area testo che mostra il catalogo
				try {
					
					tendinaGiorno.setEnabled(true);
					tendinaMese.setEnabled(true);
					tendinaAnno.setEnabled(true);
					tendinaPosti.setEnabled(true);
					
					areaTestoCatalogo = controllore.mostraCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
					areaTesto.setText(areaTestoImp + areaTestoCatalogo);
					areaTesto.setCaretPosition(0);
				} catch (MappaException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				} catch (IDEsternoElementoException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				} catch (TrattaInesistenteException e1) {
					areaTesto.setText(e1.getMessage()+"\n");
				}
				
			}
			
		}
		
	}
	
	private class TendinaAnnoAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (tendinaAnno.getItemCount() != 0) {
				int anno = (int) tendinaAnno.getSelectedItem();
				
				GregorianCalendar data = new GregorianCalendar();
				
				int annoAttuale = data.get(Calendar.YEAR);
				
				if (anno == annoAttuale){
					
					int mese = (data.get(Calendar.MONTH))+1;
					
					tendinaMese.removeAllItems();
					
					for (int i = mese; i<13; i++){
						tendinaMese.addItem(new Integer(i));
					}
					
				} else {
					tendinaMese.removeAllItems();
					for (int i=1; i<13; i++){
						tendinaMese.addItem(new Integer(i));
					}
				}
			}
			
			
			
		}
		
	}
	
	
	private class TendinaMeseAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//prendo la data attuale e l'aumento di una settimana:
			GregorianCalendar data = new GregorianCalendar();
			
			
			int annoAttuale = data.get(Calendar.YEAR);
			int meseAttuale = (data.get(Calendar.MONTH))+1;
			
			
			int anno = (int) tendinaAnno.getSelectedItem();
			
			if (tendinaMese.getItemCount() != 0){
				
				
				int mese = (int) tendinaMese.getSelectedItem();
				
				if (annoAttuale == anno && meseAttuale == mese){
					//nel caso in cui siamo al mese e anno attuale
					int giornoAttuale = data.get(Calendar.DAY_OF_MONTH);
					
					if (mese == 11 || mese == 4 || mese == 6 || mese == 9){
						tendinaGiorno.removeAllItems();
						
						for (int i=giornoAttuale; i<31; i++){
							tendinaGiorno.addItem(new Integer(i));
						}
					}
					
					if (mese == 2){
						if (anno % 4 == 0){ // è bisestile
							
							tendinaGiorno.removeAllItems();
							
							for (int i=giornoAttuale; i<30; i++){
								tendinaGiorno.addItem(new Integer(i));
							}
						} else {
							tendinaGiorno.removeAllItems();
							
							for (int i=giornoAttuale; i<29; i++){
								tendinaGiorno.addItem(new Integer(i));
							}
						}
					}
					
					if (mese == 1 || mese == 3 || mese==5 || mese==7 || mese==8 || mese==10 || mese==12){
						tendinaGiorno.removeAllItems();
						
						for (int i=giornoAttuale; i<32; i++){
							tendinaGiorno.addItem(new Integer(i));
						}
					}
				} else {
					//In questo caso non siamo nell'anno o nel mese attuale
					
					if (mese == 11 || mese == 4 || mese == 6 || mese == 9){
						tendinaGiorno.removeAllItems();
						
						for (int i=1; i<31; i++){
							tendinaGiorno.addItem(new Integer(i));
						}
					}
					
					if (mese == 2){
						if (anno % 4 == 0){ // è bisestile
							
							tendinaGiorno.removeAllItems();
							
							for (int i=1; i<30; i++){
								tendinaGiorno.addItem(new Integer(i));
							}
						} else {
							tendinaGiorno.removeAllItems();
							
							for (int i=1; i<29; i++){
								tendinaGiorno.addItem(new Integer(i));
							}
						}
					}
					
					if (mese == 1 || mese == 3 || mese==5 || mese==7 || mese==8 || mese==10 || mese==12){
						tendinaGiorno.removeAllItems();
						
						for (int i=1; i<32; i++){
							tendinaGiorno.addItem(new Integer(i));
						}
					}
				}
				
				
				
			}
			
			
			
		}
		
	}
	
	
	private class CercaOffertaAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
//			if (tendinaVia.getItemCount() != 0 && !viaScelta.equals("-----")){
//				
//				String via = (String) tendinaVia.getSelectedItem();
//				
//				// chiedo conferma
//				int conferma = JOptionPane.showConfirmDialog(null, "Rimuovere il viaggio dal catalogo?", "Conferma Rimozione Viaggio", JOptionPane.YES_NO_OPTION);
//				if (conferma == JOptionPane.YES_OPTION){
//					
//					// rimuovo il viaggio
//					try {
//						controllore.rimuoviViaggio(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, via);
//						JOptionPane.showMessageDialog(null, "Il viaggio e' stato rimosso correttamente dal catalogo.", "Viaggio Rimosso", JOptionPane.INFORMATION_MESSAGE);
//						//aggiorno tutti i campi dopo aver rimosso il viaggio
//						aggiornaTendine();
//					} catch (IDEsternoElementoException e1) {
//						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
//					} catch (TrattaInesistenteException e1) {
//						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
//					} catch (OffertaException e1) {
//						JOptionPane.showMessageDialog(null, e1.getMessage(), "Attenzione!", JOptionPane.WARNING_MESSAGE);
//					}
//					
//				}
//					
//			} else {
//				JOptionPane.showMessageDialog(null, "Nessun viaggio selezionato!");
//			}
			
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

				}
				
				
				
				
		//	} else {
		//		JOptionPane.showMessageDialog(null, "Nessun viaggio in catalogo!", "Catalogo Vuoto", JOptionPane.INFORMATION_MESSAGE);
			}
			
			svuotaPartePannello();

		}
		
	}
	
	private class ChiudiAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			panel.setVisible(false); 					//chiude questo pannello
			BoundaryVisitatore_InfoViaggi.riattivaBottoni();
			
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
			
			svuotaPartePannello();

		}
	}

}
