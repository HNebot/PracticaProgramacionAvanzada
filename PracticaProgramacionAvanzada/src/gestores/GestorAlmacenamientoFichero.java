package gestores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestorAlmacenamientoFichero<T> 
{
	private T obj;
	private String fichero;
	public GestorAlmacenamientoFichero(T obj, String fichero) {
		this.obj = obj;
		this.fichero = fichero;
	}
	
	public void almacenarDatos() {
		ObjectOutputStream oos=null;
		try {
			try {
				FileOutputStream fos = new FileOutputStream(fichero);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(obj);
			}
			finally {
				oos.close();
			}
		}
		catch(FileNotFoundException exc) {
			System.out.println("El fichero no existe.");
			exc.printStackTrace();
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		
	}
	
	public void recuperarDatos() {
		ObjectInputStream ois = null;
		try{
			try {
				FileInputStream fis = new FileInputStream(fichero);
				ois = new ObjectInputStream(fis);
				obj = (T) ois.readObject();
			}
			finally {
				if(ois != null) ois.close();
			}
		}
		catch(FileNotFoundException exc) {
			System.err.println("Fichero de datos no existe. Se crea uno nuevo.");
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc) {
			exc.printStackTrace();
		}
		
			
	}
}

