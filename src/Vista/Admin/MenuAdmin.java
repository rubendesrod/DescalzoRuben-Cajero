package Vista.Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import Controlador.Administrador.GestorApagarEncender;
import Controlador.Administrador.GestorTablas;
import Vista.Vista;

public class MenuAdmin extends JMenuBar{

	private PrincipalAdm adm;
	private JPanel jp;
	
	public MenuAdmin(PrincipalAdm adm, JPanel jp) {
		
		this.adm = adm;
		this.jp = jp;
		
		//Principales
		JMenu ayu = new JMenu("Configuracion");
		JMenu conf = new JMenu("Administracion");
		//Secundarios
		JMenu cu = new JMenu("Cuentas");
		JMenu cli = new JMenu("Clientes");
		JMenu tar = new JMenu("Tarjeta");
		JMenu flech = new JMenu("--->");
		//MenuItem
		JMenuItem ay1 = new JMenuItem("Encender y Apagar");
		if (jp instanceof PanelPrincipal) {	
			ay1.addActionListener(new GestorApagarEncender(((PanelPrincipal) jp).getEstado()));
		}
		JMenuItem ay2 = new JMenuItem("Inicio");
		ay2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelPrincipal pp = new PanelPrincipal();
				adm.remove(adm.getJp());
				adm.repaint();
				adm.add(pp);
			}
		});
		JMenuItem ay3 = new JMenuItem("Salir");
		ay3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		ay3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adm.remove(adm.getMenu());
				adm.remove(adm.getJp());
				adm.dispose();
				Vista v = new Vista();
				v.setVisible(true);
				v.setLocationRelativeTo(adm);
				
			}
			
		});
		
		
		JMenuItem cu1 = new JMenuItem("Tabla");
		cu1.addActionListener(new GestorTablas(adm, "cuenta"));
		JMenuItem cu2 = new JMenuItem("Administrar");
		
		JMenuItem cli1 = new JMenuItem("Tabla");
		cli1.addActionListener(new GestorTablas(adm, "cliente"));
		JMenuItem cli2 = new JMenuItem("Administrar");
		
		JMenuItem tar1 = new JMenuItem("Tabla");
		tar1.addActionListener(new GestorTablas(adm, "tarjeta"));
		JMenuItem tar2 = new JMenuItem("Administrar");
		
		cu.add(cu1);cu.add(cu2);
		cli.add(cli1);cli.add(cli2);
		tar.add(tar1);tar.add(tar2);
		
		conf.add(cu);conf.add(cli);conf.add(tar);
		ayu.add(ay1);ayu.add(ay2);ayu.add(ay3);
		
		this.add(conf);this.add(ayu);
		
		
		
		
		
	}
	
}
