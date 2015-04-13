package excepciones;

public class ExcepcionLlamadaNoEncontrada extends Exception
{
	private static final long serialVersionUID = -1144124953104982630L;

	public ExcepcionLlamadaNoEncontrada() {
		super("Llamada no encontrada");
	}
	
	public ExcepcionLlamadaNoEncontrada(String mensaje) {
		super(mensaje);
	}
	

}
