package menus;

public enum MenuClientesConsola{
	ATRAS("Volver atras"),
	NUEVO_CLIENTE("Nuevo cliente"),
	BUSCAR_CLIENTE_DNI("Buscar cliente por dni"),
	BUSCAR_CLIENTE_ALTA("Buscar cliente por fecha alta"),
	VER_CLIENTES("Ver todos los clientes");
	
	private String descripcion;
	
	private MenuClientesConsola(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public static String getMenu() {
		StringBuilder sb = new StringBuilder();
		for (MenuClientesConsola opcion : MenuClientesConsola.values()) {
			sb.append(opcion.ordinal());
			sb.append(".- ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static MenuClientesConsola getOpcion(int posicion) {
		return values()[posicion];
	}

}
