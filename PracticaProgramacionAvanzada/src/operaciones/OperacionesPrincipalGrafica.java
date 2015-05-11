package operaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
import interfaces.IntGrafico;
import interfaces.IntOperacionesPrincipal;

public class OperacionesPrincipalGrafica implements IntOperacionesPrincipal, IntGrafico{

	private Controlador controlador;
	private JFrame ventanaPrincipal;
	private JPanel panel;
	private JButton botonMenuClientes;
	private JButton botonMenuLlamadas;
	private JButton botonMenuFacturas;
	private JButton botonSalir;
	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void setPanelPincipal(JPanel panel) {
		this.panel = panel;
		
	}

	@Override
	public void menuPincipal() throws Exception {
		JPanel panel2 = new JPanel();
		System.out.println(this.panel.getWidth());
		System.out.println(this.panel.getHeight());
		int posx = (this.panel.getWidth() - 600)/2;
		int posy = (this.panel.getHeight() - 350)/2;
		System.out.println(posx);
		System.out.println(posy);
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
	    
	    this.panel.add(panel2, BorderLayout.CENTER);
		
		
	}
	
	private void generarBotones()
	{
		ImageIcon imagenCliente = new ImageIcon("iconos/iconoClientes45x45.png");
		ImageIcon imagenFacturas = new ImageIcon("iconos/iconoFacturas45x45.png");
		ImageIcon imagenLlamadas = new ImageIcon("iconos/iconoLLamadas45x45.png");
		ImageIcon imagenSalir = new ImageIcon("iconos/iconoSalir45x45.png");
		
		this.botonMenuClientes = new JButton(imagenCliente);
		this.botonMenuClientes.setBounds(50, 50, 50, 50);
		
		this.botonMenuFacturas = new JButton(imagenFacturas);
		this.botonMenuFacturas.setBounds(50, 120, 50, 50);
		
		this.botonMenuLlamadas = new JButton(imagenLlamadas);
		this.botonMenuLlamadas.setBounds(50, 190, 50, 50);
		
		this.botonSalir = new JButton(imagenSalir);
		this.botonSalir.setBounds(50, 260, 50, 50);
		
		
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}

}
