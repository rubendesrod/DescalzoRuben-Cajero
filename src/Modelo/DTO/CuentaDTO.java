package Modelo.DTO;

/**
 * Clase que contiene los datos de la tabla en la BB.DD
 * 
 * @version 1.0
 * @author Ruben
 */

public class CuentaDTO {

	private String numCuenta;
	private Double saldo;
	private String dni;
	private String admin;
	
	/**
	 * Constructor de la clase CuentaDTO
	 */
	
	public CuentaDTO() {
		this.numCuenta = "";
		this.saldo = 0.0;
		this.dni = "";
		this.admin = "admin";
	}
	
	/**
	 * Constructor de la clase CuentaDTO con parametros
	 * @param num [Numero de Cuenta]
	 * @param saldo [Saldo de la Cuenta]
	 * @param dni [DNI del cliente]
	 * @param admin [Usuario Administrador]
	 */
	
	public CuentaDTO(String num, Double saldo,String dni, String admin) {
		this.numCuenta = num;
		this.saldo = saldo;
		this.dni = dni;
		this.admin = admin;	
	}

	/**
	 * Metodo get del Numero de Cuenta
	 * @return String
	 */
	
	public String getNumCuenta() {
		return numCuenta;
	}

	/**
	 * Metodo set del Numero de cuenta
	 * @param numCuenta [Numero de Cuenta]
	 */
	
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	/**
	 * Metodo set del Sado
	 * @return Double
	 */
	
	public Double getSaldo() {
		return saldo;
	}

	/**
	 * Metodo set del Saldo
	 * @param saldo Saldo de la Cuenta
	 */
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
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
	 * @param dni DNI del cliente
	 */
	
	public void setDni(String dni) {
		this.dni = dni;
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
