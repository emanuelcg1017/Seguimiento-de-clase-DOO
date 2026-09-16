package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCODatosException extends LibreriaUCOExcepcion{

	private static final long serialVersionUID = 3991079396073282193L;

	private LibreriaUCODatosException(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.DATOS, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		
	}

}
