package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriasUCOEntidadException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -6327159641185377781L;

	private LibreriasUCOEntidadException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.ENTIDAD, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
