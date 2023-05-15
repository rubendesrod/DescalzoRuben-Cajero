package Vista.Cliente;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Retirar extends JPanel{

	
	private String numTarjeta;
	private JButton retirar;
	private JLabel txt;
	private JTextField cant;
	
	public Retirar(String numTarjeta) {
		
		this.numTarjeta = numTarjeta;
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		txt = new JLabel("Ingrese la cantidad a retirar:");
		retirar = new JButton("aceptar");
		cant = new JTextField();
		
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public JButton getRetirar() {
		return retirar;
	}

	public void setRetirar(JButton retirar) {
		this.retirar = retirar;
	}

	public JLabel getTxt() {
		return txt;
	}

	public void setTxt(JLabel txt) {
		this.txt = txt;
	}

	public JTextField getCant() {
		return cant;
	}

	public void setCant(JTextField cant) {
		this.cant = cant;
	}
	
	
	
}
