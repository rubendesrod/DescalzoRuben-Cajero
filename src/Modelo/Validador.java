package Modelo;

public class Validador {
	
	private String msg;
	
	public Validador() {
		
	}
	
	public boolean validarPin(String n) {
		int num = Integer.parseInt(n);
		
		if(num > 0) {
			if(n.length() == 4) {
				this.msg = "ok";
				return true;
			}else {
				this.msg = "PIN 4 DIGITOS";
				return false;
			}
		}else {
			this.msg = "El numero debe ser mayor de 0";
			return false;
		}
	}
	
	public boolean validarNumCuenta(String n) {
		if(n.length()==24) {
			if(n.startsWith("ES")) {
				return true;
			}else {
				this.msg = "NUMERO DE CUENTA -ES...";
				return false;
			}
		}else {
			this.msg = "NUMERO CUENTA 24 DIGITOS";
			return false;
		}
	}

	public boolean validarDni(String n) {
		String patron = "\\d{8}[A-Z]";
		if(n.length()==9) {
			if(n.matches(patron)) {
				return true;
			}else {
				this.msg = "EL DNI NO CUMPLE EL PATRON";
				return false;
			}
		}else {
			this.msg = "DNI 9 DIGITOS";
			return false;
		}
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
