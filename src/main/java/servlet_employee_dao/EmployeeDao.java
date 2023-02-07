package servlet_employee_dao;

import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servlet_employee_dto.Employee;



public class EmployeeDao {
	 public EntityManager getEntityManger() {
		  EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		  EntityManager entityManager=entityManagerFactory.createEntityManager();
		  return entityManager;

	  }
	  public void saveEmployee(Employee employee) {
		  EntityManager entityManager=getEntityManger();
		  EntityTransaction entityTransaction=entityManager.getTransaction();
		  entityTransaction.begin();
		  entityManager.persist(employee);
		  entityTransaction.commit();
		  
	  }
	  public void updateEmployee(int id,Employee employee) {
		  EntityManager entityManager=getEntityManger();
		  EntityTransaction entityTransaction=entityManager.getTransaction();
		  Employee employee2=entityManager.find(Employee.class,id);
		  
		  if(employee2!=null) {
			  employee.setId(id);
			  entityTransaction.begin();
			  entityManager.merge(employee);
			  entityTransaction.commit();
		  }else {
			  System.out.println("id is not present");
		  }
		 
	  }
	  public Employee loginPerson(int id) {
		  EntityManager entityManager=getEntityManger();
		  String jpql=("select e from Employee e where e.id=?1");
		  Query query= entityManager.createQuery(jpql);
		  query.setParameter(1, id);
		  Employee employe=(Employee) query.getSingleResult();
		  
		  return employe;
		  
		  
	  }
}
