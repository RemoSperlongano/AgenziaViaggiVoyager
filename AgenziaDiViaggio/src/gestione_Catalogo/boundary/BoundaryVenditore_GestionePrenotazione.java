package gestione_Catalogo.boundary;

import gestione_Catalogo.entity.Data;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.MappaException;
import gestione_Catalogo.exception.OffertaException;
import gestione_Catalogo.exception.OffertaInesistenteException;
import gestione_Catalogo.exception.OfferteNonPresentiException;
import gestione_Catalogo.exception.PrenotazioneException;
import gestione_Catalogo.exception.TrattaInesistenteException;

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
import javax.swing.JTextField;

/**
 * @authors 
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryVenditore_GestionePrenotazione {
	
	/*
	 * Attributi di istanza
	 */
	
	//Entita'
	private String ambienteScelto;
	private String mezzoScelto;
	private String partenzaScelta;
	private String arrivoScelto;
	private String viaScelta;
	private String offertaScelta;
	private String areaTestoOfferta;
	private String areaTestoCatalogo;
	private String areaTestoImp;
	private String areaTestoPrenotazione;
	

	//Pannelli
	private JPanel superPanel;
	
	private JPanel panel1;
	private JPanel nextPanel;
	
	//Elementi Pannello
    private static JButton bottoneAggiungiPrenotazione;
	private static JButton bottoneRimuoviPrenotazione;
	private static JButton bottoneModificaPrenotazione;
	private static JButton bottoneEmissioneBiglietto;
	private static JButton bottoneChiudiPannello1;
	    
	private AggiungiPrenotazioneAA ascoltatoreBottoneAggiungiPrenotazione;
	private RimuoviPrenotazioneAA ascoltatoreBottoneRimuoviPrenotazione;
    private ModificaPrenotazioneAA ascoltatoreBottoneModificaPrenotazione;
    private EmissioneBigliettoAA ascoltatoreBottoneEmissioneBiglietto;
    private ChiudiPannello1AA ascoltatoreBottoneChiudiPannello1;
    
    
    
    public BoundaryVenditore_GestionePrenotazione(JPanel panelNext){
    	
		
		/*
		 * 
		 * Il superPanel di questa Boundary prende le dimensioni del pannello Passato
		 * 
		 */
		superPanel = panelNext;
		superPanel.setVisible(true);   //Si vede ora!
		
		
		
		
		/*
		 * 
		 * primo pannello: per i bottoni della gestione dell'offerta, si apre quando viene premuto GESTIONE OFFERTA 
		 * 
		 */
		
		

		panel1 = new JPanel();
		panel1.setSize(superPanel.getWidth(), superPanel.getHeight()/8-10);  //Il meno 10 serve per far vedere il contorno 
		panel1.setLocation(0,0);			//x=0 e y=0 rispetto al superPanel
		panel1.setLayout(null); 			//ora il pannello puo' contenere oggetti
		superPanel.add(panel1);				//aggiungo il primo pannello al superPannello
		panel1.setVisible(true);
		
		bottoneAggiungiPrenotazione = new JButton("Aggiungi Prenotazione");
		bottoneAggiungiPrenotazione.setBackground(Color.CYAN);
		bottoneAggiungiPrenotazione.setBounds(panel1.getWidth()/25, panel1.getHeight()/6, panel1.getWidth()/6, panel1.getHeight()/2);
		panel1.add(bottoneAggiungiPrenotazione);//aggiungo il bottone al secondo pannello
		
		bottoneModificaPrenotazione = new JButton("Modifica Prenotazione");
		bottoneModificaPrenotazione.setBackground(Color.GREEN);
		bottoneModificaPrenotazione.setBounds(panel1.getWidth()/25*7, panel1.getHeight()/6, panel1.getWidth()/6, panel1.getHeight()/2);
		panel1.add(bottoneModificaPrenotazione);
		
		
		bottoneRimuoviPrenotazione = new JButton("Rimuovi Prenotazione");
		bottoneRimuoviPrenotazione.setBackground(Color.YELLOW);
		bottoneRimuoviPrenotazione.setBounds(panel1.getWidth()/25*13, panel1.getHeight()/6, panel1.getWidth()/6, panel1.getHeight()/2);
		panel1.add(bottoneRimuoviPrenotazione);//aggiungo il bottone al secondo pannello
		
		
		bottoneEmissioneBiglietto = new JButton("Emissione Biglietto");
		bottoneEmissioneBiglietto.setBackground(Color.PINK);
		bottoneEmissioneBiglietto.setBounds(panel1.getWidth()/25*19, panel1.getHeight()/6, panel1.getWidth()/6, panel1.getHeight()/2);
		panel1.add(bottoneEmissioneBiglietto);
		
		bottoneChiudiPannello1 = new JButton("X");
		bottoneChiudiPannello1.setBackground(Color.RED);
		bottoneChiudiPannello1.setBounds(panel1.getWidth()/20*19-10, 0, panel1.getWidth()/20, panel1.getHeight()/2-3);
		panel1.add(bottoneChiudiPannello1);
		
		
		
		// ascoltatori per primo pannello
		ascoltatoreBottoneAggiungiPrenotazione = new AggiungiPrenotazioneAA(); 		//creo ascoltatore per bottone
		bottoneAggiungiPrenotazione.addActionListener(ascoltatoreBottoneAggiungiPrenotazione); 	//associo ascoltatore al bottone
		
		ascoltatoreBottoneModificaPrenotazione = new ModificaPrenotazioneAA();
		bottoneModificaPrenotazione.addActionListener(ascoltatoreBottoneModificaPrenotazione);
		
		ascoltatoreBottoneRimuoviPrenotazione = new RimuoviPrenotazioneAA();			//creo ascoltatore per bottone
		bottoneRimuoviPrenotazione.addActionListener(ascoltatoreBottoneRimuoviPrenotazione);		//associo ascoltatore al bottone
		
		ascoltatoreBottoneEmissioneBiglietto = new EmissioneBigliettoAA();
		bottoneEmissioneBiglietto.addActionListener(ascoltatoreBottoneEmissioneBiglietto);
		
		
		ascoltatoreBottoneChiudiPannello1 = new ChiudiPannello1AA();
		bottoneChiudiPannello1.addActionListener(ascoltatoreBottoneChiudiPannello1);
		
    	
    }
    
    
    
    
    	public static void riattivaBottoni(){
    		
    		 bottoneAggiungiPrenotazione.setEnabled(true);
    		 bottoneRimuoviPrenotazione.setEnabled(true);
    		 bottoneModificaPrenotazione.setEnabled(true);
    		 bottoneEmissioneBiglietto.setEnabled(true);
    		 bottoneChiudiPannello1.setEnabled(true);
    		
    	}
    
    	
    
    
    
    /*
	 * Classi Ascoltatori per bottoni pannello 1
	 */
	
	private class AggiungiPrenotazioneAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel1.setVisible(false);
			panel1.setVisible(true);
			
			bottoneAggiungiPrenotazione.setEnabled(false); //disattiva i bottoni
			bottoneModificaPrenotazione.setEnabled(false);
			bottoneRimuoviPrenotazione.setEnabled(false);
			bottoneEmissioneBiglietto.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
			
			
			// Imposto le dimensioni per il pannello che ospiterà la boudary successive
			nextPanel = new JPanel();
			nextPanel.setSize(superPanel.getWidth(), superPanel.getHeight()/8*7);
			nextPanel.setLocation(0, superPanel.getHeight()/8);	
			nextPanel.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(nextPanel);
			nextPanel.setVisible(false);
			
			new BoundaryVenditore_GestionePrenotazione_AggiungiPrenotazione(nextPanel);
		
		}
		
	}	
	
	private class RimuoviPrenotazioneAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel1.setVisible(false);
			panel1.setVisible(true);
			
			bottoneAggiungiPrenotazione.setEnabled(false); //disattiva i bottoni
			bottoneModificaPrenotazione.setEnabled(false);
			bottoneRimuoviPrenotazione.setEnabled(false);
			bottoneEmissioneBiglietto.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
			
			
			// Imposto le dimensioni per il pannello che ospiterà la boudary successive
			nextPanel = new JPanel();
			nextPanel.setSize(superPanel.getWidth(), superPanel.getHeight()/8*7);
			nextPanel.setLocation(0, superPanel.getHeight()/8);	
			nextPanel.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(nextPanel);
			nextPanel.setVisible(false);
			
			
			new BoundaryVenditore_GestionePrenotazione_RimuoviPrenotazione(nextPanel);
			

		}
		
	}
	
	private class ModificaPrenotazioneAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(null, "Funzionalità al momento non disponibile, ci scusiamo per il disagio", "Funzione non implementata", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
	
	
	private class EmissioneBigliettoAA implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(null, "Funzionalità al momento non disponibile, ci scusiamo per il disagio", "Funzione non implementata", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
	
	private class ChiudiPannello1AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			superPanel.setVisible(false); 			    //chiude tutto questo pannello
			BoundaryVenditore.riattivaBottoni();      	//riattiva i bottoni
						
		}
	}
	
	
	
	
	

}
