package Modelo.DTO;

/**
 * Clase que contiene los datos de la tabla en la BB.DD
 * 
 * @version 1.0
 * @author Ruben
 */

public class TarjetaDTO {

	private String numTarjeta;
	private Integer pin;
	private Integer cvv;
	private String fechaCaducidad;
	private String estado;
	private String numCuenta;
	private String admin;
	
	/**
	 * Constructor de la clase TarjetaDTO
	 */
	
	public TarjetaDTO() {
		this.numTarjeta = "";
		this.pin = 0;
		this.cvv = 0;
		this.fechaCaducidad = null;
		this.estado = "";
		this.numCuenta = "";
		this.admin = "admin";
	}
	
	/**
	 * COnstructor de la clase TarjetaDTO con parametros
	 * @param numTarjeta Numero de la Tarjeta
	 * @param pin Pin de la Tarjeta
	 * @param cvv CVV de la tarjeta
	 * @param fecha Fecha de Validez de la Tarjeta
	 * @param estado Estado en el que se encuentra la tarjeta
	 * @param numCuenta Numero de cuenta al que esta asociado esa Tarjeta
	 * @param admin usuario del administrador
	 */
	
	public TarjetaDTO(String numTarjeta, Integer pin, Integer cvv, String fecha,
			String estado,String numCuenta, String admin) {
		this.numTarjeta = numTarjeta;
		this.pin = pin;
		this.cvv = cvv;
		this.fechaCaducidad = fecha;
		this.estado = estado;
		this.numCuenta = numCuenta;
		this.admin = admin;
	}

	/**
	 * Metodo get del Numero de la Tarjeta
	 * @return String
	 */
	
	public String getNumTarjeta() {
		return numTarjeta;
	}

	/**
	 * Metodo set del Numero de la Tarjeta
	 * @param numTarjeta Numero de la Tarjeta
	 */
	
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	/**
	 * Metodo get del PIN
	 * @return Integer
	 */
	
	public Integer getPin() {
		return pin;
	}

	/**
	 * Metodo set del PIN
	 * @param pin PIN de la Tarjeta
	 */
	
	public void setPin(Integer pin) {
		this.pin = pin;
	}

	/**
	 * Metodo get del CVV
	 * @return Integer
	 */
	
	public Integer getCvv() {
		return cvv;
	}

	/**
	 * Metodo set del CVV
	 * @param cvv CVV de la Tarjeta
	 */
	
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	/**
	 * Metodo get de la Fecha de Validez
	 * @return String
	 */
	
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	/**
	 * Metodo set de la Fecha de Validez
	 * @param fechaCaducidad Fecha de validez de la tarjeta
	 */
	
	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
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
	 * @param estado Estado en que se ecuentra la Tarjeta
	 */
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * Metodo get del Numero de Cuenta
	 * @return String
	 */
	
	public String getNumCuenta() {
		return numCuenta;
	}

	/**
	 * Metodo set del Numero de la Cuenta
	 * @param numCuenta Numero de Cuenta de la Tarjeta
	 */
	
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	/**
	 * Metodo get del Admin
	 * @return String
	 */
	
	public String getAdmin() {
		return admin;
	}

	/**
	 * Metodo set del Admin
	 * @param admin Usuario Administrador
	 */
	
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
	
	
}
