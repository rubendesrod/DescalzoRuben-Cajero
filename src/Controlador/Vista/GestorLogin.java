package Controlador.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.DAO.AdminDAO;
import Modelo.DTO.AdminDTO;
import Vista.DatosLoginAdm;
import Vista.DatosLoginUss;
import Vista.Vista;

public class GestorLogin implements ActionListener {

	private DatosLoginAdm da;
	private DatosLoginUss du;
	private Vista v;
	private AdminDTO adm;
	
	public GestorLogin(DatosLoginAdm da ,Vista v) {
		this.v = v;
		this.da = da;
	}
	
	public GestorLogin(DatosLoginUss du, Vista v) {
		this.du = du;
		this.v = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean enter = validarEntradaDatos(this.da);
		if(enter) {
			String pass;
			if(da.getPassV().getText().isBlank()) {
				pass = String.valueOf(da.getPassO().getPassword());
			}else {
				pass = da.getPassV().getText();
			}
		if(da.getUss().getText().equalsIgnoreCase("admin")) {
			adm = new AdminDTO(da.getUss().getText(), pass);
			
			
		}
			
		}
	}

	private boolean validarEntradaDatos(DatosLoginAdm da2) {
		String passOculta = String.valueOf(da.getPassO().getPassword());
		if(!da.getUss().getText().isBlank() && passOculta.isBlank() && da.getPassV().getText().isBlank()) {
			da.getError().setText("**Error: Ambos campos son obligatorios");
			da.getUss().setText("");
			da.getPassO().setText("");
			da.getPassV().setText("");
			return false;
		}else if (!passOculta.isBlank() && da.getPassV().getText().isBlank()) {
			da.getError().setText("**Error: ");
			da.getUss().setText("");
			da.getPassO().setText("");
			da.getPassV().setText("");
			return false;
		}else {
			da.getError().setText("");
		}
		return true;
	}

}
