package contact.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface DepartmentDao<T, Id extends Serializable> {

	public void create(Integer id, T entity) throws DaoException;

	public List<T> read() throws DaoException;

	public void update(T entity) throws DaoException;

	public void delete(Integer id) throws DaoException;
}
