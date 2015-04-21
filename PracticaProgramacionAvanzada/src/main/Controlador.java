package main;

import java.util.ArrayList;

import javafx.util.Pair;
import enumeraciones.TipoCliente;
import enumeraciones.TipoTarifaFinDeSemana;
import enumeraciones.TipoTarifaHoraria;
import excepciones.ExcepcionFacturaNoEncontrada;
import excepciones.ExcepcionClienteNoEncontrado;
import excepciones.ExcepcionLlamadaNoEncontrada;
import menus.MenuClientesConsola;
import menus.MenuFacturasConsola;
import menus.MenuLlamadasConsola;
import menus.MenuPrincipalConsola;
import objetos.Cliente;
import gestores.GestorClientes;
import gestores.GestorFacturas;
import gestores.GestorLlamadas;
import interfaces.IntIOInterface;
import interfaces.IntLectura;
import interfaces.IntSalidaInfo;

public class Controlador 
{
	private GestorClientes gestorClientes;
	private GestorFacturas gestorFacturas;
	private GestorLlamadas gestorLlamadas;
	
	private IntIOInterface IoInterface;
	private IntLectura lecturaDatos;
	private IntSalidaInfo salidaInfo;
	
	public Controlador() {
		super();
	}
	
	public void SetInterface (IntIOInterface IoInterface)
	{
		this.IoInterface = IoInterface;
	}
	public void setLectura(IntLectura lecturaDatos)
	{
		this.lecturaDatos = lecturaDatos;
	}
	public void setSalida (IntSalidaInfo salidaInfo)
	{
		this.salidaInfo = salidaInfo;
	}
	
	/**
	 * Inicia el controlador y mantiene el programa en ejecucion
	 * @throws ExcepcionClienteNoEncontrado 
	 */
	public void start() throws ExcepcionClienteNoEncontrado
	{
		inicializaGestores();
		MenuPrincipalConsola op = null;
		do {
			try{
				this.salidaInfo.salidaInfo(MenuPrincipalConsola.getMenu());
				op = MenuPrincipalConsola.getOpcion(this.lecturaDatos.lecturaEnteros());
				ejecutaOpcionMenuPrincipal(op);
			}catch(Exception e)
			{
				this.salidaInfo.salidaInfo("Opcion Incorrecta");
			}		
		} while (op != MenuPrincipalConsola.SALIR);
	}

	/**
	 * Inicializamos todos los gestores para interactuar con el modelo
	 */
	private void inicializaGestores()
	{
		this.gestorClientes = new GestorClientes();
		this.gestorFacturas = new GestorFacturas();
		this.gestorLlamadas = new GestorLlamadas();
		
		this.gestorClientes.setGestorFacturas(this.gestorFacturas);
		this.gestorFacturas.setGestorClientes(this.gestorClientes);
		this.gestorLlamadas.setGestorClientes(this.gestorClientes);
		this.gestorLlamadas.setGestorFacturas(this.gestorFacturas);
	}
	
	/**
	 * Ejecuta las opciones principales elegidas por le usuario y ejecuta sus operaciones
	 * segun la opcion que se elija carga el menu correspondiente
	 * @param opcion elegida por el usuario
	 * @throws ExcepcionClienteNoEncontrado 
	 */
	private void ejecutaOpcionMenuPrincipal(MenuPrincipalConsola opcion) throws ExcepcionClienteNoEncontrado {
		switch (opcion) {
		case CLIENTES:
			this.salidaInfo.salidaInfo(MenuClientesConsola.getMenu());
			ejecutaOpcionMenuCliente(MenuClientesConsola.getOpcion(this.lecturaDatos.lecturaEnteros()));
			break;
		case FACTURAS:
			this.salidaInfo.salidaInfo(MenuFacturasConsola.getMenu());
			ejecutaOpcionMenuFacturas(MenuFacturasConsola.getOpcion(this.lecturaDatos.lecturaEnteros()));
			break;
		case LLAMADAS:
			this.salidaInfo.salidaInfo(MenuLlamadasConsola.getMenu());
			ejecutaOpcionMenuLlamadas(MenuLlamadasConsola.getOpcion(this.lecturaDatos.lecturaEnteros()));
			break;
		case SALIR:
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * Ejecuta las opciones sobre los clientes elegidas por le usuario y ejecuta sus operaciones
	 * @param opcion elegida por el usuario
	 * @throws ExcepcionClienteNoEncontrado 
	 */
	private void ejecutaOpcionMenuCliente(MenuClientesConsola opcion) {
		String mensaje;
		TipoTarifaHoraria tarifaHoraria;
		TipoTarifaFinDeSemana tarifaFinSemana;
		switch (opcion) {
		case NUEVO_CLIENTE:
			Pair<TipoCliente, ArrayList<String>> datos = this.IoInterface.getOperacionesClientes().menuNuevoCliente();
			tarifaHoraria = this.IoInterface.getOperacionesClientes().menuTarifaHoraria();
			tarifaFinSemana = this.IoInterface.getOperacionesClientes().menuTarifaFInDeSemana();
        	mensaje = this.gestorClientes.altaCliente(datos.getKey(), datos.getValue(), tarifaHoraria, tarifaFinSemana);
        	this.IoInterface.getOperacionesClientes().mostrarMensaje(mensaje);
			break;
			
		case BUSCAR_CLIENTE_DNI:
			Cliente cli;
			try {
				cli = this.gestorClientes.datosCliente(this.IoInterface.getOperacionesClientes().menuVerCliente());
				this.IoInterface.getOperacionesClientes().formatoInfoCliente(cli);
			} catch (ExcepcionClienteNoEncontrado e) {
				this.salidaInfo.salidaInfo(e.getMessage());
			}
        	
			break;
			
		case BUSCAR_CLIENTE_ALTA:
			try {
				this.IoInterface.getOperacionesClientes().mostrarClientes(
						this.gestorClientes.buscarClientePorFechaAlta(
								this.IoInterface.getOperacionesClientes().buscarClientesPorFechaAlta()));
			} catch (ExcepcionClienteNoEncontrado e) {
				this.salidaInfo.salidaInfo(e.getMessage());
			}
			break;
			
		case VER_CLIENTES:
			try {
				this.IoInterface.getOperacionesClientes().mostrarClientes(this.gestorClientes.getClientes());
			} catch (ExcepcionClienteNoEncontrado e) {
				this.salidaInfo.salidaInfo(e.getMessage());
			}
        	break;
        	
		case MODIFICAR_TARIFA:
			String nif = this.IoInterface.getOperacionesClientes().menuVerCliente();
        	tarifaHoraria = this.IoInterface.getOperacionesClientes().menuTarifaHoraria();
			tarifaFinSemana = this.IoInterface.getOperacionesClientes().menuTarifaFInDeSemana();
        	mensaje = this.gestorClientes.actualizarTarifa(nif, tarifaHoraria, tarifaFinSemana);
        	this.IoInterface.getOperacionesClientes().mostrarMensaje(mensaje);
        	break;
			
		case ATRAS:
			break;
		}
	}
	
	/**
	 * Ejecuta las opciones del menu de Facturas elegidas por le usuario y ejecuta sus operaciones
	 * @param opcion elegida por el usuario
	 */
	private void ejecutaOpcionMenuFacturas(MenuFacturasConsola opcion) {
		String mensaje;
		switch (opcion) {
		case EMITIR_FACTURA:
			try {
				mensaje = this.IoInterface.getOperacionesFacturas().mostrarDatosFactura(
						this.gestorFacturas.emitirFactura(
								this.IoInterface.getOperacionesFacturas().emitirFactura()));
				this.salidaInfo.salidaInfo(mensaje);
			} catch (ExcepcionClienteNoEncontrado e) {
				this.salidaInfo.salidaInfo(e.getMessage());
			}

			break;
		case BUSCAR_FACTURA_CODIGO:
			try {
				mensaje = this.IoInterface.getOperacionesFacturas().mostrarDatosFactura(
						this.gestorFacturas.buscarFactura(
								this.IoInterface.getOperacionesFacturas().buscarFacturaPorCodigo()));
				this.salidaInfo.salidaInfo(mensaje);
			} catch (ExcepcionFacturaNoEncontrada e) {
				this.salidaInfo.salidaInfo(e.getMessage());
			}
			break;
		case BUSCAR_FACTURAS_FECHA:
			String codCliente = this.IoInterface.getOperacionesFacturas().buscarFacturasCliente();
			try {
				mensaje = this.IoInterface.getOperacionesFacturas().mostrarDatosFacturas(
						this.gestorFacturas.devolverFacturasClienteEntreDosFechas(codCliente, 
								this.IoInterface.getOperacionesFacturas().buscarFacturasClientePorFechaEmision()));
				this.salidaInfo.salidaInfo(mensaje);
			} catch (ExcepcionClienteNoEncontrado e) {
				this.salidaInfo.salidaInfo(e.getMessage());
			} catch (ExcepcionFacturaNoEncontrada e) {
				this.salidaInfo.salidaInfo(e.getMessage());
			}
			break;
		case FACTURAS_CLIENTE:
			try {
				mensaje = this.IoInterface.getOperacionesFacturas().mostrarDatosFacturas(
						this.gestorFacturas.devolverFacturasCliente(
								this.IoInterface.getOperacionesFacturas().buscarFacturasCliente()));
				salidaInfo.salidaInfo(mensaje);
			} catch (ExcepcionClienteNoEncontrado e) {
				this.salidaInfo.salidaInfo(e.getMessage());
			}
			break;
		case ATRAS:
			break;
		}
	}
	
	/**
	 * Ejecuta las opciones del menu de Facturas elegidas por le usuario y ejecuta sus operaciones
	 * @param opcion elegida por el usuario
	 */
	private void ejecutaOpcionMenuLlamadas(MenuLlamadasConsola opcion) {
		String mensaje;
		switch (opcion) {
		case ALTA_LLAMADA:
			mensaje = this.gestorLlamadas.altaLlamada(this.IoInterface.getOperacionesLlamadas().realizarLLamada());
			this.salidaInfo.salidaInfo(mensaje);
			break;
		case LLAMADAS_CLIENTE:
			try {
				mensaje = this.IoInterface.getOperacionesLlamadas().mostrarLlamadas(
						this.gestorLlamadas.verLlamadasCliente(this.IoInterface.getOperacionesLlamadas().llamadasCliente()));
				this.salidaInfo.salidaInfo(mensaje);
			} catch (ExcepcionClienteNoEncontrado e) {
				this.salidaInfo.salidaInfo(e.getMessage());
			}
			
			break;
		case LLAMADAS_CLIENTE_FECHA:
			String codCliente = this.IoInterface.getOperacionesLlamadas().llamadasCliente();
			try {
				mensaje = this.IoInterface.getOperacionesLlamadas().mostrarLlamadas(
						this.gestorLlamadas.devolverLlamadasClienteEntreDosFechas(codCliente, 
								this.IoInterface.getOperacionesLlamadas().buscarLlamadasClientePorFecha()));
				this.salidaInfo.salidaInfo(mensaje);
			} catch (ExcepcionClienteNoEncontrado
					| ExcepcionLlamadaNoEncontrada e) {
				this.salidaInfo.salidaInfo(e.getMessage());
			}
			break;
		case ATRAS:
			break;
		}
	}
	
}
