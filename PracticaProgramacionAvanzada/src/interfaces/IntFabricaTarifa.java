package interfaces;

import tarifas.Tarifa;
import enumeraciones.TipoTarifaFinDeSemana;
import enumeraciones.TipoTarifaHoraria;

public interface IntFabricaTarifa 
{
	public Tarifa getTarifa(TipoTarifaHoraria tarifaHoraria, TipoTarifaFinDeSemana tarifaFinSemana);

}
