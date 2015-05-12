package operaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.util.Pair;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
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

public class OperacionesClientesGrafica implements IntGrafico, IntOperacionesClientes {
	
	private Controlador controlador;
	private TipoCliente tipocliente;
	private TipoTarifaHoraria tipoTarifaHoraria = TipoTarifaHoraria.NADA;
	private TipoTarifaFinDeSemana tipoTarifaFinDeSemana = TipoTarifaFinDeSemana.NADA;
	
	private escuchadorRaton escuchadorRaton = new escuchadorRaton();
	
	private JFrame ventanaPrincipal;
	private JPanel panelPrincipal;
	private JPanel panelNuevoCliente;
	private JPanel panelTarifas;
	
	private JButton botonAltaCliente;
	private JButton botonBuscarClienteDNI;
	private JButton botonBuscarClienteFecha;
	private JButton botonVerClientes;
	private JButton botonModificarTarifa;
	private JButton botonAtras;
	
	private JLabel dniLabel;
	private JLabel nombreLabel;
	private JLabel apellidoLabel;
	private JLabel emailLabel;
	private JLabel direccionLabel;
	private JLabel portalLabel;
	private JLabel pisoPuertaLabel;
	private JLabel poblacionLabel;
	private JLabel provinciaLabel;
	private JLabel codigoPostalLabel;
	private JLabel tarifaLabel;
	private JLabel telefonoLabel;
	private JLabel fechaAltaLabel;
	
	private JTextField dniText;
	private JTextField nombreText;
	private JTextField apellidoText;
	private JTextField emailText;
	private JTextField direccionText;
	private JTextField portalText;
	private JTextField pisoPuertaText;
	private JTextField poblacionText;
	private JTextField provinciaText;
	private JTextField codigoPostalText;
	private JTextField telefonoText;
	
	private JRadioButton empresaRadioButton;
	private JRadioButton particularRadioButton;
	private ButtonGroup tipoClienteGroup;
	
	private JRadioButton tarifaManyanaRadioButton;
	private JRadioButton tarifaTardeRadioButton;
	private JRadioButton tarifaNocheRadioButton;
	private JRadioButton tarifaNingunaHorariaRadioButton;
	
	private JRadioButton tarifaSabadoRadioButton;
	private JRadioButton tarifaDomingoRadioButton;
	private JRadioButton tarifaViernesSabadoRadioButton;
	private JRadioButton tarifaSabadoDomingoRadioButton;
	private JRadioButton tarifaFinDeSemanaRadioButton;
	private JRadioButton tarifaNingunaFindeRadioButton;
	
	private ButtonGroup tarifasHorasGroup;
	private ButtonGroup tarifasDiasGroup;
	
	
	
	
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
	
	public void vistaNuevoCliente()
	{
		this.panelPrincipal.removeAll();
		JPanel panel2 = new JPanel();
		int posx = (this.panelPrincipal.getWidth() - 800)/2;
		int posy = (this.panelPrincipal.getHeight() - 450)/2;
		panel2.setBounds(posx, posy, 800, 450);
		Border raisedbevel = BorderFactory.createLineBorder(Color.GRAY);
		panel2.setBorder(raisedbevel);
		panel2.setLayout(new BorderLayout());
		
		iniciarPanelNuevoCliente();
		iniciarPanelTarifas();
		
		JTabbedPane pestanyas = new JTabbedPane();
		pestanyas.addTab("Datos personales", this.panelNuevoCliente);
		pestanyas.addTab("Tarifas", this.panelTarifas);
		
		panel2.add(pestanyas, BorderLayout.CENTER);
		this.panelPrincipal.add(panel2, BorderLayout.CENTER);
		this.panelPrincipal.revalidate();
		this.panelPrincipal.repaint();
	}
	
	private void iniciarPanelNuevoCliente()
	{
		this.panelNuevoCliente = new JPanel();
		this.panelNuevoCliente.setLayout(null);
		this.panelNuevoCliente.setBackground(Color.GRAY);		
		
		JLabel titulo = new JLabel("Introduce los datos personales del cliente");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulo.setBounds(250, 20, 300, 20);
		this.panelNuevoCliente.add(titulo);
		
		JLabel tipocliente = new JLabel("Tipo de cliente: ");
		tipocliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		tipocliente.setBounds(30, 60, 150, 20);
		this.panelNuevoCliente.add(tipocliente);	
		
		this.empresaRadioButton = new JRadioButton(TipoCliente.EMPRESA.getDescripcion(), true);
		this.empresaRadioButton.setActionCommand("Empresa");
		this.empresaRadioButton.addItemListener(new escuchadorRadioButtons());
		this.particularRadioButton = new JRadioButton(TipoCliente.PARTICULR.getDescripcion());
		this.particularRadioButton.setActionCommand("Particular");
		this.particularRadioButton.addItemListener(new escuchadorRadioButtons());
		this.tipoClienteGroup = new ButtonGroup();
		this.tipoClienteGroup.add(this.empresaRadioButton);
		this.tipoClienteGroup.add(this.particularRadioButton);	
		this.empresaRadioButton.setBounds(200, 60, 100, 20);
		this.particularRadioButton.setBounds(350, 60, 100, 20);
		this.panelNuevoCliente.add(this.empresaRadioButton);
		this.panelNuevoCliente.add(this.particularRadioButton);

		
		this.dniLabel = new JLabel("DNI/NIF:");
		this.dniLabel.setBounds(50, 110, 80, 20);
		this.dniLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.dniText = new JTextField(50);
		this.dniText.setBounds(130, 100, 250, 30);
		this.panelNuevoCliente.add(this.dniLabel);
		this.panelNuevoCliente.add(this.dniText);
		
		
		this.nombreLabel = new JLabel("Nombre:");
		this.nombreLabel.setBounds(50, 160, 80, 20);
		this.nombreLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.nombreText = new JTextField(50);
		this.nombreText.setBounds(130, 150, 250, 30);
		this.panelNuevoCliente.add(this.nombreLabel);
		this.panelNuevoCliente.add(this.nombreText);
		
		
		this.apellidoLabel = new JLabel("Apellido:");
		this.apellidoLabel.setBounds(400, 160, 80, 20);
		this.apellidoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.apellidoText = new JTextField(50);
		this.apellidoText.setBounds(480, 150, 250, 30);
		this.cambiarClienteEmpresa();
		this.panelNuevoCliente.add(this.apellidoLabel);
		this.panelNuevoCliente.add(this.apellidoText);

		
		this.direccionLabel = new JLabel("Dirección:");
		this.direccionLabel.setBounds(50, 210, 80, 20);
		this.direccionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.direccionText = new JTextField(50);
		this.direccionText.setBounds(130, 200, 200, 30);
		
		this.portalLabel = new JLabel("Portal:");
		this.portalLabel.setBounds(360, 210, 80, 20);
		this.portalLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.portalText = new JTextField(20);
		this.portalText.setBounds(420, 200, 80, 30);
		
		this.pisoPuertaLabel = new JLabel("Piso y puerta:");
		this.pisoPuertaLabel.setBounds(520, 210, 100, 20);
		this.pisoPuertaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.pisoPuertaText = new JTextField(20);
		this.pisoPuertaText.setBounds(630, 200, 60, 30);
		
		this.panelNuevoCliente.add(this.direccionLabel);
		this.panelNuevoCliente.add(this.direccionText);
		this.panelNuevoCliente.add(this.portalLabel);
		this.panelNuevoCliente.add(this.portalText);
		this.panelNuevoCliente.add(this.pisoPuertaLabel);
		this.panelNuevoCliente.add(this.pisoPuertaText);
		
		this.poblacionLabel = new JLabel("Población:");
		this.poblacionLabel.setBounds(50, 260, 100, 20);
		this.poblacionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.poblacionText = new JTextField(50);
		this.poblacionText.setBounds(130, 250, 150, 30);
		this.panelNuevoCliente.add(this.poblacionLabel);
		this.panelNuevoCliente.add(this.poblacionText);
		
		this.provinciaLabel = new JLabel("Porvincia:");
		this.provinciaLabel.setBounds(290, 260, 100, 20);
		this.provinciaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.provinciaText = new JTextField(50);
		this.provinciaText.setBounds(370, 250, 150, 30);
		this.panelNuevoCliente.add(this.provinciaLabel);
		this.panelNuevoCliente.add(this.provinciaText);
		
		this.codigoPostalLabel = new JLabel("Codigo postal:");
		this.codigoPostalLabel.setBounds(530, 260, 100, 20);
		this.codigoPostalLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.codigoPostalText = new JTextField(50);
		this.codigoPostalText.setBounds(630, 250, 100, 30);
		this.panelNuevoCliente.add(this.codigoPostalLabel);
		this.panelNuevoCliente.add(this.codigoPostalText);
		
		
		this.emailLabel = new JLabel("Correo electronico:");
		this.emailLabel.setBounds(50, 310, 150, 20);
		this.emailLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.emailText = new JTextField(70);
		this.emailText.setBounds(200, 300, 280, 30);
		this.panelNuevoCliente.add(this.emailLabel);
		this.panelNuevoCliente.add(this.emailText);
		
		this.telefonoLabel = new JLabel("Telefono cliente:");
		this.telefonoLabel.setBounds(50, 360, 150, 20);
		this.telefonoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		this.telefonoText = new JTextField(70);
		this.telefonoText.setBounds(200, 350, 200, 30);
		this.panelNuevoCliente.add(this.telefonoLabel);
		this.panelNuevoCliente.add(this.telefonoText);
		
	}
	
	private void iniciarPanelTarifas()
	{
		this.panelTarifas = new JPanel();
		this.panelTarifas.setLayout(null);
		this.panelTarifas.setBackground(Color.GRAY);		
		
		JLabel titulo = new JLabel("Seleccione las tarifas extras que desea aplicar al cliente");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulo.setBounds(200, 20, 400, 20);
		this.panelTarifas.add(titulo);
		
		JLabel tarifasHoras = new JLabel("Tipo de facturas por hora: ");
		tarifasHoras.setFont(new Font("Tahoma", Font.BOLD, 13));
		tarifasHoras.setBounds(30, 60, 200, 20);
		this.panelTarifas.add(tarifasHoras);
		
		this.tarifaManyanaRadioButton = new JRadioButton(TipoTarifaHoraria.TARIFA_MANYANA.getDescripcion());
		this.tarifaTardeRadioButton = new JRadioButton(TipoTarifaHoraria.TARIFA_TARDE.getDescripcion());
		this.tarifaNocheRadioButton = new JRadioButton(TipoTarifaHoraria.TARIFA_NOCHE.getDescripcion());
		this.tarifaNingunaHorariaRadioButton = new JRadioButton(TipoTarifaHoraria.NADA.getDescripcion(), true);
		
		this.tarifaManyanaRadioButton.setActionCommand("TarifaManyana");
		this.tarifaManyanaRadioButton.addItemListener(new escuchadorRadioButtons());
		this.tarifaTardeRadioButton.setActionCommand("TarifaTarde");
		this.tarifaTardeRadioButton.addItemListener(new escuchadorRadioButtons());
		this.tarifaNocheRadioButton.setActionCommand("TarifaNoche");
		this.tarifaNocheRadioButton.addItemListener(new escuchadorRadioButtons());
		this.tarifaNingunaHorariaRadioButton.setActionCommand("TarifaHorariaNada");
		this.tarifaNingunaHorariaRadioButton.addItemListener(new escuchadorRadioButtons());
		this.cambiarTarifaHoras("TarifaHorariaNada");
		
		this.tarifasHorasGroup = new ButtonGroup();
		this.tarifasHorasGroup.add(this.tarifaManyanaRadioButton);
		this.tarifasHorasGroup.add(this.tarifaTardeRadioButton);
		this.tarifasHorasGroup.add(this.tarifaNocheRadioButton);
		this.tarifasHorasGroup.add(this.tarifaNingunaHorariaRadioButton);
		
		this.tarifaManyanaRadioButton.setBounds(50, 80, 750, 20);
		this.tarifaTardeRadioButton.setBounds(50, 100, 750, 20);
		this.tarifaNocheRadioButton.setBounds(50, 120, 750, 20);
		this.tarifaNingunaHorariaRadioButton.setBounds(50, 140, 750, 20);
		
		
		this.panelTarifas.add(this.tarifaManyanaRadioButton);
		this.panelTarifas.add(this.tarifaTardeRadioButton);
		this.panelTarifas.add(this.tarifaNocheRadioButton);
		this.panelTarifas.add(this.tarifaNingunaHorariaRadioButton);
		
		
		
		JLabel tarifasFinde = new JLabel("Tipo de facturas para fin de semana: ");
		tarifasFinde.setFont(new Font("Tahoma", Font.BOLD, 13));
		tarifasFinde.setBounds(30, 170, 250, 20);
		this.panelTarifas.add(tarifasFinde);
		
		this.tarifaSabadoRadioButton = new JRadioButton(TipoTarifaFinDeSemana.TARIFA_SABADO.getDescripcion());
		this.tarifaDomingoRadioButton = new JRadioButton(TipoTarifaFinDeSemana.TARIFA_DOMINGO.getDescripcion());
		this.tarifaViernesSabadoRadioButton = new JRadioButton(TipoTarifaFinDeSemana.TARIFA_VIERNES_SABADO.getDescripcion());
		this.tarifaSabadoDomingoRadioButton = new JRadioButton(TipoTarifaFinDeSemana.TARIFA_SABADO_DOMINGO.getDescripcion());
		this.tarifaFinDeSemanaRadioButton = new JRadioButton(TipoTarifaFinDeSemana.TARIFA_FIN_DE_SEMANA.getDescripcion());
		this.tarifaNingunaFindeRadioButton = new JRadioButton(TipoTarifaFinDeSemana.NADA.getDescripcion(), true);
		
		this.tarifaSabadoRadioButton.setActionCommand("TarifaSabado");
		this.tarifaSabadoRadioButton.addItemListener(new escuchadorRadioButtons());
		this.tarifaDomingoRadioButton.setActionCommand("TarifaDomingo");
		this.tarifaDomingoRadioButton.addItemListener(new escuchadorRadioButtons());
		this.tarifaViernesSabadoRadioButton.setActionCommand("TarifaViernesSabado");
		this.tarifaViernesSabadoRadioButton.addItemListener(new escuchadorRadioButtons());
		this.tarifaSabadoDomingoRadioButton.setActionCommand("TarifaSabadoDomingo");
		this.tarifaSabadoDomingoRadioButton.addItemListener(new escuchadorRadioButtons());
		this.tarifaFinDeSemanaRadioButton.setActionCommand("TarifaFinDeSemanda");
		this.tarifaFinDeSemanaRadioButton.addItemListener(new escuchadorRadioButtons());
		this.tarifaNingunaFindeRadioButton.setActionCommand("TarifaFindeNada");
		this.tarifaNingunaFindeRadioButton.addItemListener(new escuchadorRadioButtons());
		this.cambiarTarifaFinDeSemana("TarifaFindeNada");
		
		this.tarifasDiasGroup = new ButtonGroup();
		this.tarifasDiasGroup.add(this.tarifaSabadoRadioButton);
		this.tarifasDiasGroup.add(this.tarifaDomingoRadioButton);
		this.tarifasDiasGroup.add(this.tarifaViernesSabadoRadioButton);
		this.tarifasDiasGroup.add(this.tarifaSabadoDomingoRadioButton);
		this.tarifasDiasGroup.add(this.tarifaFinDeSemanaRadioButton);
		this.tarifasDiasGroup.add(this.tarifaNingunaFindeRadioButton);
		
		this.tarifaSabadoRadioButton.setBounds(50, 190, 750, 20);
		this.tarifaDomingoRadioButton.setBounds(50, 210, 750, 20);
		this.tarifaViernesSabadoRadioButton.setBounds(50, 230, 750, 20);
		this.tarifaSabadoDomingoRadioButton.setBounds(50, 250, 750, 20);
		this.tarifaFinDeSemanaRadioButton.setBounds(50, 270, 750, 20);
		this.tarifaNingunaFindeRadioButton.setBounds(50, 290, 750, 20);
		
		
		this.panelTarifas.add(this.tarifaSabadoRadioButton);
		this.panelTarifas.add(this.tarifaDomingoRadioButton);
		this.panelTarifas.add(this.tarifaViernesSabadoRadioButton);
		this.panelTarifas.add(this.tarifaSabadoDomingoRadioButton);
		this.panelTarifas.add(this.tarifaFinDeSemanaRadioButton);
		this.panelTarifas.add(this.tarifaNingunaFindeRadioButton);
		
		
		JLabel tarifaBase = new JLabel("**La tarifa base aplicada a todos los cliente tiene un coste de 0,15€/min por llamada");
		tarifaBase.setFont(new Font("Tahoma", Font.BOLD, 13));
		tarifaBase.setBounds(30, 330, 600, 20);
		this.panelTarifas.add(tarifaBase);
		
		
		
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
	public void cambiarClienteEmpresa(){
		this.apellidoText.setText("");
		this.apellidoText.setEditable(false);
		this.apellidoText.addMouseListener(escuchadorRaton);
		this.tipocliente = TipoCliente.EMPRESA;
	}
	public void cambiarClienteParticular(){
		this.apellidoText.removeMouseListener(escuchadorRaton);
		this.apellidoText.setEditable(true);
		this.tipocliente = TipoCliente.EMPRESA;
	}
	
	public void cambiarTarifaHoras(String tarifa)
	{
		switch (tarifa) {
			case "TarifaHorariaNada":
				this.tipoTarifaHoraria = TipoTarifaHoraria.NADA;
				break;
				
			case "TarifaNoche":
				this.tipoTarifaHoraria = TipoTarifaHoraria.TARIFA_NOCHE;		
				break;
							
			case "TarifaManyana":
				this.tipoTarifaHoraria = TipoTarifaHoraria.TARIFA_MANYANA;
				break;
				
			case "TarifaTarde":
				this.tipoTarifaHoraria = TipoTarifaHoraria.TARIFA_TARDE;
				break;
		}
	}
	
	public void cambiarTarifaFinDeSemana(String tarifa) {
		switch (tarifa) {
		case "TarifaFindeNada":
			this.tipoTarifaFinDeSemana = TipoTarifaFinDeSemana.NADA;
			break;
			
		case "TarifaSabado":
			this.tipoTarifaFinDeSemana = TipoTarifaFinDeSemana.TARIFA_SABADO;	
			break;
						
		case "TarifaDomingo":
			this.tipoTarifaFinDeSemana = TipoTarifaFinDeSemana.TARIFA_DOMINGO;
			break;
			
		case "TarifaViernesSabado":
			this.tipoTarifaFinDeSemana = TipoTarifaFinDeSemana.TARIFA_VIERNES_SABADO;
			break;
			
		case "TarifaSabadoDomingo":
			this.tipoTarifaFinDeSemana = TipoTarifaFinDeSemana.TARIFA_SABADO_DOMINGO;
			break;
			
		case "TarifaFinDeSemanda":
			this.tipoTarifaFinDeSemana = TipoTarifaFinDeSemana.TARIFA_FIN_DE_SEMANA;
			break;
		
		}
	}
	
	public class EscuchadoraBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			
			switch (comando) {
			case "AltaCliente":
				vistaNuevoCliente();
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
	
	public class escuchadorRadioButtons implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			JRadioButton boton = (JRadioButton)e.getItemSelectable();
			String comando = boton.getActionCommand();
			if(e.getStateChange() == ItemEvent.SELECTED)
			{
				switch (comando) {
				case "Empresa":
					cambiarClienteEmpresa();
					
					break;
				case "Particular":
					cambiarClienteParticular();
					break;
					
				case "TarifaTarde":
					cambiarTarifaHoras(comando);
					break;
					
				case "TarifaNoche":
					cambiarTarifaHoras(comando);
					break;
					
				case "TarifaManyana":
					cambiarTarifaHoras(comando);
					break;
					
				case "TarifaHorariaNada":
					cambiarTarifaHoras(comando);
					break;
					
				case "TarifaFindeNada":
					cambiarTarifaFinDeSemana(comando);
					break;
					
				case "TarifaSabado":
					cambiarTarifaFinDeSemana(comando);
					break;
								
				case "TarifaDomingo":
					cambiarTarifaFinDeSemana(comando);
					break;
					
				case "TarifaViernesSabado":
					cambiarTarifaFinDeSemana(comando);
					break;
					
				case "TarifaSabadoDomingo":
					cambiarTarifaFinDeSemana(comando);
					break;
					
				case "TarifaFinDeSemanda":
					cambiarTarifaFinDeSemana(comando);
					break;
				}
			}
		}
		
	}
	
	public class escuchadorRaton implements MouseListener{
		
		@Override
		public void mouseReleased(MouseEvent e) {
							
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			JOptionPane.showMessageDialog(new JFrame(), "El campo 'Apellido' solo se puede rellenarse si el cliente es un particular.");				
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
							
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public Controlador getControlador()
	{
		return this.controlador;
	}
}
