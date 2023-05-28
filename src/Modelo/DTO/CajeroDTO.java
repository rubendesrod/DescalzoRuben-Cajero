package Modelo.DTO;

/**
 * Clase que contiene los datos de la tabla en la BB.DD
 * 
 * @version 1.0
 * @author Ruben
 */

public class CajeroDTO {

	private String estado;
	
	/**
	 * Construstor de la clase CajeroDTO
	 */
	
	public CajeroDTO() {estado = "";}
	
	/**
	 * Constructor de la clase con parametros
	 * 
	 * @param s [Estado en el que se encuentra el Cajero]
	 */
	
	public CajeroDTO(String s) {this.estado = s;}

	/**
	 * Metodo get del Estado
	 * @return String
	 */
	
	public String getEstado() {
		return estado;
	}
	
	/**
	 * Metodo set del Estado
	 * 
	 * @param estado [Estado del Cajero]
	 */

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
