package contact.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import contact.entity.Store;

public interface ServiceInt<T, Id extends Serializable> {

	public void create(T entity);

	public List<T> read();

	public void update(T entity);

	public void delete(Integer id);

	public Collection getDepartmentsForStore(Store store);

}
