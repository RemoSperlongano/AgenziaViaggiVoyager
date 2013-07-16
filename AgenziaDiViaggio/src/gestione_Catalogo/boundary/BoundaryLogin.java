/**
 * 
 */
package gestione_Catalogo.boundary;


import gestione_Catalogo.control.ControlloreLogin;

import gestione_Catalogo.exception.CredenzialiErrateException;
import gestione_Catalogo.exception.LoginFallitoException;

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
public class BoundaryLogin {
	
	private ControlloreLogin controllore;
	
	//attributi istanza
	
	private JPanel superPanel;
	
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;

	//Elementi pannello 1
	private JLabel labelTitolo;
	
	//Elementi pannello 2
	private JLabel labelUsername;
	private JTextField campoUsername;
	private JLabel labelPassword;
	private JPasswordField campoPassword;
	
	
	
	//Elementi pannello 3
	private JButton bottoneLogin;

	private LoginAA ascoltatoreLogin;
	

	
	
	
	
	
	
	//costruttore
	public BoundaryLogin(){
		
		controllore = new ControlloreLogin();
		
		
		/*
		 * definisco il SuperPannello
		 */
		superPanel = new JPanel();
		superPanel.setSize(BoundaryAAAprimaria.confinePrincipale.getWidth(), BoundaryAAAprimaria.confinePrincipale.getHeight());
		superPanel.setBackground(Color.BLACK); 					//provo a mettere il sottopannellonero...si vedono i contorni?
		superPanel.setLayout(null); 							//ora il pannello puo' contenere altri pannelli
		BoundaryAAAprimaria.confinePrincipale.add(superPanel); 	//aggiungo il pannello al confine (chiamato staticamente)
		
		
		//definisco il primo pannello: per il titolo
		panel1 = new JPanel();
		panel1.setSize(superPanel.getWidth(), superPanel.getHeight()/4-10);
		panel1.setLocation(0, 0);			//x=0 e y=0 rispetto al superPanel
		panel1.setLayout(null); 			//ora il pannello puo' contenere oggetti
		superPanel.add(panel1);				//aggiungo il primo pannello al superPannello
		
		labelTitolo = new JLabel();  		//Etichetta per il titolo
		labelTitolo.setFont(new Font("Arial", 0, 50));
		labelTitolo.setLocation(0, 0);
		labelTitolo.setSize(panel1.getWidth(), panel1.getHeight());
		labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		labelTitolo.setVerticalAlignment(JLabel.CENTER);
		labelTitolo.setText("LOGIN");
		panel1.add(labelTitolo);			//aggiungo titolo al pannello1
		
		
		//definisco il secondo pannello: per i dati
		panel2 = new JPanel();
		panel2.setSize(superPanel.getWidth(), superPanel.getHeight()/4*2-10);
		panel2.setLocation(0, superPanel.getHeight()/4);
		panel2.setLayout(null); 			//ora il pannello puo' contenere oggetti
		superPanel.add(panel2);				//aggiungo il secondo pannello al superPannello
		
		
		
		labelUsername = new JLabel();        
		labelUsername.setFont(new Font("Arial", 0, 15));
		labelUsername.setBounds(panel2.getWidth()/4*2-200, panel2.getHeight()/5, panel2.getWidth()/4, 20);
		labelUsername.setText("USERNAME");
		panel2.add(labelUsername);
		
		
		
		campoUsername = new JTextField(panel2.getWidth()/5*2);
		campoUsername.setFont(new Font("Arial", 0, 18));
		campoUsername.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5, panel2.getWidth()/4, 20);
	    panel2.add(campoUsername);
	    
	    
	    labelPassword = new JLabel();        //Etichetta per i mezzi
		labelPassword.setFont(new Font("Arial", 0, 15));
		labelPassword.setBounds(panel2.getWidth()/4*2-200, panel2.getHeight()/5*3, panel2.getWidth()/4, 20);
		labelPassword.setText("PASSWORD");
		panel2.add(labelPassword);
		
		
		
		campoPassword = new JPasswordField(panel2.getWidth()/5*2);
		campoPassword.setFont(new Font("Arial", 0, 18));
		campoPassword.setBounds(panel2.getWidth()/4*2, panel2.getHeight()/5*3, panel2.getWidth()/4, 20);
	    panel2.add(campoPassword);
		
		
		
		//definisco il terzo pannello: per il login
		panel3 = new JPanel();
		panel3.setSize(superPanel.getWidth(), superPanel.getHeight()/4);
		panel3.setLocation(0, superPanel.getHeight()/4*3);
		panel3.setLayout(null); 			//ora il pannello puo' contenere oggetti
		superPanel.add(panel3);				//aggiungo il terzo pannello al superPannello
		
		
	
		bottoneLogin = new JButton("LOGIN");
		bottoneLogin.setBounds(panel3.getWidth()/5*2, panel3.getHeight()/2, panel3.getWidth()/5, panel3.getHeight()/4);
		panel3.add(bottoneLogin);//aggiungo il bottone al quarto pannello
		
		ascoltatoreLogin = new LoginAA();
		bottoneLogin.addActionListener(ascoltatoreLogin);
		
	
		
	}
	
	@SuppressWarnings("deprecation")
	private void controlloSintatticoDati() throws CredenzialiErrateException{
		String username = campoUsername.getText();
		String password = campoPassword.getText();
		
		if (username.equals("") || password.equals("")){
			throw new CredenzialiErrateException("Tutti i campi devono esser compilati");
		}
	}
	
	
	private class LoginAA implements ActionListener{

		
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent arg0) {


			try {
				
				controlloSintatticoDati();
				
				String username = campoUsername.getText();
				String password = campoPassword.getText();
				
				String ruolo = controllore.controlloLogin(username, password);
				superPanel.setVisible(false);
				
				
				//istanzio col loading dinamico la classe che mi interessa 
				//classe c di nome ambiente
				Class<?> c = Class.forName("gestione_Catalogo.boundary.Boundary"+ruolo);   // per classi in un package, va messo il nome del package!!!"
				
				c.newInstance();  //Non ha costruttori
				
				
			} catch (CredenzialiErrateException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			} catch (LoginFallitoException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
