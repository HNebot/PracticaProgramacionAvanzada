package vista;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Menu;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
	}

	@Override
	public IntOperacionesClientes getOperacionesClientes() {
		return this.opClintes;
	}

	@Override
	public IntOperacionesFacturas getOperacionesFacturas() {
		return this.opFacturas;
	}

	@Override
	public IntOperacionesLlamadas getOperacionesLlamadas() {
		return this.opLlamadas;
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
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
		JMenu menu = new JMenu("Cliente");
		Action accionVerClientes = new AccionMenu("Ver clientes");
		menu.add(accionVerClientes);
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.add(menu);
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

		public AccionMenu(String nombre){
			putValue(Action.NAME, nombre);
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			switch ( (String) getValue(NAME)) {
			case "Ver clientes":
				System.out.println("verclientes");
				break;

			default:
				break;
			}
			
		}
		
	}

}
