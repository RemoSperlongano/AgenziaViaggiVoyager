/**
 * 
 */
package gestione_Catalogo.boundary;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryAmministratore {
	

	
	//campi istanza pannelli
	private JPanel superPanel; //Pannello principale
	private JPanel panelTitolo;
	private JPanel panelBottoni;
	private JPanel panelNext;  
	
	//Elementi pannelloTitolo
	private JLabel labelTitolo;
		
	private JButton bottoneLogOut;  
	private JButton bottoneEsci;
		
	private LogOutAA ascoltatoreBottoneLogOut;
	private EsciAA ascoltatoreBottoneEsci;
		
		
	//Elementi pannelloBottoni
		
	
	private static JButton bottoneGestioneCatalogo;
	private static JButton bottoneGestioneOfferta;
	private static JButton bottoneGestionePrenotazione;
	private static JButton bottoneInfoViaggi;
	private static JButton bottoneGestioneEccezioni;
	private static JButton bottoneVisualizzaLog;
	private static JButton bottoneGestioneUtenti;
	private static JButton bottoneGestioneIndici;
		
	private GestionePrenotazioneAA ascoltatoreGestionePrenotazione;
	    
	    
	public BoundaryAmministratore(){
		
		/*
		 * definisco il SuperPannello
		 */
		superPanel = new JPanel();
		superPanel.setSize(BoundaryAAAprimaria.confinePrincipale.getWidth(), BoundaryAAAprimaria.confinePrincipale.getHeight());
		superPanel.setBackground(Color.BLACK); 					//provo a mettere il sottopannellonero...si vedono i contorni?
		superPanel.setLayout(null); 							//ora il pannello puo' contenere altri pannelli
		BoundaryAAAprimaria.confinePrincipale.add(superPanel); 	//aggiungo il pannello al confine (chiamato staticamente)
	//	BoundaryAAAprimaria.confinePrincipale.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		
		
		
		
		/*
		 * primo pannello: per il titolo
		 */
		
		panelTitolo = new JPanel();
		panelTitolo.setSize(superPanel.getWidth(), superPanel.getHeight()/10-10);  //Il meno 10 serve per far vedere il contorno 
		panelTitolo.setLocation(0, 0);			//x=0 e y=0 rispetto al superPanel
		panelTitolo.setLayout(null); 			//ora il pannello puo' contenere oggetti
		superPanel.add(panelTitolo);				//aggiungo il primo pannello al superPannello
		
		labelTitolo = new JLabel();  		//Etichetta per il titolo
		labelTitolo.setFont(new Font("Arial", 0, 30));
		labelTitolo.setLocation(0, 0);
		labelTitolo.setSize(panelTitolo.getWidth(), panelTitolo.getHeight());
		labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		labelTitolo.setVerticalAlignment(JLabel.CENTER);
		labelTitolo.setText("AMMINISTRATORE");
		panelTitolo.add(labelTitolo);			//aggiungo titolo al pannello1
		
		
		bottoneLogOut = new JButton("LOGOUT");
		bottoneLogOut.setBackground(Color.ORANGE);
		bottoneLogOut.setBounds(panelTitolo.getWidth()/18, panelTitolo.getHeight()/4, panelTitolo.getWidth()/9, panelTitolo.getHeight()/2);
		panelTitolo.add(bottoneLogOut);//aggiungo il bottone al primo pannello
		
		bottoneEsci = new JButton("ESCI");
		bottoneEsci.setBackground(Color.RED);
		bottoneEsci.setBounds(panelTitolo.getWidth()/18*15, panelTitolo.getHeight()/4, panelTitolo.getWidth()/9, panelTitolo.getHeight()/2);
		panelTitolo.add(bottoneEsci);//aggiungo il bottone al primo pannello
		
		//Ascoltatori per primo pannello
		
		ascoltatoreBottoneLogOut = new LogOutAA();
		bottoneLogOut.addActionListener(ascoltatoreBottoneLogOut);
		
		ascoltatoreBottoneEsci = new EsciAA();
		bottoneEsci.addActionListener(ascoltatoreBottoneEsci);
		

		/*
		 * 
		 * Secondo pannello: per i bottoni relativi alle funzioni dell'utente loggato
		 * 
		 * 
		 */
		
		panelBottoni = new JPanel();
		panelBottoni.setSize(superPanel.getWidth(), superPanel.getHeight()/10*2-10);
		panelBottoni.setLocation(0, superPanel.getHeight()/10);
		panelBottoni.setLayout(null);
		superPanel.add(panelBottoni);
		
		bottoneGestioneCatalogo = new JButton("Gestione Catalogo");
		bottoneGestioneCatalogo.setBackground(Color.YELLOW);
		bottoneGestioneCatalogo.setBounds(panelBottoni.getWidth()/13, panelBottoni.getHeight()/12*2, panelBottoni.getWidth()/13*2, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestioneCatalogo);
		
		
		
		bottoneGestioneOfferta = new JButton("Gestione Offerta");
		bottoneGestioneOfferta.setBackground(Color.ORANGE);
		bottoneGestioneOfferta.setBounds(panelBottoni.getWidth()/13*4, panelBottoni.getHeight()/12*2, panelBottoni.getWidth()/13*2, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestioneOfferta);
		
		
		bottoneGestionePrenotazione = new JButton("Gestione Prenotazione");
		bottoneGestionePrenotazione.setBackground(Color.CYAN);
		bottoneGestionePrenotazione.setBounds(panelBottoni.getWidth()/13*7, panelBottoni.getHeight()/12*2, panelBottoni.getWidth()/13*2, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestionePrenotazione);
		
		
		bottoneInfoViaggi = new JButton("Info Viaggi");
		bottoneInfoViaggi.setBackground(Color.GREEN);
		bottoneInfoViaggi.setBounds(panelBottoni.getWidth()/13*10, panelBottoni.getHeight()/12*2, panelBottoni.getWidth()/13*2, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneInfoViaggi);
		
		
		
		bottoneGestioneEccezioni = new JButton("Gestione Eccezioni");
		bottoneGestioneEccezioni.setBackground(Color.RED);
		bottoneGestioneEccezioni.setBounds(panelBottoni.getWidth()/13, panelBottoni.getHeight()/12*7, panelBottoni.getWidth()/13*2, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestioneEccezioni);
		
		
		
		bottoneVisualizzaLog = new JButton("Visualizza Log");
		bottoneVisualizzaLog.setBackground(Color.GRAY);
		bottoneVisualizzaLog.setBounds(panelBottoni.getWidth()/13*4, panelBottoni.getHeight()/12*7, panelBottoni.getWidth()/13*2, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneVisualizzaLog);
		
		
		bottoneGestioneUtenti = new JButton("Gestione Utenti");
		bottoneGestioneUtenti.setBackground(Color.PINK);
		bottoneGestioneUtenti.setBounds(panelBottoni.getWidth()/13*7, panelBottoni.getHeight()/12*7, panelBottoni.getWidth()/13*2, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestioneUtenti);
		
		
		bottoneGestioneIndici = new JButton("Gestione Indici");
		bottoneGestioneIndici.setBackground(Color.WHITE);
		bottoneGestioneIndici.setBounds(panelBottoni.getWidth()/13*10, panelBottoni.getHeight()/12*7, panelBottoni.getWidth()/13*2, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestioneIndici);
		
		
		//Ascoltatori per secondo pannello
		ascoltatoreGestionePrenotazione = new GestionePrenotazioneAA();
		bottoneGestionePrenotazione.addActionListener(ascoltatoreGestionePrenotazione);
		
	    	
	    	
	    }
	
		public static void riattivaBottoni(){
			//Riattivo tutti i bottoni di questo Pannello
			bottoneGestionePrenotazione.setEnabled(true); 
		}
	    
	    
	    /*
		 * Classi Ascoltatori per bottoni pannelloTitolo
		 */
		
		private class LogOutAA implements ActionListener{

			@Override
			/*
			 * Torna al pannello precedente e serializza!
			 */
			public void actionPerformed(ActionEvent arg0) {
			
			/*	try {  //Salva gli articoli all'uscita
					controllore.salva();
				} catch (SerializzazioneException e){
					JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
				}
			*/	
				superPanel.setVisible(false);
				BoundaryAAAprimaria.superPanel.setVisible(true);
			//	BoundaryAAAprimaria.confinePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
			
		}
		
		private class EsciAA implements ActionListener{

			@Override
			/*
			 * Esce dal programma ma serializza!!!!
			 */
			public void actionPerformed(ActionEvent arg0) {
				
		/*		try {  //Salva gli articoli all'uscita
					controllore.salva();
				} catch (SerializzazioneException e){
					JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
				}
		*/		
				System.exit(0);
			}
			
		}
		
		
		
		/*
		 * Classi Ascoltatori per bottoni pannelloBottoni
		 */
		
		private class GestionePrenotazioneAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelTitolo.setVisible(false);
				panelTitolo.setVisible(true);
				panelBottoni.setVisible(false);
				panelBottoni.setVisible(true);
				
				//Disattivo tutti i bottoni di questo Pannello
				bottoneGestionePrenotazione.setEnabled(false); 
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*7);
				panelNext.setLocation(0, superPanel.getHeight()/10*3+6);
				panelNext.setBackground(Color.BLACK);
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryVenditore_GestionePrenotazione(panelNext);  //Passo il resto del Pannello
				
			
			}
			
		}



}
