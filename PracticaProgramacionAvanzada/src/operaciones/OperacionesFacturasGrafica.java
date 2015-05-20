package operaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

import menus.MenuFacturasConsola;
import objetos.Factura;
import objetos.Llamada;
import controlador.Controlador;
import interfaces.IntGrafico;
import interfaces.IntOperacionesFacturas;

public class OperacionesFacturasGrafica implements IntGrafico, IntOperacionesFacturas{

	private Controlador controlador;
	
	private JPanel panelPrincipal;
	private JPanel panelVerfacturas;
	
	private JButton botonEmitir;
	private JButton botonBuscarFacturaCodigo;
	private JButton botonBuscarFacturaFecha;
	private JButton botonVerFacturas;
	private JButton botonAtras;

	private JLabel dniLabel;
	private JLabel codigoFacturaLabel;
	private JLabel fechaInicioLabel;
	private JLabel fechaFinLabel;
	private JLabel fechaEnmisionLabel;
	private JLabel facturacionTotalLabel;
	private JLabel llamadasLabel;
	private JLabel tarifaLabel;
	
	private JTextArea llamdasTextArea;

	private JTextField dniText;
	private JTextField codifoFacturaText;

	private JButton botonBuscar;
	
	private JComboBox<Integer> listaDias1;
	private JComboBox<Integer> listaDias2;
	private JComboBox<Integer> listaMeses1;
	private JComboBox<Integer> listaMeses2;
	private JComboBox<Integer> listaAnyos1;
	private JComboBox<Integer> listaAnyos2;
	
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
	
	public void vistaBuscarCliente(String command) {
		this.panelPrincipal.removeAll();
		JPanel panel2 = new JPanel();
		int posx = (this.panelPrincipal.getWidth() - 800)/2;
		int posy = (this.panelPrincipal.getHeight() - 350)/2;
		panel2.setBounds(posx, posy, 800, 350);
		panel2.setBackground(Color.GRAY);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		panel2.setBorder(raisedbevel);
		panel2.setLayout(null);
		
		JLabel titulo = new JLabel("Introduce el Dni del cliente");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulo.setBounds(280, 20, 450, 20);
		panel2.add(titulo);
		
		this.dniLabel = new JLabel("DNI/NIF:");
		this.dniLabel.setBounds(50, 110, 80, 20);
		this.dniLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.dniText = new JTextField(50);
		this.dniText.setBounds(130, 100, 250, 30);
		panel2.add(this.dniLabel);
		panel2.add(this.dniText);
		
		this.botonBuscar = new JButton(command);
		this.botonBuscar.setActionCommand(command);
		this.botonBuscar.addActionListener(new EscuchadoraBoton());	
		this.botonBuscar.setBounds(400, 100, 100, 30);
		
		this.botonAtras = new JButton("Atras");
		this.botonAtras.setActionCommand("MenuFacturas");
		this.botonAtras.addActionListener(new EscuchadoraBoton());	
		this.botonAtras.setBounds(500, 100, 100, 30);
		
		panel2.add(this.botonBuscar);
		panel2.add(this.botonAtras);
		
		this.panelPrincipal.add(panel2, BorderLayout.CENTER);
		this.panelPrincipal.repaint();
		
	}
	
	public void vistaPedirFechas() {
		this.panelPrincipal.removeAll();
		JPanel panel2 = new JPanel();
		int posx = (this.panelPrincipal.getWidth() - 800)/2;
		int posy = (this.panelPrincipal.getHeight() - 350)/2;
		panel2.setBounds(posx, posy, 800, 350);
		panel2.setBackground(Color.GRAY);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		panel2.setBorder(raisedbevel);
		panel2.setLayout(null);
		
		JLabel titulo = new JLabel("Introduce el rango de fechas que desea filtrar");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulo.setBounds(230, 20, 350, 20);
		panel2.add(titulo);
		
		this.fechaEnmisionLabel = new JLabel("Fecha de emisión inicio:");
		this.fechaEnmisionLabel.setBounds(50, 110, 150, 20);
		this.fechaEnmisionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		Integer[] dias = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 
				20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
		
		Integer[] meses = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int anyoInicio = 1960;
		Integer numeroAnyos = (Integer.parseInt(sdf.format(Calendar.getInstance().getTime())) - anyoInicio + 1);
		
		Integer[] anyos = new Integer[numeroAnyos];
		for(int i = 0; i < numeroAnyos; i++)
		{
			anyos[i] = anyoInicio + i;
		}
		
		JLabel lbaelDia1 = new JLabel("dia ");
		lbaelDia1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaelDia1.setBounds(210, 110, 50, 20);
		
		JLabel lbaelMes1 = new JLabel("mes ");
		lbaelMes1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaelMes1.setBounds(300, 104, 50, 30);
		
		JLabel lbaelAnyo1 = new JLabel("año ");
		lbaelAnyo1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaelAnyo1.setBounds(390, 104, 50, 30);
		
		this.listaDias1 = new JComboBox<Integer>(dias);
		this.listaDias1.setBounds(240, 104, 50, 30);
		this.listaMeses1 = new JComboBox<Integer>(meses);
		this.listaMeses1.setBounds(330, 104, 50, 30);
		this.listaAnyos1 =new JComboBox<Integer>(anyos);
		this.listaAnyos1.setBounds(420, 104, 85, 30);
		
		panel2.add(this.fechaEnmisionLabel);
		panel2.add(listaDias1);
		panel2.add(lbaelDia1);
		panel2.add(listaMeses1);
		panel2.add(lbaelMes1);
		panel2.add(listaAnyos1);
		panel2.add(lbaelAnyo1);
		
		this.fechaEnmisionLabel = new JLabel("Fecha de emisión final:");
		this.fechaEnmisionLabel.setBounds(50, 150, 150, 20);
		this.fechaEnmisionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lbaelDia2 = new JLabel("dia ");
		lbaelDia2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaelDia2.setBounds(210, 150, 50, 20);
		
		JLabel lbaelMes2 = new JLabel("mes ");
		lbaelMes2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaelMes2.setBounds(300, 144, 50, 30);
		
		JLabel lbaelAnyo2 = new JLabel("año ");
		lbaelAnyo2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaelAnyo2.setBounds(390, 144, 50, 30);
		
		this.listaDias2 = new JComboBox<Integer>(dias);
		this.listaDias2.setBounds(240, 144, 50, 30);
		this.listaMeses2 = new JComboBox<Integer>(meses);
		this.listaMeses2.setBounds(330, 144, 50, 30);
		this.listaAnyos2 =new JComboBox<Integer>(anyos);
		this.listaAnyos2.setBounds(420, 144, 85, 30);
		
		panel2.add(this.fechaEnmisionLabel);
		panel2.add(listaDias2);
		panel2.add(lbaelDia2);
		panel2.add(listaMeses2);
		panel2.add(lbaelMes2);
		panel2.add(listaAnyos2);
		panel2.add(lbaelAnyo2);
		
		
		this.botonBuscar = new JButton("Buscar");
		this.botonBuscar.setActionCommand("VerFacturasFecha");
		this.botonBuscar.addActionListener(new EscuchadoraBoton());	
		this.botonBuscar.setBounds(400, 200, 100, 30);
		
		
		
		this.botonAtras = new JButton("Atras");
		this.botonAtras.setActionCommand("MenuFacturas");
		this.botonAtras.addActionListener(new EscuchadoraBoton());	
		this.botonAtras.setBounds(500, 200, 100, 30);
		
		panel2.add(this.botonBuscar);
		panel2.add(this.botonAtras);
		
		this.panelPrincipal.add(panel2, BorderLayout.CENTER);
		this.panelPrincipal.repaint();
		
	}

	@Override
	public String emitirFactura() {
		return this.dniText.getText();
	}

	@Override
	public void mostrarDatosFactura(Factura factura) {
		this.panelPrincipal.removeAll();
		this.panelVerfacturas = new JPanel();
		int posx = (this.panelPrincipal.getWidth() - 800)/2;
		int posy = (this.panelPrincipal.getHeight() - 350)/2;
		panelVerfacturas.setBounds(posx, posy, 800, 350);
		panelVerfacturas.setBackground(Color.GRAY);
		
		GridBagLayout gbl_panelVerClientes = new GridBagLayout();
		gbl_panelVerClientes.columnWidths = new int[]{0, 0};
		gbl_panelVerClientes.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelVerClientes.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		//gbl_panelVerClientes.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panelVerfacturas.setLayout(gbl_panelVerClientes);
		
		
		JLabel label = new JLabel("Cliente encontrado");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.fill = GridBagConstraints.NORTH;
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panelVerfacturas.add(label, gbc_label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setLayout(null);
		panel_1.setSize(800, 300);
		panel_1.setPreferredSize(new Dimension(800, 200));
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2, true);
		panel_1.setBorder(border);
		mostrarDatosFactura(factura, panel_1);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panelVerfacturas.add(panel_1, gbc_panel_1);
		
		this.panelPrincipal.add(this.panelVerfacturas);
		this.panelPrincipal.revalidate();
		this.panelPrincipal.repaint();
		
		
		
	}
	
	public void mostrarDatosFactura(Factura factura, JPanel panel) {	
		if(factura != null){
			this.dniLabel = new JLabel("DNI/NIF cliente: " + this.dniText.getText());
			this.dniLabel.setBounds(50, 30, 210, 20);
			this.dniLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			panel.add(this.dniLabel);
			
			this.codigoFacturaLabel = new JLabel("Codigo factura: " + factura.toArray().get(0));
			this.codigoFacturaLabel.setBounds(290, 30, 250, 20);
			this.codigoFacturaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			panel.add(this.codigoFacturaLabel);
			
			this.fechaInicioLabel = new JLabel("Fecha factura: " + factura.toArray().get(1));
			this.fechaInicioLabel.setBounds(50, 60, 300, 20);
			this.fechaInicioLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			panel.add(this.fechaInicioLabel);
			
			this.fechaFinLabel = new JLabel(" - " + factura.toArray().get(2));
			this.fechaFinLabel.setBounds(220, 60, 300, 20);
			this.fechaFinLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			panel.add(this.fechaFinLabel);
			
			this.tarifaLabel = new JLabel("Tarifa aplicada: " + factura.toArray().get(3));
			this.tarifaLabel.setBounds(50, 90, 600, 20);
			this.tarifaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			panel.add(tarifaLabel);
			
			if(factura.getFecha() != null)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
				this.fechaEnmisionLabel = new JLabel("Fecha emision: " + sdf.format(factura.getFecha().getTime()));
				this.facturacionTotalLabel = new JLabel("Facturacion total: : " + factura.facturacionTotal() + "€");
			}
			else{
				this.fechaEnmisionLabel = new JLabel("Fecha emisión: Factura aun no emitida");
				this.facturacionTotalLabel = new JLabel("Facturación total: no aplicable hasta emisión");
			
			}
			this.fechaEnmisionLabel.setBounds(50, 120, 600, 20);
			this.fechaEnmisionLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			panel.add(fechaEnmisionLabel);
			this.facturacionTotalLabel.setBounds(50, 150, 600, 20);
			this.facturacionTotalLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			panel.add(facturacionTotalLabel);
			
			this.llamadasLabel = new JLabel("Llamadas: ");
			this.llamadasLabel.setBounds(50, 170, 600, 20);
			this.llamadasLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			panel.add(llamadasLabel);
			
			this.llamdasTextArea = new JTextArea();
			this.llamdasTextArea.setBounds(70, 190, 500, 100);
			this.llamdasTextArea.setBackground(Color.GRAY);
			this.llamdasTextArea.setEditable(false);
		    JScrollPane scroll = new JScrollPane(this.llamdasTextArea);
		    scroll.setBounds(70, 185, 500, 100);
		    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		    
		    String llamadas = "";
		    for(Llamada llamada: factura.getLlamadasFactura())
			{
		    	llamadas = llamadas + llamada.toString() + "\n";
			}
		    
		    this.llamdasTextArea.setText(llamadas);
		    
		    panel.add(scroll);
			
		}
		
		
		panel.repaint();
		
	}

	@Override
	public void mostrarDatosFacturas(ArrayList<Factura> facturas) {
		int tam = facturas.size();
		int tamrowWeights = facturas.size() + 3;
		
		this.panelPrincipal.removeAll();
		this.panelVerfacturas = new JPanel();
		int posx = (this.panelPrincipal.getWidth() - 800)/2;
		int posy = (this.panelPrincipal.getHeight() - 350)/2;
		panelVerfacturas.setBounds(posx, posy, 770, 350);
		panelVerfacturas.setBackground(Color.GRAY);
		
		JScrollPane scroll = new JScrollPane();
		scroll .setBounds(posx, posy, 800, 350);
		scroll .setViewportView(panelVerfacturas);
		scroll .getViewport().setView(panelVerfacturas);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		scroll.setBorder(raisedbevel);
		panelVerfacturas.setPreferredSize(new Dimension(770, (350 * tam)));
		GridBagLayout gbl_panelVerFacturas = new GridBagLayout();
		gbl_panelVerFacturas.columnWidths = new int[]{0, 0};
		gbl_panelVerFacturas.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelVerFacturas.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelVerFacturas.rowWeights = new double[tamrowWeights];
		for(int i = 0; i < tamrowWeights-1; i++)
		{
			gbl_panelVerFacturas.rowWeights[i] = Double.MIN_VALUE;
		}
		gbl_panelVerFacturas.rowWeights[tamrowWeights-1] = 1.0;
		
		panelVerfacturas.setLayout(gbl_panelVerFacturas);
		
		JLabel label = new JLabel("Facturas encontradas");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.fill = GridBagConstraints.NORTH;
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panelVerfacturas.add(label, gbc_label_1);
		
		
		int contadorPosicion = 1;
		for(Factura factura : facturas){
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.GRAY);
			panel_1.setLayout(null);
			panel_1.setSize(770, 300);
			panel_1.setPreferredSize(new Dimension(770, 300));
			Border border = BorderFactory.createLineBorder(Color.BLACK, 2, true);
			panel_1.setBorder(border);
			mostrarDatosFactura(factura, panel_1);
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.insets = new Insets(0, 0, 5, 0);
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = contadorPosicion;
			panelVerfacturas.add(panel_1, gbc_panel_1);
			contadorPosicion++;
		}
		
		
		this.botonAtras = new JButton("Atras");
		this.botonAtras.setActionCommand("MenuFacturas");
		this.botonAtras.addActionListener(new EscuchadoraBoton());	
		
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.fill = GridBagConstraints.LINE_END;
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = tamrowWeights - 2;
		panelVerfacturas.add(this.botonAtras, gbc_button_1);
		
		this.panelPrincipal.add(scroll);
		this.panelPrincipal.revalidate();
		this.panelPrincipal.repaint();
		
	}

	@Override
	public String buscarFacturasCliente() {
		return this.dniText.getText();
	}
	
	public void vistaPedirCodFactura() {
		this.panelPrincipal.removeAll();
		JPanel panel2 = new JPanel();
		int posx = (this.panelPrincipal.getWidth() - 800)/2;
		int posy = (this.panelPrincipal.getHeight() - 350)/2;
		panel2.setBounds(posx, posy, 800, 350);
		panel2.setBackground(Color.GRAY);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		panel2.setBorder(raisedbevel);
		panel2.setLayout(null);
		
		JLabel titulo = new JLabel("Introduce el codigo de la factura que desea buscar");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulo.setBounds(180, 20, 450, 20);
		panel2.add(titulo);
		
		this.dniLabel = new JLabel("Cod. factura:");
		this.dniLabel.setBounds(50, 110, 120, 20);
		this.dniLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.dniText = new JTextField(50);
		this.dniText.setBounds(165, 100, 250, 30);
		panel2.add(this.dniLabel);
		panel2.add(this.dniText);
		
		this.botonBuscar = new JButton("Buscar");
		this.botonBuscar.setActionCommand("BuscarFactura");
		this.botonBuscar.addActionListener(new EscuchadoraBoton());	
		this.botonBuscar.setBounds(465, 100, 100, 30);
		
		this.botonAtras = new JButton("Atras");
		this.botonAtras.setActionCommand("MenuFacturas");
		this.botonAtras.addActionListener(new EscuchadoraBoton());	
		this.botonAtras.setBounds(565, 100, 100, 30);
		
		panel2.add(this.botonBuscar);
		panel2.add(this.botonAtras);
		
		this.panelPrincipal.add(panel2, BorderLayout.CENTER);
		this.panelPrincipal.repaint();
		
	}

	@Override
	public String buscarFacturaPorCodigo() {
		return this.codifoFacturaText.getText();
	}

	@Override
	public ArrayList<Calendar> buscarFacturasClientePorFechaEmision() {
		try{
			ArrayList<Calendar> filtro = new ArrayList<Calendar>();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
			
			String fechaInicio = "" + this.listaDias1.getSelectedItem() + 
					"/" + this.listaMeses1.getSelectedItem() + 
					"/" + this.listaAnyos1.getSelectedItem();
			
			Date fecha1 = sdf.parse(fechaInicio , new ParsePosition(0));
			Calendar cal1 = new GregorianCalendar();
			cal1.setTime(fecha1);
			filtro.add(cal1);
			
			String fechaFin = "" + this.listaDias2.getSelectedItem() + 
					"/" + this.listaMeses2.getSelectedItem() + 
					"/" + this.listaAnyos2.getSelectedItem();
			Date fecha2 = sdf.parse(fechaFin, new ParsePosition(0));
			Calendar cal2 = new GregorianCalendar();
			cal2.setTime(fecha2);
			filtro.add(cal2);
			
			return filtro;
		}catch(NullPointerException e)
		{
			System.out.println("java.lang.NullPointerException");
			System.out.println("Error en el formato de la fecha");
			return null;
		}
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
		this.botonEmitir.setActionCommand("BuscarCliente Emitir");
		this.botonEmitir.addActionListener(new EscuchadoraBoton());
		
		
		this.botonBuscarFacturaCodigo = new JButton();
		this.botonBuscarFacturaCodigo.setBounds(50, 120, 50, 50);
		this.botonBuscarFacturaCodigo.setName("BuscarCodigo");
		this.botonBuscarFacturaCodigo.setActionCommand("BuscarCodigo");
		this.botonBuscarFacturaCodigo.addActionListener(new EscuchadoraBoton());
		
		this.botonBuscarFacturaFecha = new JButton();
		this.botonBuscarFacturaFecha.setBounds(50, 190, 50, 50);
		this.botonBuscarFacturaFecha.setName("BuscarFecha");
		this.botonBuscarFacturaFecha.setActionCommand("BuscarCliente BuscarFecha");
		this.botonBuscarFacturaFecha.addActionListener(new EscuchadoraBoton());
		
		this.botonVerFacturas = new JButton();
		this.botonVerFacturas.setBounds(50, 260, 50, 50);
		this.botonVerFacturas.setName("VerFacturas");
		this.botonVerFacturas.setActionCommand("BuscarCliente VerFacturas");
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
			String[] comando = e.getActionCommand().split(" ");
			
			switch (comando[0]) {
			case "Emitir":
				getControlador().ejecutaOpcionMenuFacturas(MenuFacturasConsola.EMITIR_FACTURA);
				break;
				
			case "BuscarCliente":
				vistaBuscarCliente(comando[1]);
				break;
				
			case "BuscarCodigo":
				vistaPedirCodFactura();
				break;
				
			case "BuscarFecha":
				vistaPedirFechas();
				break;
				
			case "VerFacturas":
				getControlador().ejecutaOpcionMenuFacturas(MenuFacturasConsola.FACTURAS_CLIENTE);
				break;
			
			case "VerFacturasFecha":
				getControlador().ejecutaOpcionMenuFacturas(MenuFacturasConsola.BUSCAR_FACTURAS_FECHA);
				break;
				
			case "Atras":
				getControlador().ejecutaOpcionMenuFacturas(MenuFacturasConsola.ATRAS);
				break;
				
			case "MenuFacturas":
				menuPincipalFacturas();
				break;
				
			case "BuscarFactura":
				getControlador().ejecutaOpcionMenuFacturas(MenuFacturasConsola.BUSCAR_FACTURA_CODIGO);
				break;
				
			default:
				break;
			}
		}
	}

	@Override
	public void mostrarMenjase(String mensaje) {
		JOptionPane.showMessageDialog(new JFrame(), mensaje);
		menuPincipalFacturas();
		
	}

}
