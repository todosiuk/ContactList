package contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import contact.dao.StoreDao;
import contact.dao.DepartmentDaoImpl;
import contact.dao.DepartmentDao;
import contact.entity.Department;

/**
 * Сервис слой для класса Department
 * 
 * @author todosuk
 *
 */
@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService<Department, String> {

	@Autowired
	private DepartmentDao<Department, ?> departmentDao;

	/**
	 * Метод создает новый департамент
	 */
	public void create(Integer storeId, Department entity) {
		departmentDao.create(storeId, entity);
	}

	/**
	 * Метод возвращает список всех департаментов маркета
	 */
	public List<Department> read(Integer id) {
		return departmentDao.read();
	}

	/**
	 * Метод обновляет конкретный департамент маркета.
	 */
	public void update(Department entity) {
		departmentDao.update(entity);

	}

	/**
	 * Метод удаляет конкретный департамент.
	 * 
	 */
	public void delete(Integer id) {
		departmentDao.delete(id);

	}

	/**
	 * Метод возвращает конкретный департамент по его Id.
	 * 
	 * @param id
	 * @return
	 */
	public Department getDepartmentFromId(Integer id) {
		return (Department) ((DepartmentDaoImpl) departmentDao).getDepartmentFromId(id);
	}

	public StoreDao<Department, ?> getDepartmentDao() {
		return (StoreDao<Department, ?>) departmentDao;
	}

	public void setDepartmentDao(DepartmentDaoImpl departmentDao) {
		this.departmentDao = departmentDao;
	}

}
