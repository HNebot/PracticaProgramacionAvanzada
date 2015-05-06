package operaciones;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Controlador;
import interfaces.IntGrafico;
import interfaces.IntOperacionesPrincipal;

public class OperacionesPrincipalGrafica implements IntOperacionesPrincipal, IntGrafico{

	private JFrame ventanaPrincipal;
	private JPanel panel;
	@Override
	public void setPanelPincipal(JPanel panel) {
		this.panel = panel;
		
	}

	@Override
	public void menuPincipal() throws Exception {
		panel.setBackground(Color.BLUE);
		
		
	}

	@Override
	public void setControlador(Controlador controlador) {
		// TODO Auto-generated method stub
		
	}

}
