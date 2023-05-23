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


public class FrameCrear extends JFrame{

	private String objeto;
	private JLabel errores;
	private JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8;
	private JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8;
	private JButton aceptar;
	private Choice c;
	
	public FrameCrear(String objeto) {
		super("Menu Crear");
		this.objeto = objeto;
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

	
	
	public JLabel getErrores() {
		return errores;
	}



	public void setErrores(JLabel errores) {
		this.errores = errores;
	}



	public Choice getC() {
		return c;
	}



	public void setC(Choice c) {
		this.c = c;
	}



	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public JLabel getLb1() {
		return lb1;
	}

	public void setLb1(JLabel lb1) {
		this.lb1 = lb1;
	}

	public JLabel getLb2() {
		return lb2;
	}

	public void setLb2(JLabel lb2) {
		this.lb2 = lb2;
	}

	public JLabel getLb3() {
		return lb3;
	}

	public void setLb3(JLabel lb3) {
		this.lb3 = lb3;
	}

	public JLabel getLb4() {
		return lb4;
	}

	public void setLb4(JLabel lb4) {
		this.lb4 = lb4;
	}

	public JLabel getLb5() {
		return lb5;
	}

	public void setLb5(JLabel lb5) {
		this.lb5 = lb5;
	}

	public JLabel getLb6() {
		return lb6;
	}

	public void setLb6(JLabel lb6) {
		this.lb6 = lb6;
	}

	public JLabel getLb7() {
		return lb7;
	}

	public void setLb7(JLabel lb7) {
		this.lb7 = lb7;
	}

	public JLabel getLb8() {
		return lb8;
	}

	public void setLb8(JLabel lb8) {
		this.lb8 = lb8;
	}

	public JButton getAceptar() {
		return aceptar;
	}

	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}

	public JTextField getTxt1() {
		return txt1;
	}

	public void setTxt1(JTextField txt1) {
		this.txt1 = txt1;
	}

	public JTextField getTxt2() {
		return txt2;
	}

	public void setTxt2(JTextField txt2) {
		this.txt2 = txt2;
	}

	public JTextField getTxt3() {
		return txt3;
	}

	public void setTxt3(JTextField txt3) {
		this.txt3 = txt3;
	}

	public JTextField getTxt4() {
		return txt4;
	}

	public void setTxt4(JTextField txt4) {
		this.txt4 = txt4;
	}

	public JTextField getTxt5() {
		return txt5;
	}

	public void setTxt5(JTextField txt5) {
		this.txt5 = txt5;
	}

	public JTextField getTxt6() {
		return txt6;
	}

	public void setTxt6(JTextField txt6) {
		this.txt6 = txt6;
	}

	public JTextField getTxt7() {
		return txt7;
	}

	public void setTxt7(JTextField txt7) {
		this.txt7 = txt7;
	}

	public JTextField getTxt8() {
		return txt8;
	}

	public void setTxt8(JTextField txt8) {
		this.txt8 = txt8;
	}
	
	
	
}
