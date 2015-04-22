package test;

import static org.junit.Assert.*;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import objetos.Llamada;

import org.junit.Before;
import org.junit.Test;

public class LlamadaTest {
	
	private Llamada llamada;
	private Calendar fecha, fecha2, fecha3;
	@Before
	public void init() {
		fecha = Calendar.getInstance();
		fecha2 = (Calendar) fecha.clone();
		llamada = new Llamada(789456123, fecha, 8);	
	}

	@Test
	public void testGetFecha() {
		assertEquals(fecha2, llamada.getFecha());
	}

	@Test
	public void testSetFecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/M/yyyy");
		Date horaInicio = sdf.parse( "9:00 19/4/2015", new ParsePosition(0));
		fecha2.setTime(horaInicio);
		fecha3 = (Calendar) fecha2.clone();
		llamada.setFecha(fecha3);
		assertEquals(fecha2, llamada.getFecha());
	}

	@Test
	public void testGetTelefonoReceptor() {
		assertEquals(789456123, llamada.getTelefonoReceptor());
	}

	@Test
	public void testSetTelefonoReceptor() {
		assertEquals(789456123, llamada.getTelefonoReceptor());
		llamada.setTelefonoReceptor(369258147);
		assertEquals(369258147, llamada.getTelefonoReceptor());

	}

	@Test
	public void testGetDuracion() {
		assertEquals(8, llamada.getDuracion());
	}

	@Test
	public void testSetDuracion() {
		assertEquals(8, llamada.getDuracion());
		llamada.setDuracion(10);
		assertEquals(10, llamada.getDuracion());
	}

	@Test
	public void testToString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm");
		String info = "telefonoReceptor: 789456123, fecha:"
				+ sdf.format(fecha2.getTime()) + ", duracion: 8min";
		
		assertEquals(info, llamada.toString());
		
	}

}
