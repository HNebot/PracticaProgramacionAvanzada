package comparadores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import objetos.Fecha;

public class ComparadorFecha 
{
	public static <T> ArrayList<T> buscarEntreDosFechas(ArrayList<? extends Fecha> lista, Calendar fechaInicio, Calendar fechaFin)
	{
		ArrayList<T> listaFiltrada = new ArrayList<T>();
		try{
			for(int i = 0; i < lista.size(); i++)
			{
				if(lista.get(i).getFecha().after(fechaInicio) && lista.get(i).getFecha().before(fechaFin))
				{
					listaFiltrada.add((T) lista.get(i));
				}
				
			}
			return listaFiltrada;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

}