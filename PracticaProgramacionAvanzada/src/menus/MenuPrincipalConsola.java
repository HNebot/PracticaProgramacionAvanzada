package menus;

import interfaces.IntLectura;
import interfaces.IntMenuPrincipal;

import java.util.Scanner;

public class MenuPrincipalConsola implements IntMenuPrincipal{
	
	private Scanner scanner;
	private IntLectura lecturaTeclado;
	private final String MENUPRINCIPAL =""; 
	
	public MenuPrincipalConsola(Scanner scanner) {
		this.scanner = scanner;
	}
	public MenuPrincipalConsola(IntLectura lecturaTeclado) {
		this.lecturaTeclado = lecturaTeclado;
	}
	
	@Override
	public String getMenu()
	{
		System.out.println("Elija una opcion del menu:");
		System.out.println("1- Operaciones sobre clientes.");
		System.out.println("2- Operaciones sobre facturas.");
		System.out.println("3- Operaciones sobre llamadas.");
		System.out.println("0- Salir.");
		System.out.print("-->");
		
		return "";
	}

}
