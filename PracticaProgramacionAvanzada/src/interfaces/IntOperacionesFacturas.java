package interfaces;

import java.util.ArrayList;
import java.util.Calendar;

import controlador.Controlador;
import objetos.Factura;

public interface IntOperacionesFacturas{
	
	public void menuPincipalFacturas();
	public void setControlador(Controlador controlador);
	public String emitirFactura();
	public void mostrarDatosFactura(Factura factura);
	public void mostrarDatosFacturas(ArrayList<Factura> facturas);
	public String buscarFacturasCliente();
	public String buscarFacturaPorCodigo();
	public ArrayList<Calendar> buscarFacturasClientePorFechaEmision();
	public void mostrarMenjase(String mensaje);

}
