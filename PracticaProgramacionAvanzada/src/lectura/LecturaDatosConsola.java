package lectura;

import java.util.Scanner;

import interfaces.IntLectura;
/**
 * Clase para las operaciones de lectura de datos. Implemente la interfaz IntLectura
 * @author Hector
 *
 */
public class LecturaDatosConsola implements IntLectura {

	private Scanner scanner;
	
	/**
	 * Constuctor de la clase
	 * instancia un objeto de tipo Scanner
	 */
	public LecturaDatosConsola() {
		this.scanner = new Scanner(System.in);
	}
	
	/**
	 * Lee y devuelve los datos de tipo String del teclado de la consola
	 * @return la lectura de teclado
	 */
	@Override
	public String lecturaDatos() {
		try{
			return this.scanner.nextLine();
		}catch(Exception e)
		{
			this.scanner.close();
			this.scanner = new Scanner(System.in);
			return null;
		}
	}
	
	/**
	 * Lee y devuelve los datos de tipo entero del teclado de la consola
	 * @return la lectura de teclado
	 */
	@Override
	public int lecturaEnteros() {
		try{
			int num = this.scanner.nextInt();
			this.scanner.nextLine();
			return num;
		}catch(Exception e)
		{
			this.scanner.close();
			this.scanner = new Scanner(System.in);
			return -1;
		}
	}
	
	

}
