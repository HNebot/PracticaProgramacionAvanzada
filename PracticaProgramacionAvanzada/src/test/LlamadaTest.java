package test;

import static org.junit.Assert.*;

import java.util.Calendar;

import objetos.Llamada;

import org.junit.Before;
import org.junit.Test;

public class LlamadaTest {
	
	private Llamada llamada;
	private Calendar fecha, fecha2;
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

}
