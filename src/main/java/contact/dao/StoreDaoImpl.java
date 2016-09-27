package contact.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Resource;

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
public class StoreDaoImpl implements StoreDao<Store, String> {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Store entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public List<Store> read() {
		return sessionFactory.getCurrentSession().createQuery("from Store").getResultList();
	}

	public void update(Store entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	public void delete(Integer id) {
		Store store = this.getStoreFromId(id);
		if (null != store) {
			sessionFactory.getCurrentSession().delete(store);
		}
	}

	public Store getStoreFromId(Integer id) {
		Store store = (Store) sessionFactory.getCurrentSession().createQuery("from Store  where id=:id")
				.setParameter("id", id).getSingleResult();
		return store;
	}

	@Override
	public List<Department> getDepartmentsForStore(Integer idstore) {
		Store store = sessionFactory.getCurrentSession().load(Store.class, idstore);
		List<Department> departments = new ArrayList<Department>();
		Query query = sessionFactory.getCurrentSession().createQuery("from Department  where store_idstore = :idstore")
				.setParameter("idstore", idstore);
		departments = query.getResultList();
		Collections.sort(departments, new Comparator<Department>() {
			public int compare(Department d1, Department d2) {
				return d1.getNameDepartment().compareTo(d2.getNameDepartment());
			}
		});
		return departments;

	}
}
