package operaciones;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

import objetos.Llamada;
import controlador.Controlador;
import interfaces.IntGrafico;
import interfaces.IntOperacionesLlamadas;
import interfaces.IntOperacionesPrincipal;

public class OperacionesLlamadasGrafica implements IntOperacionesLlamadas, IntGrafico{

	private Controlador controlador;
	
	@Override
	public void setPanelPincipal(JPanel panel) {
		
		
	}

	@Override
	public void menuPincipalLLamadas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setControlador(Controlador controlador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> realizarLLamada() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String llamadasCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mostrarLlamadas(ArrayList<Llamada> llamadas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String formatoLlamadaPantalla(Llamada llamada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Calendar> buscarLlamadasClientePorFecha() {
		// TODO Auto-generated method stub
		return null;
	}

}
