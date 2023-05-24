package Controlador.Administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.DAO.ClientesDAO;
import Modelo.DAO.CuentaDAO;
import Modelo.DAO.TarjetaDAO;
import Modelo.DTO.ClienteDTO;
import Modelo.DTO.CuentaDTO;
import Modelo.DTO.TarjetaDTO;
import Vista.Admin.Vistas.Administrar.FrameModificar;

public class GestorModificarAdm implements ActionListener{

	private FrameModificar fm;
	private String objeto;
	private ClienteDTO cliDTO;
	private ClientesDAO cliDAO;
	private TarjetaDTO tDTO;
	private TarjetaDAO tDAO;
	private CuentaDTO cDTO;
	private CuentaDAO cDAO;
	
	public GestorModificarAdm(FrameModificar fm, String objeto) {
		this.fm = fm;
		this.objeto = objeto;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
