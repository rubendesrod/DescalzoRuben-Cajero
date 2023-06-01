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
/**
 * Clase que extiende de JFrame, es la clase principal del programa
 * es la que contiene el metodo main
 * 
 * @version 1.0
 * @author Ruben
 */

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
	
	/**
	 * Constructor de la clase
	 */
	
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
	
	/**
	 * Metodo main que inicia el programa
	 * @param args Argumentos
	 */
	
	public static void main(String[] args) {
		Vista v = new Vista();
		v.setVisible(true);
	}

	/**
	 * Metodo get del panel de la Marca de Agua
	 * @return JPanel
	 */
	
	public JPanel getwMark() {
		return wMark;
	}

	/**
	 * Metodo set del panel de la Marca de Agua
	 * @param wMark Panel de la Marca de Agua
	 */
	
	public void setwMark(JPanel wMark) {
		this.wMark = wMark;
	}

	/**
	 * Metodo get de las ventanas
	 * @return true, si se hace clic en un boton o  false, si se vuelve ha hacer clic en el boton
	 */
	
	public boolean getVentanas() {
		return ventanas;
	}

	/**
	 * Metodo set Ventanas
	 * @param ventanas ayuda para mostrar un panel u otro
	 */
	
	public void setVentanas(boolean ventanas) {
		this.ventanas = ventanas;
	}

	/**
	 * Metodo get del Panel DatosLoginUss
	 * @return DatosLoginUss
	 */
	
	public DatosLoginUss getDl() {
		return dl;
	}

	/**
	 * Metodo set de DatosLoginUss
	 * @param dl Panel de los Datos del usuario
	 */
	
	public void setDl(DatosLoginUss dl) {
		this.dl = dl;
	}
	
	/**
	 * Metodo get del Panel DatosLoginAdm
	 * @return DatosLoginAdm
	 */

	public DatosLoginAdm getDa() {
		return da;
	}

	/**
	 * Metofo set de DatosLoginAdm
	 * @param da Panel de datos del administrador
	 */
	
	public void setDa(DatosLoginAdm da) {
		this.da = da;
	}

	/**
	 * Metodo get de Opcion Admin
	 * @return JButton 
	 */
	
	public JButton getAdmOption() {
		return admOption;
	}

	/**
	 * Metodo set de la Opcion Admin
	 * @param admOption Boton para entrar al Panel del Admin
	 */
	
	public void setAdmOption(JButton admOption) {
		this.admOption = admOption;
	}

	/**
	 * Metodo get de imagen .png
	 * @return JLabel 
	 */
	
	public JLabel getPng() {
		return png;
	}

	/**
	 * Metodo set de imagen .png
	 * @param png Imagen del Cajero
	 */
	
	public void setPng(JLabel png) {
		this.png = png;
	}

	/**
	 * Metodo get del texto
	 * @return JLabel
	 */
	
	public JLabel getTxt() {
		return txt;
	}

	/**
	 * Metodo set del texto
	 * @param txt texto del panel
	 */
	
	public void setTxt(JLabel txt) {
		this.txt = txt;
	}
	
	
	
}
