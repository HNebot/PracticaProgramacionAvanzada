package enumeraciones;

public enum TipoTarifaFinDeSemana {
	TARIFA_SABADO("Tarifa Sabados Gratis: "
			+ "LLame todos los Sábados gratis durante todo el dia"),
	TARIFA_DOMINGO("Tarifa Domingos Gratis: "
			+ "LLame todos los Domingos gratis durante todo el dia"),
	TARIFA_VIERNES_SABADO("Tarifa Viernes y Sabados: "
			+ "Las llamdas a 0.09 todos los Viernes y Sabados durante todo el dia"),
	TARIFA_SABADO_DOMINGO("Tarifa Sabados y Domingos: "
					+ "Las llamdas a 0.09 todos los Sabados y Domingos durante todo el dia"),
	TARIFA_FIN_DE_SEMANA("Tarifa Fin De Semana: "
							+ "Las llamdas a 0.05 de Viernes a Domingo durante todo el dia"),
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
