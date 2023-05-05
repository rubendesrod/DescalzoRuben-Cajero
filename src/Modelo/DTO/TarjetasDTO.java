package Modelo.DTO;

import java.sql.Date;

public class TarjetasDTO {

	private Integer numTarjeta;
	private Integer pin;
	private Integer cvv;
	private Date fechaCaducidad;
	private String estado;
	private String admin;
	
	public TarjetasDTO() {
		this.numTarjeta = 0;
		this.pin = 0;
		this.cvv = 0;
		this.fechaCaducidad = null;
		this.estado = "";
		this.admin = "";
	}
	
	public TarjetasDTO(Integer numTarjeta, Integer pin, Integer cvv, Date fecha,
			String estado, String admin) {
		this.numTarjeta = numTarjeta;
		this.pin = pin;
		this.cvv = cvv;
		this.fechaCaducidad = fecha;
		this.estado = estado;
		this.admin = admin;
	}

	public Integer getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(Integer numTarjeta) {
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

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
	
}
