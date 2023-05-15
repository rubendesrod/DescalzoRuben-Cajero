package Controlador.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.DAO.AdminDAO;
import Modelo.DAO.TarjetaDAO;
import Modelo.DTO.AdminDTO;
import Modelo.DTO.TarjetaDTO;
import Vista.DatosLoginAdm;
import Vista.DatosLoginUss;
import Vista.Vista;

public class GestorLogin implements ActionListener {

	private DatosLoginAdm da;
	private DatosLoginUss du;
	private Vista v;
	private AdminDTO adm;
	private TarjetaDTO us;
	private TarjetaDAO tDAO = new TarjetaDAO();
	private AdminDAO aDAO = new AdminDAO();;
	
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
		boolean enter = validarEntradaDatos();
		if(enter) {
		
			if(da != null) {
				String pass;
				if(da.getPassV().getText().isBlank()) {
					pass = String.valueOf(da.getPassO().getPassword());
				}else {
					pass = da.getPassV().getText();
				}
				adm = new AdminDTO(da.getUss().getText(), pass);
				aDAO.buscarAdmin(adm);
				da.getError().setText(aDAO.getMsg());
				if(aDAO.getAdm().getContra().equals(pass)) {
					da.setVisible(false);
					v.getwMark().setVisible(false);;
					//vtnAdmin.setVisible(true);
				}
				else {
					da.getError().setText("La contraseña es errónea");
				}
			}else {
				String pass;
				if(du.getPassV().getText().isBlank()) {
					pass = String.valueOf(du.getPassO().getPassword());
				}else {
					pass = du.getPassV().getText();
				}
				us = new TarjetaDTO();
				us.setNumTarjeta(du.getUss().getText());
				us.setPin(Integer.parseInt(pass));
				tDAO.buscarTarjeta(us);
				du.getError().setText(tDAO.getMsg());
				if(tDAO.gettDTO().getPin() == Integer.parseInt(pass)) {
					du.setVisible(false);
					v.getwMark().setVisible(false);;
					//vtnCliente.setVisible(true);
				}else {
					du.getError().setText("El PIN es erróneo");
				}
			}
			
		}
	}

	private boolean validarEntradaDatos() {
		//String passOculta = String.valueOf(da.getPassO().getPassword());
		return true;
//		if((da.getUss().getText().isBlank() && passOculta.isBlank() && da.getPassV().getText().isBlank()) ||
//				(du.getUss().getText().isBlank() && passOculta.isBlank() && da.getPassV().getText().isBlank()))
//		{
//			da.getError().setText("**Error: Rellena los dos campos");
//			da.getUss().setText("");
//			da.getPassO().setText("");
//			da.getPassV().setText("");
//			return false;
//		}else if (passOculta.isBlank() && da.getPassV().getText().isBlank() || passOculta.isBlank() && du.getPassV().getText().isBlank()) {
//			da.getError().setText("**Error: Introduce la contraseña");
//			da.getUss().setText("");
//			da.getPassO().setText("");
//			da.getPassV().setText("");
//			return false;
//		}else {
//			da.getError().setText("**Error: Ambos campos son obligatorios");
//			du.getError().setText("**Error: Ambos campos son obligatorios");
//		}
//		return true;
	}

	public DatosLoginAdm getDa() {
		return da;
	}

	public void setDa(DatosLoginAdm da) {
		this.da = da;
	}

	public DatosLoginUss getDu() {
		return du;
	}

	public void setDu(DatosLoginUss du) {
		this.du = du;
	}

	public Vista getV() {
		return v;
	}

	public void setV(Vista v) {
		this.v = v;
	}

	public AdminDTO getAdm() {
		return adm;
	}

	public void setAdm(AdminDTO adm) {
		this.adm = adm;
	}

	public TarjetaDTO getUs() {
		return us;
	}

	public void setUs(TarjetaDTO us) {
		this.us = us;
	}

	public TarjetaDAO gettDAO() {
		return tDAO;
	}

	public void settDAO(TarjetaDAO tDAO) {
		this.tDAO = tDAO;
	}

	public AdminDAO getaDAO() {
		return aDAO;
	}

	public void setaDAO(AdminDAO aDAO) {
		this.aDAO = aDAO;
	}

	
	
}
