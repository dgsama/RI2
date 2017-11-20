package uo.ri.business.impl;

import java.util.List;
import java.util.Map;

import uo.ri.business.CashService;
import uo.ri.business.common.BusinessException;
import uo.ri.business.impl.cash.CreateInvoiceFor;

public class CashServiceImpl implements CashService {

	@Override
	public Map<String, Object> createInvoiceFor(List<Long> idsAveria) throws BusinessException {
		return new CreateInvoiceFor(idsAveria).execute();
	}

}
