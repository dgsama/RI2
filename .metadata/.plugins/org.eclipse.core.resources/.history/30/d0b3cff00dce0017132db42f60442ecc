package uo.ri.ui.admin.action;

import java.util.List;
import java.util.Map;

import alb.util.menu.Action;
import uo.ri.business.AdminService;
import uo.ri.business.common.BusinessException;
import uo.ri.business.impl.AdminServiceImpl;
import uo.ri.util.Printer;

public class ListMechanicsAction implements Action {

	@Override
	public void execute() throws BusinessException {

		AdminService aS = new AdminServiceImpl();

		List<Map<String, Object>> mecanicos = aS.findAllMechanics();

		Printer.getInstance().printListMechanics(mecanicos);

	}
}
