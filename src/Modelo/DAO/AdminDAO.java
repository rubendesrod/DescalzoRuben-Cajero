package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.Conectar;
import Modelo.DTO.AdminDTO;

/**
 * Clase que se encarga de realizar consultas a la BB.DD sobre el Administrador
 * 
 * @version 1.0
 * @author Ruben
 *
 */

public class AdminDAO {

	private AdminDTO adm = new AdminDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ResultSet rs = null;
	private String msg;
	
	/**
	 * Metodo que se encarga de un admin
	 * 
	 * @param aDTO [AdminDTO]
	 */
	
	public void buscarAdmin(AdminDTO aDTO) {
		this.cn = new Conectar();
		this.msg = "El administrador ha sido encontrado";
		try {
			if(aDTO.getUsuario()!= null) {
				this.ps = this.cn.getConnect().prepareStatement("select * from administrador where usuario = ?");
				this.ps.setString(1, aDTO.getUsuario());
				this.rs = this.ps.executeQuery();
				if(this.rs.next()) {
					this.setAdm(new AdminDTO());
					this.adm.setUsuario(rs.getString(1));
					this.adm.setContra(rs.getString(2));
				}
				else {
					this.msg = "El administrador no existe";
				}
			}
			
		}catch(Exception e) {
			this.msg = "Error:"+e; 
		}finally {
			this.cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
		
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
	 * Metodo set AdminDTO
	 * 
	 * @param adm [AdminDTO]
	 */
	
	public void setAdm(AdminDTO adm) {
		this.adm = adm;
	}

	/**
	 * Metodo get de PreparedStatement
	 * 
	 * @return PreparedStatement
	 */
	
	public PreparedStatement getPs() {
		return ps;
	}

	/**
	 * Metodo set de PreparedStatement
	 * 
	 * @param ps [PreparedStatement]
	 */
	
	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	/**
	 * Metodo get de Conectar
	 * 
	 * @return Conectar
	 */
	
	public Conectar getCn() {
		return cn;
	}

	/**
	 * Metodo set de Conectar
	 * 
	 * @param cn [Conectar]
	 */
	
	public void setCn(Conectar cn) {
		this.cn = cn;
	}

	/**
	 * Metodo get de ResultSet
	 * 
	 * @return ResultSet
	 */
	
	public ResultSet getRs() {
		return rs;
	}

	/**
	 * Metodo set de ResultSet
	 * 
	 * @param rs [ResultSet]
	 */
	
	public void setRs(ResultSet rs) {
		this.rs = rs;
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
	 * Metodo set de Msg
	 * 
	 * @param msg [Mensaje si se ha realizado o no la consulta]
	 */
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
