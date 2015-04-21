package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tarifas.Tarifa;
import tarifas.TarifaBase;

public class TarifaTest {

	@Test
	public void testGetTarifa() {
		Tarifa tarifa = new TarifaBase();
		assertEquals(0.15f, tarifa.getTarifa(), 0.0);
	}

	@Test
	public void testGetNombreTarifa() {
		fail("Not yet implemented");
	}

	@Test
	public void testCosteLlamada() {
		fail("Not yet implemented");
	}

}
