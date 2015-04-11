package gestores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import objetos.Llamada;
import baseDatos.BDLlamadas;

public class GestorLlamadas 
{
	
	private BDLlamadas dbLlamadas = new BDLlamadas();
	private final String FICHERO_LLAMADAS ="BDLlamadas.bin";
	
	private Llamada llamada;
	private GestorClientes gestorCliente;
	private GestorFacturas gestorFacturas;
	
	public GestorLlamadas() {
		super();
		recuperarDatos();
	}
	
	public void setGestorClientes(GestorClientes gestorCliente)
	{
		this.gestorCliente = gestorCliente;
	}
	public void setGestorFacturas(GestorFacturas gestorFacturas) 
	{
		this.gestorFacturas = gestorFacturas;
	}	
	
	public String altaLlamada(ArrayList<String> datos)
	{
		try{
			if(this.gestorCliente.datosCliente(datos.get(0)) == null){
				return "El cliente introducido no existe";
			}
			
			this.llamada = new Llamada(Integer.parseInt(datos.get(1)), Calendar.getInstance(),
					Integer.parseInt(datos.get(2)));
			
			if(this.dbLlamadas.altaLlamada(datos.get(0), llamada)){
				almacenarDatos();
				return "La llamada ha sido dadda de alta correctamente";
			}
			else{
				return "Error al dar de alta la llamada";
			}
		
		}
		catch(NumberFormatException e)
		{
			return "El numero de telefono o la duracion no son correctos";
		}
	}
	
	public ArrayList<Llamada> verLlamadasCliente(String nif)
	{
		return this.dbLlamadas.llamadasCliente(nif);
	}
	
	
	private void almacenarDatos() {
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
	
	private void recuperarDatos() {
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
