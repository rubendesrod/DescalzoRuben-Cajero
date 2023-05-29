package Controlador.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Validador;
import Modelo.DAO.ClientesDAO;
import Modelo.DAO.CuentaDAO;
import Modelo.DAO.TarjetaDAO;
import Modelo.DTO.ClienteDTO;
import Modelo.DTO.CuentaDTO;
import Modelo.DTO.TarjetaDTO;
import Vista.Admin.Vistas.Administrar.FrameModificar;

/**
 * Clase que implementa el ActionListener y se encarga de buscar
 * clientes, tarjeta  cuentas en la base de datos
 * 
 * @version 1.0
 * @author Ruben
 *
 */

public class GestorBuscarMod implements ActionListener{

	private FrameModificar fm;
	private String objeto;
	private CuentaDTO cDTO;
	private ClienteDTO cliDTO;
	private TarjetaDTO tDTO;
	private CuentaDAO cDAO;
	private ClientesDAO cliDAO;
	private TarjetaDAO tDAO;
	private Validador v;
	
	/**
	 * Constructor de la clase  
	 * 
	 * @param fm [Frame que contiene los datos que se van a usar]
	 * @param objeto [String que indica, sobre que tabla de la base de datos se va a trabajar]
	 */
	
	public GestorBuscarMod(FrameModificar fm, String objeto) {
		this.fm = fm;
		this.objeto = objeto;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		v = new Validador();
		
		if(objeto.equalsIgnoreCase("cliente")) {
			
			if (v.validarDni(fm.getPk().getText())) {
				
				cliDTO = new ClienteDTO();
				cliDTO.setDni(fm.getPk().getText());
				cliDAO = new ClientesDAO();
				cliDAO.buscarCliente(cliDTO);
				if(cliDAO.getCli().getDni().equalsIgnoreCase(fm.getPk().getText())) {
					fm.getTxt2().setEditable(true);fm.getTxt3().setEditable(true);fm.getTxt4().setEditable(true);fm.getTxt5().setEditable(true);
					fm.getTxt6().setEditable(true);fm.getTxt7().setEditable(true);fm.getTxt8().setEditable(true);
					fm.getTxt2().setText(cliDAO.getCli().getNombre());fm.getTxt3().setText(cliDAO.getCli().getApell1());fm.getTxt4().setText(cliDAO.getCli().getApell2());
					fm.getTxt5().setText(cliDAO.getCli().getDireccion());fm.getTxt6().setText(cliDAO.getCli().getCorreo());fm.getTxt7().setText(cliDAO.getCli().getTelefono());
					fm.getTxt8().setText(cliDAO.getCli().getFechaNac());
					fm.getPk().setEditable(false);fm.getBuscar().setEnabled(false);
				}else {
					fm.getErrores().setText("No existe el DNI");
				}
			
			}else{
				fm.getErrores().setText(v.getMsg());
			}
			
		}else if (objeto.equalsIgnoreCase("tarjeta")) {
			
			if(v.validarNumTarjeta(fm.getPk().getText())) {
				
				tDTO = new TarjetaDTO();
				tDAO = new TarjetaDAO();
				TarjetaDTO aux = new TarjetaDTO();
				tDTO.setNumTarjeta(fm.getPk().getText());
				tDAO.buscarTarjeta(tDTO);
				if(tDAO.gettDTO().getNumTarjeta().equalsIgnoreCase(fm.getPk().getText())) {
					fm.getTxt2().setEditable(true);fm.getTxt3().setEditable(true);fm.getTxt4().setEditable(true);
					fm.getTxt6().setEditable(true);
					aux = tDAO.gettDTO();
					fm.getTxt2().setText(String.valueOf(aux.getPin()));fm.getTxt3().setText(String.valueOf(aux.getCvv()));fm.getTxt4().setText(aux.getFechaCaducidad());
					fm.getTxt6().setText(aux.getNumCuenta());
					if(aux.getEstado().equalsIgnoreCase("bloqueado")) {
						fm.getC().add("bloqueado");
						fm.getC().add("noBloqueado");
					}else {
						fm.getC().add("noBloqueado");
						fm.getC().add("bloqueado");
					}
					fm.getPk().setEditable(false);fm.getBuscar().setEnabled(false);
				}else{
					fm.getErrores().setText("No existe el Numero de Tarjeta");
				}
				
			}else {
				fm.getErrores().setText(v.getMsg());
			}
			
		}else if (objeto.equalsIgnoreCase("cuenta")) {
		
			if (v.validarNumCuenta(fm.getPk().getText())) {
				
				cDTO = new CuentaDTO();
				cDTO.setNumCuenta(fm.getPk().getText());
				cDAO = new CuentaDAO();
				cDAO.buscarCuenta(cDTO);
				if(cDAO.getcDTO().getNumCuenta().equalsIgnoreCase(fm.getPk().getText())) {
					fm.getTxt2().setEditable(true);fm.getTxt3().setEditable(true);
					fm.getTxt2().setText(String.valueOf(cDAO.getcDTO().getSaldo()));
					fm.getTxt3().setText(cDAO.getcDTO().getDni());
					fm.getPk().setEditable(false);fm.getBuscar().setEnabled(false);
				}else {
					fm.getErrores().setText("No existe el Numero de Cuenta");
				}
				
			}else {
				fm.getErrores().setText(v.getMsg());
			}
		}
		
	}

}
