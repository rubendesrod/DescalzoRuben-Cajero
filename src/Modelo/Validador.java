package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

/**
 * Clase que se encarga de recibir los datos y validar si cada uno de ellos
 * tiene el formato correcto
 * 
 * @version 1.0
 * @author Ruben
 *
 */

public class Validador {
	
	private String msg;
	
	/**
	 * Constructor de la clase
	 */
	
	public Validador() {
		this.msg = null;
	}

//Validadores de Tarjeta
	
	/**
	 * Funcion que valida el Numero de una Tarjeta
	 * 
	 * @param n
	 * @return true, si tiene el formato correcto.
	 * @return false, si no tiene el formato correcto.
	 */
	
	public boolean validarNumTarjeta(String n) {
		if (!n.matches("\\d+")) {
			this.msg = "NumTarjeta Solo Numeros";
			return false;
	    }else {
	    	if(n.length() == 16) {
	    		return true;
	    	}else {
	    		this.msg = "NumTarjeta 16 DIGITOS";
	    		return false;
	    	}
	    }
		
	}
	
	/**
	 * Funcion que valida el PIN de una Tarjeta
	 * 
	 * @param n
	 * @return true, si tiene el formato correcto.
	 * @return false, si no tiene el formato correcto.
	 */
	
	public boolean validarPin(String n) {
		if (n.matches("\\d{4}") && n.length() == 4) {
	        return true;
	    } else {
	    	this.msg = "PIN 4 DIGITOS, SOLO NUMEROS";
	        return false;
	    }
	}
	
	/**
	 * Funcion que valida el Numero de una Tarjeta
	 * 
	 * @param n
	 * @return true, si tiene el formato correcto.
	 * @return false, si no tiene el formato correcto.
	 */
	
	public boolean validarCvv(String n) {
		if (n.matches("\\d{3}") && n.length() == 3) {
	        return true;
	    } else {
	    	this.msg = "CVV 4 DIGITOS, SOLO NUMEROS";
	        return false;
	    }
	}
	
	/**
	 * Funcion que valida la Fecha de una Tarjeta
	 * 
	 * @param n
	 * @return true, si tiene el formato correcto.
	 * @return false, si no tiene el formato correcto.
	 */
	
	public boolean validarFechaTarjeta(String n) {
		 String patron = "yyyy-MM-dd";
		    try {
		        LocalDate fechaIngresada = LocalDate.parse(n, DateTimeFormatter.ofPattern(patron));
		        LocalDate fechaActual = LocalDate.now();
		        if(fechaIngresada.isAfter(fechaActual)) {
		        	return true;
		        }else {
		        	this.msg = "LA FECHA ES MENOR QUE LA ACTUAL";
		        	return false;
		        }
		    } catch (DateTimeParseException e) {
		    	this.msg = "FORMATO DE FECHA ERRONEO";
		        return false;
		    }
	}
	
//Validadores de Cuenta
	
	/**
	 * Funcion que valida el Numero de una Cuenta
	 * 
	 * @param n
	 * @return true, si tiene el formato correcto.
	 * @return false, si no tiene el formato correcto.
	 */
	
	public boolean validarNumCuenta(String n) {
		 String patron = "^ES\\d{22}$";
		 if(n.matches(patron)) {
			 return true;
		 }else {
			 this.msg = "NumCuenta 24 DIGITOS y ES..";
			 return false;
		 }
	}

	/**
	 * Funcion que valida el Saldo de una Cuenta
	 * 
	 * @param n
	 * @return true, si tiene el formato correcto.
	 * @return false, si no tiene el formato correcto.
	 */
	
	public boolean validarSaldo(String n) {
		 try {
		        double saldo = Double.parseDouble(n);
		        if(saldo > 0) {
		        	return true;
		        }else {
		        	this.msg = "Saldo mayor que 0";
		        	return false;
		        }
		    } catch (NumberFormatException e) {
		    	this.msg = "SALDO SON NUMEROS";
		        return false;
		    }
	}
	
	//Validadores de Cliente
	
	/**
	 * Funcion que valida el DNI de un Cliente
	 * 
	 * @param n
	 * @return true, si tiene el formato correcto.
	 * @return false, si no tiene el formato correcto.
	 */
	
	public boolean validarDni(String n) {
		if (n.length() != 9) {
			this.msg = "DNI 9 DIGITOS";
	        return false;
	    }
		//Parto el string que ha sido pasado y le divido por numero y la ultima letra
	    String numeros = n.substring(0, 8);
	    String letra = n.substring(8);
	    //creo el try para cuando haga el parseInt no de error
	    try {
	    	//Parseo los numeros
	        Integer.parseInt(numeros);
	        if(letra.matches("[a-zA-Z]")) {
	        	return true;
	        }else {
	        	this.msg = "LETRA CARACTER NO VALIDO DNI";
	        	return false;
	        }
	    } catch (NumberFormatException e) {
	    	this.msg = "Tienen que ser numero";
	        return false;
	    }
	}
	
	/**
	 * Funcion que valida el Nombre, los dos apellidos y la Direccion de un Cliente
	 * 
	 * @param n
	 * @return true, si tiene el formato correcto.
	 * @return false, si no tiene el formato correcto.
	 */
	
	public boolean validarNombreApellDir(String n) {
		if(n.length()<=20) {
			return true;
		}else {
			this.msg = "NOMBRE APELLIDOS O DIRECCION SUPERAN 20 DIGITOS";
			return false;
		}
	}
	
	/**
	 * Funcion que valida el correo de un Cliente
	 * 
	 * @param n
	 * @return true, si tiene el formato correcto.
	 * @return false, si no tiene el formato correcto.
	 */
	
	public boolean validarCorreo(String n) {
		if (n.length() > 40) {
			this.msg = "CORREO max 40 caracteres";
			return false;
	    }else {
	    	return true;
	    }
	}
	
	/**
	 * Funcion que valida el Telefono de un Cliente
	 * 
	 * @param n
	 * @return true, si tiene el formato correcto.
	 * @return false, si no tiene el formato correcto.
	 */
	
	public boolean validarTelefono(String n) {
		  if (n.length() != 9) {
			  this.msg = "TELEFONO 9 DIGITOS";
		      return false;
		    }

		    try {
		    	Integer.parseInt(n);
		    	return true;
		    }catch(NumberFormatException e) {
		    	this.msg = "TELEFONO SOLO NUMEROS";
		    	return false;
		    }    
	}
	
	/**
	 * Funcion que valida la fecha de Nacimiento de un Cliente
	 * 
	 * @param n
	 * @return true, si tiene el formato correcto.
	 * @return false, si no tiene el formato correcto.
	 */
	
	public boolean validarFechaNac(String n) {
		String patron = "yyyy-MM-dd";
	    try {
	        LocalDate fechaIngresada = LocalDate.parse(n, DateTimeFormatter.ofPattern(patron));
	        LocalDate fechaActual = LocalDate.now();
	        if(fechaIngresada.isBefore(fechaActual)) {
	        	return true;
	        }else {
	        	this.msg = "LA FECHA ES MAYOR QUE LA ACTUAL";
	        	return false;
	        }
	    } catch (DateTimeParseException e) {
	    	this.msg = "FORMATO DE FECHA ERRONEO";
	        return false;
	    }
	}
	
	/**
	 * Metodo get de Msg
	 * 
	 * @return String
	 */
	
	public String getMsg() {
		return msg;
	}

	/**
	 * Metodo set de Msg
	 * 
	 * @param msg
	 */
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
