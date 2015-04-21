package factorias;

import tarifas.Tarifa;
import tarifas.TarifaManyana;
import tarifas.TarifaTarde;
import enumeraciones.TipoTarifaHoraria;
import interfaces.IntFabricaTarifaHoraria;

public class FabricaParametrizadaTarifaHoraria implements IntFabricaTarifaHoraria{

	@Override
	public Tarifa getTarifa(Tarifa tarifa, TipoTarifaHoraria tarifaHoraria) {
		switch (tarifaHoraria) {
		case TARIFA_MANYANA:
			tarifa = new TarifaManyana(tarifa);
			break;
			
		case TARIFA_TARDE:
			tarifa = new TarifaTarde(tarifa);
			break;
			
		case TARIFA_NOCHE:
			tarifa = new TarifaTarde(tarifa);
			break;
			
		case NADA:
			break;
			
		}
		return tarifa;
	}

}
