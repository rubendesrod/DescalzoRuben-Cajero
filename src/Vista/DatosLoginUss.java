package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controlador.Vista.GestorLogin;

/**
 * Clase que extiende de JPanel, donde el usuario pondrá sus datos
 * 
 * @version 1.0
 * @author Ruben
 *
 */

public class DatosLoginUss extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton login; //
	private JButton ver ;
	private JLabel usuario; //
	private JLabel contra; //
	private JTextField uss;
	private JPasswordField passO;
	private JTextField passV;
	private JLabel error;
	private Boolean mostrar;
	
	/**
	 * Constructor de la clase DatosLoginUss
	 * @param v [Frame principal]
	 */
	
	public DatosLoginUss(Vista v) {
		
		setLayout(null);
	    
		usuario = new JLabel("Numero de Tarjeta:");
		contra = new JLabel("PIN: ");
		login = new JButton("Acceder");
		
		if (v.getAdmOption().getText().equalsIgnoreCase("admin")) {
			usuario = new JLabel("Usuario Admin:");
			contra = new JLabel("Contraseña: ");
			login = new JButton("Acceder");
		}
		
		
		mostrar = true;
		ver = new JButton();
		ImageIcon oculto = new ImageIcon("img/oculto.png");
		ImageIcon visible = new ImageIcon("img/visible.png");
		
		error = new JLabel(" ");
		error.setForeground(Color.red);
		
		uss = new JTextField();
		passO = new JPasswordField();
		passV = new JTextField();
		passV.setVisible(false);
		ver.setIcon(visible);
		
		//Booleano para mostrar o no la contrasena
		
		this.setPreferredSize(new Dimension(350,300));
		
		usuario.setSize(140,30);
		usuario.setLocation(35,100);
		
		contra.setSize(140,30);
		contra.setLocation(120, 140);
		
		error.setSize(370,30);
		error.setLocation(80,60);
		
		uss.setSize(new Dimension(150, 30));
		uss.setLocation(160,100);
		
		passO.setSize(new Dimension(150, 30));
		passO.setLocation(160,140);
		
		passV.setSize(new Dimension(150, 30));
		passV.setLocation(160,140);
		
		login.setSize(100, 30);
		login.setLocation(180,200);		
		
		ver.setSize(25,25);
		ver.setLocation(315,142);
		ver.setFocusPainted(false);
		ver.setBorderPainted(false);
		ver.setContentAreaFilled(false);		
		
		login.addActionListener(new GestorLogin(this, v));
		
		//Cuando el usuario quiera ver la contrasena
		ver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(mostrar) {
					passV.setVisible(true);
					passO.setVisible(false);
					mostrar=false;
					passV.setText(String.valueOf(passO.getPassword()));
					passO.setText("");
					ver.setIcon(oculto);
				}else {
					passO.setVisible(true);
					passV.setVisible(false);
					mostrar=true;
					passO.setText(passV.getText());
					passV.setText("");
					ver.setIcon(visible);
				}	
			}
		});
		
		this.add(login);
		this.add(usuario);
		this.add(contra);
		this.add(error);
		this.add(uss);
		this.add(passO);
		this.add(passV);
		this.add(ver);
	}
	
		/**
		 * Metodo get del boton login
		 * @return JButton
		 */
		
		public JButton getLogin() {
			return login;
		}
		
		/**
		 * Metodo set de Login
		 * @param login Boton de login
		 */

		public void setLogin(JButton login) {
			this.login = login;
		}

		/**
		 * Metodo get del usuario
		 * @return JLabel
		 */
		
		public JLabel getUsuario() {
			return usuario;
		}

		/**
		 * Metodo set del texto usuario
		 * @param usuario Texto que indica donde poner la Tarjeta
		 */
		
		public void setUsuario(JLabel usuario) {
			this.usuario = usuario;
		}

		/**
		 * Metodo get del texto contraseña
		 * @return JLabel
		 */
		
		public JLabel getContra() {
			return contra;
		}

		/**
		 * Metodo set del Texto Contra
		 * @param contra Texto que indica donde poner el PIN
		 */
		
		public void setContra(JLabel contra) {
			this.contra = contra;
		}

		/**
		 * Metodo get del nombre de usuario
		 * @return JTextField
		 */
		
		public JTextField getUss() {
			return uss;
		}
		
		/**
		 * Metodo set del nombre de usuario
		 * @param uss Campo donde se pone el Numero de Tarjeta
		 */

		public void setUss(JTextField uss) {
			this.uss = uss;
		}

		/**
		 * Metodo get de la contraseña oculta
		 * @return JPasswordField
		 */
		
		public JPasswordField getPassO() {
			return passO;
		}
		
		/**
		 * Metodo set de la contraseña oculta
		 * @param passO Campo donde se pone el PIN y no es visible
		 */

		public void setPassO(JPasswordField passO) {
			this.passO = passO;
		}

		/**
		 * Metodo get de la contraña visible
		 * @return JTextField
		 */
		
		public JTextField getPassV() {
			return passV;
		}

		/**
		 * Metodo set de la contraseña visible
		 * @param passV Campo donde se pone el PIN y es visible
		 */
		
		public void setPassV(JTextField passV) {
			this.passV = passV;
		}

		/**
		 * Metodo get del texto Errores
		 * @return JLabel 
		 */
		
		public JLabel getError() {
			return error;
		}

		/**
		 * Metodo set del texto Errores
		 * @param error Texto donde aparecer los errores del intento de login
		 */
		
		public void setError(JLabel error) {
			this.error = error;
		}
	
	
	
}
