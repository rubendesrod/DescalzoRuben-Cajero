package Vista.Cliente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.Cliente.GestorRI;

/**
 * Clase que extiende de JPanel, muestra al usuario la informacion
 * para realizar un retiro o un ingreso dependiendo de que boton haya dado
 * 
 * @version 1.0
 * @author Ruben
 */

public class RetirarIngresar extends JPanel{

	private JLabel txt;
	private JTextField cant;
	private PrincipalUss usr;
	private JButton volver;
	private String numTarjeta;
	private JPanel botonera;
	private String texto;
	
	/**
	 * Constructor de la clase
	 * @param usr [Ventana principal del usuario]
	 * @param texto [La accion a realizar]
	 * @param n [Numero de la Tarjeta]
	 */
	
	public RetirarIngresar(PrincipalUss usr, String texto,String n) {
		
		this.texto = texto;
		this.usr = usr;
		this.numTarjeta = n;
		this.setLayout(null);
		
		if(texto.equalsIgnoreCase("retirada")) {
			txt = new JLabel("Ingrese la cantidad a retirar:");
		} else {
			txt = new JLabel("Cuanto vas a ingresar:");
		}
		cant = new JTextField();
		volver = new JButton();

		
		txt.setLocation(50,80);
		txt.setSize(180, 20);
		cant.setLocation(220,80);
		cant.setSize(160,25);
		volver.setLocation(440,80);
		volver.setSize(40, 40);
		ImageIcon back = new ImageIcon("img/volver.png");
		volver.setIcon(back);
		volver.setBorderPainted(false);
		volver.setContentAreaFilled(false);
		
		this.add(txt);this.add(cant);this.add(volver);
		
		//Los botones de la calculadora
		
		botonera = new JPanel();
		botonera.setLayout(new GridLayout(4, 3));

        // Crear los botones del 0 al 9
        for (int i = 0; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cant.setText(cant.getText()+btn.getText());	
				}	
            });
            botonera.add(btn);
        }

        
        // Crear el botón de borrar
        JButton retroceder = new JButton("Borrar");

        retroceder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cant.setText("");
			}
        });
        
        botonera.add(retroceder);

        // Crear el botón de aceptar
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new GestorRI(this,texto, numTarjeta));
        botonera.add(aceptar);
		
		
		// Action listyener boton volver
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				usr.remove(botonera);
				RetirarIngresar.this.repaint();
				usr.remove(RetirarIngresar.this);
				usr.repaint();
				usr.mostrarPanel(usr.getP());
			}
		});
		
		this.setBackground(new Color(250,230,150));
		usr.getP().setVisible(false);
		usr.setLayout(new GridLayout(2,1));
		usr.remove(usr.getP());
		usr.repaint();
		usr.add(this);
		usr.add(botonera);
		
	}

	/**
	 * Metodo get de usr
	 * @return PrincipalUsr
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
	 * Metodo del txt
	 * @return JLabel
	 */
	
	public JLabel getTxt() {
		return txt;
	}
	
	/**
	 * Metodo set del txt
	 * @param txt
	 */

	public void setTxt(JLabel txt) {
		this.txt = txt;
	}
	
	/**
	 * Metodo get de la Cantidad
	 * @return JTextField
	 */

	public JTextField getCant() {
		return cant;
	}

	/**
	 * Metodo set de la Cantidad
	 * @param cant
	 */
	
	public void setCant(JTextField cant) {
		this.cant = cant;
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
	 * Metodo get del Numero de la Tarjeta
	 * @return String
	 */

	public String getNumTarjeta() {
		return numTarjeta;
	}

	/**
	 * Metodo se del Numero de la Tarjeta
	 * @param numTarjeta
	 */

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	
	
	
	
}
