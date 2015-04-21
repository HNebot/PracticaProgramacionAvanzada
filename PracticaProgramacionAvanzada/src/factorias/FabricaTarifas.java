package factorias;

import tarifas.Tarifa;
import tarifas.TarifaBase;
import enumeraciones.TipoTarifaFinDeSemana;
import enumeraciones.TipoTarifaHoraria;
import interfaces.IntFabricaTarifa;

public class FabricaTarifas implements IntFabricaTarifa{

	@Override
	public Tarifa getTarifa(TipoTarifaHoraria tarifaHoraria,TipoTarifaFinDeSemana tarifaFinSemana) {
		FabricaParametrizadaTarifaHoraria fabricaTarifaHoraria = new FabricaParametrizadaTarifaHoraria();
		FabricaParametrizadaTarifaFinDeSemana fabricaTarifaFinDeSemana = new FabricaParametrizadaTarifaFinDeSemana();
		Tarifa tarifa = new TarifaBase();
		tarifa = fabricaTarifaHoraria.getTarifa(tarifa, tarifaHoraria);
		tarifa = fabricaTarifaFinDeSemana.getTarifa(tarifa, tarifaFinSemana);
		return tarifa;
	}
	

}
