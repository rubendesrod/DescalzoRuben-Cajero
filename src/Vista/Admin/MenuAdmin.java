package Vista.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import Controlador.Administrador.GestorVentanasAdm;
import Vista.Vista;
import Vista.Admin.Vistas.PanelPrincipal;

/**
 * Clase que extiende de JMenuBar, muestra al administrador un menu
 * con las diferentes opciones que puede elegir 
 * 
 * @version 1.0
 * @author Ruben
 *
 */

@SuppressWarnings("serial")
public class MenuAdmin extends JMenuBar{

	/**
	 * Constructor de la clase MenuAdmin
	 * @param adm [Ventana principal de Administrador]
	 * @param p [Panel principal donde iran todos los demas paneles]
	 */
	
	public MenuAdmin(PrincipalAdm adm, PanelPrincipal p) {
		
		//Principales JMenu
		JMenu ayu = new JMenu("Configuracion");
		JMenu conf = new JMenu("Tablas");
		
		//MenuItem
		
		JMenuItem cu = new JMenuItem("Cuentas");
		JMenuItem cli = new JMenuItem("Clientes");
		JMenuItem tar = new JMenuItem("Tarjeta");
		
		JMenuItem admi = new JMenuItem("Administrar");
		admi.addActionListener(new GestorVentanasAdm(adm, "administrar"));
		JMenuItem ay2 = new JMenuItem("Inicio");
		ay2.addActionListener(new GestorVentanasAdm(adm, "inicio"));
		JMenuItem ay3 = new JMenuItem("Salir");
		ay3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		ay3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adm.dispose();
				Vista v = new Vista();
				v.setVisible(true);
				v.setLocationRelativeTo(adm);
			}
			
		});
		

		cu.addActionListener(new GestorVentanasAdm(adm, "cuenta"));
		cli.addActionListener(new GestorVentanasAdm(adm, "cliente"));
		tar.addActionListener(new GestorVentanasAdm(adm, "tarjeta"));
		
		conf.add(cu);conf.add(cli);conf.add(tar);
		ayu.add(ay2);ayu.add(admi);ayu.add(ay3);
		
		this.add(conf);this.add(ayu);
		
	}
	
}
