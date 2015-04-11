package objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Factura implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7081662237352674230L;
	
	private static int contFacturaID;
	private String codFactura;
	private Tarifa tarifa;
	private Calendar fechaEmision;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private ArrayList<Llamada> llamadasFactura;
	
	private static String generarCodFactura(String codCliente)
	{
		contFacturaID++;
		return codCliente + contFacturaID;
	}
	
	private static Calendar generarFechaFin(Calendar fechaInicio)
	{
		Calendar cal = fechaInicio;
		cal.add(Calendar.MONTH, 1);
		return cal;
	}
	
	public Factura(String codCliente, Tarifa tarifa) {
		super();
		this.codFactura = generarCodFactura(codCliente);
		this.fechaInicio = Calendar.getInstance();
		this.fechaFin = generarFechaFin(fechaInicio);
		this.llamadasFactura = new ArrayList<Llamada>();
	}

	public static int getContFacturaID() {
		return contFacturaID;
	}

	public static void setContFacturaID(int contFacturaID) {
		Factura.contFacturaID = contFacturaID;
	}

	public String getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Calendar getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Calendar fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Calendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}

	public ArrayList<Llamada> getLlamadasFactura() {
		return llamadasFactura;
	}

	public void setLlamadasFactura(ArrayList<Llamada> llamadasFactura) {
		this.llamadasFactura = llamadasFactura;
	}
	
	
	
	
	
	
	
	

}
