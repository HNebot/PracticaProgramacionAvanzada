package enumeraciones;

public enum TipoTarifaFinDeSemana {
	TARIFA_SABADO("Tarifa Buenos Dias: "
			+ "Despierte a todos, llamadas economicas de 7 a 12 de la mañana"),
	TARIFA_DOMINGO("Tarifa Buen Provecho: "
			+ "Hable con sus amigos a medio dia con llamadas a 0.5 de 12 a 20 de la tarde"),
	TARIFA_VIERNES_SABADO("Tarifa buenas noches: "
			+ "Las llamdas a 0.6 de 20 a 1 de la noche para que le cuente su dia a todos"),
	TARIFA_SABADO_DOMINGO("Tarifa buenas noches: "
					+ "Las llamdas a 0.6 de 20 a 1 de la noche para que le cuente su dia a todos"),
	TARIFA_FIN_DE_SEMANA("Tarifa buenas noches: "
							+ "Las llamdas a 0.6 de 20 a 1 de la noche para que le cuente su dia a todos"),
	NADA("Ninguna: No se aplique ninguna tarifa especial y que viva el capitalismo");
	
	private String descripcion;
	
	private TipoTarifaFinDeSemana(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public static String getMenu() {
		StringBuilder sb = new StringBuilder();
		for (TipoTarifaFinDeSemana opcion : TipoTarifaFinDeSemana.values()) {
			sb.append(opcion.ordinal());
			sb.append(".- ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static TipoTarifaFinDeSemana getOpcion(int posicion) {
		return values()[posicion];
	}

}
