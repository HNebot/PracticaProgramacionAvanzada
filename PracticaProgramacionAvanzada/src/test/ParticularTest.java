package test;

import static org.junit.Assert.*;

import java.util.Calendar;

import objetos.Cliente;
import objetos.Direccion;
import objetos.Particular;

import org.junit.Before;
import org.junit.Test;

import tarifas.Tarifa;
import tarifas.TarifaBase;
import tarifas.TarifaManyana;

public class ParticularTest {

	Cliente cliente, empresa;
	Direccion direccion;
	Tarifa tarifa;
	
	@Before
	public void init() {
		tarifa = new TarifaBase();
		direccion = new Direccion("Avd aaa", "5", "", "Castellon", "Castellon", 12004);
		cliente = new Particular("Vicente", "987D", "v@gmail.com", 456852031, direccion, 
				Calendar.getInstance(), tarifa, "Fernandez");
	}
	
	
	@Test
	public void testGetApellido() {
		assertEquals("Fernandez", ((Particular) cliente).getApellido());
	}

	@Test
	public void testGetNIF() {
		assertEquals("987D", cliente.getNIF());	
	}

	@Test
	public void testGetNombre() {
		assertEquals("Vicente", cliente.getNombre());
	}

	@Test
	public void testGetEmail() {
		assertEquals("v@gmail.com", cliente.getEmail());
	}

	@Test
	public void testGetNumeroTelefono() {
		assertEquals(456852031, cliente.getNumeroTelefono());
	}

	@Test
	public void testGetDireccion() {
		assertEquals(direccion, cliente.getDireccion());
	}

	@Test
	public void testGetTarifa() {
		assertEquals("Tarifa Base", cliente.getTarifa().getNombreTarifa());
	}

	@Test
	public void testSetTarifa() {
		tarifa = new TarifaManyana(tarifa);
		cliente.setTarifa(tarifa);
		assertEquals("Tarifa Base + Buenos Dias", cliente.getTarifa().getNombreTarifa());
	}
}
