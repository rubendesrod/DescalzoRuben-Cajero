package Modelo.DTO;

import java.sql.Date;

public class MovimientoDTO {

	private int cod;
	private Date fecha;
	private String estado;
	private String numCuenta;
	private String dni;
	
	public MovimientoDTO() {
		this.cod = 0;
		this.fecha = null;
		this.estado = "";
		this.numCuenta = "";
		this.dni = "";
	}
	
	public MovimientoDTO(int cod, Date fecha, String estado, String num, String dni) {
		this.cod = cod;
		this.fecha = fecha;
		this.estado = estado;
		this.numCuenta = num;
		this.dni = dni;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
