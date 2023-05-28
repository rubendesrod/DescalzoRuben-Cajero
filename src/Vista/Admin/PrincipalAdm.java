package Vista.Admin;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import Vista.Admin.Vistas.PanelPrincipal;

/**
 * Clase principal del Administrador extiende de JFrame, es la que muestra
 * constantemente el menu por el que se mueve el administrador y todos los paneles
 * que haya
 * 
 * @version 1.0
 * @author Ruben
 *
 */

@SuppressWarnings("serial")
public class PrincipalAdm extends JFrame{

	private JMenuBar menu;
	private JPanel content;
	
	/**
	 * Constructor de la clase PrincipalAdm
	 */
	
	public PrincipalAdm() {
		super("Ventana Admin");
		
		Image icono = Toolkit.getDefaultToolkit().getImage("img/adm.png");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setPreferredSize(new Dimension(600,450));
		this.pack();
		this.setResizable(false);
		this.setIconImage(icono);
		this.setLayout(null);
		
		content = new JPanel();
		content.setLocation(0, 30);
		content.setSize(600,420);
		content.setLayout(null);
		
		PanelPrincipal p = new PanelPrincipal();
		content.add(p);
		
		menu = new MenuAdmin(this, p);
		menu.setLocation(0, 0);
		menu.setSize(600,30);
		
		this.add(menu);
		this.add(content);
		
	}

	/**
	 * Metodo get content
	 * @return JPanel
	 */
	
	public JPanel getContent() {
		return content;
	}
	
	/**
	 * Metodo set content
	 * @param content Panel que va a Contener Muchos mas
	 */
	
	public void setContent(JPanel content) {
		this.content = content;
	}
	
	/**
	 * Metodo get menu
	 * @return JMenuBar
	 */
	
	public JMenuBar getMenu() {
		return menu;
	}
	
	/**
	 * Metodo set menu
	 * @param menu Menu del Administrador
	 */

	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}
	
	
}
