package co.edu.uco.libreriauco.transversal.utilitarios;

import java.util.UUID;

public class UtilUUID {
	
	private UtilUUID() {
	}
	
	public static UUID generar() {
		return UUID.randomUUID();
	}
	
	public static boolean esIgual(UUID uuidUno, UUID uuidDos) {
		return uuidUno.equals(uuidDos);
	}
	
	
}
