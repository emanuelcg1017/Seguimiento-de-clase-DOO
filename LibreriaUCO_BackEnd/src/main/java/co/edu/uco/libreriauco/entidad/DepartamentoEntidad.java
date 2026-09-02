package co.edu.uco.libreriauco.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class DepartamentoEntidad {

	private UUID id;
	private String nombre;
	private PaisEntidad pais;

	public DepartamentoEntidad() {
		setId(UtilUUID.obtenerValorDefecto(id));
		setNombre(UtilTexto.VACIO);
		setPais(new PaisEntidad());
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
	}

	public PaisEntidad getPais() {
		return pais;
	}

	public void setPais(PaisEntidad pais) {
		this.pais = UtilObjeto.obtenerValorDefectoSiNulo(pais, new PaisEntidad());
	}

}
