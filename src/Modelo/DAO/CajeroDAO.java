package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.Conectar;
import Modelo.Consultas;
import Modelo.DTO.CajeroDTO;


/**
 * Clase que se encarga de realizar consultas a la BB.DD sobre el Cajero
 * 
 * @version 1.0
 * 
 * @author Ruben
 *
 */

public class CajeroDAO {
	
	private CajeroDTO cDTO = new CajeroDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ResultSet rs = null;
	private String msg;
	
	/**
	 * Metodo que busca el Cajero realizando una consulta a la BB.DD
	 */
	
	public void buscarCajero() {
		this.msg ="Los movimientos han sido encontrados";
		this.cn = new Conectar();
		try {
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_CAJERO);
			this.rs = this.ps.executeQuery();
				if (rs.next()) {
					this.cDTO = new CajeroDTO();
					this.cDTO.setEstado(rs.getString(1));		
				}
		}catch (SQLException e) {
			this.msg = "Error: "+e;
		}finally {
			this.cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	/**
	 * Metodo que relaiza una modificacion del cajero en la BB.DD
	 * @param cDTO [CajeroDTO]
	 */
	
	public void modificarCajero(CajeroDTO cDTO) {
		this.msg = "La cuenta ha sido modificada correctamente";
		this.cn = new Conectar();
		try {
			if(cDTO.getEstado()!=null) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CAJERO);
					this.ps.setString(1, cDTO.getEstado());
					this.ps.executeUpdate();
			}else {
				this.msg = "No se ha modificado el cajero";
			}
		}catch(Exception e) {
			this.msg = "Error: "+e;
		}finally {
			this.cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}

	/**
	 * Metodo get de CajeroDTO
	 * 
	 * @return CajeroDTO
	 */
	
	public CajeroDTO getcDTO() {
		return cDTO;
	}

	/**
	 * Metodo set de CajeroDTO
	 * 
	 * @param cDTO [CajeroDTO]
	 */
	
	public void setcDTO(CajeroDTO cDTO) {
		this.cDTO = cDTO;
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
	 * @param msg [Mensaje de si se ha realizado la consulta o no]
	 */
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
