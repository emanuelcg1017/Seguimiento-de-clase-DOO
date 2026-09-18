package co.edu.uco.libreriauco.dao.factoria;

import java.sql.Connection;
import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes.UtilSQL;


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
		co.edu.uco.libreriauco.transversal.utilitarios.UtilSQL.cerrarConexion(conexion);
	}

	public void iniciarTransaccion() {
		
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
