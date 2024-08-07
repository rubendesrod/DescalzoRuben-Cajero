package Vista.Cliente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Vista.Vista;

/**
 * Clase que extiende de JFrame, es la principal del usuario
 * muestra al usuario las Opciones que puede realizar en el cajero
 * 
 * @version 1.0
 * @author Ruben
 */

@SuppressWarnings("serial")
public class PrincipalUss extends JFrame{

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JPanel p;
	private JPanel wMark;
	private ArrayList<JButton> botonera;
	private String numTarjeta;
	
	/**
	 * Constructor de la clase PrincipalUss
	 * @param n Numero de la Tarjeta
	 */
	
	public PrincipalUss( String n) {
		super("Ventana Usuario");
		
		this.numTarjeta = n;
		
		Image icono = Toolkit.getDefaultToolkit().getImage("img/cajero.png");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(600,450));
		this.pack();
		this.setResizable(false);
		this.setIconImage(icono);
		
		
		p = new JPanel(); p.setOpaque(false);
		p.setLayout(new GridLayout(2,3));
		

		btn1 = new JButton("Retirar");
		btn2 = new JButton("Ingresar");
		btn3 = new JButton("Cambiar PIN");
		btn4 = new JButton("Movimientos y Saldo");
		btn5 = new JButton("Salir");
		
		// Aqui se aplica el estilo de los botones recorriendo un array donde estan guardados estos
		Border bordeRelieve = new BevelBorder(BevelBorder.RAISED);
		Border bordeTam = new EmptyBorder(20,20,20,20);
		botonera = new ArrayList<JButton>();
		botonera.add(btn1);botonera.add(btn2);botonera.add(btn3);botonera.add(btn4);botonera.add(btn5);
		for(int i = 0; i<botonera.size();i++) {
			botonera.get(i).setForeground(Color.BLACK);
			botonera.get(i).setBorder(new CompoundBorder(bordeRelieve,bordeTam));
			botonera.get(i).setBackground(new Color(215,189,81));
		}
		
		
		
		//Action listener de todos los botones
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				RetirarIngresar r = new RetirarIngresar(PrincipalUss.this,"retirada", numTarjeta);
				r.setVisible(true);
			}	
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				RetirarIngresar r = new RetirarIngresar(PrincipalUss.this,"ingreso", numTarjeta);
				r.setVisible(true);
			}	
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				CambiarPin c = new CambiarPin(PrincipalUss.this,numTarjeta);
				c.setVisible(true);
			}	
		});
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VistaMovimientos vm = new VistaMovimientos(PrincipalUss.this, numTarjeta);
				vm.setVisible(true);
			}	
		});
		btn5.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			PrincipalUss.this.dispose();
			Vista v = new Vista();
			v.setVisible(true);
		}	
	});
		
		p.add(btn1);p.add(btn4);
		p.add(btn2);p.add(btn5);
		p.add(btn3);
		p.setOpaque(true);
		p.setBackground(new Color(250,230,150));
		this.add(p);
		
	}

	/**
	 * Metodo mostrar Panel
	 * @param p Panel principal
	 */
	
	public void mostrarPanel(JPanel p) {
		p.setVisible(true);;
		this.add(p);
	}
	
	/**
	 * Metodo get Btn1
	 * @return JButton
	 */
	
	public JButton getBtn1() {
		return btn1;
	}
	
	/**
	 * Metodo set Btn1
	 * @param btn1 JButton Retirar
	 */

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	/**
	 * Metodo get Btn2
	 * @return JButton
	 */
	
	public JButton getBtn2() {
		return btn2;
	}

	/**
	 * Metodo set Btn2
	 * @param btn2 JButton Ver Movimientos
	 */
	
	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	/**
	 * Metodo get Btn3
	 * @return JButton
	 */
	
	public JButton getBtn3() {
		return btn3;
	}

	/**
	 * Metodo set Btn3
	 * @param btn3 JButton retirar
	 */
	
	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	/**
	 * Metodo get Btn4
	 * @return JButton
	 */
	
	public JButton getBtn4() {
		return btn4;
	}

	/**
	 * Metodo set Btn4
	 * @param btn4 JButton Salir
	 */
	
	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	/**
	 * Metodo get Btn5
	 * @return JButton
	 */
	
	public JButton getBtn5() {
		return btn5;
	}

	/**
	 * Metodo set Btn5
	 * @param btn5 JButton cambiar PIN
	 */
	
	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}

	/**
	 * Metodo gep de P
	 * @return JPanel
	 */
	
	public JPanel getP() {
		return p;
	}

	/**
	 * Metodo set de P
	 * @param p Panel
	 */
	
	public void setP(JPanel p) {
		this.p = p;
	}

	/**
	 * Metodo get de la Marca de Agua
	 * @return JPanel
	 */
	
	public JPanel getwMark() {
		return wMark;
	}

	/**
	 * Metodo set de la Marca de Agua
	 * @param wMark Panel Marca de Agua
	 */
	
	public void setwMark(JPanel wMark) {
		this.wMark = wMark;
	}

	/**
	 * Metodo get de Botonera
	 * @return ArrayList
	 */
	
	public ArrayList<JButton> getBotonera() {
		return botonera;
	}

	/**
	 * Metodo set de Botonera
	 * @param botonera ArrayList de Botones
	 */
	
	public void setBotonera(ArrayList<JButton> botonera) {
		this.botonera = botonera;
	}

	/**
	 * Metodo set del Numero de la Tarjeta
	 * @return String
	 */

	public String getNumTarjeta() {
		return numTarjeta;
	}

	/**
	 * Metodo set del Numero de la Tarjeta
	 * @param numTarjeta Numero de la Tarjeta
	 */
	
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	
	
}
