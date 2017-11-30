package uo.ri.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface MecanicosGateway {

	void setConnection(Connection c);

	List<Map<String, Object>> findAllMechanic() throws SQLException;

	void addMechanic(String name, String surname) throws SQLException;

	void deleteMechanic(Long id) throws SQLException;

	void update(Long id, String name, String surname) throws SQLException;
}
