package co.edu.uco.libreriauco.dao.factoria;

import java.sql.Connection;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;

public abstract class DAOFactory {

	private Connection conexion;

	protected DAOFactory(Connection conexion) {
		abrirConexion();
	}

	protected Connection getConexion() {
		return conexion;
	}

	protected void setConexion(Connection conexion) {
		// tarea: asegurar que la conexion este abierta y sea valida
		this.conexion = conexion;
	}
	
	protected abstract void abrirConexion();


	public void cerrarConexion() {
		// tarea: como se cierra la conexion de manera segura?
	}

	public void iniciarTransaccion() {
		// tarea: como se inicia una transaccion de forma segura?
	}

	public void confirmarTransacion() {
		// tarea: como se confirma una transaccion de forma segura?
	}

	public void cancelarTransacion() {
		// tarea: coomo se calcela una transaccion de forma segura?
	}
	
	public abstract PaisDAO obtenerPaisDAO();
	
	public abstract DepartamentoDAO obtenerDepartamentoDAO();
}
