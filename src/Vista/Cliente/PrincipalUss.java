package Vista.Cliente;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class PrincipalUss extends JFrame{

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JPanel p;
	private Image imagenDeFondo;
	private ArrayList<JButton> botonera;
	
	public PrincipalUss() {
		super("Ventana Usuario");
		Image icono = Toolkit.getDefaultToolkit().getImage("img/cajero.png");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(600,450));
		this.pack();
		this.setResizable(false);
		this.setIconImage(icono);
		
		
//		imagenDeFondo = new ImageIcon("img/fondo.jpg").getImage();
//
//		// Configura el tamaño del panel para que coincida con el tamaño de la imagen de fondo
//	    Dimension dimension = new Dimension(imagenDeFondo.getWidth(null), imagenDeFondo.getHeight(null));
//	    setPreferredSize(dimension);
//
//	    // Agrega un panel personalizado que se utilizará como fondo
//	    setContentPane(new JPanel() {
//	    	@Override
//	    	protected void paintComponent(Graphics g) {
//	    		super.paintComponent(g);
//				g.drawImage(imagenDeFondo, 0, 0, null);
//	    	}
//	    });
		
		
		p = new JPanel(); p.setOpaque(false);
		p.setLayout(null);
		

		btn1 = new JButton("Retirar Dinero");
		btn2 = new JButton("Ingresar");
		btn3 = new JButton("Cambiar PIN");
		btn4 = new JButton("Movimientos y Saldo");
		btn5 = new JButton("Salir");
		
		// Aqui se aplica el estilo de los botones recorriendo un array donde estan guardados estos
		botonera = new ArrayList<JButton>();
		botonera.add(btn1);botonera.add(btn2);botonera.add(btn3);botonera.add(btn4);botonera.add(btn5);
		for(int i = 0; i<botonera.size();i++) {
			botonera.get(i).setForeground(Color.white);
			botonera.get(i).setBorder(new MatteBorder(1, 1, 1, 1, new Color(200,185,61)));
			botonera.get(i).setBackground(Color.black);
		}
		
		// Localizacion de los botones en la ventana
		
		btn1.setLocation(120, 30);
		btn1.setSize(100,20);
		
		btn2.setLocation(70, 70);
		btn2.setSize(80,20);
		
		btn1.addActionListener(null);
		btn2.addActionListener(null);
		btn3.addActionListener(null);
		btn4.addActionListener(null);
		btn5.addActionListener(null);
		
		p.add(btn1);p.add(btn4);
		p.add(btn2);p.add(btn5);
		p.add(btn3);
		this.add(p);
		
	}
	
}
