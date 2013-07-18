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
public class BoundaryAmministratore_GestioneUtenti {

	
	/*
	 * Attributi di istanza
	 */
	

	//Pannelli
	private JPanel superPanel;
	
	private JPanel panel1;
	private JPanel nextPanel;
	
	//Elementi Pannello
    private static JButton bottoneOpzioniAdmin;
	private static JButton bottoneGestioneUtenti;
	private static JButton bottoneChiudiPannello1;
	    
	private OpzioniAdminAA ascoltatoreBottoneOpzioniAdmin;
	private GestioneUtentiAA ascoltatoreBottoneGestioneUtenti;
    private ChiudiPannello1AA ascoltatoreBottoneChiudiPannello1;
    
    
    
    public BoundaryAmministratore_GestioneUtenti(JPanel panelNext){
    	
		
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
		
		bottoneOpzioniAdmin = new JButton("Opzioni Amministratore");
		bottoneOpzioniAdmin.setBackground(Color.LIGHT_GRAY);
		bottoneOpzioniAdmin.setBounds(panel1.getWidth()/5, panel1.getHeight()/6, panel1.getWidth()/5, panel1.getHeight()/2);
		panel1.add(bottoneOpzioniAdmin);//aggiungo il bottone al secondo pannello
		
		
		bottoneGestioneUtenti = new JButton("Gestione Utenti");
		bottoneGestioneUtenti.setBackground(Color.PINK);
		bottoneGestioneUtenti.setBounds(panel1.getWidth()/5*3, panel1.getHeight()/6, panel1.getWidth()/5, panel1.getHeight()/2);
		panel1.add(bottoneGestioneUtenti);//aggiungo il bottone al secondo pannello
		
		
		bottoneChiudiPannello1 = new JButton("X");
		bottoneChiudiPannello1.setBackground(Color.RED);
		bottoneChiudiPannello1.setBounds(panel1.getWidth()/20*19, 0, panel1.getWidth()/20, panel1.getHeight()/2-3);
		panel1.add(bottoneChiudiPannello1);
		
		
		
		// ascoltatori per primo pannello
		ascoltatoreBottoneOpzioniAdmin = new OpzioniAdminAA(); 		//creo ascoltatore per bottone
		bottoneOpzioniAdmin.addActionListener(ascoltatoreBottoneOpzioniAdmin); 	//associo ascoltatore al bottone
		
		ascoltatoreBottoneGestioneUtenti = new GestioneUtentiAA();			//creo ascoltatore per bottone
		bottoneGestioneUtenti.addActionListener(ascoltatoreBottoneGestioneUtenti);		//associo ascoltatore al bottone
		
		
		ascoltatoreBottoneChiudiPannello1 = new ChiudiPannello1AA();
		bottoneChiudiPannello1.addActionListener(ascoltatoreBottoneChiudiPannello1);
		
    	
    }
    
    
    
    
    	public static void riattivaBottoni(){
    		
    		 bottoneOpzioniAdmin.setEnabled(true);
    		 bottoneGestioneUtenti.setEnabled(true);
    		 bottoneChiudiPannello1.setEnabled(true);
    		
    	}
    
    	
    
    
    
    /*
	 * Classi Ascoltatori per bottoni pannello 1
	 */
	
	private class OpzioniAdminAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel1.setVisible(false);
			panel1.setVisible(true);
			
			bottoneOpzioniAdmin.setEnabled(false); //disattiva i bottoni
			bottoneGestioneUtenti.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
			
			
			// Imposto le dimensioni per il pannello che ospiterà la boudary successive
			nextPanel = new JPanel();
			nextPanel.setSize(superPanel.getWidth(), superPanel.getHeight()/8*7);
			nextPanel.setLocation(0, superPanel.getHeight()/8);	
			nextPanel.setBackground(Color.BLACK);
			nextPanel.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(nextPanel);
			nextPanel.setVisible(false);
			
			new BoundaryAmministratore_GestioneUtenti_OpzioniAdmin(nextPanel);
		
		}
		
	}	
	
	private class GestioneUtentiAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel1.setVisible(false);
			panel1.setVisible(true);
			
			bottoneOpzioniAdmin.setEnabled(false); //disattiva i bottoni
			bottoneGestioneUtenti.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
			
			
			// Imposto le dimensioni per il pannello che ospiterà la boudary successive
			nextPanel = new JPanel();
			nextPanel.setSize(superPanel.getWidth(), superPanel.getHeight()/8*7);
			nextPanel.setLocation(0, superPanel.getHeight()/8);	
			nextPanel.setBackground(Color.BLACK);
			nextPanel.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(nextPanel);
			nextPanel.setVisible(false);
			
			
			new BoundaryAmministratore_GestioneUtenti_GestioneUtenti(nextPanel);
			

		}
		
	}
	
	
	
	private class ChiudiPannello1AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			superPanel.setVisible(false); 			    //chiude tutto questo pannello
			BoundaryAmministratore.riattivaBottoni();      	//riattiva i bottoni
						
		}
	}
	


}
