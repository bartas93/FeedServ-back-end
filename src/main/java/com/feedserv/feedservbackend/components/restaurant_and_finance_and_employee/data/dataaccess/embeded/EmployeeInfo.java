package com.feedserv.feedservbackend.components.restaurant_and_finance_and_employee.data.dataaccess.embeded;

import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.feedserv.feedservbackend.components.order_and_customer_and_partner.data.dataaccess.entity.AddressEntity;

@Embeddable
public class EmployeeInfo {

	private LocalDate birthDate;
	private String father_first_name;
	private String father_last_name;
	private String mother_first_name;
	private String mother_last_name;
	private String PESEL;
	private String id_of_personal_document;

	@ManyToOne
	@JoinColumn(name = "address_id")
	private AddressEntity addressEntity;

	public EmployeeInfo() {
	}

	public EmployeeInfo(LocalDate birthDate, String father_first_name, String father_last_name,
			String mother_first_name, String mother_last_name, String pESEL, String id_of_personal_document,
			AddressEntity addressEntity) {
		super();
		this.birthDate = birthDate;
		this.father_first_name = father_first_name;
		this.father_last_name = father_last_name;
		this.mother_first_name = mother_first_name;
		this.mother_last_name = mother_last_name;
		PESEL = pESEL;
		this.id_of_personal_document = id_of_personal_document;
		this.addressEntity = addressEntity;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getFather_first_name() {
		return father_first_name;
	}

	public void setFather_first_name(String father_first_name) {
		this.father_first_name = father_first_name;
	}

	public String getFather_last_name() {
		return father_last_name;
	}

	public void setFather_last_name(String father_last_name) {
		this.father_last_name = father_last_name;
	}

	public String getMother_first_name() {
		return mother_first_name;
	}

	public void setMother_first_name(String mother_first_name) {
		this.mother_first_name = mother_first_name;
	}

	public String getMother_last_name() {
		return mother_last_name;
	}

	public void setMother_last_name(String mother_last_name) {
		this.mother_last_name = mother_last_name;
	}

	public String getPESEL() {
		return PESEL;
	}

	public void setPESEL(String pESEL) {
		PESEL = pESEL;
	}

	public String getId_of_personal_document() {
		return id_of_personal_document;
	}

	public void setId_of_personal_document(String id_of_personal_document) {
		this.id_of_personal_document = id_of_personal_document;
	}

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}

}
