package contact.service;

import java.io.Serializable;
import java.util.List;

public interface DepartmentService <T, Id extends Serializable> {

	public void create(Integer id, T entity);

	public List<T> read();

	public void update(T entity);

	public void delete(Integer id);
	

}
