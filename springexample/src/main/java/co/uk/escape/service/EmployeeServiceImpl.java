package co.uk.escape.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.uk.escape.dao.EmployeeADAO;
import co.uk.escape.dao.EmployeeBDAO;
import co.uk.escape.model.EmployeeA;
import co.uk.escape.model.EmployeeB;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeADAO employeeADAO;
	
	@Autowired
	EmployeeBDAO employeeBDAO;
	
	@Transactional(rollbackFor=Exception.class)
	public void persistEmployees(EmployeeA employeeA, EmployeeB employeeB) throws Exception {
		System.out.println("Persist A");
		employeeADAO.persistEmployee(employeeA);
		System.out.println("Persist A OK - persist B");
		employeeBDAO.persistEmployee(employeeB);
		System.out.println("Persist B okk");
	}

}
