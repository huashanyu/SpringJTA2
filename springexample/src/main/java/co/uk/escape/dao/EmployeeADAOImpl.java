package co.uk.escape.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.uk.escape.model.EmployeeA;

@Transactional
@Service
public class EmployeeADAOImpl implements EmployeeADAO {

	@PersistenceContext(unitName="PersistenceUnitA")
	private EntityManager entityManager;

	public void persistEmployee(EmployeeA employee) {	
		


		entityManager.persist(employee);
		

	}

	@Override
	public EmployeeA findEmployee(EmployeeA employee) {
		return entityManager.find(EmployeeA.class, employee.getId());		
	}

}