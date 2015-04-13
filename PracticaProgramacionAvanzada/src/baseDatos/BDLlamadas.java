package baseDatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import objetos.Llamada;


public class BDLlamadas implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5525941430214701042L;
	private HashMap<String, ArrayList<Llamada>> llamadas;
	
	public BDLlamadas() {
		super();
		this.llamadas = new HashMap<String, ArrayList<Llamada>>();
	}
	
	public boolean altaLlamada(String nif, Llamada llamada)
	{
		if(this.llamadas.containsKey(nif))
		{
			return this.llamadas.get(nif).add(llamada);
		}
		else
		{
			ArrayList<Llamada> lista = new ArrayList<Llamada>();
			lista.add(llamada);
			this.llamadas.put(nif, lista);
			return true;
		}
	}
	
	public ArrayList<Llamada> llamadasCliente(String nif)
	{
		if(!this.llamadas.containsKey(nif))
		{
			return null;
		}
		
		return this.llamadas.get(nif);
	}
	
	
	

}
