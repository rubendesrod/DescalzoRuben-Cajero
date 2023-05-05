package Modelo;

/**
 * 
 * @author Rubens
 * 
 * @version 1.0
 * 
 * Todas las consultas que se pueden realizar al base de datos
 *
 */

public class Consultas {

	//		INSERT
	public static final String INSERTAR_CLIENTE = "insert into clientes values (?,?,?,?,?,?,?,?,?)";
	public static final String INSERTAR_TARJETA = "insert into tarjetas values (?,?,?,?,?,?)";
	public static final String INSERTAR_CUENTA = "insert into cuentas values (?,?,?)";
	public static final String INSERTAR_MOVIMIENTO = "insert into movimientos values (?,?,?,?,?)";
	public static final String INSERTAR_PERTENECE = "insert into pertenece values (?,?)";
	
	//		DELETE
	public static final String BORRAR_CLIENTE = "delete from clientes where DNI = ?";
	public static final String BORRAR_TARJETA = "delete from tarjetas where numero = ?";
	public static final String BORRAR_CUENTA = "delete from cuentas where numCuenta = ?";
	public static final String BORRAR_MOVIMIENTO = "delete from movimientos where codigo = ?";
	public static final String BORRAR_PERTENECE = "delete from pertenece where DNI = ? and numCuenta = ?";
	
	
	//UPDATE
	public static final String ACTUALIZAR_CLIENTE_NOMBRE = "update clientes set nombre = ? where DNI = ?";
	public static final String ACTUALIZAR_CLIENTE_APELLIDO1 = "update clientes set apell1 = ? where DNI = ?";
	public static final String ACTUALIZAR_CLIENTE_APELLIDO2 = "update clientes set apell2 = ? where DNI = ?";
	public static final String ACTUALIZAR_CLIENTE_DIRECCION = "update clientes set direccion = ? where DNI = ?";
	public static final String ACTUALIZAR_CLIENTE_CORREO = "UPDATE clientes SET correo = ? WHERE DNI = ?";
}
