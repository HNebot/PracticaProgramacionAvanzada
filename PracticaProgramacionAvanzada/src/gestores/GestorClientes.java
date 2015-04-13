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
import baseDatos.BDClientes;
import objetos.Cliente;
import objetos.Direccion;
import objetos.Empresa;
import objetos.Particular;
import objetos.Tarifa;

public class GestorClientes
{
	private Cliente cliente;
	private BDClientes dbCliente = new BDClientes();
	private final String FICHERO_CLIENTES ="ficherosAlmacenamiento/BDClientes.bin";
	private GestorFacturas gestorFacturas;
	//private GestorAlmacenamientoFichero<BDClientes> datosClientes = 
	//		new GestorAlmacenamientoFichero<BDClientes>(dbCliente, FICHERO_CLIENTES);
	
	/**
	 * Contructor principal del gestor de clientes. Cuando el objeto se instancia carga los datos guardados en el dico
	 */
	public GestorClientes(){
		super();
		recuperarDatos();
	}
	
	/**
	 * Asigna un objeto para gestionar las facturas
	 * @param gestorFacturas
	 */
	public void setGestorFacturas(GestorFacturas gestorFacturas)
	{
		this.gestorFacturas = gestorFacturas;
	}
	
	/**
	 * Crea un cliente con los datos que se han proporcinado en la lista. La fecha de alta se genera automaticamente.
	 * Luego llama  a la funcion addNuevoCliente() para guardarla en al base de datos.
	 * Si el cliente se crea correctaemnte se le genera una factura de forma automatica
	 * Llama al metodo almacenarDatos() para guarda los datos en un fichero en el disco
	 * @param datos, una lista con todos los datos del cliente que se va a crear
	 * @return Un mensaje indicando si la operacion ha tenido exito
	 */
	public String altaCliente (ArrayList<String> datos)
	{
		try{
			String mensage = "Cliente registrado";
			
			Direccion direccion = new Direccion(datos.get(5), datos.get(6), datos.get(7), 
					datos.get(8), datos.get(9), Integer.parseInt(datos.get(10)));
			Calendar fechaAlta = Calendar.getInstance();
			Tarifa tarifa = new Tarifa(Float.parseFloat(datos.get(11)));
			
			if(datos.get(0).equals("E"))
			{
				this.cliente = new Empresa(datos.get(1), datos.get(2), datos.get(3), Integer.parseInt(datos.get(4)), direccion, fechaAlta, tarifa);
			}
			else
			{
				this.cliente = new Particular(datos.get(1), datos.get(2), datos.get(3), Integer.parseInt(datos.get(4)), direccion, fechaAlta, tarifa, datos.get(12));
			}
			
			if(!dbCliente.addNuevoCliente(cliente))
			{
				mensage = "No se pudo dar de alta el cliente. \n Ya existe.";
				return mensage;
			}

			almacenarDatos();
			this.gestorFacturas.crearFactura(cliente.getNIF(), cliente.getTarifa());
			return mensage;
		}
		catch(NumberFormatException ex)
		{
			return "Error de formato.Introduzca los datos correctamente";
		}
		catch (Exception e) {
			return "El cliente no se pudo crear";
		}
	}
	
	/**
	 * Devuelve un cliente que coresponda al condigo que se le pasa por parametro
	 * @param nuff del cliente a guscar
	 * @return un objeto cliente
	 * @throws ExcepcionClienteNoEncontrado 
	 */
	public Cliente datosCliente(String nif) throws ExcepcionClienteNoEncontrado
	{
		return this.dbCliente.buscarCliente(nif);
	}
	
	/**
	 * LLama al metodo buscarCliente del bojeto dBclientes para obtener todos los clientes
	 * @return Un listado con todos los clientes de la base de datos
	 */
	public ArrayList<Cliente> getClientes() throws ExcepcionClienteNoEncontrado
	{
		try{
			return this.dbCliente.buscarClientes();
		}catch(Exception e)
		{
			return new ArrayList<Cliente>();
		}
	}
	
	/**
	 * Busca un cliente y actualiza la tarifa con la nueva que se pasa por parametro
	 * @param El nif del cliente al que se le modificara al tarifa
	 * @param El valor de la nueva tarifa
	 * @return Un mensaje indicando si la operacio ha tenido exito.
	 */
	@SuppressWarnings("finally")
	public String actualizarTarifa(String nif, String nuevaTarifa)
	{	
		String mensaje = "";
		try
		{
			Cliente cliente = this.datosCliente(nif);
			cliente.getTarifa().setTarifa(Float.parseFloat(nuevaTarifa));
			mensaje = "Tarifa actualizada";
		}
		catch(NumberFormatException e)
		{
			mensaje = "Error. La tarifa no es correcta";
		}
		catch(Exception e)
		{
			mensaje = e.getMessage();
		}
		finally
		{
			almacenarDatos();
			return mensaje;
		}
		
	}
	
	/**
	 * Devuelve un lista con los clientes que se han dado de alta 
	 * en las dos fechas que estan dentro de la lista que se pasa por parametro.
	 * Llama al metodo estatico de la calse CoparadorFechas para realizar la operacion de filtrado
	 * @param fechasDeFiltrado, listado con las dos fechas para filtrar los datos
	 * @return Un listado con los objetos que cumplen la condicion. Retorna null si hay algun error o no existen clientes
	 * @throws ExcepcionClienteNoEncontrado 
	 */
	public ArrayList<Cliente> buscarClientePorFechaAlta(ArrayList<Calendar> fechasDeFiltrado) throws ExcepcionClienteNoEncontrado
	{
		try{
			return ComparadorFecha.buscarEntreDosFechas(getClientes(), fechasDeFiltrado.get(0), fechasDeFiltrado.get(1));
		}catch(NullPointerException e)
		{
			return null;
		}
	}
	
	/**
	 * Almacena los datos en un fichero binario determinado para no perder los datos
	 */
	
	private void almacenarDatos() {
		ObjectOutputStream oos=null;
		try {
			try {
				FileOutputStream fos = new FileOutputStream(FICHERO_CLIENTES);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(dbCliente);
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
				FileInputStream fis = new FileInputStream(FICHERO_CLIENTES);
				ois = new ObjectInputStream(fis);
				dbCliente = (BDClientes)ois.readObject();
			}
			finally {
				if(ois != null) ois.close();
			}
		}
		catch(FileNotFoundException exc) {
			System.err.println("Fichero de datos no existe. Se crea uno nuevo fichero" + FICHERO_CLIENTES + ".");
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc) {
			exc.printStackTrace();
		}
		
			
	}

}
