/**
 * 
 */
package gestione_Catalogo.boundary;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import gestione_Catalogo.control.ControllorePrimoAccesso;

import gestione_Catalogo.exception.DatiPersonaliErratiException;
import gestione_Catalogo.exception.UtenteEsistenteException;
import gestione_Catalogo.exception.UtenteInesistenteException;

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
public class BoundaryPrimoAccesso {
	
	
	
		ControllorePrimoAccesso controllore;
		
		//campi istanza pannelli
		private JPanel superPanel; //Pannello principale
		private JPanel panelTitolo;
		private JPanel panelCampi;
		 
		
		//Elementi pannelloTitolo
		private JLabel labelTitolo;
			
		private JButton bottoneLogOut;  
		private JButton bottoneEsci;
			
		private LogOutAA ascoltatoreBottoneLogOut;
		private EsciAA ascoltatoreBottoneEsci;
		
		
		//Elementi pannelloCampi
		
		
		private JLabel labelNome;
		private JTextField campoNome;
		
		private JLabel labelCognome;
		private JTextField campoCognome;
		
		private JLabel labelEmail;
		private JTextField campoEmail;
		
		private JLabel labelUsername;
		private JTextField campoUsername;
		
		private JLabel labelPassword;
		private JPasswordField campoPassword;
		
		private JLabel labelRipetiPassword;
		private JPasswordField campoRipetiPassword;
		
		//Elementi Bottoni
		
		private JButton bottoneModifica;
		private JButton bottoneSvuota;
		
		
		private ModificaAA ascoltatoreBottoneModifica;
		private SvuotaAA ascoltatoreBottoneSvuota;
		
		
		
		public BoundaryPrimoAccesso() {
			
			controllore = new ControllorePrimoAccesso();
			
			
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
			 * primo pannello:  per il titolo
			 */
			
			panelTitolo = new JPanel();
			panelTitolo.setSize(superPanel.getWidth(), superPanel.getHeight()/7-20);  //Il meno 10 serve per far vedere il contorno 
			panelTitolo.setLocation(0, 0);			//x=0 e y=0 rispetto al superPanel
			panelTitolo.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(panelTitolo);				//aggiungo il primo pannello al superPannello
			
			labelTitolo = new JLabel();  		//Etichetta per il titolo
			labelTitolo.setFont(new Font("Arial", 0, 30));
			labelTitolo.setLocation(0, 0);
			labelTitolo.setSize(panelTitolo.getWidth(), panelTitolo.getHeight());
			labelTitolo.setHorizontalAlignment(JLabel.CENTER);
			labelTitolo.setVerticalAlignment(JLabel.CENTER);
			labelTitolo.setText("PRIMO ACCESSO");
			panelTitolo.add(labelTitolo);			//aggiungo titolo al pannello1
			
			
			bottoneLogOut = new JButton("LOGOUT");
			bottoneLogOut.setBackground(Color.ORANGE);
			bottoneLogOut.setBounds(panelTitolo.getWidth()/18, panelTitolo.getHeight()/4, panelTitolo.getWidth()/9, panelTitolo.getHeight()/2);
			panelTitolo.add(bottoneLogOut);//aggiungo il bottone al primo pannello
			
			bottoneEsci = new JButton("ESCI");
			bottoneEsci.setBackground(Color.RED);
			bottoneEsci.setBounds(panelTitolo.getWidth()/18*15, panelTitolo.getHeight()/4, panelTitolo.getWidth()/9, panelTitolo.getHeight()/2);
			panelTitolo.add(bottoneEsci);//aggiungo il bottone al primo pannello
			
			//Ascoltatori per primo pannello
			
			ascoltatoreBottoneLogOut = new LogOutAA();
			bottoneLogOut.addActionListener(ascoltatoreBottoneLogOut);
			
			ascoltatoreBottoneEsci = new EsciAA();
			bottoneEsci.addActionListener(ascoltatoreBottoneEsci);
			
			
			
			
			panelCampi = new JPanel();
			panelCampi.setSize(superPanel.getWidth(), superPanel.getHeight()/7*6);
			panelCampi.setLocation(0, superPanel.getHeight()/7);	
			panelCampi.setLayout(null); 			//ora il pannello puo' contenere oggetti
			superPanel.add(panelCampi);

			
			
		    labelNome = new JLabel();        
		    labelNome.setFont(new Font("Arial", 0, 15));
		    labelNome.setBounds(panelCampi.getWidth()/4*2-200, panelCampi.getHeight()/5+25, panelCampi.getWidth()/4, 20);
		    labelNome.setText("NOME");
			panelCampi.add(labelNome);
			
			campoNome = new JTextField(panelCampi.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
			campoNome.setFont(new Font("Arial", 0, 18));
			campoNome.setBounds(panelCampi.getWidth()/4*2, panelCampi.getHeight()/5+25, panelCampi.getWidth()/4, 20);
			panelCampi.add(campoNome);
			
			
		    labelCognome = new JLabel();        
		    labelCognome.setFont(new Font("Arial", 0, 15));
		    labelCognome.setBounds(panelCampi.getWidth()/4*2-200, panelCampi.getHeight()/5+50, panelCampi.getWidth()/4, 20);
		    labelCognome.setText("COGNOME");
			panelCampi.add(labelCognome);
			
			campoCognome = new JTextField(panelCampi.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
			campoCognome.setFont(new Font("Arial", 0, 18));
			campoCognome.setBounds(panelCampi.getWidth()/4*2, panelCampi.getHeight()/5+50, panelCampi.getWidth()/4, 20);
			panelCampi.add(campoCognome);
			
			
		    labelEmail = new JLabel();        
		    labelEmail.setFont(new Font("Arial", 0, 15));
		    labelEmail.setBounds(panelCampi.getWidth()/4*2-200, panelCampi.getHeight()/5+75, panelCampi.getWidth()/4, 20);
		    labelEmail.setText("EMAIL");
			panelCampi.add(labelEmail);
			
			campoEmail = new JTextField(panelCampi.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
			campoEmail.setFont(new Font("Arial", 0, 18));
			campoEmail.setBounds(panelCampi.getWidth()/4*2, panelCampi.getHeight()/5+75, panelCampi.getWidth()/4, 20);
			panelCampi.add(campoEmail);
			
			
			
			
		    labelUsername = new JLabel();        
		    labelUsername.setFont(new Font("Arial", 0, 15));
		    labelUsername.setBounds(panelCampi.getWidth()/4*2-200, panelCampi.getHeight()/5+100, panelCampi.getWidth()/4, 20);
		    labelUsername.setText("USERNAME");
			panelCampi.add(labelUsername);
			
			campoUsername = new JTextField(panelCampi.getWidth()/5);	  //campo per aggiungere dei nuovi mezzi
			campoUsername.setFont(new Font("Arial", 0, 18));
			campoUsername.setBounds(panelCampi.getWidth()/4*2, panelCampi.getHeight()/5+100, panelCampi.getWidth()/4, 20);
			panelCampi.add(campoUsername);
			
		    
		    labelPassword = new JLabel();        
		    labelPassword.setFont(new Font("Arial", 0, 15));
		    labelPassword.setBounds(panelCampi.getWidth()/4*2-200, panelCampi.getHeight()/5+125, panelCampi.getWidth()/4, 20);
		    labelPassword.setText("PASSWORD");
			panelCampi.add(labelPassword);
			
			campoPassword = new JPasswordField(panelCampi.getWidth()/5*2);
			campoPassword.setFont(new Font("Arial", 0, 18));
			campoPassword.setBounds(panelCampi.getWidth()/4*2, panelCampi.getHeight()/5+125, panelCampi.getWidth()/4, 20);
		    panelCampi.add(campoPassword);
		    
		    
		    labelRipetiPassword = new JLabel();        
		    labelRipetiPassword.setFont(new Font("Arial", 0, 15));
		    labelRipetiPassword.setBounds(panelCampi.getWidth()/4*2-200, panelCampi.getHeight()/5+150, panelCampi.getWidth()/4, 20);
		    labelRipetiPassword.setText("RIPETI PASSWORD");
			panelCampi.add(labelRipetiPassword);
			
			campoRipetiPassword = new JPasswordField(panelCampi.getWidth()/5*2);
			campoRipetiPassword.setFont(new Font("Arial", 0, 18));
			campoRipetiPassword.setBounds(panelCampi.getWidth()/4*2, panelCampi.getHeight()/5+150, panelCampi.getWidth()/4, 20);
		    panelCampi.add(campoRipetiPassword);
		    
		    
		    
		    bottoneSvuota = new JButton("AZZERA CAMPI");
			bottoneSvuota.setBackground(Color.YELLOW);
			bottoneSvuota.setBounds(panelCampi.getWidth()/10*3-25, panelCampi.getHeight()/5*3+15, panelCampi.getWidth()/5, panelCampi.getHeight()/15);
			panelCampi.add(bottoneSvuota);
			
			bottoneModifica = new JButton("MODIFICA");
			bottoneModifica.setBackground(Color.ORANGE);
			bottoneModifica.setBounds(panelCampi.getWidth()/10*6-25, panelCampi.getHeight()/5*3+15, panelCampi.getWidth()/5, panelCampi.getHeight()/15);
			panelCampi.add(bottoneModifica);
			
			
			//Ascoltatori pannello 2
			ascoltatoreBottoneSvuota = new SvuotaAA();
			bottoneSvuota.addActionListener(ascoltatoreBottoneSvuota);
			
			ascoltatoreBottoneModifica = new ModificaAA();
			bottoneModifica.addActionListener(ascoltatoreBottoneModifica);
			
			
			JOptionPane.showMessageDialog(null, "Questo è il primo accesso. Modificare dati di Amministratore Iniziale", "Benvenuti!", JOptionPane.WARNING_MESSAGE);
			
			
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
		

		private void svuotaPannello() {
			campoNome.setText(null);
			campoCognome.setText(null);
			campoEmail.setText(null);
			campoUsername.setText(null);
			campoPassword.setText(null);
			campoRipetiPassword.setText(null);
		}
		
		
		
		/*
		 * 
		 * Ascoltatori per pannello Titolo
		 * 
		 */
		
		
		private class LogOutAA implements ActionListener{

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
		 * 
		 * Ascoltatori per pannello campi
		 * 
		 */
		
		
		private class ModificaAA implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {

				String nome = uppercaseFirstLetters(campoNome.getText());
				String cognome = uppercaseFirstLetters(campoCognome.getText());
				String email = campoEmail.getText().toLowerCase();
				
				String username = campoUsername.getText();
				String password = String.valueOf(campoPassword.getPassword());
				String ripetiPsw = String.valueOf(campoRipetiPassword.getPassword());
				
				try {
					
					controlloSintatticoDati(nome, cognome, email, username, password, ripetiPsw);
					
					int conferma = JOptionPane.showConfirmDialog(null, "Aggiungere il nuovo Amministratore?", "Conferma Nuovo Utente", JOptionPane.YES_NO_OPTION);				
				
					if (conferma == JOptionPane.YES_OPTION){	
						controllore.modificaUtente(nome, cognome, email, username, password, "Amministratore");
						JOptionPane.showMessageDialog(null, "Il nuovo Amministratore e' stato aggiunto correttamente. Si prega di rifare il Login", "Nuovo Utente Aggiunto", JOptionPane.INFORMATION_MESSAGE);
						superPanel.setVisible(false);
						BoundaryAAAprimaria.superPanel.setVisible(true);
					}
		
				} catch (DatiPersonaliErratiException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Attenzione!", JOptionPane.WARNING_MESSAGE);
				} catch (UtenteEsistenteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Attenzione!", JOptionPane.WARNING_MESSAGE);
				} catch (UtenteInesistenteException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Attenzione!", JOptionPane.WARNING_MESSAGE);
				}
				
			}


		}
		
		
		
		private class SvuotaAA implements ActionListener{
			/*
			 * Svuota tutti i campi
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				svuotaPannello();
			}
			
		}

}
