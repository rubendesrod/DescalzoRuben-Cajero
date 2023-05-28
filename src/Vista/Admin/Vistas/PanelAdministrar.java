package Vista.Admin.Vistas;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import Vista.Admin.Vistas.Administrar.AdministrarCliente;
import Vista.Admin.Vistas.Administrar.AdministrarCuenta;
import Vista.Admin.Vistas.Administrar.AdministrarTarjeta;

/**
 * Clase que extiende de JPanel, muestra 3 paneles al administrador
 * que contienes botones para que seleccione lo que quiere modificar
 * 
 * @version 1.0
 * @author Ruben
 */

@SuppressWarnings("serial")
public class PanelAdministrar extends JPanel{

	private AdministrarCliente acli;
	private AdministrarTarjeta at;
	private AdministrarCuenta acu;
	
	/**
	 * Constructor de la clase PanelAdministrar
	 */
	
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

	/**
	 * Metodo get acli
	 * @return AdministrarCliente
	 */
	
	public AdministrarCliente getAcli() {
		return acli;
	}
	
	/**
	 * Metodo set acli
	 * @param acli Panel Administrar Cliente
	 */

	public void setAcli(AdministrarCliente acli) {
		this.acli = acli;
	}

	/**
	 * Metodo get at
	 * @return AdministrarTarjeta
	 */
	
	public AdministrarTarjeta getAt() {
		return at;
	}

	/**
	 * Metodo set at
	 * @param at Panel Administrar Tarjeta
	 */
	
	public void setAt(AdministrarTarjeta at) {
		this.at = at;
	}

	/**
	 * Metodo get acu
	 * @return AdministrarCuenta
	 */
	
	public AdministrarCuenta getAcu() {
		return acu;
	}

	/**
	 * Metodo set acu
	 * @param acu Panel Administrar Cuenta
	 */
	
	public void setAcu(AdministrarCuenta acu) {
		this.acu = acu;
	}
	
	
	
}
