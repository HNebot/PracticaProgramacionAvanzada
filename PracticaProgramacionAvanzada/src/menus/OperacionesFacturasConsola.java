package menus;

import interfaces.IntMenuFacturas;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import lectura.LecturaDatosConsola;
import objetos.Factura;
import objetos.Llamada;

public class OperacionesFacturasConsola implements IntMenuFacturas 
{
	private Scanner scanner;
	private LecturaDatosConsola lectura;
	
	public OperacionesFacturasConsola(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public OperacionesFacturasConsola() {
		this.lectura = new LecturaDatosConsola();
	}

	@Override
	public String emitirFactura() {
		System.out.println("Introduzca el codigo del cliente: ");
		return this.lectura.lecturaDatos();
	}

	@Override
	public String mostrarDatosFactura(Factura factura) {
			
		if(factura != null){
			String infoFactura = "";
			infoFactura = infoFactura + "CodFactura: " + factura.toArray().get(0) + "\n";
			infoFactura = infoFactura + "Fecha inicio: " + factura.toArray().get(1) + "\t";
			infoFactura = infoFactura + "Fecha fin: " + factura.toArray().get(2) + "\n";
			infoFactura = infoFactura + "Tarifa aplicada: " + factura.toArray().get(3) + "€/min\n";
			
			if(factura.getFecha() != null)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
				infoFactura = infoFactura + "Fecha emision: " + sdf.format(factura.getFecha().getTime()) + "\n";
				infoFactura = infoFactura + "Facturacion total: : " + factura.facturacionTotal() + "€\n";
			}
			infoFactura = infoFactura + "Llamadas: \n";
			
			for(Llamada llamada: factura.getLlamadasFactura())
			{
				infoFactura = infoFactura + llamada.toString() + "\n";
			}
			
			return infoFactura;
		}
		else{
			return "No existen facturas";
		}
	}

	@Override
	public String buscarFacturasCliente() {
		System.out.println("Introduzca el codigo del cliente: ");
		return this.lectura.lecturaDatos();
	}

	@Override
	public String buscarFacturaPorCodigo() {
		System.out.println("Introduzca el codigo de la factura: ");
		return this.lectura.lecturaDatos();
	}

	@Override
	public String mostrarDatosFacturas(ArrayList<Factura> facturas) {
		String info = "=========================\n";
		
		if(facturas !=null || facturas.size() < 0)
		{
			for(Factura factura: facturas)
			{
				info = info + this.mostrarDatosFactura(factura);
				info = info +  "=========================\n";
			}
			return info;
		}else{
			return "No existen facturas";
		}
	}

	@Override
	public ArrayList<Calendar> buscarFacturasClientePorFechaEmision() {
		try{
			ArrayList<Calendar> filtro = new ArrayList<Calendar>();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy"); 
			
			System.out.println("Introduzca la fecha de inicio (ejemplo: 12/4/2015): ");
			System.out.print("--> ");
			Date fecha1 = sdf.parse(lectura.lecturaDatos() , new ParsePosition(0));
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(fecha1);
			filtro.add(cal1);
			
			System.out.println("Introduzca la fecha de fin (ejemplo: 12/4/2015): ");
			System.out.print("--> ");
			Date fecha2 = sdf.parse(lectura.lecturaDatos() , new ParsePosition(0));
			Calendar cal2 = new GregorianCalendar();
			cal1.setTime(fecha2);
			filtro.add(cal2);
			
			return filtro;
		}catch(NullPointerException e)
		{
			System.out.println("java.lang.NullPointerException");
			System.out.println("Error en el formato de la fecha");
			return null;
		}
	}
	
	

}
