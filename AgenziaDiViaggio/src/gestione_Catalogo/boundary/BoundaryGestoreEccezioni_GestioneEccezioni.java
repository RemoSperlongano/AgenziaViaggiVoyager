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
public class BoundaryGestoreEccezioni_GestioneEccezioni {
	
	private String ruolo;
	
	/*
	 * Attributi di istanza
	 */
	

	//Pannelli
	private JPanel superPanel;
	
	private JPanel panel1;
	private JPanel nextPanel;
	
	//Elementi Pannello
	private static JButton bottoneCancellaOfferta;
	private static JButton bottoneModificaPrenotazione;
	private static JButton bottoneChiudiPannello1;
	    
	private CancellaOffertaAA ascoltatoreBottoneCancellaOfferta;
    private ModificaPrenotazioneAA ascoltatoreBottoneModificaPrenotazione;
    private ChiudiPannello1AA ascoltatoreBottoneChiudiPannello1;
    
    
    
    public BoundaryGestoreEccezioni_GestioneEccezioni(JPanel panelNext, String ruolo){
    	
    	this.ruolo = ruolo;
		
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
		
		
		bottoneModificaPrenotazione = new JButton("Modifica Prenotazione");
		bottoneModificaPrenotazione.setBackground(Color.GREEN);
		bottoneModificaPrenotazione.setBounds(panel1.getWidth()/5-5, panel1.getHeight()/6, panel1.getWidth()/5+20, panel1.getHeight()/2);
		panel1.add(bottoneModificaPrenotazione);
		
		
		bottoneCancellaOfferta = new JButton("Rimuovi Offerta & Prenotazioni");
		bottoneCancellaOfferta.setBackground(Color.YELLOW);
		bottoneCancellaOfferta.setBounds(panel1.getWidth()/5*3-5, panel1.getHeight()/6, panel1.getWidth()/5+20, panel1.getHeight()/2);
		panel1.add(bottoneCancellaOfferta);//aggiungo il bottone al secondo pannello
		
		
		bottoneChiudiPannello1 = new JButton("X");
		bottoneChiudiPannello1.setBackground(Color.RED);
		bottoneChiudiPannello1.setBounds(panel1.getWidth()/20*19, 0, panel1.getWidth()/20, panel1.getHeight()/2-3);
		panel1.add(bottoneChiudiPannello1);
		
		
		
		// ascoltatori per primo pannello
		
		ascoltatoreBottoneModificaPrenotazione = new ModificaPrenotazioneAA();
		bottoneModificaPrenotazione.addActionListener(ascoltatoreBottoneModificaPrenotazione);
		
		ascoltatoreBottoneCancellaOfferta = new CancellaOffertaAA();			//creo ascoltatore per bottone
		bottoneCancellaOfferta.addActionListener(ascoltatoreBottoneCancellaOfferta);		//associo ascoltatore al bottone
		
		
		ascoltatoreBottoneChiudiPannello1 = new ChiudiPannello1AA();
		bottoneChiudiPannello1.addActionListener(ascoltatoreBottoneChiudiPannello1);
		
    	
    }
    
    
    
    
    	public static void riattivaBottoni(){
    		
    		 bottoneCancellaOfferta.setEnabled(true);
    		 bottoneModificaPrenotazione.setEnabled(true);
    		 bottoneChiudiPannello1.setEnabled(true);
    		
    	}
    
    	
    
    
    
    /*
	 * Classi Ascoltatori per bottoni pannello 1
	 */
	
	
	private class CancellaOffertaAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel1.setVisible(false);
			panel1.setVisible(true);
			
			bottoneModificaPrenotazione.setEnabled(false);
			bottoneCancellaOfferta.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
			
			
			// Imposto le dimensioni per il pannello che ospiterà la boudary successive
			nextPanel = new JPanel();
			nextPanel.setSize(superPanel.getWidth(), superPanel.getHeight()/8*7);
			nextPanel.setLocation(0, superPanel.getHeight()/8);	
			nextPanel.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(nextPanel);
			nextPanel.setVisible(false);
			
			
			new BoundaryGestoreEccezioni_GestioneEccezioni_RimuoviOffertaConPrenotazioni(nextPanel);
			

		}
		
	}
	
	private class ModificaPrenotazioneAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			panel1.setVisible(false);
			panel1.setVisible(true);
			
			bottoneModificaPrenotazione.setEnabled(false);
			bottoneCancellaOfferta.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
			
			
			// Imposto le dimensioni per il pannello che ospiterà la boudary successive
			nextPanel = new JPanel();
			nextPanel.setSize(superPanel.getWidth(), superPanel.getHeight()/8*7);
			nextPanel.setLocation(0, superPanel.getHeight()/8);	
			nextPanel.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(nextPanel);
			nextPanel.setVisible(false);
			
			new BoundaryGestoreEccezioni_GestioneEccezioni_ModificaPrenotazione(nextPanel);
			
		}
		
	}
	
	
	private class ChiudiPannello1AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			superPanel.setVisible(false); 			    //chiude tutto questo pannello
			
			//riattiva i bottoni in base al ruolo.

			if (ruolo.equals("GestoreEccezioni")){
				BoundaryGestoreEccezioni.riattivaBottoni();
			}
			
			if (ruolo.equals("Amministratore")){
				BoundaryAmministratore.riattivaBottoni();
			}
						
						
		}
	}
	
	
	
	
	

}
