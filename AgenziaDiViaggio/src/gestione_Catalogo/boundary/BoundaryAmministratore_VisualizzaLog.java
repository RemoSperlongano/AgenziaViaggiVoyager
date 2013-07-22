/**
 * 
 */
package gestione_Catalogo.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import gestione_Catalogo.control.ControlloreVisualizzaLog;
import gestione_Catalogo.exception.FileInesistenteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @authors
 * Remo Sperlongano
 * Ivan Torre
 */
public class BoundaryAmministratore_VisualizzaLog {
	
	/*
	 * Attributi di istanza
	 */
	
	//Entita'
	private ControlloreVisualizzaLog controllore;
	
	//Pannelli
	private JPanel panel;
	
	
	//Elementi panel
	//Elementi 
	
	private JLabel	labelTitolo;
	
	private JTextArea areaTesto;
	private JScrollPane scrollAreaTesto;
	
	private JButton bottoneAggiorna;
	private JButton bottoneCancellaLog;
	
	private JButton bottoneChiudi;
	
	private AggiornaAA ascoltatoreBottoneAggiorna;
	private CancellaLogAA ascoltatoreCancellaLog;
	private ChiudiAA ascoltatoreBottoneChiudi;



	
	
	public BoundaryAmministratore_VisualizzaLog(JPanel panelNext) {
		
		controllore = new ControlloreVisualizzaLog();
		
		/*
		 * 
		 * Il panel di questa Boundary prende le dimensioni del pannello Passato
		 * 
		 */
		panel = panelNext;
		panel.setVisible(true);   //Si vede ora!
		
		
		
		
		/*
		 * 
		 * Elementi del pannello
		 * 
		 */
		
		labelTitolo = new JLabel();	
		labelTitolo.setFont(new Font("Arial", 0, 20));
		labelTitolo.setBounds(panel.getWidth()/3, panel.getHeight()/200, panel.getWidth()/3, panel.getHeight()/7);
		labelTitolo.setVerticalAlignment(JLabel.CENTER);
		labelTitolo.setHorizontalAlignment(JLabel.CENTER);
		labelTitolo.setText("VISUALIZZA LOG");
		panel.add(labelTitolo);
		
		
		areaTesto = new JTextArea();
		areaTesto = new JTextArea(panel.getWidth()/40*39+10, panel.getHeight()/6*4+15);
		areaTesto.setFont(new Font("Arial", 0, 15));
		areaTesto.setEditable(false);
		areaTesto.setLineWrap(false);
		scrollAreaTesto = new JScrollPane(areaTesto);   //creo un piccolo scroll e lo aggiungo alla text area
		scrollAreaTesto.setBounds(panel.getWidth()/40, panel.getHeight()/7, panel.getWidth()/40*39+10, panel.getHeight()/6*4+15);
		panel.add(scrollAreaTesto);
		
		
		bottoneAggiorna = new JButton("AGGIORNA");
		bottoneAggiorna.setBackground(Color.YELLOW);
		bottoneAggiorna.setBounds(panel.getWidth()/5, panel.getHeight()/6*5+25, panel.getWidth()/5, panel.getHeight()/14);
		panel.add(bottoneAggiorna);
		
		bottoneCancellaLog = new JButton("CANCELLA LOG");
		bottoneCancellaLog.setBackground(Color.ORANGE);
		bottoneCancellaLog.setBounds(panel.getWidth()/5*3, panel.getHeight()/6*5+25, panel.getWidth()/5, panel.getHeight()/14);
		panel.add(bottoneCancellaLog);
		
		bottoneChiudi = new JButton("X");
		bottoneChiudi.setBackground(Color.RED);
		bottoneChiudi.setBounds(panel.getWidth()/20*19, 0, panel.getWidth()/20, panel.getHeight()/18);
		panel.add(bottoneChiudi);
		
		
		//Ascoltatori
		ascoltatoreBottoneAggiorna = new AggiornaAA();
		bottoneAggiorna.addActionListener(ascoltatoreBottoneAggiorna);
		
		ascoltatoreCancellaLog = new CancellaLogAA();
		bottoneCancellaLog.addActionListener(ascoltatoreCancellaLog);
		
		ascoltatoreBottoneChiudi = new ChiudiAA();
		bottoneChiudi.addActionListener(ascoltatoreBottoneChiudi);
		
		
		aggiornaLog();
	}
	
	
	
	private void aggiornaLog() {
		try {
			areaTesto.setText(controllore.visualizzaLog());
		} catch (FileInesistenteException e) {
			areaTesto.setText(e.getMessage());
		}
		
	}

	
	
	
	/*
	 * Ascoltatori per elementi pannello 
	 */
	
	private class AggiornaAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			aggiornaLog();
			
		}
		
	}
	
	private class CancellaLogAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int conferma = JOptionPane.showConfirmDialog(null, "Cancellare completamente il log delle operazioni?", "Conferma Cancellazione Log", JOptionPane.YES_NO_OPTION);
			if (conferma == JOptionPane.YES_OPTION){
				try {
					controllore.cancellaLog();
					aggiornaLog();
					JOptionPane.showMessageDialog(null, "Il log e' stato cancellato.", "Log Cancellato", JOptionPane.INFORMATION_MESSAGE);
				} catch (FileInesistenteException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), e.toString(), JOptionPane.INFORMATION_MESSAGE);
				}
			
			}
			
		}
		
	}
	

	private class ChiudiAA implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			panel.setVisible(false); 					//chiude questo pannello
			BoundaryAmministratore.riattivaBottoni();
			

			areaTesto.setText("");

		}
	}

}
