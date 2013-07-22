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
public class BoundaryCliente {
	
	private final String ruolo = "Cliente";
	
	//campi istanza pannelli
	private JPanel superPanel; //Pannello principale
	private JPanel panelTitolo;
	private JPanel panelBottoni;
	private JPanel panelNext;  
	
	//Elementi pannelloTitolo
	private JLabel labelTitolo;
		
	private JButton bottoneLogout;  //Statici perchè devono essere riattivati da altra boundary
	private JButton bottoneEsci;
		
	private LogoutAA ascoltatoreBottoneLogout;
	private EsciAA ascoltatoreBottoneEsci;
		
		
	//Elementi pannelloBottoni
		
	private static JButton bottoneOrdinaViaggi;
	private static JButton bottoneInfoViaggi;
	private static JButton bottoneGestioneProfiloPersonale;
		
	private OrdinaViaggiAA ascoltatoreOrdinaViaggi;
	private InfoViaggiAA ascoltatoreInfoViaggi;
	private GestioneProfiloPersonaleAA ascoltatoreGestioneProfiloPersonale;
	    
	    
	public BoundaryCliente(){
		
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
		labelTitolo.setText("CLIENTE");
		panelTitolo.add(labelTitolo);			//aggiungo titolo al pannello1
		
		
		bottoneLogout = new JButton("LOGOUT");
		bottoneLogout.setBackground(Color.ORANGE);
		bottoneLogout.setBounds(panelTitolo.getWidth()/18, panelTitolo.getHeight()/4, panelTitolo.getWidth()/9, panelTitolo.getHeight()/2);
		panelTitolo.add(bottoneLogout);//aggiungo il bottone al primo pannello
		
		bottoneEsci = new JButton("ESCI");
		bottoneEsci.setBackground(Color.RED);
		bottoneEsci.setBounds(panelTitolo.getWidth()/18*15, panelTitolo.getHeight()/4, panelTitolo.getWidth()/9, panelTitolo.getHeight()/2);
		panelTitolo.add(bottoneEsci);//aggiungo il bottone al primo pannello
		
		//Ascoltatori per primo pannello
		
		ascoltatoreBottoneLogout = new LogoutAA();
		bottoneLogout.addActionListener(ascoltatoreBottoneLogout);
		
		ascoltatoreBottoneEsci = new EsciAA();
		bottoneEsci.addActionListener(ascoltatoreBottoneEsci);
		

		/*
		 * 
		 * Secondo pannello: per i bottoni relativi alle funzioni dell'utente loggato
		 * 
		 * 
		 */
		
		panelBottoni = new JPanel();
		panelBottoni.setSize(superPanel.getWidth(), superPanel.getHeight()/10-10);
		panelBottoni.setLocation(0, superPanel.getHeight()/10);
		panelBottoni.setLayout(null);
		superPanel.add(panelBottoni);
		
		
		bottoneOrdinaViaggi = new JButton("Ordina Viaggi");
		bottoneOrdinaViaggi.setBackground(Color.ORANGE);
		bottoneOrdinaViaggi.setBounds(panelBottoni.getWidth()/5, panelBottoni.getHeight()/4, panelBottoni.getWidth()/5, panelBottoni.getHeight()/2);
		panelBottoni.add(bottoneOrdinaViaggi);
		
		
		bottoneInfoViaggi = new JButton("Info Viaggi");
		bottoneInfoViaggi.setBackground(Color.GREEN);
		bottoneInfoViaggi.setBounds(panelBottoni.getWidth()/5*3, panelBottoni.getHeight()/4, panelBottoni.getWidth()/5, panelBottoni.getHeight()/2);
		panelBottoni.add(bottoneInfoViaggi);
		
		bottoneGestioneProfiloPersonale = new JButton("Gestione Profilo Personale");
		bottoneGestioneProfiloPersonale.setBackground(Color.LIGHT_GRAY);
		bottoneGestioneProfiloPersonale.setBounds(panelBottoni.getWidth()/5*3, panelBottoni.getHeight()/4, panelBottoni.getWidth()/5, panelBottoni.getHeight()/2);
		panelBottoni.add(bottoneGestioneProfiloPersonale);
		
		//Ascoltatori per secondo pannello
		ascoltatoreOrdinaViaggi = new OrdinaViaggiAA();
		bottoneOrdinaViaggi.addActionListener(ascoltatoreOrdinaViaggi);
		
		ascoltatoreInfoViaggi = new InfoViaggiAA();
		bottoneInfoViaggi.addActionListener(ascoltatoreInfoViaggi);
		
		ascoltatoreGestioneProfiloPersonale = new GestioneProfiloPersonaleAA();
		bottoneGestioneProfiloPersonale.addActionListener(ascoltatoreGestioneProfiloPersonale);
	    	
	    	
	    }
	
		public static void riattivaBottoni(){
			//Riattivo tutti i bottoni di questo Pannello
			bottoneOrdinaViaggi.setEnabled(true); 
			bottoneInfoViaggi.setEnabled(true);
			bottoneGestioneProfiloPersonale.setEnabled(true);
		}
	    
	    
	    /*
		 * Classi Ascoltatori per bottoni pannelloTitolo
		 */
		
		private class LogoutAA implements ActionListener{

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
		
		private class OrdinaViaggiAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelTitolo.setVisible(false);
				panelTitolo.setVisible(true);
				panelBottoni.setVisible(false);
				panelBottoni.setVisible(true);
				
				//Disattivo tutti i bottoni di questo Pannello
				bottoneOrdinaViaggi.setEnabled(false); 
				bottoneInfoViaggi.setEnabled(false);
				bottoneGestioneProfiloPersonale.setEnabled(false);
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*8);
				panelNext.setLocation(0, superPanel.getHeight()/10*2+6);
				panelNext.setBackground(Color.BLACK);
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryCliente_OrdinaViaggi(panelNext);  //Passo il resto del Pannello
				
			
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
				bottoneOrdinaViaggi.setEnabled(false); 
				bottoneInfoViaggi.setEnabled(false);
				bottoneGestioneProfiloPersonale.setEnabled(false);
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*8);
				panelNext.setLocation(0, superPanel.getHeight()/10*2+6);
				panelNext.setBackground(Color.BLACK);
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryVisitatore_InfoViaggi(panelNext, ruolo);  //Passo il resto del Pannello
				
				
			}
			
		}
		
		
		private class GestioneProfiloPersonaleAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panelTitolo.setVisible(false);
				panelTitolo.setVisible(true);
				panelBottoni.setVisible(false);
				panelBottoni.setVisible(true);
				
				//Disattivo tutti i bottoni di questo Pannello
				bottoneOrdinaViaggi.setEnabled(false); 
				bottoneInfoViaggi.setEnabled(false);
				bottoneGestioneProfiloPersonale.setEnabled(false);
				
				// Pannello next: definisco le dimensioni del pannello da passare alla boundary del caso d'uso di competenza
				panelNext = new JPanel();
				panelNext.setSize(superPanel.getWidth(), superPanel.getHeight()/10*8);
				panelNext.setLocation(0, superPanel.getHeight()/10*2+6);
				panelNext.setBackground(Color.BLACK);
				panelNext.setLayout(null); 			//ora il pannello puo' contenere oggetti
				panelNext.setVisible(false);        //Si vede solo quando premo un bottone del pannello Bottone
				superPanel.add(panelNext);			//Anche se non si vede, va aggiunto lo stesso!!!
				
				
				new BoundaryCliente_GestioneProfiloPersonale(panelNext, ruolo);  //Passo il resto del Pannello
				
				
			}
			
		}
			

}
