package co.edu.uco.libreriauco.dto;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PaisDTO {

	private UUID id;
	private String nombre;

	public PaisDTO() {
		this(new Builder());
	}

	private PaisDTO(final Builder builder) {

		setId(builder.id);
		setNombre(builder.nombre);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacionEnBlanco(nombre);
	}

	public static class Builder {

		private UUID id;
		private String nombre;

		public Builder() {

			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder nombre(final String nombre) {
			this.nombre = nombre;
			return this;
		}

		public PaisDTO build() {
			return new PaisDTO(this);
		}
	}
}