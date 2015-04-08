package main;

import java.util.ArrayList;
import java.util.Scanner;

import menus.MenuClientesConsola;
import menus.MenuPrincipalConsola;
import objetos.Cliente;
import interfaces.IntIOInterface;
import interfaces.IntLectura;
import interfaces.IntMenu;
import interfaces.IntSalidaInfo;

public class Controlador 
{
	//private GestorCliente gestorCliente;
	//private GestorFactura gestorFactura;
	//private GestorLlamada gestorLlamada;
	
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
		MenuPrincipalConsola op;
		Scanner scanner = new Scanner(System.in);
		do {
			this.salidaInfo.salidaInfo(MenuPrincipalConsola.getMenu());
			op = MenuPrincipalConsola.getOpcion(this.lecturaDatos.lecturaEnteros());
			ejecutaOpcionMenuPrincipal(op);
		} while (op != MenuPrincipalConsola.SALIR);
		scanner.close();
	}

	/**
	 * Inicializamos todos los gestores para interactuar con el modelo
	 */
	public void inicializaGestores()
	{
		//this.gestorCliente = new GestorCliente();
		//this.gestorFactura = new GestorFactura();
		//this.gestorLlamada = new GestorLlamada();
	}
	
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
        	//mensaje = this..altaCliente(datos);
        	//this.IoInterface.getMenuClientes().mostrarMensaje(mensaje);
			break;
			
		case BUSCAR_CLIENTE_DNI:
			//Cliente cli = this.gestorCliente.datosCliente(this.IoInterface.getMenuClientes().menuVerCliente());
        	//this.IoInterface.getMenuClientes().formatoInfoCliente(cli);
			break;
			
		case BUSCAR_CLIENTE_ALTA:
			break;
			
		case VER_CLIENTES:
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
	/*private void ejecutarOpcion(String opcion) {
		String mensaje;
		byte opt = Byte.parseByte(opcion);
        switch (opt){
            case 1: 
            	//Ejecuta el menu sobre los clientes
            	//opcion = (byte) ((opcion*10) + this.IoInterface.getMenuClientes().menuInicial());
            	//ejecutarOpcion(opcion);
                break;
            case 2: 
            	//Ejecuta el menu sobre las facturas
            	//opcion = (byte) ((opcion*10) + this.IoInterface.getMenuFacturas().menuInicial());
            	//ejecutarOpcion(opcion);
            	break;
            	
            case 3: 
            	//Ejecuta el menu sobre las llamadas
            	//opcion = (byte) ((opcion*10) + this.IoInterface.getMenuLlamadas().menuInicial());
            	//ejecutarOpcion(opcion);
            	break;
            	
            case 11:
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
            	mensaje = this.gestorCliente.altaCliente(datos);
            	//this.IoInterface.getMenuClientes().mostrarMensaje(mensaje);
            	
            	break;
            	
            case 12:
            	
            	//Cliente cli = this.gestorCliente.datosCliente(this.IoInterface.getMenuClientes().menuVerCliente());
            	//this.IoInterface.getMenuClientes().formatoInfoCliente(cli);
            	break;
            
            case 13:
            	//this.IoInterface.getMenuClientes().mostrarClientes(this.gestorCliente.getClientes());
            	break;
            
            case 14:
            	//String nif = this.IoInterface.getMenuClientes().menuVerCliente();
            	//String tarifa = this.IoInterface.getMenuClientes().actualizarTarifa();
            	//mensaje = this.gestorCliente.actualizarTarifa(nif, tarifa);
            	//this.IoInterface.getMenuClientes().mostrarMensaje(mensaje);
            	break;
             
            default:
            	break;
        }
	}*/

}
