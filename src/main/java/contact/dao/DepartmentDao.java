package contact.dao;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import contact.entity.Department;
import contact.entity.Store;

@Component
@Transactional
public class DepartmentDao implements Dao<Department, String> {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Department department, Integer id) {
		Store store = sessionFactory.getCurrentSession().load(Store.class, id);
		department.setStore(store);
		sessionFactory.getCurrentSession().save(department);

	}

	public List<Department> read() {

		return sessionFactory.getCurrentSession().createQuery("from Department").list();
	}

	public void update(Department entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	public void delete(Integer id) {
		Department department = (Department) sessionFactory.getCurrentSession().load(Department.class, id);
		if (null != department) {
			sessionFactory.getCurrentSession().delete(department);
		}

	}

	public List<Department> getDepartmentFromId(Integer id) {
		List department = sessionFactory.getCurrentSession().createQuery("from Department where id = :id")
				.setInteger("id", id).list();
		return department;
	}

	@Override
	public Collection getDepartmentsForStore(Store store) {
		// TODO Auto-generated method stub
		return null;
	}

}
