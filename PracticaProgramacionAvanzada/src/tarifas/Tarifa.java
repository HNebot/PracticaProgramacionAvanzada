package tarifas;

import java.io.Serializable;

import objetos.Llamada;

public abstract class Tarifa implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8255629566405519458L;
	
	private final float COSTE_TARIFA = 0.15f;

	public Tarifa() {
		super();
	}

	public float getTarifa() {
		return this.COSTE_TARIFA;
	}

	@Override
	public String toString() {
		return "" + getTarifa();
	}
	
	public float costeLlamada(Llamada llamada)
	{
		return (this.COSTE_TARIFA * llamada.getDuracion());
	}
	
}
