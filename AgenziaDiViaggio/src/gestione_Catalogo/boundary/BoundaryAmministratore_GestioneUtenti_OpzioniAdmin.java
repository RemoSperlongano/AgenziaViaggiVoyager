/**
 * 
 */
package gestione_Catalogo.boundary;

import gestione_Catalogo.control.ControlloreGestioneUtenti;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryAmministratore_GestioneUtenti_OpzioniAdmin {

	
	/*
	 * Attributi di istanza
	 */
	
	//Entita'
	private ControlloreGestioneUtenti controllore;

	//Pannelli
	private JPanel superPanel;
	
	private JPanel panel1;
	private JPanel panel2;


	
	//Elementi Pannello1
	private JButton bottoneCambiaPassword;
	private JButton bottoneChiudiPannello1;
    
    private CambiaPasswordAA ascoltatoreBottoneCambiaPassword;
    private ChiudiPannello1AA ascoltatoreBottoneChiudiPannello1;

    
    //Elementi Pannello2
    private JLabel	labelTitoloPannello2;
    

	private JLabel labelVecchiaPassword;
	private JPasswordField campoVecchiaPassword;
	
	private JLabel labelNuovaPassword;
	private JPasswordField campoNuovaPassword;
	
	private JLabel labelRipetiPassword;
	private JPasswordField campoRipetiPassword;


	private JButton bottoneInvia;
	private JButton bottoneSvuotaPannello2;
	
	private JButton bottoneChiudiPannello2;

	private ChiudiPannello2AA ascoltatoreBottoneChiudiPannello2;
	private InviaAA ascoltatoreBottoneInvia;
	private SvuotaPannello2AA ascoltatoreBottoneSvuotaPannello2;

	

	public BoundaryAmministratore_GestioneUtenti_OpzioniAdmin(JPanel nextPanel) {
		
		controllore = new ControlloreGestioneUtenti();
		
		
		/*
		 * Il superPanel di questa Boundary prende le dimensioni del pannello Passato 
		 */
		superPanel = nextPanel;
		superPanel.setVisible(true);   //Si vede ora!
		
		
		/*
		 * primo pannello 
		 */
		panel1 = new JPanel();
		panel1.setSize(superPanel.getWidth(), superPanel.getHeight()/7-10);  //Il meno 10 serve per far vedere il contorno 
		panel1.setLocation(0,0);			//x=0 e y=0 rispetto al superPanel
		panel1.setLayout(null); 			//ora il pannello puo' contenere oggetti
		superPanel.add(panel1);				//aggiungo il primo pannello al superPannello
		panel1.setVisible(true);

		bottoneCambiaPassword = new JButton("Cambia Password");
		bottoneCambiaPassword.setBackground(Color.ORANGE);
		bottoneCambiaPassword.setBounds(panel1.getWidth()/5*2, panel1.getHeight()/6, panel1.getWidth()/5, panel1.getHeight()/2);
		panel1.add(bottoneCambiaPassword);
		
		
		bottoneChiudiPannello1 = new JButton("X");
		bottoneChiudiPannello1.setBackground(Color.RED);
		bottoneChiudiPannello1.setBounds(panel1.getWidth()/20*19, 0, panel1.getWidth()/20, panel1.getHeight()/2-3);
		panel1.add(bottoneChiudiPannello1);
		
		// ascoltatori per primo pannello
		ascoltatoreBottoneCambiaPassword = new CambiaPasswordAA(); 		
		bottoneCambiaPassword.addActionListener(ascoltatoreBottoneCambiaPassword); 	
				
		ascoltatoreBottoneChiudiPannello1 = new ChiudiPannello1AA();
		bottoneChiudiPannello1.addActionListener(ascoltatoreBottoneChiudiPannello1);
		
		
		/*
		 * secondo pannello: questo pannello si attiva premendo il bottone AGGIUNGI VIAGGIO del primo pannello
		 */
		panel2 = new JPanel();
		panel2.setSize(superPanel.getWidth(), superPanel.getHeight()/7*6);
		panel2.setLocation(0, superPanel.getHeight()/7);	
		panel2.setLayout(null); 			//ora il pannello puo' contenere oggetti
		superPanel.add(panel2);
		panel2.setVisible(false); 			//deve essere invisibile all'inizio, attivato solo dal bottone
		
		labelTitoloPannello2 = new JLabel();	
		labelTitoloPannello2.setFont(new Font("Arial", 0, 20));
		labelTitoloPannello2.setBounds(panel2.getWidth()/3, panel2.getHeight()/49, panel2.getWidth()/3, panel2.getHeight()/7);
		labelTitoloPannello2.setVerticalAlignment(JLabel.CENTER);
		labelTitoloPannello2.setHorizontalAlignment(JLabel.CENTER);
		labelTitoloPannello2.setText("CAMBIA PASSWORD");
		panel2.add(labelTitoloPannello2);
		

	    labelVecchiaPassword = new JLabel();        
	    labelVecchiaPassword.setFont(new Font("Arial", 0, 15));
	    labelVecchiaPassword.setBounds(panel2.getWidth()/4*2-230, panel2.getHeight()/5+15, panel2.getWidth()/4, 20);
	    labelVecchiaPassword.setText("VECCHIA PASSWORD");
		panel2.add(labelVecchiaPassword);
		
		campoVecchiaPassword = new JPasswordField(panel2.getWidth()/5*2);
		campoVecchiaPassword.setFont(new Font("Arial", 0, 18));
		campoVecchiaPassword.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+15, panel2.getWidth()/4, 20);
	    panel2.add(campoVecchiaPassword);
	    
	    
	    labelNuovaPassword = new JLabel();        
	    labelNuovaPassword.setFont(new Font("Arial", 0, 15));
	    labelNuovaPassword.setBounds(panel2.getWidth()/4*2-230, panel2.getHeight()/5*2+15, panel2.getWidth()/4, 20);
	    labelNuovaPassword.setText("NUOVA PASSWORD");
		panel2.add(labelNuovaPassword);
		
		campoNuovaPassword = new JPasswordField(panel2.getWidth()/5*2);
		campoNuovaPassword.setFont(new Font("Arial", 0, 18));
		campoNuovaPassword.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5*2+15, panel2.getWidth()/4, 20);
	    panel2.add(campoNuovaPassword);
	    
	    
	    labelRipetiPassword = new JLabel();        
	    labelRipetiPassword.setFont(new Font("Arial", 0, 15));
	    labelRipetiPassword.setBounds(panel2.getWidth()/4*2-230, panel2.getHeight()/5*3+15, panel2.getWidth()/4, 20);
	    labelRipetiPassword.setText("RIPETI NUOVA PASSWORD");
		panel2.add(labelRipetiPassword);
		
		campoRipetiPassword = new JPasswordField(panel2.getWidth()/5*2);
		campoRipetiPassword.setFont(new Font("Arial", 0, 18));
		campoRipetiPassword.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5*3+15, panel2.getWidth()/4, 20);
	    panel2.add(campoRipetiPassword);
	    
	    
		bottoneSvuotaPannello2 = new JButton("AZZERA CAMPI");
		bottoneSvuotaPannello2.setBackground(Color.YELLOW);
		bottoneSvuotaPannello2.setBounds(panel2.getWidth()/10*3-25, panel2.getHeight()/5*4+15, panel2.getWidth()/5, panel2.getHeight()/11);
		panel2.add(bottoneSvuotaPannello2);
		
		bottoneInvia = new JButton("CAMBIA PASSWORD");
		bottoneInvia.setBackground(Color.ORANGE);
		bottoneInvia.setBounds(panel2.getWidth()/10*5+25, panel2.getHeight()/5*4+15, panel2.getWidth()/5, panel2.getHeight()/11);
		panel2.add(bottoneInvia);
		
		bottoneChiudiPannello2 = new JButton("X");
		bottoneChiudiPannello2.setBackground(Color.RED);
		bottoneChiudiPannello2.setBounds(panel2.getWidth()/20*19, 0, panel2.getWidth()/20, panel2.getHeight()/18);
		panel2.add(bottoneChiudiPannello2);
		
		//Ascoltatori pannello 2
		ascoltatoreBottoneSvuotaPannello2 = new SvuotaPannello2AA();
		bottoneSvuotaPannello2.addActionListener(ascoltatoreBottoneSvuotaPannello2);
		
		ascoltatoreBottoneInvia = new InviaAA();
		bottoneInvia.addActionListener(ascoltatoreBottoneInvia);
		
		ascoltatoreBottoneChiudiPannello2			= new ChiudiPannello2AA();
		bottoneChiudiPannello2.addActionListener(ascoltatoreBottoneChiudiPannello2);
		
	}
	
	/*
	 * Classi Ascoltatori per bottoni pannello 1
	 */
	
	private class CambiaPasswordAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel1.setVisible(false);
			panel1.setVisible(true);
			panel2.setVisible(true);  //attiva pannello 2
			
			bottoneCambiaPassword.setEnabled(false); //disattiva i bottoni
			bottoneChiudiPannello1.setEnabled(false);
		
		}
		
	}	
	
	
	private class ChiudiPannello1AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			superPanel.setVisible(false); 			    //chiude tutto questo pannello
			
			//riattiva i bottoni.
			BoundaryAmministratore_GestioneUtenti.riattivaBottoni();
						
		}
	}
	
	private class InviaAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			/*
			 * DA IMPLEMENTARE
			 */
			
		}
		
	}
	
	
	
	private class SvuotaPannello2AA implements ActionListener{
		/*
		 * Svuota tutti i campi
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
	
			campoVecchiaPassword.setText(null);	//svuota tutti i campi testo
			campoNuovaPassword.setText(null);
			campoRipetiPassword.setText(null);

		}
		
	}
	
	private class ChiudiPannello2AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			panel2.setVisible(false); 					//chiude questo pannello
			bottoneCambiaPassword.setEnabled(true);	//riattiva i bottoni
			bottoneChiudiPannello1.setEnabled(true);
						
			//svuoto cmq il pannello
			campoVecchiaPassword.setText(null);	
			campoNuovaPassword.setText(null);
			campoRipetiPassword.setText(null);
			
		}
	}

	
	

}
