package Controlador.Administrador;

import java.awt.Color;
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
 * Clase que se encarga de modificar los datos en la BB.DD de un cliente
 * , una cuenta o una tarjeta.
 * 
 *@version 1.0
 * @author Ruben
 *
 */

public class GestorModificarAdm implements ActionListener{

	private FrameModificar fm;
	private String objeto;
	private ClienteDTO cliDTO;
	private ClientesDAO cliDAO;
	private TarjetaDTO tDTO;
	private TarjetaDAO tDAO;
	private CuentaDTO cDTO;
	private CuentaDAO cDAO;
	private Validador v;
	
	/**
	 * Constructor de la clase 
	 * 
	 * @param fm [FrameModificar del cual se van a sacar los datos a utilizar]
	 * @param objeto [String que indica, sobre que tabla de la base de datos se va a trabajar]
	 */
	
	public GestorModificarAdm(FrameModificar fm, String objeto) {
		this.fm = fm;
		this.objeto = objeto;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		v = new Validador();
		
		if(objeto.equalsIgnoreCase("cliente")) {
			
			if (fm.getTxt2().getText().isEmpty()||fm.getTxt3().getText().isEmpty() || fm.getTxt4().getText().isEmpty() || fm.getTxt5().getText().isEmpty()||
				fm.getTxt6().getText().isEmpty()|| fm.getTxt7().getText().isEmpty() || fm.getTxt8().getText().isEmpty() ){	
					
				fm.getErrores().setText("FALTAN CAMPOS OBLIGATORIOS [*]");
					
			}else {
					if (v.validarNombreApellDir(fm.getTxt2().getText()) && v.validarNombreApellDir(fm.getTxt3().getText())
							&& v.validarNombreApellDir(fm.getTxt4().getText()) && v.validarNombreApellDir(fm.getTxt5().getText())&& v.validarCorreo(fm.getTxt6().getText())
							&& v.validarTelefono(fm.getTxt7().getText())&& v.validarFechaNac(fm.getTxt8().getText())) {
						
						cliDTO = new ClienteDTO();
						cliDAO = new ClientesDAO();
						cliDTO.setDni(fm.getPk().getText());
						cliDTO.setNombre(fm.getTxt2().getText());
						cliDTO.setApell1(fm.getTxt3().getText());
						cliDTO.setApell2(fm.getTxt4().getText());
						cliDTO.setDireccion(fm.getTxt5().getText());
						cliDTO.setCorreo(fm.getTxt6().getText());
						cliDTO.setTelefono(fm.getTxt7().getText());
						cliDTO.setFechaNac(fm.getTxt8().getText());
						cliDAO.buscarCliente(cliDTO);
						if(cliDAO.getCli().getDni().equalsIgnoreCase(cliDTO.getDni())) {
							cliDAO.modificarCliente(cliDTO);
							fm.getErrores().setForeground(Color.blue);
							fm.getErrores().setText(cliDAO.getMsg());
							fm.getPk().setEditable(true);fm.getBuscar().setEnabled(true);
						}else {
							fm.getErrores().setText("Este DNI ya existe en la base de datos");
						}
					}else {
						fm.getErrores().setText(v.getMsg());
					}
				}	
			
		}else if(objeto.equalsIgnoreCase("tarjeta")) {
			if (!fm.getTxt2().getText().isEmpty() || !fm.getTxt3().getText().isEmpty() || !fm.getTxt4().getText().isEmpty() || !fm.getTxt6().getText().isEmpty()) {
					if (v.validarPin(fm.getTxt2().getText())&& v.validarCvv(fm.getTxt3().getText()) && v.validarNumCuenta(fm.getTxt6().getText()) 
							&& v.validarFechaTarjeta(fm.getTxt4().getText())) {
						
						tDTO = new TarjetaDTO();
						tDAO = new TarjetaDAO();
						tDTO.setNumTarjeta(fm.getPk().getText());
						tDTO.setPin(Integer.parseInt(fm.getTxt2().getText()));
						tDTO.setCvv(Integer.parseInt(fm.getTxt3().getText()));
						tDTO.setFechaCaducidad(fm.getTxt4().getText());
						tDTO.setEstado(fm.getC().getSelectedItem());
						tDTO.setNumCuenta(fm.getTxt6().getText());
						tDAO.buscarTarjeta(tDTO);
						if(tDAO.gettDTO().getNumTarjeta().equalsIgnoreCase(tDTO.getNumTarjeta())) {
							cDTO = new CuentaDTO();
							cDAO = new CuentaDAO();
							cDTO.setNumCuenta(fm.getTxt6().getText());
							cDAO.buscarCuenta(cDTO);
							if (cDAO.getcDTO().getNumCuenta().equalsIgnoreCase(cDTO.getNumCuenta())) {
								tDAO.modificarTarjeta(tDTO);
								fm.getErrores().setForeground(Color.blue);
								fm.getErrores().setText(tDAO.getMsg());
								fm.getPk().setEditable(true);fm.getBuscar().setEnabled(true);
							}else {
								fm.getErrores().setText("No existe el numero de cuenta que has introducido");
							}
						}else {
							fm.getErrores().setText("Esta Tarjeta ya existe en la base de datos");
							
						}
					}else {
						fm.getErrores().setText(v.getMsg());
					}	
			}else {
				fm.getErrores().setText("FALTAN CAMPOS OBLIGATORIOS [*]");
			}
		}else if(objeto.equalsIgnoreCase("cuenta")) {
			
			if(fm.getTxt2().getText().isEmpty() || fm.getTxt3().getText().isEmpty()) {
				fm.getErrores().setText("FALTAN CAMPOS OBLIGATORIOS [*]");
			}else {
				if (v.validarSaldo(fm.getTxt2().getText()) && v.validarDni(fm.getTxt3().getText())) {
					cDTO = new CuentaDTO();
					cDAO = new CuentaDAO();	
					cDTO.setNumCuenta(fm.getPk().getText());
					cDTO.setSaldo(Double.parseDouble(fm.getTxt2().getText()));
					cDTO.setDni(fm.getTxt3().getText());
					cDAO.buscarCuenta(cDTO);
					if(cDAO.getcDTO().getNumCuenta().equalsIgnoreCase(cDTO.getNumCuenta())) {
						cliDTO = new ClienteDTO();
						cliDAO = new ClientesDAO();
						cliDTO.setDni(fm.getTxt3().getText());
						cliDAO.buscarCliente(cliDTO);
						if (cliDAO.getCli().getDni().equalsIgnoreCase(cliDTO.getDni())) {
							cDAO.modificarCuenta(cDTO);
							fm.getErrores().setForeground(Color.blue);
							fm.getErrores().setText(cDAO.getMsg());
							fm.getPk().setEditable(true);fm.getBuscar().setEnabled(true);
						}else {
							fm.getErrores().setText("El DNI no existe");
						}
					}else {
						fm.getErrores().setText("El Numero de cuenta ya existe");
					}
				}else {
					fm.getErrores().setText(v.getMsg());
				}
			}
			
		}
		
	}

}
