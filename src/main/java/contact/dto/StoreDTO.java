package contact.dto;

import java.util.List;

import contact.entity.Department;

/**
 * Класс используется для передачи данных.
 * 
 * @author todosuk
 *
 */
public class StoreDTO {
	private Integer id;
	private String city;
	private List<?> depList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<?> getDepList() {
		return depList;
	}

	public void setDepList(List<?> depList) {
		this.depList = depList;
	}

}
