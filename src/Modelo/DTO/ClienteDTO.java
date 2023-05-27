package Modelo.DTO;

import java.sql.Date;

/**
 * Clase que contiene los datos de la tabla en la BB.DD
 * 
 * @version 1.0
 * @author Ruben
 */

public class ClienteDTO {

	private String dni;
	private String nombre;
	private String apell1;
	private String apell2;
	private String direccion;
	private String telefono;
	private String correo;
	private String fechaNac;
	private String admin;
	
	/**
	 * Constructor de la clase
	 */
	
	public ClienteDTO() {
		this.dni = "";
		this.nombre = "";
		this.apell1 = "";
		this.apell2 = "";
		this.direccion = "";
		this.telefono = "";
		this.correo = "";
		this.fechaNac = null;
		this.admin = "admin";
	}
	
	/**
	 * Constructor de la clase con parametros
	 * @param dni
	 * @param nombre
	 * @param apell1
	 * @param apell2
	 * @param direccion
	 * @param telefono
	 * @param correo
	 * @param fecha
	 * @param admin
	 */
	
	public ClienteDTO(String dni, String nombre, String apell1, String apell2, String direccion,
			String telefono, String correo, String fecha, String admin) {
		this.dni = dni;
		this.nombre = nombre;
		this.apell1 = apell1;
		this.apell2 = apell2;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaNac = fecha;
		this.admin = admin;
	}
	
	/**
	 * Metodo get del DNI
	 * @return String
	 */
	
	public String getDni() {
		return dni;
	}
	
	/**
	 * Metodo set del DNI
	 * @param dni
	 */
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Metodo get del Nombre
	 * @return String
	 */
	
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo set del nombre
	 * @param nombre
	 */
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo get del Primer Apellido
	 * @return String
	 */
	
	public String getApell1() {
		return apell1;
	}

	/**
	 * Metodo set del Primer Apellido
	 * @param apell1
	 */
	
	public void setApell1(String apell1) {
		this.apell1 = apell1;
	}

	/**
	 * Metodo get del Segundo Apellido
	 * @return String
	 */
	
	public String getApell2() {
		return apell2;
	}

	/**
	 * Metodo set del Segundo Apellido
	 * @param apell2
	 */
	
	public void setApell2(String apell2) {
		this.apell2 = apell2;
	}

	/**
	 * Metodo get de la Direccion
	 * @return String
	 */
	
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Metodo set de la Direccion
	 * @param direccion
	 */
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Metodo get del Telefono
	 * @return String
	 */

	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Metodo set del Telefono
	 * @param telefono
	 */

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Metodo get del Correo
	 * @return String
	 */
	
	public String getCorreo() {
		return correo;
	}

	/**
	 * Metodo set del Correo
	 * @param correo
	 */
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Metodo get de la fecha de Nacimiento
	 * @return String
	 */
	
	public String getFechaNac() {
		return fechaNac;
	}

	/**
	 * Metodo set de la Fecha de Nacimiento
	 * @param fechaNac
	 */
	
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	/**
	 * Metodo get del Administrador
	 * @return String
	 */
	
	public String getAdmin() {
		return admin;
	}

	/**
	 * Metotodo set del Administrador
	 * @param admin
	 */
	
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
}
