package operaciones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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

import operaciones.OperacionesPrincipalGrafica.EscuchadoraBoton;
import menus.MenuFacturasConsola;
import menus.MenuLlamadasConsola;
import menus.MenuPrincipalConsola;
import objetos.Llamada;
import controlador.Controlador;
import interfaces.IntGrafico;
import interfaces.IntOperacionesLlamadas;
import interfaces.IntOperacionesPrincipal;

public class OperacionesLlamadasGrafica implements IntOperacionesLlamadas, IntGrafico{

	private Controlador controlador;
	
	private JPanel panelPrincipal;
	
	private JButton botonAltaLLamada;
	private JButton botonVerLlamadasClientes;
	private JButton botonVerLlamadasClienteFecha;
	private JButton botonAtras;
	private JButton botonBuscar;
	
	private JLabel dniLabel;
	private JLabel fechaLlamadaLabel;
	private JLabel telefonoReceptorLabel;
	private JLabel duracionLlamadaLabel;
	
	private JTextField dniText;
	private JTextField telefonoReceptorText;
	private JTextField duracionLlamadaText;

	private JComboBox<Integer> listaDias1;
	private JComboBox<Integer> listaMeses1;
	private JComboBox<Integer> listaAnyos1;
	private JComboBox<Integer> listaDias2;
	private JComboBox<Integer> listaMeses2;
	private JComboBox<Integer> listaAnyos2;

	private JTextArea llamdasTextArea;

	private JLabel llamadasLabel;
	
	@Override
	public void setPanelPincipal(JPanel panel) {
		this.panelPrincipal = panel;
		
	}

	@Override
	public void menuPincipalLLamadas() {
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
		
		panel2.add(this.botonAltaLLamada);
		JLabel altaLlamadaLabel = new JLabel("Nueva llamada");
		JLabel altaLlamadasLabel2 = new JLabel(MenuLlamadasConsola.ALTA_LLAMADA.getDescripcion());
		altaLlamadaLabel.setBounds(120, 15, 100, 100);
		altaLlamadasLabel2.setBounds(120, 35, 400, 100);
		panel2.add(altaLlamadaLabel);
		panel2.add(altaLlamadasLabel2);
		
		panel2.add(this.botonVerLlamadasClientes);
		JLabel verLlamadasLabel = new JLabel("Ver llamadas");
		JLabel verLlamadasLabel2 = new JLabel(MenuLlamadasConsola.LLAMADAS_CLIENTE.getDescripcion());
		verLlamadasLabel.setBounds(120, 85, 100, 100);
		verLlamadasLabel2.setBounds(120, 105, 400, 100);
		panel2.add(verLlamadasLabel);
		panel2.add(verLlamadasLabel2);
	    
	    
	    panel2.add(this.botonVerLlamadasClienteFecha);
	    JLabel verLlamadasFechaLabel = new JLabel("Ver llamadas por fecha");
		JLabel verLlamadasFechaLabel2 = new JLabel(MenuLlamadasConsola.LLAMADAS_CLIENTE_FECHA.getDescripcion());
		verLlamadasFechaLabel.setBounds(120, 155, 150, 100);
		verLlamadasFechaLabel2.setBounds(120, 175, 400, 100);
		panel2.add(verLlamadasFechaLabel);
		panel2.add(verLlamadasFechaLabel2);
	    
	    
	    panel2.add(this.botonAtras);
	    JLabel salirLabel = new JLabel(MenuLlamadasConsola.ATRAS.getDescripcion());
		JLabel salirLabel2 = new JLabel("Volver al menu principal");
		salirLabel.setBounds(120, 225, 150, 100);
		salirLabel2.setBounds(120, 245, 400, 100);
		panel2.add(salirLabel);
		panel2.add(salirLabel2);
	    
	    this.panelPrincipal.add(panel2, BorderLayout.CENTER);
	    this.panelPrincipal.repaint();
	}

	private void generarBotones() {
		ImageIcon imagenCliente = new ImageIcon("iconos/iconoClientes45x45.png");
		ImageIcon imagenFacturas = new ImageIcon("iconos/iconoFacturas45x45.png");
		ImageIcon imagenLlamadas = new ImageIcon("iconos/iconoLLamadas45x45.png");
		ImageIcon imagenSalir = new ImageIcon("iconos/iconoSalir45x45.png");
		
		this.botonAltaLLamada = new JButton();
		this.botonAltaLLamada.setBounds(50, 50, 50, 50);
		this.botonAltaLLamada.setName("AltaLlamada");
		this.botonAltaLLamada.setActionCommand("VistaAltaLlamada");
		this.botonAltaLLamada.addActionListener(new EscuchadoraBoton());
		
		
		this.botonVerLlamadasClientes = new JButton();
		this.botonVerLlamadasClientes.setBounds(50, 120, 50, 50);
		this.botonVerLlamadasClientes.setName("VerLlamadasCliente");
		this.botonVerLlamadasClientes.setActionCommand("VistaPedirDni VerLlamadasCliente");
		this.botonVerLlamadasClientes.addActionListener(new EscuchadoraBoton());
		
		this.botonVerLlamadasClienteFecha = new JButton();
		this.botonVerLlamadasClienteFecha.setBounds(50, 190, 50, 50);
		this.botonVerLlamadasClienteFecha.setName("VerLlamadasClienteFecha");
		this.botonVerLlamadasClienteFecha.setActionCommand("VistaPedirDni VistaPedirFechas");
		this.botonVerLlamadasClienteFecha.addActionListener(new EscuchadoraBoton());
		
		this.botonAtras = new JButton();
		this.botonAtras.setBounds(50, 260, 50, 50);
		this.botonAtras.setName("Atras");
		this.botonAtras.setActionCommand("Atras");
		this.botonAtras.addActionListener(new EscuchadoraBoton());
		
	}

	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}

	@Override
	public ArrayList<String> realizarLLamada() {
		 ArrayList<String> datosLLamada = new ArrayList<String>();
		 datosLLamada.add(this.dniText.getText());
		 datosLLamada.add(this.telefonoReceptorText.getText());
		 datosLLamada.add(this.duracionLlamadaText.getText());
		return datosLLamada;
	}

	@Override
	public String llamadasCliente() {
		return this.dniText.getText();
	}

	@Override
	public void mostrarLlamadas(ArrayList<Llamada> llamadas) {

		this.panelPrincipal.removeAll();
		JPanel panel2 = new JPanel();
		int posx = (this.panelPrincipal.getWidth() - 800)/2;
		int posy = (this.panelPrincipal.getHeight() - 350)/2;
		panel2.setBounds(posx, posy, 800, 350);
		panel2.setBackground(Color.GRAY);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		panel2.setBorder(raisedbevel);
		panel2.setLayout(null);
		
		JLabel titulo = new JLabel("Llamadas encontradas");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 15));
		titulo.setBounds(280, 20, 450, 20);
		panel2.add(titulo);
		
		this.dniLabel = new JLabel("Cliente: " + this.dniText.getText());
		this.dniLabel.setBounds(50, 110, 110, 20);
		this.dniLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel2.add(this.dniLabel);;

		this.llamadasLabel = new JLabel("Llamadas encontradas");
		llamadasLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		llamadasLabel.setBounds(50, 140, 450, 20);
		panel2.add(llamadasLabel);
		
		this.llamdasTextArea = new JTextArea();
		this.llamdasTextArea.setBounds(60, 170, 700, 150);
		this.llamdasTextArea.setBackground(Color.LIGHT_GRAY);
		this.llamdasTextArea.setEditable(false);
	    JScrollPane scroll = new JScrollPane(this.llamdasTextArea);
	    scroll.setBounds(60, 165, 700, 150);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    
	    String informacion = "";
	    for(Llamada llamada: llamadas)
		{
			informacion = informacion + this.formatoLlamadaPantalla(llamada);
			informacion = informacion + "===================================\n";
		}
	    
	    this.llamdasTextArea.setText(informacion);
	    panel2.add(scroll);
	    
	    this.botonAtras = new JButton("Atras");
		this.botonAtras.setActionCommand("MenuLlamadas");
		this.botonAtras.addActionListener(new EscuchadoraBoton());	
		this.botonAtras.setBounds(650, 314, 100, 30);
		
		panel2.add(this.botonAtras);
		
		this.panelPrincipal.add(panel2, BorderLayout.CENTER);
		this.panelPrincipal.revalidate();
		this.panelPrincipal.repaint();
		
	}

	@Override
	public String formatoLlamadaPantalla(Llamada llamada) {
		String infoLlamada = "";
		infoLlamada = infoLlamada + "Telefono receptor: " + llamada.toArray().get(0) + "\n";
		infoLlamada = infoLlamada + "Fecha de la llamada: " + llamada.toArray().get(1) + "\n";
		infoLlamada = infoLlamada + "Duracion de la llamada: " + llamada.toArray().get(2) + "\n";
		return infoLlamada;
	}

	@Override
	public ArrayList<Calendar> buscarLlamadasClientePorFecha() {
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
	
	public Controlador getControlador()
	{
		return this.controlador;
	}
	
	public class EscuchadoraBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String[] comando = e.getActionCommand().split(" ");
			
			switch (comando[0]) {
			case "AltaLlamada":
				vistaAltaLlamadas();
				break;
				
			case "RealizarLlamada":
				getControlador().ejecutaOpcionMenuLlamadas(MenuLlamadasConsola.ALTA_LLAMADA);
				break;
				
			case "VistaAltaLlamada":
				vistaAltaLlamadas();
				break;
			
			case "VistaPedirDni":
				vistaPedirDni(comando[1]);
				break;
				
			case "VerLlamadasCliente":
				getControlador().ejecutaOpcionMenuLlamadas(MenuLlamadasConsola.LLAMADAS_CLIENTE);
				break;
				
			case "VistaPedirFechas":
				vistaPedirFechas();
				break;
				
			case "VerLlamadasClienteFecha":
				getControlador().ejecutaOpcionMenuLlamadas(MenuLlamadasConsola.LLAMADAS_CLIENTE_FECHA);
				break;
				
			case "Atras":
				getControlador().ejecutaOpcionMenuLlamadas(MenuLlamadasConsola.ATRAS);
				break;
			
			case "MenuLlamadas":
				menuPincipalLLamadas();
				break;	
			default:
				break;
			}
		}
	}

	@Override
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(new JFrame(), mensaje);
		this.menuPincipalLLamadas();
		
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
		
		this.fechaLlamadaLabel = new JLabel("Fecha de la llamada inicio:");
		this.fechaLlamadaLabel.setBounds(50, 110, 190, 20);
		this.fechaLlamadaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
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
		lbaelDia1.setBounds(250, 110, 50, 20);
		
		JLabel lbaelMes1 = new JLabel("mes ");
		lbaelMes1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaelMes1.setBounds(340, 104, 50, 30);
		
		JLabel lbaelAnyo1 = new JLabel("año ");
		lbaelAnyo1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaelAnyo1.setBounds(430, 104, 50, 30);
		
		this.listaDias1 = new JComboBox<Integer>(dias);
		this.listaDias1.setBounds(280, 104, 50, 30);
		this.listaMeses1 = new JComboBox<Integer>(meses);
		this.listaMeses1.setBounds(370, 104, 50, 30);
		this.listaAnyos1 =new JComboBox<Integer>(anyos);
		this.listaAnyos1.setBounds(460, 104, 85, 30);
		
		panel2.add(this.fechaLlamadaLabel);
		panel2.add(listaDias1);
		panel2.add(lbaelDia1);
		panel2.add(listaMeses1);
		panel2.add(lbaelMes1);
		panel2.add(listaAnyos1);
		panel2.add(lbaelAnyo1);
		
		this.fechaLlamadaLabel = new JLabel("Fecha de la llamada final:");
		this.fechaLlamadaLabel.setBounds(50, 150, 190, 20);
		this.fechaLlamadaLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lbaelDia2 = new JLabel("dia ");
		lbaelDia2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaelDia2.setBounds(250, 150, 50, 20);
		
		JLabel lbaelMes2 = new JLabel("mes ");
		lbaelMes2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaelMes2.setBounds(340, 144, 50, 30);
		
		JLabel lbaelAnyo2 = new JLabel("año ");
		lbaelAnyo2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbaelAnyo2.setBounds(430, 144, 50, 30);
		
		this.listaDias2 = new JComboBox<Integer>(dias);
		this.listaDias2.setBounds(280, 144, 50, 30);
		this.listaMeses2 = new JComboBox<Integer>(meses);
		this.listaMeses2.setBounds(370, 144, 50, 30);
		this.listaAnyos2 =new JComboBox<Integer>(anyos);
		this.listaAnyos2.setBounds(460, 144, 85, 30);
		
		panel2.add(this.fechaLlamadaLabel);
		panel2.add(listaDias2);
		panel2.add(lbaelDia2);
		panel2.add(listaMeses2);
		panel2.add(lbaelMes2);
		panel2.add(listaAnyos2);
		panel2.add(lbaelAnyo2);
		
		
		this.botonBuscar = new JButton("Buscar");
		this.botonBuscar.setActionCommand("VerFacturasFecha");
		this.botonBuscar.addActionListener(new EscuchadoraBoton());	
		this.botonBuscar.setBounds(440, 200, 100, 30);
		
		
		
		this.botonAtras = new JButton("Atras");
		this.botonAtras.setActionCommand("MenuFacturas");
		this.botonAtras.addActionListener(new EscuchadoraBoton());	
		this.botonAtras.setBounds(540, 200, 100, 30);
		
		panel2.add(this.botonBuscar);
		panel2.add(this.botonAtras);
		
		this.panelPrincipal.add(panel2, BorderLayout.CENTER);
		this.panelPrincipal.revalidate();
		this.panelPrincipal.repaint();
		
	}

	public void vistaPedirDni(String command){
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
			
			this.botonBuscar = new JButton("Continuar");
			this.botonBuscar.setActionCommand(command);
			this.botonBuscar.addActionListener(new EscuchadoraBoton());	
			this.botonBuscar.setBounds(400, 100, 100, 30);
			
			this.botonAtras = new JButton("Atras");
			this.botonAtras.setActionCommand("MenuLlamadas");
			this.botonAtras.addActionListener(new EscuchadoraBoton());	
			this.botonAtras.setBounds(500, 100, 100, 30);
			
			panel2.add(this.botonBuscar);
			panel2.add(this.botonAtras);
			
			this.panelPrincipal.add(panel2, BorderLayout.CENTER);
			this.panelPrincipal.revalidate();
			this.panelPrincipal.repaint();
			
		
	}

	public void vistaAltaLlamadas() {
		this.panelPrincipal.removeAll();
		JPanel panel2 = new JPanel();
		int posx = (this.panelPrincipal.getWidth() - 800)/2;
		int posy = (this.panelPrincipal.getHeight() - 350)/2;
		panel2.setBounds(posx, posy, 800, 350);
		panel2.setBackground(Color.GRAY);
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		panel2.setBorder(raisedbevel);
		panel2.setLayout(null);
		
		JLabel titulo = new JLabel("Dar de alta una nueva llamada");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		titulo.setBounds(280, 20, 450, 20);
		panel2.add(titulo);
		
		this.dniLabel = new JLabel("DNI/NIF:");
		this.dniLabel.setBounds(50, 110, 80, 20);
		this.dniLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.dniText = new JTextField(50);
		this.dniText.setBounds(130, 100, 100, 30);
		panel2.add(this.dniLabel);
		panel2.add(this.dniText);
		
		this.telefonoReceptorLabel = new JLabel("Telefono receptor :");
		this.telefonoReceptorLabel.setBounds(50, 140, 150, 20);
		this.telefonoReceptorLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.telefonoReceptorText = new JTextField(50);
		this.telefonoReceptorText.setBounds(210, 130, 250, 30);
		panel2.add(this.telefonoReceptorLabel);
		panel2.add(this.telefonoReceptorText);
		
		this.duracionLlamadaLabel = new JLabel("Duración:");
		this.duracionLlamadaLabel.setBounds(50, 170, 120, 20);
		this.duracionLlamadaLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.duracionLlamadaText = new JTextField(50);
		this.duracionLlamadaText.setBounds(140, 160, 100, 30);
		panel2.add(this.duracionLlamadaLabel);
		panel2.add(this.duracionLlamadaText);
		
		
		
		this.botonBuscar = new JButton("Continuar");
		this.botonBuscar.setActionCommand("RealizarLlamada");
		this.botonBuscar.addActionListener(new EscuchadoraBoton());	
		this.botonBuscar.setBounds(400, 250, 100, 30);
		
		this.botonAtras = new JButton("Atras");
		this.botonAtras.setActionCommand("MenuLlamadas");
		this.botonAtras.addActionListener(new EscuchadoraBoton());	
		this.botonAtras.setBounds(500, 250, 100, 30);
		
		panel2.add(this.botonBuscar);
		panel2.add(this.botonAtras);
		
		this.panelPrincipal.add(panel2, BorderLayout.CENTER);
		this.panelPrincipal.revalidate();
		this.panelPrincipal.repaint();
		
		
	}

}
