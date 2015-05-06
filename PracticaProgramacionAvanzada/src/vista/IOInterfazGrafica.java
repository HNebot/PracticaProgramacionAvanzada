package vista;

import java.awt.Color;
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
		
		crearPanelPrincipal();
		
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
	
	private void crearPanelPrincipal()
	{
		this.ventana = new JFrame("Empresa Telefonia");
		this.contenedor = ventana.getContentPane();
		this.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panelInicial = new JPanel();
		ventana.add(panelInicial);
		JMenu menu = new JMenu("Cliente");
		Action accionVerClientes = new AccionMenu("Ver clientes");
		menu.add(accionVerClientes);
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.add(menu);
		ventana.setJMenuBar(barraMenu);
	}
	private void visualizarPanelPincipal()
	{
		ventana.setSize(800, 400);
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
