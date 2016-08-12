package contact.dao;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	public void create(Department entity) {

		sessionFactory.getCurrentSession().save(entity);

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

	public Query<Department> getDepartmentFromId(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("select * from Department where id = ?");
	}

	@Override
	public Collection getDepartmentsForStore(Store store) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
