package contact.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import contact.entity.Department;

@Repository
public class DepartmentDao implements Dao<Department, String> {

	@Autowired
	private SessionFactory sessionFactory;

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
		return sessionFactory.getCurrentSession().createQuery("select * fom department where id = ?");
	}

}
