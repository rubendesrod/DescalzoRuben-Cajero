package Vista.Admin.Vistas.Administrar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameModificar extends JFrame{

	private String objeto;
	private JLabel errores;
	private JLabel txt;
	private JTextField pk;
	private JButton buscar, modificar;
	private JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8;
	private JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8;
	
	public FrameModificar(String objeto) {
		
		this.objeto = objeto;
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.pack();
		this.setSize(new Dimension(400,250));
		this.setResizable(false);
		errores = new JLabel("");
		errores.setForeground(Color.red);
		buscar = new JButton("buscar");
		modificar = new JButton("modificar");
		
		if(objeto.equalsIgnoreCase("cliente")) {
			
			
		}else if(objeto.equalsIgnoreCase("tarjeta")) {
			
			
		}else if (objeto.equalsIgnoreCase("cuenta")) {
			
			
		}
	}
	
	
	
}
