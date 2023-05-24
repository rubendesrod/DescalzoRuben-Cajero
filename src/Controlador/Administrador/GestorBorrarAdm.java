package Controlador.Administrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public GestorBorrarAdm(FrameBorrar fb, String objeto) {
		
		this.fb = fb;
		this.objeto = objeto;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(objeto.equalsIgnoreCase("cliente")) {
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
		}else if (objeto.equalsIgnoreCase("tarjeta")) {
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
		}else if(objeto.equalsIgnoreCase("cuenta")) {
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
		}
		
	}
	
}
