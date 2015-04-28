package main;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import operaciones.OperacionesClientesGrafica;
import operaciones.OperacionesFacturasGrafica;
import operaciones.OperacionesLlamadasGrafica;
import interfaces.IntIOInterface;
import interfaces.IntOperacionesClientes;
import interfaces.IntOperacionesFacturas;
import interfaces.IntOperacionesLlamadas;

public class IOInterfazGrafica implements IntIOInterface{
	
	private OperacionesClientesGrafica opClintes;
	private OperacionesFacturasGrafica opFacturas;
	private OperacionesLlamadasGrafica opLlamadas;
	
	private Controlador controlador;
	private JFrame ventana;
    private Container contenedor;
	    
	public IOInterfazGrafica() {
		
		this.ventana = new JFrame("Empresa Telefonia");
		this.contenedor = ventana.getContentPane();
		
		this.opClintes = new OperacionesClientesGrafica();
		this.opFacturas = new OperacionesFacturasGrafica();
		this.opLlamadas = new OperacionesLlamadasGrafica();
	}

	@Override
	public IntOperacionesClientes getOperacionesClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntOperacionesFacturas getOperacionesFacturas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntOperacionesLlamadas getOperacionesLlamadas() {
		// TODO Auto-generated method stub
		return null;
	}

}
