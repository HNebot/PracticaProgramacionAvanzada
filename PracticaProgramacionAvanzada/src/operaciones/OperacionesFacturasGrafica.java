package operaciones;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JPanel;

import objetos.Factura;
import controlador.Controlador;
import interfaces.IntGrafico;
import interfaces.IntOperacionesFacturas;

public class OperacionesFacturasGrafica implements IntGrafico, IntOperacionesFacturas{

	@Override
	public void menuPincipalFacturas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setControlador(Controlador controlador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String emitirFactura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mostrarDatosFactura(Factura factura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mostrarDatosFacturas(ArrayList<Factura> facturas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buscarFacturasCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buscarFacturaPorCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Calendar> buscarFacturasClientePorFechaEmision() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPanelPincipal(JPanel panel) {
		// TODO Auto-generated method stub
		
	}

}
