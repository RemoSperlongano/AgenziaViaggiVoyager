/**
 * 
 */
package gestione_Catalogo.boundary;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryCliente_OrdinaViaggi {
	
	/*
	 * Attributi di istanza
	 */
	

	//Pannelli
	private JPanel superPanel;
	
	private JPanel panel1;
	private JPanel nextPanel;
	
	//Elementi Pannello
    private static JButton bottonePrenotaViaggio;
	private static JButton bottoneAnnullaPrenotazione;
	private static JButton bottoneEmissioneBiglietti;
	private static JButton bottoneChiudiPannello1;
	    
	private PrenotaViaggioAA ascoltatoreBottonePrenotaViaggio;
	private AnnullaPrenotazioneAA ascoltatoreBottoneRimuoviPrenotazione;
    private EmissioneBigliettiAA ascoltatoreBottoneEmissioneBiglietti;
    private ChiudiPannello1AA ascoltatoreBottoneChiudiPannello1;
    
    
    
    public BoundaryCliente_OrdinaViaggi(JPanel panelNext){
    	
		
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
		
		bottonePrenotaViaggio = new JButton("Prenota Viaggio");
		bottonePrenotaViaggio.setBackground(Color.CYAN);
		bottonePrenotaViaggio.setBounds(panel1.getWidth()/12, panel1.getHeight()/6, panel1.getWidth()/6, panel1.getHeight()/2);
		panel1.add(bottonePrenotaViaggio);//aggiungo il bottone al secondo pannello
		
		
		bottoneAnnullaPrenotazione = new JButton("Annulla Prenotazione");
		bottoneAnnullaPrenotazione.setBackground(Color.YELLOW);
		bottoneAnnullaPrenotazione.setBounds(panel1.getWidth()/12*5, panel1.getHeight()/6, panel1.getWidth()/6, panel1.getHeight()/2);
		panel1.add(bottoneAnnullaPrenotazione);//aggiungo il bottone al secondo pannello
		
		
		bottoneEmissioneBiglietti = new JButton("Emissione Biglietti");
		bottoneEmissioneBiglietti.setBackground(Color.PINK);
		bottoneEmissioneBiglietti.setBounds(panel1.getWidth()/12*9, panel1.getHeight()/6, panel1.getWidth()/6, panel1.getHeight()/2);
		panel1.add(bottoneEmissioneBiglietti);
		
		bottoneChiudiPannello1 = new JButton("X");
		bottoneChiudiPannello1.setBackground(Color.RED);
		bottoneChiudiPannello1.setBounds(panel1.getWidth()/20*19, 0, panel1.getWidth()/20, panel1.getHeight()/2-3);
		panel1.add(bottoneChiudiPannello1);
		
		
		
		// ascoltatori per primo pannello
		ascoltatoreBottonePrenotaViaggio = new PrenotaViaggioAA(); 		//creo ascoltatore per bottone
		bottonePrenotaViaggio.addActionListener(ascoltatoreBottonePrenotaViaggio); 	//associo ascoltatore al bottone
		
		ascoltatoreBottoneRimuoviPrenotazione = new AnnullaPrenotazioneAA();			//creo ascoltatore per bottone
		bottoneAnnullaPrenotazione.addActionListener(ascoltatoreBottoneRimuoviPrenotazione);		//associo ascoltatore al bottone
		
		ascoltatoreBottoneEmissioneBiglietti = new EmissioneBigliettiAA();
		bottoneEmissioneBiglietti.addActionListener(ascoltatoreBottoneEmissioneBiglietti);
		
		
		ascoltatoreBottoneChiudiPannello1 = new ChiudiPannello1AA();
		bottoneChiudiPannello1.addActionListener(ascoltatoreBottoneChiudiPannello1);
		
    	
    }
    
    
    
    
    	public static void riattivaBottoni(){
    		
    		 bottonePrenotaViaggio.setEnabled(true);
    		 bottoneAnnullaPrenotazione.setEnabled(true);
    		 bottoneEmissioneBiglietti.setEnabled(true);
    		 bottoneChiudiPannello1.setEnabled(true);
    		
    	}
    
    	
    
    
    
    /*
	 * Classi Ascoltatori per bottoni pannello 1
	 */
	
	private class PrenotaViaggioAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel1.setVisible(false);
			panel1.setVisible(true);
			
			bottonePrenotaViaggio.setEnabled(false); //disattiva i bottoni
			bottoneAnnullaPrenotazione.setEnabled(false);
			bottoneEmissioneBiglietti.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
			
			
			// Imposto le dimensioni per il pannello che ospiterà la boudary successive
			nextPanel = new JPanel();
			nextPanel.setSize(superPanel.getWidth(), superPanel.getHeight()/8*7);
			nextPanel.setLocation(0, superPanel.getHeight()/8);	
			nextPanel.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(nextPanel);
			nextPanel.setVisible(false);
			
			new BoundaryCliente_OrdinaViaggi_PrenotaViaggio(nextPanel);
		
		}
		
	}	
	
	private class AnnullaPrenotazioneAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel1.setVisible(false);
			panel1.setVisible(true);
			
			bottonePrenotaViaggio.setEnabled(false); //disattiva i bottoni
			bottoneAnnullaPrenotazione.setEnabled(false);
			bottoneEmissioneBiglietti.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
			
			
			// Imposto le dimensioni per il pannello che ospiterà la boudary successive
			nextPanel = new JPanel();
			nextPanel.setSize(superPanel.getWidth(), superPanel.getHeight()/8*7);
			nextPanel.setLocation(0, superPanel.getHeight()/8);	
			nextPanel.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(nextPanel);
			nextPanel.setVisible(false);
			
			
			new BoundaryCliente_OrdinaViaggi_AnnullaPrenotazione(nextPanel);
			

		}
		
	}
	
	
	
	private class EmissioneBigliettiAA implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			panel1.setVisible(false);
			panel1.setVisible(true);
			
			bottonePrenotaViaggio.setEnabled(false); //disattiva i bottoni
			bottoneAnnullaPrenotazione.setEnabled(false);
			bottoneEmissioneBiglietti.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
			
			
			// Imposto le dimensioni per il pannello che ospiterà la boudary successive
			nextPanel = new JPanel();
			nextPanel.setSize(superPanel.getWidth(), superPanel.getHeight()/8*7);
			nextPanel.setLocation(0, superPanel.getHeight()/8);	
			nextPanel.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(nextPanel);
			nextPanel.setVisible(false);
			
			new BoundaryCliente_OrdinaViaggi_EmissioneBiglietti(nextPanel);
			
		}
		
	}
	
	private class ChiudiPannello1AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			superPanel.setVisible(false); 			    //chiude tutto questo pannello
			BoundaryCliente.riattivaBottoni();      	//riattiva i bottoni
						
		}
	}
	
	
	
	
	

}
