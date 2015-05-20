package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import menus.MenuClientesConsola;
import menus.MenuFacturasConsola;
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
		this.ventana = new JFrame("Empresa Telefonia");
		this.contenedor = ventana.getContentPane();
		this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				JOptionPane.showMessageDialog(new JFrame(), "informacion\n"
						+ "asdasdasdasd");
				break;
				
			case "Salir":
				System.exit(0);
				break;
			default:
				break;
			}
			
		}
		
	}

}
