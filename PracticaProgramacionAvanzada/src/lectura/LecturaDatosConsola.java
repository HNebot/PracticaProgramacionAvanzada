package lectura;

import java.util.Scanner;

import interfaces.IntLectura;

public class LecturaDatosConsola implements IntLectura {

	private Scanner scanner;
	
	public LecturaDatosConsola() {
		this.scanner = new Scanner(System.in);
	}
	@Override
	public String lecturaDatos() {
		return this.scanner.nextLine();
	}
	@Override
	public int lecturaEnteros() {
		return this.scanner.nextInt();
	}
	
	

}
