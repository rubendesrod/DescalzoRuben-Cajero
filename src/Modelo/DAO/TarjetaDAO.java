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
	private ArrayList<TarjetaDTO> tarjetasDTO = new ArrayList<TarjetaDTO>();
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
		this.msg = "La consulta se ha realizado con exito";
		try {
			
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_TARJETA_NUMERO);
			this.ps.setInt(1, tDTO.getNumTarjeta());
			this.rs = this.ps.executeQuery();
			if(this.rs.next()==false) {
				this.ps = this.cn.getConnect().prepareStatement(Consultas.INSERTAR_TARJETA);
				this.ps.setInt(1, tDTO.getNumTarjeta());
				this.ps.setInt(2,tDTO.getPin());
				this.ps.setInt(3, tDTO.getCvv());
				this.ps.setDate(4, tDTO.getFechaCaducidad());
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
		this.msg = "La tarjeta se ha eliminado correctamente";
		try {
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_TARJETA_NUMERO);
			this.ps.setInt(1, tDTO.getNumTarjeta());
			this.rs = this.ps.executeQuery();
			if(this.rs.next()==true) {
				this.ps = this.cn.getConnect().prepareStatement(Consultas.BORRAR_TARJETA);
				this.ps.setInt(1, tDTO.getNumTarjeta());
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
		this.tarjetasDTO.clear();
		try {
			
		}catch(Exception e) {
			this.msg = "Error no previsto: "+e;
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
			this.ps.setInt(1, tDTO.getNumTarjeta());
			this.rs = this.ps.executeQuery();
			if(this.rs.next()==true) {
				/*PIN*/
				if(tDTO.getPin()!=null) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_TARJETA_PIN);
					this.ps.setInt(1, tDTO.getPin());
					this.ps.setInt(1, tDTO.getNumTarjeta());
					this.ps.executeUpdate();
				}
				/*CVV*/
				else if (tDTO.getCvv()!= null) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_TARJETA_CVV);
					this.ps.setInt(1, tDTO.getCvv());
					this.ps.setInt(2, tDTO.getNumTarjeta());
				}
				/*ESTADO*/
				else if (tDTO.getEstado()!=null) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_TARJETA_ESTADO);
					this.ps.setString(1, tDTO.getEstado());
					this.ps.setInt(2, tDTO.getNumTarjeta());
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

	
	
	public TarjetaDTO gettDTO() {
		return tDTO;
	}

	public void settDTO(TarjetaDTO tDTO) {
		this.tDTO = tDTO;
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

	public ArrayList<TarjetaDTO> getTarjetasDTO() {
		return tarjetasDTO;
	}

	public void setTarjetasDTO(ArrayList<TarjetaDTO> tarjetasDTO) {
		this.tarjetasDTO = tarjetasDTO;
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