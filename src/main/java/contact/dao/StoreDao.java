package contact.dao;

import java.util.ArrayList;
import java.util.Collection;
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
public class StoreDao implements Dao<Store, String> {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Store entity, Integer id) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public List<Store> read() {

		return sessionFactory.getCurrentSession().createQuery("from Store").list();
	}

	public void update(Store entity) {
		sessionFactory.getCurrentSession().update(entity);

	}

	public void delete(Integer id) {
		Store store = (Store) sessionFactory.getCurrentSession().load(Store.class, id);
		if (null != store) {
			sessionFactory.getCurrentSession().delete(store);
		}

	}

	public List<Store> getStoreFromId(Integer id) {
		List store = sessionFactory.getCurrentSession().createQuery("from Store where id=:id").setInteger("id", id)
				.list();
		return store;
		// return (List<Store>)
		// sessionFactory.getCurrentSession().createNamedQuery("from Store where
		// id=:id")
		// .setString(1, "id").list();
	}

	@Override
	public Collection getDepartmentsForStore(Integer idstore) {
		Store store = sessionFactory.getCurrentSession().load(Store.class, idstore);
		List<Department> departments = new ArrayList<Department>();
		Query query = sessionFactory.getCurrentSession().createQuery("from Department where store_idstore = :idstore")
				.setInteger("idstore", idstore);
		return departments = query.list();

	}

}
