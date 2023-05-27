package Controlador.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import Modelo.DAO.CuentaDAO;
import Modelo.DAO.MovimientoDAO;
import Modelo.DAO.TarjetaDAO;
import Modelo.DTO.CuentaDTO;
import Modelo.DTO.MovimientoDTO;
import Modelo.DTO.TarjetaDTO;
import Vista.Cliente.PrincipalUss;

/**
 * Clase que se encarga de guardar los movimientos de una cuenta y exportarlos.
 * 
 * @version 1.0
 * @author Ruben
 *
 */

public class GestorGuardar implements ActionListener{

	private MovimientoDTO mDTO;
	private MovimientoDAO mDAO;
	private TarjetaDTO tDTO;
	private TarjetaDAO tDAO;
	private CuentaDTO cDTO;
	private CuentaDAO cDAO;
	private PrincipalUss usr;
	private String numTarjeta;
	
	
	/**
	 * Constructor de la clase 
	 * 
	 * @param numTarjeta
	 * @param usr
	 */
	public GestorGuardar(String numTarjeta, PrincipalUss usr) {
		
		this.numTarjeta = numTarjeta;
		this.usr = usr;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser ubicacion = new JFileChooser();
		int opcion = ubicacion.showSaveDialog(usr);

		if (opcion == JFileChooser.APPROVE_OPTION) {
			try {

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

				String ruta = ubicacion.getSelectedFile().getAbsolutePath();

				FileWriter escribir = new FileWriter(ruta);
				PrintWriter esc = new PrintWriter(escribir);

				esc.print("****** CAJERO GALI ******");
				esc.print("\nMOVIMIENTOS Y SALDO                  NumCuenta:" + cDAO.getcDTO().getNumCuenta());
				esc.print("\n||     FECHA    ||    TIPO   ||   CANTIDAD   ||    AUTOR     ||       NumeroCuenta      ||\n");
				for (MovimientoDTO m : mDAO.getCuentas()) {

					esc.print("\n||  " + m.getFecha() + "  ||  " + m.getEstado() + "  ||    " + m.getCantidad() + "   ||  "
							+ m.getDni() + "    ||  " + m.getNumCuenta() + "  ||");
				}

				esc.print("\n\nSaldo de la cuenta " + mDAO.getmDTO().getNumCuenta() + ": " + cDAO.getcDTO().getSaldo() + "€");

				esc.close();
			} catch (IOException p) {
				System.out.print(p);
			}
		}
		
	}
	
}
