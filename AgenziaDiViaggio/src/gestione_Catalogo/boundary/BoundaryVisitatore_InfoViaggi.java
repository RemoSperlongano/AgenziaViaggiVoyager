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
public class BoundaryVisitatore_InfoViaggi {
	
	
		private String ruolo;
	
		//Pannelli
		private JPanel superPanel;
		
		private JPanel panel1;
		private JPanel nextPanel;
		
		
		//Elementi Pannello1
	    private static JButton bottoneMostraCatalogo;
		private static JButton bottoneMostraOfferta;
		private static JButton bottoneChiudiPannello;
		    
		private MostraCatalogoAA ascoltatoreBottoneMostraCatalogo;
		private MostraOffertaAA ascoltatoreBottoneMostraOfferta;
	    private ChiudiPannelloAA ascoltatoreBottoneChiudiPannello;
	    
	    
	    public BoundaryVisitatore_InfoViaggi(JPanel panelNext, String ruolo){
	    	
	    	
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
			 * primo pannello: per i bottoni della gestione del visitatore, si apre quando viene premuto GESTIONE VISITATORE 
			 * 
			 */

			panel1 = new JPanel();
			panel1.setSize(superPanel.getWidth(), superPanel.getHeight()/8-10);  //Il meno 10 serve per far vedere il contorno 
			panel1.setLocation(0,0);			//x=0 e y=0 rispetto al superPanel
			panel1.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(panel1);				//aggiungo il primo pannello al superPannello
			panel1.setVisible(true);
			
			bottoneMostraCatalogo = new JButton("MOSTRA CATALOGO");
			bottoneMostraCatalogo.setBackground(Color.CYAN);
			bottoneMostraCatalogo.setBounds(panel1.getWidth()/5, panel1.getHeight()/6, panel1.getWidth()/5, panel1.getHeight()/2);
			panel1.add(bottoneMostraCatalogo);//aggiungo il bottone al secondo pannello
			
			
			bottoneMostraOfferta = new JButton("MOSTRA OFFERTA");
			bottoneMostraOfferta.setBackground(Color.YELLOW);
			bottoneMostraOfferta.setBounds(panel1.getWidth()/5*3, panel1.getHeight()/6, panel1.getWidth()/5, panel1.getHeight()/2);
			panel1.add(bottoneMostraOfferta);//aggiungo il bottone al secondo pannello
			
			
			bottoneChiudiPannello = new JButton("X");
			bottoneChiudiPannello.setBackground(Color.RED);
			bottoneChiudiPannello.setBounds(panel1.getWidth()/20*19, 0, panel1.getWidth()/20, panel1.getHeight()/2-3);
			panel1.add(bottoneChiudiPannello);
			
			
			ascoltatoreBottoneMostraCatalogo = new MostraCatalogoAA();
			bottoneMostraCatalogo.addActionListener(ascoltatoreBottoneMostraCatalogo);
			
			ascoltatoreBottoneMostraOfferta = new MostraOffertaAA();
			bottoneMostraOfferta.addActionListener(ascoltatoreBottoneMostraOfferta);
			
			ascoltatoreBottoneChiudiPannello = new ChiudiPannelloAA();
			bottoneChiudiPannello.addActionListener(ascoltatoreBottoneChiudiPannello);
			
			
	    	
	    	
	    } //Fine costruttore
	    
	    
	    public static void riattivaBottoni(){
    		
   		 bottoneMostraCatalogo.setEnabled(true);
   		 bottoneMostraOfferta.setEnabled(true);
   		 bottoneChiudiPannello.setEnabled(true);
   		
   	}
	    
	    
	    
	    
	    private class MostraCatalogoAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel1.setVisible(false);
				panel1.setVisible(true);
				
				bottoneMostraCatalogo.setEnabled(false);
		   		bottoneMostraOfferta.setEnabled(false);
		   		bottoneChiudiPannello.setEnabled(false);

				nextPanel = new JPanel();
				nextPanel.setSize(superPanel.getWidth(), superPanel.getHeight()/8*7);  
				nextPanel.setLocation(0,superPanel.getHeight()/8);			
				nextPanel.setLayout(null); 			
				superPanel.add(nextPanel);				
				nextPanel.setVisible(false);
				
				new BoundaryVisitatore_InfoViaggi_MostraCatalogo(nextPanel);
			
			}
			
		}	
		
		private class MostraOffertaAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel1.setVisible(false);
				panel1.setVisible(true);
				
				bottoneMostraCatalogo.setEnabled(false);
		   		bottoneMostraOfferta.setEnabled(false);
		   		bottoneChiudiPannello.setEnabled(false);


				nextPanel = new JPanel();
				nextPanel.setSize(superPanel.getWidth(), superPanel.getHeight()/8*7);  
				nextPanel.setLocation(0,superPanel.getHeight()/8);			
				nextPanel.setLayout(null); 			
				superPanel.add(nextPanel);				
				nextPanel.setVisible(false);
				
				new BoundaryVisitatore_InfoViaggi_MostraOfferta(nextPanel);

			}
			
		}
		
		private class ChiudiPannelloAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				
				superPanel.setVisible(false); 			    //chiude tutto questo pannello
				
				
				//riattiva i bottoni in base al ruolo.
				if (ruolo.equals("Progettista")){
					BoundaryProgettista.riattivaBottoni();
				}
				
				if (ruolo.equals("Promotore")){
					BoundaryPromotore.riattivaBottoni();
				}
				
				if (ruolo.equals("GestoreEccezioni")){
					BoundaryGestoreEccezioni.riattivaBottoni();
				}
				if (ruolo.equals("Venditore")){
					BoundaryVenditore.riattivaBottoni();
				}
				if (ruolo.equals("Cliente")){
					BoundaryCliente.riattivaBottoni();
				}
				if (ruolo.equals("Amministratore")){
					BoundaryAmministratore.riattivaBottoni();
				}
				if (ruolo.equals("Visitatore")){
					BoundaryVisitatore.riattivaBottoni();      
				}
				
							
			}
		}

}
