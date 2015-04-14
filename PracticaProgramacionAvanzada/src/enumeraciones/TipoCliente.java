package enumeraciones;

public enum TipoCliente{
	PARTICULR("Particular"),
	EMPRESA("Empresa");
	
	private String descripcion;
	
	private TipoCliente(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public static String getMenu() {
		StringBuilder sb = new StringBuilder();
		for (TipoCliente opcion : TipoCliente.values()) {
			sb.append(opcion.ordinal());
			sb.append(".- ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static TipoCliente getOpcion(int posicion) {
		return values()[posicion];
	}

}
