package co.edu.uco.libreriauco.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dto.PaisDTO;
import co.edu.uco.libreriauco.negocio.fachada.PaisFachada;
import co.edu.uco.libreriauco.negocio.fachada.assembler.impl.PaisDTOAssembler;
import co.edu.uco.libreriauco.negocio.negocio.PaisNegocio;
import co.edu.uco.libreriauco.negocio.negocio.impl.PaisNegocioImpl;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriasUCOFachadaException;

public class PaisFachadaimpl implements PaisFachada{

	private DAOFactory daoFactory;
	private PaisNegocio paisNegocio;
	
	public PaisFachadaimpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		paisNegocio = new PaisNegocioImpl(daoFactory);
	}
	
	@Override
	public void registrarInformacionNuevoPais(PaisDTO datos) {

		daoFactory.iniciarTransaccion();
		
		try {
			var paisDominio = PaisDTOAssembler.getInstance().convertirADominio(datos);
			paisNegocio.registrarInformacionNuevoPais(paisDominio);
			daoFactory.confirmarTransaccion();
			
		} catch (LibreriaUCOExcepcion excepcion) {
			
			daoFactory.cancelarTransaccion();
			throw excepcion;
			
		}catch (Exception excepcion) {
			
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = "se ha presentado un problema inesperado tratando de registrar la informacion del nuevo pais deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion.";
			throw LibreriasUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage() , excepcion);
			
		}finally {
			
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificadorInformacionPaisExistente(UUID id, PaisDTO datos) {
		
		daoFactory.iniciarTransaccion();
		
		try {
			var paisDominio = PaisDTOAssembler.getInstance().convertirADominio(datos);
			paisNegocio.modificadorInformacionPaisExistente(id, paisDominio);
			daoFactory.confirmarTransaccion();
			
		} catch (LibreriaUCOExcepcion excepcion) {
			
			daoFactory.cancelarTransaccion();
			throw excepcion;
			
		}catch (Exception excepcion) {
			
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = "se ha presentado un problema inesperado tratando de modificar la informacion del nuevo pais deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion.";
			throw LibreriasUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage() , excepcion);
			
		}finally {
			
			daoFactory.cerrarConexion();
		}		
	}

	@Override
	public void darBajaInformacionPaisExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PaisDTO> consultarPorFiltro(PaisDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDTO> consultarTodos() {
		
		try {
			var listaPaisesDominio = paisNegocio.consultarTodos();
			return PaisDTOAssembler.getInstance().convertirADTO(listaPaisesDominio);
			
		} catch (LibreriaUCOExcepcion excepcion) {
			
			throw excepcion;
			
		}catch (Exception excepcion) {
						
			var mensajeUsuario = "se ha presentado un problema inesperado tratando de consultar la informacion de todos los paises. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion.";
			throw LibreriasUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage() , excepcion);
			
		}finally {
			
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public PaisDTO consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
