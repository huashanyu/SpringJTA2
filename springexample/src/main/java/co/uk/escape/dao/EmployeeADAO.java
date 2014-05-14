package co.uk.escape.dao;

import co.uk.escape.model.EmployeeA;

public interface EmployeeADAO {
	
		  void persistEmployee(EmployeeA employee);		
		  EmployeeA findEmployee(EmployeeA employee);		  
}
