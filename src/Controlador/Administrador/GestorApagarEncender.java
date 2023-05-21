package Controlador.Administrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import Modelo.DAO.CajeroDAO;
import Modelo.DTO.CajeroDTO;

public class GestorApagarEncender implements ActionListener{

	private JLabel estado;
	private CajeroDTO cDTO;
	private CajeroDAO cDAO;
	
	public GestorApagarEncender(JLabel estado) {
		this.estado = estado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		cDTO = new CajeroDTO();
		cDAO = new CajeroDAO();
		if(estado.getText().equalsIgnoreCase("apagado")) {
			cDTO.setEstado("encendido");
			cDAO.modificarCajero(cDTO);
			estado.setText("encendido");
			estado.setForeground(Color.black);
		}else {
			cDTO.setEstado("apagado");
			cDAO.modificarCajero(cDTO);
			estado.setText("apagado");
			estado.setForeground(Color.red);
		}
		
		
		
	}
	
}
