package main;

import java.util.ArrayList;
import java.util.Scanner;

import menus.MenuClientesConsola;
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
	public void inicializaGestores()
	{
		this.gestorClientes = new GestorClientes();
		this.gestorFacturas = new GestorFacturas();
		this.gestorLlamadas = new GestorLlamadas();
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
			break;
		case LLAMADAS:
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
			//ArrayList<String> datos = this.IoInterface.getMenuClientes().menuNuevoCliente();
        	ArrayList<String> datos = new ArrayList();
    		datos.add("P");
    		datos.add("Hector");
    		datos.add("123S");
    		datos.add("n@gmail.com");
    		datos.add("111222333");
    		datos.add("Avd Pio XII");
    		datos.add("17");
    		datos.add("2D");
    		datos.add("Vila-real");
    		datos.add("Castellon");
    		datos.add("12540");
    		datos.add("0.03");
    		datos.add("Nebot");
        	mensaje = this.gestorClientes.altaCliente(datos);
        	this.IoInterface.getOperacionesClientes().mostrarMensaje(mensaje);
			break;
			
		case BUSCAR_CLIENTE_DNI:
			Cliente cli = this.gestorClientes.datosCliente(this.IoInterface.getOperacionesClientes().menuVerCliente());
        	this.IoInterface.getOperacionesClientes().formatoInfoCliente(cli);
			break;
			
		case BUSCAR_CLIENTE_ALTA:
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
	 * Ejecuta las opciones elegidas por le usuario y ejecuta sus operaciones
	 * Se usa de forma recursiva
	 * @param opcion
	 */
	
}
