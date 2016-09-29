package contact.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import contact.entity.Department;
import contact.entity.Store;

@Component
public interface StoreDao<Store, id extends Serializable> {

	public void create(Store entity) throws DaoException;

	public List<Store> read() throws DaoException;

	public void update(Store entity) throws DaoException;

	public void delete(Integer id) throws DaoException;

	public List<Department> getDepartmentsForStore(Integer storeId) throws DaoException;

}
