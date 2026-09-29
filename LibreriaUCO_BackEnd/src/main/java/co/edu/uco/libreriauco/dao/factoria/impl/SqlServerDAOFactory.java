package co.edu.uco.libreriauco.dao.factoria.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCODatosException;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilSQL;

public class SqlServerDAOFactory extends DAOFactory {

	protected SqlServerDAOFactory() {
		super();
	}

	protected void abrirConexion() {

		if (UtilSQL.conexionEstaAbierta(getConexion())) {
			
			return;
			
		}

		try {
//crear data base para librerias uco
			String url = "jdbc:sqlserver://Emanuel:1433;"
					+ "databaseName=oelo;"
					+ "integratedSecurity=true;"
					+ "encrypt=true;"
					+ "trustServerCertificate=true";

			Connection conexion = DriverManager.getConnection(url);

			setConexion(conexion);

		} catch (SQLException excepcion) {


			var mensajeUsuario =CatalogoMensajes.SqlServerDAOFactory.USUARIO_ERROR_CONEXION_SQL_SERVER;
			var mensajeTecnico =CatalogoMensajes.SqlServerDAOFactory.TECNICO_ERROR_CONEXION_SQL_SERVER + excepcion.getMessage();
			throw LibreriaUCODatosException.crear(mensajeUsuario,mensajeTecnico,excepcion);
			
		}
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		
		return new PaisSqlServerDAO(getConexion());
		
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		
		return new DepartamentoSqlServerDAO(getConexion());
		
	}

}
