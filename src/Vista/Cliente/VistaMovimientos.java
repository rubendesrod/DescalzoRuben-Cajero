package Vista.Cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import Controlador.Cliente.GestorGuardar;
import Modelo.DAO.CuentaDAO;
import Modelo.DAO.MovimientoDAO;
import Modelo.DAO.TarjetaDAO;
import Modelo.DTO.CuentaDTO;
import Modelo.DTO.MovimientoDTO;
import Modelo.DTO.TarjetaDTO;
import Modelo.Tabla.TablaMovimientos;

/**
 * Clas que extiende de JPanel, muestra al usuario la informacion de sus movientos realizados
 * 
 * @version 1.0
 * @author Ruben
 */

public class VistaMovimientos extends JPanel{

	private PrincipalUss usr;
	private String numTarjeta;
	private MovimientoDTO mDTO;
	private MovimientoDAO mDAO;
	private TarjetaDTO tDTO;
	private TarjetaDAO tDAO;
	private CuentaDTO cDTO;
	private CuentaDAO cDAO;
	
	/**
	 * Constructor de la clase VistaMovimientoss
	 * @param usr [Ventana principal del usuario]
	 * @param numTarjeta [Su numero de la tarjeta]
	 */
	
	public VistaMovimientos(PrincipalUss usr, String numTarjeta){
		
		this.usr = usr;
		this.numTarjeta = numTarjeta;
		
		tDTO = new TarjetaDTO();
		tDTO.setNumTarjeta(numTarjeta);
		tDAO = new TarjetaDAO();
		tDAO.buscarTarjeta(tDTO);
		mDTO = new MovimientoDTO();
		mDTO.setNumCuenta(tDAO.gettDTO().getNumCuenta());
		mDAO = new MovimientoDAO();
		mDAO.buscarMovimiento(mDTO);
		cDTO = new CuentaDTO();
		cDTO.setNumCuenta(tDAO.gettDTO().getNumCuenta());
		cDAO = new CuentaDAO();
		cDAO.buscarCuenta(cDTO);
		
		
		TablaMovimientos tablaM = new TablaMovimientos();
		JTable tabla =new JTable(tablaM);
		JScrollPane s = new JScrollPane();
		s.setViewportView(tabla);
		s.setColumnHeaderView(tabla.getTableHeader());
		s.setBounds(45,140,500,250);
		
		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        
        int columnas = tabla.getColumnCount();
        for(int i = 0; i<columnas;i++) {
        	tabla.getColumnModel().getColumn(i).setCellRenderer(centro);
        }
		
		// Primero borramos la tabla para que refresque si hay nuevos datos
		int row = tablaM.getRowCount();
		while(row>0) {
			row--;
			tablaM.borrarMovimiento(row);
		}
		
		//Ahora anyadimos los datos de nuevo
		for(int i = 0; i<mDAO.getCuentas().size();i++) {
			tablaM.anadeMovimiento(mDAO.getCuentas().get(i));
		}
		
		JLabel txt = new JLabel("Movimientos y Saldo");
		Font font = new Font("Arial", Font.BOLD, 40);
		txt.setFont(font);
		txt.setForeground(Color.BLACK);
		txt.setLocation(45,20);
		txt.setSize(400, 50);
		
		JButton save = new JButton();
		ImageIcon g = new ImageIcon("img/guardar.png");
		save.setIcon(g);
		save.setLocation(90, 100);
		save.setSize(30,30);
		save.setBorderPainted(false);
		save.setContentAreaFilled(false);
		save.addActionListener(new GestorGuardar(numTarjeta, usr));
		
		JLabel com = new JLabel("Guardar movimientos");
		com.setSize(190,30);
		com.setLocation(50,70);
		
		JLabel saldo = new JLabel(String.valueOf(cDAO.getcDTO().getSaldo())+"€");
		Font fuente = new Font("Arial", Font.BOLD, 16);
		saldo.setFont(fuente);
		saldo.setForeground(Color.BLACK);
		saldo.setSize(140,40);
		saldo.setLocation(420, 100);
		
		JButton volver = new JButton();
		ImageIcon back = new ImageIcon("img/volver.png");
		volver.setIcon(back);
		volver.setSize(40,40);
		volver.setLocation(530, 40);
		volver.setBorderPainted(false);
		volver.setContentAreaFilled(false);
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				usr.remove(VistaMovimientos.this);
				usr.repaint();
				usr.mostrarPanel(usr.getP());;
				
			}
		});
		
		this.add(s);this.add(txt);this.add(save);this.add(com);this.add(saldo);this.add(volver);
		this.setLayout(null);
		this.setBackground(new Color(250,230,150));
		usr.getP().setVisible(false);
		usr.remove(usr.getP());
		usr.repaint();
		usr.add(this);
		
	}
	
}
