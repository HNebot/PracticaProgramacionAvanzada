package salida;

import interfaces.IOInterface;
import menus.MenuClientes;
import menus.MenuFacturas;
import menus.MenuLlamadas;
import menus.MenuPincipal;

public class Controlador 
{
	private MenuPincipal menPrincipal;
	private MenuClientes menClientes;
	private MenuFacturas menFacturas;
	private MenuLlamadas menLlamadas;
	
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
		inicializaMenus();
		
		byte opcion = 0;
		
		do{
            opcion = this.IoInterface.getMenuPrincipal().menuInicial();
            ejecutarOpcion(opcion);
        }while (opcion!=0);
		
		
	}
	public void inicializaGestores()
	{
		
	}
	public void inicializaMenus()
	{
		
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
            	System.out.println("nuevocliente");
            	break;
             
            default:
            	break;
        }
	}

}
