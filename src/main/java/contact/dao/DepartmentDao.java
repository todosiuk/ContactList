package contact.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import contact.entity.Department;
import contact.entity.Store;

@Repository
public class DepartmentDao implements Dao<Department, String> {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Department entity) {
		
		sessionFactory.getCurrentSession().save(entity);

	}

	public List<Department> read() {

		return sessionFactory.getCurrentSession().createQuery("from department").list();
	}

	public void update(Department entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	public void delete(Integer id) {
		Department department = sessionFactory.getCurrentSession().load(Department.class, id);
		if (null != department) {
			sessionFactory.getCurrentSession().delete(department);
		}

	}

	public Query<Department> getDepartmentFromId(Integer id) {
		return sessionFactory.getCurrentSession().createQuery("select * from department where id = ?");
	}

	@Override
	public Collection getDepartmentsForStore(Store store) {
		// TODO Auto-generated method stub
		return null;
	}

}
