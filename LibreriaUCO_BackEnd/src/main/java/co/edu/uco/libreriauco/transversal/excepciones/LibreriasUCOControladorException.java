package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriasUCOControladorException extends LibreriaUCOExcepcion{

	private static final long serialVersionUID = -1467106275691435325L;

	private LibreriasUCOControladorException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.CONTROLADOR, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static LibreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriasUCOControladorException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new LibreriasUCOControladorException(mensajeUsuario, mensajeUsuario, new Exception(mensajeTecnico));
	}
	
	public static LibreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new LibreriasUCOControladorException(mensajeUsuario, mensajeUsuario, excepcionRaiz);
	}
}
