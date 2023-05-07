package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Modelo.Conectar;
import Modelo.Consultas;
import Modelo.DTO.ClientesDTO;

public class clientesDAO implements Consultas{

	/**
	 * @author Ruben
	 * 
	 * @version 1.0
	 * 
	 * Clase que comunica clienteDTO con la BBDD
	 * 
	 */
	
	private ClientesDTO cli = new ClientesDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ArrayList<ClientesDTO> clientes = new ArrayList<ClientesDTO>();
	private ResultSet rs = null;
	private String msg;
	
	
	/**
	 * 
	 * @param cli
	 * 
	 * funcion que la paso un ClienteDTO y realiza la consulta para
	 * crear un cliente
	 */
	public void crearCliente(ClientesDTO cli) {
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
				this.msg = "El cliente ha sido dado de alta";
				
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
	public void eliminarCliente(ClientesDTO cli) {
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
	
	public void buscarCliente(ClientesDTO cli) {
		this.cn = new Conectar();
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
	
	public void modificarCliente(ClientesDTO cli) {
		this.cn = new Conectar();
		try {
			
		}catch(Exception e) {
			this.msg = "Error no previsto: "+e;
		}finally {
			cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	
	
	
	public ClientesDTO getCli() {
		return cli;
	}
	public void setCli(ClientesDTO cli) {
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
	public ArrayList<ClientesDTO> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<ClientesDTO> clientes) {
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
