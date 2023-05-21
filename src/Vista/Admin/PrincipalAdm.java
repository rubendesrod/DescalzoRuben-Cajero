package Vista.Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

import Modelo.DAO.CajeroDAO;

public class PrincipalAdm extends JFrame{

	private JPanel jp;
	private JMenuBar menu;
	private JLabel estado;
	
	public PrincipalAdm() {
		super("Ventana Admin");
		
		Image icono = Toolkit.getDefaultToolkit().getImage("img/adm.png");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(600,450));
		this.pack();
		this.setResizable(false);
		this.setIconImage(icono);
		this.setLayout(null);
		
		jp = new JPanel();
		jp.setLocation(0, 30);
		jp.setSize(600,420);
		jp.setBackground(new Color(250,230,150));
		jp.setLayout(null);
		
		//Todo dentro del JPanel jp
		
			JLabel adm = new JLabel("Administrador");
			Font f = new Font("Montserrat", Font.BOLD, 24);
			adm.setForeground(Color.black);
			adm.setFont(f);
			adm.setLocation(210, 90);
			adm.setSize(200, 100);
			jp.add(adm);
			ImageIcon ad = new ImageIcon("img/adm.png");
			//Temporizador para cambiar entre texto e imagen
			Timer tempo = new Timer(2000, new ActionListener() {
				boolean txt = true;
				@Override
				public void actionPerformed(ActionEvent e) {
					if(txt) {
						adm.setIcon(null);
						adm.setText("Administrador");
						adm.setLocation(210, 90);
						txt = false;
					}else {
						adm.setText("");
						adm.setIcon(ad);
						adm.setLocation(260, 90);
						txt = true;
					}
				}	
			});
			
			JLabel txt = new JLabel("Estado del cajero:");
			txt.setForeground(Color.black);
			txt.setSize(105, 40);
			txt.setLocation(380, 5);
			jp.add(txt);
			
			
			CajeroDAO caDAO = new CajeroDAO();
			caDAO.buscarCajero();
			estado = new JLabel(caDAO.getcDTO().getEstado());
			estado.setSize(60,40);
			estado.setForeground(Color.black);
			if(estado.getText().equalsIgnoreCase("apagado")) {
				estado.setForeground(Color.red);
			}
			estado.setLocation(490, 5);
			jp.add(estado);
		
		menu = new MenuAdmin(this);
		menu.setLocation(0, 0);
		menu.setSize(600,30);
		tempo.start();
		this.add(menu);this.add(jp);
		
		
	}

	public JPanel getJp() {
		return jp;
	}

	public void setJp(JPanel jp) {
		this.jp = jp;
	}

	public JMenuBar getMenu() {
		return menu;
	}

	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}
	
	public JLabel getEstado() {
		return estado;
	}
	
	public void setEstado(JLabel estado) {
		this.estado = estado;
	}
	
	
}
