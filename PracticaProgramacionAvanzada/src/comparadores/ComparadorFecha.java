package comparadores;

import java.util.ArrayList;
import java.util.Calendar;

import objetos.Fecha;

public class ComparadorFecha 
{
	/**
	 * Metodo generico que recive una lista de objetos que extiende a fecha y dos fechas.
	 * Recorre los objetos de la lista para buscar aquellos que tengan un fecha entre la dos pasadas por parametro.
	 * @param lista de objetos que extieden de fecha
	 * @param Un objeto calendar con la fecha de inicio para crear el filtro.
	 * @param Un objeto calendar con la fecha final para crear el filtro.
	 * @return devuelve un lista de ojetos que cumplen con las condiciones del filtro, Devuelve null is hay algun error
	 */
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
			if(listaFiltrada.size() == 0) throw new Exception();
			return listaFiltrada;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

}