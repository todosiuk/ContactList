package contact.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import contact.entity.Department;
import contact.entity.Store;

@Repository
public class StoreDao implements Dao<Store, String> {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Store entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	public List<Store> read() {

		return sessionFactory.getCurrentSession().createQuery("from store").list();
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

	public Query<Store> getStoreFromId(Integer id) {
		// String sql = "select * from store where id=?";
		return sessionFactory.getCurrentSession().createQuery("select * from store where id=?");
	}

	@Override
	public Collection getDepartmentsForStore(Store store) {
		List departments = new ArrayList<Department>();
		Integer storeId = store.getId();
		Query query = sessionFactory.getCurrentSession().createQuery("from department where store_idstore = :idstore")
				.setInteger("idstore", storeId);
		return departments = query.list();

	}

}
