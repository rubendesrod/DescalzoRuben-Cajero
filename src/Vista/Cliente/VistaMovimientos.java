package Vista.Cliente;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Modelo.Tabla.TablaMovimientos;

public class VistaMovimientos extends JPanel{

	private PrincipalUss usr;
	private String numTarjeta;
	
	public VistaMovimientos(PrincipalUss usr, String numTarjeta){
		
		this.usr = usr;
		this.numTarjeta = numTarjeta;
		
		TablaMovimientos tablaM = new TablaMovimientos();
		JTable tabla =new JTable(tablaM);
		JScrollPane s = new JScrollPane();
		s.setViewportView(tabla);
		s.setColumnHeaderView(tabla.getTableHeader());
		s.setBounds(50,50,80,80);
		
		usr.getP().setVisible(false);
		usr.remove(usr.getP());
		usr.repaint();
		usr.add(this);
		
	}
	
}
