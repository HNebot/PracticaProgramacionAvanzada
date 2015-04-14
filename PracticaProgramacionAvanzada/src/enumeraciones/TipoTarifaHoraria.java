package enumeraciones;

public enum TipoTarifaHoraria
{
	TARIFA_MAÑANA("Tarifa Buenos Dias: "
			+ "Despierte a todos, llamadas economicas de 7 a 12 de la mañana"),
	TARIFA_TARDE("Tarifa Buen Provecho: "
			+ "Hable con sus amigos a medio dia con llamadas a 0.5 de 12 a 20 de la tarde"),
	TARIFA_NOCHE("Tarifa buenas noches: "
			+ "Las llamdas a 0.6 de 20 a 1 de la noche para que le cuente su dia a todos"),
	NADA("Ninguna: No se aplique ninguna tarifa especial y que viva el capitalismo");
	
	private String descripcion;
	
	private TipoTarifaHoraria(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public static String getMenu() {
		StringBuilder sb = new StringBuilder();
		for (TipoTarifaHoraria opcion : TipoTarifaHoraria.values()) {
			sb.append(opcion.ordinal());
			sb.append(".- ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static TipoTarifaHoraria getOpcion(int posicion) {
		return values()[posicion];
	}
	
	

}