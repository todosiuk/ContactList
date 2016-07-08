package contact.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "store") 
public class Store {

	@Id 
	@Column(name = "id") 
	@GeneratedValue 
	private Integer id;

	@Column(name = "city")
	private String city;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "store")
	private List<Department> depList;

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

	public List<Department> getDepList() {
		return depList;
	}

	public void setDepList(List<Department> depList) {
		this.depList = depList;
	}

	@Override
	public String toString() {
		return "Store " + this.id + " , " + this.city + " , " + this.depList;
	}

}
