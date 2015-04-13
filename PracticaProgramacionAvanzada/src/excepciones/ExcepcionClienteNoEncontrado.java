package excepciones;

public class ExcepcionClienteNoEncontrado extends Exception{
	
	private static final long serialVersionUID = 7488621735123255907L;

	public ExcepcionClienteNoEncontrado() {
		super("El cliente no existe");
	}
	
	public ExcepcionClienteNoEncontrado(String mensaje) {
		super(mensaje);
	}

}
