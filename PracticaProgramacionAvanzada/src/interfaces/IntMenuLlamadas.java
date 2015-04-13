package interfaces;

import java.util.ArrayList;
import java.util.Calendar;

import objetos.Llamada;

public interface IntMenuLlamadas
{
	public ArrayList<String> realizarLLamada();
	public String llamadasCliente();
	public String mostrarLlamadas(ArrayList<Llamada> llamadas);
	public String formatoLlamadaPantalla(Llamada llamada);
	public ArrayList<Calendar> buscarLlamadasClientePorFecha();

}
