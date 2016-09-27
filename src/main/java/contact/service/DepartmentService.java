package contact.service;

import java.io.Serializable;
import java.util.List;
/**
 * Интерфейс для сервис-слоя класса department. 
 * @author todosuk
 *
 * @param <T>
 * @param <Id>
 */
public interface DepartmentService <T, Id extends Serializable> {

	public void create(Integer id, T entity);

	public List<T> read(Integer integer);

	public void update(T entity);

	public void delete(Integer id);
	

}
