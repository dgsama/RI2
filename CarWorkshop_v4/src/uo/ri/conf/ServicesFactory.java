package uo.ri.conf;

import uo.ri.business.AdminService;
import uo.ri.business.CashService;
import uo.ri.business.impl.AdminServiceImpl;
import uo.ri.business.impl.CashServiceImpl;

public class ServicesFactory {

	public ServicesFactory() {
	}

	public AdminService getAdminService() {
		return new AdminServiceImpl();
	}

	public CashService getCashService() {
		return new CashServiceImpl();
	}

}
