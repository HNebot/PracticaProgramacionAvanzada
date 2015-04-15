package tarifas;

import objetos.Llamada;

public class TarifaBase extends Tarifa
{
	private static final long serialVersionUID = 4710552802491884188L;
	
	private final String NOMBRE_TARIFA = "Tarifa Base";
	private final float COSTE_TARIFA = 0.15f;
	
	public TarifaBase() {
		super();
	}

	@Override
	public String getNombreTarifa() {
		return this.NOMBRE_TARIFA;
	}

	@Override
	public float costeLlamada(Llamada llamada) {
		return (this.COSTE_TARIFA * llamada.getDuracion());
	}

	@Override
	public float getTarifa() {
		return this.COSTE_TARIFA;
	}
	
	
	
}
