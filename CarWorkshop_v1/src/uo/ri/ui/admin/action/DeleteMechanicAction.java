package uo.ri.ui.admin.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.admin.DeleteMechanic;
import uo.ri.common.BusinessException;
import uo.ri.util.Printer;

public class DeleteMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long idMecanico = Console.readLong("Id de mecánico");

		new DeleteMechanic(idMecanico).execute();

		Printer.getInstance().printDeleteMechanic();

	}

}
