/**
 * 
 */
package gestione_Catalogo.boundary;

import gestione_Catalogo.control.ControlloreAggiungiPrenotazione;
import gestione_Catalogo.control.ControlloreLogin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryLogin {
	
	private static final long serialVersionUID = 1L;
	
	
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
	
	
	private JLabel labelProprietari;
	private JLabel labelLogin;
	
	private JButton	bottoneVisitatore;
	private JButton bottoneLogin;

	private JButton bottoneProgettista;
	private JButton bottonePromotore;
	private JButton bottoneVenditore;

	
	
	
	
	
	
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
		panel1.setSize(superPanel.getWidth(), superPanel.getHeight()/4);
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
		
		
		//definisco il secondo pannello: per i proprietari
		panel2 = new JPanel();
		panel2.setSize(superPanel.getWidth(), superPanel.getHeight()/4);
		panel2.setLocation(0, superPanel.getHeight()/4);
		panel2.setLayout(null); 			//ora il pannello puo' contenere oggetti
		superPanel.add(panel2);				//aggiungo il secondo pannello al superPannello
		
		labelProprietari = new JLabel();	//Etichetta dei proprietari
		labelProprietari.setFont(new Font("Arial", 0, 20));
		labelProprietari.setLocation(0, 0);
		labelProprietari.setSize(panel2.getWidth(), 20);
		labelProprietari.setHorizontalAlignment(JLabel.CENTER);
		labelProprietari.setVerticalAlignment(JLabel.CENTER);
		labelProprietari.setText("Caso d'uso GestioneCatalogo");
		panel2.add(labelProprietari);		//aggiungo proprietari al pannello2
		
		
		
		//definisco il terzo pannello: per il login
		panel3 = new JPanel();
		panel3.setSize(superPanel.getWidth(), superPanel.getHeight()/4);
		panel3.setLocation(0, superPanel.getHeight()/4*2);
		panel3.setLayout(null); 			//ora il pannello puo' contenere oggetti
		superPanel.add(panel3);				//aggiungo il terzo pannello al superPannello
		
		
		
		bottoneVisitatore = new JButton("VISITATORE");
		bottoneVisitatore.setBounds(panel3.getWidth()/5, panel3.getHeight()/2, panel3.getWidth()/5, panel3.getWidth()/4);
		panel3.add(bottoneVisitatore);
		
	
		
		
		
		bottoneLogin = new JButton("LOGIN");
		bottoneLogin.setBounds(panel3.getWidth()/5*3, panel3.getHeight()/2, panel3.getWidth()/5, panel3.getHeight()/4);
		panel3.add(bottoneLogin);//aggiungo il bottone al quarto pannello
		
	
		
		
		
		
		
		

		
		
	}

}
