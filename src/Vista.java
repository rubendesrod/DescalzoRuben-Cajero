import java.awt.Dimension;

import javax.swing.JFrame;

public class Vista extends JFrame{

	public Vista() {
		
		super("Cajero Automatico");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(600,600));
		this.pack();
		
	}
	
	public static void main(String[] args) {
		Vista v = new Vista();
		v.setVisible(true);
	}
	
}
