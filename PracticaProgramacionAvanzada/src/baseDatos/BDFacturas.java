package baseDatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import objetos.Factura;

public class BDFacturas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3140478683150785681L;
	private HashMap<String,ArrayList<Factura>> factuasCliente;
	private HashMap<String, Factura> facturas;
	
	public BDFacturas() {
		super();
		this.factuasCliente = new HashMap<String, ArrayList<Factura>>();
		this.facturas = new HashMap<String, Factura>();
	}
	
	public boolean addNuevaFactura(Factura factura, String cliente)
	{
		try{
			if(this.factuasCliente.containsKey(cliente))
			{
				this.factuasCliente.get(cliente).add(factura);
				this.facturas.put(factura.getCodFactura(), factura);
			}
			else
			{
				ArrayList<Factura> listaFacturas = new ArrayList<Factura>();
				listaFacturas.add(factura);
				this.factuasCliente.put(cliente, listaFacturas);
				this.facturas.put(factura.getCodFactura(), factura);
			}
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	
	public Factura buscarFactura(String codFactura)
	{
		if(this.facturas.containsKey(codFactura))
		{
			return this.facturas.get(codFactura);
		}
		return null;
	}
	
	public ArrayList<Factura> buscarFacturasCliente(String codCliente)
	{
		if(this.factuasCliente.containsKey(codCliente))
		{
			return this.factuasCliente.get(codCliente);
		}
		return null;
	}
	
	
	
}
