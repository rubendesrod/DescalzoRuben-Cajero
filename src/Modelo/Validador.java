package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Validador {
	
	private String msg;
	
	public Validador() {
		this.msg = null;
	}

	//Validadores de Tarjeta
	
	public boolean validarNumTarjeta(String n) {
		if (n.matches("\\d+")) {
	        int num = Integer.parseInt(n);
	        
	        if (num > 0) {
	            if (n.length() == 16) {
	                return true;
	            } else {
	                this.msg = "Número debe tener 16 dígitos";
	                return false;
	            }
	        } else {
	            this.msg = "El número debe ser mayor a 0";
	            return false;
	        }
	    } else {
	        this.msg = "El número debe contener solo números";
	        return false;
	    }		
	}
	
	public boolean validarPin(String n) {
		if (n.matches("\\d+")) {
	        int num = Integer.parseInt(n);
	        if (num > 0) {
	            if (n.length() == 4) {
	                this.msg = "ok";
	                return true;
	            } else {
	                this.msg = "PIN debe tener 4 dígitos";
	                return false;
	            }
	        } else {
	            this.msg = "El PIN debe ser mayor a 0";
	            return false;
	        }
	    } else {
	        this.msg = "El PIN debe contener solo números";
	        return false;
	    }
	}
	
	public boolean validarCvv(String n) {
		 if (n.matches("\\d+")) {
		        int num = Integer.parseInt(n);
		        if (num > 0) {
		            if (n.length() == 3) {
		                this.msg = "ok";
		                return true;
		            } else {
		                this.msg = "CVV debe tener 3 dígitos";
		                return false;
		            }
		        } else {
		            this.msg = "El CVV debe ser mayor a 0";
		            return false;
		        }
		    } else {
		        this.msg = "El CVV debe contener solo números";
		        return false;
		    }
	}
	
	public boolean validarFechaTarjeta(String n) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String patron = "\\([0-9]{4,})([-])([0-9]{2,})([-])([0-9]{2,})";
		LocalDate fechaTarjeta = LocalDate.parse(n,formato);
		LocalDate fechaActual = LocalDate.now();
		int comp = fechaTarjeta.compareTo(fechaActual);
		if(comp > 0) {
			if(n.matches(patron)) {
				return true;
			}else {
				this.msg = "PATRON DE FECHA yyyy-MM-dd";
				return false;
			}
		}else {
			this.msg = "La fecha no puede ser MEnor que la actual";
			return false;
		}
	}
	
	//Validadores de Cuenta
	
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

	public boolean validarSaldo(String n) {
		Double num = Double.parseDouble(n);
		if(num > 0) {
			return true;
		}else {
			this.msg = "SALDO MAYOR DE 0";
			return false;
		}
	}
	
	//Validadores de Cliente
	
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
	
	public boolean validarNombreApellDir(String n) {
		if(n.length()<=20) {
			return true;
		}else {
			this.msg = "NOMBRE APELLIDOS O DIRECCION SUPERAN 20 DIGITOS";
			return false;
		}
	}
	
	public boolean validarCorreo(String n) {
		if(n.length()<=40) {
			return true;
		}else {
			this.msg = "CORREO 40 DIGITOS MAX";
			return false;
		}
	}
	
	public boolean validarTelefono(String n) {
		if(n.length()==9) {
			return true;
		}else {
			this.msg = "TELEFONO 9 DIGITOS";
			return false;
		}
	}
	
	public boolean validarFechaNac(String n) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String patron = "\\([0-9]{4,})([-])([0-9]{2,})([-])([0-9]{2,})";
		LocalDate fechaNac = LocalDate.parse(n,formato);
		LocalDate fechaActual = LocalDate.now();
		int comp = fechaNac.compareTo(fechaActual);
		if(comp > 0) {
			if(n.matches(patron)) {
				return true;
			}else {
				this.msg = "PATRON DE FECHA yyyy-MM-dd";
				return false;
			}
		}else {
			this.msg = "La fecha no puede ser Mayor que la actual";
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
