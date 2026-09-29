package co.edu.uco.libreriauco.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriasUCOTransversalException;

public final class UtilSQL {

	private UtilSQL() {

	}

	public static boolean conexionEstaVacia(Connection conexion) {

		return UtilObjeto.esNulo(conexion);
	}

	public static boolean conexionEstaAbierta(Connection conexion) {

		try {

			return !conexionEstaVacia(conexion) && !conexion.isClosed();

		} catch (SQLException excepcion) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario,excepcion.getMessage(),excepcion);

		} catch (Exception excepcion) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario,excepcion.getMessage(),excepcion);
		}
	}

	public static void asegurarConexionAbierta(Connection conexion) {

		if (!conexionEstaAbierta(conexion)) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario);
		}
	}

	public static boolean transaccionEstaIniciada(Connection conexion) {

		try {

			return conexionEstaAbierta(conexion) && !conexion.getAutoCommit();

		} catch (SQLException excepcion) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario,excepcion.getMessage(),excepcion);

		} catch (Exception excepcion) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario,excepcion.getMessage(),excepcion);
		}
	}

	public static void iniciarTransaccion(Connection conexion) {
		asegurarConexionAbierta(conexion);

		if (transaccionEstaIniciada(conexion)) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario);
		}

		try {

			conexion.setAutoCommit(false);

		} catch (SQLException excepcion) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_INICIANDO_TRANSACCION_SQL;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario,excepcion.getMessage(),excepcion);
		}
	}

	public static void confirmarTransaccion(Connection conexion) {
		asegurarConexionAbierta(conexion);

		if (!transaccionEstaIniciada(conexion)) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario);
		}

		try {

			conexion.commit();
			conexion.setAutoCommit(true);

		} catch (SQLException excepcion) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_CONFIRMAR_TRANSACCION_SQL;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario,excepcion.getMessage(),excepcion);
		}
	}

	public static void cancelarTransaccion(Connection conexion) {
		asegurarConexionAbierta(conexion);

		if (!transaccionEstaIniciada(conexion)) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario);
		}

		try {

			conexion.rollback();
			conexion.setAutoCommit(true);

		} catch (SQLException excepcion) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_CANCELAR_TRANSACCION_SQL;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario,excepcion.getMessage(),excepcion);
		}
	}

	public static void cerrarConexion(Connection conexion) {

		if (!conexionEstaAbierta(conexion)) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario);
		}

		try {

			if (transaccionEstaIniciada(conexion)) {
				conexion.rollback();
			}
			conexion.close();

		} catch (SQLException excepcion) {

			var mensajeUsuario =CatalogoMensajes.UtilSQL.USUARIO_ERROR_CERRAR_CONEXION_SQL;
			throw LibreriasUCOTransversalException.crear(mensajeUsuario,excepcion.getMessage(),excepcion);
		}
	}
}