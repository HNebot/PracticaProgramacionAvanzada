package interfaces;

import tarifas.Tarifa;
import enumeraciones.TipoTarifaHoraria;

public interface IntFabricaTarifaHoraria {
	public Tarifa getTarifa(Tarifa tarifa, TipoTarifaHoraria tarifaHoraria);

}
