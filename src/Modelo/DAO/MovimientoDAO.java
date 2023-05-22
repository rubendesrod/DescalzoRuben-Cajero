package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Conectar;
import Modelo.Consultas;
import Modelo.DTO.MovimientoDTO;


public class MovimientoDAO{

	private MovimientoDTO mDTO = new MovimientoDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ArrayList<MovimientoDTO> movimientos = new ArrayList<MovimientoDTO>();
	private ResultSet rs = null;
	private String msg;
	
	
	
	public void crearMovimiento(MovimientoDTO mDTO) {
		this.msg = "creado";
		this.cn = new Conectar();
		try {
			this.ps = this.cn.getConnect().prepareStatement(Consultas.INSERTAR_MOVIMIENTO);
			this.ps.setString(1, mDTO.getFecha());
			this.ps.setString(2, mDTO.getEstado());
			this.ps.setDouble(3, mDTO.getCantidad());
			this.ps.setString(4, mDTO.getDni());
			this.ps.setString(5, mDTO.getNumCuenta());
			
			this.ps.executeUpdate();
		}catch(Exception e) {
			this.msg = "Error: "+e;
		}finally {
			this.cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	
	
	public void modificarMovmiento(MovimientoDTO mDTO) {
		
	}
	
	
	
	public void buscarMovimiento(MovimientoDTO mDTO) {
		this.msg ="Los movimientos han sido encontrados";
		this.cn = new Conectar();
		this.movimientos.clear();
		try {
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_MOVIMIENTO_NUMCUENTA);
			this.ps.setString(1, mDTO.getNumCuenta());
			this.rs = this.ps.executeQuery();
				while (rs.next()) {
					this.mDTO = new MovimientoDTO();
					this.mDTO.setFecha(rs.getString(1));
					this.mDTO.setEstado(rs.getString(2));
					this.mDTO.setCantidad(rs.getDouble(3));
					this.mDTO.setDni(rs.getString(4));
					this.mDTO.setNumCuenta(rs.getString(5));
					this.movimientos.add(this.mDTO);			
				}
		}catch (SQLException e) {
			this.msg = "Error: "+e;
		}finally {
			this.cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	
	
	public MovimientoDTO getmDTO() {
		return mDTO;
	}
	
	public void setmDTO(MovimientoDTO mDTO) {
		this.mDTO = mDTO;
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
	public ArrayList<MovimientoDTO> getCuentas() {
		return movimientos;
	}
	public void setCuentas(ArrayList<MovimientoDTO> cuentas) {
		this.movimientos = cuentas;
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
