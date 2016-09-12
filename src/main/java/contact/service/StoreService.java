package contact.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import contact.entity.Store;
@Component
public interface StoreService<Store, Id extends Serializable> {

	public void create(Store entity);

	public List<Store> read();

	public void update(Store entity);

	public void delete(Integer id);

	public Collection getDepartmentsForStore(Integer storeId);

}
