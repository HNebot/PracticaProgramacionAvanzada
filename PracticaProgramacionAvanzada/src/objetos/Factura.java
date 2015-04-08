package objetos;

import java.io.Serializable;
import java.util.Calendar;

public class Factura implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7081662237352674230L;
	
	private String codFactura;
	private Tarifa tarifa;
	private Calendar fechaEmision;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	
	

}
