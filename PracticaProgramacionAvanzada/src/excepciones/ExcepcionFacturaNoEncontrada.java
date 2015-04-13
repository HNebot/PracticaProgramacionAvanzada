package excepciones;

public class ExcepcionFacturaNoEncontrada extends Exception
{
	private static final long serialVersionUID = -3720793989624321555L;

	public ExcepcionFacturaNoEncontrada() {
		super("Factura no encontrada");
	}
	
	public ExcepcionFacturaNoEncontrada(String mensaje) {
		super(mensaje);
	}

}
