package uo.ri.ui.cash.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.CashService;
import uo.ri.business.common.BusinessException;
import uo.ri.business.impl.CashServiceImpl;
import uo.ri.util.Printer;

public class FacturarReparacionesAction implements Action {

	@Override
	public void execute() throws BusinessException {
		List<Long> idsAveria = new ArrayList<Long>();

		// pedir las averias a incluir en la factura
		do {
			Long id = Console.readLong("ID de averia");
			idsAveria.add(id);
		} while (masAverias());

		CashService cS = new CashServiceImpl();
		Map<String, Object> factura = cS.createInvoiceFor(idsAveria);
		Printer.getInstance().mostrarFactura(factura);
	}

	private boolean masAverias() {
		return Printer.getInstance().masAverias();
	}
}
