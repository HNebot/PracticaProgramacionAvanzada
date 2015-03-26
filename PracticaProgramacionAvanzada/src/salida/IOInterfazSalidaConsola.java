package salida;

import interfaces.IntIOInterface;
import java.util.Scanner;
import menus.*;

public class IOInterfazSalidaConsola implements IntIOInterface 
{
	private MenuPrincipalConsola menPrincipal;
	private MenuClientesConsola menClientes;
	private MenuFacturasConsola menFacturas;
	private MenuLlamadasConsola menLlamadas;
	
	private Scanner scanner;
	
	public IOInterfazSalidaConsola() {
		this.scanner = new Scanner(System.in);
		
		this.menPrincipal = new MenuPrincipalConsola(this.scanner);
		this.menClientes = new MenuClientesConsola(this.scanner);
		this.menFacturas = new MenuFacturasConsola(this.scanner);
		this.menLlamadas = new MenuLlamadasConsola(this.scanner);
	}

	@Override
	public MenuPrincipalConsola getMenuPrincipal() {
		return this.menPrincipal;
	}

	@Override
	public MenuClientesConsola getMenuClientes() {
		return this.menClientes;
	}

	@Override
	public MenuFacturasConsola getMenuFacturas() {
		return this.menFacturas;
	}

	@Override
	public MenuLlamadasConsola getMenuLlamadas() {
		return this.menLlamadas;
	}

}
