package co.uk.escape.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
	
	//@Transactional(propagation=Propagation.REQUIRES_NEW)
	//@Transactional(rollbackFor=Exception.class)
	public void persistEmployees(EmployeeA employeeA, EmployeeB employeeB) throws Exception {
		System.out.println("Persist A");
		employeeADAO.persistEmployee(employeeA);
		System.out.println("Persist A OK - persist B");
//		employeeBDAO.persistEmployee(employeeB);
//		System.out.println("Persist B ok");
	}
	
	public EmployeeA findEmployees(EmployeeA employeeA) throws Exception {
		System.out.println("Finding employee A");
		EmployeeA eA = employeeADAO.findEmployee(employeeA);
		System.out.println("Found Employee A." + eA.getName() + " age:" + eA.getAge());
		return eA;

	}

}
