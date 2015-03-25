package salida;

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
	
	public Controlador() {
		// TODO Auto-generated constructor stub
	}
	
	public void start()
	{
		inicializaGestores();
		inicializaMenus();
		
		byte opcion = 0;
		
		do{
            opcion = this.menPrincipal.menuInicial();
            ejecutarOpcion(opcion);
        }while (opcion!=0);
		
		
	}
	public void inicializaGestores()
	{
		
	}
	public void inicializaMenus()
	{
		this.menPrincipal = new MenuPincipal();
		this.menClientes = new MenuClientes();
		this.menFacturas = new MenuFacturas();
		this.menLlamadas = new MenuLlamadas();
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
            	opcion = (byte) ((opcion*10) + this.menClientes.menuInicialClientes());
            	ejecutarOpcion(opcion);
                break;
            case 2: 
            	//Ejecuta el menu sobre las facturas
            	opcion = (byte) ((opcion*10) + this.menFacturas.menuInicialFacturas());
            	ejecutarOpcion(opcion);
            	break;
            	
            case 3: 
            	//Ejecuta el menu sobre las llamadas
            	opcion = (byte) ((opcion*10) + this.menLlamadas.menuInicialLlamadas());
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
