package uo.ri.ui.admin.action;

import java.util.List;
import java.util.Map;

import alb.util.menu.Action;
import uo.ri.business.admin.ListMechanic;
import uo.ri.common.BusinessException;
import uo.ri.util.Printer;

public class ListMechanicsAction implements Action {

	@Override
	public void execute() throws BusinessException {

		List<Map<String, Object>> mecanicos = new ListMechanic().execute();

		Printer.getInstance().printListMechanics(mecanicos);

	}
}
