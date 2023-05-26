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
import Vista.Admin.Vistas.Administrar.FrameBorrar;

public class GestorBorrarAdm implements ActionListener{

	private FrameBorrar fb;
	private String objeto;
	private ClienteDTO cliDTO;
	private ClientesDAO cliDAO;
	private TarjetaDTO tDTO;
	private TarjetaDAO tDAO;
	private CuentaDTO cDTO;
	private CuentaDAO cDAO;
	private Validador v;
	/**
	 * Constructo de la GestorBorrar, la cual se encarga de borrar en la base de datos
	 * @author Ruben
	 * @param fb [Panel donde se encuentran los campos de texto]
	 * @param objeto [String que indica, sobre que tabla de la base de datos se va a trabajar]
	 */
	
	public GestorBorrarAdm(FrameBorrar fb, String objeto) {
		
		this.fb = fb;
		this.objeto = objeto;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		v = new Validador();
		
		if(objeto.equalsIgnoreCase("cliente")) {
			if (v.validarDni(fb.getPk().getText())) {
				if (fb.getPk().getText().isEmpty()){	
						fb.getErrores().setText("** CAMPO OBLIGATORIO");
				}else {
					cliDTO = new ClienteDTO();
					cliDAO = new ClientesDAO();
					cliDTO.setDni(fb.getPk().getText());
					cliDAO.buscarCliente(cliDTO);
					if(cliDAO.getCli().getDni().equalsIgnoreCase(cliDTO.getDni())) {
						cliDAO.eliminarCliente(cliDTO);
						fb.getErrores().setForeground(Color.blue);
						fb.getErrores().setText(cliDAO.getMsg());
					}else {
						fb.getErrores().setText("** EL DNI NO EXISTE");
					}
				}	
			}else {
				fb.getErrores().setText(v.getMsg());
			}
		}else if (objeto.equalsIgnoreCase("tarjeta")) {
			if (v.validarNumTarjeta(fb.getPk().getText())) {
				if (fb.getPk().getText().isEmpty()){	
					fb.getErrores().setText("** CAMPO OBLIGATORIO");
				}else {
					tDTO = new TarjetaDTO();
					tDAO = new TarjetaDAO();
					tDTO.setNumTarjeta(fb.getPk().getText());
					tDAO.buscarTarjeta(tDTO);
					if(tDAO.gettDTO().getNumTarjeta().equals(tDTO.getNumTarjeta())) {
						tDAO.eliminarTarjeta(tDTO);
						fb.getErrores().setForeground(Color.blue);
						fb.getErrores().setText(tDAO.getMsg());
					}else {
						fb.getErrores().setText("** EL DNI NO EXISTE");
					}
				}	
			}else {
				fb.getErrores().setText(v.getMsg());
			}
		}else if(objeto.equalsIgnoreCase("cuenta")) {
			if (v.validarNumTarjeta(fb.getPk().getText())) {
				if(fb.getErrores().getText().isEmpty()) {
					fb.getErrores().setText("** CAMPO OBLIGATORIO");
				}else {
					cDTO = new CuentaDTO();
					cDAO = new CuentaDAO();
					cDTO.setNumCuenta(fb.getPk().getText());
					cDAO.buscarCuenta(cDTO);
					if(cDAO.getcDTO().getNumCuenta().equalsIgnoreCase(cDTO.getNumCuenta())) {
						cDAO.borrarCuenta(cDTO);
						fb.getErrores().setForeground(Color.blue);
						fb.getErrores().setText(cDAO.getMsg());
					}else {
						fb.getErrores().setText("** LA CUENTA NO EXISTE");
					}
				}
			}else {
				fb.getErrores().setText(v.getMsg());
			}
		}
		
	}
	
}
