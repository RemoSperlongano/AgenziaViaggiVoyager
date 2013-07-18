/**
 * 
 */
package gestione_Catalogo.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;



import gestione_Catalogo.control.ControlloreGestioneIndici;
import gestione_Catalogo.exception.DirittiException;
import gestione_Catalogo.exception.IDEsternoElementoException;
import gestione_Catalogo.exception.MappaException;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryAmministratore_GestioneIndici {

	
	
	private ControlloreGestioneIndici controllore;
	private String ambienteScelto;
	private String mezzoScelto;
	private String partenzaScelta;
	private String arrivoScelto;
	private String viaScelta;
	private String metodoScelto;
	
	
	//Pannelli
	private JPanel panel;
	
	
	//Elementi Pannello
	
	private JLabel		 labelTitolo;
	
	private JRadioButton radioTotale;
	private JRadioButton radioAnnuale;
	private JRadioButton radioUltimaOfferta;

	private ButtonGroup gruppoRadioButton;
	
	
	private JLabel labelAmbiente;
	private JComboBox<String> tendinaAmbiente;
	
	private JLabel labelMezzi;
	private JComboBox<String> tendinaMezzi;

	private JLabel labelCittaPartenza;
	private JComboBox<String> tendinaCittaPartenza;

	private JLabel labelCittaArrivo;
	private JComboBox<String> tendinaCittaArrivo;
	
	private JLabel labelVia;
	private JComboBox<String> tendinaVia;
	
	
	
	
	
	
	private RadioButtonTotaleAA ascoltatoreRadioButtonTotale;
	private RadioButtonAnnualeAA ascoltatoreRadioButtonAnnuale;
	private RadioButtonUltimaOffertaAA ascoltatoreRadioButtonUltimaOfferta;
	
	private TendinaAmbienteAA ascoltatoreTendinaAmbiente;
	private TendinaMezziAA ascoltatoreTendinaMezzi;
	private TendinaPartenzeAA ascoltatoreTendinaPartenze;
	private TendinaArriviAA ascoltatoreTendinaArrivi;
	private TendinaViaAA ascoltatoreTendinaVia;
		
		
	public BoundaryAmministratore_GestioneIndici(JPanel panelNext) {


		ambienteScelto = null;
		mezzoScelto = null;
		partenzaScelta = null;
		arrivoScelto = null;
		viaScelta = null;
		metodoScelto = null;
		controllore = new ControlloreGestioneIndici();
		
		
		/*
		 * 
		 * Il superPanel di questa Boundary prende le dimensioni del pannello Passato
		 * 
		 */
		panel = panelNext;
		panel.setVisible(true);   //Si vede ora!
		
		
		
		/*
		 * 
		 * Elementi pannello
		 * 
		 */
		
		labelTitolo = new JLabel();	
		labelTitolo.setFont(new Font("Arial", 0, 20));
		labelTitolo.setBounds(panel.getWidth()/3, panel.getHeight()/49, panel.getWidth()/3, panel.getHeight()/7);
		labelTitolo.setVerticalAlignment(JLabel.CENTER);
		labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		labelTitolo.setText("GESTIONE INDICI");
		panel.add(labelTitolo);
		
		
		
		
		radioTotale = new JRadioButton("TOTALI");
		radioTotale.setBounds(panel.getWidth()/7+100, panel.getHeight()/6, panel.getWidth()/7, panel.getHeight()/14);
		panel.add(radioTotale);   //aggiungo il radiobutton al pannello 1
		
		radioAnnuale = new JRadioButton("ANNUALI");
		radioAnnuale.setBounds(panel.getWidth()/7*3, panel.getHeight()/6, panel.getWidth()/7, panel.getHeight()/14);
		panel.add(radioAnnuale);
		
		radioUltimaOfferta = new JRadioButton("ULTIMA OFFERTA");
		radioUltimaOfferta.setBounds(panel.getWidth()/7*5-100, panel.getHeight()/6, panel.getWidth()/7, panel.getHeight()/14);
		panel.add(radioUltimaOfferta);
		
		gruppoRadioButton = new ButtonGroup();
		gruppoRadioButton.add(radioTotale);
		gruppoRadioButton.add(radioAnnuale);
		gruppoRadioButton.add(radioUltimaOfferta);   //Ora solo uno di questi 3 e' selezionabile
		
		
		
		
		labelAmbiente = new JLabel();        //Etichetta per i mezzi
		labelAmbiente.setFont(new Font("Arial", 0, 15));
		labelAmbiente.setBounds(panel.getWidth()/11-35, panel.getHeight()/6*2, panel.getWidth()/6, 20);
		labelAmbiente.setText("Ambiente");
		panel.add(labelAmbiente);
		
		
		tendinaAmbiente = new JComboBox<String>();	  //Tendina per i mezzi
		tendinaAmbiente.setBackground(Color.WHITE);
		tendinaAmbiente.setEnabled(false);
		tendinaAmbiente.setBounds(panel.getWidth()/11-35, panel.getHeight()/6*2+20, panel.getWidth()/6, 20);
		panel.add(tendinaAmbiente);

		
		
		
		labelMezzi = new JLabel();        //Etichetta per i mezzi
		labelMezzi.setFont(new Font("Arial", 0, 15));
		labelMezzi.setBounds(panel.getWidth()/11*3-35, panel.getHeight()/6*2, panel.getWidth()/6, 20);
		labelMezzi.setText("Mezzo di Trasporto");
		panel.add(labelMezzi);
		
		
		tendinaMezzi = new JComboBox<String>();	  //Tendina per i mezzi
		tendinaMezzi.setBackground(Color.WHITE);
		tendinaMezzi.setEnabled(false);
		tendinaMezzi.setBounds(panel.getWidth()/11*3-35, panel.getHeight()/6*2+20, panel.getWidth()/6, 20);
		panel.add(tendinaMezzi);
		
		
		labelCittaPartenza = new JLabel();        //Etichetta per Stazioni di partenza
		labelCittaPartenza.setFont(new Font("Arial", 0, 15));
		labelCittaPartenza.setBounds(panel.getWidth()/11*5-35, panel.getHeight()/6*2, panel.getWidth()/6, 20);
		labelCittaPartenza.setText("Citta' di Partenza");
		panel.add(labelCittaPartenza);
		
		
		tendinaCittaPartenza = new JComboBox<String>();	 //Tendina per stazioni di partenza
		tendinaCittaPartenza.setBackground(Color.WHITE);
		tendinaCittaPartenza.setBounds(panel.getWidth()/11*5-35, panel.getHeight()/6*2+20, panel.getWidth()/6, 20);
		tendinaCittaPartenza.setEnabled(false);
		panel.add(tendinaCittaPartenza);
		
		
		labelCittaArrivo = new JLabel();        //Etichetta per Stazione di arrivo
		labelCittaArrivo.setFont(new Font("Arial", 0, 15));
		labelCittaArrivo.setBounds(panel.getWidth()/11*7-35, panel.getHeight()/6*2, panel.getWidth()/6, 20);
		labelCittaArrivo.setText("Citta' di Arrivo");
		panel.add(labelCittaArrivo);
		
		
		tendinaCittaArrivo = new JComboBox<String>();	 //Tendina per stazioni di arrivo
		tendinaCittaArrivo.setBackground(Color.WHITE);
		tendinaCittaArrivo.setBounds(panel.getWidth()/11*7-35, panel.getHeight()/6*2+20, panel.getWidth()/6, 20);
		tendinaCittaArrivo.setEnabled(false);
		panel.add(tendinaCittaArrivo);
		
		
		labelVia = new JLabel();	//Etichetta per Stazione intermedia
		labelVia.setFont(new Font("Arial", 0, 15));
		labelVia.setBounds(panel.getWidth()/11*9-35, panel.getHeight()/6*2, panel.getWidth()/6, 20);
		labelVia.setText("Via");
		panel.add(labelVia);
		
		
		tendinaVia = new JComboBox<String>(); //Tendina per stazioni intermedie
		tendinaVia.setBackground(Color.WHITE);
		tendinaVia.setBounds(panel.getWidth()/11*9-35, panel.getHeight()/6*2+20, panel.getWidth()/6, 20);
		tendinaVia.setEnabled(false);
		panel.add(tendinaVia);
		
		
		
		
		ascoltatoreRadioButtonTotale		  = new RadioButtonTotaleAA();
		ascoltatoreRadioButtonAnnuale		  = new RadioButtonAnnualeAA();
		ascoltatoreRadioButtonUltimaOfferta	  = new RadioButtonUltimaOffertaAA();
		ascoltatoreTendinaAmbiente   = new TendinaAmbienteAA();
		ascoltatoreTendinaMezzi	  = new TendinaMezziAA();
		ascoltatoreTendinaPartenze   = new TendinaPartenzeAA();
		ascoltatoreTendinaArrivi     = new TendinaArriviAA();
		ascoltatoreTendinaVia 		  = new TendinaViaAA();
		
		
		
		radioTotale.addActionListener(ascoltatoreRadioButtonTotale);
		radioAnnuale.addActionListener(ascoltatoreRadioButtonAnnuale);
		radioUltimaOfferta.addActionListener(ascoltatoreRadioButtonUltimaOfferta);
		tendinaAmbiente.addActionListener(ascoltatoreTendinaAmbiente);
		tendinaMezzi.addActionListener(ascoltatoreTendinaMezzi);
		tendinaCittaPartenza.addActionListener(ascoltatoreTendinaPartenze);
		tendinaCittaArrivo.addActionListener(ascoltatoreTendinaArrivi);
		tendinaVia.addActionListener(ascoltatoreTendinaVia);
		
		
		
		
	}
	
	
	
		
	// Aggiorna la tendina degli ambienti del secondo pannello
		private void aggiornaTendine() { 
			
			tendinaAmbiente.removeAllItems();
			tendinaAmbiente.setEnabled(false);
								
			//imposto ambiente scelto
			ambienteScelto = "-----";
			
			try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
				Set<String> s = controllore.mostraAmbientiInCatalogo();
				Iterator<String> it = s.iterator();
				if (s.size() > 1){ //se c'e' piu' di un elemento visualizzo l'elemento neutro
					//devo aggiungere l'elemento vuoto
					tendinaAmbiente.addItem("-----");
				}
					
				while(it.hasNext()){ 					//itero l'insieme di chiavi
					tendinaAmbiente.addItem(it.next());  //ne aggiungo uno alla volta
				}
					
				tendinaAmbiente.setEnabled(true);
				

				
			} catch (MappaException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			} 

		}
	
	
	
	
	private class RadioButtonTotaleAA implements ActionListener{
		
		/*
		 *  Quando premo il bottone via Aria
		 */

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			metodoScelto = "Totale";			//Cambia l'ambiente scelto
			aggiornaTendine();
		}
	
	}


	private class RadioButtonAnnualeAA implements ActionListener{
		
		/*
		 *  Quando premo il bottone via Mare
		 */

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			metodoScelto = "Annuale"; 			//Cambia l'ambiente scelto
			aggiornaTendine();
		}
		
	}
	
	private class RadioButtonUltimaOffertaAA implements ActionListener{
		
		/*
		 *  Quando premo il bottone via Terra
		 */

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			metodoScelto = "UltimaOfferta"; 			//Cambia l'ambiente scelto
			aggiornaTendine();
		}
		
	}
	
	
	private class TendinaAmbienteAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaMezzi.removeAllItems();
			tendinaMezzi.setEnabled(false);
			
			//prendo il valore di questa tendina
			ambienteScelto	= (String)tendinaAmbiente.getSelectedItem();
			
			if (tendinaAmbiente.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
			
					
					if(!ambienteScelto.equals("-----")){ //Solo se non e' l'elemento neutro
							
						try {  //cerca nella mappa tutte le chiavi da aggiungere in tendina
							Set<String> s = controllore.mostraMezziInCatalogo(ambienteScelto);
							Iterator<String> it = s.iterator();
							
							if (s.size() > 1){
								//inserisco l'elemento neutro
								tendinaMezzi.addItem("-----");
							}
							
							while(it.hasNext()){ 					//itero l'insieme di chiavi
								tendinaMezzi.addItem(it.next());  //ne aggiungo uno alla volta
							}
							tendinaMezzi.setEnabled(true);
							
						} catch (DirittiException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						} catch (IDEsternoElementoException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						}
					}
	
			}
		
		}
		
	}
	
	
	private class TendinaMezziAA implements ActionListener{
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaCittaPartenza.removeAllItems();
			tendinaCittaPartenza.setEnabled(false);
			
			//prendo il valore delle altre tendina
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();   //Neanche servirebbe, in teoria...
			mezzoScelto = (String)tendinaMezzi.getSelectedItem();
			
			if (tendinaMezzi.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
	
				if(!mezzoScelto.equals("-----")){ //Solo se non e' l'elemento neutro
					
					try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
						Set<String> s = controllore.mostraCittaDiPartenzaInCatalogo(ambienteScelto, mezzoScelto);
						Iterator<String> it = s.iterator();
						
						if (s.size() > 1){
							//inserisco l'elemento neutro
							tendinaCittaPartenza.addItem("-----");
						}
						
						while(it.hasNext()){ 					//itero l'insieme di chiavi
							tendinaCittaPartenza.addItem(it.next());  //ne aggiungo uno alla volta
						}
						
						tendinaCittaPartenza.setEnabled(true);
						
					} catch (DirittiException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}   
				}
						
	
			}
		
		}
		
	}
	
	private class TendinaPartenzeAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaCittaArrivo.removeAllItems();
			tendinaCittaArrivo.setEnabled(false);
			
			//prendo il valore delle altre tendina
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			
			if (tendinaCittaPartenza.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
				
				if(!partenzaScelta.equals("-----")){ //Solo se non e' l'elemento neutro
					
					try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
						Set<String> s = controllore.mostraCittaDiArrivoInCatalogo(ambienteScelto, mezzoScelto, partenzaScelta);
						Iterator<String> it = s.iterator();
						
						if(s.size() > 1){
							//inserisco l'elemento neutro
							tendinaCittaArrivo.addItem("-----");
						}
						
						while(it.hasNext()){ 					//itero l'insieme di chiavi
							tendinaCittaArrivo.addItem(it.next());  //ne aggiungo uno alla volta
						}
						
						tendinaCittaArrivo.setEnabled(true);
						tendinaCittaArrivo.setSelectedIndex(0);
						
					} catch (DirittiException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
			
			}
			
		}
		
	}
	
	private class TendinaArriviAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Svuotiamo tutte le tendine successive (non le precedenti) e le disattiviamo
			tendinaVia.removeAllItems();
			tendinaVia.setEnabled(false);
			
			//prendo il valore delle altre tendina
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			
			if (tendinaCittaArrivo.getItemCount() != 0) { //ci deve essere almeno un elemento, se ho la tendina vuota mi va in null pointer exception.
				
				if(!arrivoScelto.equals("-----")){ //Solo se non e' l'elemento neutro
					
					try { //cerca nella mappa tutte le chiavi da aggiungere in tendina
						Set<String> s = controllore.mostraViaInCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto);
						Iterator<String> it = s.iterator();
						
						if(s.size() > 1){
							//inserisco l'elemento neutro
							tendinaVia.addItem("-----");
						}
						
						while(it.hasNext()){ 					//itero l'insieme di chiavi
							tendinaVia.addItem(it.next());  //ne aggiungo uno alla volta
						}
						
						tendinaVia.setEnabled(true);
						tendinaVia.setSelectedIndex(0);
						
					} catch (DirittiException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					} catch (IDEsternoElementoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
	
				
			}
			
			
		}
		
	}
	
	
	private class TendinaViaAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ambienteScelto = (String) tendinaAmbiente.getSelectedItem();
			mezzoScelto = (String) tendinaMezzi.getSelectedItem();
			partenzaScelta = (String) tendinaCittaPartenza.getSelectedItem();
			arrivoScelto = (String)tendinaCittaArrivo.getSelectedItem();
			viaScelta = (String) tendinaVia.getSelectedItem();
			
//			if (tendinaVia.getItemCount() != 0) {
//				//Aggiorno l'area testo che mostra il catalogo
//				try {
//					
//					areaTestoCatalogo = controllore.mostraCatalogo(ambienteScelto, mezzoScelto, partenzaScelta, arrivoScelto, viaScelta);
//					areaTesto.setText(areaTestoImp + areaTestoCatalogo);
//					areaTesto.setCaretPosition(0);
//					
//				} catch (DirittiException e1) {
//					JOptionPane.showMessageDialog(null, e1.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
//				} catch (MappaException e1) {
//					areaTesto.setText(e1.getMessage()+"\n");
//				} catch (IDEsternoElementoException e1) {
//					areaTesto.setText(e1.getMessage()+"\n");
//				} catch (TrattaInesistenteException e1) {
//					areaTesto.setText(e1.getMessage()+"\n");
//				}
//				
//			}
			
		}
		
	}

}
