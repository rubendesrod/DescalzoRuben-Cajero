package Controlador.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

import Modelo.Validador;
import Modelo.DAO.CuentaDAO;
import Modelo.DAO.MovimientoDAO;
import Modelo.DAO.TarjetaDAO;
import Modelo.DTO.CuentaDTO;
import Modelo.DTO.MovimientoDTO;
import Modelo.DTO.TarjetaDTO;
import Vista.Cliente.RetirarIngresar;

/**
 * Clase que se encarga de retirar o ingresar dinero dependiendo de la accion que quiere
 * realizar el cliente
 * 
 * @version 1.0
 * @author Ruben
 *
 */

public class GestorRI implements ActionListener{

	private RetirarIngresar r;
	private String msg;
	private String numTarjeta;
	private CuentaDAO cDAO;
	private CuentaDTO cDTO;
	private TarjetaDTO tDTO;
	private TarjetaDAO tDAO;
	private Double dinero;
	private MovimientoDTO mDTO;
	private MovimientoDAO mDAO;
	private Validador v;
	
	/**
	 * Constructor de la clase 
	 * 
	 * @param r [Panel del cual se recogen los datos necesarios]
	 * @param msg [Texto que contiene la accion que quiere realizar el cliente]
	 * @param tar [Numero de tarjeta con el que trabaja el cliente]
	 */
	
	public GestorRI(RetirarIngresar r, String msg, String tar) {
		this.r = r;
		this.msg = msg;
		this.numTarjeta = tar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		v = new Validador();
		if (v.validarSaldo(r.getCant().getText())) {
			LocalDate fechaActual = LocalDate.now();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String fecha = fechaActual.format(formato);

			if (!r.getCant().getText().isEmpty()) {
				dinero = Double.parseDouble(r.getCant().getText());
			} else {
				JOptionPane.showMessageDialog(null, "No se ha podido leer los datos", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				dinero = 0.0;
			}

			mDTO = new MovimientoDTO();
			mDAO = new MovimientoDAO();
			cDTO = new CuentaDTO();
			cDAO = new CuentaDAO();
			tDTO = new TarjetaDTO();
			tDAO = new TarjetaDAO();
			tDTO.setNumTarjeta(numTarjeta);
			tDAO.buscarTarjeta(tDTO);
			cDTO.setNumCuenta(tDAO.gettDTO().getNumCuenta());
			cDAO.buscarCuenta(cDTO);

			//Creo lo que es el movimiento pero sin darle si es tipo retirar o ingresar
			mDTO.setFecha(fecha);
			mDTO.setEstado(getMsg());
			mDTO.setNumCuenta(cDAO.getcDTO().getNumCuenta());
			mDTO.setDni(cDAO.getcDTO().getDni());

			//Primero compruebo desde que clase estoy llamando al action listener
			// ya que ingresar y retirar comparten el mismo procedimiento

			if (msg.equalsIgnoreCase("ingreso")) {
				cDTO.setSaldo(cDAO.getcDTO().getSaldo() + dinero);
				cDAO.modificarCuenta(cDTO);
				mDTO.setCantidad(dinero);
				JOptionPane.showMessageDialog(null, "El dinero se ha ingresado correctamente");
			} else {
				//Retirar
				if (cDAO.getcDTO().getSaldo() > dinero) {
					cDTO.setSaldo(cDAO.getcDTO().getSaldo() - dinero);
					cDAO.modificarCuenta(cDTO);
					mDTO.setCantidad(dinero);
					JOptionPane.showMessageDialog(null, "Se ha retirado correctamen la cantidad introducida");
				} else {
					JOptionPane.showMessageDialog(null, "No dispone de tanta cantidad a retirar", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			}
			//Ahora ya con el ultimo dato que falta del movimiento ya insertar el nuevo movimiento
			mDAO.crearMovimiento(mDTO);
		}else {
			JOptionPane.showMessageDialog(null, v.getMsg(), "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

	/**
	 * Metodo get de Msg
	 * 
	 * @return String
	 */
	
	public String getMsg() {
		return msg;
	}

	/**
	 * Metodo set de Msg pasandole un String
	 * 
	 * @param msg Mensaje de texto
	 */
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
