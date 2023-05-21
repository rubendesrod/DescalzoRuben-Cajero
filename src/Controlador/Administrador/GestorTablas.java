package Controlador.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Admin.PrincipalAdm;
import Vista.Admin.Vistas.PanelTablaCuentas;

public class GestorTablas implements ActionListener{

	private PrincipalAdm adm;
	private String tipo;
	
	public GestorTablas(PrincipalAdm adm, String tipo) {
		this.adm = adm;
		this.tipo = tipo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(tipo.equalsIgnoreCase("cuenta")) {
			// La tabla de las cuentas
			PanelTablaCuentas pt = new PanelTablaCuentas();
			adm.remove(adm.getJp());
			adm.repaint();
			adm.add(pt);
			
			
		}else if (tipo.equalsIgnoreCase("cliente")) {
			
			//La tabla de los clientes
			
		}else {
			
			// La tabla de las tarjetas
			
		}
		
	}

}
