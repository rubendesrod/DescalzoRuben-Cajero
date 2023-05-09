package Modelo;

/**
 * 
 * @author Rubens
 * 
 * @version 1.0
 * 
 * Constantes en las que se guardan las consultas posibles a la base de datos
 *
 */

public interface Consultas {

	//		INSERT
	public static final String INSERTAR_CLIENTE = "INSERT INTO clientes VALUES (?,?,?,?,?,?,?,?,?)";
	public static final String INSERTAR_TARJETA = "INSERT INTO tarjetas VALUES (?,?,?,?,?,?)";
	public static final String INSERTAR_CUENTA = "INSERT INTO cuentas VALUES (?,?,?)";
	public static final String INSERTAR_MOVIMIENTO = "INSERT INTO movimientos VALUES (?,?,?,?,?)";
	public static final String INSERTAR_PERTENECE = "INSERT INTO pertenece VALUES (?,?)";
	
	//		DELETE
	public static final String BORRAR_CLIENTE = "DELETE FROM clientes WHERE dni = ?";
	public static final String BORRAR_TARJETA = "DELETE FROM tarjetas WHERE numero = ?";
	public static final String BORRAR_CUENTA = "DELETE FROM cuentas WHERE numCuenta = ?";
	public static final String BORRAR_MOVIMIENTO = "DELETE FROM movimientos WHERE codigo = ?";
	public static final String BORRAR_PERTENECE = "DELETE FROM pertenece WHERE dni = ? and numCuenta = ?";
	
	
	//		UPDATE
	public static final String ACTUALIZAR_CLIENTE_NOMBRE = "update clientes set nombre = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_APELLIDO1 = "update clientes set apell1 = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_APELLIDO2 = "update clientes set apell2 = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_DIRECCION = "update clientes set direccion = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_CORREO = "UPDATE clientes SET correo = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_TELEFONO = "UPDATE cliente SET telefono = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_FECHANACIMIENTO = "UPDATE clientes SET fechaNacimiento = ? WHERE dni = ?";
	public static final String ACTUALIZAR_CLIENTE_ADMIN = "UPDATE clientes SET admin = ? WHERE dni = ?";
	
	public static final String ACTUALIZAR_CUENTA_NUMCUENTA = "UPDATE cuentas SET numCuenta = ? WHERE numCuenta = ?";
	public static final String ACTUALIZAR_CUENTA_SALDO = "UPDATE cuentas SET saldo = ? WHERE numCuenta = ?";
	public static final String ACTUALIZAR_CUENTA_ADMIN = "UPDATE cuentas SET admin = ? WHERE numCuenta = ?";
	
	public static final String ACTUALIZAR_TARJETA_PIN = "UPDATE tarjetas SET pin = ? WHERE numero = ?";
	public static final String ACTUALIZAR_TARJETA_CVV = "UPDATE tarjetas SET cvv = ? WHERE numero = ?";
	public static final String ACTUALIZAR_TARJETA_VALIDEZ = "UPDATE tarjetas SET validez = ? WHERE numero = ?";
	public static final String ACTUALIZAR_TARJETA_ESTADO = "UPDATE tarjetas SET estado = ? WHERE numer = ?";
	public static final String ACTUALIZAR_TARJETA_NUMCUENTA = "UPDATE tarjetas SET numCuenta = ? WHERE numCuenta = ?";
	public static final String ACTUALZIAR_TARJETA_ADMIN = "UPDATE tarjetas SET admin = ? WHERE numero = ?";
	
	public static final String ACTUALIZAR_MOVIMIENTO_FECHA = "UPDATE movimientos SET fecha = ? WHERE codigo = ?";
	public static final String ACTUALIZAR_MOVIMIENTO_TIPO_INGRESO = "UPDATE movimientos SET tipo = ingreso WHERE codigo = ?";
	public static final String ACTUALIZAR_MOVIMIENTO_TIPO_RETIRADA = "UPDATE movimientos SET tipo = retirada WHERE codigo = ?";
	public static final String ACTUALIZAR_MOVIMIENTO_TIPO_TRANSFERENCIA = "UPDATE movimientos SET tipo = transferencia WHERE codigo = ?";
	public static final String ACTUALIZAR_MOVIMIENTO_AUTOR = "UPDATE movimientos SET autor = ? WHERE codigo = ?";
	public static final String ACTUALIZAR_MOVIMIENTO_NUMCUENTA = "UPDATE movimientos SET numCuenta = ? WHERE codigo = ?";
	
	public static final String ACTUALIZAR_PERTENECE_DNI = "UPDATE pertenece SET dni = ? WHERE numCuenta = ?";
	public static final String ACTUALIZAR_PERTENECE_NUMCUENTA = "UPDATE pertenece SET numCuenta = ? WHERE dni = ?";
	
	
	//		BUSCAR
	public static final String BUSCAR_CLIENTES = "SELECT * FROM clientes";
	public static final String BUSCAR_CLIENTE_DNI = "SELECT * FROM clientes WHERE dni = ?";
	public static final String BUSCAR_CLIENTE_NOMBRE = "SELECT * FROM clientes WHERE nombre = ?";
	public static final String BUSCAR_CLIENETE_APELL1 = "SELECT * FROM clientes WHERE apell1 = ?";
	public static final String BUSCAR_CLIENTE_APELL2 = "SELECT * FROM clientes WHERE apell2 = ?";
	public static final String BUScAR_CLIENTE_DIRECCION = "SELECT * FROM clientes WHERE direccion = ?";
	public static final String BUSCAR_CLIENTE_CORREO = "SELECT * FROM clientes WHERE correo = ?";
	public static final String BUSCAR_CLIENTE_TELEFONO = "SELECT * FROM clientes WHERE telefono = ?";
	public static final String BUSCAR_CLIENTE_FECHANACIMIENTO = "SELECT * FROM clientes WHERE fechaNacimiento = ?";
	
	public static final String BUSCAR_CUENTAS = "SELECT * FROM cuentas";
	public static final String BUSCAR_CUENTA_NUMCUENTA = "SELECT * FROM cuentas WHERE numCuenta = ?";
	public static final String BUSCAR_CUENTA_SALDO = "SELECT * FROM cuentas WHERE saldo = ?";
	
	public static final String BUSCAR_TARJETAS = "SELECT * FROM tarjetas";
	public static final String BUSCAR_TARJETA_NUMERO = "SELECT * FROM tarjetas WHERE numero = ?";
	public static final String BUSCAR_TARJETA_PIN = "SELECT * FROM tarjetas WHERE pin = ?";
	public static final String BUSCAR_TARJETA_CVV = "SELECT * FROM tarjetas WHERE cvv = ?";
	public static final String BUSCAR_TARJETA_VALIDEZ = "SELECT * FROM tarjetas WHERE validez = ?";
	public static final String BUSCAR_TARJETA_BLOQUEADA = "SELECT * FROM tarjetas WHERE estado = bloqueado";
	public static final String BUSCAR_TARJETA_NOBLOQUEADA = "SELECT * FROM tarjetas WHERE estado = noBloqueado";
	public static final String BUSCAR_TARJETA_NUMCUENTA = "SELECT * FROM tarjetas WHERE numCuenta = ?";
	public static final String BUSCAR_TARJETA_ADMIN = "SELECT * FROM tarjetas WHERE admin = ?";
	
	public static final String BUSCAR_MOVIMIENTOS = "SELECT * FROM movimientos WHERE codigo = ?";
	public static final String BUSCAR_MOVIMIENTO_CODIGO = "SELECT * FROM movimientos WHERE fecha = ?";
	public static final String BUSCAR_MOVIMIENTO_TIPO_INGRESO = "SELECT * FROM movimientos WHERE tipo = ingreso";
	public static final String BUSCAR_MOVIMIENTO_TIPO_RETIRADA = "SELECT * FROM movimientos WHERE tipo = retirada";
	public static final String BUSCAR_MOVIMIENTO_TIPO_TRANSFERENCIA = "SELECT * FROM movimientos WHERE tipo = transferencia";
	public static final String BUSCAR_MOVIMIENTO_AUTOR = "SELECT * FROM movimientos WHERE autor = ?";
	public static final String BUScAR_MOVIMIENTO_NUMCUENTA = "SELECT * FROM movientos WHERE numCuenta = ?";
	
	public static final String BUSCAR_PERTENECES = "SELECT * FROM pertenece";
	public static final String BUSCAR_PERTENECE_DNI = "SELECT * FROM pertenece WHERE dni = ?";
	public static final String BUSCAR_PERTENECE_NUMCUENTA = "SELECT * FROM pertenece WHERE numCuenta = ?";
	
}
