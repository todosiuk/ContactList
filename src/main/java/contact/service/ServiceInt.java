package contact.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import contact.entity.Store;
@Component
public interface ServiceInt<T, Id extends Serializable> {

	public void create(T entity, Integer id);

	public List<T> read();

	public void update(T entity);

	public void delete(Integer id);

	public Collection getDepartmentsForStore(Integer storeId);

}
