package co.edu.uco.libreriauco.pruebas;

import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PruebaBuilder {

	public static void main(String[] args) {

		PaisDominio dominioPaisUno = new PaisDominio.Builder().build();

		PaisDominio dominioPaisConID = new PaisDominio.Builder()
				.id(UtilUUID.generar())
				.build();

		PaisDominio dominioPaisConNombre = new PaisDominio.Builder()
				.nombre("C")
				.build();

		PaisDominio dominioPaisCompleto = new PaisDominio.Builder()
				.nombre("C")
				.id(UtilUUID.generar())
				.build();

		System.out.println("Pais uno: id=" + dominioPaisUno.getId()
				+ ", nombre=" + dominioPaisUno.getNombre());

		System.out.println("Pais con id: id=" + dominioPaisConID.getId()
				+ ", nombre=" + dominioPaisConID.getNombre());

		System.out.println("Pais con nombre: id=" + dominioPaisConNombre.getId()
				+ ", nombre=" + dominioPaisConNombre.getNombre());

		System.out.println("Pais completo: id=" + dominioPaisCompleto.getId()
				+ ", nombre=" + dominioPaisCompleto.getNombre());
	}
}