package uo.ri.ui.admin.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.AdminService;
import uo.ri.business.common.BusinessException;
import uo.ri.business.impl.AdminServiceImpl;
import uo.ri.util.Printer;

public class DeleteMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {
		Long idMecanico = Console.readLong("Id de mecánico");

		AdminService aS = new AdminServiceImpl();
		aS.deleteMechanic(idMecanico);

		Printer.getInstance().printDeleteMechanic();

	}

}
