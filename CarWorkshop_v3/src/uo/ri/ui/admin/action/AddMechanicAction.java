package uo.ri.ui.admin.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.common.BusinessException;
import uo.ri.conf.ServicesFactory;
import uo.ri.util.Printer;

public class AddMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {

		// Pedir datos
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");

		ServicesFactory sF = new ServicesFactory();
		sF.getAdminService().newMecanic(nombre, apellidos);

		// Mostrar resultado
		Printer.getInstance().printAddMechanic();
	}

}
