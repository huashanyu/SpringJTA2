package co.uk.escape.service;

import co.uk.escape.model.EmployeeA;
import co.uk.escape.model.EmployeeB;

public interface EmployeeService {

	void persistEmployees(EmployeeA employeeA, EmployeeB employeeB) throws Exception;
	
}
