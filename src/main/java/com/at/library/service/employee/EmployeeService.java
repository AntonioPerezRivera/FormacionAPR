package com.at.library.service.employee;

import java.util.List;

import com.at.library.dto.EmployeeDTO;
import com.at.library.model.Employee;

public interface EmployeeService {

	/**
	 * Realiza la busqueda de todos los empleados existentes
	 * 
	 * @return listado de empleados
	 */
	List<EmployeeDTO> findAll();

	/**
	 * Transfrma un empleado en un empleadoDTO
	 * 
	 * @param book
	 * @return
	 */
	EmployeeDTO transform(Employee employee);

	/**
	 * Transforma un empleadoDTO en un empleado
	 * 
	 * @param book
	 * @return
	 */
	Employee transform(EmployeeDTO employee);

}
