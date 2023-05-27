package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Modelo.Conectar;
import Modelo.Consultas;
import Modelo.DTO.TarjetaDTO;

public class TarjetaDAO {

	/**
	 * @author Ruben
	 * 
	 * @version 1.0
	 * 
	 * Clase que comunica TarjetaDTO con la BBDD
	 * 
	 */
	
	private TarjetaDTO tDTO = new TarjetaDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ArrayList<TarjetaDTO> tarjetas = new ArrayList<TarjetaDTO>();
	private ResultSet rs = null;
	private String msg;
	
	
	/**
	 * 
	 * @param tDTO
	 * paso el Objeto de la clase TarjetaDTO
	 * para poder crear con los datos de ese objeto un registro en la BBDD
	 */
	
	public void crearTarjeta(TarjetaDTO tDTO) {
		this.cn = new Conectar();
		this.msg = "La Tarjeta sa creado con éxito";
		try {
			
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_TARJETA_NUMERO);
			this.ps.setString(1, tDTO.getNumTarjeta());
			this.rs = this.ps.executeQuery();
			if(this.rs.next()==false) {
				this.ps = this.cn.getConnect().prepareStatement(Consultas.INSERTAR_TARJETA);
				this.ps.setString(1, tDTO.getNumTarjeta());
				this.ps.setInt(2,tDTO.getPin());
				this.ps.setInt(3, tDTO.getCvv());
				this.ps.setString(4, tDTO.getFechaCaducidad());
				this.ps.setString(5, tDTO.getEstado());
				this.ps.setString(6, tDTO.getAdmin());
				
				this.ps.executeUpdate();
			}else {
				this.msg = "La Tarjeta ya existe";
			}
			
		}catch(Exception e) {
			this.msg = "Error: "+e;
		}finally {
			cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	/**
	 * 
	 * @param tDTO [Objeto de la clase TarjetaDTO]
	 * 
	 * paso un objeto del cual saco su Numero y borro de la BBDD con ese numero
	 */
	
	public void eliminarTarjeta(TarjetaDTO tDTO) {
		this.cn = new Conectar();
		this.msg = "ELIMINACION CON EXITO";
		try {
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_TARJETA_NUMERO);
			this.ps.setString(1, tDTO.getNumTarjeta());
			this.rs = this.ps.executeQuery();
			if(this.rs.next()==true) {
				this.ps = this.cn.getConnect().prepareStatement(Consultas.BORRAR_TARJETA);
				this.ps.setString(1, tDTO.getNumTarjeta());
				this.ps.executeUpdate();
			}else {
				this.msg = "La tarjeta que se intanta borrar no existe";
			}
		}catch(Exception e) {
			this.msg = "Error: "+e;
		}finally {
			cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	/**
	 * 
	 * @param tDTO [Objeto de la clase TarjetaDTO]
	 * paso el objeto de la clase para poder buscar datos necesarios de esta
	 * de la BBDD
	 */
	
	public void buscarTarjeta(TarjetaDTO tDTO) {
		this.cn = new Conectar();
		this.tarjetas.clear();
		this.msg="La tarjeta ha sido encontrada";
		try {
			if(tDTO.getNumTarjeta()!=null) {
				this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_TARJETA_NUMERO);
				this.ps.setString(1, tDTO.getNumTarjeta());
				this.rs = this.ps.executeQuery();
				if(rs.next()) {
					this.settDTO(new TarjetaDTO());
					this.tDTO.setNumTarjeta(rs.getString(1));
					this.tDTO.setPin(rs.getInt(2));
					this.tDTO.setCvv(rs.getInt(3));
					this.tDTO.setFechaCaducidad(rs.getString(4));
					this.tDTO.setEstado(rs.getString(5));
					this.tDTO.setNumCuenta(rs.getString(6));
				}
				else {
					this.msg = "La tarjeta introducida no existe";
				}
			}else {
				this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_TARJETAS);
				this.rs = this.ps.executeQuery();
				while(rs.next()) {
					this.tDTO = new TarjetaDTO();
					this.tDTO.setNumTarjeta(rs.getString(1));
					this.tDTO.setPin(rs.getInt(2));
					this.tDTO.setCvv(rs.getInt(3));
					this.tDTO.setFechaCaducidad(rs.getString(4));
					this.tDTO.setEstado(rs.getString(5));
					this.tDTO.setNumCuenta(rs.getString(6));
				this.tarjetas.add(this.tDTO);
				}
			}
		}catch(Exception e) {
			this.msg = "Error no previsto: "+e;
			System.out.println(e);
		}finally {
			cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	/**
	 * 
	 * @param tDTO [Objeto de la clase TarjetaDTO]
	 * 
	 * paso el objeto de la clase para poder modificar sus datos y mandarles a la BBDD
	 */
	
	public void modificarTarjeta(TarjetaDTO tDTO) {
		this.cn = new Conectar();
		this.msg = "La tarjeta ha sido modificada correctamente";
		try {
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_TARJETA_NUMERO);
			this.ps.setString(1, tDTO.getNumTarjeta());
			this.rs = this.ps.executeQuery();
			if(this.rs.next()==true) {
				/*PIN*/
				if(tDTO.getPin()!=null) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_TARJETA_PIN);
					this.ps.setInt(1, tDTO.getPin());
					this.ps.setString(2, tDTO.getNumTarjeta());
					this.ps.executeUpdate();
				}
				/*ESTADO*/
				if (tDTO.getEstado()!=null) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_TARJETA_ESTADO);
					this.ps.setString(1, tDTO.getEstado());
					this.ps.setString(2, tDTO.getNumTarjeta());
					this.ps.executeUpdate();
				}
				/*CVV*/
				if (tDTO.getCvv()!= null) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_TARJETA_CVV);
					this.ps.setInt(1, tDTO.getCvv());
					this.ps.setString(2, tDTO.getNumTarjeta());
					this.ps.executeUpdate();
				}
				if(tDTO.getNumCuenta()!= null) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_TARJETA_NUMCUENTA);
					this.ps.setString(1, tDTO.getNumCuenta());
					this.ps.setString(2, tDTO.getNumTarjeta());
					this.ps.executeUpdate();
				}
				
			}else {
				this.msg = "La tarjeta introducida no existe";
			}
		}catch(Exception e) {
			this.msg = "Error: "+e;
		}finally {
			cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}

	/**
	 * Metodo get de TarjetaDTO
	 * 
	 * @return TarjetaDTO
	 */
	
	public TarjetaDTO gettDTO() {
		return tDTO;
	}
	
	/**
	 * Metodo set de TarjetaDTO
	 * 
	 * @param tDTO
	 */
	
	public void settDTO(TarjetaDTO tDTO) {
		this.tDTO = tDTO;
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
	 * @param ps
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
	 * @param cn
	 */
	
	public void setCn(Conectar cn) {
		this.cn = cn;
	}

	/**
	 * Metodo que devuelve un ArrayList de TarjetaDTO
	 * 
	 * @return ArrayList de TarjetaDTO
	 */
	
	public ArrayList<TarjetaDTO> getTarjetasDTO() {
		return tarjetas;
	}

	/**
	 * Metodo set de ArrayList de TarjetaDTO
	 * 
	 * @param TarjetasDTO
	 */
	
	public void setTarjetasDTO(ArrayList<TarjetaDTO> tarjetasDTO) {
		this.tarjetas = tarjetasDTO;
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
	 * @param rs
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
	 * @param msg
	 */
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
