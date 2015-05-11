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

import menus.MenuClientesConsola;
import menus.MenuFacturasConsola;
import menus.MenuPrincipalConsola;
import operaciones.OperacionesClientesGrafica.EscuchadoraBoton;
import objetos.Factura;
import controlador.Controlador;
import excepciones.ExcepcionClienteNoEncontrado;
import interfaces.IntGrafico;
import interfaces.IntOperacionesFacturas;

public class OperacionesFacturasGrafica implements IntGrafico, IntOperacionesFacturas{

	private Controlador controlador;
	
	private JFrame ventanaPrincipal;
	private JPanel panelPrincipal;
	
	private JButton botonEmitir;
	private JButton botonBuscarFacturaCodigo;
	private JButton botonBuscarFacturaFecha;
	private JButton botonVerFacturas;
	private JButton botonAtras;
	
	@Override
	public void menuPincipalFacturas() {
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
		
		panel2.add(this.botonEmitir);
		JLabel emitirLabel = new JLabel("Emitir");
		JLabel emitirLabel2 = new JLabel(MenuFacturasConsola.EMITIR_FACTURA.getDescripcion());
		emitirLabel.setBounds(120, 15, 100, 100);
		emitirLabel2.setBounds(120, 35, 400, 100);
		panel2.add(emitirLabel);
		panel2.add(emitirLabel2);
		
		panel2.add(this.botonBuscarFacturaCodigo);
		JLabel buscarFacturasCodigoLabel = new JLabel("Buscar por codigo");
		JLabel buscarFacturasCodigoLabel2 = new JLabel(MenuFacturasConsola.BUSCAR_FACTURA_CODIGO.getDescripcion());
		buscarFacturasCodigoLabel.setBounds(120, 85, 200, 100);
		buscarFacturasCodigoLabel2.setBounds(120, 105, 400, 100);
		panel2.add(buscarFacturasCodigoLabel);
		panel2.add(buscarFacturasCodigoLabel2);
	    
	    
	    panel2.add(this.botonBuscarFacturaFecha);
	    JLabel buscarFacturasFechaLabel = new JLabel("Buscar por fecha");
		JLabel buscarFacturasFechaLabel2 = new JLabel(MenuFacturasConsola.BUSCAR_FACTURAS_FECHA.getDescripcion());
		buscarFacturasFechaLabel.setBounds(120, 155, 200, 100);
		buscarFacturasFechaLabel2.setBounds(120, 175, 400, 100);
		panel2.add(buscarFacturasFechaLabel);
		panel2.add(buscarFacturasFechaLabel2);
	    
	    
	    panel2.add(this.botonVerFacturas);
	    JLabel verFacturasLabel = new JLabel("Ver Facturas");
		JLabel verFacturasLabel2 = new JLabel(MenuFacturasConsola.FACTURAS_CLIENTE.getDescripcion());
		verFacturasLabel.setBounds(120, 225, 200, 100);
		verFacturasLabel2.setBounds(120, 245, 400, 100);
		panel2.add(verFacturasLabel);
		panel2.add(verFacturasLabel2);
		
		panel2.add(this.botonAtras);
		JLabel atrasLabel = new JLabel(MenuFacturasConsola.ATRAS.getDescripcion());
		JLabel atrasLabel2 = new JLabel("Volver al menu principal");
		atrasLabel.setBounds(520, 15, 100, 100);
		atrasLabel2.setBounds(520, 35, 400, 100);
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
	public String emitirFactura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mostrarDatosFactura(Factura factura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String mostrarDatosFacturas(ArrayList<Factura> facturas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buscarFacturasCliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buscarFacturaPorCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Calendar> buscarFacturasClientePorFechaEmision() {
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
		
		this.botonEmitir = new JButton();
		this.botonEmitir.setBounds(50, 50, 50, 50);
		this.botonEmitir.setName("Emitir");
		this.botonEmitir.setActionCommand("Emitir");
		this.botonEmitir.addActionListener(new EscuchadoraBoton());
		
		
		this.botonBuscarFacturaCodigo = new JButton();
		this.botonBuscarFacturaCodigo.setBounds(50, 120, 50, 50);
		this.botonBuscarFacturaCodigo.setName("BuscarCodigo");
		this.botonBuscarFacturaCodigo.setActionCommand("BuscarCodigo");
		this.botonBuscarFacturaCodigo.addActionListener(new EscuchadoraBoton());
		
		this.botonBuscarFacturaFecha = new JButton();
		this.botonBuscarFacturaFecha.setBounds(50, 190, 50, 50);
		this.botonBuscarFacturaFecha.setName("BuscarFecha");
		this.botonBuscarFacturaFecha.setActionCommand("BuscarFecha");
		this.botonBuscarFacturaFecha.addActionListener(new EscuchadoraBoton());
		
		this.botonVerFacturas = new JButton();
		this.botonVerFacturas.setBounds(50, 260, 50, 50);
		this.botonVerFacturas.setName("VerFacturas");
		this.botonVerFacturas.setActionCommand("VerFacturas");
		this.botonVerFacturas.addActionListener(new EscuchadoraBoton());
		
		this.botonAtras = new JButton();
		this.botonAtras.setBounds(450, 50, 50, 50);
		this.botonAtras.setName("Atras");
		this.botonAtras.setActionCommand("Atras");
		this.botonAtras.addActionListener(new EscuchadoraBoton());
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
			case "Emitir":
				break;
				
			case "BuscarCodigo":
				break;
				
			case "BuscarFecha":
				break;
				
			case "VerFacturas":
				break;
				
			case "Atras":
				getControlador().ejecutaOpcionMenuFacturas(MenuFacturasConsola.ATRAS);
				break;
				
			default:
				break;
			}
		}
	}
	
	

}
