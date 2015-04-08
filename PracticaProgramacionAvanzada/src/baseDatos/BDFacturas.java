package baseDatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import objetos.Factura;

public class BDFacturas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3140478683150785681L;
	private HashMap<String,ArrayList<Factura>> factuas;
}
