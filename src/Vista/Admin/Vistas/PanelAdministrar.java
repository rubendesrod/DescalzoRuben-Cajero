package Vista.Admin.Vistas;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import Vista.Admin.Vistas.Administrar.AdministrarCliente;
import Vista.Admin.Vistas.Administrar.AdministrarCuenta;
import Vista.Admin.Vistas.Administrar.AdministrarTarjeta;

public class PanelAdministrar extends JPanel{

	private AdministrarCliente acli;
	private AdministrarTarjeta at;
	private AdministrarCuenta acu;
	
	public PanelAdministrar() {
		
		this.setLayout(new GridLayout(3,1));
		this.setLocation(0, 0);
		this.setSize(600,420);
		
		acli = new AdministrarCliente();
		at = new AdministrarTarjeta();
		acu = new AdministrarCuenta();
		
		this.setBackground(new Color(242,250,150));
		this.add(acli);this.add(acu);this.add(at);
	}
	
	
}
