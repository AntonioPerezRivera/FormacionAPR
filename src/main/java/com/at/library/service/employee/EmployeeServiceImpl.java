package com.at.library.service.employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.at.library.dao.EmployeeDao;
import com.at.library.dto.EmployeeDTO;
import com.at.library.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public List<EmployeeDTO> findAll() {
		final Iterable<Employee> findAll = employeeDao.findAll();
		final Iterator<Employee> iterator = findAll.iterator();
		final List<EmployeeDTO> res = new ArrayList<>();
		while (iterator.hasNext()) {
			final Employee b = iterator.next();
			final EmployeeDTO bDTO = transform(b);
			res.add(bDTO);
		}
		return res;
	}

	@Override
	public EmployeeDTO transform(Employee employee) {
		return dozer.map(employee, EmployeeDTO.class);
	}

	@Override
	public Employee transform(EmployeeDTO employee) {
		return dozer.map(employee, Employee.class);
	}

	@Override
	public EmployeeDTO create(EmployeeDTO employee) {
		Employee e = transform(employee);
		return transform(employeeDao.save(e));
	}

	@Override
	public EmployeeDTO getById(Integer id) {
		Employee e = employeeDao.findOne(id);
		return transform(e);
	}

	@Override
	public void update(EmployeeDTO employee) {
		Employee e = transform(employee);
		employeeDao.save(e);
	}

	@Override
	public void delete(Integer id) {
		employeeDao.delete(id);
	}

}
