package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Modelo.Conectar;
import Modelo.Consultas;
import Modelo.DTO.CuentaDTO;

public class CuentaDAO {

	/**
	 * @author Ruben
	 * 
	 * @version 1.0
	 * 
	 * Clase que comunica CuentaDTO con la BBDD
	 * 
	 */
	
	private CuentaDTO cDTO = new CuentaDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ArrayList<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();
	private ResultSet rs = null;
	private String msg;
	
	public void crearCuenta(CuentaDTO cDTO) {
		this.msg = "La cuenta ha sido creada correctamente";
		this.cn = new Conectar();
		try {
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_CUENTA_NUMCUENTA);
			this.ps.setString(1, cDTO.getNumCuenta());
			this.rs = this.ps.executeQuery();
			if(!this.rs.next()) {
				this.ps = this.cn.getConnect().prepareStatement(Consultas.INSERTAR_CUENTA);
				this.ps.setString(1, cDTO.getNumCuenta());
				this.ps.setDouble(2, cDTO.getSaldo());
				this.ps.setString(2, cDTO.getAdmin());
				
				this.ps.executeUpdate();
			}
			else {
				this.msg = "La cuenta ya existe";
			}
		}catch(Exception e) {
			this.msg = "Error: "+e;
		}finally {
			this.cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	public void borrarCuenta() {
		
	}
	
	public void buscarCuenta() {
		
	}
	
	public void modificarCuenta() {
		
	}

	public CuentaDTO getcDTO() {
		return cDTO;
	}

	public void setcDTO(CuentaDTO cDTO) {
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

	public ArrayList<CuentaDTO> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<CuentaDTO> cuentas) {
		this.cuentas = cuentas;
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
