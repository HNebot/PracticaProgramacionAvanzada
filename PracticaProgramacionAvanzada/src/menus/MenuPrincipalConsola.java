package menus;

import interfaces.IntMenu;

public enum MenuPrincipalConsola {
	SALIR("Salir del programa"),
	CLIENTES("Menu clientes"),
	FACTURAS("Menu facturas"),
	LLAMADAS("Menu llamadas");

	private String descripcion;

	private MenuPrincipalConsola(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public static String getMenu() {
		StringBuilder sb = new StringBuilder();
		for (MenuPrincipalConsola opcion : MenuPrincipalConsola.values()) {
			sb.append(opcion.ordinal());
			sb.append(".- ");
			sb.append(opcion.getDescripcion());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static MenuPrincipalConsola getOpcion(int posicion) {
		return values()[posicion];
	}
		
}

