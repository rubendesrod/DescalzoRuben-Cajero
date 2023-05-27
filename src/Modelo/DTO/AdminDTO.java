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
	 * @param u
	 * @param con
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
	 * @param usuario
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
	 * @param contra
	 */
	
	public void setContra(String contra) {
		this.contra = contra;
	}
	
	
	
}
