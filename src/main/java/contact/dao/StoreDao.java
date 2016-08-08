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

	public void create(Store entity) {
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

	public Query<Store> getStoreFromId(Integer id) {
		// String sql = "select * from store where id=?";
		return sessionFactory.getCurrentSession().createQuery("select * from Store where id=?");
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
