package operaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.util.Pair;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import menus.MenuClientesConsola;
import menus.MenuPrincipalConsola;
import operaciones.OperacionesPrincipalGrafica.EscuchadoraBoton;
import objetos.Cliente;
import controlador.Controlador;
import enumeraciones.TipoCliente;
import enumeraciones.TipoTarifaFinDeSemana;
import enumeraciones.TipoTarifaHoraria;
import excepciones.ExcepcionClienteNoEncontrado;
import interfaces.IntGrafico;
import interfaces.IntOperacionesClientes;

public class OperacionesClientesGrafica implements IntGrafico, IntOperacionesClientes{

	private Controlador controlador;
	
	private JFrame ventanaPrincipal;
	private JPanel panelPrincipal;
	
	private JButton botonAltaCliente;
	private JButton botonBuscarClienteDNI;
	private JButton botonBuscarClienteFecha;
	private JButton botonVerClientes;
	private JButton botonModificarTarifa;
	private JButton  botonAtras;
	
	
	
	public OperacionesClientesGrafica() {
		super();
	}
	
	
	@Override
	public void menuPincipalClientes() {
		this.panelPrincipal.removeAll();
		JPanel panel2 = new JPanel();
		int posx = (this.panelPrincipal.getWidth() - 800)/2;
		int posy = (this.panelPrincipal.getHeight() - 350)/2;
		panel2.setBounds(posx, posy, 800, 350);
		panel2.setBackground(Color.GRAY);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		panel2.setBorder(raisedbevel);
		panel2.setLayout(null);
		
		generarBotones();
		
		panel2.add(this.botonAltaCliente);
		JLabel altaClienteLabel = new JLabel(MenuClientesConsola.NUEVO_CLIENTE.getDescripcion());
		JLabel altaClienteLabel2 = new JLabel("Añade un nuevo cliente a la base de datos");
		altaClienteLabel.setBounds(120, 15, 100, 100);
		altaClienteLabel2.setBounds(120, 35, 400, 100);
		panel2.add(altaClienteLabel);
		panel2.add(altaClienteLabel2);
		
		panel2.add(this.botonBuscarClienteDNI);
		JLabel buscarClienteDNILabel = new JLabel(MenuClientesConsola.BUSCAR_CLIENTE_DNI.getDescripcion());
		JLabel buscarClienteDNILabel2 = new JLabel("Buscar clientes en la base de datos por dni");
		buscarClienteDNILabel.setBounds(120, 85, 200, 100);
		buscarClienteDNILabel2.setBounds(120, 105, 400, 100);
		panel2.add(buscarClienteDNILabel);
		panel2.add(buscarClienteDNILabel2);
	    
	    
	    panel2.add(this.botonBuscarClienteFecha);
	    JLabel buscarClienteFechaLabel = new JLabel(MenuClientesConsola.BUSCAR_CLIENTE_ALTA.getDescripcion());
		JLabel buscarClienteFechaLabel2 = new JLabel("Buscar clientes en la base de datos por fecha de alta");
		buscarClienteFechaLabel.setBounds(120, 155, 200, 100);
		buscarClienteFechaLabel2.setBounds(120, 175, 400, 100);
		panel2.add(buscarClienteFechaLabel);
		panel2.add(buscarClienteFechaLabel2);
	    
	    
	    panel2.add(this.botonVerClientes);
	    JLabel verClientesLabel = new JLabel(MenuClientesConsola.VER_CLIENTES.getDescripcion());
		JLabel verClientesLabel2 = new JLabel("Ver todos los clientes registrados en la base de datos");
		verClientesLabel.setBounds(120, 225, 200, 100);
		verClientesLabel2.setBounds(120, 245, 400, 100);
		panel2.add(verClientesLabel);
		panel2.add(verClientesLabel2);
		
		panel2.add(this.botonModificarTarifa);
		JLabel modificarTarifaLabel = new JLabel("Modificar tarifa");
		JLabel modificarTarifaLabel2 = new JLabel(MenuClientesConsola.MODIFICAR_TARIFA.getDescripcion() + " registrado");
		modificarTarifaLabel.setBounds(520, 15, 150, 100);
		modificarTarifaLabel2.setBounds(520, 35, 400, 100);
		panel2.add(modificarTarifaLabel);
		panel2.add(modificarTarifaLabel2);
		
		panel2.add(this.botonAtras);
		JLabel atrasLabel = new JLabel(MenuClientesConsola.ATRAS.getDescripcion());
		JLabel atrasLabel2 = new JLabel("Volver al menu principal");
		atrasLabel.setBounds(520, 85, 200, 100);
		atrasLabel2.setBounds(520, 105, 400, 100);
		panel2.add(atrasLabel);
		panel2.add(atrasLabel2);
		
		
		this.panelPrincipal.add(panel2, BorderLayout.CENTER);
		this.panelPrincipal.repaint();
		
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
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
		this.panelPrincipal = panel;
		
	}
	
	private void generarBotones()
	{
		ImageIcon imagenCliente = new ImageIcon("iconos/iconoClientes45x45.png");
		ImageIcon imagenFacturas = new ImageIcon("iconos/iconoFacturas45x45.png");
		ImageIcon imagenLlamadas = new ImageIcon("iconos/iconoLLamadas45x45.png");
		ImageIcon imagenSalir = new ImageIcon("iconos/iconoSalir45x45.png");
		
		this.botonAltaCliente = new JButton();
		this.botonAltaCliente.setBounds(50, 50, 50, 50);
		this.botonAltaCliente.setName("AltaCliente");
		this.botonAltaCliente.setActionCommand("AltaCliente");
		this.botonAltaCliente.addActionListener(new EscuchadoraBoton());
		
		
		this.botonBuscarClienteDNI = new JButton();
		this.botonBuscarClienteDNI.setBounds(50, 120, 50, 50);
		this.botonBuscarClienteDNI.setName("BuscarDNI");
		this.botonBuscarClienteDNI.setActionCommand("BuscarDNI");
		this.botonBuscarClienteDNI.addActionListener(new EscuchadoraBoton());
		
		this.botonBuscarClienteFecha = new JButton();
		this.botonBuscarClienteFecha.setBounds(50, 190, 50, 50);
		this.botonBuscarClienteFecha.setName("BuscarFecha");
		this.botonBuscarClienteFecha.setActionCommand("BuscarFecha");
		this.botonBuscarClienteFecha.addActionListener(new EscuchadoraBoton());
		
		this.botonVerClientes = new JButton();
		this.botonVerClientes.setBounds(50, 260, 50, 50);
		this.botonVerClientes.setName("VerClientes");
		this.botonVerClientes.setActionCommand("VerClientes");
		this.botonVerClientes.addActionListener(new EscuchadoraBoton());
		
		this.botonModificarTarifa = new JButton();
		this.botonModificarTarifa.setBounds(450, 50, 50, 50);
		this.botonModificarTarifa.setName("ModificarTarifa");
		this.botonModificarTarifa.setActionCommand("ModificarTarifa");
		this.botonModificarTarifa.addActionListener(new EscuchadoraBoton());
		
		this.botonAtras = new JButton();
		this.botonAtras.setBounds(450, 120, 50, 50);
		this.botonAtras.setName("Atras");
		this.botonAtras.setActionCommand("Atras");
		this.botonAtras.addActionListener(new EscuchadoraBoton());
		
		
	}
	
	public class EscuchadoraBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			
			switch (comando) {
			case "AltaCliente":
				break;
				
			case "BuscarDNI":
				break;
				
			case "BuscarFecha":
				break;
				
			case "VerClientes":
				break;
				
			case "ModificarTarifa":
				break;
				
			case "Atras":
				getControlador().ejecutaOpcionMenuCliente(MenuClientesConsola.ATRAS);
				break;
				
			default:
				break;
			}
		}

	}
	
	public Controlador getControlador()
	{
		return this.controlador;
	}
}
