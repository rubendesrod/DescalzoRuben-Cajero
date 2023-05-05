package Modelo.DTO;

public class PerteneceDTO {

	private String dni;
	private String numCuenta;
	
	public PerteneceDTO() {
		this.dni = "";
		this.numCuenta = "";
	}
	
	public PerteneceDTO(String dni, String num) {
		this.dni = dni;
		this.numCuenta = num;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNumCuenta() {
		return numCuenta;
	}
	
	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}
	
}
