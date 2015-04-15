package tarifas;

import java.io.Serializable;

import objetos.Llamada;

public abstract class Tarifa implements Serializable
{
	private static final long serialVersionUID = 8255629566405519458L;

	public Tarifa() {
		super();
	}

	public abstract float getTarifa();
	
	public abstract String getNombreTarifa();

	@Override
	public String toString() {
		return "" + getTarifa();
	}
	
	public abstract float costeLlamada(Llamada llamada);
	
}
