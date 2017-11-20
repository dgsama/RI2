package uo.ri.util;

import java.util.List;
import java.util.Map;

import alb.util.console.Console;

public class Printer {

	public static Printer instance = null;

	public Printer() {
	}

	public static Printer getInstance() {
		if (instance == null) {
			instance = new Printer();
		}
		return instance;
	}

	/** MECHANIC **/

	public void printAddMechanic() {
		Console.println("Nuevo mecánico añadido");
	}

	public void printDeleteMechanic() {
		Console.println("Se ha eliminado el mecánico");
	}

	public void printUpdateMechanic() {
		Console.println("Mecánico actualizado");
	}

	public void printListMechanics(List<Map<String, Object>> mecanicos) {
		Console.println("Lista de mecánicos:\n");
		for (Map<String, Object> each : mecanicos) {
			Console.printf("\t%d %s %s\n", each.get("id"), each.get("nombre"), each.get("apellidos"));
		}
	}

	/** CASH **/
	public void mostrarFactura(Map<String, Object> factura) {

		Console.printf("Factura nº: %d\n", factura.get("numeroFactura"));
		Console.printf("\tFecha: %1$td/%1$tm/%1$tY\n", factura.get(" fechaFactura"));
		Console.printf("\tTotal: %.2f €\n", factura.get("totalFactura"));
		Console.printf("\tIva: %.1f %% \n", factura.get("iva"));
		Console.printf("\tTotal con IVA: %.2f €\n", factura.get("totalConIva"));
	}

	public boolean masAverias() {
		return Console.readString("¿Añadir más averias? (s/n) ").equalsIgnoreCase("s");
	}
}
