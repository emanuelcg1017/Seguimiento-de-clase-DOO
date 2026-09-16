package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriasUCOTransversalException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -2411371935718847791L;

	private LibreriasUCOTransversalException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.TRANSVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
