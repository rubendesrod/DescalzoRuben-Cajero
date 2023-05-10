package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Modelo.Conectar;
import Modelo.Consultas;
import Modelo.DTO.MovimientoDTO;


public class MovimientoDAO implements Consultas{

	private MovimientoDTO mDTO = new MovimientoDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ArrayList<MovimientoDTO> cuentas = new ArrayList<MovimientoDTO>();
	private ResultSet rs = null;
	private String msg;
	
	
	
	public void crearMovimiento(MovimientoDTO mDTO, String dni, String numCuenta) {
		this.msg = "creado";
		this.cn = new Conectar();
		int cod = 1;
		try {
			this.ps = this.cn.getConnect().prepareStatement(Consultas.INSERTAR_MOVIMIENTO);
			this.ps.setInt(1, cod);
			this.ps.setDate(2, mDTO.getFecha());
			this.ps.setString(3, mDTO.getEstado());
			this.ps.setString(4, numCuenta);
			this.ps.setString(5, dni);
			
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
		
	}
	
	
	
	public MovimientoDTO getmDTO(MovimientoDTO mDTO) {
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
		return cuentas;
	}
	public void setCuentas(ArrayList<MovimientoDTO> cuentas) {
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
