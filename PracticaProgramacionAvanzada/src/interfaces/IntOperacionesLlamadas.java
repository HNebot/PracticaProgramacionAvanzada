package interfaces;

import java.util.ArrayList;
import java.util.Calendar;

import controlador.Controlador;
import objetos.Llamada;

public interface IntOperacionesLlamadas
{
	
	public void menuPincipalLLamadas();
	public void setControlador(Controlador controlador);
	public ArrayList<String> realizarLLamada();
	public String llamadasCliente();
	public String mostrarLlamadas(ArrayList<Llamada> llamadas);
	public String formatoLlamadaPantalla(Llamada llamada);
	public ArrayList<Calendar> buscarLlamadasClientePorFecha();

}
