package test;

import static org.junit.Assert.*;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import objetos.Llamada;

import org.junit.Before;
import org.junit.Test;

import tarifas.Tarifa;
import tarifas.TarifaBase;
import tarifas.TarifaDomingo;
import tarifas.TarifaManyana;

public class TarifaTest {

	private Tarifa tarifa;
	
	@Before
	public void init() {
		tarifa = new TarifaBase();
	}
	@Test
	public void testGetTarifa() {
		assertEquals(0.15f, tarifa.getTarifa(), 0.0);
		tarifa = new TarifaManyana(tarifa);
		assertEquals(0.12f, tarifa.getTarifa(), 0.0);
		tarifa = new TarifaDomingo(tarifa);
		assertEquals(0.0f, tarifa.getTarifa(), 0.0);
	}

	@Test
	public void testGetNombreTarifa() {
		assertEquals("Tarifa Base", tarifa.getNombreTarifa());
		tarifa = new TarifaManyana(tarifa);
		assertEquals("Tarifa Base + Buenos Dias", tarifa.getNombreTarifa());
		tarifa = new TarifaDomingo(tarifa);
		assertEquals("Tarifa Base + Buenos Dias + Domingos Gratis", tarifa.getNombreTarifa());
	}

	@Test
	public void testCosteLlamada() {
		Llamada llamada = new Llamada(965412368, Calendar.getInstance(), 5);
		assertEquals(0.75f, tarifa.costeLlamada(llamada), 0.0);
		tarifa = new TarifaManyana(tarifa);
		assertEquals(0.75f, tarifa.costeLlamada(llamada), 0.0);
		tarifa = new TarifaDomingo(tarifa);
		assertEquals(0.75f, tarifa.costeLlamada(llamada), 0.0);
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date horaInicio = sdf.parse( "9:00", new ParsePosition(0));		
		llamada.getFecha().setTime(horaInicio);
		assertEquals(0.6f, tarifa.costeLlamada(llamada), 0.001);
		
		sdf = new SimpleDateFormat("HH:mm dd/M/yyyy");
		horaInicio = sdf.parse( "9:00 19/4/2015", new ParsePosition(0));
		llamada.getFecha().setTime(horaInicio);
		assertEquals(0.0f, tarifa.costeLlamada(llamada), 0.001);

	}

}
