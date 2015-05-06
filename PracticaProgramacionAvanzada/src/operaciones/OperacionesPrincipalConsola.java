package operaciones;

import lectura.LecturaDatosConsola;
import menus.MenuPrincipalConsola;
import controlador.Controlador;
import excepciones.ExcepcionClienteNoEncontrado;
import interfaces.IntOperacionesPrincipal;



public class OperacionesPrincipalConsola implements IntOperacionesPrincipal{
	
	private Controlador controlador;
	private LecturaDatosConsola lecturaDatos;
	
	public OperacionesPrincipalConsola() {
		this.lecturaDatos = new LecturaDatosConsola();
	}
	@Override
	public void menuPincipal() throws Exception {
			System.out.println(MenuPrincipalConsola.getMenu());
			MenuPrincipalConsola op = MenuPrincipalConsola.getOpcion(this.lecturaDatos.lecturaEnteros());
			this.controlador.ejecutaOpcionMenuPrincipal(op);
	}
	@Override
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}



}
