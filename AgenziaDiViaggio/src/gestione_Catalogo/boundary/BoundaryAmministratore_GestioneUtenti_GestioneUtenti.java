/**
 * 
 */
package gestione_Catalogo.boundary;

import gestione_Catalogo.control.ControlloreGestioneUtenti;
import gestione_Catalogo.entity.Utente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryAmministratore_GestioneUtenti_GestioneUtenti {
	
	/*
	 * Attributi di istanza
	 */
	
	//Entita'
	private ControlloreGestioneUtenti controllore;

	//Pannelli
	private JPanel superPanel;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;


	
	//Elementi Pannello1
	private JButton bottoneAggiungiUtente;
	private JButton bottoneRimuoviUtente;
	private JButton bottoneChiudiPannello1;
    
    private AggiungiUtenteAA ascoltatoreAggiungiUtente;
    private RimuoviUtenteAA ascoltatoreRimuoviUtente;
    private ChiudiPannello1AA ascoltatoreBottoneChiudiPannello1;


    
    //Elementi Pannello2
    private JLabel	labelTitoloPannello2;
   
	private JLabel labelRuoliPannello2;
	private JComboBox<String> tendinaRuoliPannello2;
	
	private JLabel labelNomePannello2;
	private JTextField campoNomePannello2;
	
	private JLabel labelCognomePannello2;
	private JTextField campoCognomePannello2;
	
	private JLabel labelEmailPannello2;
	private JTextField campoEmailPannello2;
	
	private JLabel labelUsernamePannello2;
	private JTextField campoUsernamePannello2;
	
	private JLabel labelPasswordPannello2;
	private JPasswordField campoPasswordPannello2;
	
	private JLabel labelRipetiPasswordPannello2;
	private JPasswordField campoRipetiPasswordPannello2;


	private JButton bottoneAggiungi;
	private JButton bottoneSvuotaPannello2;
	
	private JButton bottoneChiudiPannello2;

	private ChiudiPannello2AA ascoltatoreBottoneChiudiPannello2;
	private AggiungiAA ascoltatoreBottoneAggiungi;
	private SvuotaPannello2AA ascoltatoreBottoneSvuotaPannello2;

	
    //Elementi Pannello3
    private JLabel	labelTitoloPannello3;
   
	private JLabel labelRuoliPannello3;
	private JComboBox<String> tendinaRuoliPannello3;
	
	private JLabel labelUtentiPannello3;
	private JComboBox<String> tendinaUtentiPannello3;
	
	private JButton bottoneRimuovi;
	private JButton bottoneSvuotaPannello3;
	
	private JButton bottoneChiudiPannello3;

	private ChiudiPannello3AA ascoltatoreBottoneChiudiPannello3;
	private RimuoviAA ascoltatoreBottoneRimuovi;
	private SvuotaPannello3AA ascoltatoreBottoneSvuotaPannello3;

	
	

	public BoundaryAmministratore_GestioneUtenti_GestioneUtenti(JPanel nextPanel) {
		
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

		bottoneAggiungiUtente = new JButton("Aggiungi Utente");
		bottoneAggiungiUtente.setBackground(Color.GREEN);
		bottoneAggiungiUtente.setBounds(panel1.getWidth()/5, panel1.getHeight()/6, panel1.getWidth()/5, panel1.getHeight()/2);
		panel1.add(bottoneAggiungiUtente);
		
		
		bottoneRimuoviUtente = new JButton("Rimuovi Utente");
		bottoneRimuoviUtente.setBackground(Color.ORANGE);
		bottoneRimuoviUtente.setBounds(panel1.getWidth()/5*3, panel1.getHeight()/6, panel1.getWidth()/5, panel1.getHeight()/2);
		panel1.add(bottoneRimuoviUtente);
		
		bottoneChiudiPannello1 = new JButton("X");
		bottoneChiudiPannello1.setBackground(Color.RED);
		bottoneChiudiPannello1.setBounds(panel1.getWidth()/20*19, 0, panel1.getWidth()/20, panel1.getHeight()/2-3);
		panel1.add(bottoneChiudiPannello1);
		
		// ascoltatori per primo pannello
		ascoltatoreAggiungiUtente = new AggiungiUtenteAA(); 		
		bottoneAggiungiUtente.addActionListener(ascoltatoreAggiungiUtente); 
		
		ascoltatoreRimuoviUtente = new RimuoviUtenteAA(); 		
		bottoneRimuoviUtente.addActionListener(ascoltatoreRimuoviUtente); 
				
		ascoltatoreBottoneChiudiPannello1 = new ChiudiPannello1AA();
		bottoneChiudiPannello1.addActionListener(ascoltatoreBottoneChiudiPannello1);
		
		
		/*
		 * secondo pannello
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
		labelTitoloPannello2.setText("AGGIUNGI UTENTE");
		panel2.add(labelTitoloPannello2);
		

	    labelRuoliPannello2 = new JLabel();        
	    labelRuoliPannello2.setFont(new Font("Arial", 0, 15));
	    labelRuoliPannello2.setBounds(panel2.getWidth()/4*2-180, panel2.getHeight()/5, panel2.getWidth()/4, 20);
	    labelRuoliPannello2.setText("TIPO DI UTENTE");
		panel2.add(labelRuoliPannello2);
		
		tendinaRuoliPannello2 = new JComboBox<String>(Utente.RUOLI);
		tendinaRuoliPannello2.setBackground(Color.WHITE);
		tendinaRuoliPannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5, panel2.getWidth()/4, 20);
		panel2.add(tendinaRuoliPannello2);
		
		
	    labelNomePannello2 = new JLabel();        
	    labelNomePannello2.setFont(new Font("Arial", 0, 15));
	    labelNomePannello2.setBounds(panel2.getWidth()/4*2-180, panel2.getHeight()/5+25, panel2.getWidth()/4, 20);
	    labelNomePannello2.setText("NOME");
		panel2.add(labelNomePannello2);
		
		campoNomePannello2 = new JTextField(panel2.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
		campoNomePannello2.setFont(new Font("Arial", 0, 18));
		campoNomePannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+25, panel2.getWidth()/4, 20);
		panel2.add(campoNomePannello2);
		
		
	    labelCognomePannello2 = new JLabel();        
	    labelCognomePannello2.setFont(new Font("Arial", 0, 15));
	    labelCognomePannello2.setBounds(panel2.getWidth()/4*2-180, panel2.getHeight()/5+50, panel2.getWidth()/4, 20);
	    labelCognomePannello2.setText("COGNOME");
		panel2.add(labelCognomePannello2);
		
		campoCognomePannello2 = new JTextField(panel2.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
		campoCognomePannello2.setFont(new Font("Arial", 0, 18));
		campoCognomePannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+50, panel2.getWidth()/4, 20);
		panel2.add(campoCognomePannello2);
		
		
	    labelEmailPannello2 = new JLabel();        
	    labelEmailPannello2.setFont(new Font("Arial", 0, 15));
	    labelEmailPannello2.setBounds(panel2.getWidth()/4*2-180, panel2.getHeight()/5+75, panel2.getWidth()/4, 20);
	    labelEmailPannello2.setText("EMAIL");
		panel2.add(labelEmailPannello2);
		
		campoEmailPannello2 = new JTextField(panel2.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
		campoEmailPannello2.setFont(new Font("Arial", 0, 18));
		campoEmailPannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+75, panel2.getWidth()/4, 20);
		panel2.add(campoEmailPannello2);
		
		
		
		
	    labelUsernamePannello2 = new JLabel();        
	    labelUsernamePannello2.setFont(new Font("Arial", 0, 15));
	    labelUsernamePannello2.setBounds(panel2.getWidth()/4*2-180, panel2.getHeight()/5+100, panel2.getWidth()/4, 20);
	    labelUsernamePannello2.setText("USERNAME");
		panel2.add(labelUsernamePannello2);
		
		campoUsernamePannello2 = new JTextField(panel2.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
		campoUsernamePannello2.setFont(new Font("Arial", 0, 18));
		campoUsernamePannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+100, panel2.getWidth()/4, 20);
		panel2.add(campoUsernamePannello2);
		
	    
	    labelPasswordPannello2 = new JLabel();        
	    labelPasswordPannello2.setFont(new Font("Arial", 0, 15));
	    labelPasswordPannello2.setBounds(panel2.getWidth()/4*2-180, panel2.getHeight()/5+125, panel2.getWidth()/4, 20);
	    labelPasswordPannello2.setText("PASSWORD");
		panel2.add(labelPasswordPannello2);
		
		campoPasswordPannello2 = new JPasswordField(panel2.getWidth()/5*2);
		campoPasswordPannello2.setFont(new Font("Arial", 0, 18));
		campoPasswordPannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+125, panel2.getWidth()/4, 20);
	    panel2.add(campoPasswordPannello2);
	    
	    
	    labelRipetiPasswordPannello2 = new JLabel();        
	    labelRipetiPasswordPannello2.setFont(new Font("Arial", 0, 15));
	    labelRipetiPasswordPannello2.setBounds(panel2.getWidth()/4*2-180, panel2.getHeight()/5+150, panel2.getWidth()/4, 20);
	    labelRipetiPasswordPannello2.setText("RIPETI PASSWORD");
		panel2.add(labelRipetiPasswordPannello2);
		
		campoRipetiPasswordPannello2 = new JPasswordField(panel2.getWidth()/5*2);
		campoRipetiPasswordPannello2.setFont(new Font("Arial", 0, 18));
		campoRipetiPasswordPannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+150, panel2.getWidth()/4, 20);
	    panel2.add(campoRipetiPasswordPannello2);
	    
	    
		bottoneSvuotaPannello2 = new JButton("AZZERA CAMPI");
		bottoneSvuotaPannello2.setBackground(Color.YELLOW);
		bottoneSvuotaPannello2.setBounds(panel2.getWidth()/10*3-25, panel2.getHeight()/5*4+15, panel2.getWidth()/5, panel2.getHeight()/11);
		panel2.add(bottoneSvuotaPannello2);
		
		bottoneAggiungi = new JButton("AGGIUNGI UTENTE");
		bottoneAggiungi.setBackground(Color.ORANGE);
		bottoneAggiungi.setBounds(panel2.getWidth()/10*5+25, panel2.getHeight()/5*4+15, panel2.getWidth()/5, panel2.getHeight()/11);
		panel2.add(bottoneAggiungi);
		
		bottoneChiudiPannello2 = new JButton("X");
		bottoneChiudiPannello2.setBackground(Color.RED);
		bottoneChiudiPannello2.setBounds(panel2.getWidth()/20*19, 0, panel2.getWidth()/20, panel2.getHeight()/18);
		panel2.add(bottoneChiudiPannello2);
		
		//Ascoltatori pannello 2
		ascoltatoreBottoneSvuotaPannello2 = new SvuotaPannello2AA();
		bottoneSvuotaPannello2.addActionListener(ascoltatoreBottoneSvuotaPannello2);
		
		ascoltatoreBottoneAggiungi = new AggiungiAA();
		bottoneAggiungi.addActionListener(ascoltatoreBottoneAggiungi);
		
		ascoltatoreBottoneChiudiPannello2			= new ChiudiPannello2AA();
		bottoneChiudiPannello2.addActionListener(ascoltatoreBottoneChiudiPannello2);
		
		
		
		/*
		 * terzo pannello
		 */
		panel3 = new JPanel();
		panel3.setSize(superPanel.getWidth(), superPanel.getHeight()/7*6);
		panel3.setLocation(0, superPanel.getHeight()/7);	
		panel3.setLayout(null); 			//ora il pannello puo' contenere oggetti
		superPanel.add(panel3);
		panel3.setVisible(false); 			//deve essere invisibile all'inizio, attivato solo dal bottone
		
		labelTitoloPannello3 = new JLabel();	
		labelTitoloPannello3.setFont(new Font("Arial", 0, 20));
		labelTitoloPannello3.setBounds(panel3.getWidth()/3, panel3.getHeight()/49, panel3.getWidth()/3, panel3.getHeight()/7);
		labelTitoloPannello3.setVerticalAlignment(JLabel.CENTER);
		labelTitoloPannello3.setHorizontalAlignment(JLabel.CENTER);
		labelTitoloPannello3.setText("RIMUOVI UTENTE");
		panel3.add(labelTitoloPannello3);
		

	    labelRuoliPannello3 = new JLabel();        
	    labelRuoliPannello3.setFont(new Font("Arial", 0, 15));
	    labelRuoliPannello3.setBounds(panel3.getWidth()/8*3, panel3.getHeight()/4, panel3.getWidth()/4, 20);
	    labelRuoliPannello3.setText("Tipo di Utente");
		panel3.add(labelRuoliPannello3);
		
		tendinaRuoliPannello3 = new JComboBox<String>();
		tendinaRuoliPannello3.setBackground(Color.WHITE);
		tendinaRuoliPannello3.setBounds(panel3.getWidth()/8*3, panel3.getHeight()/4+20, panel3.getWidth()/4, 20);
		panel3.add(tendinaRuoliPannello3);
		
		
	    labelUtentiPannello3 = new JLabel();        
	    labelUtentiPannello3.setFont(new Font("Arial", 0, 15));
	    labelUtentiPannello3.setBounds(panel3.getWidth()/8*3, panel3.getHeight()/4*2, panel3.getWidth()/4, 20);
	    labelUtentiPannello3.setText("Utente");
		panel3.add(labelUtentiPannello3);
		
		tendinaUtentiPannello3 = new JComboBox<String>();
		tendinaUtentiPannello3.setBackground(Color.WHITE);
		tendinaUtentiPannello3.setBounds(panel3.getWidth()/8*3, panel3.getHeight()/4*2+20, panel3.getWidth()/4, 20);
		panel3.add(tendinaUtentiPannello3);
		
		
		bottoneSvuotaPannello3 = new JButton("AZZERA CAMPI");
		bottoneSvuotaPannello3.setBackground(Color.YELLOW);
		bottoneSvuotaPannello3.setBounds(panel3.getWidth()/10*3-25, panel3.getHeight()/5*4+15, panel3.getWidth()/5, panel3.getHeight()/11);
		panel3.add(bottoneSvuotaPannello3);
		
		bottoneRimuovi = new JButton("RIMUOVI UTENTE");
		bottoneRimuovi.setBackground(Color.ORANGE);
		bottoneRimuovi.setBounds(panel3.getWidth()/10*5+25, panel3.getHeight()/5*4+15, panel3.getWidth()/5, panel3.getHeight()/11);
		panel3.add(bottoneRimuovi);
		
		bottoneChiudiPannello3 = new JButton("X");
		bottoneChiudiPannello3.setBackground(Color.RED);
		bottoneChiudiPannello3.setBounds(panel3.getWidth()/20*19, 0, panel3.getWidth()/20, panel3.getHeight()/18);
		panel3.add(bottoneChiudiPannello3);
		
		//Ascoltatori pannello 3
		ascoltatoreBottoneSvuotaPannello3 = new SvuotaPannello3AA();
		bottoneSvuotaPannello3.addActionListener(ascoltatoreBottoneSvuotaPannello3);
		
		ascoltatoreBottoneRimuovi = new RimuoviAA();
		bottoneRimuovi.addActionListener(ascoltatoreBottoneRimuovi);
		
		ascoltatoreBottoneChiudiPannello3 = new ChiudiPannello3AA();
		bottoneChiudiPannello3.addActionListener(ascoltatoreBottoneChiudiPannello3);
		
		
		
	}
	
	/*
	 * Classi Ascoltatori per bottoni pannello 1
	 */
	
	private class AggiungiUtenteAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel1.setVisible(false);
			panel1.setVisible(true);
			panel2.setVisible(true);  //attiva pannello 2
			
			bottoneAggiungiUtente.setEnabled(false); //disattiva i bottoni
			bottoneRimuoviUtente.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
		
		}
		
	}	
	
	private class RimuoviUtenteAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel1.setVisible(false);
			panel1.setVisible(true);
			panel3.setVisible(true);  //attiva pannello 2
			
			bottoneAggiungiUtente.setEnabled(false); //disattiva i bottoni
			bottoneRimuoviUtente.setEnabled(false);
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
	
	
	/*
	 * Classi Ascoltatori per bottoni pannello 2
	 */
	
	private class AggiungiAA implements ActionListener{

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
			
			//tendinaRuoliPannello2.setSelectedIndex(0);
			campoNomePannello2.setText(null);
			campoCognomePannello2.setText(null);
			campoUsernamePannello2.setText(null);
			campoPasswordPannello2.setText(null);
			campoRipetiPasswordPannello2.setText(null);

		}
		
	}
	
	private class ChiudiPannello2AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			panel2.setVisible(false); 					//chiude questo pannello
			bottoneAggiungiUtente.setEnabled(true); //riattiva i bottoni
			bottoneRimuoviUtente.setEnabled(true);
			bottoneChiudiPannello1.setEnabled(true);
						
			//svuoto cmq il pannello
			//tendinaRuoliPannello2.setSelectedIndex(0);
			campoNomePannello2.setText(null);
			campoCognomePannello2.setText(null);
			campoUsernamePannello2.setText(null);
			campoPasswordPannello2.setText(null);
			campoRipetiPasswordPannello2.setText(null);

			
		}
	}

	
	
	/*
	 * Classi Ascoltatori per bottoni pannello 3
	 */
	
	private class RimuoviAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			/*
			 * DA IMPLEMENTARE
			 */
			
		}
		
	}
	
	
	
	private class SvuotaPannello3AA implements ActionListener{
		/*
		 * Svuota tutti i campi
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//tendinaRuoliPannello3.setSelectedIndex(0);
			

		}
		
	}
	
	private class ChiudiPannello3AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			panel3.setVisible(false); 					//chiude questo pannello
			bottoneAggiungiUtente.setEnabled(true); //riattiva i bottoni
			bottoneRimuoviUtente.setEnabled(true);
			bottoneChiudiPannello1.setEnabled(true);
						
			//svuoto cmq il pannello
			//tendinaRuoliPannello3.setSelectedIndex(0);

			
		}
	}

	

}
