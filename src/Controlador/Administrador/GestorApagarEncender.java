package Controlador.Administrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Modelo.DAO.CajeroDAO;
import Modelo.DTO.CajeroDTO;

public class GestorApagarEncender implements ActionListener{

	private JLabel estado;
	private JButton power;
	private CajeroDTO cDTO;
	private CajeroDAO cDAO;
	private ImageIcon img;
	
	/**
	 * Constructor de la clase , la cual se encarga de cambiar el icono de color
	 * y el texto dependiendo de si el cajero esta apagado o encendido
	 * @author Ruben
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
