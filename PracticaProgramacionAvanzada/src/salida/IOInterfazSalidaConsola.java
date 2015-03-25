package salida;

import interfaces.IOInterface;
import interfaces.Menu;

import java.util.Scanner;

import menus.MenuClientes;
import menus.MenuFacturas;
import menus.MenuLlamadas;
import menus.MenuPincipal;

public class IOInterfazSalidaConsola implements IOInterface 
{
	private MenuPincipal menPrincipal;
	private MenuClientes menClientes;
	private MenuFacturas menFacturas;
	private MenuLlamadas menLlamadas;
	
	private Scanner scanner;
	
	public IOInterfazSalidaConsola() {
		this.scanner = new Scanner(System.in);
		
		this.menPrincipal = new MenuPincipal(this.scanner);
		this.menClientes = new MenuClientes(this.scanner);
		this.menFacturas = new MenuFacturas(this.scanner);
		this.menLlamadas = new MenuLlamadas(this.scanner);
	}

	@Override
	public Menu getMenuPrincipal() {
		return this.menPrincipal;
	}

	@Override
	public Menu getMenuClientes() {
		return this.menClientes;
	}

	@Override
	public Menu getMenuFacturas() {
		return this.menFacturas;
	}

	@Override
	public Menu getMenuLlamadas() {
		return this.menLlamadas;
	}

}
