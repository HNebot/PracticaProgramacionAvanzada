package menus;

public enum MenuFacturasConsola {
	ATRAS("Volver atras"),
	EMITIR_FACTURA("Emitir una factura de un cliente."),
	BUSCAR_FACTURA_CODIGO("Buscar una factura usando su codigo."),
	BUSCAR_FACTURAS_FECHA("Buscar las facturas de un cliente comprendidas entre dos fechas."),
	FACTURAS_CLIENTE("Buscar las facturas de un cliente.");
	
	private String descripcion;
	
	private MenuFacturasConsola(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public static String getMenu() {
		StringBuilder sb = new StringBuilder();
		for (MenuFacturasConsola opcion : MenuFacturasConsola.values()) {
			sb.append(opcion.ordinal());
			sb.append(".- ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static MenuFacturasConsola getOpcion(int posicion) {
		try
		{
			return values()[posicion];
		}catch(ArrayIndexOutOfBoundsException e)
		{
			return values()[0];
		}
	}

}
