package Controlador.Administrador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.Admin.PanelPrincipal;
import Vista.Admin.PrincipalAdm;
import Vista.Admin.Vistas.PanelAdministrar;
import Vista.Admin.Vistas.PanelTablaClientes;
import Vista.Admin.Vistas.PanelTablaCuentas;
import Vista.Admin.Vistas.PanelTablaTarjetas;
import Vista.Admin.Vistas.Administrar.AdministrarCliente;

public class GestorVentanasAdm implements ActionListener{

	private PrincipalAdm adm;
	private PanelPrincipal pp;
	private PanelTablaCuentas pcu;
	private PanelTablaClientes pcli;
	private PanelTablaTarjetas ptar;
	private PanelAdministrar padmi;
	private String tipo;
	
	public GestorVentanasAdm(PrincipalAdm adm, String tipo) {
		this.adm = adm;
		this.tipo = tipo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		adm.getContent().removeAll();;
		adm.repaint();
		if(tipo.equalsIgnoreCase("inicio")) {
			pp = new PanelPrincipal();
			adm.setSize(600,420);
			adm.getContent().add(pp);			
		}else if (tipo.equalsIgnoreCase("cuenta")) {
			pcu = new PanelTablaCuentas();
			adm.setSize(600,420);
			adm.getContent().add(pcu);
		}else if(tipo.equalsIgnoreCase("cliente")){
			pcli = new PanelTablaClientes();
			adm.setSize(600,420);
			adm.getContent().add(pcli);
		}else if(tipo.equalsIgnoreCase("tarjeta")) {
			ptar = new PanelTablaTarjetas();
			adm.setSize(600,420);
			adm.getContent().add(ptar);
		}else {
			padmi = new PanelAdministrar();
			adm.setSize(new Dimension(600,490));
			adm.getContent().add(padmi);
		}
		
	}

}