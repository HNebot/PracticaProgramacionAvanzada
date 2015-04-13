package objetos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Factura extends Fecha implements Serializable
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
	
	/**
	 * Genera el codigo de la factura mendiante un contador que cuenta las facturas creadas 
	 * y el codigo individual de cada cliente
	 * @param codCliente
	 * @return codFactura
	 */
	private static String generarCodFactura(String codCliente)
	{
		contFacturaID++;
		return codCliente + contFacturaID;
	}
	
	/**
	 * Genera la fecha de fin de factura sumandole un mes a la fecha de inicio de esta
	 * @param fechaInicio
	 * @return fechaFin
	 */
	private static Calendar generarFechaFin(Calendar fechaInicio)
	{
		Calendar cal = (Calendar) fechaInicio.clone();
		cal.add(Calendar.MONTH, 1);
		return cal;
	}
	
	public Factura(String codCliente, Tarifa tarifa) {
		super();
		this.codFactura = generarCodFactura(codCliente);
		this.fechaInicio = Calendar.getInstance();
		this.fechaFin = generarFechaFin(fechaInicio);
		this.tarifa = tarifa;
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

	/**
	 * Hace referencia a la fecha de emision de la factura.
	 * @return La fecha de emision.
	 */
	public Calendar getFecha() {
		return fechaEmision;
	}

	/**
	 * Inserta una fecha de emison.
	 * @param fechaEmision
	 */
	public void setFecha(Calendar fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Calendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
		generarFechaFin(fechaInicio);
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
	
	public void modificarFechaInicioYFIn(Calendar fecha)
	{
		this.setFechaInicio(fecha);
		this.setFechaFin(generarFechaFin(fecha));
	}
	
	public float facturacionTotal()
	{
		float facturacion = 0;
		try{
			for(Llamada llamada: this.llamadasFactura)
			{
				facturacion = facturacion + llamada.getDuracion() * this.tarifa.getTarifa();
			}
			return facturacion;
		}catch(Exception e){
			return facturacion;
		}
		
	}

	@Override
	public String toString() {
		return "Factura [codFactura=" + codFactura + ", tarifa=" + tarifa
				+ ", fechaEmision=" + fechaEmision + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + ", llamadasFactura="
				+ llamadasFactura + "]";
	}
	
	/**
	 * Da formato a la fecha para convertir el objeto Calendar en un string con formato dd/M/yyyy
	 * @param fecha
	 * @return fechaString
	 */
	private String formatoFecha(Calendar fecha)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		return sdf.format(fecha.getTime());
	}
	
	/**
	 * Deveuelve un ArrayList<String> con los datos de la factura
	 * por0: codFactura, pos1: fechaInicio, pos2: fechaFin, pos3: tarifa
	 * @return ArrayList<String>
	 */
	public ArrayList<String> toArray()
	{
		ArrayList<String> datos = new ArrayList<String>();
		
		datos.add(getCodFactura());
		datos.add(formatoFecha(fechaInicio));
		datos.add(formatoFecha(fechaFin));
		datos.add("" + getTarifa().getTarifa());
		return datos;
	}

}
