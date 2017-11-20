package uo.ri.ui.admin.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.admin.AddMechanic;
import uo.ri.common.BusinessException;
import uo.ri.util.Printer;

public class AddMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {

		// Pedir datos
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");

		new AddMechanic(nombre, apellidos).execute();

		// Mostrar resultado
		Printer.getInstance().printAddMechanic();
	}

}
