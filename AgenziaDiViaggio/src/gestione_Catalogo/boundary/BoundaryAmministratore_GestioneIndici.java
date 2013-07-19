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




import gestione_Catalogo.control.ControlloreGestioneIndici;
import gestione_Catalogo.exception.CalcoloIndiceException;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.MappaException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.OfferteNonPresentiException;
import gestione_Catalogo.exception.PrenotazioneInesistenteException;
import gestione_Catalogo.exception.TrattaInesistenteException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryAmministratore_GestioneIndici {

	
	
	private ControlloreGestioneIndici controllore;
	private String ambienteScelto;
	private String mezzoScelto;
	private String partenzaScelta;
	private String arrivoScelto;
	private String viaScelta;
	private String offertaScelta;
	private String numeratore;
	private String denominatore;
	private String prenotazioneScelta;
	private String metodoScelto;
	
	
	private static final String TOTALE = "Totale";
	private static final String AMBIENTE = "Ambiente";
	private static final String MEZZO = "Mezzo";
	private static final String TIPOMEZZO = "Tipo Mezzo";
	private static final String TRATTA = "Tratta";
	private static final String OFFERTA = "Offerta";
	private static final String PRENOTAZIONE = "Prenotazione";
	
	
	//Pannelli
	private JPanel panel;
	
	
	//Elementi Pannello
	
	private JLabel		 labelTitolo;
	
	private JRadioButton radioTotale;
	private JRadioButton radioAnnuale;
	private JRadioButton radioUltimaOfferta;

	private ButtonGroup gruppoRadioButton;
	
	
	private JLabel labelAmbiente;
	private JComboBox<String> tendinaAmbiente;
	
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
	
	private JLabel labelIndiceGradimento;
	
	private JComboBox<String> tendinaNumeratore;
	private JComboBox<String> tendinaDenominatore;
	
	private JLabel	labelPercentuale;
	private JTextField campoIndiceGradimento;
	
	private JButton	bottoneCalcolaIndiceGradimento;
	private JButton bottoneChiudi;
	private JButton bottoneSvuota;
	

	
	private RadioButtonTotaleAA ascoltatoreRadioButtonTotale;
	private RadioButtonAnnualeAA ascoltatoreRadioButtonAnnuale;
	private RadioButtonUltimaOffertaAA ascoltatoreRadioButtonUltimaOfferta;
	
	private TendinaAmbienteAA ascoltatoreTendinaAmbiente;
	private TendinaMezziAA ascoltatoreTendinaMezzi;
	private TendinaPartenzeAA ascoltatoreTendinaPartenze;
	private TendinaArriviAA ascoltatoreTendinaArrivi;
	private TendinaViaAA ascoltatoreTendinaVia;
	private TendinaOfferteAA ascoltatoreTendinaOfferte;
	private TendinaPrenotazioniAA ascoltatoreTendinaPrenotazioni;
	private TendinaNumeratoreAA ascoltatoreTendinaNumeratore;
	private TendinaDenominatoreAA ascoltatoreTendinaDenominatore;
	
	private ChiudiAA ascoltatoreBottoneChiudi;
	private SvuotaAA ascoltatoreBottoneSvuota;
	private CalcolaIndiceGradimentoAA ascoltatoreBottoneCalcolaIndiceGradimento;
		
		
	public BoundaryAmministratore_GestioneIndici(JPanel panelNext) {


		ambienteScelto = null;
		mezzoScelto = null;
		partenzaScelta = null;
		arrivoScelto = null;
		viaScelta = null;
		metodoScelto = null;
		offertaScelta = null;
		prenotazioneScelta = null;
		numeratore = null;
		denominatore = null;
		controllore = new ControlloreGestioneIndici();
		
		
		/*
		 * 
		 * Il superPanel di questa Boundary prende le dimensioni del pannello Passato
		 * 
		 */
		panel = panelNext;
		panel.setVisible(true);   //Si vede ora!
		
		
		
		/*
		 * 
		 * Elementi pannello
		 * 
		 */
		
		labelTitolo = new JLabel();	
		labelTitolo.setFont(new Font("Arial", 0, 20));
		labelTitolo.setBounds(panel.getWidth()/3, panel.getHeight()/49, panel.getWidth()/3, panel.getHeight()/7);
		labelTitolo.setVerticalAlignment(JLabel.CENTER);
		labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		labelTitolo.setText("GESTIONE INDICI");
		panel.add(labelTitolo);
		
		
		
		
		radioTotale = new JRadioButton("TOTALI");
		radioTotale.setBounds(panel.getWidth()/7+100, panel.getHeight()/6, panel.getWidth()/7, panel.getHeight()/14);
		panel.add(radioTotale);   //aggiungo il radiobutton al pannello 1
		
		radioAnnuale = new JRadioButton("ANNUALI");
		radioAnnuale.setBounds(panel.getWidth()/7*3, panel.getHeight()/6, panel.getWidth()/7, panel.getHeight()/14);
		panel.add(radioAnnuale);
		
		radioUltimaOfferta = new JRadioButton("ULTIMA OFFERTA");
		radioUltimaOfferta.setBounds(panel.getWidth()/7*5-100, panel.getHeight()/6, panel.getWidth()/7, panel.getHeight()/14);
		panel.add(radioUltimaOfferta);
		
		gruppoRadioButton = new ButtonGroup();
		gruppoRadioButton.add(radioTotale);
		gruppoRadioButton.add(radioAnnuale);
		gruppoRadioButton.add(radioUltimaOfferta);   //Ora solo uno di questi 3 e' selezionabile
		
		
		
		
		labelAmbiente = new JLabel();        //Etichetta per i mezzi
		labelAmbiente.setFont(new Font("Arial", 0, 15));
		labelAmbiente.setBounds(panel.getWidth()/11-35, panel.getHeight()/6*2, panel.getWidth()/6, 20);
		labelAmbiente.setText("Ambiente");
		panel.add(labelAmbiente);
		
		
		tendinaAmbiente = new JComboBox<String>();	  //Tendina per i mezzi
		tendinaAmbiente.setBackground(Color.WHITE);
		tendinaAmbiente.setEnabled(false);
		tendinaAmbiente.setBounds(panel.getWidth()/11-35, panel.getHeight()/6*2+20, panel.getWidth()/6, 20);
		panel.add(tendinaAmbiente);

		
		
		
		labelMezzi = new JLabel();        //Etichetta per i mezzi
		labelMezzi.setFont(new Font("Arial", 0, 15));
		labelMezzi.setBounds(panel.getWidth()/11*3-35, panel.getHeight()/6*2, panel.getWidth()/6, 20);
		labelMezzi.setText("Mezzo di Trasporto");
		panel.add(labelMezzi);
		
		
		tendinaMezzi = new JComboBox<String>();	  //Tendina per i mezzi
		tendinaMezzi.setBackground(Color.WHITE);
		tendinaMezzi.setEnabled(false);
		tendinaMezzi.setBounds(panel.getWidth()/11*3-35, panel.getHeight()/6*2+20, panel.getWidth()/6, 20);
		panel.add(tendinaMezzi);
		
		
		labelCittaPartenza = new JLabel();        //Etichetta per Stazioni di partenza
		labelCittaPartenza.setFont(new Font("Arial", 0, 15));
		labelCittaPartenza.setBounds(panel.getWidth()/11*5-35, panel.getHeight()/6*2, panel.getWidth()/6, 20);
		labelCittaPartenza.setText("Citta' di Partenza");
		panel.add(labelCittaPartenza);
		
		
		tendinaCittaPartenza = new JComboBox<String>();	 //Tendina per stazioni di partenza
		tendinaCittaPartenza.setBackground(Color.WHITE);
		tendinaCittaPartenza.setBounds(panel.getWidth()/11*5-35, panel.getHeight()/6*2+20, panel.getWidth()/6, 20);
		tendinaCittaPartenza.setEnabled(false);
		panel.add(tendinaCittaPartenza);
		
		
		labelCittaArrivo = new JLabel();        //Etichetta per Stazione di arrivo
		labelCittaArrivo.setFont(new Font("Arial", 0, 15));
		labelCittaArrivo.setBounds(panel.getWidth()/11*7-35, panel.getHeight()/6*2, panel.getWidth()/6, 20);
		labelCittaArrivo.setText("Citta' di Arrivo");
		panel.add(labelCittaArrivo);
		
		
		tendinaCittaArrivo = new JComboBox<String>();	 //Tendina per stazioni di arrivo
		tendinaCittaArrivo.setBackground(Color.WHITE);
		tendinaCittaArrivo.setBounds(panel.getWidth()/11*7-35, panel.getHeight()/6*2+20, panel.getWidth()/6, 20);
		tendinaCittaArrivo.setEnabled(false);
		panel.add(tendinaCittaArrivo);
		
		
		labelVia = new JLabel();	//Etichetta per Stazione intermedia
		labelVia.setFont(new Font("Arial", 0, 15));
		labelVia.setBounds(panel.getWidth()/11*9-35, panel.getHeight()/6*2, panel.getWidth()/6, 20);
		labelVia.setText("Via");
		panel.add(labelVia);
		
		
		tendinaVia = new JComboBox<String>(); //Tendina per stazioni intermedie
		tendinaVia.setBackground(Color.WHITE);
		tendinaVia.setBounds(panel.getWidth()/11*9-35, panel.getHeight()/6*2+20, panel.getWidth()/6, 20);
		tendinaVia.setEnabled(false);
		panel.add(tendinaVia);
		
		
		
		labelOfferta = new JLabel();	//Etichetta elementi data
		labelOfferta.setFont(new Font("Arial",0,15));
		labelOfferta.setBounds(panel.getWidth()/5, panel.getHeight()/6*2+60, panel.getWidth()/4, 20);
		labelOfferta.setText("Offerta");
		//panel.add(labelOfferta);           //Decommentare per aggiungere tendina in caso di ulteriori livelli calcolo indici
		
		
		
		tendinaOfferta = new JComboBox<String>(); //Tendina per stazioni intermedie
		tendinaOfferta.setBackground(Color.WHITE);
		tendinaOfferta.setBounds(panel.getWidth()/5, panel.getHeight()/6*2+80, panel.getWidth()/4, 20);
		tendinaOfferta.setEnabled(false);
		//panel.add(tendinaOfferta);         //Decommentare per aggiungere tendina in caso di ulteriori livelli calcolo indici
		
		
		
		labelPrenotazione = new JLabel();
		labelPrenotazione.setFont(new Font("Arial",0,15));
		labelPrenotazione.setBounds(panel.getWidth()/5*3, panel.getHeight()/6*2+60,panel.getWidth()/6, 20);
		labelPrenotazione.setText("Prenotazione");
		//panel.add(labelPrenotazione);      //Decommentare per aggiungere tendina in caso di ulteriori livelli calcolo indici
		
		
		tendinaPrenotazione = new JComboBox<String>();
		tendinaPrenotazione.setBackground(Color.WHITE);
		tendinaPrenotazione.setBounds(panel.getWidth()/5*3, panel.getHeight()/6*2+80, panel.getWidth()/4, 20);
		tendinaPrenotazione.setEnabled(false);
		//panel.add(tendinaPrenotazione);    //Decommentare per aggiungere tendina in caso di ulteriori livelli calcolo indici
		
		
		labelIndiceGradimento = new JLabel();        //Etichetta per Stazione di arrivo
		labelIndiceGradimento.setFont(new Font("Arial", 0, 15));
		labelIndiceGradimento.setBounds(panel.getWidth()/6-50, panel.getHeight()/6*4, panel.getWidth()/4, 20);
		labelIndiceGradimento.setText("Indice   ------------------------------------");
		panel.add(labelIndiceGradimento);
		
		
		tendinaNumeratore = new JComboBox<String>();
		tendinaNumeratore.setBackground(Color.WHITE);
		tendinaNumeratore.setBounds(panel.getWidth()/6, panel.getHeight()/6*4-30, panel.getWidth()/6, 20);
		tendinaNumeratore.setEnabled(false);
		panel.add(tendinaNumeratore);
		
		tendinaDenominatore = new JComboBox<String>();
		tendinaDenominatore.setBackground(Color.WHITE);
		tendinaDenominatore.setBounds(panel.getWidth()/6, panel.getHeight()/6*4+30, panel.getWidth()/6, 20);
		tendinaDenominatore.setEnabled(false);
		panel.add(tendinaDenominatore);
		
		bottoneCalcolaIndiceGradimento = new JButton("Calcola Gradimento");
		bottoneCalcolaIndiceGradimento.setBackground(Color.ORANGE);
		bottoneCalcolaIndiceGradimento.setBounds(panel.getWidth()/6*3, panel.getHeight()/6*4-30, panel.getWidth()/6, panel.getHeight()/12);
		panel.add(bottoneCalcolaIndiceGradimento);
		
		
		campoIndiceGradimento = new JTextField(panel.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
		campoIndiceGradimento.setFont(new Font("Arial", 0, 18));
		campoIndiceGradimento.setBounds(panel.getWidth()/18*10, panel.getHeight()/6*4+30, panel.getWidth()/18, 20);
		campoIndiceGradimento.setEditable(false);   				// all'inizio e' disattivato, si attiva solo con new...
		panel.add(campoIndiceGradimento);
		
		labelPercentuale = new JLabel();
		labelPercentuale.setFont(new Font("Arial",0,15));
		labelPercentuale.setBounds(panel.getWidth()/18*11, panel.getHeight()/6*4+30,panel.getWidth()/18, 20);
		labelPercentuale.setText("%");
		panel.add(labelPercentuale);
		
		
		
		
		bottoneSvuota = new JButton("AZZERA CAMPI");
		bottoneSvuota.setBackground(Color.YELLOW);
		bottoneSvuota.setBounds(panel.getWidth()/5*2, panel.getHeight()/6*5, panel.getWidth()/5, panel.getHeight()/12);
		panel.add(bottoneSvuota);
		
		
		
		bottoneChiudi = new JButton("X");
		bottoneChiudi.setBackground(Color.RED);
		bottoneChiudi.setBounds(panel.getWidth()/20*19, 0, panel.getWidth()/20, panel.getHeight()/18);
		panel.add(bottoneChiudi);
		
		
		
		
		ascoltatoreRadioButtonTotale		  = new RadioButtonTotaleAA();
		ascoltatoreRadioButtonAnnuale		  = new RadioButtonAnnualeAA();
		ascoltatoreRadioButtonUltimaOfferta	  = new RadioButtonUltimaOffertaAA();
		ascoltatoreTendinaAmbiente   = new TendinaAmbienteAA();
		ascoltatoreTendinaMezzi	  = new TendinaMezziAA();
		ascoltatoreTendinaPartenze   = new TendinaPartenzeAA();
		ascoltatoreTendinaArrivi     = new TendinaArriviAA();
		ascoltatoreTendinaVia 		  = new TendinaViaAA();
		ascoltatoreTendinaOfferte = new TendinaOfferteAA();
		ascoltatoreTendinaPrenotazioni = new TendinaPrenotazioniAA();
		ascoltatoreTendinaNumeratore = new TendinaNumeratoreAA();
		ascoltatoreTendinaDenominatore = new TendinaDenominatoreAA();
		ascoltatoreBottoneChiudi = new ChiudiAA();
		ascoltatoreBottoneSvuota = new SvuotaAA();
		ascoltatoreBottoneCalcolaIndiceGradimento = new CalcolaIndiceGradimentoAA();
		
		
		
		radioTotale.addActionListener(ascoltatoreRadioButtonTotale);
		radioAnnuale.addActionListener(ascoltatoreRadioButtonAnnuale);
		radioUltimaOfferta.addActionListener(ascoltatoreRadioButtonUltimaOfferta);
		tendinaAmbiente.addActionListener(ascoltatoreTendinaAmbiente);
		tendinaMezzi.addActionListener(ascoltatoreTendinaMezzi);
		tendinaCittaPartenza.addActionListener(ascoltatoreTendinaPartenze);
		tendinaCittaArrivo.addActionListener(ascoltatoreTendinaArrivi);
		tendinaVia.addActionListener(ascoltatoreTendinaVia);
		tendinaOfferta.addActionListener(ascoltatoreTendinaOfferte);
		tendinaPrenotazione.addActionListener(ascoltatoreTendinaPrenotazioni);
		tendinaNumeratore.addActionListener(ascoltatoreTendinaNumeratore);
		tendinaDenominatore.addActionListener(ascoltatoreTendinaDenominatore);
		bottoneChiudi.addActionListener(ascoltatoreBottoneChiudi);
		bottoneSvuota.addActionListener(ascoltatoreBottoneSvuota);
		bottoneCalcolaIndiceGradimento.addActionListener(ascoltatoreBottoneCalcolaIndiceGradimento);
		
		
		
		
		
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
				

				
			} catch (MappaException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			} 

		}
	
	
	
	
	private class RadioButtonTotaleAA implements ActionListener{
		
		/*
		 *  Quando premo il bottone via Aria
		 */

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			metodoScelto = "Totale";			//Cambia l'ambiente scelto
			aggiornaTendine();
		}
	
	}


	private class RadioButtonAnnualeAA implements ActionListener{
		
		/*
		 *  Quando premo il bottone via Mare
		 */

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			metodoScelto = "Annuale"; 			//Cambia l'ambiente scelto
			aggiornaTendine();
		}
		
	}
	
	private class RadioButtonUltimaOffertaAA implements ActionListener{
		
		/*
		 *  Quando premo il bottone via Terra
		 */

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			metodoScelto = "UltimaOfferta"; 			//Cambia l'ambiente scelto
			aggiornaTendine();
		}
		
	}
	
	
	private class TendinaAmbienteAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			campoIndiceGradimento.setText("");
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaMezzi.removeAllItems();
			tendinaMezzi.setEnabled(false);
			
			//prendo il valore di questa tendina
			ambienteScelto	= (String)tendinaAmbiente.getSelectedItem();
			
			if (tendinaAmbiente.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
			
					
					if(!ambienteScelto.equals("-----")){ //Solo se non e' l'elemento neutro
						
						//inserisco l'elemento interessato nella tendina numeratore
						tendinaNumeratore.removeAllItems();
						tendinaNumeratore.setEnabled(false);
						tendinaNumeratore.addItem("-----");
						tendinaNumeratore.addItem(AMBIENTE);
						tendinaNumeratore.setSelectedItem(0);
						tendinaNumeratore.setEnabled(true);
							
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
							
							
						} catch (DirittiException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						} catch (IDEsternoElementoException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						tendinaNumeratore.removeAllItems();
						tendinaNumeratore.setEnabled(false);
					}
	
			}
		
		}
		
	}
	
	
	private class TendinaMezziAA implements ActionListener{
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			campoIndiceGradimento.setText("");
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaCittaPartenza.removeAllItems();
			tendinaCittaPartenza.setEnabled(false);
			
			//prendo il valore delle altre tendina
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();   //Neanche servirebbe, in teoria...
			mezzoScelto = (String)tendinaMezzi.getSelectedItem();
			
			if (tendinaMezzi.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
	
				if(!mezzoScelto.equals("-----")){ //Solo se non e' l'elemento neutro
					
					//inserisco l'elemento interessato nella tendina numeratore
					tendinaNumeratore.removeAllItems();
					tendinaNumeratore.setEnabled(false);
					tendinaNumeratore.addItem("-----");
					tendinaNumeratore.addItem(AMBIENTE);
					tendinaNumeratore.addItem(TIPOMEZZO);
					tendinaNumeratore.addItem(MEZZO);
					tendinaNumeratore.setSelectedItem(0);
					tendinaNumeratore.setEnabled(true);
					
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
						
						
						
					} catch (DirittiException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}   
				} else {
					
					tendinaNumeratore.removeAllItems();
					tendinaNumeratore.setEnabled(false);
					tendinaNumeratore.addItem("-----");
					tendinaNumeratore.addItem(AMBIENTE);
					tendinaNumeratore.setSelectedItem(0);
					tendinaNumeratore.setEnabled(true);
				}
						
	
			}
		
		}
		
	}
	
	private class TendinaPartenzeAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			campoIndiceGradimento.setText("");
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaCittaArrivo.removeAllItems();
			tendinaCittaArrivo.setEnabled(false);
			
			//prendo il valore delle altre tendina
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			
			if (tendinaCittaPartenza.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
				
				if(!partenzaScelta.equals("-----")){ //Solo se non e' l'elemento neutro
					
					//inserisco l'elemento interessato nella tendina numeratore
					tendinaNumeratore.removeAllItems();
					tendinaNumeratore.setEnabled(false);
					tendinaNumeratore.addItem("-----");
					tendinaNumeratore.addItem(AMBIENTE);
					tendinaNumeratore.addItem(TIPOMEZZO);
					tendinaNumeratore.addItem(MEZZO);
					tendinaNumeratore.setSelectedItem(0);
					tendinaNumeratore.setEnabled(true);
					
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
						
						
						
						
					} catch (DirittiException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}
					
					
				} else {
					//inserisco l'elemento interessato nella tendina numeratore
					tendinaNumeratore.removeAllItems();
					tendinaNumeratore.setEnabled(false);
					tendinaNumeratore.addItem("-----");
					tendinaNumeratore.addItem(AMBIENTE);
					tendinaNumeratore.addItem(TIPOMEZZO);
					tendinaNumeratore.addItem(MEZZO);
					tendinaNumeratore.setSelectedItem(0);
					tendinaNumeratore.setEnabled(true);
				}
			
			}
			
		}
		
	}
	
	private class TendinaArriviAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			campoIndiceGradimento.setText("");
			
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
					
					//inserisco l'elemento interessato nella tendina numeratore
					tendinaNumeratore.removeAllItems();
					tendinaNumeratore.setEnabled(false);
					tendinaNumeratore.addItem("-----");
					tendinaNumeratore.addItem(AMBIENTE);
					tendinaNumeratore.addItem(TIPOMEZZO);
					tendinaNumeratore.addItem(MEZZO);
					tendinaNumeratore.setSelectedItem(0);
					tendinaNumeratore.setEnabled(true);
					
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
						
					} catch (DirittiException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}
					
					
				} else {
					//inserisco l'elemento interessato nella tendina numeratore
					tendinaNumeratore.removeAllItems();
					tendinaNumeratore.setEnabled(false);
					tendinaNumeratore.addItem("-----");
					tendinaNumeratore.addItem(AMBIENTE);
					tendinaNumeratore.addItem(TIPOMEZZO);
					tendinaNumeratore.addItem(MEZZO);
					tendinaNumeratore.setSelectedItem(0);
					tendinaNumeratore.setEnabled(true);
				}
	
				
			}
			
			
		}
		
	}
	
	
	private class TendinaViaAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			campoIndiceGradimento.setText("");
			
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			viaScelta = (String) tendinaVia.getSelectedItem();
			

			//Svuoto tutte le tendine e l'area testo
			tendinaOfferta.removeAllItems();
			tendinaOfferta.setEnabled(false);
			
			offertaScelta = "-----";
			
			
			if (tendinaVia.getItemCount() != 0) {
				
					
					if (!viaScelta.equals("-----")){
						
						
						//inserisco l'elemento interessato nella tendina numeratore
						tendinaNumeratore.removeAllItems();
						tendinaNumeratore.setEnabled(false);
						tendinaNumeratore.addItem("-----");
						tendinaNumeratore.addItem(AMBIENTE);
						tendinaNumeratore.addItem(TIPOMEZZO);
						tendinaNumeratore.addItem(MEZZO);
						tendinaNumeratore.addItem(TRATTA);
						tendinaNumeratore.setSelectedItem(0);
						tendinaNumeratore.setEnabled(true);
						
//						try {   //Decommentare per aggiungere tendina in caso di ulteriori livelli calcolo indici
//							
//						
//							ArrayList<String> listaOfferte = controllore.mostraOfferteValidePerLaTratta(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
//							
//							
//							//inserisco l'elemento neutro
//							tendinaOfferta.addItem("-----");
//					
//						    
//							for(String d : listaOfferte){
//								//inserisco l'elemento in tendina
//								tendinaOfferta.addItem(d);
//							}
//						    
//							tendinaOfferta.setEnabled(true);
//							tendinaOfferta.setSelectedIndex(0);
//						
//	
//						
//						} catch (DirittiException e1) {
//							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
//						} catch (IDEsternoElementoException e1) {
//							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
//						} catch (OfferteNonPresentiException e) {
//							JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
//						}  
					
						
					} else {
						//inserisco l'elemento interessato nella tendina numeratore
						tendinaNumeratore.removeAllItems();
						tendinaNumeratore.setEnabled(false);
						tendinaNumeratore.addItem("-----");
						tendinaNumeratore.addItem(AMBIENTE);
						tendinaNumeratore.addItem(TIPOMEZZO);
						tendinaNumeratore.addItem(MEZZO);
						tendinaNumeratore.setSelectedItem(0);
						tendinaNumeratore.setEnabled(true);
					}
					

			} 
					
			
			
		

		}
		
	}
	
	
	private class TendinaOfferteAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			campoIndiceGradimento.setText("");
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaPrenotazione.removeAllItems();
			tendinaPrenotazione.setEnabled(false);
			
			
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			offertaScelta = (String) tendinaOfferta.getSelectedItem();
			
		
				
				if (tendinaOfferta.getItemCount() != 0 && !offertaScelta.equals("-----")){
			
					if(!offertaScelta.equals("-----")){	
						
						//inserisco l'elemento interessato nella tendina numeratore
						tendinaNumeratore.removeAllItems();
						tendinaNumeratore.setEnabled(false);
						tendinaNumeratore.addItem("-----");
						tendinaNumeratore.addItem(AMBIENTE);
						tendinaNumeratore.addItem(TIPOMEZZO);
						tendinaNumeratore.addItem(MEZZO);
						tendinaNumeratore.addItem(TRATTA);
						tendinaNumeratore.addItem(OFFERTA);
						tendinaNumeratore.setSelectedItem(0);
						tendinaNumeratore.setEnabled(true);
						
						
						try {
						
						//cerca nella mappa tutte le chiavi da aggiungere in tendina
						Set<String> s = controllore.mostraPrenotazioniPerOfferta(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta, offertaScelta);
						Iterator<String> it = s.iterator();
						
						
						
						//inserisco l'elemento neutro
						tendinaPrenotazione.addItem("-----");
						
						
						while(it.hasNext()){ 	//itero l'insieme di chiavi
							String str = it.next();
							tendinaPrenotazione.addItem(str);    //ne aggiungo uno alla volta
						}
						
						tendinaPrenotazione.setEnabled(true);
						tendinaPrenotazione.setSelectedIndex(0);
					    } catch (DirittiException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						} catch (IDEsternoElementoException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						} catch (ParseException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						} catch (OffertaInesistenteException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						} catch (PrenotazioneInesistenteException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						} 
				
						
			} else {
				//inserisco l'elemento interessato nella tendina numeratore
				tendinaNumeratore.removeAllItems();
				tendinaNumeratore.setEnabled(false);
				tendinaNumeratore.addItem("-----");
				tendinaNumeratore.addItem(AMBIENTE);
				tendinaNumeratore.addItem(TIPOMEZZO);
				tendinaNumeratore.addItem(MEZZO);
				tendinaNumeratore.addItem(TRATTA);
				tendinaNumeratore.setSelectedItem(0);
				tendinaNumeratore.setEnabled(true);
			}
			
		}
		
	}
		
}
	
	private class TendinaPrenotazioniAA implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			
			campoIndiceGradimento.setText("");
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			viaScelta = (String) tendinaVia.getSelectedItem();
			offertaScelta = (String) tendinaOfferta.getSelectedItem();
			prenotazioneScelta = (String) tendinaPrenotazione.getSelectedItem();
		
			if (tendinaOfferta.getItemCount() != 0 && !offertaScelta.equals("-----")){
				
				if(!offertaScelta.equals("-----")){	
					
					//inserisco l'elemento interessato nella tendina numeratore
					tendinaNumeratore.removeAllItems();
					tendinaNumeratore.setEnabled(false);
					tendinaNumeratore.addItem("-----");
					tendinaNumeratore.addItem(AMBIENTE);
					tendinaNumeratore.addItem(TIPOMEZZO);
					tendinaNumeratore.addItem(MEZZO);
					tendinaNumeratore.addItem(TRATTA);
					tendinaNumeratore.addItem(OFFERTA);
					tendinaNumeratore.addItem(PRENOTAZIONE);
					tendinaNumeratore.setSelectedItem(0);
					tendinaNumeratore.setEnabled(true);
					
				} else {
					
					//inserisco l'elemento interessato nella tendina numeratore
					tendinaNumeratore.removeAllItems();
					tendinaNumeratore.setEnabled(false);
					tendinaNumeratore.addItem("-----");
					tendinaNumeratore.addItem(AMBIENTE);
					tendinaNumeratore.addItem(TIPOMEZZO);
					tendinaNumeratore.addItem(MEZZO);
					tendinaNumeratore.addItem(TRATTA);
					tendinaNumeratore.addItem(OFFERTA);
					tendinaNumeratore.setSelectedItem(0);
					tendinaNumeratore.setEnabled(true);
				}
			}
		}
		
	}
	
	
	
	private class TendinaNumeratoreAA implements ActionListener{

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			campoIndiceGradimento.setText("");
			
			numeratore = (String) tendinaNumeratore.getSelectedItem();
			
			tendinaDenominatore.setEnabled(false);
			tendinaDenominatore.removeAllItems();
			
			
			
			
			if (tendinaNumeratore.getItemCount() != 0 ){
				
				if(!tendinaNumeratore.equals("-----")){	
					
					
					if (numeratore.equals(AMBIENTE)){
						
						tendinaDenominatore.addItem("-----");
						tendinaDenominatore.addItem(TOTALE);
						tendinaDenominatore.setSelectedIndex(0);
						tendinaDenominatore.setEnabled(true);
						
					}
					
					if (numeratore.equals(TIPOMEZZO)){
						
						tendinaDenominatore.addItem("-----");
						tendinaDenominatore.addItem(AMBIENTE);
						tendinaDenominatore.setSelectedIndex(0);
						tendinaDenominatore.setEnabled(true);
						
					}
					
					if (numeratore.equals(MEZZO)){
						
						tendinaDenominatore.addItem("-----");
						tendinaDenominatore.addItem(AMBIENTE);
						tendinaDenominatore.addItem(TIPOMEZZO);
						tendinaDenominatore.setSelectedIndex(0);
						tendinaDenominatore.setEnabled(true);
						
					}

					if (numeratore.equals(TRATTA)){
						
						tendinaDenominatore.addItem("-----");
						tendinaDenominatore.addItem(MEZZO);
						tendinaDenominatore.setSelectedIndex(0);
						tendinaDenominatore.setEnabled(true);
						
					}
					
					if (numeratore.equals(OFFERTA)){
						
						tendinaDenominatore.addItem("-----");
						tendinaDenominatore.addItem(TRATTA);
						tendinaDenominatore.setSelectedIndex(0);
						tendinaDenominatore.setEnabled(true);
						
					}
					
					if (numeratore.equals(PRENOTAZIONE)){
						
						tendinaDenominatore.addItem("-----");
						tendinaDenominatore.addItem(OFFERTA);
						tendinaDenominatore.setSelectedIndex(0);
						tendinaDenominatore.setEnabled(true);
						
					}
					
					
					
				}
			}
			
		}
		
	}
	
	
	private class TendinaDenominatoreAA implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			campoIndiceGradimento.setText("");
			denominatore = (String) tendinaDenominatore.getSelectedItem();

			
		}
		
	}
	
	
	private class CalcolaIndiceGradimentoAA implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent arg0) {


			if ( denominatore == null || numeratore == null || denominatore.equals("-----") || numeratore.equals("-----") ){
				JOptionPane.showMessageDialog(null, "Selezionare gli elementi di confronto indici" , "Errore", JOptionPane.ERROR_MESSAGE);
			} else {
				
				
				ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
				mezzoScelto = (String) tendinaMezzi.getSelectedItem();
				partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
				arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
				viaScelta = (String) tendinaVia.getSelectedItem();
				offertaScelta = (String) tendinaOfferta.getSelectedItem();
				prenotazioneScelta = (String) tendinaPrenotazione.getSelectedItem();
				
				try {
					Double risultato = controllore.CalcolaIndiceGradimento(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta, metodoScelto, numeratore, denominatore);
					String s = risultato.toString();
					if (s.equals("NaN")){
						JOptionPane.showMessageDialog(null, "Non sono ancora stati venduti biglietti per questa tratta" , "Errore", JOptionPane.ERROR_MESSAGE);
					} else {
						campoIndiceGradimento.setText(risultato.toString());
					}
					
				} catch (TrattaInesistenteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage() , "Errore", JOptionPane.ERROR_MESSAGE);
				} catch (CalcoloIndiceException e) {
					JOptionPane.showMessageDialog(null, e.getMessage() , "Errore", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
			
		}
		
	}
	
	
	
	private class SvuotaAA implements ActionListener{
		/*
		 * Svuota tutti i campi
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			//svuoto comunque il pannello
			if (tendinaAmbiente.getItemCount() != 0){
				
				tendinaAmbiente.setSelectedIndex(0); //la tendina torna al primo valore.
				tendinaMezzi.removeAllItems();  //svuota le tendine
				tendinaMezzi.setEnabled(false);//disattiva tutte le tendine
				
				tendinaNumeratore.removeAllItems();
				tendinaNumeratore.setEnabled(false);
				
				tendinaDenominatore.removeAllItems();
				tendinaDenominatore.setEnabled(false);

			}
			
			ambienteScelto = null;
			mezzoScelto = null;
			partenzaScelta = null;
			arrivoScelto = null;
			viaScelta = null;
			offertaScelta = null;
			prenotazioneScelta = null;
			denominatore = null;
			numeratore = null;
			campoIndiceGradimento.setText("");
			
			

		}
		
	}
	
	
	private class ChiudiAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			panel.setVisible(false); 					//chiude questo pannello
			BoundaryAmministratore.riattivaBottoni();
			
			
			ambienteScelto = null;
			mezzoScelto = null;
			partenzaScelta = null;
			arrivoScelto = null;
			viaScelta = null;
			offertaScelta = null;
			prenotazioneScelta = null;
			denominatore = null;
			numeratore = null;
			
			

		}
	}

}
