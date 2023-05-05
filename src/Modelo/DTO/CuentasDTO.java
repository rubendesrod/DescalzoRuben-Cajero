package Modelo.DTO;

public class CuentasDTO {

	private String numCuenta;
	private Double saldo;
	private String admin;
	
	public CuentasDTO() {
		this.numCuenta = "";
		this.saldo = 0.0;
		this.admin = "";
	}
	
	public CuentasDTO(String num, Double saldo, String admin) {
		this.numCuenta = num;
		this.saldo = saldo;
		this.admin = admin;	
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
	
}
