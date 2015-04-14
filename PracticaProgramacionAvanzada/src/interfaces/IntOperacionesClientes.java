package interfaces;

import java.util.ArrayList;
import java.util.Calendar;

import enumeraciones.TipoCliente;
import enumeraciones.TipoTarifaFinDeSemana;
import enumeraciones.TipoTarifaHoraria;
import javafx.util.Pair;
import objetos.Cliente;

public interface IntOperacionesClientes
{
	
	public Pair<TipoCliente, ArrayList<String>> menuNuevoCliente();
	public String menuVerCliente();
	public TipoTarifaHoraria menuTarifaHoraria();
	public TipoTarifaFinDeSemana menuTarifaFInDeSemana();
	public void mostrarMensaje(String mensaje);
	public void formatoInfoCliente(Cliente cliente);
	public void mostrarClientes(ArrayList<Cliente> clientes);
	public String actualizarTarifa();
	public ArrayList<Calendar> buscarClientesPorFechaAlta();
}
