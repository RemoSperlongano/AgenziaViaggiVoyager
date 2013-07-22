/**
 * 
 */
package gestione_Catalogo.boundary;

import gestione_Catalogo.control.ControlloreGestioneUtenti;
import gestione_Catalogo.exception.CredenzialiErrateException;
import gestione_Catalogo.exception.DatiPersonaliErratiException;
import gestione_Catalogo.exception.UtenteInesistenteException;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
public class BoundaryCliente_GestioneProfiloPersonale {

	private String ruolo;
	
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
	private JButton bottoneCambiaPassword;
	private JButton bottoneCambiaEmail;
	private JButton bottoneChiudiPannello1;
    
    private CambiaPasswordAA ascoltatoreBottoneCambiaPassword;
    private CambiaEmailAA ascoltatoreBottoneCambiaEmail;
    private ChiudiPannello1AA ascoltatoreBottoneChiudiPannello1;

    
    //Elementi Pannello2
    private JLabel	labelTitoloPannello2;
    

	private JLabel labelVecchiaPasswordPannello2;
	private JPasswordField campoVecchiaPasswordPannello2;
	
	private JLabel labelNuovaPasswordPannello2;
	private JPasswordField campoNuovaPasswordPannello2;
	
	private JLabel labelRipetiPasswordPannello2;
	private JPasswordField campoRipetiPasswordPannello2;


	private JButton bottoneCambiaPannello2;
	private JButton bottoneSvuotaPannello2;
	
	private JButton bottoneChiudiPannello2;

	private ChiudiPannello2AA ascoltatoreBottoneChiudiPannello2;
	private CambiaPannello2AA ascoltatoreBottoneCambiaPannello2;
	private SvuotaPannello2AA ascoltatoreBottoneSvuotaPannello2;

	
	
    //Elementi Pannello3
    private JLabel	labelTitoloPannello3;
    
	private JLabel labelNuovaEmailPannello3;
	private JTextField campoNuovaEmailPannello3;
	
	private JLabel labelRipetiNuovaEmailPannello3;
	private JTextField campoRipetiNuovaEmailPannello3;
	
	private JLabel labelPasswordPannello3;
	private JPasswordField campoPasswordPannello3;
	
	private JButton bottoneCambiaPannello3;
	private JButton bottoneSvuotaPannello3;
	
	private JButton bottoneChiudiPannello3;

	private ChiudiPannello3AA ascoltatoreBottoneChiudiPannello3;
	private CambiaPannello3AA ascoltatoreBottoneCambiaPannello3;
	private SvuotaPannello3AA ascoltatoreBottoneSvuotaPannello3;

	

	public BoundaryCliente_GestioneProfiloPersonale(JPanel nextPanel, String ruolo) {
		
		this.ruolo = ruolo;
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
		bottoneCambiaPassword.setBackground(Color.GREEN);
		bottoneCambiaPassword.setBounds(panel1.getWidth()/5, panel1.getHeight()/6, panel1.getWidth()/5, panel1.getHeight()/2);
		panel1.add(bottoneCambiaPassword);
		
		
		bottoneCambiaEmail = new JButton("Cambia Email");
		bottoneCambiaEmail.setBackground(Color.YELLOW);
		bottoneCambiaEmail.setBounds(panel1.getWidth()/5*3, panel1.getHeight()/6, panel1.getWidth()/5, panel1.getHeight()/2);
		panel1.add(bottoneCambiaEmail);
		
		
		bottoneChiudiPannello1 = new JButton("X");
		bottoneChiudiPannello1.setBackground(Color.RED);
		bottoneChiudiPannello1.setBounds(panel1.getWidth()/20*19, 0, panel1.getWidth()/20, panel1.getHeight()/2-3);
		panel1.add(bottoneChiudiPannello1);
		
		// ascoltatori per primo pannello
		ascoltatoreBottoneCambiaPassword = new CambiaPasswordAA(); 		
		bottoneCambiaPassword.addActionListener(ascoltatoreBottoneCambiaPassword); 
		
		ascoltatoreBottoneCambiaEmail = new CambiaEmailAA(); 		
		bottoneCambiaEmail.addActionListener(ascoltatoreBottoneCambiaEmail); 	
				
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
		labelTitoloPannello2.setText("CAMBIA PASSWORD");
		panel2.add(labelTitoloPannello2);
		

	    labelVecchiaPasswordPannello2 = new JLabel();        
	    labelVecchiaPasswordPannello2.setFont(new Font("Arial", 0, 15));
	    labelVecchiaPasswordPannello2.setBounds(panel2.getWidth()/4*2-230, panel2.getHeight()/5+15, panel2.getWidth()/4, 20);
	    labelVecchiaPasswordPannello2.setText("VECCHIA PASSWORD");
		panel2.add(labelVecchiaPasswordPannello2);
		
		campoVecchiaPasswordPannello2 = new JPasswordField(panel2.getWidth()/5*2);
		campoVecchiaPasswordPannello2.setFont(new Font("Arial", 0, 18));
		campoVecchiaPasswordPannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5+15, panel2.getWidth()/4, 20);
	    panel2.add(campoVecchiaPasswordPannello2);
	    
	    
	    labelNuovaPasswordPannello2 = new JLabel();        
	    labelNuovaPasswordPannello2.setFont(new Font("Arial", 0, 15));
	    labelNuovaPasswordPannello2.setBounds(panel2.getWidth()/4*2-230, panel2.getHeight()/5*2+15, panel2.getWidth()/4, 20);
	    labelNuovaPasswordPannello2.setText("NUOVA PASSWORD");
		panel2.add(labelNuovaPasswordPannello2);
		
		campoNuovaPasswordPannello2 = new JPasswordField(panel2.getWidth()/5*2);
		campoNuovaPasswordPannello2.setFont(new Font("Arial", 0, 18));
		campoNuovaPasswordPannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5*2+15, panel2.getWidth()/4, 20);
	    panel2.add(campoNuovaPasswordPannello2);
	    
	    
	    labelRipetiPasswordPannello2 = new JLabel();        
	    labelRipetiPasswordPannello2.setFont(new Font("Arial", 0, 15));
	    labelRipetiPasswordPannello2.setBounds(panel2.getWidth()/4*2-230, panel2.getHeight()/5*3+15, panel2.getWidth()/4, 20);
	    labelRipetiPasswordPannello2.setText("RIPETI NUOVA PASSWORD");
		panel2.add(labelRipetiPasswordPannello2);
		
		campoRipetiPasswordPannello2 = new JPasswordField(panel2.getWidth()/5*2);
		campoRipetiPasswordPannello2.setFont(new Font("Arial", 0, 18));
		campoRipetiPasswordPannello2.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5*3+15, panel2.getWidth()/4, 20);
	    panel2.add(campoRipetiPasswordPannello2);
	    
	    
		bottoneSvuotaPannello2 = new JButton("AZZERA CAMPI");
		bottoneSvuotaPannello2.setBackground(Color.YELLOW);
		bottoneSvuotaPannello2.setBounds(panel2.getWidth()/10*3-25, panel2.getHeight()/5*4+15, panel2.getWidth()/5, panel2.getHeight()/11);
		panel2.add(bottoneSvuotaPannello2);
		
		bottoneCambiaPannello2 = new JButton("CAMBIA PASSWORD");
		bottoneCambiaPannello2.setBackground(Color.ORANGE);
		bottoneCambiaPannello2.setBounds(panel2.getWidth()/10*5+25, panel2.getHeight()/5*4+15, panel2.getWidth()/5, panel2.getHeight()/11);
		panel2.add(bottoneCambiaPannello2);
		
		bottoneChiudiPannello2 = new JButton("X");
		bottoneChiudiPannello2.setBackground(Color.RED);
		bottoneChiudiPannello2.setBounds(panel2.getWidth()/20*19, 0, panel2.getWidth()/20, panel2.getHeight()/18);
		panel2.add(bottoneChiudiPannello2);
		
		//Ascoltatori pannello 2
		ascoltatoreBottoneSvuotaPannello2 = new SvuotaPannello2AA();
		bottoneSvuotaPannello2.addActionListener(ascoltatoreBottoneSvuotaPannello2);
		
		ascoltatoreBottoneCambiaPannello2 = new CambiaPannello2AA();
		bottoneCambiaPannello2.addActionListener(ascoltatoreBottoneCambiaPannello2);
		
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
		labelTitoloPannello3.setText("CAMBIA EMAIL");
		panel3.add(labelTitoloPannello3);
		
		
	    labelNuovaEmailPannello3 = new JLabel();        
	    labelNuovaEmailPannello3.setFont(new Font("Arial", 0, 15));
	    labelNuovaEmailPannello3.setBounds(panel3.getWidth()/4*2-230, panel3.getHeight()/5+15, panel3.getWidth()/4, 20);
	    labelNuovaEmailPannello3.setText("NUOVA EMAIL");
		panel3.add(labelNuovaEmailPannello3);
		
		campoNuovaEmailPannello3 = new JTextField(panel3.getWidth()/5*2);
		campoNuovaEmailPannello3.setFont(new Font("Arial", 0, 18));
		campoNuovaEmailPannello3.setBounds(panel3.getWidth()/4*2, panel3.getHeight()/5+15, panel3.getWidth()/4, 20);
	    panel3.add(campoNuovaEmailPannello3);
	    
	    
	    labelRipetiNuovaEmailPannello3 = new JLabel();        
	    labelRipetiNuovaEmailPannello3.setFont(new Font("Arial", 0, 15));
	    labelRipetiNuovaEmailPannello3.setBounds(panel3.getWidth()/4*2-230, panel3.getHeight()/5*2+15, panel3.getWidth()/4, 20);
	    labelRipetiNuovaEmailPannello3.setText("RIPETI NUOVA EMAIL");
		panel3.add(labelRipetiNuovaEmailPannello3);
		
		campoRipetiNuovaEmailPannello3 = new JTextField(panel3.getWidth()/5*2);
		campoRipetiNuovaEmailPannello3.setFont(new Font("Arial", 0, 18));
		campoRipetiNuovaEmailPannello3.setBounds(panel3.getWidth()/4*2, panel3.getHeight()/5*2+15, panel3.getWidth()/4, 20);
	    panel3.add(campoRipetiNuovaEmailPannello3);
	    
	   
	    labelPasswordPannello3 = new JLabel();        
	    labelPasswordPannello3.setFont(new Font("Arial", 0, 15));
	    labelPasswordPannello3.setBounds(panel3.getWidth()/4*2-230, panel3.getHeight()/5*3+15, panel3.getWidth()/4, 20);
	    labelPasswordPannello3.setText("INSERISCI PASSWORD");
		panel3.add(labelPasswordPannello3);
		
		campoPasswordPannello3 = new JPasswordField(panel3.getWidth()/5*2);
		campoPasswordPannello3.setFont(new Font("Arial", 0, 18));
		campoPasswordPannello3.setBounds(panel3.getWidth()/4*2, panel3.getHeight()/5*3+15, panel3.getWidth()/4, 20);
	    panel3.add(campoPasswordPannello3);
	    
	    
		bottoneSvuotaPannello3 = new JButton("AZZERA CAMPI");
		bottoneSvuotaPannello3.setBackground(Color.YELLOW);
		bottoneSvuotaPannello3.setBounds(panel3.getWidth()/10*3-25, panel3.getHeight()/5*4+15, panel3.getWidth()/5, panel3.getHeight()/11);
		panel3.add(bottoneSvuotaPannello3);
		
		bottoneCambiaPannello3 = new JButton("CAMBIA EMAIL");
		bottoneCambiaPannello3.setBackground(Color.ORANGE);
		bottoneCambiaPannello3.setBounds(panel3.getWidth()/10*5+25, panel3.getHeight()/5*4+15, panel3.getWidth()/5, panel3.getHeight()/11);
		panel3.add(bottoneCambiaPannello3);
		
		bottoneChiudiPannello3 = new JButton("X");
		bottoneChiudiPannello3.setBackground(Color.RED);
		bottoneChiudiPannello3.setBounds(panel3.getWidth()/20*19, 0, panel3.getWidth()/20, panel3.getHeight()/18);
		panel3.add(bottoneChiudiPannello3);
		
		//Ascoltatori pannello 3
		ascoltatoreBottoneSvuotaPannello3 = new SvuotaPannello3AA();
		bottoneSvuotaPannello3.addActionListener(ascoltatoreBottoneSvuotaPannello3);
		
		ascoltatoreBottoneCambiaPannello3 = new CambiaPannello3AA();
		bottoneCambiaPannello3.addActionListener(ascoltatoreBottoneCambiaPannello3);
		
		ascoltatoreBottoneChiudiPannello3 = new ChiudiPannello3AA();
		bottoneChiudiPannello3.addActionListener(ascoltatoreBottoneChiudiPannello3);
	}
	
	
	private void controlloSintatticoDatiPannello2(String vecchiaPsw, String nuovaPsw, String ripetiNuovaPsw) throws DatiPersonaliErratiException {
		if (vecchiaPsw.equals("")||nuovaPsw.equals("")||ripetiNuovaPsw.equals("")){
			throw new DatiPersonaliErratiException("Tutti i campi devono essere compilati.");
		}
		
		if (!nuovaPsw.equals(ripetiNuovaPsw)){
			throw new DatiPersonaliErratiException("I campi Nuova Password sono differenti. Controllare la password inserita...");
		}
		
	}
	

	private void svuotaPannello2() {
		campoVecchiaPasswordPannello2.setText(null);	//svuota tutti i campi testo
		campoNuovaPasswordPannello2.setText(null);
		campoRipetiPasswordPannello2.setText(null);
	}

	

	private void controlloSintatticoDatiPannello3(String nuovaEmail, String ripetiEmail, String password) throws DatiPersonaliErratiException {
		if (nuovaEmail.equals("")||ripetiEmail.equals("")||password.equals("")){
			throw new DatiPersonaliErratiException("Tutti i campi devono essere compilati.");
		}
		if (!nuovaEmail.equals(ripetiEmail)){
			throw new DatiPersonaliErratiException("I campi Nuova Email sono differenti. Controllare i dati inseriti...");
		}
		if (!nuovaEmail.contains("@")||!ripetiEmail.contains("@")){
			throw new DatiPersonaliErratiException("Indirizzo email non valido. Controllare i dati inseriti...");
		}
		
	}
	
	
	private void svuotaPannello3() {
		campoNuovaEmailPannello3.setText(null);	//svuota tutti i campi testo
		campoRipetiNuovaEmailPannello3.setText(null);
		campoPasswordPannello3.setText(null);
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
			bottoneCambiaEmail.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
		
		}
		
	}	
	
	
	private class CambiaEmailAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panel1.setVisible(false);
			panel1.setVisible(true);
			panel3.setVisible(true);  //attiva pannello 2
			
			bottoneCambiaPassword.setEnabled(false); //disattiva i bottoni
			bottoneCambiaEmail.setEnabled(false);
			bottoneChiudiPannello1.setEnabled(false);
		
		}
		
	}	
	
	
	private class ChiudiPannello1AA implements ActionListener{

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
				BoundaryAmministratore_GestioneUtenti.riattivaBottoni();
			}
	
						
		}
	}
	
	
	
	
	private class CambiaPannello2AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String vecchiaPsw = String.valueOf(campoVecchiaPasswordPannello2.getPassword());
			String nuovaPsw = String.valueOf(campoNuovaPasswordPannello2.getPassword());
			String ripetiNuovaPsw = String.valueOf(campoNuovaPasswordPannello2.getPassword());
			try {				
				controlloSintatticoDatiPannello2(vecchiaPsw, nuovaPsw, ripetiNuovaPsw);
				int conferma = JOptionPane.showConfirmDialog(null, "Cambiare la password?", "Conferma Modifica Password", JOptionPane.YES_NO_OPTION);				
				
				if (conferma == JOptionPane.YES_OPTION){	
					controllore.cambiaPassword(vecchiaPsw, nuovaPsw);
					JOptionPane.showMessageDialog(null, "La password e' stata cambiata correttamente.", "Password Modificata", JOptionPane.INFORMATION_MESSAGE);
					svuotaPannello2();
				}
				
				
			} catch (DatiPersonaliErratiException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Attenzione!", JOptionPane.WARNING_MESSAGE);
			} catch (UtenteInesistenteException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			} catch (CredenzialiErrateException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
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
			bottoneCambiaPassword.setEnabled(true);	//riattiva i bottoni
			bottoneCambiaEmail.setEnabled(true);
			bottoneChiudiPannello1.setEnabled(true);
						
			//svuoto cmq il pannello
			svuotaPannello2();
			
		}
	}

	
	
	private class CambiaPannello3AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String nuovaEmail = campoNuovaEmailPannello3.getText().toLowerCase();
			String ripetiEmail = campoRipetiNuovaEmailPannello3.getText().toLowerCase();
			String password = String.valueOf(campoPasswordPannello3.getPassword());
			try {				
				controlloSintatticoDatiPannello3(nuovaEmail, ripetiEmail, password);
				int conferma = JOptionPane.showConfirmDialog(null, "Cambiare l'indirizzo email?", "Conferma Modifica Email", JOptionPane.YES_NO_OPTION);				
				
				if (conferma == JOptionPane.YES_OPTION){	
					controllore.cambiaEmail(nuovaEmail, password);
					JOptionPane.showMessageDialog(null, "L'indirizzo email e' stata modificato correttamente.", "Email Modificata", JOptionPane.INFORMATION_MESSAGE);
					svuotaPannello3();
				}
				
				
			} catch (DatiPersonaliErratiException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Attenzione!", JOptionPane.WARNING_MESSAGE);
			} catch (UtenteInesistenteException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			} catch (CredenzialiErrateException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}

	}
	
	
	
	private class SvuotaPannello3AA implements ActionListener{
		/*
		 * Svuota tutti i campi
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			svuotaPannello3();

		}
		
	}
	
	private class ChiudiPannello3AA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			panel3.setVisible(false); 					//chiude questo pannello
			bottoneCambiaPassword.setEnabled(true);	//riattiva i bottoni
			bottoneCambiaEmail.setEnabled(true);
			bottoneChiudiPannello1.setEnabled(true);
						
			//svuoto cmq il pannello
			svuotaPannello3();

		}
	}


}
