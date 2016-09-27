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

	public void create(Integer storeId, Department department) {
		Store store = (Store) sessionFactory.getCurrentSession().get(Store.class, storeId);
		department.setStore(store);
		sessionFactory.getCurrentSession().save(department);
	}

	public List<Department> read() {
		return sessionFactory.getCurrentSession().createQuery("from Department").getResultList();
	}

	public void update(Department entity) {
		Department department = sessionFactory.getCurrentSession().get(Department.class, entity.getId());
		department.setEmail(entity.getEmail());
		department.setNameDepartment(entity.getNameDepartment());
		department.setPhone(entity.getPhone());
		department.setPost(entity.getPost());
		sessionFactory.getCurrentSession().saveOrUpdate(department);
	}

	public void delete(Integer id) {
		Department department = this.getDepartmentFromId(id);
		sessionFactory.getCurrentSession().delete(department);
	}

	public Department getDepartmentFromId(Integer id) {
		Department department = (Department) sessionFactory.getCurrentSession()
				.createQuery("from Department d where d.id = :id").setParameter("id", id).getSingleResult();
		return department;
	}
}
