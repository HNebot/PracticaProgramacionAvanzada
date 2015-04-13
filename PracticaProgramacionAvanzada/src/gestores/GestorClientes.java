package gestores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;



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
	
	public GestorClientes(){
		super();
		recuperarDatos();
	}
	
	public void setGestorFacturas(GestorFacturas gestorFacturas)
	{
		this.gestorFacturas = gestorFacturas;
	}
	
	public String altaCliente (ArrayList<String> datos)
	{
		try{
			String mensage = "Cliente registrado";
			
			Direccion direccion = new Direccion(datos.get(5), datos.get(6), datos.get(7), 
					datos.get(8), datos.get(9), Integer.parseInt(datos.get(10)));
			Calendar fechaAlta = Calendar.getInstance();
			Tarifa tarifa = new Tarifa(Float.parseFloat(datos.get(11)));
			
			if(datos.get(0) == "E")
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
	}
	
	public Cliente datosCliente(String nif)
	{
		return this.dbCliente.buscarCliente(nif);
	}
	
	public ArrayList<Cliente> getClientes()
	{
		try{
			return this.dbCliente.buscarClientes();
		}catch(Exception e)
		{
			return new ArrayList<Cliente>();
		}
	}
	
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
