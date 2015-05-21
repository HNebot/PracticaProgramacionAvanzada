package gestores;

import interfaces.IntModeloGestor;

public class GestorManager implements IntModeloGestor {
	
	private GestorClientes gestorClientes;
	private GestorFacturas gestorFacturas;
	private GestorLlamadas gestorLlamadas;
	
	public GestorManager() {
		this.gestorClientes = new GestorClientes();
		this.gestorFacturas = new GestorFacturas();
		this.gestorLlamadas = new GestorLlamadas();
		
		this.gestorClientes.setGestorFacturas(this.gestorFacturas);
		this.gestorFacturas.setGestorClientes(this.gestorClientes);
		this.gestorLlamadas.setGestorClientes(this.gestorClientes);
		this.gestorLlamadas.setGestorFacturas(this.gestorFacturas);
	}

	@Override
	public GestorClientes getGestorCliente() {
		return this.gestorClientes;
	}

	@Override
	public GestorFacturas getGestorFacturas() {
		return this.gestorFacturas;
	}

	@Override
	public GestorLlamadas getGestorLlamadas() {
		return this.gestorLlamadas;
	}

}
