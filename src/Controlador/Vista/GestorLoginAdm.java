package Controlador.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vista.Vista;

public class GestorLoginAdm implements ActionListener {

	private Vista admin;
	
	public GestorLoginAdm(Vista v) {
		this.admin = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(admin.getAdmOption().getText().equalsIgnoreCase("login")) {
			admin.getAdmOption().setText("admin");
		}else {
			admin.getAdmOption().setText("login");
		}
	}

}
