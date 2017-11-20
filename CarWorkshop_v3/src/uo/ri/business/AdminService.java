package uo.ri.business;

import java.util.List;
import java.util.Map;

public interface AdminService {

	void newMecanic(String nombre, String apellidos);

	void deleteMechanic(Long idMecanico);

	void updateMechanic(Long id, String nombre, String apellidos);

	List<Map<String, Object>> findAllMechanics();
}
