package Controlador.Administrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Modelo.DAO.CajeroDAO;
import Modelo.DTO.CajeroDTO;

/**
 * Clase que implementa el ActionListener y se encarga de encender y apagar el cajero
 * 
 * @version 1.0
 * @author Ruben
 *
 */

public class GestorApagarEncender implements ActionListener{

	private JLabel estado;
	private JButton power;
	private CajeroDTO cDTO;
	private CajeroDAO cDAO;
	private ImageIcon img;
	
	/**
	 * Constructor de la clase 
	 *
	 * @param estado [Texto que indica si esta encendido o apagado el cajero]
	 * @param power [Boton de encendido y apagado]
	 */
	
	public GestorApagarEncender(JLabel estado, JButton power) {
		this.estado = estado;
		this.power = power;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		cDTO = new CajeroDTO();
		cDAO = new CajeroDAO();
		if(estado.getText().equalsIgnoreCase("apagado")) {
			img = new ImageIcon("img/powerR.png");
			cDTO.setEstado("encendido");
			cDAO.modificarCajero(cDTO);
			estado.setText("encendido");
			power.setIcon(img);
			estado.setForeground(Color.black);
		}else {
			img = new ImageIcon("img/powerV.png");
			cDTO.setEstado("apagado");
			cDAO.modificarCajero(cDTO);
			estado.setText("apagado");
			estado.setForeground(Color.red);
			power.setIcon(img);
		}
		
		
		
	}
	
}
