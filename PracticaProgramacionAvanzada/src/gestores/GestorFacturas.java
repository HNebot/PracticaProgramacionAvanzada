package gestores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import objetos.Cliente;
import objetos.Factura;
import objetos.Llamada;
import objetos.Tarifa;
import baseDatos.BDFacturas;

public class GestorFacturas 
{
	private BDFacturas dbFacturas = new BDFacturas();
	private final String FICHERO_FACTURAS ="BDFacturas.bin";
	private GestorClientes gestorClientes;
	
	public GestorFacturas() {
		super();
		recuperarDatos();
	}
	
	public void setGestorClientes(GestorClientes gestorClientes)
	{
		this.gestorClientes = gestorClientes;
	}
	
	public boolean crearFactura(String cliente, Tarifa tarifa)
	{
		try{
			Factura factura = new Factura(cliente, tarifa);
			this.dbFacturas.addNuevaFactura(factura, cliente);
			almacenarDatos();
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public boolean anyadirLlamada(String codCliente, Llamada llamada)
	{
		try {
			ArrayList<Factura> facturas = this.dbFacturas.buscarFacturasCliente(codCliente);
			Factura factura = facturas .get(facturas.size() - 1);
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
			
			if(llamada.getFecha().before(factura.getFechaFin()))
			{
				factura.getLlamadasFactura().add(llamada);
			}
			else{
				Cliente cliente = this.gestorClientes.datosCliente(codCliente);
				do{
					Calendar fechaInicio = (Calendar) factura.getFechaFin().clone();				
					Factura nuevaFactura = new Factura(codCliente, cliente.getTarifa());
					nuevaFactura.modificarFechaInicioYFIn(fechaInicio);
					this.dbFacturas.addNuevaFactura(nuevaFactura, codCliente);
					factura = nuevaFactura;
				}while(llamada.getFecha().before(factura.getFechaFin()));
				
				factura.getLlamadasFactura().add(llamada);
			}
			
			almacenarDatos();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Factura emitirFactura(){
		return null;
	}
	
	public Factura emitirFacturaPorCodigo(String codfactura)
	{
		return null;
	}
	
	public Factura buscarFactura(String codFactura){
		return null;
	}
	
	public ArrayList<Factura> devolverFacturasCliente(String CodCliente)
	{
		return null;
	}
	
	private void almacenarDatos() {
		ObjectOutputStream oos=null;
		try {
			try {
				FileOutputStream fos = new FileOutputStream(FICHERO_FACTURAS);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(dbFacturas);
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
				FileInputStream fis = new FileInputStream(FICHERO_FACTURAS);
				ois = new ObjectInputStream(fis);
				dbFacturas = (BDFacturas) ois.readObject();
			}
			finally {
				if(ois != null) ois.close();
			}
		}
		catch(FileNotFoundException exc) {
			System.err.println("Fichero de datos no existe. Se crea uno nuevo fichero" + FICHERO_FACTURAS + ".");
		}
		catch(IOException exc) {
			exc.printStackTrace();
		}
		catch(ClassNotFoundException exc) {
			exc.printStackTrace();
		}
		
			
	}

}
