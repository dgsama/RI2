package uo.ri.ui.admin.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.AdminService;
import uo.ri.business.common.BusinessException;
import uo.ri.business.impl.AdminServiceImpl;
import uo.ri.util.Printer;

public class AddMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {

		// Pedir datos
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");

		AdminService aS = new AdminServiceImpl();
		aS.newMecanic(nombre, apellidos);

		// Mostrar resultado
		Printer.getInstance().printAddMechanic();
	}

}