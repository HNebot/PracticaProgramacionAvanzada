package tarifas;

import java.text.SimpleDateFormat;

import objetos.Llamada;

public class TarifaViernesSabado extends TarifaPersonalizada
{
	private static final long serialVersionUID = 5711567586159254901L;
	
	private final float COSTE_TARIFA = 0.9f;
	private final String DIA_TARIFA_1 = "viernes";
	private final String DIA_TARIFA_2 = "sábado";
	private final String NOMBRE_TARIFA = "Viernes y Sabados";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
	
	public TarifaViernesSabado (Tarifa tarifa) {
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
		
		if(diaLlamada.equals(this.DIA_TARIFA_1) || diaLlamada.equals(this.DIA_TARIFA_2)){
			
			costeLlamada = Math.min(super.costeLlamada(llamada), this.COSTE_TARIFA * llamada.getDuracion());
		}
		else{
			costeLlamada = super.costeLlamada(llamada);
		}
		
		return costeLlamada;
	}

}
