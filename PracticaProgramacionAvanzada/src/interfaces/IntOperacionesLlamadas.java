package interfaces;

import java.util.ArrayList;
import java.util.Calendar;

import controlador.Controlador;
import excepciones.ExcepcionLlamadaNoEncontrada;
import objetos.Llamada;

public interface IntOperacionesLlamadas
{
	
	public void menuPincipalLLamadas();
	public void setControlador(Controlador controlador);
	public ArrayList<String> realizarLLamada();
	public String llamadasCliente();
	public void mostrarLlamadas(ArrayList<Llamada> llamadas) throws ExcepcionLlamadaNoEncontrada;
	public String formatoLlamadaPantalla(Llamada llamada);
	public ArrayList<Calendar> buscarLlamadasClientePorFecha();
	public void mostrarMensaje(String mensaje);

}
