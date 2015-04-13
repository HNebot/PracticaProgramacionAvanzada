package main;

import java.util.ArrayList;
import java.util.Scanner;

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
	 */
	public void start()
	{
		inicializaGestores();
		MenuPrincipalConsola op;
		do {
			this.salidaInfo.salidaInfo(MenuPrincipalConsola.getMenu());
			op = MenuPrincipalConsola.getOpcion(this.lecturaDatos.lecturaEnteros());
			ejecutaOpcionMenuPrincipal(op);
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
	 * @param opcion
	 */
	private void ejecutaOpcionMenuPrincipal(MenuPrincipalConsola opcion) {
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
		}
		
	}
	
	/**
	 * Ejecuta las opciones sobre los clientes elegidas por le usuario y ejecuta sus operaciones
	 * @param opcion
	 */
	private void ejecutaOpcionMenuCliente(MenuClientesConsola opcion) {
		String mensaje;
		switch (opcion) {
		case NUEVO_CLIENTE:
			ArrayList<String> datos = this.IoInterface.getOperacionesClientes().menuNuevoCliente();
        	mensaje = this.gestorClientes.altaCliente(datos);
        	this.IoInterface.getOperacionesClientes().mostrarMensaje(mensaje);
			break;
			
		case BUSCAR_CLIENTE_DNI:
			Cliente cli = this.gestorClientes.datosCliente(this.IoInterface.getOperacionesClientes().menuVerCliente());
        	this.IoInterface.getOperacionesClientes().formatoInfoCliente(cli);
			break;
			
		case BUSCAR_CLIENTE_ALTA:
			this.IoInterface.getOperacionesClientes().mostrarClientes(
					this.gestorClientes.buscarClientePorFechaAlta(
							this.IoInterface.getOperacionesClientes().buscarClientesPorFechaAlta()));
			break;
			
		case VER_CLIENTES:
			this.IoInterface.getOperacionesClientes().mostrarClientes(this.gestorClientes.getClientes());
        	break;
        	
		case MODIFICAR_TARIFA:
			String nif = this.IoInterface.getOperacionesClientes().menuVerCliente();
        	String tarifa = this.IoInterface.getOperacionesClientes().actualizarTarifa();
        	mensaje = this.gestorClientes.actualizarTarifa(nif, tarifa);
        	this.IoInterface.getOperacionesClientes().mostrarMensaje(mensaje);
        	break;
			
		case ATRAS:
			break;
		}
	}
	
	/**
	 * Ejecuta las opciones del menu de Facturas elegidas por le usuario y ejecuta sus operaciones
	 * @param opcion
	 */
	private void ejecutaOpcionMenuFacturas(MenuFacturasConsola opcion) {
		String mensaje;
		switch (opcion) {
		case EMITIR_FACTURA:
			mensaje = this.IoInterface.getOperacionesFacturas().mostrarDatosFactura(
					this.gestorFacturas.emitirFactura(
							this.IoInterface.getOperacionesFacturas().emitirFactura()));
			this.salidaInfo.salidaInfo(mensaje);
			break;
		case BUSCAR_FACTURA_CODIGO:
			mensaje = this.IoInterface.getOperacionesFacturas().mostrarDatosFactura(
					this.gestorFacturas.buscarFactura(
							this.IoInterface.getOperacionesFacturas().buscarFacturaPorCodigo()));
			this.salidaInfo.salidaInfo(mensaje);
			break;
		case BUSCAR_FACTURAS_FECHA:
			String codCliente = this.IoInterface.getOperacionesFacturas().buscarFacturasCliente();
			mensaje = this.IoInterface.getOperacionesFacturas().mostrarDatosFacturas(
					this.gestorFacturas.devolverFacturasClienteEntreDosFechas(codCliente, 
							this.IoInterface.getOperacionesFacturas().buscarFacturasClientePorFechaEmision()));
			this.salidaInfo.salidaInfo(mensaje);
			break;
		case FACTURAS_CLIENTE:
			mensaje = this.IoInterface.getOperacionesFacturas().mostrarDatosFacturas(
					this.gestorFacturas.devolverFacturasCliente(
							this.IoInterface.getOperacionesFacturas().buscarFacturasCliente()));
			salidaInfo.salidaInfo(mensaje);
			break;
		case ATRAS:
			break;
		}
	}
	
	/**
	 * Ejecuta las opciones del menu de Facturas elegidas por le usuario y ejecuta sus operaciones
	 * @param opcion
	 */
	private void ejecutaOpcionMenuLlamadas(MenuLlamadasConsola opcion) {
		String mensaje;
		switch (opcion) {
		case ALTA_LLAMADA:
			mensaje = this.gestorLlamadas.altaLlamada(this.IoInterface.getOperacionesLlamadas().realizarLLamada());
			this.salidaInfo.salidaInfo(mensaje);
			break;
		case LLAMADAS_CLIENTE:
			mensaje = this.IoInterface.getOperacionesLlamadas().mostrarLlamadas(
					this.gestorLlamadas.verLlamadasCliente(this.IoInterface.getOperacionesLlamadas().llamadasCliente()));
			this.salidaInfo.salidaInfo(mensaje);
			break;
		case LLAMADAS_CLIENTE_FECHA:
			String codCliente = this.IoInterface.getOperacionesLlamadas().llamadasCliente();
			mensaje = this.IoInterface.getOperacionesLlamadas().mostrarLlamadas(
					this.gestorLlamadas.devolverLlamadasClienteEntreDosFechas(codCliente, 
							this.IoInterface.getOperacionesLlamadas().buscarLlamadasClientePorFecha()));
			this.salidaInfo.salidaInfo(mensaje);
			break;
		case ATRAS:
			break;
		}
	}
	
}
