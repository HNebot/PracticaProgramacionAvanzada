package operaciones;

import java.util.ArrayList;
import java.util.Calendar;

import javafx.util.Pair;

import javax.swing.JPanel;

import objetos.Cliente;
import controlador.Controlador;
import enumeraciones.TipoCliente;
import enumeraciones.TipoTarifaFinDeSemana;
import enumeraciones.TipoTarifaHoraria;
import interfaces.IntGrafico;
import interfaces.IntOperacionesClientes;

public class OperacionesClientesGrafica implements IntGrafico, IntOperacionesClientes{

	@Override
	public void menuPincipalClientes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setControlador(Controlador controlador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pair<TipoCliente, ArrayList<String>> menuNuevoCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String menuVerCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoTarifaHoraria menuTarifaHoraria() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoTarifaFinDeSemana menuTarifaFInDeSemana() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mostrarMensaje(String mensaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void formatoInfoCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarClientes(ArrayList<Cliente> clientes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String actualizarTarifa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Calendar> buscarClientesPorFechaAlta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPanelPincipal(JPanel panel) {
		// TODO Auto-generated method stub
		
	}

}
