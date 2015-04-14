package tarifas;

public abstract class TarifaPersonalizada extends Tarifa
{
	private static final long serialVersionUID = -5211355942483453133L;
	
	private Tarifa tarifa;
	
	public TarifaPersonalizada(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	

}
