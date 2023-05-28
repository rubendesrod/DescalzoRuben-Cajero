package Modelo.DTO;

/**
 * Clase que contiene lo mismos datos que las tablas de la BB.DD
 * 
 * @version 1.0
 * @author Ruben
 */

public class AdminDTO {

	private String usuario;
	private String contra;
	
	/**
	 * Constructor de la clase AdminDTO
	 */
	
	public AdminDTO() {
		this.usuario = "";
		this.contra = "";
	}
	
	/**
	 * Constructor de la clase con parametros
	 * @param u [Usuario de log del admin]
	 * @param con [Contraseña del admin]
	 */
	
	public AdminDTO(String u, String con) {
		this.usuario = u;
		this.contra = con;
	}

	/**
	 * Metodo get de Usuario
	 * 
	 * @return String
	 */
	
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Metodo set de Usuario
	 * @param usuario [usuario con el que se logea el admin]
	 */
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo get de Contraseña
	 * 
	 * @return String
	 */
	
	public String getContra() {
		return contra;
	}

	/**
	 * Metodo set de Contraseña
	 * @param contra [Contraseña del administrador]
	 */
	
	public void setContra(String contra) {
		this.contra = contra;
	}
	
	
	
}
