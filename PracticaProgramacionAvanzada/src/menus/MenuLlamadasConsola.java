package menus;

public enum MenuLlamadasConsola 
{
	ATRAS("Volver atras"),
	ALTA_LLAMADA("Dar de alta una llamada."),
	LLAMADAS_CLIENTE("Ver una llamadas de un cliente."),
	LLAMADAS_CLIENTE_FECHA("Ver las llamadas de un cliente comprendidas entre dos fechas.");
	
	private String descripcion;
	
	private MenuLlamadasConsola(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public static String getMenu() {
		StringBuilder sb = new StringBuilder();
		for (MenuLlamadasConsola opcion : MenuLlamadasConsola.values()) {
			sb.append(opcion.ordinal());
			sb.append(".- ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static MenuLlamadasConsola getOpcion(int posicion)  {
		return values()[posicion];
	}

}
