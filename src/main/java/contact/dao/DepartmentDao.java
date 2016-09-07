package contact.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface DepartmentDao<T, Id extends Serializable> {

	public void create(Integer id, T entity);

	public List<T> read();

	public void update(T entity);

	public void delete(Integer id);
}
