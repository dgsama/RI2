package uo.ri.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alb.util.jdbc.Jdbc;
import uo.ri.conf.Conf;
import uo.ri.persistence.FacturasGateway;

public class FacturasGatewayImpl implements FacturasGateway {
	Connection c;

	@Override
	public void setConnection(Connection connection) {
		this.c = connection;
	}

	public long save(Map<String, Object> datos) throws SQLException {
		PreparedStatement pst = null;

		try {
			pst = c.prepareStatement(Conf.get("SQL_INSERTAR_FACTURA"));
			pst.setLong(1, (Long) datos.get("numeroFactura"));
			pst.setDate(2, new java.sql.Date(((Date) datos.get("fechaFactura")).getTime()));
			pst.setDouble(3, (Double) datos.get("iva"));
			pst.setDouble(4, (Double) datos.get("importe"));
			pst.setString(5, "SIN_ABONAR");

			pst.executeUpdate();

			return (Long) datos.get("numeroFactura");
			
		} finally {
			Jdbc.close(pst);
		}
	}

	public  Map<String, Object>  findByNumber(long numeroFactura) throws SQLException {
		Map<String, Object> factura = new HashMap<String, Object>();
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = c.prepareStatement(Conf.get("SQL_RECUPERAR_CLAVE_GENERADA"));
			pst.setLong(1, numeroFactura);
			rs = pst.executeQuery();
			rs.next();

			factura.put("idFactura", rs.getLong(1));
			factura.put("fechaFactura", rs.getDate(2));
			factura.put("importe", rs.getDouble(3));
			factura.put("iva", rs.getDouble(4));
			factura.put("numero", rs.getLong(5));
			factura.put("status", rs.getString(6));
			
			return factura;
			
		} finally {
			Jdbc.close(rs, pst);
		}
	}

	public Long getLastInvoiceNumber() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = c.prepareStatement(Conf.get("SQL_ULTIMO_NUMERO_FACTURA"));
			rs = pst.executeQuery();
			
			if (rs.next()) {
				return rs.getLong(1); // +1, el siguiente
			} else {  // todavía no hay ninguna
				return 1L;
			}
		} finally {
			Jdbc.close(rs, pst);
		}
	}

	public Map<String, Object> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Map<String, Object>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void update(Map<String, Object> factura) {
		// TODO Auto-generated method stub
		
	}

}
