package co.edu.uco.libreriauco.dominio;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PaisDominio {

	private UUID id;
	private String nombre;

	private PaisDominio(UUID id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	private PaisDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public static class Builder {
		private UUID id;
		private String nombre;
		
		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
		}

		public Builder id(UUID id) {
			id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
			return this;
		}
		
		public PaisDominio build() {
			return new PaisDominio(this);
		}
	}
}
