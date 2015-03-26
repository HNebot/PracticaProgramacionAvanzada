package salida;

import java.util.ArrayList;

import objetos.Cliente;
import gestores.GestorCliente;
import gestores.GestorFactura;
import gestores.GestorLlamada;
import interfaces.IOInterface;

public class Controlador 
{
	private GestorCliente gestorCliente;
	private GestorFactura gestorFactura;
	private GestorLlamada gestorLlamada;
	
	private IOInterface IoInterface;
	
	public Controlador() {
		super();
	}
	
	public void SetInterface (IOInterface IoInterface)
	{
		this.IoInterface = IoInterface;
	}
	
	public void start()
	{
		inicializaGestores();
		
		byte opcion = 0;
		
		do{
            opcion = this.IoInterface.getMenuPrincipal().menuInicial();
            ejecutarOpcion(opcion);
        }while (opcion!=0);
		
		
	}
	public void inicializaGestores()
	{
		this.gestorCliente = new GestorCliente();
		this.gestorFactura = new GestorFactura();
		this.gestorLlamada = new GestorLlamada();
	}
	
	/**
	 * Ejecuta las opciones elegidas por le usuario y ejecuta sus operaciones
	 * Se usa de forma recursiva
	 * @param opcion
	 */
	private void ejecutarOpcion(byte opcion) {
        switch (opcion){
            case 1: 
            	//Ejecuta el menu sobre los clientes
            	opcion = (byte) ((opcion*10) + this.IoInterface.getMenuClientes().menuInicial());
            	ejecutarOpcion(opcion);
                break;
            case 2: 
            	//Ejecuta el menu sobre las facturas
            	opcion = (byte) ((opcion*10) + this.IoInterface.getMenuFacturas().menuInicial());
            	ejecutarOpcion(opcion);
            	break;
            	
            case 3: 
            	//Ejecuta el menu sobre las llamadas
            	opcion = (byte) ((opcion*10) + this.IoInterface.getMenuLlamadas().menuInicial());
            	ejecutarOpcion(opcion);
            	break;
            	
            case 11:
            	//ArrayList<String> datos = this.IoInterface.getMenuClientes().menuNuevoCliente();
            	ArrayList<String> datos = new ArrayList();
        		datos.add("P");
        		datos.add("Hector");
        		datos.add("123S");
        		datos.add("n@gmail.com");
        		datos.add("Avd Pio XII");
        		datos.add("17");
        		datos.add("2D");
        		datos.add("Vila-real");
        		datos.add("Castellon");
        		datos.add("12540");
        		datos.add("0.03");
        		datos.add("Nebot");
            	String mensaje = this.gestorCliente.altaCliente(datos);
            	
            	break;
            	
            case 12:
            	
            	Cliente cli = this.gestorCliente.datosCliente(this.IoInterface.getMenuClientes().menuVerCliente());
            	this.IoInterface.getMenuClientes().formatoInfoCliente(cli);
            	break;
             
            default:
            	break;
        }
	}

}
