package objetos;

public class Direccion 
{
	
	private String calle;
	private String portal;
	private String puerta;
	private String poblacion;
	private String provincia;
	private int codigoPostal;
	
	public Direccion(String calle, String portal, String puerta,
			String poblacion, String provincia, int codigoPostal) {
		super();
		this.calle = calle;
		this.portal = portal;
		this.puerta = puerta;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPortal() {
		return portal;
	}

	public void setPortal(String portal) {
		this.portal = portal;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	
	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", portal=" + portal + ", puerta="
				+ puerta + ", poblacion=" + poblacion + ", provincia="
				+ provincia + ", codigoPostal=" + codigoPostal + "]";
	}
	
	public String newToString()
	{
		return getCalle() + " Nº" + getPortal() + " " + getPuerta() + "\n" + 
				getPoblacion() + " ("+ getProvincia() +") " + getCodigoPostal();
	}
	
	
	
	
}
