package uo.ri.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import uo.ri.business.common.BusinessException;

public interface AveriasGateway {

	void setConnection(Connection con);

	void updateImporte(Map<String, Object> averia) throws SQLException;

	void vincularFacturaAveria(Map<String, Object> datos) throws SQLException;

	void verificarAveriasTermindas(List<Long> idsAveria) throws SQLException, BusinessException;

	void updateEstadoAveria(Map<String, Object> averias) throws SQLException;

	double importeRepuestos(Long idAveria) throws SQLException;

	double importeManoObra(Long idAveria) throws SQLException, BusinessException;

}
