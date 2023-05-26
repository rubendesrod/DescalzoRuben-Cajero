package Controlador.Cliente;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Validador;
import Modelo.DAO.TarjetaDAO;
import Modelo.DTO.TarjetaDTO;
import Vista.Cliente.CambiarPin;

public class GestorCambiarPin implements ActionListener{

	private CambiarPin cp;
	private TarjetaDAO tDAO;
	private TarjetaDTO tDTO;
	private String numTarjeta;
	private Validador v;
	
	/**
	 * Constructor de la clase GestorCambiarPin, la cual se encargar de recibir datos
	 * ,verificar y setear el nuevo PIN con una llamada a la base de datos
	 * 
	 * @author Ruben
	 * @param cp [Panel desde el cual se insertan los datos]
	 * @param num [Numero de la Tarjeta con la que trabaja el cliente]
	 */
	
	public GestorCambiarPin(CambiarPin cp, String num) {
		this.cp = cp;
		this.numTarjeta = num;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tDTO = new TarjetaDTO();
		tDTO.setNumTarjeta(numTarjeta);
		tDAO = new TarjetaDAO();
		tDAO.buscarTarjeta(tDTO);
		v = new Validador();
		String nuevo =  String.valueOf(cp.getNuevoPin().getPassword());
		if (v.validarPin(cp.getActualPin().getText()) && v.validarPin(String.valueOf(cp.getActualPin().getText()))) {
			if (cp.getActualPin().getText().isEmpty()) {
				cp.getErrores().setForeground(Color.red);
				cp.getErrores().setText("** Ambos campos son obligatorios");
			}else if(nuevo.isEmpty()) {
				cp.getErrores().setForeground(Color.red);
				cp.getErrores().setText("** Ambos campos son obligatorios");
			}else {
				if (tDAO.gettDTO().getPin() == Integer.parseInt(cp.getActualPin().getText())) {
					String nuevoPin = String.valueOf(cp.getNuevoPin().getPassword());
					tDTO.setPin(Integer.parseInt(nuevoPin));
					tDAO.modificarTarjeta(tDTO);
					cp.getErrores().setForeground(Color.BLUE);
					cp.getErrores().setText("** PIN ha sido actualizado");
				} else {
					cp.getErrores().setForeground(Color.red);
					cp.getErrores().setText("** El PIN actual no coincide");
				} 
			}
		}else {
			cp.getErrores().setForeground(Color.red);
			cp.getErrores().setText(v.getMsg());
		}
		
	}

}
