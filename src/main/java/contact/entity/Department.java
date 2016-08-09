package contact.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "department")
@Component
public class Department {

	@Id
	@Column(name = "iddepartment")
	@GeneratedValue
	private Integer id;

	@Column(name = "nameDepartment")
	private Integer nameDepartment;

	@Column(name = "email")
	private String email;

	@Column(name = "post")
	private String post;

	@Column(name = "phone")
	private String phone;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "store_idstore")
	private Store store;
	
	public Department(){
	}
	
	public Department(Integer name, Store store){
		this.nameDepartment = name;
		this.store = store;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Integer getNameDepartment() {
		return nameDepartment;
	}

	public void setNameDepartment(Integer nameDepartment) {
		this.nameDepartment = nameDepartment;
	}

	@Override
	public String toString() {
		return "Department " + this.id + " , " + this.phone + " , " + this.post + " , " + this.store;
	}

}
