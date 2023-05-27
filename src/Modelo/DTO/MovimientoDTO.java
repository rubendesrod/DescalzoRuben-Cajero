package Modelo.DTO;

/**
 * Clase que contiene los datos de la tabla en la BB.DD
 * 
 * @version 1.0
 * @author Ruben
 */

public class MovimientoDTO {

	private String fecha;
	private String estado;
	private Double cantidad;
	private String numCuenta;
	private String dni;
	
	/**
	 * Constructor de la clase MovimientoDTO
	 */
	
	public MovimientoDTO() {
		this.fecha = null;
		this.estado = "";
		this.cantidad = 0.00;
		this.numCuenta = "";
		this.dni = "";
	}
	
	/**
	 * Constructor de la clase MovimientoDTO con parametros
	 * @param fecha
	 * @param estado
	 * @param cantidad
	 * @param num
	 * @param dni
	 */
	
	public MovimientoDTO(String fecha, String estado,Double cantidad, String num, String dni) {
		this.fecha = fecha;
		this.estado = estado;
		this.cantidad = cantidad;
		this.numCuenta = num;
		this.dni = dni;
	}

	/**
	 * Metodo get de la Fecha
	 * @return String
	 */
	
	public String getFecha() {
		return fecha;
	}

	/**
	 * Metodo set de la Fehca
	 * @param fecha
	 */
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Metodo get del Estado
	 * @return String
	 */
	
	public String getEstado() {
		return estado;
	}

	/**
	 * Metodo set del Estado
	 * @param estado
	 */
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * Metodo get de la Cantidad
	 * @return Double
	 */
	
	public Double getCantidad() {
		return cantidad;
	}
	
	/**
	 * Metodo set de la Cantidad
	 * @param cantidad
	 */
	
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Metodo get del Numero de Cuenta
	 * @return String
	 */
	
	public String getNumCuenta() {
		return numCuenta;
	}

	/**
	 * Metodo set del Numero de Cuenta
	 * @param numCuenta
	 */
	
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
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
	
	
}
