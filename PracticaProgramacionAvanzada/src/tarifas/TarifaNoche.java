package tarifas;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import objetos.Llamada;

public class TarifaNoche extends TarifaPersonalizada
{
	private static final long serialVersionUID = 3497075115345980951L;
	
	private final float COSTE_TARIFA = 0.12f;
	private final String HORA_INICIO_TARIFA = "20:00";
	private final String HORA_FIN_TARIFA = "1:00";
	private final String NOMBRE_TARIFA = "Buenas Noches";
	
	private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	private Date horaInicioTarifa = sdf.parse( this.HORA_INICIO_TARIFA, new ParsePosition(0));
	private Date horaFinTarifa = sdf.parse( this.HORA_FIN_TARIFA, new ParsePosition(0));
	
	public TarifaNoche(Tarifa tarifa) {
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
		
		Date fechaparaComparar = sdf.parse(sdf.format(llamada.getFecha().getTime()), new ParsePosition(0));
		float costeLlamada = 0;
		
		if(fechaparaComparar.compareTo(horaInicioTarifa) > 0 && 
				fechaparaComparar.compareTo(horaFinTarifa) < 0){
			
			costeLlamada = Math.min(super.costeLlamada(llamada), this.COSTE_TARIFA * llamada.getDuracion());
		}
		else{
			costeLlamada = super.costeLlamada(llamada);
		}
		
		return costeLlamada;
	}

}
