package Vista.Admin.Vistas.Administrar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 * Clase que extiende de JPanel, contiene lo que se puede admnistrar de las Cuentas
 * como crear, borrar, y modificar
 * 
 * @version 1.0
 * @author Ruben
 */

public class AdministrarCuenta extends JPanel{

	private JButton crear;
	private JButton borrar;
	private JButton modificar;
	
	/**
	 * Constructor de la clase AdministrarCuenta
	 */
	
	public AdministrarCuenta() {
		
		this.setBorder(new TitledBorder("Cuenta"));
		this.setOpaque(true);
		
		//Imagenes de los botones
		ImageIcon c = new ImageIcon("img/anadirCuenta.png");
		ImageIcon cg = new ImageIcon("img/anadirCuentaG.png");
		ImageIcon m = new ImageIcon("img/modificarCuenta.png");
		ImageIcon mg = new ImageIcon("img/modificarCuentaG.png");
		ImageIcon b = new ImageIcon("img/borrarCuenta.png");
		ImageIcon bg = new ImageIcon("img/borrarCuentaG.png");
		
		
		//Creacion de los botones y seteo de las imagenes
		crear = new JButton("Crear Cuenta");
		borrar = new JButton("Borrar Cuenta");
		modificar = new JButton("Modificar Cuenta");
		crear.setIcon(c);
		borrar.setIcon(b);
		modificar.setIcon(m);
		
		
		//Modificacion de los botones
		crear.setVerticalAlignment(SwingConstants.CENTER);
		crear.setHorizontalTextPosition(SwingConstants.CENTER);
		crear.setVerticalTextPosition(SwingConstants.BOTTOM);				
		crear.setRolloverIcon(cg);
		borrar.setVerticalAlignment(SwingConstants.CENTER);
		borrar.setHorizontalTextPosition(SwingConstants.CENTER);
		borrar.setVerticalTextPosition(SwingConstants.BOTTOM);				
		borrar.setRolloverIcon(bg);
		modificar.setVerticalAlignment(SwingConstants.CENTER);
		modificar.setHorizontalTextPosition(SwingConstants.CENTER);
		modificar.setVerticalTextPosition(SwingConstants.BOTTOM);				
		modificar.setRolloverIcon(mg);
		crear.setFocusPainted(false);
		crear.setBorderPainted(false);
		crear.setContentAreaFilled(false);
		borrar.setFocusPainted(false);
		borrar.setBorderPainted(false);
		borrar.setContentAreaFilled(false);	
		modificar.setFocusPainted(false);
		modificar.setBorderPainted(false);
		modificar.setContentAreaFilled(false);	
		
		
		//Posiciones de los botones y size
		crear.setLocation(100, 30);
		crear.setSize(new Dimension(130,90));
		borrar.setLocation(260, 30);
		borrar.setSize(new Dimension(130,90));
		modificar.setLocation(420, 30);
		modificar.setSize(new Dimension(130,90));
		
		
		//Añadir actiopnListener a cada boton
		crear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameCrear fc = new FrameCrear("cuenta");
				fc.setVisible(true);
		}});
		borrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBorrar fb = new FrameBorrar("cuenta");
				fb.setVisible(true);
		}});
		modificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameModificar fm = new FrameModificar("cuenta");
				fm.setVisible(true);
		}});
		
		
		//Anadir al panel los botones
		this.add(crear);this.add(borrar);this.add(modificar);
		this.setLocation(0, 140);
		this.setBackground(new Color(250,230,150));
		this.setSize(600,140);
	}
	
}
