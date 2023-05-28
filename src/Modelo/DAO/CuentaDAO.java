package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Conectar;
import Modelo.Consultas;
import Modelo.DTO.CuentaDTO;

/**
 * @author Ruben
 * 
 * @version 1.0
 * 
 * Clase que comunica CuentaDTO con la BBDD
 * 
 */

public class CuentaDAO {
	
	private CuentaDTO cDTO = new CuentaDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ArrayList<CuentaDTO> cuentas = new ArrayList<CuentaDTO>();
	private ResultSet rs = null;
	private String msg;
	
	
	/**
	 * 
	 * @param cDTO
	 * 
	 * funcion que la paso un CuentaDTO y realiza la consulta para
	 * crear una cuenta
	 */
	
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
				this.ps.setString(3, cDTO.getAdmin());
				
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
	
	/**
	 * 
	 * @param cDTO
	 * 
	 * funcion a la que paso un CuentaDTO para relaizar 
	 * el borrado de este de la BBDD
	 */
	
	public void borrarCuenta(CuentaDTO cDTO) {
		this.msg = "La cuenta ha sido borrada con exito";
		this.cn = new Conectar();
		try {
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_CUENTA_NUMCUENTA);
			this.ps.setString(1, cDTO.getNumCuenta());
			this.rs = this.ps.executeQuery();
			if(this.rs.next()) {
				this.ps = this.cn.getConnect().prepareStatement(Consultas.BORRAR_CUENTA);
				this.ps.setString(1, cDTO.getNumCuenta());
			
				this.ps.executeUpdate();
			}else {
				this.msg = "La cuenta introducida no existe";
			}
		}catch(Exception e) {
			this.msg = "Error: "+e;
		}finally {
			this.cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	/**
	 * 
	 * @param cDTO
	 * 
	 * Funion a la que paso un CuentaDTO para relizar 
	 * la busqueda de una Cuenta
	 */
	
	public void buscarCuenta(CuentaDTO cDTO) {
		this.msg = "La cuenta ha sido encontrada correctamente";
		this.cn = new Conectar();
		this.cuentas.clear();
		
		try {
			if(cDTO.getNumCuenta()!=null) {
				this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_CUENTA_NUMCUENTA);
				this.ps.setString(1, cDTO.getNumCuenta());
				this.rs = this.ps.executeQuery();
				if(rs.next()) {
					this.setcDTO(new CuentaDTO());
					this.cDTO.setNumCuenta(rs.getString(1));
					this.cDTO.setSaldo(rs.getDouble(2));
					this.cDTO.setDni(rs.getString(3));
					
				}else {
					this.msg = "La cuenta no existe";
				}
			}else {
				this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_CUENTAS);
				this.rs = this.ps.executeQuery();
				while(rs.next()) {
					this.cDTO = new CuentaDTO();
					this.cDTO.setNumCuenta(rs.getString(1));
					this.cDTO.setSaldo(rs.getDouble(2));
					this.cDTO.setDni(rs.getString(3));
				this.cuentas.add(this.cDTO);
				}
			} 
		}catch (SQLException e) {
			this.msg = "Error: "+e;
		}finally {
			this.cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	
	/**
	 * 
	 * @param cDTO
	 * 
	 * Funcion a la que paso un CuentaDTO para realizar la 
	 * modificacion de una cuenta
	 */
	
	public void modificarCuenta(CuentaDTO cDTO) {
		this.msg = "La cuenta ha sido modificada correctamente";
		this.cn = new Conectar();
		try {
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_CUENTA_NUMCUENTA);
			this.ps.setString(1, cDTO.getNumCuenta());
			this.rs = this.ps.executeQuery();
			if(this.rs.next()) {
				/*Saldo*/
				if(cDTO.getSaldo()!=null) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CUENTA_SALDO);
					this.ps.setDouble(1, cDTO.getSaldo());
					this.ps.setString(2, cDTO.getNumCuenta());
					this.ps.executeUpdate();
				}
				if(cDTO.getDni()!=null){
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CUENTA_DNI);
					this.ps.setString(1, cDTO.getDni());
					this.ps.setString(2, cDTO.getNumCuenta());
				}
			}else {
				this.msg = "La cuenta introducida no ha sido encontrada";
			}
		}catch(Exception e) {
			this.msg = "Error: "+e;
		}finally {
			this.cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}

	/**
	 * Metodo get de CuentaDTO
	 * 
	 * @return CuentaDTO
	 */
	
	public CuentaDTO getcDTO() {
		return cDTO;
	}

	/**
	 * Metodo set de CuentaDTO
	 * 
	 * @param cDTO [CuentaDTO]
	 */
	
	public void setcDTO(CuentaDTO cDTO) {
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
	 * Metodo que devuelve un ArrayList de CuentaDTO
	 * 
	 * @return ArrayList de CuentaDTO
	 */

	public ArrayList<CuentaDTO> getCuentas() {
		return cuentas;
	}

	/**
	 * Metodo set de ArrayList de CuentaDTO
	 * 
	 * @param cuentas [ArrayList de CuentaDTO]
	 */
	
	public void setCuentas(ArrayList<CuentaDTO> cuentas) {
		this.cuentas = cuentas;
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
	 * @param msg [Mensaje de la consulta]
	 */
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
