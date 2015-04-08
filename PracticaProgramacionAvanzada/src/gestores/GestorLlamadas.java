package gestores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import baseDatos.BDLlamadas;

public class GestorLlamadas 
{
	
	private BDLlamadas dbLlamadas = new BDLlamadas();
	private final String FICHERO_LLAMADAS ="BDLlamadas.bin";
	
	public GestorLlamadas() {
		super();
		recuperarDatos();
	}
	
	
	public void almacenarDatos() {
		ObjectOutputStream oos=null;
		try {
			try {
				FileOutputStream fos = new FileOutputStream(FICHERO_LLAMADAS);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(dbLlamadas);
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
				FileInputStream fis = new FileInputStream(FICHERO_LLAMADAS);
				ois = new ObjectInputStream(fis);
				dbLlamadas = (BDLlamadas) ois.readObject();
			}
			finally {
				if(ois != null) ois.close();
			}
		}
		catch(FileNotFoundException exc) {
			System.err.println("Fichero de datos no existe. Se crea uno nuevo fichero" + FICHERO_LLAMADAS + ".");
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc) {
			exc.printStackTrace();
		}
		
			
	}

}
