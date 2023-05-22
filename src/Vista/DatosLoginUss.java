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
	public Boolean mostrar = true;
	
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

//	@SuppressWarnings("unused")
//	private void ussKeyTyped(java.awt.event.KeyEvent evt) {
//		int key = evt.getKeyChar();
//		
//		boolean numero = key >= 48 && key <= 57;
//		
//		if(!numero) {
//			evt.consume();
//		}
//	}
	
	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JLabel getUsuario() {
		return usuario;
	}

	public void setUsuario(JLabel usuario) {
		this.usuario = usuario;
	}

	public JLabel getContra() {
		return contra;
	}

	public void setContra(JLabel contra) {
		this.contra = contra;
	}

	public JTextField getUss() {
		return uss;
	}

	public void setUss(JTextField uss) {
		this.uss = uss;
	}

	public JPasswordField getPassO() {
		return passO;
	}

	public void setPassO(JPasswordField passO) {
		this.passO = passO;
	}

	public JTextField getPassV() {
		return passV;
	}

	public void setPassV(JTextField passV) {
		this.passV = passV;
	}

	public JLabel getError() {
		return error;
	}

	public void setError(JLabel error) {
		this.error = error;
	}
	
	
	
}
