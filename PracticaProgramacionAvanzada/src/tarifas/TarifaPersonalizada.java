package tarifas;

import objetos.Llamada;

public abstract class TarifaPersonalizada extends Tarifa
{
	private static final long serialVersionUID = -5211355942483453133L;
	
	private Tarifa tarifa;
	
	public TarifaPersonalizada(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	
	@Override
	public String getNombreTarifa() {
		return this.tarifa.getNombreTarifa();
	}
	
	@Override
	public float costeLlamada(Llamada llamada) {
		return this.tarifa.costeLlamada(llamada);
	}	

	

}
