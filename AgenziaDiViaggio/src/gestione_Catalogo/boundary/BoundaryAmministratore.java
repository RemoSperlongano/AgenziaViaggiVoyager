/**
 * 
 */
package gestione_Catalogo.boundary;



import gestione_Catalogo.control.ControlloreAggiungiPrenotazione;
import gestione_Catalogo.control.ControlloreGestioneCatalogo;
import gestione_Catalogo.control.ControlloreGestioneOfferta;
import gestione_Catalogo.thread.ProgettistaThread1;
import gestione_Catalogo.thread.ProgettistaThread2;
import gestione_Catalogo.thread.ProgettistaThread3;
import gestione_Catalogo.thread.ProgettistaThread4;
import gestione_Catalogo.thread.ProgettistaThread5;
import gestione_Catalogo.thread.PromotoreThread1;
import gestione_Catalogo.thread.PromotoreThread2;
import gestione_Catalogo.thread.PromotoreThread3;
import gestione_Catalogo.thread.PromotoreThread4;
import gestione_Catalogo.thread.PromotoreThread5;
import gestione_Catalogo.thread.VenditoreThread1;
import gestione_Catalogo.thread.VenditoreThread2;
import gestione_Catalogo.thread.VenditoreThread3;
import gestione_Catalogo.thread.VenditoreThread4;
import gestione_Catalogo.thread.VenditoreThread5;

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
	
	private final String ruolo = "Amministratore";
	
	//campi istanza pannelli
	private JPanel superPanel; //Pannello principale
	private JPanel panelTitolo;
	private JPanel panelBottoni;
	private JPanel panelNext;  
	
	//Elementi pannelloTitolo
	private JLabel labelTitolo;
		
	private JButton bottoneLogOut;  
	private JButton bottoneThread;
	private JButton bottoneEsci;
		
	private ThreadAA ascoltatoreBottoneThread;
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
	
	private GestioneCatalogoAA ascoltatoreGestioneCatalogo;
	private GestioneOffertaAA ascoltatoreGestioneOfferta;
	private GestionePrenotazioneAA ascoltatoreGestionePrenotazione;
	private InfoViaggiAA ascoltatoreInfoViaggi;
	private GestioneEccezioniAA ascoltatoreGestioneEccezioni;
	private VisualizzaLogAA ascoltatoreVisualizzaLog;
	private GestioneUtentiAA ascoltatoreGestioneUtenti;
	private GestioneIndiciAA ascoltatoreGestioneIndici;
	    
	    
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
		 * primo pannello:  per il titolo
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
		
		bottoneThread = new JButton("T");
		bottoneThread.setBackground(Color.GREEN);
		bottoneThread.setBounds(panelTitolo.getWidth()/18*4, panelTitolo.getHeight()/4, panelTitolo.getWidth()/20, panelTitolo.getHeight()/2);
		panelTitolo.add(bottoneThread);
		
		bottoneEsci = new JButton("ESCI");
		bottoneEsci.setBackground(Color.RED);
		bottoneEsci.setBounds(panelTitolo.getWidth()/18*15, panelTitolo.getHeight()/4, panelTitolo.getWidth()/9, panelTitolo.getHeight()/2);
		panelTitolo.add(bottoneEsci);//aggiungo il bottone al primo pannello
		
		//Ascoltatori per primo pannello
		
		ascoltatoreBottoneLogOut = new LogOutAA();
		bottoneLogOut.addActionListener(ascoltatoreBottoneLogOut);
		
		ascoltatoreBottoneThread = new ThreadAA();
		bottoneThread.addActionListener(ascoltatoreBottoneThread);
		
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
		bottoneGestioneCatalogo.setBounds(panelBottoni.getWidth()/30+15, panelBottoni.getHeight()/12*2, panelBottoni.getWidth()/5, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestioneCatalogo);
		
		
		
		bottoneGestioneOfferta = new JButton("Gestione Offerta");
		bottoneGestioneOfferta.setBackground(Color.ORANGE);
		bottoneGestioneOfferta.setBounds(panelBottoni.getWidth()/30*8+15, panelBottoni.getHeight()/12*2, panelBottoni.getWidth()/5, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestioneOfferta);
		
		
		bottoneGestionePrenotazione = new JButton("Gestione Prenotazione");
		bottoneGestionePrenotazione.setBackground(Color.CYAN);
		bottoneGestionePrenotazione.setBounds(panelBottoni.getWidth()/30*15+15, panelBottoni.getHeight()/12*2, panelBottoni.getWidth()/5, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestionePrenotazione);
		
		
		bottoneInfoViaggi = new JButton("Info Viaggi");
		bottoneInfoViaggi.setBackground(Color.GREEN);
		bottoneInfoViaggi.setBounds(panelBottoni.getWidth()/30*22+15, panelBottoni.getHeight()/12*2, panelBottoni.getWidth()/5, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneInfoViaggi);
		
		
		
		bottoneGestioneEccezioni = new JButton("Gestione Eccezioni");
		bottoneGestioneEccezioni.setBackground(Color.RED);
		bottoneGestioneEccezioni.setBounds(panelBottoni.getWidth()/30+15, panelBottoni.getHeight()/12*7, panelBottoni.getWidth()/5, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestioneEccezioni);
		
		
		
		bottoneVisualizzaLog = new JButton("Visualizza Log");
		bottoneVisualizzaLog.setBackground(Color.LIGHT_GRAY);
		bottoneVisualizzaLog.setBounds(panelBottoni.getWidth()/30*8+15, panelBottoni.getHeight()/12*7, panelBottoni.getWidth()/5, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneVisualizzaLog);
		
		
		bottoneGestioneUtenti = new JButton("Gestione Utenti");
		bottoneGestioneUtenti.setBackground(Color.PINK);
		bottoneGestioneUtenti.setBounds(panelBottoni.getWidth()/30*15+15, panelBottoni.getHeight()/12*7, panelBottoni.getWidth()/5, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestioneUtenti);
		
		
		bottoneGestioneIndici = new JButton("Gestione Indici");
		bottoneGestioneIndici.setBackground(Color.WHITE);
		bottoneGestioneIndici.setBounds(panelBottoni.getWidth()/30*22+15, panelBottoni.getHeight()/12*7, panelBottoni.getWidth()/5, panelBottoni.getHeight()/4);
		panelBottoni.add(bottoneGestioneIndici);
		
		
		//Ascoltatori per secondo pannello
		ascoltatoreGestioneCatalogo = new GestioneCatalogoAA();
		bottoneGestioneCatalogo.addActionListener(ascoltatoreGestioneCatalogo);
		
		ascoltatoreGestioneOfferta = new GestioneOffertaAA();
		bottoneGestioneOfferta.addActionListener(ascoltatoreGestioneOfferta);
		
		ascoltatoreGestionePrenotazione = new GestionePrenotazioneAA();
		bottoneGestionePrenotazione.addActionListener(ascoltatoreGestionePrenotazione);
		
		ascoltatoreInfoViaggi = new InfoViaggiAA();
		bottoneInfoViaggi.addActionListener(ascoltatoreInfoViaggi);
	    	
	    ascoltatoreGestioneEccezioni = new GestioneEccezioniAA();
	    bottoneGestioneEccezioni.addActionListener(ascoltatoreGestioneEccezioni);
	    
	    ascoltatoreVisualizzaLog = new VisualizzaLogAA();
	    bottoneVisualizzaLog.addActionListener(ascoltatoreVisualizzaLog);
	    
	    ascoltatoreGestioneUtenti = new GestioneUtentiAA();
	    bottoneGestioneUtenti.addActionListener(ascoltatoreGestioneUtenti);
	    
	    ascoltatoreGestioneIndici = new GestioneIndiciAA();
	    bottoneGestioneIndici.addActionListener(ascoltatoreGestioneIndici);
	    
	    
	}
	
		public static void riattivaBottoni(){
			//Riattivo tutti i bottoni di questo Pannello
			bottoneGestionePrenotazione.setEnabled(true); 
			bottoneGestioneCatalogo.setEnabled(true);
			bottoneGestioneOfferta.setEnabled(true);
			bottoneInfoViaggi.setEnabled(true);
			bottoneGestioneEccezioni.setEnabled(true);
			bottoneVisualizzaLog.setEnabled(true);
			bottoneGestioneUtenti.setEnabled(true);
			bottoneGestioneIndici.setEnabled(true);
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
		
		private class ThreadAA implements ActionListener{

			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ControlloreGestioneOfferta controlloreProgettista = new ControlloreGestioneOfferta();
				ControlloreGestioneCatalogo controllorePromotore = new ControlloreGestioneCatalogo();
				ControlloreAggiungiPrenotazione controlloreVenditore = new ControlloreAggiungiPrenotazione();


				ProgettistaThread1 dt1 = new ProgettistaThread1(controlloreProgettista);
				ProgettistaThread2 dt2 = new ProgettistaThread2(controlloreProgettista);
				ProgettistaThread3 dt3 = new ProgettistaThread3(controlloreProgettista);
				ProgettistaThread4 dt4 = new ProgettistaThread4(controlloreProgettista);
				ProgettistaThread5 dt5 = new ProgettistaThread5(controlloreProgettista);
				
				PromotoreThread1 pt1 = new PromotoreThread1(controllorePromotore);
				PromotoreThread2 pt2 = new PromotoreThread2(controllorePromotore);
				PromotoreThread3 pt3 = new PromotoreThread3(controllorePromotore);
				PromotoreThread4 pt4 = new PromotoreThread4(controllorePromotore);
				PromotoreThread5 pt5 = new PromotoreThread5(controllorePromotore);
				
				
				VenditoreThread1 vt1 = new VenditoreThread1(controlloreVenditore);
				VenditoreThread2 vt2 = new VenditoreThread2(controlloreVenditore);
				VenditoreThread3 vt3 = new VenditoreThread3(controlloreVenditore);
				VenditoreThread4 vt4 = new VenditoreThread4(controlloreVenditore);
				VenditoreThread5 vt5 = new VenditoreThread5(controlloreVenditore);
				
				
				
				
				
				Thread t1 = new Thread(dt1);
				Thread t2 = new Thread(dt2);
				Thread t3 = new Thread(dt3);
				Thread t4 = new Thread(dt4);
				Thread t5 = new Thread(dt5);
				Thread t6 = new Thread(pt1);
				Thread t7 = new Thread(pt2);
				Thread t8 = new Thread(pt3);
				Thread t9 = new Thread(pt4);
				Thread t10 = new Thread(pt5);
				Thread t11 = new Thread(vt1);
				Thread t12 = new Thread(vt2);
				Thread t13 = new Thread(vt3);
				Thread t14 = new Thread(vt4);
				Thread t15 = new Thread(vt5);
				
				
				t1.setName("T1_ProgettistaThread");
				t2.setName("T2_ProgettistaThread");
				t3.setName("T3_ProgettistaThread");
				t4.setName("T4_ProgettistaThread");
				t5.setName("T5_ProgettistaThread");
				t6.setName("T6_PromotoreThread");
				t7.setName("T7_PromotoreThread");
				t8.setName("T8_PromotoreThread");
				t9.setName("T9_PromotoreThread");
				t10.setName("T10_PromotoreThread");
				t11.setName("T11_VenditoreThread");
				t12.setName("T12_VenditoreThread");
				t13.setName("T13_VenditoreThread");
				t14.setName("T14_VenditoreThread");
				t15.setName("T15_VenditoreThread");
				

				t13.start();
				t5.start();
				t14.start();
				t1.start();
				t3.start();
				t15.start();
				t7.start();
				t9.start();
				t6.start();
				t10.start();
				t4.start();
				t12.start();
				t11.start();
				t8.start();
				t2.start();
				
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
		
		private class GestioneCatalogoAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelTitolo.setVisible(false);
				panelTitolo.setVisible(true);
				panelBottoni.setVisible(false);
				panelBottoni.setVisible(true);
				
				//Disattivo tutti i bottoni di questo Pannello
				bottoneGestioneCatalogo.setEnabled(false);
				bottoneGestioneOfferta.setEnabled(false);
				bottoneGestionePrenotazione.setEnabled(false); 
				bottoneInfoViaggi.setEnabled(false);
				bottoneGestioneEccezioni.setEnabled(false);
				bottoneVisualizzaLog.setEnabled(false);
				bottoneGestioneUtenti.setEnabled(false);
				bottoneGestioneIndici.setEnabled(false);
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*7);
				panelNext.setLocation(0, superPanel.getHeight()/10*3+6);
				panelNext.setBackground(Color.BLACK);
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryPromotore_GestioneCatalogo(panelNext, ruolo);  //Passo il resto del Pannello
				
			
			}
			
		}


		private class GestioneOffertaAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelTitolo.setVisible(false);
				panelTitolo.setVisible(true);
				panelBottoni.setVisible(false);
				panelBottoni.setVisible(true);
				
				//Disattivo tutti i bottoni di questo Pannello
				bottoneGestioneCatalogo.setEnabled(false);
				bottoneGestioneOfferta.setEnabled(false);
				bottoneGestionePrenotazione.setEnabled(false); 
				bottoneInfoViaggi.setEnabled(false);
				bottoneGestioneEccezioni.setEnabled(false);
				bottoneVisualizzaLog.setEnabled(false);
				bottoneGestioneUtenti.setEnabled(false);
				bottoneGestioneIndici.setEnabled(false);
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*7);
				panelNext.setLocation(0, superPanel.getHeight()/10*3+6);
				panelNext.setBackground(Color.BLACK);
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryProgettista_GestioneOfferta(panelNext, ruolo);  //Passo il resto del Pannello
				
			
			}
			
		}

		
		private class GestionePrenotazioneAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelTitolo.setVisible(false);
				panelTitolo.setVisible(true);
				panelBottoni.setVisible(false);
				panelBottoni.setVisible(true);
				
				//Disattivo tutti i bottoni di questo Pannello
				bottoneGestioneCatalogo.setEnabled(false);
				bottoneGestioneOfferta.setEnabled(false);
				bottoneGestionePrenotazione.setEnabled(false); 
				bottoneInfoViaggi.setEnabled(false);
				bottoneGestioneEccezioni.setEnabled(false);
				bottoneVisualizzaLog.setEnabled(false);
				bottoneGestioneUtenti.setEnabled(false);
				bottoneGestioneIndici.setEnabled(false);
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*7);
				panelNext.setLocation(0, superPanel.getHeight()/10*3+6);
				panelNext.setBackground(Color.BLACK);
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryVenditore_GestionePrenotazione(panelNext, ruolo);  //Passo il resto del Pannello
				
			
			}
			
		}
		
		
		private class InfoViaggiAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelTitolo.setVisible(false);
				panelTitolo.setVisible(true);
				panelBottoni.setVisible(false);
				panelBottoni.setVisible(true);
				
				//Disattivo tutti i bottoni di questo Pannello
				bottoneGestioneCatalogo.setEnabled(false);
				bottoneGestioneOfferta.setEnabled(false);
				bottoneGestionePrenotazione.setEnabled(false); 
				bottoneInfoViaggi.setEnabled(false);
				bottoneGestioneEccezioni.setEnabled(false);
				bottoneVisualizzaLog.setEnabled(false);
				bottoneGestioneUtenti.setEnabled(false);
				bottoneGestioneIndici.setEnabled(false);
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*7);
				panelNext.setLocation(0, superPanel.getHeight()/10*3+6);
				panelNext.setBackground(Color.BLACK);
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryVisitatore_InfoViaggi(panelNext, ruolo);  //Passo il resto del Pannello
				
			
			}
			
		}


		private class GestioneEccezioniAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelTitolo.setVisible(false);
				panelTitolo.setVisible(true);
				panelBottoni.setVisible(false);
				panelBottoni.setVisible(true);
				
				//Disattivo tutti i bottoni di questo Pannello
				bottoneGestioneCatalogo.setEnabled(false);
				bottoneGestioneOfferta.setEnabled(false);
				bottoneGestionePrenotazione.setEnabled(false); 
				bottoneInfoViaggi.setEnabled(false);
				bottoneGestioneEccezioni.setEnabled(false);
				bottoneVisualizzaLog.setEnabled(false);
				bottoneGestioneUtenti.setEnabled(false);
				bottoneGestioneIndici.setEnabled(false);
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*7);
				panelNext.setLocation(0, superPanel.getHeight()/10*3+6);
				panelNext.setBackground(Color.BLACK);
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryGestoreEccezioni_GestioneEccezioni(panelNext, ruolo);  //Passo il resto del Pannello
				
			
			}
			
		}

		
		private class VisualizzaLogAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelTitolo.setVisible(false);
				panelTitolo.setVisible(true);
				panelBottoni.setVisible(false);
				panelBottoni.setVisible(true);
				
				//Disattivo tutti i bottoni di questo Pannello
				bottoneGestioneCatalogo.setEnabled(false);
				bottoneGestioneOfferta.setEnabled(false);
				bottoneGestionePrenotazione.setEnabled(false); 
				bottoneInfoViaggi.setEnabled(false);
				bottoneGestioneEccezioni.setEnabled(false);
				bottoneVisualizzaLog.setEnabled(false);
				bottoneGestioneUtenti.setEnabled(false);
				bottoneGestioneIndici.setEnabled(false);
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*7);
				panelNext.setLocation(0, superPanel.getHeight()/10*3+6);
				
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryAmministratore_VisualizzaLog(panelNext);  //Passo il resto del Pannello
				
			
			}
			
		}


		private class GestioneUtentiAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelTitolo.setVisible(false);
				panelTitolo.setVisible(true);
				panelBottoni.setVisible(false);
				panelBottoni.setVisible(true);
				
				//Disattivo tutti i bottoni di questo Pannello
				bottoneGestioneCatalogo.setEnabled(false);
				bottoneGestioneOfferta.setEnabled(false);
				bottoneGestionePrenotazione.setEnabled(false); 
				bottoneInfoViaggi.setEnabled(false);
				bottoneGestioneEccezioni.setEnabled(false);
				bottoneVisualizzaLog.setEnabled(false);
				bottoneGestioneUtenti.setEnabled(false);
				bottoneGestioneIndici.setEnabled(false);
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*7);
				panelNext.setLocation(0, superPanel.getHeight()/10*3+6);
				panelNext.setBackground(Color.BLACK);
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryAmministratore_GestioneUtenti(panelNext, ruolo);  //Passo il resto del Pannello
				
			
			}
			
		}


		private class GestioneIndiciAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelTitolo.setVisible(false);
				panelTitolo.setVisible(true);
				panelBottoni.setVisible(false);
				panelBottoni.setVisible(true);
				
				//Disattivo tutti i bottoni di questo Pannello
				bottoneGestioneCatalogo.setEnabled(false);
				bottoneGestioneOfferta.setEnabled(false);
				bottoneGestionePrenotazione.setEnabled(false); 
				bottoneInfoViaggi.setEnabled(false);
				bottoneGestioneEccezioni.setEnabled(false);
				bottoneVisualizzaLog.setEnabled(false);
				bottoneGestioneUtenti.setEnabled(false);
				bottoneGestioneIndici.setEnabled(false);
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*7);
				panelNext.setLocation(0, superPanel.getHeight()/10*3+6);
				//panelNext.setBackground(Color.BLACK);
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryAmministratore_GestioneIndici(panelNext);  //Passo il resto del Pannello
				
			
			}
			
		}


}
