package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Modelo.Conectar;
import Modelo.Consultas;
import Modelo.DTO.ClienteDTO;

public class ClientesDAO implements Consultas{

	/**
	 * @author Ruben
	 * 
	 * @version 1.0
	 * 
	 * Clase que comunica clienteDTO con la BBDD
	 * 
	 */
	
	private ClienteDTO cli = new ClienteDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
	private ResultSet rs = null;
	private String msg;
	
	
	/**
	 * 
	 * @param cli
	 * 
	 * funcion que la paso un ClienteDTO y realiza la consulta para
	 * crear un cliente
	 */
	
	public void crearCliente(ClienteDTO cli) {
		this.cn = new Conectar();
		try {
			
			this.ps = this.cn.getConnect().prepareStatement(BUSCAR_CLIENTE_DNI);
			this.ps.setString(1, cli.getDni());
			this.rs = this.ps.executeQuery();
			
			if(!this.rs.next()) {
				this.ps = this.cn.getConnect().prepareStatement(INSERTAR_CLIENTE);
				this.ps.setString(1, cli.getDni());this.ps.setString(2, cli.getNombre());
				this.ps.setString(3, cli.getApell1());this.ps.setString(4, cli.getApell2());
				this.ps.setString(5, cli.getDireccion());this.ps.setString(6,cli.getCorreo());
				this.ps.setInt(7, cli.getTelefono());this.ps.setDate(8, cli.getFechaNac());
				this.ps.setString(9, "raul");
				this.msg = "El cliente ha sDNIo dado de alta";
				
				this.ps.executeUpdate();
				
			}else {
				this.msg = "El cliente ya existe";
			}
			
		}catch (Exception e) {
			this.msg = "Error no previsto: "+e;
		}finally {
			cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	/**
	 * 
	 * @param cli
	 * 
	 * funcion a la que paso un ClienteDTO para relaizar 
	 * el borrado de este de la BBDD
	 */
	
	public void eliminarCliente(ClienteDTO cli) {
		this.cn = new Conectar();
		try {
			this.ps = this.cn.getConnect().prepareStatement(BUSCAR_CLIENTE_DNI);
			this.ps.setString(1, cli.getDni());
			this.rs = this.ps.executeQuery();
			if(this.rs.next()) {
				this.ps = this.cn.getConnect().prepareStatement(BORRAR_CLIENTE);
				this.ps.setString(1, cli.getDni());
				
				this.ps.executeUpdate();
				this.msg = "El cliente se ha dado de baja con exito";
			}else {
				this.msg = "El cliente no existe";
			}
		}catch(Exception e) {
			this.msg = "Error no previsto: "+e;
		}finally {
			cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	/**
	 * 
	 * @param cli
	 * 
	 * Funion a la que paso un CLienteDTO para relizar 
	 * la busqueda de un cliente
	 */
	
	public void buscarCliente(ClienteDTO cli) {
		this.cn = new Conectar();
		this.clientes.clear();
		try {
			
		}catch(Exception e) {
			this.msg = "Error no previsto: "+e;
		}finally {
			cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	/**
	 * 
	 * @param cli
	 * 
	 * Funcion a la que paso un ClienteDTO para realizar la 
	 * modificacion de un cliente
	 */
	
	public void modificarCliente(ClienteDTO cli) {
		this.cn = new Conectar();
		this.msg = "El cliente ha sido modificado con exito";
		try {
			
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_CLIENTE_DNI);
			this.ps.setInt(1, Integer.parseInt(cli.getDni()));
			this.rs = this.ps.executeQuery();
			if(this.rs.next()==true) {
				/*Nombre*/
				if(null!=cli.getNombre()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_NOMBRE);
					this.ps.setString(1, cli.getNombre());
					this.ps.setString(2, cli.getDni());
					this.ps.executeUpdate();
				}
				/*Apell1*/
				else if(null!=cli.getApell1()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_APELLIDO1);
					this.ps.setString(1, cli.getApell1());
					this.ps.setString(2, cli.getDni());
					this.ps.executeUpdate();
				}
				/*Apell2*/
				else if(null!=cli.getApell2()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_APELLIDO2);
					this.ps.setString(1, cli.getApell2());
					this.ps.setString(2, cli.getDni());
					this.ps.executeUpdate();
				}
				/*Direccion*/
				else if(null!=cli.getDireccion()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_DIRECCION);
					this.ps.setString(1, cli.getDireccion());
					this.ps.setString(2, cli.getDni());
					this.ps.executeUpdate();
				}
				/*correo*/
				else if(null!=cli.getCorreo()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_CORREO);
					this.ps.setString(1, cli.getCorreo());
					this.ps.setString(2, cli.getDni());
					this.ps.executeUpdate();
				}
				/*Telefono*/
				else if(null!=cli.getTelefono()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_DIRECCION);
					this.ps.setInt(1, cli.getTelefono());
					this.ps.setString(2, cli.getDni());
					this.ps.executeUpdate();
				}
				/*FechaNacimiento*/
				else if(null!=cli.getFechaNac()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_FECHANACIMIENTO);
					this.ps.setDate(1, cli.getFechaNac());
					this.ps.setString(2, cli.getDni());
					this.ps.executeUpdate();
					this.rs = this.ps.executeQuery(Consultas.BUSCAR_CLIENTE_DNI);
				}
			}else {
				this.msg = "El cliente no existe";
			}
			
			
		}catch(Exception e) {
			this.msg = "Error no previsto: "+e;
		}finally {
			cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	
	
	
	public ClienteDTO getCli() {
		return cli;
	}
	public void setCli(ClienteDTO cli) {
		this.cli = cli;
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
	public ArrayList<ClienteDTO> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<ClienteDTO> clientes) {
		this.clientes = clientes;
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
