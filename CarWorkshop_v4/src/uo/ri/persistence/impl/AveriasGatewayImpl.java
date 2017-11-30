package uo.ri.persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import alb.util.jdbc.Jdbc;
import uo.ri.business.common.BusinessException;
import uo.ri.conf.Conf;
import uo.ri.persistence.AveriasGateway;

public class AveriasGatewayImpl implements AveriasGateway {

	Connection c;

	public void setConnection(Connection conn) {
		this.c = conn;
	}

	public void updateImporte(Map<String, Object> averia) throws SQLException {
		PreparedStatement pst = null;

		try {
			pst = c.prepareStatement(Conf.get("SQL_UPDATE_IMPORTE_AVERIA"));
			Double totalAveria = (Double) averia.get("totalAveria");
			Long idAveria = (Long) averia.get("idAveria");

			pst.setDouble(1, totalAveria);
			pst.setLong(2, idAveria);
			pst.executeUpdate();
		} finally {
			Jdbc.close(pst);
		}

	}

	@SuppressWarnings("unchecked")
	public void vincularFacturaAveria(Map<String, Object> datos) throws SQLException {
		PreparedStatement pst = null;
		try {
			pst = c.prepareStatement(Conf.get("SQL_VINCULAR_AVERIA_FACTURA"));
			List<Long> idsAveria = (List<Long>) datos.get("idsAveria");
			Long idFactura = (Long) datos.get("idFactura");

			for (Long idAveria : idsAveria) {
				pst.setLong(1, idFactura);
				pst.setLong(2, idAveria);

				pst.executeUpdate();
			}
		} finally {
			Jdbc.close(pst);
		}
	}

	public void verificarAveriasTermindas(List<Long> idsAveria) throws SQLException, BusinessException {
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = c.prepareStatement(Conf.get("SQL_VERIFICAR_ESTADO_AVERIA"));

			for (Long idAveria : idsAveria) {
				pst.setLong(1, idAveria);

				rs = pst.executeQuery();
				if (rs.next() == false) {
					throw new BusinessException("No existe la averia " + idAveria);
				}

				String status = rs.getString(1);
				if (!"TERMINADA".equalsIgnoreCase(status)) {
					throw new BusinessException("No está terminada la avería " + idAveria);
				}

				rs.close();
			}
		} finally {
			Jdbc.close(rs, pst);
		}
	}

	@SuppressWarnings("unchecked")

	public void updateEstadoAveria(Map<String, Object> averias) throws SQLException {
		PreparedStatement pst = null;

		try {
			pst = c.prepareStatement(Conf.get("SQL_ACTUALIZAR_ESTADO_AVERIA"));

			List<Long> idsAveria = (List<Long>) averias.get("idsAveria");
			String status = (String) averias.get("status");

			for (Long idAveria : idsAveria) {
				pst.setString(1, status);
				pst.setLong(2, idAveria);

				pst.executeUpdate();
			}
		} finally {
			Jdbc.close(pst);
		}

	}

	public double importeRepuestos(Long idAveria) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = c.prepareStatement(Conf.get("SQL_IMPORTE_REPUESTOS"));
			pst.setLong(1, idAveria);

			rs = pst.executeQuery();
			if (rs.next() == false) {
				return 0.0; // La averia puede no tener repuestos
			}

			return rs.getDouble(1);

		} finally {
			Jdbc.close(rs, pst);
		}
	}

	public double importeManoObra(Long idAveria) throws SQLException, BusinessException {
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = c.prepareStatement(Conf.get("SQL_IMPORTE_MANO_OBRA"));
			pst.setLong(1, idAveria);

			rs = pst.executeQuery();
			if (rs.next() == false) {
				throw new BusinessException("La averia no existe o no se puede facturar");
			}

			return rs.getDouble(1);

		} catch (BusinessException e) {
			throw e;
		} finally {
			Jdbc.close(rs, pst);
		}
	}

}
