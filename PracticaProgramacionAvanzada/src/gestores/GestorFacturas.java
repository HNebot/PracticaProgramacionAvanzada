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
import comparadores.ComparadorFecha;

import objetos.Cliente;
import objetos.Factura;
import objetos.Llamada;
import objetos.Tarifa;
import baseDatos.BDFacturas;

public class GestorFacturas 
{
	private BDFacturas dbFacturas = new BDFacturas();
	private final String FICHERO_FACTURAS ="ficherosAlmacenamiento/BDFacturas.bin";
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
	
	/**
	 * Añade una llamada a la ultima factura del cliente, 
	 * si la llamda es posterior a la fecha de finalizacion de la ultima factura se crea una nueva, ya que las facturas son mensuales.
	 * @param codCliente: el codigo del cliente que realiza la llamda i al que pertenece la factura.
	 * @param llamada: la llamada qeu se añadira a la factura actual.
	 * @return devuelfe true si se ha añadido correctamente, false si ha ahbiado algun error.
	 */
	public boolean anyadirLlamada(String codCliente, Llamada llamada)
	{
		try {
			ArrayList<Factura> facturas = this.dbFacturas.buscarFacturasCliente(codCliente);
			Factura factura = facturas .get(facturas.size() - 1);
			
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
	
	/**
	 * Busca la ultima factura sin emitir y la devuelve asignando la fecha actual como fecha de emision.
	 * Si la fecha de emision es anterior a la de fin de factura esta ultima se actualiza a la de emision.
	 * Se crea una nueva factura si la que se emite es la ultima.
	 * @param El  codigo del cliente al que se le emite la factura.
	 * @return Un objeto factura si se emite. Si hay algun fallo retorna null.
	 */
	public Factura emitirFactura(String codCliente){
		ArrayList<Factura> listaFacturas = this.devolverFacturasCliente(codCliente);
		Factura factura;
		try{
			for(int i = 0;  i < listaFacturas.size(); i++)
			{
				factura = listaFacturas.get(i);
				if(factura.getFecha() == null)
				{
					Calendar fechaEmision = Calendar.getInstance();
					factura.setFecha(fechaEmision);
					if(fechaEmision.before(factura.getFechaFin()))
					{
						factura.setFechaFin(fechaEmision);
						Cliente cliente = this.gestorClientes.datosCliente(codCliente);
						this.crearFactura(codCliente, cliente.getTarifa());
					}
					almacenarDatos();
					return factura;
				}
			}
		}
		catch(Exception e){
			almacenarDatos();
			return null;
		}
		return null;
	}
	
	public Factura emitirFacturaPorCodigo(String codfactura)
	{
		return null;
	}
	
	public Factura buscarFactura(String codFactura){
		return this.dbFacturas.buscarFactura(codFactura);
	}
	
	public ArrayList<Factura> devolverFacturasCliente(String codCliente)
	{
		return this.dbFacturas.buscarFacturasCliente(codCliente);
	}
	
	public ArrayList<Factura> devolverFacturasClienteEntreDosFechas(String codCliente, ArrayList<Calendar> filtradoFechas)
	{
		return ComparadorFecha.buscarEntreDosFechas(this.dbFacturas.buscarFacturasCliente(codCliente), 
				filtradoFechas.get(0), filtradoFechas.get(1));
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
