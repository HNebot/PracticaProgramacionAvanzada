package tarifas;

import java.text.SimpleDateFormat;
import objetos.Llamada;

public class TarifaSabado extends TarifaPersonalizada
{
	private static final long serialVersionUID = 7630075695645985331L;
	
	private final float COSTE_TARIFA = 0f;
	private final String DIA_TARIFA_GRATIS = "sábado";
	private final String NOMBRE_TARIFA = "Sabados Gratis";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
	
	public TarifaSabado (Tarifa tarifa) {
		super(tarifa);
	}
	
	@Override
	public float getTarifa() {
		return this.COSTE_TARIFA;
	}
	
	@Override
	public String getNombreTarifa() {
		return super.getNombreTarifa()  + " + " + this.NOMBRE_TARIFA;
	}
	
	@Override
	public float costeLlamada(Llamada llamada) {
		
		String diaLlamada = sdf.format(llamada.getFecha().getTime());
		float costeLlamada = 0;
		
		if(diaLlamada.equals(this.DIA_TARIFA_GRATIS)){
			
			costeLlamada = Math.min(super.costeLlamada(llamada), this.COSTE_TARIFA * llamada.getDuracion());
		}
		else{
			costeLlamada = super.costeLlamada(llamada);
		}
		
		return costeLlamada;
	}
}


