package co.edu.uco.libreriauco.transversal.catalogo;

public class CatalogoMensajes {



	private CatalogoMensajes() {

	}

	public static final class UtilSQL {

		private UtilSQL() {

		}

		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema tratando de validar si la conexión con la fuente de información se encuentra abierta. Por favor intente nuevamente y, si el problema persiste, contacte al administrador.";

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema no controlado tratando de validar si la conexión con la fuente de información se encuentra abierta. Por favor intente nuevamente y, si el problema persiste, contacte al administrador.";
		
		public static final String USUARIO_ERROR_CONEXION_SQL_NO_ESTA_ABIERTA ="No es posible continuar con la operación porque la conexión con la fuente de información no se encuentra abierta.";

		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema tratando de validar si existe una transacción iniciada. Por favor intente nuevamente y, si el problema persiste, contacte al administrador.";

		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema no controlado tratando de validar si existe una transacción iniciada. Por favor intente nuevamente y, si el problema persiste, contacte al administrador.";

		public static final String USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "No es posible iniciar la transacción porque la conexión no se encuentra disponible o ya existe una transacción iniciada.";

		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL = "No es posible confirmar la transacción porque no existe una transacción iniciada.";

		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL = "No es posible cancelar la transacción porque no existe una transacción iniciada.";

		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL = "No es posible cerrar la conexión porque esta no se encuentra abierta.";

		public static final String USUARIO_ERROR_INICIANDO_TRANSACCION_SQL = "Se ha presentado un problema intentando iniciar la transacción.";

		public static final String USUARIO_ERROR_CONFIRMAR_TRANSACCION_SQL = "Se ha presentado un problema intentando confirmar la transacción.";

		public static final String USUARIO_ERROR_CANCELAR_TRANSACCION_SQL = "Se ha presentado un problema intentando cancelar la transacción.";

		public static final String USUARIO_ERROR_CERRAR_CONEXION_SQL = "Se ha presentado un problema intentando cerrar la conexión.";
	}
	
	public static class SqlServerDAOFactory {

		private SqlServerDAOFactory() {

		}

		public static final String USUARIO_ERROR_CONEXION_SQL_SERVER ="No fue posible establecer la conexión con la fuente de información. Por favor intente nuevamente y, si el problema persiste, contacte al administrador.";

		public static final String TECNICO_ERROR_CONEXION_SQL_SERVER ="Se presentó un error tratando de establecer la conexión con SQL Server. Detalle técnico: ";
	}
	
	public static final class PaisNegocioImpl {
		
		private PaisNegocioImpl() {
		}


		public static  final String NOMBRE_PAIS_OBLIGATORIO  = "El nombre del pais es obligatorio para llevar a cabo la operacion deseada";
		
		public static final String LONGITUD_NOMBRE_PAIS_NO_VALIDA = "La longitud del pais no es válida. Asegurese que esté entre 1 y 50";

		public static final String FORMATO_PAIS_NO_VALIDO = "El formato del pais no es valido";

		public static final String Pais_Ya_Existe_Con_El_Mismo_Nombre_Pais_A_Crear = "ya existe un pais con ese nombre";
	}	
}
