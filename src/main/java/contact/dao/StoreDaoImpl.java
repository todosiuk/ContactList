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
public class StoreDaoImpl implements StoreDao<Store, String> {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// Создание нового магазина
	public void create(Store entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	// Получение всех магазинов
	public List<Store> read() {
		return sessionFactory.getCurrentSession().createQuery("from Store").getResultList();
	}

	// Обновление конкретного магазина
	public void update(Store entity) {
		sessionFactory.getCurrentSession().update(entity);

	}

	// Удаление магазина
	public void delete(Integer id) {
		Store store = this.getStoreFromId(id);// или так (Store)
												// sessionFactory.getCurrentSession().load(Store.class,
												// id);
		if (null != store) {
			sessionFactory.getCurrentSession().delete(store);
		}

	}

	// Получение магазина по его id
	public Store getStoreFromId(Integer id) {
		Store store = (Store) sessionFactory.getCurrentSession().createQuery("from Store s where s.id=:id")
				.setParameter("id", id).getSingleResult();
		return store;
	}

	// Получение департаментов конкретного магазина
	@Override
	public Collection getDepartmentsForStore(Integer idstore) {
		Store store = sessionFactory.getCurrentSession().load(Store.class, idstore);
		List<Department> departments = new ArrayList<Department>();
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Department d where d.store_idstore = :idstore").setParameter("idstore", idstore);
		return departments = query.getResultList();

	}

}
