package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Modelo.Conectar;
import Modelo.Consultas;
import Modelo.DTO.ClienteDTO;

/**
 * Clase que implementa Consultas
 * Es la que comunica con la tabla clientes de la BB.DD
 * 
 * @version 1.0
 * @author Ruben
 *
 */

public class ClientesDAO implements Consultas{

	
	private ClienteDTO cli = new ClienteDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ArrayList<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
	private ResultSet rs = null;
	private String msg;
	
	
	/**
	 * 
	 * @param cDTO
	 * 
	 * funcion que la paso un ClienteDTO y realiza la consulta para
	 * crear un cliente
	 */
	
	public void crearCliente(ClienteDTO cDTO) {
		this.cn = new Conectar();
		try {
			
			this.ps = this.cn.getConnect().prepareStatement(BUSCAR_CLIENTE_DNI);
			this.ps.setString(1, cDTO.getDni());
			this.rs = this.ps.executeQuery();
			if(!this.rs.next()) {
				this.ps = this.cn.getConnect().prepareStatement(INSERTAR_CLIENTE);
				this.ps.setString(1, cDTO.getDni());this.ps.setString(2, cDTO.getNombre());
				this.ps.setString(3, cDTO.getApell1());this.ps.setString(4, cDTO.getApell2());
				this.ps.setString(5, cDTO.getDireccion());this.ps.setString(6,cDTO.getCorreo());
				this.ps.setString(7, cDTO.getTelefono());this.ps.setString(8, cDTO.getFechaNac());
				this.ps.setString(9, cDTO.getAdmin());
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
	 * @param cDTO
	 * 
	 * funcion a la que paso un ClienteDTO para relaizar 
	 * el borrado de este de la BBDD
	 */
	
	public void eliminarCliente(ClienteDTO cDTO) {
		this.cn = new Conectar();
		try {
			this.ps = this.cn.getConnect().prepareStatement(BUSCAR_CLIENTE_DNI);
			this.ps.setString(1, cDTO.getDni());
			this.rs = this.ps.executeQuery();
			if(this.rs.next()) {
				this.ps = this.cn.getConnect().prepareStatement(BORRAR_CLIENTE);
				this.ps.setString(1, cDTO.getDni());
				
				this.ps.executeUpdate();
				this.msg = "El cliente se ha dado de baja";
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
	 * @param cDTO
	 * 
	 * Funion a la que paso un CLienteDTO para relizar 
	 * la busqueda de un cliente
	 */
	
	public void buscarCliente(ClienteDTO cDTO) {
		this.cn = new Conectar();
		this.msg = "El cliente ha sido encontrado";
		this.clientes.clear();
		try {
			if(cDTO.getDni()!=null) {
				this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_CLIENTE_DNI);
				this.ps.setString(1, cDTO.getDni());
				this.rs = this.ps.executeQuery();
				if(rs.next()) {
					this.setCli(new ClienteDTO());
					this.cli.setDni(rs.getString(1));
					this.cli.setNombre(rs.getString(2));
					this.cli.setApell1(rs.getString(3));
					this.cli.setApell2(rs.getString(4));
					this.cli.setDireccion(rs.getString(5));
					this.cli.setCorreo(rs.getString(6));
					this.cli.setTelefono(rs.getString(7));
					this.cli.setFechaNac(rs.getString(8));
				}else {
					this.msg = "El cliente introducido no existe";
				}
			}else {
				this.ps = this.cn.getConnect().prepareStatement(BUSCAR_CLIENTES);
				this.rs = this.ps.executeQuery();
				while(rs.next()) {
					this.cli = new ClienteDTO();
					this.cli.setDni(rs.getString(1));
					this.cli.setNombre(rs.getString(2));
					this.cli.setApell1(rs.getString(3));
					this.cli.setApell2(rs.getString(4));
					this.cli.setDireccion(rs.getString(5));
					this.cli.setCorreo(rs.getString(6));
					this.cli.setTelefono(rs.getString(7));
					this.cli.setFechaNac(rs.getString(8));
				this.clientes.add(this.cli);
				}
			}
		}catch(Exception e) {
			this.msg = "Error no previsto: "+e;
		}finally {
			cn.cerrarConexion(this.rs, this.cn.getConnect(), this.ps);
		}
	}
	
	/**
	 * @param cDTO
	 * 
	 * Funcion a la que paso un ClienteDTO para realizar la 
	 * modificacion de un cliente
	 */
	
	public void modificarCliente(ClienteDTO cDTO) {
		this.cn = new Conectar();
		this.msg = "El cliente ha sido modificado con exito";
		try {
			
			this.ps = this.cn.getConnect().prepareStatement(Consultas.BUSCAR_CLIENTE_DNI);
			this.ps.setString(1, cDTO.getDni());
			this.rs = this.ps.executeQuery();
			if(this.rs.next()==true) {
				/*Nombre*/
				if(null!=cDTO.getNombre()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_NOMBRE);
					this.ps.setString(1, cDTO.getNombre());
					this.ps.setString(2, cDTO.getDni());
					this.ps.executeUpdate();
				}
				/*Apell1*/
				if(null!=cDTO.getApell1()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_APELLIDO1);
					this.ps.setString(1, cDTO.getApell1());
					this.ps.setString(2, cDTO.getDni());
					this.ps.executeUpdate();
				}
				/*Apell2*/
				if(null!=cDTO.getApell2()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_APELLIDO2);
					this.ps.setString(1, cDTO.getApell2());
					this.ps.setString(2, cDTO.getDni());
					this.ps.executeUpdate();
				}
				/*Direccion*/
				if(null!=cDTO.getDireccion()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_DIRECCION);
					this.ps.setString(1, cDTO.getDireccion());
					this.ps.setString(2, cDTO.getDni());
					this.ps.executeUpdate();
				}
				/*correo*/
				if(null!=cDTO.getCorreo()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_CORREO);
					this.ps.setString(1, cDTO.getCorreo());
					this.ps.setString(2, cDTO.getDni());
					this.ps.executeUpdate();
				}
				/*Telefono*/
				if(null!=cDTO.getTelefono()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_TELEFONO);
					this.ps.setString(1, cDTO.getTelefono());
					this.ps.setString(2, cDTO.getDni());
					this.ps.executeUpdate();
				}
				/*FechaNacimiento*/
				if(null!=cDTO.getFechaNac()) {
					this.ps = this.cn.getConnect().prepareStatement(Consultas.ACTUALIZAR_CLIENTE_FECHANACIMIENTO);
					this.ps.setString(1, cDTO.getFechaNac());
					this.ps.setString(2, cDTO.getDni());
					this.ps.executeUpdate();
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
	
	
	/**
	 * Metodo get de ClienteDTO
	 * 
	 * @return ClienteDTO
	 */
	
	public ClienteDTO getCli() {
		return cli;
	}
	
	/**
	 * Metodo set de ClienteDTO
	 * 
	 * @param cDTO [ClienteDTO]
	 */
	
	public void setCli(ClienteDTO cDTO) {
		this.cli = cDTO;
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
	 * Metodo que devuelve un ArrayList de ClienteDTO
	 * 
	 * @return ArrayList de ClienteDTO
	 */
	
	public ArrayList<ClienteDTO> getClientes() {
		return clientes;
	}
	
	/**
	 * Metodo set del ArrayList de cliente
	 * 
	 * @param clientes [ArrayList de clientes]
	 */
	
	public void setClientes(ArrayList<ClienteDTO> clientes) {
		this.clientes = clientes;
	}
	
	/**
	 * Metodo get de ResultSet
	 * 
	 * @return ResultSet [Contiene los resultados de la consulta]
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
	 * @param msg [mensaje]
	 */
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
