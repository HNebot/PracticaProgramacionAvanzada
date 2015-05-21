package controlador;

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
import interfaces.IntModeloGestor;
import interfaces.IntSalidaInfo;

public class Controlador 
{
	
	private GestorClientes gestorClientes;
	private GestorFacturas gestorFacturas;
	private GestorLlamadas gestorLlamadas;
	
	private IntIOInterface IoInterface;
	private IntModeloGestor gestorManager;
	private IntSalidaInfo salidaInfo;
	
	public Controlador() {
		super();
	}
	
	public void setInterface (IntIOInterface IoInterface)
	{
		this.IoInterface = IoInterface;
	}
	
	public void setModeloGestor (IntModeloGestor modeloGestor)
	{
		this.gestorManager = modeloGestor;
		inicializaGestores();
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
		//inicializaGestores();
		/*do {
			try{
				this.IoInterface.getOperacionesPrincipal().menuPincipal();
			}catch(Exception e)
			{
				this.salidaInfo.salidaInfo("Opcion Incorrecta");
			}		
		/} while(true);*/
	}

	/**
	 * Inicializamos todos los gestores para interactuar con el modelo
	 */
	private void inicializaGestores()
	{
		this.gestorClientes = this.gestorManager.getGestorCliente();
		this.gestorFacturas = this.gestorManager.getGestorFacturas();
		this.gestorLlamadas = this.gestorManager.getGestorLlamadas();
	}
	
	/**
	 * Ejecuta las opciones principales elegidas por le usuario y ejecuta sus operaciones
	 * segun la opcion que se elija carga el menu correspondiente
	 * @param opcion elegida por el usuario
	 * @throws ExcepcionClienteNoEncontrado 
	 */
	public void ejecutaOpcionMenuPrincipal(MenuPrincipalConsola opcion) throws ExcepcionClienteNoEncontrado {
		switch (opcion) {
		case CLIENTES:
			this.IoInterface.getOperacionesClientes().menuPincipalClientes();
			break;
		case FACTURAS:
			this.IoInterface.getOperacionesFacturas().menuPincipalFacturas();
			break;
		case LLAMADAS:
			this.IoInterface.getOperacionesLlamadas().menuPincipalLLamadas();
			break;
		case SALIR:
			System.exit(0);
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
	public void ejecutaOpcionMenuCliente(MenuClientesConsola opcion) {
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
				this.IoInterface.getOperacionesClientes().mostrarMensaje(e.getMessage());
			}
        	
			break;
			
		case BUSCAR_CLIENTE_ALTA:
			try {
				this.IoInterface.getOperacionesClientes().mostrarClientes(
						this.gestorClientes.buscarClientePorFechaAlta(
								this.IoInterface.getOperacionesClientes().buscarClientesPorFechaAlta()));
			} catch (ExcepcionClienteNoEncontrado e) {
				this.IoInterface.getOperacionesClientes().mostrarMensaje(e.getMessage());
			}
			catch(NullPointerException e)
			{
				this.IoInterface.getOperacionesClientes().mostrarMensaje(
						new ExcepcionClienteNoEncontrado().getMessage());
			}
			break;
			
		case VER_CLIENTES:
			try {
				this.IoInterface.getOperacionesClientes().mostrarClientes(this.gestorClientes.getClientes());
			} catch (ExcepcionClienteNoEncontrado e) {
				this.IoInterface.getOperacionesClientes().mostrarMensaje(e.getMessage());
			}
        	break;
        	
		case MODIFICAR_TARIFA:
			try{
				String nif = this.IoInterface.getOperacionesClientes().menuVerCliente();
				tarifaHoraria = this.IoInterface.getOperacionesClientes().menuTarifaHoraria();
				tarifaFinSemana = this.IoInterface.getOperacionesClientes().menuTarifaFInDeSemana();
				mensaje = this.gestorClientes.actualizarTarifa(nif, tarifaHoraria, tarifaFinSemana);
				this.IoInterface.getOperacionesClientes().mostrarMensaje(mensaje);
			} catch (Exception e) {
				this.IoInterface.getOperacionesClientes().mostrarMensaje(e.getMessage());
			}
        	break;
			
		case ATRAS:
			try {
				this.IoInterface.getOperacionesPrincipal().menuPincipal();
			} catch (Exception e) {
				this.IoInterface.getOperacionesClientes().mostrarMensaje(e.getMessage());
			}
			break;
		}
	}
	
	/**
	 * Ejecuta las opciones del menu de Facturas elegidas por le usuario y ejecuta sus operaciones
	 * @param opcion elegida por el usuario
	 */
	public void ejecutaOpcionMenuFacturas(MenuFacturasConsola opcion) {
		switch (opcion) {
		case EMITIR_FACTURA:
			try {
				this.IoInterface.getOperacionesFacturas().mostrarDatosFactura(
						this.gestorFacturas.emitirFactura(
								this.IoInterface.getOperacionesFacturas().emitirFactura()));
			} catch (ExcepcionClienteNoEncontrado e) {
				this.IoInterface.getOperacionesFacturas().mostrarMenjase(e.getMessage());
			}

			break;
		case BUSCAR_FACTURA_CODIGO:
			try {
				this.IoInterface.getOperacionesFacturas().mostrarDatosFactura(
						this.gestorFacturas.buscarFactura(
								this.IoInterface.getOperacionesFacturas().buscarFacturaPorCodigo()));
			} catch (ExcepcionFacturaNoEncontrada e) {
				this.IoInterface.getOperacionesFacturas().mostrarMenjase(e.getMessage());
			}
			catch (Exception e) {
				this.IoInterface.getOperacionesFacturas().mostrarMenjase(
						new ExcepcionFacturaNoEncontrada().getMessage());
			}
			break;
		case BUSCAR_FACTURAS_FECHA:
			String codCliente = this.IoInterface.getOperacionesFacturas().buscarFacturasCliente();
			try {
				this.IoInterface.getOperacionesFacturas().mostrarDatosFacturas(
						this.gestorFacturas.devolverFacturasClienteEntreDosFechas(codCliente, 
								this.IoInterface.getOperacionesFacturas().buscarFacturasClientePorFechaEmision()));
				//this.salidaInfo.salidaInfo(mensaje);
			} catch (ExcepcionClienteNoEncontrado | ExcepcionFacturaNoEncontrada e) {
				this.IoInterface.getOperacionesFacturas().mostrarMenjase(e.getMessage());
			} catch (Exception e) {
				this.IoInterface.getOperacionesFacturas().mostrarMenjase(
						new ExcepcionFacturaNoEncontrada().getMessage());
			}
			break;
		case FACTURAS_CLIENTE:
			try {
				this.IoInterface.getOperacionesFacturas().mostrarDatosFacturas(
						this.gestorFacturas.devolverFacturasCliente(
								this.IoInterface.getOperacionesFacturas().buscarFacturasCliente()));
			} catch (ExcepcionClienteNoEncontrado e) {
				this.IoInterface.getOperacionesFacturas().mostrarMenjase(e.getMessage());
			}
			break;
		case ATRAS:
			try {
				this.IoInterface.getOperacionesPrincipal().menuPincipal();
			} catch (Exception e) {
				this.IoInterface.getOperacionesFacturas().mostrarMenjase(e.getMessage());
			}
			break;
		}
	}
	
	/**
	 * Ejecuta las opciones del menu de Facturas elegidas por le usuario y ejecuta sus operaciones
	 * @param opcion elegida por el usuario
	 */
	public void ejecutaOpcionMenuLlamadas(MenuLlamadasConsola opcion) {
		String mensaje;
		switch (opcion) {
		case ALTA_LLAMADA:
			mensaje = this.gestorLlamadas.altaLlamada(this.IoInterface.getOperacionesLlamadas().realizarLLamada());
			this.IoInterface.getOperacionesLlamadas().mostrarMensaje(mensaje);
			break;
		case LLAMADAS_CLIENTE:
			try {
				this.IoInterface.getOperacionesLlamadas().mostrarLlamadas(
						this.gestorLlamadas.verLlamadasCliente(this.IoInterface.getOperacionesLlamadas().llamadasCliente()));
			} catch (ExcepcionClienteNoEncontrado | ExcepcionLlamadaNoEncontrada e) {
				this.IoInterface.getOperacionesLlamadas().mostrarMensaje(e.getMessage());
			}
			
			break;
		case LLAMADAS_CLIENTE_FECHA:
			String codCliente = this.IoInterface.getOperacionesLlamadas().llamadasCliente();
			try {
				this.IoInterface.getOperacionesLlamadas().mostrarLlamadas(
						this.gestorLlamadas.devolverLlamadasClienteEntreDosFechas(codCliente, 
								this.IoInterface.getOperacionesLlamadas().buscarLlamadasClientePorFecha()));
			} catch (ExcepcionClienteNoEncontrado
					| ExcepcionLlamadaNoEncontrada e) {
				this.IoInterface.getOperacionesLlamadas().mostrarMensaje(e.getMessage());
			}
			break;
		case ATRAS:
			try {
				this.IoInterface.getOperacionesPrincipal().menuPincipal();
			} catch (Exception e) {
				this.salidaInfo.salidaInfo(e.getMessage());
			}
			break;
		}
	}
	
}
