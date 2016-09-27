package contact.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "department")
@Component
public class Department implements Serializable{

	/**
	 * Класс представляет сущность "Департамент"
	 * Содержит поля id, имя департамента (числовое значение от 10 до 100 (10,20,30 и тд), e-mail, должность сотрудника и телефон.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "iddepartment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private Integer nameDepartment;

	@Column(name = "email")
	private String email;

	@Column(name = "post")
	private String post;

	@Column(name = "phone")
	private String phone;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "store_idstore")
	private Store store;
	
	public Department(){
	}
	
	public Department(Integer nameDepartment, String email, String post, String phone, Store store) {
		super();
		this.nameDepartment = nameDepartment;
		this.email = email;
		this.post = post;
		this.phone = phone;
		this.store = store;
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
