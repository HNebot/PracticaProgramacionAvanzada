package interfaces;

import tarifas.Tarifa;
import enumeraciones.TipoTarifaFinDeSemana;

public interface IntFabricaTarifaFinDeSemana {
	public Tarifa getTarifa(Tarifa tarifa, TipoTarifaFinDeSemana tarifaFinSemana);

}
