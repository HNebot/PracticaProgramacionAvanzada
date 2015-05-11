package operaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.border.Border;

import menus.MenuPrincipalConsola;
import controlador.Controlador;
import excepciones.ExcepcionClienteNoEncontrado;
import interfaces.IntGrafico;
import interfaces.IntOperacionesPrincipal;

public class OperacionesPrincipalGrafica implements IntOperacionesPrincipal, IntGrafico{

	private Controlador controlador;
	private JFrame ventanaPrincipal;
	private JPanel panelPrincipal;
	private JButton botonMenuClientes;
	private JButton botonMenuLlamadas;
	private JButton botonMenuFacturas;
	private JButton botonSalir;
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void setPanelPincipal(JPanel panel) {
		this.panelPrincipal = panel;
		
	}

	@Override
	public void menuPincipal() throws Exception {
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
		
		panel2.add(this.botonMenuClientes);
		JLabel clientesLabel = new JLabel(MenuPrincipalConsola.CLIENTES.getDescripcion());
		JLabel clientesLabel2 = new JLabel("Accede al menu pincipial para realizar operaciones sobre clientes");
		clientesLabel.setBounds(120, 15, 100, 100);
		clientesLabel2.setBounds(120, 35, 400, 100);
		panel2.add(clientesLabel);
		panel2.add(clientesLabel2);
		
		panel2.add(this.botonMenuFacturas);
		JLabel facturasLabel = new JLabel(MenuPrincipalConsola.FACTURAS.getDescripcion());
		JLabel facturasLabel2 = new JLabel("Accede al menu pincipial para realizar operaciones sobre facturas");
		facturasLabel.setBounds(120, 85, 100, 100);
		facturasLabel2.setBounds(120, 105, 400, 100);
		panel2.add(facturasLabel);
		panel2.add(facturasLabel2);
	    
	    
	    panel2.add(this.botonMenuLlamadas);
	    JLabel llamadasLabel = new JLabel(MenuPrincipalConsola.LLAMADAS.getDescripcion());
		JLabel llamadasLabel2 = new JLabel("Accede al menu pincipial para realizar operaciones sobre llamadas");
		llamadasLabel.setBounds(120, 155, 100, 100);
		llamadasLabel2.setBounds(120, 175, 400, 100);
		panel2.add(llamadasLabel);
		panel2.add(llamadasLabel2);
	    
	    
	    panel2.add(this.botonSalir);
	    JLabel salirLabel = new JLabel(MenuPrincipalConsola.SALIR.getDescripcion());
		JLabel salirLabel2 = new JLabel("Salir totalmente de la aplicaccion");
		salirLabel.setBounds(120, 225, 150, 100);
		salirLabel2.setBounds(120, 245, 400, 100);
		panel2.add(salirLabel);
		panel2.add(salirLabel2);
	    
	    this.panelPrincipal.add(panel2, BorderLayout.CENTER);
	    this.panelPrincipal.repaint();
		
		
	}
	
	private void generarBotones()
	{
		ImageIcon imagenCliente = new ImageIcon("iconos/iconoClientes45x45.png");
		ImageIcon imagenFacturas = new ImageIcon("iconos/iconoFacturas45x45.png");
		ImageIcon imagenLlamadas = new ImageIcon("iconos/iconoLLamadas45x45.png");
		ImageIcon imagenSalir = new ImageIcon("iconos/iconoSalir45x45.png");
		
		this.botonMenuClientes = new JButton(imagenCliente);
		this.botonMenuClientes.setBounds(50, 50, 50, 50);
		this.botonMenuClientes.setName("MenuClientes");
		this.botonMenuClientes.setActionCommand("MenuClientes");
		this.botonMenuClientes.addActionListener(new EscuchadoraBoton());
		
		
		this.botonMenuFacturas = new JButton(imagenFacturas);
		this.botonMenuFacturas.setBounds(50, 120, 50, 50);
		this.botonMenuFacturas.setName("MenuFaturas");
		this.botonMenuFacturas.setActionCommand("MenuFaturas");
		this.botonMenuFacturas.addActionListener(new EscuchadoraBoton());
		
		this.botonMenuLlamadas = new JButton(imagenLlamadas);
		this.botonMenuLlamadas.setBounds(50, 190, 50, 50);
		this.botonMenuLlamadas.setName("MenuLlamadas");
		this.botonMenuLlamadas.setActionCommand("MenuLlamadas");
		this.botonMenuLlamadas.addActionListener(new EscuchadoraBoton());
		
		this.botonSalir = new JButton(imagenSalir);
		this.botonSalir.setBounds(50, 260, 50, 50);
		this.botonSalir.setName("Salir");
		this.botonSalir.setActionCommand("Salir");
		this.botonSalir.addActionListener(new EscuchadoraBoton());
		
		
	}
	public class EscuchadoraBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			
			switch (comando) {
			case "MenuClientes":
				try {
					getControlador().ejecutaOpcionMenuPrincipal(MenuPrincipalConsola.CLIENTES);
				} catch (ExcepcionClienteNoEncontrado e1) {}
				break;
			case "MenuFaturas":
				try {
					getControlador().ejecutaOpcionMenuPrincipal(MenuPrincipalConsola.FACTURAS);
				} catch (ExcepcionClienteNoEncontrado e1) {}
				break;
			case "MenuLlamadas":
				try {
					getControlador().ejecutaOpcionMenuPrincipal(MenuPrincipalConsola.LLAMADAS);
				} catch (ExcepcionClienteNoEncontrado e1) {}
				break;
			case "Salir":
				try {
					getControlador().ejecutaOpcionMenuPrincipal(MenuPrincipalConsola.SALIR);
				} catch (ExcepcionClienteNoEncontrado e1) {}
				break;
				
			default:
				break;
			}
		}
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}
	
	public Controlador getControlador(){
		return this.controlador;
	}
	

}
