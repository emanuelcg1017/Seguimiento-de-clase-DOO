package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriasUCODTOException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = 5205095069753958013L;

	private LibreriasUCODTOException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.DTO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
