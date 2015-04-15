package factorias;

import tarifas.Tarifa;
import tarifas.TarifaBase;
import tarifas.TarifaDomingo;
import tarifas.TarifaFinDeSemana;
import tarifas.TarifaManyana;
import tarifas.TarifaSabado;
import tarifas.TarifaSabadoDomingo;
import tarifas.TarifaTarde;
import tarifas.TarifaViernesSabado;
import enumeraciones.TipoTarifaFinDeSemana;
import enumeraciones.TipoTarifaHoraria;
import interfaces.IntFabricaTarifa;

public class FabricaTarifas implements IntFabricaTarifa{

	@Override
	public Tarifa getTarifa(TipoTarifaHoraria tarifaHoraria,
			TipoTarifaFinDeSemana tarifaFinSemana) {
		Tarifa tarifa = new TarifaBase();
		tarifa = this.getTarifaPersonalizadaHoraria(tarifa, tarifaHoraria);
		tarifa = this.getTarifaPersonalizadaFinDeSemana(tarifa, tarifaFinSemana);
		return tarifa;
	}
	
	private Tarifa getTarifaPersonalizadaHoraria(Tarifa tarifa, TipoTarifaHoraria tarifaHoraria)
	{
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
	
	private Tarifa getTarifaPersonalizadaFinDeSemana(Tarifa tarifa, TipoTarifaFinDeSemana tarifaFinSemana)
	{
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
