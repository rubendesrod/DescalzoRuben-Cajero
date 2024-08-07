package Vista.Admin.Vistas.Administrar;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.Administrador.GestorCrearAdm;

/**
 * Clase que extiende de JFrame, muestra al administrador
 * que datos puede crear del objeto que haya seleccionado
 * 
 * @version 1.0
 * @author Ruben
 */

@SuppressWarnings("serial")
public class FrameCrear extends JFrame{

	private JLabel errores;
	private JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8;
	private JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8;
	private JButton aceptar;
	private Choice c;
	
	/**
	 * Constructor de la clase FrameCrear
	 * @param objeto [Texto del objeto seleccionados]
	 */
	
	public FrameCrear(String objeto) {
		super("Menu Crear");
		aceptar = new JButton("crear");
		errores = new JLabel("");
		errores.setForeground(Color.red);
		
		if(objeto.equalsIgnoreCase("cliente")) {
			//Crear cliente
			lb1 = new JLabel("*DNI");lb2 = new JLabel("*Nombre");lb3 = new JLabel("*Apell1");lb4 = new JLabel("Apell2");
			lb8 = new JLabel("*FechaNacimiento");lb7 = new JLabel("*Telefono");lb6 = new JLabel("Correo");lb5 = new JLabel("*Direccion");
			txt1 = new JTextField(6);txt2 = new JTextField(15);txt3 = new JTextField(15);txt4 = new JTextField(15);
			txt8 = new JTextField(6);txt7 = new JTextField(9);txt6 = new JTextField(18);txt5 = new JTextField(20);
			aceptar.addActionListener(new GestorCrearAdm("cliente", this));
			this.add(lb1);this.add(txt1);this.add(lb2);this.add(txt2);this.add(lb3);this.add(txt3);this.add(lb4);this.add(txt4);
			this.add(lb8);this.add(txt8);this.add(lb7);this.add(txt7);this.add(lb6);this.add(txt6);this.add(lb5);this.add(txt5);
			this.add(aceptar);
			
			
			
		}else if (objeto.equalsIgnoreCase("tarjeta")) {
			//Crear Tarjeta
			c = new Choice();
			c.add("noBloqueado");c.add("bloqueado");
			lb1 = new JLabel("*Numero");lb2 = new JLabel("*PIN");lb3 = new JLabel("*CVV");lb4 = new JLabel("*FechaValidez");
			lb5 = new JLabel("*Estado");
			txt1 = new JTextField(10);txt2 = new JTextField(6);txt3 = new JTextField(6);txt4 = new JTextField(6);
			txt5 = new JTextField(6);
			aceptar.addActionListener(new GestorCrearAdm("tarjeta", this));
			this.add(lb1);this.add(txt1);this.add(lb2);this.add(txt2);this.add(lb3);this.add(txt3);this.add(lb4);this.add(txt4);
			this.add(lb5);this.add(c);this.add(aceptar);
			
			
			
		}else if (objeto.equalsIgnoreCase("cuenta")) {
			//Crear Cuenta
			lb1 = new JLabel("*Numero");lb2 = new JLabel("(por defecto pon 0) Saldo");
			lb3 = new JLabel("El numero de cuenta empieza con [ES***]");
			txt1 = new JTextField(16);txt2 = new JTextField(5);
			aceptar.addActionListener(new GestorCrearAdm("Cuenta", this));
			this.add(lb1);this.add(txt1);this.add(lb2);this.add(txt2);
			this.add(lb3);this.add(aceptar);
		}
		
		
		
		this.add(errores);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(580,180));
		this.pack();
		this.setResizable(false);
	}

	/**
	 * Metodo get de errores
	 * @return JLabel
	 */
	
	public JLabel getErrores() {
		return errores;
	}

	/**
	 * Metodo set de errores
	 * @param errores texto donde marca los errores
	 */
	
	public void setErrores(JLabel errores) {
		this.errores = errores;
	}

	/**
	 * Metodo get de c
	 * @return Choice
	 */
	
	public Choice getC() {
		return c;
	}
	
	/**
	 * Metodo set de c
	 * @param c Para solo poder elegir los dos estados que puede tener una Tarjeta
	 */

	public void setC(Choice c) {
		this.c = c;
	}
	
	/**
	 * Metodo get de txt1
	 * @return JTextField
	 */

	public JTextField getTxt1() {
		return txt1;
	}
	
	/**
	 * Metodo set de txt1
	 * @param txt1 Campo de texto
	 */

	public void setTxt1(JTextField txt1) {
		this.txt1 = txt1;
	}
	/**
	 * Metodo get de txt2
	 * @return JTextField
	 */
	
	public JTextField getTxt2() {
		return txt2;
	}

	/**
	 * Metodo set de txt2
	 * @param txt2 Campo de texto
	 */
	
	public void setTxt2(JTextField txt2) {
		this.txt2 = txt2;
	}

	/**
	 * Metodo get de txt3
	 * @return JTextField
	 */
	
	public JTextField getTxt3() {
		return txt3;
	}
	
	/**
	 * Metodo set de txt3
	 * @param txt3 Campo de texto
	 */

	public void setTxt3(JTextField txt3) {
		this.txt3 = txt3;
	}

	/**
	 * Metodo get de txt4
	 * @return JTextField
	 */
	
	public JTextField getTxt4() {
		return txt4;
	}
	
	/**
	 * Metodo set de txt4
	 * @param txt4 Campo de texto
	 */

	public void setTxt4(JTextField txt4) {
		this.txt4 = txt4;
	}

	/**
	 * Metodo get de txt5
	 * @return JTextField
	 */
	
	public JTextField getTxt5() {
		return txt5;
	}
	
	/**
	 * Metodo set de txt5
	 * @param txt5 Campo de texto
	 */

	public void setTxt5(JTextField txt5) {
		this.txt5 = txt5;
	}

	/**
	 * Metodo get de txt6
	 * @return JTextField
	 */
	
	public JTextField getTxt6() {
		return txt6;
	}

	/**
	 * Metodo set de txt6
	 * @param txt6 Campo de texto
	 */
	
	public void setTxt6(JTextField txt6) {
		this.txt6 = txt6;
	}

	/**
	 * Metodo get de txt7
	 * @return JTextField
	 */
	
	public JTextField getTxt7() {
		return txt7;
	}

	/**
	 * Metodo set de txt7
	 * @param txt7 Campo de texto
	 */
	
	public void setTxt7(JTextField txt7) {
		this.txt7 = txt7;
	}

	/**
	 * Metodo get de txt8
	 * @return JTextField
	 */
	
	public JTextField getTxt8() {
		return txt8;
	}
	
	/**
	 * Metodo set de txt8
	 * @param txt8 Campo de texto
	 */

	public void setTxt8(JTextField txt8) {
		this.txt8 = txt8;
	}
	
	
	
}
