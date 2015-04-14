package tarifas;

import objetos.Llamada;

public class TarifaManyana extends TarifaPersonalizada
{
	private static final long serialVersionUID = 7630075695645985331L;
	//private Tarifa tarifa;
	private final float COSTE_TARIFA = 0.12f;
	
	public TarifaManyana(Tarifa tarifa) {
		super(tarifa);
	}
	
	@Override
	public float costeLlamada(Llamada llamada) {
		float costeLlamada = Math.min(super.costeLlamada(llamada), this.COSTE_TARIFA * llamada.getDuracion());
		return costeLlamada;
	}
	 

}
