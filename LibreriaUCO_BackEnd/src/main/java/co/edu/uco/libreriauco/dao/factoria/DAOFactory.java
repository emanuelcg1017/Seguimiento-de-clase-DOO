package co.edu.uco.libreriauco.dao.factoria;

import java.sql.Connection;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.factoria.enums.FactoriaEnum;
import co.edu.uco.libreriauco.dao.factoria.impl.SqlServerDAOFactory;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCODatosException;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilSQL;

public abstract class DAOFactory {

	private Connection conexion;
	private static FactoriaEnum factoria = FactoriaEnum.SQLSERVER;
	
	public static DAOFactory obtenerFactoria() {
		switch (factoria) {
		
			case SQLSERVER: {
				return new SqlServerDAOFactory();
			}
			default:
				
				var mensajeUsuario = "la fuente de informcion deseada que se solicito para llevar a cabo la operacion no esta abilitada. Por favor contacte al administrador de la aplicacion.";

				throw LibreriaUCODatosException.crear(mensajeUsuario);
			}
	}

	protected DAOFactory() {
		abrirConexion();
	}

	protected Connection getConexion() {

		return conexion;
	}

	protected void setConexion(Connection conexion) {

		UtilSQL.asegurarConexionAbierta(conexion);
		this.conexion = conexion;
	}

	protected abstract void abrirConexion();

	public void cerrarConexion() {

		UtilSQL.cerrarConexion(conexion);
	}

	public void iniciarTransaccion() {

		UtilSQL.iniciarTransaccion(conexion);
	}

	public void confirmarTransaccion() {

		UtilSQL.confirmarTransaccion(conexion);
	}

	public void cancelarTransaccion() {

		UtilSQL.cancelarTransaccion(conexion);
	}

	public abstract PaisDAO obtenerPaisDAO();

	public abstract DepartamentoDAO obtenerDepartamentoDAO();
}