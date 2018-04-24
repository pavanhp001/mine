package com.pavan.O2O;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {


	private static final long serialVersionUID = 1L;
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
	private int idemployee;
	private String firstname;
	private String lastname;
	private String email;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "iddesk")
	private Desk desk;

	public int getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

}