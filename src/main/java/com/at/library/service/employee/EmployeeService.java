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
	 * @param employee
	 * @return
	 */
	EmployeeDTO transform(Employee employee);

	/**
	 * Transforma un empleadoDTO en un empleado
	 * 
	 * @param employee
	 * @return
	 */
	Employee transform(EmployeeDTO employee);

	/**
	 * Metodo que permite la creacion de un empleado
	 * @param employee
	 * @return
	 */
	EmployeeDTO create(EmployeeDTO employee);

	/**
	 * Metodo que permite devolver un empleado dado un id concreto
	 * @param id
	 * @return
	 */
	Employee getById(Integer id);

	/**
	 * Metodo que permite actualizar la informacion de un empleado concreto
	 * @param employee
	 */
	void update(EmployeeDTO employee);

	/**
	 * Metodo que permite la eliminacion de un usuario concreto
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * Metodo que permite devolver un empleadoDTO dado un id
	 * @param id
	 * @return
	 */
	EmployeeDTO getByIdDTO(Integer id);

}
