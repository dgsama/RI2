package uo.ri.business.impl.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alb.util.jdbc.Jdbc;

public class ListMechanic {
	private static String SQL = "select id, nombre, apellidos from TMecanicos";

	public List<Map<String, Object>> execute() {
		List<Map<String, Object>> result = new ArrayList<>();
		Map<String, Object> mecanico = null;

		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			c = Jdbc.getConnection();

			pst = c.prepareStatement(SQL);

			rs = pst.executeQuery();
			while (rs.next()) {
				mecanico = new HashMap<>();
				mecanico.put("id", rs.getLong(1));
				mecanico.put("nombre", rs.getString(2));
				mecanico.put("apellidos", rs.getString(3));
				result.add(mecanico);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			Jdbc.close(rs, pst, c);
		}

		return result;
	}

}
