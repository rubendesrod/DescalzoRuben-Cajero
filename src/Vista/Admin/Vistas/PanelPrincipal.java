package Vista.Admin.Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controlador.Administrador.GestorApagarEncender;
import Modelo.DAO.CajeroDAO;
import Vista.Admin.PrincipalAdm;

/**
 * Panel principal del Administrador extiende de JPanel, es el primer panel que se muestraç
 * el cual muestra el estado del cajero y se puede apagar o encender el cajero (es mas que esta en mantenimiento)
 * 
 * @version 1.0
 * @author Ruben
 *
 */

@SuppressWarnings("serial")
public class PanelPrincipal extends JPanel{

	private JLabel estado;
	private PrincipalAdm adm;
	
	/**
	 * Constructor de la clase PanelPrincipal
	 */
	
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

	/**
	 * Metodo get del estado
	 * @return JLabel
	 */
	
	public JLabel getEstado() {
		return estado;
	}

	/**
	 * Metodo set del estado
	 * @param estado Estado del Cajero
	 */
	
	public void setEstado(JLabel estado) {
		this.estado = estado;
	}
	
	/**
	 * Metodo get de adm
	 * @return PrincipalAdm
	 */

	public PrincipalAdm getAdm() {
		return adm;
	}

	/**
	 * Metodo set de adm
	 * @param adm Panel Principal de Adm
	 */
	
	public void setAdm(PrincipalAdm adm) {
		this.adm = adm;
	}
	
	
	
}
