package interfaces;

import controlador.Controlador;

public interface IntIOInterface {
	
	
	public void setControlador(Controlador controlador);
	
	
	public IntOperacionesPrincipal getOperacionesPrincipal();
	/**
	 * Devuelve un objeto con el que se se getionan las operaciones sobre los cliente por pantalla
	 * @return un opbjeto que implemtente la interfaz IntMenuClientes
	 */
	public IntOperacionesClientes getOperacionesClientes();
	
	/**
	 * Devuelve un objeto con el que se se getionan las operaciones sobre las facturas por pantalla
	 * @return un opbjeto que implemtente la interfaz IntMenuFacturas
	 */
	public IntOperacionesFacturas getOperacionesFacturas();
	/**
	 * Devuelve un objeto con el que se se getionan las operaciones sobre las llamadas por pantalla
	 * @return un opbjeto que implemtente la interfaz IntMenuLlamadas
	 */
	public IntOperacionesLlamadas getOperacionesLlamadas();
	
	public void start();
	//public IntMenu menuPrincipal();
	//public IntMenu menuClientes();
	//public IntMenu menuLLamadas();
	//public IntMenu menuFacturas();

}
