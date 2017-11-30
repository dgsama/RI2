package uo.ri.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface FacturasGateway {

	void setConnection(Connection connection);

	long save(Map<String, Object> datos) throws SQLException;

	Map<String, Object> findByNumber(long numeroFactura) throws SQLException;

	Long getLastInvoiceNumber() throws SQLException;

	Map<String, Object> findById(Long id);

	List<Map<String, Object>> findAll();

	void delete(Long id);

	void update(Map<String, Object> factura);

}
