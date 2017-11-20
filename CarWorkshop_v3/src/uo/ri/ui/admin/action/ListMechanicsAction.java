package uo.ri.ui.admin.action;

import java.util.List;
import java.util.Map;

import alb.util.menu.Action;
import uo.ri.business.common.BusinessException;
import uo.ri.conf.ServicesFactory;
import uo.ri.util.Printer;

public class ListMechanicsAction implements Action {

	@Override
	public void execute() throws BusinessException {

		ServicesFactory sF = new ServicesFactory();

		List<Map<String, Object>> mecanicos = sF.getAdminService().findAllMechanics();

		Printer.getInstance().printListMechanics(mecanicos);

	}
}
