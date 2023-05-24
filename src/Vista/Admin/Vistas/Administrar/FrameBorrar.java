package Vista.Admin.Vistas.Administrar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Controlador.Administrador.GestorBorrarAdm;

public class FrameBorrar extends JFrame{

	private String objeto;
	private JButton aceptar;
	private JTextField pk;
	private JLabel txt;
	private JLabel errores;
	
	
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


	public String getObjeto() {
		return objeto;
	}


	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}


	public JButton getAceptar() {
		return aceptar;
	}


	public void setAceptar(JButton aceptar) {
		this.aceptar = aceptar;
	}


	public JTextField getPk() {
		return pk;
	}


	public void setPk(JTextField pk) {
		this.pk = pk;
	}


	public JLabel getTxt() {
		return txt;
	}


	public void setTxt(JLabel txt) {
		this.txt = txt;
	}


	public JLabel getErrores() {
		return errores;
	}


	public void setErrores(JLabel errores) {
		this.errores = errores;
	}
	
	
	
}
