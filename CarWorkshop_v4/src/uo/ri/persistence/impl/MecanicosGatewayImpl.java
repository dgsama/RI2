package uo.ri.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alb.util.jdbc.Jdbc;
import uo.ri.conf.Conf;
import uo.ri.persistence.MecanicosGateway;

public class MecanicosGatewayImpl implements MecanicosGateway {

	private Connection c;

	public void setConnection(Connection c) {
		this.c = c;

	}

	public List<Map<String, Object>> findAllMechanic() throws SQLException {

		List<Map<String, Object>> lista = new ArrayList<Map<String, Object>>();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = c.prepareStatement(Conf.get("SQL_FIND_ALL_MECHANIC"));
			rs = pst.executeQuery();
			while (rs.next()) {
				Map<String, Object> m = new HashMap<String, Object>();

				m.put("id", rs.getLong(1));
				m.put("nombre", rs.getString(2));
				m.put("apellidos", rs.getString(3));
				lista.add(m);

			}
		} catch (SQLException e) {
			throw e;
		} finally {
			Jdbc.close(rs, pst);
		}
		return lista;
	}

	public void addMechanic(String name, String surname) throws SQLException {
		PreparedStatement pst = null;
		try {
			pst = c.prepareStatement(Conf.get("SQL_INSERT_MECHANIC"));
			pst.setString(1, name);
			pst.setString(2, surname);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			Jdbc.close(pst);
		}
	}

	public void deleteMechanic(Long id) throws SQLException {
		PreparedStatement pst = null;
		try {
			pst = c.prepareStatement(Conf.get("SQL_DELETE_MECHANIC"));
			pst.setLong(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			Jdbc.close(pst);
		}
	}

	public void update(Long id, String name, String surname) throws SQLException {
		PreparedStatement pst = null;
		try {
			pst = c.prepareStatement(Conf.get("SQL_UPDATE_MECHANIC"));
			pst.setString(1, name);
			pst.setString(2, surname);
			pst.setLong(3, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} finally {
			Jdbc.close(pst);
		}
	}

}
