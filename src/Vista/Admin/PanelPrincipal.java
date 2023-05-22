package Vista.Admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controlador.Administrador.GestorApagarEncender;
import Modelo.DAO.CajeroDAO;

public class PanelPrincipal extends JPanel{

	private JLabel estado;
	private PrincipalAdm adm;
	
	public PanelPrincipal() {
		this.setLocation(0, 0);
		this.setSize(600,420);
		this.setBackground(new Color(250,230,150));
		this.setLayout(null);
		
		
		JLabel adm = new JLabel("Administrador");
		Font f = new Font("Montserrat", Font.BOLD, 24);
		adm.setForeground(Color.black);
		adm.setFont(f);
		adm.setLocation(210, 90);
		adm.setSize(200, 100);
		this.add(adm);
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
		this.add(txt);
			
			
		CajeroDAO caDAO = new CajeroDAO();
		caDAO.buscarCajero();
		estado = new JLabel(caDAO.getcDTO().getEstado());
		estado.setSize(60,40);
		estado.setForeground(Color.black);
		estado.setLocation(490, 5);
		tempo.start();
		
		
		JButton power = new JButton();
		power.setBorderPainted(false);
		power.setContentAreaFilled(false);
		power.setSize(30, 30);
		power.setLocation(330, 10);
		if(estado.getText().equalsIgnoreCase("apagado")) {
			estado.setForeground(Color.red);
			ImageIcon on = new ImageIcon("img/powerV.png");
			power.setIcon(on);
		}else {
			ImageIcon on = new ImageIcon("img/powerR.png");
			power.setIcon(on);
		}
		
		power.addActionListener(new GestorApagarEncender(estado,power));
		this.add(estado);this.add(power);
	}

	public JLabel getEstado() {
		return estado;
	}

	public void setEstado(JLabel estado) {
		this.estado = estado;
	}

	public PrincipalAdm getAdm() {
		return adm;
	}

	public void setAdm(PrincipalAdm adm) {
		this.adm = adm;
	}
	
	
	
}
