package Vista.Cliente;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

@SuppressWarnings("serial")
public class RetirarIngresar extends JPanel{

	private JLabel txt;
	private JTextField cant;
	private PrincipalUss usr;
	private JButton volver;
	private String numTarjeta;
	private JPanel botonera;
	
	/**
	 * Constructor de la clase
	 * @param usr [Ventana principal del usuario]
	 * @param texto [La accion a realizar]
	 * @param n [Numero de la Tarjeta]
	 */
	
	public RetirarIngresar(PrincipalUss usr, String texto,String n) {
		
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
		
		//panel Content
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(2,1));
		
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
				usr.remove(content);
				usr.repaint();
				usr.mostrarPanel(usr.getP());
			}
		});
		
		this.setBackground(new Color(250,230,150));
		content.add(this);content.add(botonera);
		content.setVisible(true);
		usr.getP().setVisible(false);
		usr.remove(usr.getP());
		usr.repaint();
		usr.add(content);
		
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
	 * @param usr Panel Principal del Usuario
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
	 * @param txt Texto
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
	 * @param cant Cantidad de Dinero
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
	 * @param volver Volver al panel Principal
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
	 * @param numTarjeta Numero de la Tarjeta
	 */

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	
	
}
