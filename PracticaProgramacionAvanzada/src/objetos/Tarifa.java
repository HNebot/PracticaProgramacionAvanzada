package objetos;

import java.io.Serializable;

public class Tarifa implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8255629566405519458L;
	
	private float tarifa;

	public Tarifa(float tarifa) {
		super();
		this.tarifa = tarifa;
	}

	public float getTarifa() {
		return tarifa;
	}

	public void setTarifa(float tarifa) {
		this.tarifa = tarifa;
	}
	
	@Override
	public String toString() {
		return "" + getTarifa();
	}
	
}
