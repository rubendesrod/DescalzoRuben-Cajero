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

public class AdministrarCliente extends JPanel{

	private JButton crear;
	private JButton borrar;
	private JButton modificar;
	
	public AdministrarCliente() {
		
		this.setBorder(new TitledBorder("Cliente"));
		
		
		//Imagenes de los botones
		ImageIcon c = new ImageIcon("img/anadirCliente.png");
		ImageIcon cg = new ImageIcon("img/anadirClienteG.png");
		ImageIcon m = new ImageIcon("img/modificarCliente.png");
		ImageIcon mg = new ImageIcon("img/modificarClienteG.png");
		ImageIcon b = new ImageIcon("img/borrarCliente.png");
		ImageIcon bg = new ImageIcon("img/borrarClienteG.png");
		
		//Creacion de los botones y seteo de las imagenes
		crear = new JButton("Crear Cliente");
		borrar = new JButton("Borrar Cliente");
		modificar = new JButton("Modificar Cliente");
		crear.setIcon(c);
		borrar.setIcon(b);
		modificar.setIcon(m);
		
		//Modificacion de los botones
		crear.setVerticalAlignment(SwingConstants.CENTER);
		crear.setHorizontalTextPosition(SwingConstants.CENTER);
		crear.setVerticalTextPosition(SwingConstants.BOTTOM);				
		crear.setRolloverIcon(cg);
		crear.setFocusPainted(false);
		crear.setBorderPainted(false);
		crear.setContentAreaFilled(false);
		borrar.setVerticalAlignment(SwingConstants.CENTER);
		borrar.setHorizontalTextPosition(SwingConstants.CENTER);
		borrar.setVerticalTextPosition(SwingConstants.BOTTOM);				
		borrar.setRolloverIcon(bg);
		borrar.setFocusPainted(false);
		borrar.setBorderPainted(false);
		borrar.setContentAreaFilled(false);	
		modificar.setVerticalAlignment(SwingConstants.CENTER);
		modificar.setHorizontalTextPosition(SwingConstants.CENTER);
		modificar.setVerticalTextPosition(SwingConstants.BOTTOM);				
		modificar.setRolloverIcon(mg);
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
				FrameCrear fc = new FrameCrear("cliente");
				fc.setVisible(true);
		}});
		borrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBorrar fb = new FrameBorrar("cliente");
				fb.setVisible(true);
		}});
		modificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameModificar fm = new FrameModificar("cliente");
				fm.setVisible(true);
		}});
		
		//Anadir al panel los botones
		this.add(crear);this.add(borrar);this.add(modificar);
		this.setLocation(0, 0);
		this.setSize(600,140);
		this.setBackground(new Color(250,230,150));
		this.setOpaque(true);
	}

	public JButton getCrear() {
		return crear;
	}

	public void setCrear(JButton crear) {
		this.crear = crear;
	}

	public JButton getBorrar() {
		return borrar;
	}

	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
	}

	public JButton getModificar() {
		return modificar;
	}

	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}
	
	
	
}
