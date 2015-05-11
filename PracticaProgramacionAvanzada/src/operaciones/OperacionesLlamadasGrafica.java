package operaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import operaciones.OperacionesPrincipalGrafica.EscuchadoraBoton;
import menus.MenuFacturasConsola;
import menus.MenuLlamadasConsola;
import menus.MenuPrincipalConsola;
import objetos.Llamada;
import controlador.Controlador;
import interfaces.IntGrafico;
import interfaces.IntOperacionesLlamadas;
import interfaces.IntOperacionesPrincipal;

public class OperacionesLlamadasGrafica implements IntOperacionesLlamadas, IntGrafico{

	private Controlador controlador;
	
	private JFrame ventanaPrincipal;
	private JPanel panelPrincipal;
	
	private JButton botonAltaLLamada;
	private JButton botonVerLlamadasClientes;
	private JButton botonVerLlamadasClienteFecha;
	private JButton botonAtras;
	
	@Override
	public void setPanelPincipal(JPanel panel) {
		this.panelPrincipal = panel;
		
	}

	@Override
	public void menuPincipalLLamadas() {
		this.panelPrincipal.removeAll();
		JPanel panel2 = new JPanel();
		int posx = (this.panelPrincipal.getWidth() - 600)/2;
		int posy = (this.panelPrincipal.getHeight() - 350)/2;
		panel2.setBounds(posx, posy, 600, 350);
		panel2.setBackground(Color.GRAY);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		panel2.setBorder(raisedbevel);
		panel2.setLayout(null);
		
		generarBotones();
		
		panel2.add(this.botonAltaLLamada);
		JLabel altaLlamadaLabel = new JLabel("Nueva llamada");
		JLabel altaLlamadasLabel2 = new JLabel(MenuLlamadasConsola.ALTA_LLAMADA.getDescripcion());
		altaLlamadaLabel.setBounds(120, 15, 100, 100);
		altaLlamadasLabel2.setBounds(120, 35, 400, 100);
		panel2.add(altaLlamadaLabel);
		panel2.add(altaLlamadasLabel2);
		
		panel2.add(this.botonVerLlamadasClientes);
		JLabel verLlamadasLabel = new JLabel("Ver llamadas");
		JLabel verLlamadasLabel2 = new JLabel(MenuLlamadasConsola.LLAMADAS_CLIENTE.getDescripcion());
		verLlamadasLabel.setBounds(120, 85, 100, 100);
		verLlamadasLabel2.setBounds(120, 105, 400, 100);
		panel2.add(verLlamadasLabel);
		panel2.add(verLlamadasLabel2);
	    
	    
	    panel2.add(this.botonVerLlamadasClienteFecha);
	    JLabel verLlamadasFechaLabel = new JLabel("ver llamadas por fecha");
		JLabel verLlamadasFechaLabel2 = new JLabel(MenuLlamadasConsola.LLAMADAS_CLIENTE_FECHA.getDescripcion());
		verLlamadasFechaLabel.setBounds(120, 155, 100, 100);
		verLlamadasFechaLabel2.setBounds(120, 175, 400, 100);
		panel2.add(verLlamadasFechaLabel);
		panel2.add(verLlamadasFechaLabel2);
	    
	    
	    panel2.add(this.botonAtras);
	    JLabel salirLabel = new JLabel(MenuLlamadasConsola.ATRAS.getDescripcion());
		JLabel salirLabel2 = new JLabel("Volver al menu principal");
		salirLabel.setBounds(120, 225, 150, 100);
		salirLabel2.setBounds(120, 245, 400, 100);
		panel2.add(salirLabel);
		panel2.add(salirLabel2);
	    
	    this.panelPrincipal.add(panel2, BorderLayout.CENTER);
	    this.panelPrincipal.repaint();
	}

	private void generarBotones() {
		ImageIcon imagenCliente = new ImageIcon("iconos/iconoClientes45x45.png");
		ImageIcon imagenFacturas = new ImageIcon("iconos/iconoFacturas45x45.png");
		ImageIcon imagenLlamadas = new ImageIcon("iconos/iconoLLamadas45x45.png");
		ImageIcon imagenSalir = new ImageIcon("iconos/iconoSalir45x45.png");
		
		this.botonAltaLLamada = new JButton();
		this.botonAltaLLamada.setBounds(50, 50, 50, 50);
		this.botonAltaLLamada.setName("AltaLlamada");
		this.botonAltaLLamada.setActionCommand("AltaLlamada");
		this.botonAltaLLamada.addActionListener(new EscuchadoraBoton());
		
		
		this.botonVerLlamadasClientes = new JButton();
		this.botonVerLlamadasClientes.setBounds(50, 120, 50, 50);
		this.botonVerLlamadasClientes.setName("VerLlamadasCliente");
		this.botonVerLlamadasClientes.setActionCommand("VerLlamadasCliente");
		this.botonVerLlamadasClientes.addActionListener(new EscuchadoraBoton());
		
		this.botonVerLlamadasClienteFecha = new JButton();
		this.botonVerLlamadasClienteFecha.setBounds(50, 190, 50, 50);
		this.botonVerLlamadasClienteFecha.setName("VerLlamadasClienteFecha");
		this.botonVerLlamadasClienteFecha.setActionCommand("VerLlamadasClienteFecha");
		this.botonVerLlamadasClienteFecha.addActionListener(new EscuchadoraBoton());
		
		this.botonAtras = new JButton();
		this.botonAtras.setBounds(50, 260, 50, 50);
		this.botonAtras.setName("Atras");
		this.botonAtras.setActionCommand("Atras");
		this.botonAtras.addActionListener(new EscuchadoraBoton());
		
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
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
	
	public Controlador getControlador()
	{
		return this.controlador;
	}
	
	public class EscuchadoraBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			
			switch (comando) {
			case "AltaLlamada":
				break;
				
			case "VerLlamadasCliente":
				break;
				
			case "VerLlamadasClienteFecha":
				break;
				
			case "Atras":
				getControlador().ejecutaOpcionMenuLlamadas(MenuLlamadasConsola.ATRAS);
				break;
				
			default:
				break;
			}
		}
	}

}
