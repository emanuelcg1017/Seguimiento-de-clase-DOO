package co.edu.uco.libreriauco.controlador.impl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.libreriauco.controlador.AbstractRestController;

@RestController
@RequestMapping("/api/v1/paises")
public class PaisControlador extends AbstractRestController {
	
	@GetMapping
	public String consultarTodos() {
		return "ahora si mono! Metodo Get exitoso";
	}
	
	@PostMapping
	public String registrarInformacionNuevoPais() {
		return "ahora si mono! Metodo Post exitoso";
	}
	
	@PutMapping
	public String modificadorInformacionPaisExistente() {
		return "ahora si mono! Metodo Put exitoso";
	}
	
	@DeleteMapping
	public String darBajaInformacionPaisExistente() {
		return "ahora si mono! Metodo Delete exitoso";
	}

}


/*
<protocolo>://<host>:<puerto>/<recurso>
http://localhost:8800/api/v1/paises"
http://127.0.0.1:8800/api/v1/paises"
http://Emanuel:8800/api/v1/paises"
	
https-->80
https-->443
*/
