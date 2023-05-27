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

/**
 * Clase que extiende de JPanel, muestra al usuario como realizar el cambio
 * 
 *  @version 1.0
 * @author Ruben
 */

public class CambiarPin extends JPanel{

	private String numTarjeta;
	private PrincipalUss usr;
	
	private JButton volver;
	private JTextField actualPin;
	private JPasswordField nuevoPin;
	private JButton cambiar;
	private JLabel errores;
	
	/**
	 * Constructor de la clase CambiarPin
	 * @param usr [Ventana principal del usuario]
	 * @param numTarjeta [Tarjeta del usuario]
	 */
	
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
		ImageIcon back = new ImageIcon("img/volver.png");

		actualPin.setLocation(260, 120);
		actualPin.setSize(40, 20);
		nuevoPin.setLocation(260,150);
		nuevoPin.setSize(40, 20);
		cambiar.setLocation(250, 180);
		cambiar.setSize(60,60);
		cambiar.setBorderPainted(false);
		cambiar.setContentAreaFilled(false);
		errores.setLocation(210, 70);
		errores.setSize(200, 20);
		volver.setLocation(340, 200);
		volver.setSize(70, 30);
		volver.setSize(40, 40);
		volver.setIcon(back);
		volver.setBorderPainted(false);
		volver.setContentAreaFilled(false);
		actual.setLocation(195, 120);
		actual.setSize(60, 20);
		nuevo.setLocation(195, 150);
		nuevo.setSize(60, 20);
		
		
		this.add(actualPin);this.add(nuevoPin);this.add(cambiar);
		this.add(volver);this.add(errores);this.add(nuevo);this.add(actual);
		this.setBackground(new Color(250,230,150));
		usr.getP().setVisible(false);
		usr.remove(usr.getP());
		usr.repaint();
		usr.add(this);
		
	}

	/**
	 * Metodo get del Numero de la Tarjeta
	 * @return String
	 */
	
	public String getNumTarjeta() {
		return numTarjeta;
	}

	/**
	 * Metodo set del Numero de la Tarjeta
	 * @param numTarjeta
	 */
	
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	/**
	 * Metodo get de usr
	 * @return PrincipalUss
	 */
	
	public PrincipalUss getUsr() {
		return usr;
	}

	/**
	 * Metodo set de usr
	 * @param usr
	 */
	
	public void setUsr(PrincipalUss usr) {
		this.usr = usr;
	}

	/**
	 * Metodo get de volver
	 * @return JButton
	 */
	
	public JButton getVolver() {
		return volver;
	}

	/**
	 * Metodo set de volver
	 * @param volver
	 */
	
	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	/**
	 * Metodo get de PIN Actual
	 * @return JTextField
	 */
	
	public JTextField getActualPin() {
		return actualPin;
	}

	/**
	 * Metodo set de PIN Actual
	 * @param actualPin
	 */
	
	public void setActualPin(JTextField actualPin) {
		this.actualPin = actualPin;
	}

	/**
	 * Metodo get de Nuevo PIN
	 * @return JPasswordField
	 */
	
	public JPasswordField getNuevoPin() {
		return nuevoPin;
	}

	/**
	 * Metodo set de Nuevo PIN
	 * @param nuevoPin
	 */
	
	public void setNuevoPin(JPasswordField nuevoPin) {
		this.nuevoPin = nuevoPin;
	}

	/**
	 * Metodo get de cambiar
	 * @return JButton
	 */
	
	public JButton getCambiar() {
		return cambiar;
	}

	/**
	 * Metodo set de cambiar
	 * @param cambiar
	 */
	
	public void setCambiar(JButton cambiar) {
		this.cambiar = cambiar;
	}

	/**
	 * Metodo get del texto errores
	 * @return JLabel
	 */
	
	public JLabel getErrores() {
		return errores;
	}
	
	/**
	 * Metodo set del texto errores
	 * @param errores
	 */

	public void setErrores(JLabel errores) {
		this.errores = errores;
	}
	
	
	
}
