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

	public void create(Store entity) throws DaoException {
		try {
			sessionFactory.getCurrentSession().save(entity);
		} catch (Exception e) {
			throw new DaoException("exception in StoreDaoImpl create", e);
		}
	}

	public List<Store> read() throws DaoException {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Store").getResultList();
		} catch (Exception e) {
			throw new DaoException("exception in StoreDaoImpl read", e);
		}
	}

	public void update(Store entity) throws DaoException {
		try {
			sessionFactory.getCurrentSession().update(entity);
		} catch (Exception e) {
			throw new DaoException("exception in StoreDaoImpl update", e);
		}
	}

	public void delete(Integer id) throws DaoException {
		try {
			Store store = this.getStoreFromId(id);
			if (null != store) {
				sessionFactory.getCurrentSession().delete(store);
			}
		} catch (Exception e) {
			throw new DaoException("exception in StoreDaoImpl delete", e);
		}

	}

	public Store getStoreFromId(Integer id) throws DaoException {
		try {
			Store store = (Store) sessionFactory.getCurrentSession().createQuery("from Store  where id=:id")
					.setParameter("id", id).getSingleResult();
			return store;
		} catch (Exception e) {
			throw new DaoException("exception in StoreDaoImpl getStoreFromId", e);
		}
	}

	@Override
	public List<Department> getDepartmentsForStore(Integer idstore) throws DaoException {
		try {
			Store store = sessionFactory.getCurrentSession().load(Store.class, idstore);
			List<Department> departments = new ArrayList<Department>();
			Query query = sessionFactory.getCurrentSession()
					.createQuery("from Department  where store_idstore = :idstore").setParameter("idstore", idstore);
			departments = query.getResultList();
			Collections.sort(departments, new Comparator<Department>() {
				public int compare(Department d1, Department d2) {
					return d1.getNameDepartment().compareTo(d2.getNameDepartment());
				}
			});
			return departments;
		} catch (Exception e) {
			throw new DaoException("exception in StoreDaoImpl getDepartmentsForStore ", e);
		}

	}
}
