package contact.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import contact.entity.Department;
import contact.entity.Store;

@Component
@Transactional
public class DepartmentDaoImpl implements DepartmentDao<Department, String> {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Integer storeId, Department department) throws DaoException {
		try {
			Store store = (Store) sessionFactory.getCurrentSession().get(Store.class, storeId);
			department.setStore(store);
			sessionFactory.getCurrentSession().save(department);
		} catch (Exception e) {
			throw new DaoException("exception in DepartmentDaoImpl create", e);
		}
	}

	public List<Department> read() throws DaoException {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Department").getResultList();
		} catch (Exception e) {
			throw new DaoException("exception in DepartmentDaoImpl read", e);
		}
	}

	public void update(Department entity) throws DaoException {
		try {
			Department department = sessionFactory.getCurrentSession().get(Department.class, entity.getId());
			department.setEmail(entity.getEmail());
			department.setNameDepartment(entity.getNameDepartment());
			department.setPhone(entity.getPhone());
			department.setPost(entity.getPost());
			sessionFactory.getCurrentSession().saveOrUpdate(department);
		} catch (Exception e) {
			throw new DaoException("exception in DepartmentDaoImpl update", e);
		}
	}

	public void delete(Integer id) throws DaoException {
		try {
			Department department = this.getDepartmentFromId(id);
			sessionFactory.getCurrentSession().delete(department);
		} catch (Exception e) {
			throw new DaoException("exception in DepartmentDaoImpl delete", e);
		}
	}

	public Department getDepartmentFromId(Integer id) throws DaoException {
		try {
			Department department = (Department) sessionFactory.getCurrentSession()
					.createQuery("from Department d where d.id = :id").setParameter("id", id).getSingleResult();
			return department;
		} catch (Exception e) {
			throw new DaoException("exception in DepartmentDaoImpl getDepartmentFromId", e);
		}
	}
}
