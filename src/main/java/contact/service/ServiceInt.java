package contact.service;

import java.io.Serializable;
import java.util.List;

public interface ServiceInt<T, Id extends Serializable> {

	public void create(T entity);

	public List<T> read();

	public void update(T entity);

	public void delete(Integer id);
}
