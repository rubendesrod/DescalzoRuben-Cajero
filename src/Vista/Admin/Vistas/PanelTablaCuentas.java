package Vista.Admin.Vistas;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import Modelo.DAO.CuentaDAO;
import Modelo.DTO.CuentaDTO;
import Modelo.Tabla.TablaCuentas;



public class PanelTablaCuentas extends JPanel{

	private CuentaDTO cDTO;
	private CuentaDAO cDAO;
	
	public PanelTablaCuentas() {
		
		cDTO = new CuentaDTO();
		cDTO.setNumCuenta(null);
		cDAO = new CuentaDAO();
		cDAO.buscarCuenta(cDTO);
		
		TablaCuentas tablac = new TablaCuentas();
		JTable tabla =new JTable(tablac);
		JScrollPane s = new JScrollPane();
		s.setViewportView(tabla);
		s.setColumnHeaderView(tabla.getTableHeader());
		s.setBounds(45,140,500,200);
		
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
			tablac.borrarCuenta(row);
		}
		
		//Ahora anyadimos los datos de nuevo
		for(int i = 0; i<cDAO.getCuentas().size();i++) {
			tablac.anadeCuenta(cDAO.getCuentas().get(i));
		}
		
		this.add(s);
		this.setLocation(0, 30);
		this.setSize(600,420);
		this.setLayout(null);
		this.setBackground(new Color(250,230,150));
		
	}
	
}
