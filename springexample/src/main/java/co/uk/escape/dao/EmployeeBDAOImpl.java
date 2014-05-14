package co.uk.escape.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import co.uk.escape.model.EmployeeB;

@Service
public class EmployeeBDAOImpl implements EmployeeBDAO {

//	@PersistenceContext(unitName="PersistenceUnitB")
	private EntityManager entityManager;

	public void persistEmployee(EmployeeB employee) throws Exception {
		entityManager.persist(employee);
		//throw new Exception();
	}
}