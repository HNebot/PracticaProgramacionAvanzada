package objetos;

import java.util.Calendar;
import interfaces.IntFecha;

public abstract class  Fecha implements IntFecha {

	private Calendar fecha;
	@Override
	public Calendar getFecha() {
		return fecha;
	}

	@Override
	public void setFecha(Calendar calendar) {
		this.fecha = calendar;

	}

}
