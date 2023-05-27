package Vista.Admin.Vistas.Administrar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.Administrador.GestorBorrarAdm;

/**
 * Clase que extiende de JFrame, se encarga de recibir un dato
 * y de borrar de la BB.DD el objeto.
 * 
 * @version 1.0
 * @author Ruben
 */

public class FrameBorrar extends JFrame{

	private String objeto;
	private JButton aceptar;
	private JTextField pk;
	private JLabel txt;
	private JLabel errores;
	
	/**
	 * Constructor de la clase FrameBorrar
	 * @param objeto [Texto que dice sobre quien realizar la accion]
	 */
	
	public FrameBorrar(String objeto) {
		
		super("Adminitar borrar");
		
		this.objeto = objeto;
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.pack();
		this.setSize(new Dimension(300,150));
		this.setResizable(false);
		aceptar = new JButton("Borrar");
		errores = new JLabel("");
		errores.setForeground(Color.red);
		
		if(objeto.equalsIgnoreCase("cliente")) {
			
			txt = new JLabel("Introduce el DNI");
			pk = new JTextField(10);
			aceptar.addActionListener(new GestorBorrarAdm(this,objeto));
			this.add(txt);this.add(pk);this.add(aceptar);this.add(errores);
			
			
		}else if(objeto.equalsIgnoreCase("tarjeta")) {
			
			txt = new JLabel("Introduce el numero de la Tarjeta");
			pk = new JTextField(10);
			aceptar.addActionListener(new GestorBorrarAdm(this,objeto));
			this.add(txt);this.add(pk);this.add(aceptar);this.add(errores);
			
			
		}else if(objeto.equalsIgnoreCase("cuenta")) {
			
			txt = new JLabel("Introduce el numero de cuenta");
			pk = new JTextField(16);
			aceptar.addActionListener(new GestorBorrarAdm(this,objeto));
			this.add(txt);this.add(pk);this.add(aceptar);this.add(errores);
		}	
	}

	/**
	 * Metodo get de PK
	 * @return JTextField
	 */
	
	public JTextField getPk() {
		return pk;
	}
	
	/**
	 * Metodo set de Pk
	 * @param pk
	 */

	public void setPk(JTextField pk) {
		this.pk = pk;
	}

	/**
	 * Metodo get errores
	 * @return JLabel
	 */
	
	public JLabel getErrores() {
		return errores;
	}

	/**
	 * Metodo set de errores
	 * @param errores
	 */

	public void setErrores(JLabel errores) {
		this.errores = errores;
	}
	
	
	
}
