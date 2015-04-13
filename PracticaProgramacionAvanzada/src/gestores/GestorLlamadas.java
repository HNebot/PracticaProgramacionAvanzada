package gestores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;

import comparadores.ComparadorFecha;
import excepciones.ExcepcionClienteNoEncontrado;
import excepciones.ExcepcionLlamadaNoEncontrada;
import objetos.Llamada;
import baseDatos.BDLlamadas;

public class GestorLlamadas 
{
	
	private BDLlamadas dbLlamadas = new BDLlamadas();
	private final String FICHERO_LLAMADAS ="ficherosAlmacenamiento/BDLlamadas.bin";
	
	private Llamada llamada;
	private GestorClientes gestorCliente;
	private GestorFacturas gestorFacturas;
	
	public GestorLlamadas() {
		super();
		recuperarDatos();
	}
	
	/**
	 * Añade un gestor de clientes para crear inteccion entre los gestores.
	 * @param gestorCliente
	 */
	public void setGestorClientes(GestorClientes gestorCliente)
	{
		this.gestorCliente = gestorCliente;
	}
	/**
	 * Añade un gestor de facturas para crear inteccion entre los gestores.
	 * @param gestorFacturas
	 */
	public void setGestorFacturas(GestorFacturas gestorFacturas) 
	{
		this.gestorFacturas = gestorFacturas;
	}	
	
	/**
	 * Da de alta una llamada con los datos que se le pasan mediante una lista de String
	 * Crea la llamada y llama la gestor de facturas para asignarla a una factura determinada.
	 * @param datos
	 * @return
	 * @throws ExcepcionClienteNoEncontrado 
	 */
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
				this.gestorFacturas.anyadirLlamada(datos.get(0), llamada);
				return "La llamada ha sido dadda de alta correctamente";
			}
			else{
				return "Error al dar de alta la llamada";
			}
		
		}
		catch(NumberFormatException e)
		{
			return "El numero de telefono o la duracion no son correctos";
		} catch (ExcepcionClienteNoEncontrado e) {
			return e.getMessage();
		}
	}
	
	/**
	 * Devuelve todas las llamadas de un cliente.
	 * @param nif
	 * @return listado de llamadas.
	 * @throws ExcepcionClienteNoEncontrado 
	 */
	public ArrayList<Llamada> verLlamadasCliente(String nif) throws ExcepcionClienteNoEncontrado
	{
		return this.dbLlamadas.llamadasCliente(nif);
	}
	
	/**
	 * Devuelve un lista con las llamadas de un cliente que se han realizado 
	 * en las dos fechas que estan dentro de la lista que se pasa por parametro.
	 * Llama al metodo estatico de la calse CoparadorFechas para realizar la operacion de filtrado
	 * @param codCliente
	 * @param filtradoFechas
	 * @return listado con las llamadas filtradas del cliente.
	 * @throws ExcepcionClienteNoEncontrado, ExcepcionLlamadaNoEncontrada 
	 */
	public ArrayList<Llamada> devolverLlamadasClienteEntreDosFechas(String codCliente, ArrayList<Calendar> filtradoFechas) throws ExcepcionClienteNoEncontrado, ExcepcionLlamadaNoEncontrada
	{
		return ComparadorFecha.buscarEntreDosFechas(this.verLlamadasCliente(codCliente), 
				filtradoFechas.get(0), filtradoFechas.get(1));
	}
	
	/**
	 * Almacena los datos en un fichero binario determinado para no perder los datos
	 */
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
	
	/**
	 * Recupera los datos almacenados en el fichero binario.
	 */
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
