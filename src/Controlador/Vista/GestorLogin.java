package Controlador.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Modelo.Validador;
import Modelo.DAO.AdminDAO;
import Modelo.DAO.TarjetaDAO;
import Modelo.DTO.AdminDTO;
import Modelo.DTO.TarjetaDTO;
import Vista.DatosLoginAdm;
import Vista.DatosLoginUss;
import Vista.Vista;
import Vista.Admin.PrincipalAdm;
import Vista.Cliente.PrincipalUss;

public class GestorLogin implements ActionListener {

	private DatosLoginAdm da;
	private DatosLoginUss du;
	private Vista v;
	private AdminDTO adm;
	private TarjetaDTO us;
	private TarjetaDAO tDAO = new TarjetaDAO();
	private AdminDAO aDAO = new AdminDAO();
	private Validador val;
	
	public int intentos = 0;
	
	/**
	 * Constructor de la clase GestorLogin, la cual se encarga de la entrada de datos
	 * del administrador cuando intenta iniciar sesion
	 * 
	 * @author Ruben
	 * @param da [Panel donde se encuentran los datos del administrador]
	 * @param v [Frame principal]
	 */
	
	public GestorLogin(DatosLoginAdm da ,Vista v) {
		this.v = v;
		this.da = da;
	}
	
	/**
	 * constructor de la clase GestorLogin, la cual se encarga de la entrada de datos
	 * cuando un cliente intenta inciar en el cajero
	 * 
	 * @author Ruben
	 * @param du [Panel donde se encuentran los datos del usuario]
	 * @param v [Frame principal]
	 */
	
	public GestorLogin(DatosLoginUss du, Vista v) {
		this.du = du;
		this.v = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		val = new Validador();
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
					PrincipalAdm p = new PrincipalAdm();
					p.setVisible(true);
					v.dispose();
				}
				else {
				da.getError().setText("La contraseña es errónea");
				}
				
			}else {
				String pass;
				if (du.getPassV().getText().isBlank()) {
					pass = String.valueOf(du.getPassO().getPassword());
				} else {
					pass = du.getPassV().getText();
				}
			if (val.validarNumTarjeta(du.getUss().getText()) && val.validarPin(pass)) {
					us = new TarjetaDTO();
					us.setNumTarjeta(du.getUss().getText());
					us.setPin(Integer.parseInt(pass));
					tDAO.buscarTarjeta(us);
					if (tDAO.gettDTO().getEstado().equalsIgnoreCase("bloqueado")) {
						du.getError().setText("** ESTA TARJETA SE ENCUENTRA BLOQUEADA");
					} else {
						DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate fechaTarjeta = LocalDate.parse(tDAO.gettDTO().getFechaCaducidad(), formato);
						LocalDate fechaActual = LocalDate.now();
						int comp = fechaTarjeta.compareTo(fechaActual);
						if (comp < 0) {
							du.getError().setText("** HA VENCIDO LA FECHA DE CADUCIDAD");
						} else {
							if (tDAO.gettDTO().getPin() == Integer.parseInt(pass)) {
								du.setVisible(false);
								v.setVisible(false);
								PrincipalUss p = new PrincipalUss(du.getUss().getText());
								p.setVisible(true);
							} else {
								du.getError().setText("El PIN es erróneo");
								intentos++;
								if (intentos == 3) {
									us.setPin(null);
									us.setEstado("bloqueado");
									tDAO.modificarTarjeta(us);
									intentos = 0;
								}
							}
						}
					} 
				}else {
					du.getError().setText(val.getMsg());
				}
			}	
		}
	}

	private boolean validarEntradaDatos() {
		
		if (du != null) {
			if (du.getUss().getText().isEmpty()) {
				du.getError().setText("** Falta Numero de Tarjeta");
				return false;
			} else if (du.getPassV().getText().isEmpty() && String.valueOf(du.getPassO().getPassword()).isEmpty()) {
				du.getError().setText("** Falta Pin de la Tarjeta");
				return false;
			}
			return true;
		}else {
			if(da.getUss().getText().isEmpty()) {
				da.getError().setText("** Falta usuario");
				return false;
			}else if(da.getPassV().getText().isEmpty() && String.valueOf(da.getPassO().getPassword()).isEmpty()) {
				da.getError().setText("** Falta Contraseña");
				return false;
			}
			return true;
		}
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
