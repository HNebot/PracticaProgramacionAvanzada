package factorias;

import tarifas.Tarifa;
import tarifas.TarifaDomingo;
import tarifas.TarifaFinDeSemana;
import tarifas.TarifaSabado;
import tarifas.TarifaSabadoDomingo;
import tarifas.TarifaViernesSabado;
import enumeraciones.TipoTarifaFinDeSemana;
import interfaces.IntFabricaTarifaFinDeSemana;

public class FabricaParametrizadaTarifaFinDeSemana implements IntFabricaTarifaFinDeSemana{

	@Override
	public Tarifa getTarifa(Tarifa tarifa, TipoTarifaFinDeSemana tarifaFinSemana) {
		switch (tarifaFinSemana) {
		case TARIFA_SABADO:
			tarifa = new TarifaSabado(tarifa);
			break;
			
		case TARIFA_DOMINGO:
			tarifa = new TarifaDomingo(tarifa);
			break;
			
		case TARIFA_VIERNES_SABADO:
			tarifa = new TarifaViernesSabado(tarifa);
			break;
			
		case TARIFA_SABADO_DOMINGO:
			tarifa = new TarifaSabadoDomingo(tarifa);
			break;
			
		case TARIFA_FIN_DE_SEMANA:
			tarifa = new TarifaFinDeSemana(tarifa);
			break;
			
		case NADA:
			break;
			
		}
		return tarifa;
	}

}
