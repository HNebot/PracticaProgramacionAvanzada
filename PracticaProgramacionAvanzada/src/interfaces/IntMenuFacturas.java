package interfaces;

import java.util.ArrayList;

import objetos.Factura;

public interface IntMenuFacturas{
	public String emitirFactura();
	public String mostrarDatosFactura(Factura factura);
	public String mostrarDatosFacturas(ArrayList<Factura> facturas);
	public String buscarFacturasCliente();
	public String buscarFacturaPorCodigo();

}
