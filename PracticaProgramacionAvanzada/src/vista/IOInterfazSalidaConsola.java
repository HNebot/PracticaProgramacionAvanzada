package vista;

import controlador.Controlador;
import operaciones.OperacionesClientesConsola;
import operaciones.OperacionesFacturasConsola;
import operaciones.OperacionesLlamadasConsola;
import operaciones.OperacionesPrincipalConsola;
import interfaces.IntIOInterface;
import interfaces.IntOperacionesClientes;
import interfaces.IntOperacionesFacturas;
import interfaces.IntOperacionesLlamadas;
import interfaces.IntOperacionesPrincipal;

/**
 * Clase para gestionar la salida de los datos por pantalla, en esta clase se gestiona la salida por consola.
 * Implemtena la interfaz IntIOInterface
 * @author Hector
 */
public class IOInterfazSalidaConsola implements IntIOInterface 
{
	private OperacionesPrincipalConsola opPrincipal;
	private OperacionesClientesConsola opClintes;
	private OperacionesFacturasConsola opFacturas;
	private OperacionesLlamadasConsola opLlamadas;
	private Controlador controlador;
	
	
	/**
	 * Contructor de la clase donde se intancian los menus de operaciones
	 */
	public IOInterfazSalidaConsola() {
		this.opPrincipal = new OperacionesPrincipalConsola();
		this.opClintes = new OperacionesClientesConsola();
		this.opFacturas = new OperacionesFacturasConsola();
		this.opLlamadas = new OperacionesLlamadasConsola();
	}
	
	@Override
	public IntOperacionesPrincipal getOperacionesPrincipal() {
		return this.opPrincipal;
	}

	@Override
	public IntOperacionesClientes getOperacionesClientes() {
		return this.opClintes;
	}

	@Override
	public IntOperacionesFacturas getOperacionesFacturas() {
		return this.opFacturas;
	}

	@Override
	public IntOperacionesLlamadas getOperacionesLlamadas() {
		return this.opLlamadas;
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		this.opClintes.setControlador(this.controlador);
		this.opFacturas.setControlador(this.controlador);
		this.opPrincipal.setControlador(this.controlador);
		this.opLlamadas.setControlador(this.controlador);		
	}
	
	@Override
	public void start()
	{	while(true){
			try {
				this.opPrincipal.menuPincipal();
			} catch (Exception e) {
				System.out.println("Opcion Incorrecta");
			}
		}
	}


}
