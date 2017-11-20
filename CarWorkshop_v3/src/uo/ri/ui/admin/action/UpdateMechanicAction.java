package uo.ri.ui.admin.action;

import alb.util.console.Console;
import alb.util.menu.Action;
import uo.ri.business.common.BusinessException;
import uo.ri.conf.ServicesFactory;
import uo.ri.util.Printer;

public class UpdateMechanicAction implements Action {

	@Override
	public void execute() throws BusinessException {

		// Pedir datos
		Long id = Console.readLong("Id del mecánico");
		String nombre = Console.readString("Nombre");
		String apellidos = Console.readString("Apellidos");

		// Procesar
		ServicesFactory sF = new ServicesFactory();
		sF.getAdminService().updateMechanic(id, nombre, apellidos);

		// Mostrar resultado
		Printer.getInstance().printUpdateMechanic();
	}

}
