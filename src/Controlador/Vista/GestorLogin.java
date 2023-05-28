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

/**
 * Clase que se encarga de rocoger los datos del login y hacer una llamada a la 
 * BB.DD para comprobar los datos de este.
 * 
 * @version 1.0
 * @author Ruben
 *
 */

public class GestorLogin implements ActionListener {

	private DatosLoginAdm da;
	private DatosLoginUss du;
	private Vista v;
	private AdminDTO adm;
	private TarjetaDTO us;
	private TarjetaDAO tDAO = new TarjetaDAO();
	private AdminDAO aDAO = new AdminDAO();
	private Validador val;
	private int intentos = 0;
	
	/**
	 * Constructor de la clase 
	 * 
	 * @param da [Panel donde se encuentran los datos del administrador]
	 * @param v [Frame principal]
	 */
	
	public GestorLogin(DatosLoginAdm da ,Vista v) {
		this.v = v;
		this.da = da;
	}
	
	/**
	 * constructor de la clase
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
					tDAO.buscarTarjeta(us);
					
					if (us.getNumTarjeta().equalsIgnoreCase(tDAO.gettDTO().getNumTarjeta())) {
						us.setPin(Integer.parseInt(pass));
						
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
						du.getError().setText("La tarjeta introducida no existe");
					}
				}else {
					du.getError().setText(val.getMsg());
				}
			}	
		}
	}

	/**
	 * Funcion que se encarga de validar los campos de texto
	 * 
	 * @return true, si se han rellenado bien los campos y ninguno vacio
	 * @return false, si hay algun campo vacio sin estar escrito
	 */
	
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

	/**
	 * Metodo get de DatosLoginAdm
	 * 
	 * @return DatosLoginAdm
	 */
	
	public DatosLoginAdm getDa() {
		return da;
	}

	/**
	 * Metodo set de DatosLoginAdm
	 * 
	 * @param da Panel de dartos del Administrador
	 */
	
	public void setDa(DatosLoginAdm da) {
		this.da = da;
	}

	/**
	 * Metodo get de DatosLoginUss
	 * 
	 * @return DatosLoginUss
	 */
	
	public DatosLoginUss getDu() {
		return du;
	}

	/**
	 * Metodo set de DatosLoginUss
	 * 
	 * @param du Panel de datos del cliente
	 */
	
	public void setDu(DatosLoginUss du) {
		this.du = du;
	}

	/**
	 * Metodo get de Vista
	 * 
	 * @return Vista
	 */
	
	public Vista getV() {
		return v;
	}

	/**
	 * Metodo set de Vista
	 * 
	 * @param v Frame principal
	 */
	
	public void setV(Vista v) {
		this.v = v;
	}

	/**
	 * Metodo get de AdminDTO
	 * 
	 * @return AdminDTO
	 */
	
	public AdminDTO getAdm() {
		return adm;
	}

	/**
	 * Metodo get de AdminDTO
	 * 
	 * @param adm AdministradorDTO
	 */
	
	public void setAdm(AdminDTO adm) {
		this.adm = adm;
	}

	/**
	 * Metodo get de TarjetaDTO
	 * 
	 * @return TarjetaDTO
	 */
	
	public TarjetaDTO getUs() {
		return us;
	}

	/**
	 * Metodo set de TarjetaDTO
	 * 
	 * @param us TarjetaDTO
	 */
	
	public void setUs(TarjetaDTO us) {
		this.us = us;
	}

	/**
	 * Metodo get de TarjetaDAO
	 * 
	 * @return TarjetaDAO
	 */
	
	public TarjetaDAO gettDAO() {
		return tDAO;
	}

	/**
	 * Metodo set de TarjetaDAO
	 * 
	 * @param tDAO TarjetaDAO
	 */
	
	public void settDAO(TarjetaDAO tDAO) {
		this.tDAO = tDAO;
	}

	/**
	 * Metodo get de AdminDAO
	 * 
	 * @return AdminDAO
	 */
	
	public AdminDAO getaDAO() {
		return aDAO;
	}

	/**
	 * Metodo set de AdminDAO
	 * 
	 * @param aDAO AdminDAO
	 */
	
	public void setaDAO(AdminDAO aDAO) {
		this.aDAO = aDAO;
	}

	
	
}
