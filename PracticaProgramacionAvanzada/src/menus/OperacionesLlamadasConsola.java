package menus;

import interfaces.IntMenuLlamadas;

import java.util.Scanner;

public class OperacionesLlamadasConsola implements IntMenuLlamadas
{
	private Scanner scanner;
	
	public OperacionesLlamadasConsola(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public OperacionesLlamadasConsola() {
		
	}

}
