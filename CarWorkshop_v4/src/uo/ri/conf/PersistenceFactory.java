package uo.ri.conf;

import uo.ri.persistence.AveriasGateway;
import uo.ri.persistence.CargosGateway;
import uo.ri.persistence.FacturasGateway;
import uo.ri.persistence.MecanicosGateway;
import uo.ri.persistence.MediosPagoGateway;
import uo.ri.persistence.impl.AveriasGatewayImpl;
import uo.ri.persistence.impl.CargosGatewayImpl;
import uo.ri.persistence.impl.FacturasGatewayImpl;
import uo.ri.persistence.impl.MecanicosGatewayImpl;
import uo.ri.persistence.impl.MedioPagoGatewayImpl;

public class PersistenceFactory {

	public PersistenceFactory() {
	}

	public static AveriasGateway getAveriasGateway() {
		return new AveriasGatewayImpl();
	}

	public static CargosGateway getCargosGateway() {
		return new CargosGatewayImpl();
	}

	public static FacturasGateway getFacturasGateway() {
		return new FacturasGatewayImpl();
	}

	public static MecanicosGateway getMecanicosGateway() {
		return new MecanicosGatewayImpl();
	}

	public static MediosPagoGateway getMedioPagoGateway() {
		return new MedioPagoGatewayImpl();
	}

}
