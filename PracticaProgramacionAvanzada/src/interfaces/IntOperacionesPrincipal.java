package interfaces;

import controlador.Controlador;
import excepciones.ExcepcionClienteNoEncontrado;
import menus.MenuPrincipalConsola;

public interface IntOperacionesPrincipal 
{
	public void menuPincipal() throws Exception;
	public void setControlador(Controlador controlador);

}
