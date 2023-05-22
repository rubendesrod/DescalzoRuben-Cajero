package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.Conectar;
import Modelo.DTO.AdminDTO;

public class AdminDAO {

	private AdminDTO adm = new AdminDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ResultSet rs = null;
	private String msg;
	
	public boolean buscarAdmin(AdminDTO aDTO) {
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
		return true;
	}

	public AdminDTO getAdm() {
		return adm;
	}

	public void setAdm(AdminDTO adm) {
		this.adm = adm;
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

/*this.ps = this.cn.getConnect().prepareStatement("select usuario from administrador where usuario = ?");
this.ps.setString(1, aDTO.getUsuario());
this.rs = this.ps.executeQuery();
if(rs.next()) {
	adm.setUsuario(this.rs.getNString(1));
	adm.setContra(rs.getString(2));
	if(aDTO.getUsuario().equalsIgnoreCase(adm.getUsuario()) && aDTO.getContra().equals(adm.getContra())) {
		re = true;
	}
}else {
	this.msg = "El administrador no se ha encontrado";
	this.cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
	return false;
}*/