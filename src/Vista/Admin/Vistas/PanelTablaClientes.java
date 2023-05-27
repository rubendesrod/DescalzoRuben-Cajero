package Vista.Admin.Vistas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import Modelo.DAO.ClientesDAO;
import Modelo.DTO.ClienteDTO;
import Modelo.Tabla.TablaClientes;

/**
 * Clase que extiende de JPanel, contiene el Modelo de la Tabla Clientes
 * y la muestra en el panel
 * 
 * @version 1.0
 * @author Ruben
 */

public class PanelTablaClientes extends JPanel{

	private ClienteDTO cDTO;
	private ClientesDAO cDAO;
	
	/**
	 * Constructor de la Clase PanelTablaTarjetas
	 */
	
	public PanelTablaClientes() {
		cDTO = new ClienteDTO();
		cDTO.setDni(null);
		cDAO = new ClientesDAO();
		cDAO.buscarCliente(cDTO);
		
		TablaClientes tablac = new TablaClientes();
		JTable tabla =new JTable(tablac);
		JScrollPane s = new JScrollPane();
		s.setViewportView(tabla);
		s.setColumnHeaderView(tabla.getTableHeader());
		s.setBounds(20,140,540,200);
		
		//Formato a las columnas de la tabla
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        
        int columnas = tabla.getColumnCount();
        for(int i = 0; i<columnas;i++) {
        	tabla.getColumnModel().getColumn(i).setCellRenderer(centro);
        }
		
		// Primero borramos la tabla para que refresque si hay nuevos datos
		int row = tablac.getRowCount();
		while(row>0) {
			row--;
			tablac.borrarCliente(row);
		}
		
		//Ahora anyadimos los datos de nuevo
		for(int i = 0; i<cDAO.getClientes().size();i++) {
			tablac.anadeCliente(cDAO.getClientes().get(i));
		}
		
		JLabel jl1 = new JLabel("Tabla");
		jl1.setFont(new Font("Garamond", Font.BOLD, 32));
		jl1.setSize(80, 40);
		jl1.setLocation(20, 5);
		jl1.setForeground(Color.BLACK);
		JLabel jl2 = new JLabel("Clientes");
		jl2.setFont(new Font("Garamond", Font.BOLD, 32));
		jl2.setSize(180, 40);
		jl2.setLocation(20, 35);
		jl2.setForeground(Color.BLACK);
		
		this.add(jl1);this.add(jl2);
		this.add(s);
		this.setLocation(0, 0);
		this.setSize(600,420);
		this.setLayout(null);
		this.setBackground(new Color(250,230,150));
	}
	
}
