package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Clase que extiende de JPanel y contiene los datos del cajero apagado
 * 
 * @version 1.0
 * @author Ruben
 *
 */

public class cajeroApagado extends JPanel{

	
	private JLabel txt;
	
	/**
	 * Constructor de la clase cajeroApagado
	 */
	
	public cajeroApagado() {
		
		
		txt = new JLabel("CAJERO \n APAGADO");
		txt.setFont(new Font("Garamond", Font.BOLD, 32));
		
		this.setVisible(true);
		this.add(txt, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(350,300));
	}
	
}
