package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.DatosLoginUss;
import Vista.Vista;

public class GestorLogin implements ActionListener {

	private DatosLoginUss du;
	private Vista v;
	
	public GestorLogin(DatosLoginUss du, Vista v) {
		this.du = du;
		this.v = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		

	}

}
