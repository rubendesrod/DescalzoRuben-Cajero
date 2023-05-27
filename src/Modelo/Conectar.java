package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * Clase que pretende conectar con la base de datos Cajero Galileo.
 * 
 * @author Ruben
 *
 */

public class Conectar {

	final private String driver = "com.mysql.cj.jdbc.Driver";
	final private String host = "localhost";
	final private String user = "root";
	final private String passwd = "admin";
	private Connection connect = null;
	private Statement statement = null;
	
	
	public Conectar() {
		try {
			// Cargamos el driver de MySQL. Cada SGBD tiene el suyo.
			Class.forName(driver);
			
			// Configuramos la conexion con la BBDD --
			
			// jdbc:mysql://localhost/feedback?user=admin¬password=1235
			 connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "/cajero?" + "user=" + user + "&password=" + passwd);
			// El statement permite realizar consultas SQL a la base de datos.
			 statement = connect.createStatement();
			 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR: No se ha podido establecer conexión con la base de datos.\n\n "+e.getLocalizedMessage(), "Error de conexión", JOptionPane.ERROR_MESSAGE);
//			System.out.println("Error al crear la conexión: " + e.getLocalizedMessage());
		}
	}

	/**
	 * Método get de Connection.
	 * 
	 * @return connect.
	 */

	public Connection getConnect() {
		return connect;
	}

	/**
	 * Método set de Connection.
	 * 
	 * @param connect.
	 */

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	/**
	 * Método get de Statement.
	 * 
	 * @return statement.
	 */

	public Statement getStatement() {
		return statement;
	}

	/**
	 * Método set de Statement.
	 * 
	 * @param statement
	 */

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	/**
	 * Método para cerrar la conexión a la base de datos.
	 * 
	 * @param resultSet
	 * @param connect
	 * @param statement
	 */

	public void cerrarConexion(ResultSet resultSet, Connection connect, Statement statement) {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"ERROR: No se ha podido establecer conexión con la base de datos.\n\n " + e.getLocalizedMessage(),
					"Error de conexión", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Método get de Driver.
	 * 
	 * @return driver.
	 */

	public String getDriver() {
		return driver;
	}

	/**
	 * Método get de Host.
	 * 
	 * @return host.
	 */

	public String getHost() {
		return host;
	}

	/**
	 * Método get de user.
	 * 
	 * @return user.
	 */

	public String getUser() {
		return user;
	}

	/**
	 * Método get de passwd.
	 * 
	 * @return passwd.
	 */

	public String getPasswd() {
		return passwd;
	}
}
