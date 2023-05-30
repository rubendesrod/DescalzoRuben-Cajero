package Modelo;

/**
 * 
 * @author Ruben
 * 
 * @version 1.0
 * 
 * Constantes en las que se guardan las consultas posibles a la base de datos
 *
 */


public interface Consultas {
	
	//		INSERT
	public static final String INSERTAR_CLIENTE = "INSERT INTO clientes VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String INSERTAR_TARJETA = "INSERT INTO tarjetas(numero,pin,cvv,validez,estado,usuad) VALUES (?,?,?,?,?,?)";
	public static final String INSERTAR_CUENTA = "INSERT INTO cuentas(numCuenta, saldo,usuad) VALUES (?,?,?)";
	public static final String INSERTAR_MOVIMIENTO = "INSERT INTO movimientos(fecha, tipo,cantidad, autor, numCuenta) VALUES (?,?,?,?,?);";
	
	//		DELETE
	public static final String BORRAR_CLIENTE = "DELETE FROM clientes WHERE dni = ?";
	public static final String BORRAR_TARJETA = "DELETE FROM tarjetas WHERE numero = ?";
	public static final String BORRAR_CUENTA = "DELETE FROM cuentas WHERE numCuenta = ?";
	public static final String BORRAR_MOVIMIENTO = "DELETE FROM movimientos WHERE codigo = ?";
	
	
	//		UPDATE
	public static final String ACTUALIZAR_CLIENTE_NOMBRE = "update clientes set nombre = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_APELLIDO1 = "update clientes set apell1 = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_APELLIDO2 = "update clientes set apell2 = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_DIRECCION = "update clientes set direccion = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_CORREO = "UPDATE clientes SET correo = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_TELEFONO = "UPDATE clientes SET telefono = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_FECHANACIMIENTO = "UPDATE clientes SET fechaNacimiento = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_ADMIN = "UPDATE clientes SET admin = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CUENTA_NUMCUENTA = "UPDATE cuentas SET numCuenta = ? WHERE numCuenta = ?";
	public static final String ACTUALIZAR_CUENTA_SALDO = "UPDATE cuentas SET saldo = ? WHERE numCuenta = ?";
	public static final String ACTUALIZAR_CUENTA_DNI = "UPDATE cuentas SET dni = ? WHERE numCuenta = ?";
	public static final String ACTUALIZAR_CUENTA_ADMIN = "UPDATE cuentas SET admin = ? WHERE numCuenta = ?";
	public static final String ACTUALIZAR_TARJETA_PIN = "UPDATE tarjetas SET pin = ? WHERE numero = ?";
	public static final String ACTUALIZAR_TARJETA_CVV = "UPDATE tarjetas SET cvv = ? WHERE numero = ?";
	public static final String ACTUALIZAR_TARJETA_VALIDEZ = "UPDATE tarjetas SET validez = ? WHERE numero = ?";
	public static final String ACTUALIZAR_TARJETA_ESTADO = "UPDATE tarjetas SET estado = ? WHERE numero = ?";
	public static final String ACTUALIZAR_TARJETA_NUMCUENTA = "UPDATE tarjetas SET numCuenta = ? WHERE numero = ?";
	public static final String ACTUALZIAR_TARJETA_ADMIN = "UPDATE tarjetas SET admin = ? WHERE numero = ?";
	public static final String ACTUALIZAR_CAJERO = "UPDATE cajero SET estado = ?";
	
	//		BUSCAR
	public static final String BUSCAR_CLIENTES = "SELECT * FROM clientes";
	public static final String BUSCAR_CLIENTE_DNI = "SELECT * FROM clientes WHERE dni = ?";
	public static final String BUSCAR_CUENTAS = "SELECT numCuenta,saldo,dni FROM cuentas";
	public static final String BUSCAR_CUENTA_NUMCUENTA = "SELECT * FROM cuentas WHERE numCuenta = ?";
	public static final String BUSCAR_CUENTA_SALDO = "SELECT * FROM cuentas WHERE saldo = ?";
	public static final String BUSCAR_TARJETAS = "SELECT * FROM tarjetas";
	public static final String BUSCAR_TARJETA_NUMERO = "SELECT * FROM tarjetas WHERE numero = ?";
	public static final String BUSCAR_MOVIMIENTOS = "SELECT * FROM movimientos WHERE codigo = ?";
	public static final String BUSCAR_MOVIMIENTO_NUMCUENTA = "SELECT fecha,tipo,cantidad,autor,numCuenta FROM movimientos WHERE numCuenta = ?";
	public static final String BUSCAR_CAJERO = "SELECT * from cajero";	
	
}
