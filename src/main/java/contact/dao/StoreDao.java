package contact.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
