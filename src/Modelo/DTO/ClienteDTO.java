package Modelo.DTO;

import java.sql.Date;

public class ClienteDTO {

	private String dni;
	private String nombre;
	private String apell1;
	private String apell2;
	private String direccion;
	private Integer telefono;
	private String correo;
	private Date fechaNac;
	private String admin;
	
	public ClienteDTO() {
		this.dni = "";
		this.nombre = "";
		this.apell1 = "";
		this.apell2 = "";
		this.direccion = "";
		this.telefono = 0;
		this.correo = "";
		this.fechaNac = null;
		this.admin = "";
	}
	
	public ClienteDTO(String dni, String nombre, String apell1, String apell2, String direccion,
			Integer telefono, String correo, Date fecha, String admin) {
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
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApell1() {
		return apell1;
	}

	public void setApell1(String apell1) {
		this.apell1 = apell1;
	}

	public String getApell2() {
		return apell2;
	}

	public void setApell2(String apell2) {
		this.apell2 = apell2;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
}
