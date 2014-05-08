package co.uk.escape.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import co.uk.escape.model.EmployeeA;

@Service
public class EmployeeADAOImpl implements EmployeeADAO {

	@PersistenceContext(unitName="PersistenceUnitA")
	private EntityManager entityManager;

	public void persistEmployee(EmployeeA employee) {
		entityManager.persist(employee);
	}


}