package co.edu.uco.libreriauco.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import co.edu.uco.libreriauco.controlador.respuesta.RespuestaError;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;

@RestControllerAdvice
public abstract class AbstractRestController {

	@ExceptionHandler (LibreriaUCOExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarLibreriaUcoException(LibreriaUCOExcepcion excepcion){

		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());
		//logger.printException(excepcion)
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}
	
	@ExceptionHandler (Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarException(Exception excepcion){
		
		var mensajeRespuesta = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste  contacte al administrador de la aplicacion y entreguele el codigo que se muestra a continuacion ";
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		//logger.printException(excepcion)
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
	}
	
	@ExceptionHandler (NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> controlarException(NoResourceFoundException excepcion){
		
		var mensajeRespuesta = "Ojo mono porque el recurso que pidio no existe...:" + excepcion.getResourcePath() + "por el metodo: " + excepcion.getHttpMethod();
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		//logger.printException(excepcion)
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	}
	
	
	
}
