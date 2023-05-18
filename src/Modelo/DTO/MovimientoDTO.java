package Modelo.DTO;

import java.sql.Date;

public class MovimientoDTO {

	private String fecha;
	private String estado;
	private Double cantidad;
	private String numCuenta;
	private String dni;
	
	public MovimientoDTO() {
		this.fecha = null;
		this.estado = "";
		this.cantidad = 0.00;
		this.numCuenta = "";
		this.dni = "";
	}
	
	public MovimientoDTO(String fecha, String estado,Double cantidad, String num, String dni) {
		this.fecha = fecha;
		this.estado = estado;
		this.cantidad = cantidad;
		this.numCuenta = num;
		this.dni = dni;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Double getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
