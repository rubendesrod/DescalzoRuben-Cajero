package Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modelo.DAO.CajeroDAO;
import Vista.Admin.PrincipalAdm;
import Vista.Cliente.PrincipalUss;

public class Vista extends JFrame{

	private static final long serialVersionUID = 1L;
	private DatosLoginUss dl; 
	private DatosLoginAdm da;
	private cajeroApagado capa;
	private JButton admOption;
	private JLabel png;
	private JLabel txt;
	private JPanel wMark;
	private CajeroDAO cDAO;
	private boolean ventanas = true; //intercambio de ventanas
	
	public Vista() {
		super("Cajero Automatico");
		Image icono = Toolkit.getDefaultToolkit().getImage("img/cajero.png");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		wMark = new JPanel();
		wMark.setBackground(new Color(251, 224, 112));
		wMark.setPreferredSize(new Dimension(200, 50));
		wMark.setLayout(null);

		png = new JLabel();
		png.setIcon(new ImageIcon("img/cajero.png"));
		txt = new JLabel("Cajero - GALI");
		Font negrita = new Font("Arial", Font.BOLD, 14);
		txt.setFont(negrita);
		txt.setForeground(Color.BLACK);
		admOption = new JButton("login");
		admOption.setFocusPainted(false);
		admOption.setBorderPainted(false);
		admOption.setContentAreaFilled(false);
		admOption.setForeground(new Color(251, 224, 112));
		png.setSize(200, 200);
		png.setLocation(0, 60);
		txt.setSize(200, 200);
		txt.setLocation(35, 180);
		admOption.setSize(50, 50);
		admOption.setLocation(43, 173);

		wMark.add(png);
		wMark.add(txt);
		wMark.add(admOption);
		
		cDAO = new CajeroDAO();
		cDAO.buscarCajero();
		if (cDAO.getcDTO().getEstado().equalsIgnoreCase("encendido")) {
			dl = new DatosLoginUss(this);
			da = new DatosLoginAdm(this);
			da.setVisible(false);
			// cuando toque el boton invisble cambia a la otra pantalla
			this.add(dl, BorderLayout.WEST);
			admOption.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					if (ventanas) {
						dl.setVisible(false);
						dl.getUss().setText("");
						dl.getPassO().setText("");
						dl.getPassV().setText("");
						da.setVisible(true);
						add(da);
						ventanas = false;
					} else {
						dl.setVisible(true);
						da.setVisible(false);
						da.getUss().setText("");
						da.getPassO().setText("");
						da.getPassV().setText("");
						add(dl);
						ventanas = true;
					}
				}
			});
		}else {
			capa = new cajeroApagado();
			da = new DatosLoginAdm(this);
			da.setVisible(false);
			this.add(capa, BorderLayout.EAST);
			admOption.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					if (ventanas) {
						capa.setVisible(false);
						da.setVisible(true);
						add(da);
						ventanas = false;
					} else {
						capa.setVisible(true);
						da.setVisible(false);
						da.getUss().setText("");
						da.getPassO().setText("");
						da.getPassV().setText("");
						add(capa);
						ventanas = true;
					}
				}
			});
		}
		
		
		
	//	Continua el JFrame
		this.add(wMark, BorderLayout.EAST);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(600,450));
		this.pack();
		this.setResizable(false);
		this.setIconImage(icono);
	}
	
	public static void main(String[] args) {
		Vista v = new Vista();
		v.setVisible(false);
		PrincipalUss p = new PrincipalUss("1111222233334444");
		p.setVisible(false);
		PrincipalAdm a = new PrincipalAdm();
		a.setVisible(true);
	}

	
	
	public JPanel getwMark() {
		return wMark;
	}

	public void setwMark(JPanel wMark) {
		this.wMark = wMark;
	}

	public boolean isVentanas() {
		return ventanas;
	}

	public void setVentanas(boolean ventanas) {
		this.ventanas = ventanas;
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
