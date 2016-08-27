package contact.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "store")
@Component
public class Store implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idstore")
	private Integer id;

	@Column(name = "city")
	private String city;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "store")
	private List<Department> depList = new ArrayList<Department>();

	public Store() {
	}

	public Store(String city) {
		super();
		this.city = city;
	}

	public Store(String city, int id) {
		super();
		this.city = city;
		this.id = id;
	}

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
