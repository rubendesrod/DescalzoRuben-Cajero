package Vista.Cliente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controlador.Cliente.GestorCambiarPin;


public class CambiarPin extends JPanel{

	private String numTarjeta;
	private PrincipalUss usr;
	
	private JButton volver;
	private JTextField actualPin;
	private JPasswordField nuevoPin;
	private JButton cambiar;
	private JLabel errores;
	
	public CambiarPin(PrincipalUss usr,String numTarjeta) {
		this.numTarjeta = numTarjeta;
		this.usr = usr;
		this.setLayout(null);
		
		ImageIcon ch = new ImageIcon("img/cambiarPIN.png");
		
		actualPin = new JTextField();
		nuevoPin = new JPasswordField();
		cambiar = new JButton();
		cambiar.setIcon(ch);
		cambiar.addActionListener(new GestorCambiarPin(this, numTarjeta));
		errores = new JLabel("");
		errores.setForeground(Color.red);
		volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				usr.remove(CambiarPin.this);;
				usr.repaint();
				usr.mostrarPanel(usr.getP());;
				
			}
		});
		
		JLabel actual = new JLabel("Pin actual:");
		JLabel nuevo = new JLabel("Pin nuevo:");
		

		actualPin.setLocation(260, 120);
		actualPin.setSize(40, 20);
		nuevoPin.setLocation(260,150);
		nuevoPin.setSize(40, 20);
		cambiar.setLocation(250, 180);
		cambiar.setSize(60,60);
		cambiar.setBorderPainted(false);
		cambiar.setContentAreaFilled(false);
		errores.setLocation(210, 70);
		errores.setSize(160, 20);
		volver.setLocation(340, 200);
		volver.setSize(70, 30);
		actual.setLocation(195, 120);
		actual.setSize(60, 20);
		nuevo.setLocation(195, 150);
		nuevo.setSize(60, 20);
		
		
		this.add(actualPin);this.add(nuevoPin);this.add(cambiar);
		this.add(volver);this.add(errores);this.add(nuevo);this.add(actual);
		
		usr.getP().setVisible(false);
		usr.remove(usr.getP());
		usr.repaint();
		usr.add(this);
		
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public PrincipalUss getUsr() {
		return usr;
	}

	public void setUsr(PrincipalUss usr) {
		this.usr = usr;
	}

	public JButton getVolver() {
		return volver;
	}

	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	public JTextField getActualPin() {
		return actualPin;
	}

	public void setActualPin(JTextField actualPin) {
		this.actualPin = actualPin;
	}

	public JPasswordField getNuevoPin() {
		return nuevoPin;
	}

	public void setNuevoPin(JPasswordField nuevoPin) {
		this.nuevoPin = nuevoPin;
	}

	public JButton getCambiar() {
		return cambiar;
	}

	public void setCambiar(JButton cambiar) {
		this.cambiar = cambiar;
	}

	public JLabel getErrores() {
		return errores;
	}

	public void setErrores(JLabel errores) {
		this.errores = errores;
	}
	
	
	
}
