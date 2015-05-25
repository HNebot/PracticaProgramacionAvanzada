package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import menus.MenuClientesConsola;
import controlador.Controlador;
import operaciones.OperacionesClientesGrafica;
import operaciones.OperacionesFacturasGrafica;
import operaciones.OperacionesLlamadasGrafica;
import operaciones.OperacionesPrincipalGrafica;
import interfaces.IntIOInterface;
import interfaces.IntOperacionesClientes;
import interfaces.IntOperacionesFacturas;
import interfaces.IntOperacionesLlamadas;
import interfaces.IntOperacionesPrincipal;

public class IOInterfazGrafica implements IntIOInterface{
	
	private OperacionesClientesGrafica opClintes;
	private OperacionesFacturasGrafica opFacturas;
	private OperacionesLlamadasGrafica opLlamadas;
	private OperacionesPrincipalGrafica opPrincipal;
	
	private Controlador controlador;
	
	private JFrame ventana;
	private JPanel panelInicial;
    private Container contenedor;
	    
	public IOInterfazGrafica() {
		
		try {
			crearPanelPrincipal();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.opClintes = new OperacionesClientesGrafica();
		this.opFacturas = new OperacionesFacturasGrafica();
		this.opLlamadas = new OperacionesLlamadasGrafica();
		this.opPrincipal = new OperacionesPrincipalGrafica();
		
		this.opPrincipal.setPanelPincipal(this.panelInicial);
		this.opClintes.setPanelPincipal(this.panelInicial);
		this.opFacturas.setPanelPincipal(this.panelInicial);
		this.opLlamadas.setPanelPincipal(this.panelInicial);
	}
	
	public Controlador getControlador()
	{
		return this.controlador;
	}

	@Override
	public IntOperacionesClientes getOperacionesClientes() {
		return this.opClintes;
	}
	
	public OperacionesClientesGrafica getOperacionesClientesGrafica() {
		return this.opClintes;
	}

	
	@Override
	public IntOperacionesFacturas getOperacionesFacturas() {
		return this.opFacturas;
	}
	
	public OperacionesFacturasGrafica getOperacionesFacturasGrafica() {
		return this.opFacturas;
	}

	@Override
	public IntOperacionesLlamadas getOperacionesLlamadas() {
		return this.opLlamadas;
	}
	
	public OperacionesLlamadasGrafica getOperacionesLlamadasGrafica() {
		return this.opLlamadas;
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		this.opPrincipal.setControlador(controlador);
		this.opClintes.setControlador(controlador);
		this.opFacturas.setControlador(controlador);
		this.opLlamadas.setControlador(controlador);
	}

	@Override
	public IntOperacionesPrincipal getOperacionesPrincipal() {
		return this.opPrincipal;
	}
	
	private void crearPanelPrincipal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		this.ventana = new JFrame("TelefMas");
		this.contenedor = ventana.getContentPane();
		this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
 
		this.ventana.setIconImage(Toolkit.getDefaultToolkit().getImage("iconos/IconoEmpresa.png"));
		
		this.panelInicial = new JPanel();
		this.panelInicial.setLayout(null);
		contenedor.add(panelInicial);
		
		JMenuBar barraMenu = new JMenuBar();
		
		JMenu menuArchivo = new JMenu("Archivo");
		Action accionSalir = new AccionMenu("Salir");
		menuArchivo.add(accionSalir);
		barraMenu.add(menuArchivo);
		
		JMenu menuClientes = new JMenu("Cliente");
		Action accionVerClientes = new AccionMenu("Ver clientes");
		menuClientes.add(accionVerClientes);
		Action accionNuevoCliente = new AccionMenu("Nuevo cliente");
		menuClientes.add(accionNuevoCliente);
		Action accionBuscar = new AccionMenu("Buscar Cliente");
		menuClientes.add(accionBuscar);
		
		barraMenu.add(menuClientes);
		
		JMenu menuFacturas = new JMenu("Facturas");
		Action accionBuscarFacturas = new AccionMenu("Facturas cliente");
		menuFacturas.add(accionBuscarFacturas);
		Action accionEmitirFacturas = new AccionMenu("Emitir factura");
		menuFacturas.add(accionEmitirFacturas);
		
		barraMenu.add(menuFacturas);
		
		
		JMenu menuAyuda = new JMenu("Ayuda");
		Action accionInformacion = new AccionMenu("Información");
		menuAyuda.add(accionInformacion);
		barraMenu.add(menuAyuda);
		
		ventana.setJMenuBar(barraMenu);
	}
	private void visualizarPanelPincipal()
	{
		ventana.setBounds(200, 110, 1000, 600);
		ventana.setResizable(false);
		ventana.setVisible(true);
		
	}

	@Override
	public void start() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					visualizarPanelPincipal();
					getOperacionesPrincipal().menuPincipal();
				} catch (Exception e) {
					
				}
			}
		});

		
	}
	
	
	private class AccionMenu extends AbstractAction{

		private static final long serialVersionUID = 355044677127560958L;
		public AccionMenu(String nombre){
			putValue(Action.NAME, nombre);
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			switch ( (String) getValue(NAME)) {
			case "Ver clientes":
				getControlador().ejecutaOpcionMenuCliente(MenuClientesConsola.VER_CLIENTES);
				break;

			case "Nuevo cliente":
				getOperacionesClientesGrafica().vistaNuevoCliente();
				break;
				
			case "Buscar Cliente":
				getOperacionesClientesGrafica().vistaPedirDni("BuscarCliente");
				break;
				
			case "Facturas cliente":
				getOperacionesFacturasGrafica().vistaBuscarCliente("VerFacturas");
				break;
				
			case "Emitir factura":
				getOperacionesFacturasGrafica().vistaBuscarCliente("Emitir");
				break;
				
			case "Información":
				
				JFrame ventanaInfo = new JFrame("Información TelefMas");
				ventanaInfo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ventanaInfo.setIconImage(Toolkit.getDefaultToolkit().getImage("iconos/IconoEmpresa.png"));
				ventanaInfo.setBounds(100, 100, 450, 275);
				
				JPanel panel = new JPanel();
				ventanaInfo.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				panel.setBackground(Color.GRAY);
				
				PanelImagen panel_1 = new PanelImagen(); 
				panel_1.setBackgroundImage(panel_1.createImage("iconos/IconoEmpresaInfo.png").getImage());
				panel_1.setBounds(10, 11, 150, 200);
				Border borde = BorderFactory.createLineBorder(Color.BLACK);
				panel_1.setBorder(borde);
				panel.add(panel_1);
				
				JTextArea infoText = new JTextArea();
				infoText.setBounds(170, 11, 250, 200);
				infoText.setBackground(Color.LIGHT_GRAY);
				infoText.setEditable(false);
			    JScrollPane scroll = new JScrollPane(infoText);
			    scroll.setBounds(170, 11, 250, 200);
			    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			    String informacion = "TelefMas Manager\n\n"
			    		+ "Version: TelefMas Manager (2.0.1)\n\n"
			    		+ "Build id: 70140246-0800\n\n" 
			    		+ "(c) Copyright TelefMas contributors and others 2014, 2015.\n"
			    		+ "All rights reserved.\n "
			    		+ "Eclipse and the TelefMas logo are trademarks of the TelefMas Foundation, Inc.,\n"
			    		+ "The TelefMas logo cannot be altered without TelefMas's permission.\n"
			    		+ "TelefMas logos are provided for use under the TelefMas logo and trademark guidelines.\n";
			    infoText.setText(informacion);
			    panel.add(scroll);
				
			    JButton botonSalirInfo = new JButton("Salir");
			    botonSalirInfo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						ventanaInfo.setVisible(false);
						
					}
				});
			    botonSalirInfo.setBounds(300, 215, 100, 30);
			    panel.add(botonSalirInfo);
				
				ventanaInfo.setResizable(false);
				ventanaInfo.setVisible(true);
				break;
				
			case "Salir":
				System.exit(0);
				break;
			default:
				break;
			}
			
		}
		
	}
	
	public class PanelImagen extends JPanel {

		private static final long serialVersionUID = 6521278324796399116L;
		private Image bgImage;
		 
		 public PanelImagen() {
		  super();
		  this.setOpaque(false);
		 }
		 
		 public void setBackgroundImage(Image bgImage) {
		  this.bgImage = bgImage;
		 }
		 
		 public ImageIcon createImage(String path) {
		     if (path != null) {
		         return new ImageIcon(path);
		     } else {
		         return null;
		     }
		 }
		 
		 @Override
		 public void paint(Graphics g) {
		 
		  if(bgImage != null) {
		   g.drawImage(bgImage, -3, -3, null);
		  }
		 
		  super.paint(g);
		 
		 }
	}

}
