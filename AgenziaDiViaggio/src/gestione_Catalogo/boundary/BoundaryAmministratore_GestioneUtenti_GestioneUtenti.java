/**
 * 
 */
package gestione_Catalogo.boundary;

import gestione_Catalogo.control.ControlloreGestioneUtenti;
import gestione_Catalogo.entity.Utente;
import gestione_Catalogo.exception.DatiPersonaliErratiException;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.UtenteEsistenteException;
import gestione_Catalogo.exception.UtenteInesistenteException;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private String ruoloScelto;

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

	private TendinaRuoliPannello3AA ascoltatoreTendinaRuoliPannello3;
	private ChiudiPannello3AA ascoltatoreBottoneChiudiPannello3;
	private RimuoviAA ascoltatoreBottoneRimuovi;
	private SvuotaPannello3AA ascoltatoreBottoneSvuotaPannello3;

	
	

	public BoundaryAmministratore_GestioneUtenti_GestioneUtenti(JPanel nextPanel) {
		
		controllore = new ControlloreGestioneUtenti();
		ruoloScelto = null;
		
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
		bottoneAggiungiUtente.setBackground(Color.CYAN);
		bottoneAggiungiUtente.setBounds(panel1.getWidth()/5, panel1.getHeight()/6, panel1.getWidth()/5, panel1.getHeight()/2);
		panel1.add(bottoneAggiungiUtente);
		
		
		bottoneRimuoviUtente = new JButton("Rimuovi Utente");
		bottoneRimuoviUtente.setBackground(Color.YELLOW);
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
	    labelRuoliPannello2.setBounds(panel2.getWidth()/4*2-200, panel2.getHeight()/5, panel2.getWidth()/4, 20);
	    labelRuoliPannello2.setText("TIPO DI UTENTE");
		panel2.add(labelRuoliPannello2);
		
		tendinaRuoliPannello2 = new JComboBox<String>(Utente.RUOLI);
		tendinaRuoliPannello2.setBackground(Color.WHITE);
		tendinaRuoliPannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5, panel2.getWidth()/4, 20);
		panel2.add(tendinaRuoliPannello2);
		
		
	    labelNomePannello2 = new JLabel();        
	    labelNomePannello2.setFont(new Font("Arial", 0, 15));
	    labelNomePannello2.setBounds(panel2.getWidth()/4*2-200, panel2.getHeight()/5+25, panel2.getWidth()/4, 20);
	    labelNomePannello2.setText("NOME");
		panel2.add(labelNomePannello2);
		
		campoNomePannello2 = new JTextField(panel2.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
		campoNomePannello2.setFont(new Font("Arial", 0, 18));
		campoNomePannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+25, panel2.getWidth()/4, 20);
		panel2.add(campoNomePannello2);
		
		
	    labelCognomePannello2 = new JLabel();        
	    labelCognomePannello2.setFont(new Font("Arial", 0, 15));
	    labelCognomePannello2.setBounds(panel2.getWidth()/4*2-200, panel2.getHeight()/5+50, panel2.getWidth()/4, 20);
	    labelCognomePannello2.setText("COGNOME");
		panel2.add(labelCognomePannello2);
		
		campoCognomePannello2 = new JTextField(panel2.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
		campoCognomePannello2.setFont(new Font("Arial", 0, 18));
		campoCognomePannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+50, panel2.getWidth()/4, 20);
		panel2.add(campoCognomePannello2);
		
		
	    labelEmailPannello2 = new JLabel();        
	    labelEmailPannello2.setFont(new Font("Arial", 0, 15));
	    labelEmailPannello2.setBounds(panel2.getWidth()/4*2-200, panel2.getHeight()/5+75, panel2.getWidth()/4, 20);
	    labelEmailPannello2.setText("EMAIL");
		panel2.add(labelEmailPannello2);
		
		campoEmailPannello2 = new JTextField(panel2.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
		campoEmailPannello2.setFont(new Font("Arial", 0, 18));
		campoEmailPannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+75, panel2.getWidth()/4, 20);
		panel2.add(campoEmailPannello2);
		
		
		
		
	    labelUsernamePannello2 = new JLabel();        
	    labelUsernamePannello2.setFont(new Font("Arial", 0, 15));
	    labelUsernamePannello2.setBounds(panel2.getWidth()/4*2-200, panel2.getHeight()/5+100, panel2.getWidth()/4, 20);
	    labelUsernamePannello2.setText("USERNAME");
		panel2.add(labelUsernamePannello2);
		
		campoUsernamePannello2 = new JTextField(panel2.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
		campoUsernamePannello2.setFont(new Font("Arial", 0, 18));
		campoUsernamePannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+100, panel2.getWidth()/4, 20);
		panel2.add(campoUsernamePannello2);
		
	    
	    labelPasswordPannello2 = new JLabel();        
	    labelPasswordPannello2.setFont(new Font("Arial", 0, 15));
	    labelPasswordPannello2.setBounds(panel2.getWidth()/4*2-200, panel2.getHeight()/5+125, panel2.getWidth()/4, 20);
	    labelPasswordPannello2.setText("PASSWORD");
		panel2.add(labelPasswordPannello2);
		
		campoPasswordPannello2 = new JPasswordField(panel2.getWidth()/5*2);
		campoPasswordPannello2.setFont(new Font("Arial", 0, 18));
		campoPasswordPannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+125, panel2.getWidth()/4, 20);
	    panel2.add(campoPasswordPannello2);
	    
	    
	    labelRipetiPasswordPannello2 = new JLabel();        
	    labelRipetiPasswordPannello2.setFont(new Font("Arial", 0, 15));
	    labelRipetiPasswordPannello2.setBounds(panel2.getWidth()/4*2-200, panel2.getHeight()/5+150, panel2.getWidth()/4, 20);
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
		tendinaRuoliPannello3.setEnabled(false);
		panel3.add(tendinaRuoliPannello3);
		
		
	    labelUtentiPannello3 = new JLabel();        
	    labelUtentiPannello3.setFont(new Font("Arial", 0, 15));
	    labelUtentiPannello3.setBounds(panel3.getWidth()/8*3, panel3.getHeight()/4*2, panel3.getWidth()/4, 20);
	    labelUtentiPannello3.setText("Utente");
		panel3.add(labelUtentiPannello3);
		
		tendinaUtentiPannello3 = new JComboBox<String>();
		tendinaUtentiPannello3.setBackground(Color.WHITE);
		tendinaUtentiPannello3.setBounds(panel3.getWidth()/8*3, panel3.getHeight()/4*2+20, panel3.getWidth()/4, 20);
		tendinaUtentiPannello3.setEnabled(false);
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
		ascoltatoreTendinaRuoliPannello3 = new TendinaRuoliPannello3AA();
		tendinaRuoliPannello3.addActionListener(ascoltatoreTendinaRuoliPannello3);
		
		ascoltatoreBottoneSvuotaPannello3 = new SvuotaPannello3AA();
		bottoneSvuotaPannello3.addActionListener(ascoltatoreBottoneSvuotaPannello3);
		
		ascoltatoreBottoneRimuovi = new RimuoviAA();
		bottoneRimuovi.addActionListener(ascoltatoreBottoneRimuovi);
		
		ascoltatoreBottoneChiudiPannello3 = new ChiudiPannello3AA();
		bottoneChiudiPannello3.addActionListener(ascoltatoreBottoneChiudiPannello3);
		
	}

	

	private void controlloSintatticoDati(String nome, String cognome, String email, String username, String password, String ripetiPsw) throws DatiPersonaliErratiException {
		if (nome.equals("")||cognome.equals("")||email.equals("")||username.equals("")||password.equals("")||ripetiPsw.equals("")){
			throw new DatiPersonaliErratiException("Tutti i campi devono essere compilati.");
		}
		if (!password.equals(ripetiPsw)){
			throw new DatiPersonaliErratiException("I campi Password sono differenti. Controllare la password inserita...");
		}
		if (!email.contains("@")){
			throw new DatiPersonaliErratiException("Indirizzo email non valido. Controllare i dati inseriti...");
		}
		
	}
	
	
	//rende maiuscola la prima lettera di ogni parola della stringa passata come parametro, sostituisce spazi multipli con spazio singolo
	private String uppercaseFirstLetters(String str) {
	    boolean prevWasWhiteSp = true;
	    char[] chars = str.trim().replaceAll("\\s+"," ").toLowerCase().toCharArray();
	    for (int i = 0; i < chars.length; i++) {
	        if (Character.isLetter(chars[i])){
	            if (prevWasWhiteSp) {
	                chars[i] = Character.toUpperCase(chars[i]);    
	            } 
	            prevWasWhiteSp = false;
	        } else {
	            prevWasWhiteSp = Character.isWhitespace(chars[i]);
	        }
	    }
	    return new String(chars);
	}
	

	private void svuotaPannello2() {
		tendinaRuoliPannello2.setSelectedIndex(0);
		campoNomePannello2.setText(null);
		campoCognomePannello2.setText(null);
		campoEmailPannello2.setText(null);
		campoUsernamePannello2.setText(null);
		campoPasswordPannello2.setText(null);
		campoRipetiPasswordPannello2.setText(null);
	}
	
	private void aggiornaTendinePannello3(){
		ruoloScelto = null;
		tendinaRuoliPannello3.removeAllItems();
		tendinaRuoliPannello3.setEnabled(false);
			
		ArrayList<String> ruoli = controllore.mostraRuoliUtenza();
		for(String s : ruoli){ 					
			tendinaRuoliPannello3.addItem(s);  
		}
			
		tendinaRuoliPannello3.setEnabled(true);
		
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
			
			aggiornaTendinePannello3();
		
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

			String nome = uppercaseFirstLetters(campoNomePannello2.getText());
			String cognome = uppercaseFirstLetters(campoCognomePannello2.getText());
			String email = campoEmailPannello2.getText().toLowerCase();
			
			String username = campoUsernamePannello2.getText();
			String password = String.valueOf(campoPasswordPannello2.getPassword());
			String ripetiPsw = String.valueOf(campoRipetiPasswordPannello2.getPassword());
			String ruolo = (String) tendinaRuoliPannello2.getSelectedItem();
			
			try {
				
				controlloSintatticoDati(nome, cognome, email, username, password, ripetiPsw);
				
				int conferma = JOptionPane.showConfirmDialog(null, "Aggiungere il nuovo utente?", "Conferma Nuovo Utente", JOptionPane.YES_NO_OPTION);				
			
				if (conferma == JOptionPane.YES_OPTION){	
					controllore.aggiungiUtente(nome, cognome, email, username, password, ruolo);
					JOptionPane.showMessageDialog(null, "Il nuovo utente e' stato aggiunto correttamente ed e' abilitato all'uso del sistema.", "Nuovo Utente Aggiunto", JOptionPane.INFORMATION_MESSAGE);
					svuotaPannello2();
				}
	
			} catch (DatiPersonaliErratiException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Attenzione!", JOptionPane.WARNING_MESSAGE);
			} catch (UtenteEsistenteException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Attenzione!", JOptionPane.WARNING_MESSAGE);
			}
			
		}


	}
	
	
	
	private class SvuotaPannello2AA implements ActionListener{
		/*
		 * Svuota tutti i campi
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			svuotaPannello2();
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
			svuotaPannello2();

		}
	}

	
	
	/*
	 * Classi Ascoltatori per bottoni pannello 3
	 */
	
	private class TendinaRuoliPannello3AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaUtentiPannello3.removeAllItems();
			tendinaUtentiPannello3.setEnabled(false);
			
			//prendo il valore di questa tendina
			ruoloScelto	= (String)tendinaRuoliPannello3.getSelectedItem();
			
			if (tendinaRuoliPannello3.getItemCount() != 0) { 
				ArrayList<String> utenti = controllore.mostraUtentiPerRuolo(ruoloScelto);
				for (String s : utenti){
					tendinaUtentiPannello3.addItem(s);
				}
			}
			
			tendinaUtentiPannello3.setEnabled(true);		
		}
		
	}
	
	
	private class RimuoviAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if (tendinaUtentiPannello3.getItemCount() != 0){
				String utente = (String) tendinaUtentiPannello3.getSelectedItem();
				// chiedo conferma
				int conferma = JOptionPane.showConfirmDialog(null, "Rimuovere l'utente selezionato?", "Conferma Rimozione Utente", JOptionPane.YES_NO_OPTION);
				if (conferma == JOptionPane.YES_OPTION){
					try {
						controllore.rimuoviUtente(utente,ruoloScelto);
						JOptionPane.showMessageDialog(null, "L'utente e' stato rimosso dal sistema.", "Utente Rimosso", JOptionPane.INFORMATION_MESSAGE);
						aggiornaTendinePannello3();
					} catch (UtenteInesistenteException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (DirittiException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), e1.toString(), JOptionPane.ERROR_MESSAGE);
					}

				}
				
			}
			
		}
		
	}
	
	
	
	private class SvuotaPannello3AA implements ActionListener{
		/*
		 * Svuota tutti i campi
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			aggiornaTendinePannello3();
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
			ruoloScelto=null;
			tendinaRuoliPannello3.removeAllItems();
			tendinaRuoliPannello3.setEnabled(false);
			

			
		}
	}

	

}
