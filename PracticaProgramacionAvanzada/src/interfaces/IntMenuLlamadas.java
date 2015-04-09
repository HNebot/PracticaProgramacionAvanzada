package interfaces;

import java.util.ArrayList;
import objetos.Llamada;

public interface IntMenuLlamadas
{
	public ArrayList<String> realizarLLamada();
	public String llamadasCliente();
	public String mostrarLlamadas(ArrayList<Llamada> llamadas);
	public String formatoLlamadaPantalla(Llamada llamada);

}
