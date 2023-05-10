package Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controlador.Vista.GestorLoginAdm;

public class Vista extends JFrame{


	 private DatosLoginUss dl; 
	 private DatosLoginAdm da;
	 private JButton admOption;
	 private JLabel png;
	 private JLabel txt;
	
	public Vista() {
		super("Cajero Automatico");
		Image icono = Toolkit.getDefaultToolkit().getImage("img/cajero.png");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 	Panel derecho del Login	
			JPanel wMark = new JPanel();
			wMark.setBackground(new Color(251,224,112));
			wMark.setPreferredSize(new Dimension(200,50));
			wMark.setLayout(null);
			
			png = new JLabel();
			png.setIcon(new ImageIcon("img/cajero.png"));
			txt = new JLabel("Cajero - IES Galileo");
			Font negrita = new Font("Arial", Font.BOLD, 14);
			txt.setFont(negrita);txt.setForeground(Color.BLACK);
			admOption = new JButton("login");
			admOption.setFocusPainted(false);
			admOption.setBorderPainted(false);
			admOption.setContentAreaFilled(false);	
			admOption.setForeground(new Color(251,224,112));
			
			png.setSize(200,200);
			png.setLocation(0,60);
			txt.setSize(200,200);
			txt.setLocation(35,180);
			admOption.setSize(50,10);
			admOption.setLocation(43,173);
			
			wMark.add(png);wMark.add(txt);wMark.add(admOption);
			
			dl = new DatosLoginUss(this);
			admOption.addActionListener(new GestorLoginAdm(this));
			
	//	Continua el JFrame
		this.add(wMark, BorderLayout.EAST);
		this.add(dl, BorderLayout.WEST);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(600,450));
		this.pack();
		this.setResizable(false);
		this.setIconImage(icono);
	}
	
	public static void main(String[] args) {
		Vista v = new Vista();
		v.setVisible(true);
	}

	public DatosLoginUss getDl() {
		return dl;
	}

	public void setDl(DatosLoginUss dl) {
		this.dl = dl;
	}

	public DatosLoginAdm getDa() {
		return da;
	}

	public void setDa(DatosLoginAdm da) {
		this.da = da;
	}

	public JButton getAdmOption() {
		return admOption;
	}

	public void setAdmOption(JButton admOption) {
		this.admOption = admOption;
	}

	public JLabel getPng() {
		return png;
	}

	public void setPng(JLabel png) {
		this.png = png;
	}

	public JLabel getTxt() {
		return txt;
	}

	public void setTxt(JLabel txt) {
		this.txt = txt;
	}
	
	
	
}
