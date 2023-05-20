package Modelo.DTO;

import java.sql.Date;

public class TarjetaDTO {

	private String numTarjeta;
	private Integer pin;
	private Integer cvv;
	private String fechaCaducidad;
	private String estado;
	private String numCuenta;
	private String admin;
	
	public TarjetaDTO() {
		this.numTarjeta = "";
		this.pin = 0;
		this.cvv = 0;
		this.fechaCaducidad = null;
		this.estado = "";
		this.numCuenta = "";
		this.admin = "";
	}
	
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

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
	
	
}
