package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.Conectar;
import Modelo.Consultas;
import Modelo.DTO.CajeroDTO;
import Modelo.DTO.CuentaDTO;

public class CajeroDAO {
	
	private CajeroDTO cDTO = new CajeroDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ResultSet rs = null;
	private String msg;
	
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

	public CajeroDTO getcDTO() {
		return cDTO;
	}

	public void setcDTO(CajeroDTO cDTO) {
		this.cDTO = cDTO;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	public Conectar getCn() {
		return cn;
	}

	public void setCn(Conectar cn) {
		this.cn = cn;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
