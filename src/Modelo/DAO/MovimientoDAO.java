package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Conectar;
import Modelo.Consultas;
import Modelo.DTO.MovimientoDTO;

/**
 * Clase que se encarga de comunicar el MovimientoDTO con la BB.DD
 * 
 * @version 1.0
 * @author Ruben
 *
 */

public class MovimientoDAO{

	private MovimientoDTO mDTO = new MovimientoDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ArrayList<MovimientoDTO> movimientos = new ArrayList<MovimientoDTO>();
	private ResultSet rs = null;
	private String msg;
	
	/**
	 * Metodo que se encarga de crear un Movimiento
	 * 
	 * @param mDTO MovimientoDTO
	 */
	
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
	
	/**
	 * Metodo que se encarga de buscar un movimiento
	 * 
	 * @param mDTO MovimientoDTO
	 */
	
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
	
	/**
	 * Metodo get de MovimientoDTO
	 * 
	 * @return MovimientoDTO
	 */
	
	public MovimientoDTO getmDTO() {
		return mDTO;
	}
	
	/**
	 * Metodo set de MovimientoDTO
	 * 
	 * @param mDTO MovimientoDTO
	 */
	
	public void setmDTO(MovimientoDTO mDTO) {
		this.mDTO = mDTO;
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
	 * @param ps PreparedStatement
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
	 * @param cn Conectar
	 */
	
	public void setCn(Conectar cn) {
		this.cn = cn;
	}
	
	/**
	 * Metodo get de ArrayList de MovimientoDTO
	 * 
	 * @return Arraylist de MovimientoDTO
	 */
	
	public ArrayList<MovimientoDTO> getCuentas() {
		return movimientos;
	}
	
	/**
	 * Metodo set de ArrayList de MovimientoDTO
	 * 
	 * @param cuentas ArrayList de Movimientos
	 */
	
	public void setCuentas(ArrayList<MovimientoDTO> cuentas) {
		this.movimientos = cuentas;
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
	 * @param rs ResultSet
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
	 * @param msg Mensaje si se ha realizado la consulta o no
	 */
	
	public void setMsg(String msg) {
		this.msg = msg;
	}	
	
}
