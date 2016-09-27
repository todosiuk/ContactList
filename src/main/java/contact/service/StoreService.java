package contact.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import contact.entity.Department;
import contact.entity.Store;

/**
 * Интерфейс для сервис-слоя класса Person.
 * @author todosuk
 *
 * @param <Store>
 * @param <Id>
 */
@Component
public interface StoreService<Store, Id extends Serializable> {

	public void create(Store entity);

	public List<Store> read();

	public void update(Store entity);

	public void delete(Integer id);

	public List<Department> getDepartmentsForStore(Integer storeId);

}
